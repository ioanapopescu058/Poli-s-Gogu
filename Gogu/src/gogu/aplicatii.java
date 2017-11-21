/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class aplicatii {
    
    static boolean ntpd = false;
    static boolean cmd = false;
    static boolean wmp = false;
    static boolean cal = false;
    static boolean pnt = false;
    static Process pr_ntpd = null;
    static Process pr_player = null;
    static Process pr_paint = null;
   
    
    public static void notepad(){
        if(!ntpd){
            try {
                //deschide
                ntpd = true;
                pr_ntpd = Runtime.getRuntime().exec("notepad");
                
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            //inchide
                pr_ntpd.destroyForcibly();
            ntpd = false;
        }
    }
    public static void cmd(){
        if(!cmd){
            //deschide
            try {
                Process pr = Runtime.getRuntime().exec("cmd /c start cmd.exe");
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmd = true;
        }
        else{
            //inchide
            try {
                Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmd = false;
        }
    }
    public static void player(){
        if(!wmp){
            //deschide
            try {
                pr_player = Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe\"");
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
            wmp = true;
        }
        else{
            //inchide
            pr_player.destroyForcibly();
            wmp = false;
        }
    }
    public static void calculator(){
        if(!cal){
            try {
                //deschide
                Runtime.getRuntime().exec("calc");
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
            cal = true;
            
        }
        else{
            try {
                //inchide
                Runtime.getRuntime().exec("taskkill /F /IM Calculator.exe");
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
            cal = false;
        }
    }
    public static void paint(){
        if(!pnt){
            //deschide
            try {
                pr_paint = Runtime.getRuntime().exec("\"C:\\Windows\\System32\\mspaint.exe\"");
            } catch (IOException ex) {
                Logger.getLogger(aplicatii.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnt = true;
        }
        else{
            //inchide
            pr_paint.destroyForcibly();
            pnt = false;
        }
    }
}
