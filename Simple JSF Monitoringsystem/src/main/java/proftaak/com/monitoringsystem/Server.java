/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proftaak.com.monitoringsystem;

import javax.persistence.Entity;

/**
 *
 * @author Sjoerd
 */

public class Server {
    private String URL;
    private int status;
    private String error;
    private String background;

    public String getURL() {
        return URL;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }


    public Server(String URL) {
        this.URL = URL;
    }

    
    
    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    
}
