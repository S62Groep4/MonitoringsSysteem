package domain;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.util.Date;

@Model
@Entity
public class HttpGetRequest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    private Status responseStatus;

    private int responseNumber;

    @ManyToOne
    private SystemFeature systemFeature;

    private String reponseMessage;

    @Basic(optional = false)
    @Column(name="DATE_CREATED", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.util.Date requestSendTime;

    @Column(name="DATE_RESPONSE")
    private java.util.Date receivedSendTime;

    public HttpGetRequest() {
        this.receivedSendTime = new Date();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Status getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Status responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(int responseNumber) {
        this.responseNumber = responseNumber;
    }

    public String getReponseMessage() {
        return reponseMessage;
    }

    public void setReponseMessage(String reponseMessage) {
        this.reponseMessage = reponseMessage;
    }

    public Date getRequestSendTime() {
        return requestSendTime;
    }

    public void setRequestSendTime(Date requestTime) {
        this.requestSendTime = requestTime;
    }

    public Date getReceivedSendTime() {
        return receivedSendTime;
    }

    public void setReceivedSendTime(Date receivedTime) {
        this.receivedSendTime = receivedTime;
    }

    public SystemFeature getSystemFeature() {
        return systemFeature;
    }

    public void setSystemFeature(SystemFeature systemFeature) {
        this.systemFeature = systemFeature;
    }
}
