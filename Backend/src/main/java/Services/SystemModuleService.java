package Services;

import dao.JPA;
import dao.ServerRepository;
import domain.SystemModule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@Stateless
public class SystemModuleService {

    @Inject
    @JPA
    ServerRepository serverRepository;


    public void createSystemModule(SystemModule systemModule){
        serverRepository.createSystem(systemModule);
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
}
