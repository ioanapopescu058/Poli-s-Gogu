/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.util.*;

/**
 *
 * @author Adrian
 */
public class InterpretCommand {
    
    public static void Resolve(String command){
        ArrayList<String> twitchURL = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(command);
        String argument = new String();
        String cmd = st.nextToken();
        if(cmd.equalsIgnoreCase("time")){
            if(st.hasMoreTokens()){
                //timpul in oras strain
                argument = st.nextToken();
                sistem.time(argument);
            }
            else{
                //timpul local
                sistem.time("gol");
            }
        } 
        else if(cmd.equalsIgnoreCase("date")){
            if(!st.hasMoreTokens()){
                //data locala
                sistem.date();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("ipconfig")){
            if(!st.hasMoreTokens()){
                //informatii retea
                sistem.ipconfig();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("del")){
            if(st.hasMoreTokens()){
                //sterge fisier
                argument = st.nextToken();
                sistem.del(argument);
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("mkdir")){
            if(st.hasMoreTokens()){
                //creeaza folder
                argument = st.nextToken();
                sistem.mkdir(argument);
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        
        else if(cmd.equalsIgnoreCase("shutdown")){
            if(!st.hasMoreTokens()){
                //inchide calculator
                sistem.shutdown();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("notepad")){
            if(!st.hasMoreTokens()){
                //deschide notepad(Aplicatia)
                aplicatii.notepad();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("cmd")){
            if(!st.hasMoreTokens()){
                //deschide cmd
                aplicatii.cmd();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("player")){
            if(!st.hasMoreTokens()){
                //deschide windows media player
                aplicatii.player();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("calculator")){
            if(!st.hasMoreTokens()){
                //deschide calculator
                aplicatii.calculator();
            }           
        }
        else if(cmd.equalsIgnoreCase("paint")){
            if(!st.hasMoreTokens()){
                //deschide paint
                aplicatii.paint();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("mail")){
            if(!st.hasMoreTokens()){
                //deschide mail
                web.mail();
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("twitch")){
            //deschide twitch la un joc
            while(st.hasMoreTokens()){
                twitchURL.add(st.nextToken());
            }
            web.twitch(twitchURL);
        }
        else if(cmd.equalsIgnoreCase("weather")){
            if(st.hasMoreTokens()){
                //zice vremea
                argument = st.nextToken();
                web.weather(argument);
            }else{
                Gogu.addToHistory("Wrong command!");
            }            
        }
        else if(cmd.equalsIgnoreCase("currency")){
            if(st.hasMoreTokens()){
                //iti zice cati bani n-ai
                argument = st.nextToken();
                web.currency(argument);
            }else{
                Gogu.addToHistory("Wrong command!");
            }           
        }
    }
}
