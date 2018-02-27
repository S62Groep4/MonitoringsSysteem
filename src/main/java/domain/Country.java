/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author M
 */
@Entity
@Model
public class Country implements Serializable{
    @Id
    private Long id = null;
    @Inject
    private Monitor monitor;
    private String name = null;
    private Boolean isExternal = null;

    public Country() {
    }
    
    public Country(String name, Boolean isExternal){
        this.name = name;
        this.isExternal = isExternal;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setIsExternal(Boolean isExternal){
        this.isExternal = isExternal;
    }
    
    public Boolean getIsExternal(){
        return this.isExternal;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
}
