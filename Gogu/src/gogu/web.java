/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.css.StyleOrigin.USER_AGENT;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    
    public static void twitch(ArrayList<String> param){
        //https://www.twitch.tv/directory/game/World%20of%20Warcraft
        String url = "https://www.twitch.tv/directory";
        if(param.size() > 0){
            url += "/game/" + param.get(0);
            
            for(int i=1; i<param.size(); i++){
                url += "%20" + param.get(i);
            }
        }
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void weather(String param){
        
    }
    
    public static void currency(String param){
        //http://api.fixer.io/2016-05-20?base=EUR&symbols=RON
        String head = "http://api.fixer.io/2016-05-20?base=";
        String base = "&symbols=RON";
        String URL = head+""+param+""+base;
        URL obj;
        try {
            obj = new URL(URL);   
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if(responseCode == 200){           
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
                in.close();

                //Read JSON response and print
                JSONObject jsResponse = new JSONObject(response.toString());
                JSONObject exchangeValue = jsResponse.getJSONObject("rates");
                String value = exchangeValue.get("RON").toString();
                Gogu.addToHistory(param+" = "+value+" RON");
            }
            else{
                Gogu.addToHistory("Wrong currency!");
            }
        } catch (MalformedURLException ex) {
                Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
                Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
