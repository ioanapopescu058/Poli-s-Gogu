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
            }           
        }
        else if(cmd.equalsIgnoreCase("ipconfig")){
            if(!st.hasMoreTokens()){
                //informatii retea
                sistem.ipconfig();
            }           
        }
        else if(cmd.equalsIgnoreCase("del")){
            if(st.hasMoreTokens()){
                //sterge fisier
                argument = st.nextToken();
                sistem.del(argument);
            }           
        }
        else if(cmd.equalsIgnoreCase("mkdir")){
            if(st.hasMoreTokens()){
                //creeaza folder
                argument = st.nextToken();
                sistem.mkdir(argument);
            }           
        }
        
        else if(cmd.equalsIgnoreCase("shutdown")){
            if(!st.hasMoreTokens()){
                //inchide calculator
                sistem.shutdown();
            }           
        }
        else if(cmd.equalsIgnoreCase("calculator")){
            if(!st.hasMoreTokens()){
                //deschide calculator(Aplicatia)
                aplicatii.calculator();
            }           
        }
        else if(cmd.equalsIgnoreCase("cmd")){
            if(!st.hasMoreTokens()){
                //deschide cmd
                aplicatii.cmd();
            }           
        }
        else if(cmd.equalsIgnoreCase("player")){
            if(!st.hasMoreTokens()){
                //deschide windows media player
                aplicatii.player();
            }           
        }
        else if(cmd.equalsIgnoreCase("calendar")){
            if(!st.hasMoreTokens()){
                //deschide calendar
                aplicatii.calendar();
            }           
        }
        else if(cmd.equalsIgnoreCase("paint")){
            if(!st.hasMoreTokens()){
                //deschide paint
                aplicatii.paint();
            }           
        }
        else if(cmd.equalsIgnoreCase("mail")){
            if(!st.hasMoreTokens()){
                //deschide mail
                web.mail();
            }           
        }
        else if(cmd.equalsIgnoreCase("twitch")){
            if(!st.hasMoreTokens()){
                //deschide twitch la un joc
                web.twitch();
            }           
        }
        else if(cmd.equalsIgnoreCase("weathr")){
            if(st.hasMoreTokens()){
                //zice vremea
                argument = st.nextToken();
                web.weather(argument);
            }           
        }
        else if(cmd.equalsIgnoreCase("currency")){
            if(st.hasMoreTokens()){
                //iti zice cati bani n-ai
                argument = st.nextToken();
                web.currency(argument);
            }           
        }
    }
}
