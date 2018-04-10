package dao;


import domain.HttpGetRequest;
import domain.SystemFeature;
import domain.SystemModule;
import org.eclipse.persistence.annotations.ReturnInsert;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@JPA
public class ServerRepositoryImp implements ServerRepository {

    @PersistenceContext(unitName = "monitorPU")
    EntityManager em;

    @Override
    public SystemModule getSystem(long id) {

        SystemModule returnAccount = em.find(SystemModule.class, id);
        return returnAccount;


    }

    @Override
    public List<SystemModule> getSystems() {
        return em.createQuery("Select a from SystemModule a ", SystemModule.class)
                .getResultList();
    }



    @Override
    @ReturnInsert
    public SystemModule createSystem(SystemModule systemModule) {
        em.persist(systemModule);
        em.flush();
        return systemModule;
    }

    @Override
    public SystemModule updateSystem(SystemModule systemModule) {
        SystemModule systemModuleExists = em.find(SystemModule.class, systemModule.getId());
        if (systemModuleExists == null) {
            return null;
        }
        em.merge(systemModule);
        em.flush();
        em.refresh(systemModuleExists);

        return systemModuleExists;
    }

    @Override
    public SystemFeature getFeature(int id) {

        return em.find(SystemFeature.class, id);


    }

    @Override
    public List<SystemFeature> getFeatures() {
        return em.createQuery("Select a from SystemFeature a ", SystemFeature.class)
                .getResultList();
    }



    @Override
    @ReturnInsert
    public SystemFeature createFeature(SystemFeature systemFeature) {
        em.persist(systemFeature);
        em.flush();
        return systemFeature;
    }

    @Override
    public SystemFeature updateFeature(SystemFeature systemFeature) {
        SystemFeature systemFeatureExists = em.find(SystemFeature.class, systemFeature.getId());
        if (systemFeature == null) {
            return null;
        }
        em.merge(systemFeature);
        em.flush();
        em.refresh(systemFeatureExists);

        return systemFeatureExists;
    }


    @Override
    @ReturnInsert
    public HttpGetRequest createGetRequest(HttpGetRequest gerRequest) {
        em.persist(gerRequest);
        em.flush();

        return gerRequest;
    }

    @Override
    public HttpGetRequest updateGetRequest(HttpGetRequest httpGetRequest) {
        HttpGetRequest httpGetRequestExists = em.find(HttpGetRequest.class, httpGetRequest.getId());
        if (httpGetRequest == null) {
            return null;
        }
        em.merge(httpGetRequest);
        em.flush();
        em.refresh(httpGetRequestExists);

        return httpGetRequestExists;
    }



}
