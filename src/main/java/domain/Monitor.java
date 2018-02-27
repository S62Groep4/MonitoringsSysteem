/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author M
 */
public class Monitor {
    
    @Inject
    List<Country> country;
    
    public Monitor(){
        
    }
}
