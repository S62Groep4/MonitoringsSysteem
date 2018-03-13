/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proftaak.com.monitoringsystem;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sjoerd
 */
public class ServerController {
    
    
    private static String brackgroundError = "bg-danger";

    private static String brackgroundwarning = "bg-warning";
    private static String brackgroundSucces = "bg-success";
    
    static public List<Server> GetServers(List<Server> servers){
        for (Server server : servers) {
        URL url;
            try {
                url = new URL(server.getURL());
                url.toExternalForm();
                 HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");   
                server.setBackground(brackgroundSucces);
                server.setError("RUNNING");

            } catch (MalformedURLException ex) {
                server.setError("Invalid url");
                server.setBackground(brackgroundError);
            } catch (IOException ex) {
                server.setError(ex.getMessage());
                server.setBackground(brackgroundError);            
            }            
        }
        
        return servers;
    }
}
