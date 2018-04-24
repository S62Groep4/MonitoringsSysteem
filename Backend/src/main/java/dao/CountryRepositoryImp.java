package dao;


import domain.Country;
import domain.SystemModule;
import org.eclipse.persistence.annotations.ReturnInsert;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@JPA
public class CountryRepositoryImp implements CountryRepository {

    @PersistenceContext(unitName = "monitorPU")
    EntityManager em;

    @Override
    public Country getCountry(Long id) {

        Country returnAccount = em.find(Country.class, id);
        return returnAccount;


    }

    @Override
    public Country getCountry(String name) {

        Country returnAccount = em.createQuery("Select a from Country a where a.name = :countryname", Country.class)
                .setParameter("countryname",name )
                .getSingleResult();
        return returnAccount;


    }

    @Override
    public List<Country> getCountries() {
        return em.createQuery("Select a from Country a ", Country.class)
                .getResultList();
    }



    @Override
    @ReturnInsert
    public Country createCountry(Country country) {
        em.persist(country);
        return country;
    }

    @Override
    public Country updateCountry(Country country) {
        Country countryExists= em.find(Country.class, country.getId());
        if (countryExists == null) {
            return null;
        }
        em.merge(country);
        em.flush();
        em.refresh(country);

        return country;
    }
}
