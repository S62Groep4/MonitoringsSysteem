package domain;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Model
public class SystemFeature {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String featureName;

    private String featureUrlExtention;

    // Set default polling interval to 5 minutes
    private int pollingInterval = 5;

    @OneToMany
    private List<HttpGetRequest> statusHistory = new ArrayList<>();

    @ElementCollection
    private List<String> acceptedResponseMessages = new ArrayList<>();

    @ElementCollection
    private List<Integer> acceptedResponseCodes = new ArrayList<>();

//    @ManyToOne
//    private SystemModule systemModule;

    public SystemFeature() {
    }

    public SystemFeature(String featureName, String featureUrlExtention) {
        this.featureName = featureName;
        this.featureUrlExtention = featureUrlExtention;
        this.acceptedResponseMessages = acceptedResponseMessages;
    }


    public SystemFeature(String featureName, String featureUrlExtention, List<String> acceptedResponseMessages, List<Integer> acceptedResponseCodes) {
        this.featureName = featureName;
        this.featureUrlExtention = featureUrlExtention;
        this.acceptedResponseMessages = acceptedResponseMessages;
        this.acceptedResponseCodes = acceptedResponseCodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureUrlExtention() {
        return featureUrlExtention;
    }

    public void setFeatureUrlExtention(String featureUrlExtention) {
        this.featureUrlExtention = featureUrlExtention;
    }

    public List<String> getAcceptedResponseMessages() {
        return acceptedResponseMessages;
    }

    public void setAcceptedResponseMessages(List<String> acceptedResponseMessages) {
        this.acceptedResponseMessages = acceptedResponseMessages;
    }

    public List<Integer> getAcceptedResponseCodes() {
        return acceptedResponseCodes;
    }

    public void setAcceptedResponseCodes(List<Integer> acceptedResponseCodes) {
        this.acceptedResponseCodes = acceptedResponseCodes;
    }

    public int getPollingInterval() {
        return pollingInterval;
    }

    public void setPollingInterval(int pollingInterval) {
        this.pollingInterval = pollingInterval;
    }

    public List<HttpGetRequest> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<HttpGetRequest> statusHistory) {
        this.statusHistory = statusHistory;
    }
}
