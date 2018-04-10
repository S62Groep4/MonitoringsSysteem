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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Model
public class Country implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name = null;
    private Boolean isExternal ;

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

    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
}
