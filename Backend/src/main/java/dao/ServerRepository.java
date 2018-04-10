package dao;

import domain.HttpGetRequest;
import domain.SystemFeature;
import domain.SystemModule;

import java.util.List;

/**
 * Created by Sjoerd on 26-2-2018.
 */
public interface ServerRepository {
    SystemModule getSystem(long id);

    List<SystemModule> getSystems();

    SystemModule createSystem(SystemModule systemModule);

    SystemModule updateSystem(SystemModule systemModule);


    SystemFeature getFeature(int id);

    List<SystemFeature> getFeatures();

    SystemFeature createFeature(SystemFeature systemFeature);

    SystemFeature updateFeature(SystemFeature systemFeature);

    HttpGetRequest createGetRequest(HttpGetRequest httpGetRequest);

    HttpGetRequest updateGetRequest(HttpGetRequest httpGetRequest);


}
