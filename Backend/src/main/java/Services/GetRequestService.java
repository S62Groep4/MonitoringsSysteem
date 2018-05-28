package Services;

import dao.JPA;
import dao.ServerRepository;
import domain.HttpGetRequest;
import domain.SystemFeature;
import domain.SystemModule;
import workers.RequestWorker;

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
        sendRequests();

    }

    private void sendRequests(){
        for (SystemModule module: serverRepository.getSystems()) {
            executor.scheduleAtFixedRate( new RequestWorker(module, this), 0, 1, TimeUnit.MINUTES);
        }
    }


    public HttpGetRequest createGetRequest(HttpGetRequest httpGetRequest){
       return serverRepository.createGetRequest(httpGetRequest);
    }

    public HttpGetRequest updateGetRequest(HttpGetRequest httpGetRequest){
       return serverRepository.updateGetRequest(httpGetRequest);
    }

    public SystemModule getServer(SystemModule serverModule){
        return serverRepository.getSystem(serverModule.getId());
    }

    public SystemModule updateServer(SystemModule serverModule){
        return serverRepository.updateSystem(serverModule);
    }

    public SystemFeature updateFeature(SystemFeature systemFeature){
        return serverRepository.updateFeature(systemFeature);
    }

    public void restartScheduledExecutor(){
        executor.shutdownNow();
        executor = Executors.newScheduledThreadPool(10);

        sendRequests();
    }


}
