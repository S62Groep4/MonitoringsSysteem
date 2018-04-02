package Services;

import dao.JPA;
import dao.ServerRepository;
import dao.ServerRepositoryImp;
import domain.GetRequest;
import domain.SystemModule;
import workers.RequestThread;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.concurrent.*;

@Singleton
@Startup
public class GetRequestService {

    @Inject
    @JPA
    ServerRepository serverRepository;
    ScheduledExecutorService executor;



    @PostConstruct
    public void serviceInit(){
        executor = Executors.newScheduledThreadPool(10);
        triggerRequests();

    }

    private void triggerRequests(){
        for (SystemModule module: serverRepository.getSystems()) {

            executor.scheduleAtFixedRate( new RequestThread(module, this), 0, 1, TimeUnit.MINUTES);

        }

    }


    public GetRequest createGetRequest(GetRequest getRequest){
       return serverRepository.createGetRequest(getRequest);
    }

    public GetRequest updateGetRequest(GetRequest getRequest){
       return serverRepository.updateGetRequest(getRequest);
    }

    public SystemModule updateServer(SystemModule serverModule){
        return serverRepository.updateSystem(serverModule);

    }
}
