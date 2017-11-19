/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

/**
 *
 * @author Adrian
 */
public class aplicatii {
    
    static boolean clc = false;
    static boolean cmd = false;
    static boolean wmp = false;
    static boolean cal = false;
    static boolean pnt = false;
    
    public static void calculator(){
        if(!clc){
            //deschide
            clc = true;
        }
        else{
            //inchide
            clc = false;
        }
    }
    public static void cmd(){
        if(!cmd){
            //deschide
            cmd = true;
        }
        else{
            //inchide
            cmd = false;
        }
    }
    public static void player(){
        if(!wmp){
            //deschide
            wmp = true;
        }
        else{
            //inchide
            wmp = false;
        }
    }
    public static void calendar(){
        if(!cal){
            //deschide
            cal = true;
        }
        else{
            //inchide
            cal = false;
        }
    }
    public static void paint(){
        if(!pnt){
            //deschide
            pnt = true;
        }
        else{
            //inchide
            pnt = false;
        }
    }
}
