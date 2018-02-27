/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author M
 */
public class System {
    private String componentName = null;
    private String versionNumber = null;
    private List<String> features = null;
    private String url = null;
    
    public System(String componentName, String versionNumber, List<String> features, String url){
        this.componentName = componentName;
        this.versionNumber = versionNumber;
        this.features = features;
        this.url = url;
    }
    
    public void setComponentName(String componentName){
        this.componentName = componentName;
    }
    
    public String getComponentName(){
        return this.componentName;
    }
    
    public void setVersionNumber(String versionNumber){
        this.versionNumber = versionNumber;
    }
    
    public String getVersionNumber(){
        return this.versionNumber;
    }
    
    public void setFeatures(List<String> features){
        this.features = features;
    }
    
    public List<String> getFeatures(){
        return this.features;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return this.url;
    }
}
