/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.io.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class sistem {
    
    //Data pentru fiecare timezone diferit
    public static void time(String param){

        if(param.equalsIgnoreCase("Berlin")){
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+1");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            String time = c.get(java.util.Calendar.HOUR_OF_DAY)+":"+
            c.get(java.util.Calendar.MINUTE)+":"+c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
        }          
        else if(param.equalsIgnoreCase("Tokyo")){
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+9");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            String time = c.get(java.util.Calendar.HOUR_OF_DAY)+":"+
            c.get(java.util.Calendar.MINUTE)+":"+c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
        }                
        else if(param.equalsIgnoreCase("Boston")){
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT-5");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            String time = c.get(java.util.Calendar.HOUR_OF_DAY)+":"+
            c.get(java.util.Calendar.MINUTE)+":"+c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
        }                   
        else if(param.equalsIgnoreCase("Bogota")){
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT-5");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            String time = c.get(java.util.Calendar.HOUR_OF_DAY)+":"+
            c.get(java.util.Calendar.MINUTE)+":"+c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
        }
        else if(param.equals("gol")){
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+2");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            String time = c.get(java.util.Calendar.HOUR_OF_DAY)+":"+
            c.get(java.util.Calendar.MINUTE)+":"+c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
        }
    }
    
    //Data locala
    public static void date(){
        String date = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        Gogu.addToHistory(date);
    }
    
    //Ip calculatorului
    public static void ipconfig(){
        String ip;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
            Gogu.addToHistory(ip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(sistem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Sterge un fisier sau director dat dupa calea lui absoluta
    public static void del(String path){
        try {
            Path p = Paths.get(path);
            Files.deleteIfExists(p);
        } catch (IOException ex) {
            Logger.getLogger(sistem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Creeaza un director dat dupa calea lui absoluta
    public static void mkdir(String path){
        boolean success = (new File(path)).mkdirs();
        
        if(!success)
            Gogu.addToHistory("Eroare");
        else
            Gogu.addToHistory("Director creat cu success");
    }
    
    //Opreste programul si Inchide calculatorul
    public static void shutdown(){
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("shutdown -s -t 0");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(sistem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
