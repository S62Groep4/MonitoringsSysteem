package Services;

import dao.JPA;
import dao.ServerRepository;
import domain.SystemFeature;
import domain.SystemModule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class SystemModuleService {

    @Inject
    @JPA
    ServerRepository serverRepository;

    @Inject
    GetRequestService getRequestService;


    public void createSystemModule(SystemModule systemModule){
        serverRepository.createSystem(systemModule);
    }

    public SystemFeature getFeatureModule(int feature){
        return serverRepository.getFeature(feature);
    }

    public void updateSystemModule(SystemModule systemModule){
        serverRepository.updateSystem(systemModule);
    }

    public List<SystemModule> getAllSystemModules(){
        return serverRepository.getSystems();
    }

    public SystemModule getSystemModule(long id){
        return serverRepository.getSystem(id);
    }

    public void createSystemFeature(long systemId, SystemFeature systemFeature){
        SystemFeature feature = serverRepository.createFeature(systemFeature);
        SystemModule featureSystem = serverRepository.getSystem(systemId);
        featureSystem.getSystemFeatures().add(feature);
        serverRepository.updateSystem(featureSystem);
        getRequestService.restartScheduledExecutor();
    }

}
