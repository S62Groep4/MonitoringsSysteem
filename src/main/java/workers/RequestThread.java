package workers;

import Services.GetRequestService;
import dao.ServerRepository;
import domain.GetRequest;
import domain.Status;
import domain.SystemFeature;
import domain.SystemModule;
import sun.security.provider.certpath.OCSPResponse;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

@Asynchronous
public class RequestThread implements Runnable {

    @Inject
    GetRequestService service;

    private SystemModule systemModule;

    public RequestThread(SystemModule systemModule, GetRequestService requestService) {

        this.systemModule = systemModule;
        this.service = requestService;
    }

    public RequestThread() {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. = " + systemModule.getComponentName());
        for (SystemFeature feature: systemModule.getSystemFeatures()) {
            processCommand(feature);
        }
        System.out.println(Thread.currentThread().getName() + systemModule.getComponentName() + " ended.");
    }

    private void processCommand(SystemFeature feature) {
        GetRequest getRequest = new GetRequest();
        getRequest = service.createGetRequest(getRequest);
        systemModule.getStatusHistory().add(getRequest );
        service.updateServer(systemModule);

        try {
            URL url = new URL(systemModule.getUrl()+feature.getFeatureUrlExtention());
            url.toExternalForm();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String body = con.getResponseMessage();
            getRequest.setReceivedTime(new Date());
            getRequest.setReponseMessage(body);
            getRequest.setResponseNumber(con.getResponseCode());


            if(feature.getAcceptedResponseCodes().contains(con.getResponseCode()) || feature.getAcceptedResponseMessages().contains(getRequest.getReponseMessage())){
                getRequest.setResponseStatus(Status.ONLINE);
            }else{
                getRequest.setResponseStatus(Status.OFFLINE);
            }


        } catch (MalformedURLException ex) {
            getRequest.setResponseStatus(Status.ERROR);

        } catch (IOException ex) {

            getRequest.setResponseStatus(Status.ERROR);
        }
        service.updateServer(systemModule);
        service.updateGetRequest(getRequest);

    }


    @Override
    public String toString() {
        return this.systemModule.getComponentName();
    }
}