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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Adrian
 */
public class web {

    public static void mail() {
        try {
            Desktop.getDesktop().browse(new URI("https://mail.google.com/mail"));
            ArrayList<String> sounds = new ArrayList<String>();
            sounds.add("comanda succes");
            SoundPlayer.player(sounds);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void twitch(ArrayList<String> param) {
        //https://www.twitch.tv/directory/game/World%20of%20Warcraft
        String url = "https://www.twitch.tv/directory";
        if (param.size() > 0) {
            url += "/game/" + param.get(0);

            for (int i = 1; i < param.size(); i++) {
                url += "%20" + param.get(i);
            }
        }
        try {
            Desktop.getDesktop().browse(new URI(url));
            ArrayList<String> sounds = new ArrayList<String>();
            sounds.add("comanda succes");
            SoundPlayer.player(sounds);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void weather(String param) {
        //"http://api.openweathermap.org/data/2.5/weather?q=Bucharest&APPID=7e24e5f8a7b572000f24aaed703ee478"
        String head = "http://api.openweathermap.org/data/2.5/weather?q=";
        String base = "&APPID=7e24e5f8a7b572000f24aaed703ee478";
        String URL = head + "" + param + "" + base;
        URL obj;
        try {
            obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
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
                JSONArray weatherCondition = jsResponse.getJSONArray("weather");
                JSONObject weatherDesc = weatherCondition.getJSONObject(0);
                JSONObject weatherValue = jsResponse.getJSONObject("main");
                String temp = weatherValue.get("temp").toString();
                float itemp = Float.parseFloat(temp);
                itemp -= 272.15;
                String pres = weatherValue.get("pressure").toString();
                String humi = weatherValue.get("humidity").toString();

                Gogu.addToHistory("Condition: " + weatherDesc.get("main") + "\nTemperature: " + itemp + " C\nAir Pressure: " + pres
                        + " mBar\nHumidity: " + humi + "%");
                ArrayList<String> sounds = new ArrayList<String>();
                sounds.add("comanda succes");
                SoundPlayer.player(sounds);
            } else {
                Gogu.addToHistory("Wrong city!");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void currency(String param) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String head = "http://api.fixer.io/" + date + "?base=";
        String base = "&symbols=RON";
        String URL = head + "" + param + "" + base;
        URL obj;
        try {
            obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
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
                Gogu.addToHistory(param + " = " + value + " RON");
                ArrayList<String> sounds = new ArrayList<String>();
                sounds.add("comanda succes");
                SoundPlayer.player(sounds);
            } else {
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
