package Services;

import dao.CountryRepository;
import dao.JPA;
import dao.ServerRepository;
import domain.Country;
import domain.SystemModule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CountryService {

    @Inject
    @JPA
    CountryRepository countryRepository;


    public Country createCountry(String name, boolean isExternal){
        countryRepository.createCountry(new Country(name, isExternal));
        return countryRepository.getCountry( name);
    }

    public List<Country> getCountries(){
        return countryRepository.getCountries();
    }

    public Country getCountry(Long id){
        return countryRepository.getCountry(id);

    }

}
