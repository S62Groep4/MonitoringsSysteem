/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.*;

/**
 *
 * @author M
 */
@Model
@Entity
public class SystemModule implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Country country;
    
    private String componentName = null;
    private String url = null;


    @OneToMany
//    @JoinTable
//            (
//                    name="system_features",
//                    joinColumns={ @JoinColumn(name="ID", referencedColumnName="ID") },
//                    inverseJoinColumns={ @JoinColumn(name="OBJECTB_ID", referencedColumnName="ID") })
    private List<SystemFeature> systemFeatures = new ArrayList<>();



    public SystemModule() {
    }




    public void setComponentName(String componentName){
        this.componentName = componentName;
    }
    
    public String getComponentName(){
        return this.componentName;
    }


    public void setUrl(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return this.url;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public List<SystemFeature> getSystemFeatures() {
        return systemFeatures;
    }

    public void setSystemFeatures(List<SystemFeature> systemFeatures) {
        this.systemFeatures = systemFeatures;
    }
}
