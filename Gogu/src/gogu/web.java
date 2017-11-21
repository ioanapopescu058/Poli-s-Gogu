/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class web {
    public static void mail(){
        try {
            Desktop.getDesktop().browse(new URI("https://mail.google.com/mail"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static void twitch(){
        try {
            Desktop.getDesktop().browse(new URI("https://www.twitch.tv/directory"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void weather(String param){
        
    }
    
    public static void currency(String param){
        
    }
}
