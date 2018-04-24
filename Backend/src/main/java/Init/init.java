package Init;

import dao.CountryRepository;
import dao.JPA;
import dao.ServerRepository;
import domain.Country;
import domain.SystemFeature;
import domain.SystemModule;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Startup
@Singleton
public class init {

    @Inject
    @JPA
    ServerRepository serverRepository;

    @Inject
    @JPA
    CountryRepository countryRepository;

    private SystemModule systemModule1 = null;
    private Country country1 = null;
    private SystemFeature feature1 = null;

    @PostConstruct
    public void init() {
        try {
            createCountries();
        }catch (Exception ex) {
            //Ignore init errors
        }
        try {
            createSystems();
        }catch (Exception ex) {
                //Ignore init errors
            }
            try{
            createSystemFeatures();}
        catch (Exception ex) {
            //Ignore init errors
        }
    }

    private void createCountries(){
        country1 = new Country("Duitsland", false);
        countryRepository.createCountry(country1);
    }

    private void createSystems() {
        systemModule1 = new SystemModule();
        systemModule1.setComponentName("Test component");
        systemModule1.setCountry(country1);
        systemModule1.setUrl("http://google.nl");
        systemModule1 = serverRepository.createSystem(systemModule1);
    }

    private void createSystemFeatures() {

        feature1 = new SystemFeature("Test feature", "/business");
        feature1.getAcceptedResponseCodes().add(200 );
        systemModule1.getSystemFeatures().add(feature1 );
        feature1 = serverRepository.createFeature(feature1);
        serverRepository.updateSystem(systemModule1);

    }
}


