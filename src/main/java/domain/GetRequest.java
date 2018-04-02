package domain;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.util.Date;

@Model
@Entity
public class GetRequest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    private Status responseStatus;

    private int responseNumber;

    private String reponseMessage;

    @Basic(optional = false)
    @Column(name="DATE_CREATED", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.util.Date requestTime;

    @Column(name="DATE_RESPONSE")
    private java.util.Date receivedTime;

    public GetRequest() {
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

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }
}
