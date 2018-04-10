package workers;

import Services.GetRequestService;
import domain.HttpGetRequest;
import domain.Status;
import domain.SystemFeature;
import domain.SystemModule;

import javax.ejb.Asynchronous;
import javax.inject.Inject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

@Asynchronous
public class RequestWorker implements Runnable {

    @Inject
    GetRequestService service;

    private SystemModule systemModule;

    public RequestWorker(SystemModule systemModule, GetRequestService requestService) {

        this.systemModule = systemModule;
        this.service = requestService;
    }

    public RequestWorker() {
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
        HttpGetRequest httpGetRequest = new HttpGetRequest();
        httpGetRequest.setSystemFeature(feature);
        httpGetRequest = service.createGetRequest(httpGetRequest);
        feature.getStatusHistory().add(httpGetRequest);
        service.updateServer(systemModule);

        try {
            URL url = new URL(systemModule.getUrl()+feature.getFeatureUrlExtention());
            url.toExternalForm();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String body = con.getResponseMessage();
            httpGetRequest.setReceivedSendTime(new Date());
            httpGetRequest.setReponseMessage(body);
            httpGetRequest.setResponseNumber(con.getResponseCode());


            if(feature.getAcceptedResponseCodes().contains(con.getResponseCode()) || feature.getAcceptedResponseMessages().contains(httpGetRequest.getReponseMessage())){
                httpGetRequest.setResponseStatus(Status.ONLINE);
            }else if (con.getResponseCode() >= 500 &&con.getResponseCode() <= 503){
                httpGetRequest.setResponseStatus(Status.ERROR);

            }else
            {
                httpGetRequest.setResponseStatus(Status.OFFLINE);
            }


        } catch (MalformedURLException ex) {
            httpGetRequest.setResponseStatus(Status.ERROR);

        } catch (IOException ex) {

            httpGetRequest.setResponseStatus(Status.ERROR);
        }
        service.updateServer(systemModule);
        service.updateGetRequest(httpGetRequest);

    }


    @Override
    public String toString() {
        return this.systemModule.getComponentName();
    }
}