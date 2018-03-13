/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proftaak.com.monitoringsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sjoerd
 */
@Named(value = "defaultBean")
@SessionScoped
public class DefaultBean implements Serializable{

    
    private List<Server> servers;

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
    
    /**
     * Creates a new instance of DefaultBean
     */
    public DefaultBean() {
        servers = new ArrayList<Server>();


    }
    
    public void AddServer(String serverurl){
        servers.add(new Server(serverurl));
        RefreshServers();
    }
    
    public void RefreshServers(){
        servers = ServerController.GetServers(servers);

    }
    
    public void removeServer(Server server) {
    try {
        servers.remove(server);
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
}
