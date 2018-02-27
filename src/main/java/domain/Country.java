/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author M
 */
public class Country {
    private String name = null;
    private Boolean isExternal = null;
    
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
}
