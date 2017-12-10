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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author Adrian
 */
public class sistem {

    //Data pentru fiecare timezone diferit
    public static void time(String param) {
        ArrayList<String> sounds = new ArrayList<String>();
        int aux = 0;
        String time = "";
        if (param.equalsIgnoreCase("Berlin")) {
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+1");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            time = c.get(java.util.Calendar.HOUR_OF_DAY) + ":"
                    + c.get(java.util.Calendar.MINUTE) + ":" + c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
            sounds.add("berlin");
        } else if (param.equalsIgnoreCase("Tokyo")) {
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+9");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            time = c.get(java.util.Calendar.HOUR_OF_DAY) + ":"
                    + c.get(java.util.Calendar.MINUTE) + ":" + c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
            sounds.add("tokyo");
        } else if (param.equalsIgnoreCase("Boston")) {
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT-5");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            time = c.get(java.util.Calendar.HOUR_OF_DAY) + ":"
                    + c.get(java.util.Calendar.MINUTE) + ":" + c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
            sounds.add("boston");
        } else if (param.equalsIgnoreCase("Bogota")) {
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT-5");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            time = c.get(java.util.Calendar.HOUR_OF_DAY) + ":"
                    + c.get(java.util.Calendar.MINUTE) + ":" + c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
            sounds.add("bogota");
        } else if (param.equals("gol")) {
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+2");
            java.util.Calendar c = java.util.Calendar.getInstance(tz);
            time = c.get(java.util.Calendar.HOUR_OF_DAY) + ":"
                    + c.get(java.util.Calendar.MINUTE) + ":" + c.get(java.util.Calendar.SECOND);
            Gogu.addToHistory(time);
            sounds.add("ora este");
        } else {
            aux = 1;
        }

        if (aux == 0) {
            StringTokenizer st = new StringTokenizer(time, ":");
            int count = 0;
            while (st.hasMoreElements()) {
                String num = st.nextToken();
                int nr = Integer.parseInt(num);
                if (nr > 20) {
                    if (count > 0) {
                        sounds.add("si");
                    }
                    sounds.add("" + num.charAt(0) + "0");
                    sounds.add("si");
                    sounds.add("" + num.charAt(1));
                    if (count == 1) {
                        sounds.add("minute");
                    } else if (count == 2) {
                        sounds.add("secunde");
                    }
                    count++;
                } else {
                    if (count > 0) {
                        sounds.add("si");
                    }
                    sounds.add(num);
                    if (count == 1) {
                        sounds.add("minute");
                    } else if (count == 2) {
                        sounds.add("secunde");
                    }
                    count++;
                }
            }
            SoundPlayer.player(sounds);
        } else {
            Gogu.addToHistory("Wrong command!");
            sounds.add("comanda gresita");
            SoundPlayer.player(sounds);
        }

    }

    //Data locala
    public static void date() {
        String date = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        Gogu.addToHistory(date);

        ArrayList<String> sounds = new ArrayList<String>();
        sounds.add("data");
        StringTokenizer st = new StringTokenizer(date, "/");
        int count = 0;
        String an = st.nextToken();
        String luna = st.nextToken();
        String zi = st.nextToken();
        int num = Integer.parseInt(zi);
        if (num > 20) {
            sounds.add("" + zi.charAt(0) + "0");
            sounds.add("si");
            sounds.add("" + zi.charAt(1));
        } else {
            sounds.add("" + num);
        }
        sounds.add(luna + "m");
        sounds.add(an);
        SoundPlayer.player(sounds);
    }

    //Ip calculatorului
    public static void ip() {
        String ip;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
            Gogu.addToHistory(ip);

            ArrayList<String> sounds = new ArrayList<String>();
            sounds.add("ip");
            StringTokenizer st = new StringTokenizer(ip, ".");
            int count = 0;
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            String d = st.nextToken();
            int numa = Integer.parseInt(a);
            int numb = Integer.parseInt(b);
            int numc = Integer.parseInt(c);
            int numd = Integer.parseInt(d);

            if (numa >= 100) {
                sounds.add("" + a.charAt(0));
                sounds.add("" + a.charAt(1));
                sounds.add("" + a.charAt(2));
            } else if (numa >= 10) {
                sounds.add("" + a.charAt(0));
                sounds.add("" + a.charAt(1));
            } else {
                sounds.add("" + a.charAt(0));
            }
            sounds.add("punct");
            if (numb >= 100) {
                sounds.add("" + b.charAt(0));
                sounds.add("" + b.charAt(1));
                sounds.add("" + b.charAt(2));
            } else if (numb >= 10) {
                sounds.add("" + b.charAt(0));
                sounds.add("" + b.charAt(1));
            } else {
                sounds.add("" + b.charAt(0));
            }
            sounds.add("punct");
            if (numc >= 100) {
                sounds.add("" + c.charAt(0));
                sounds.add("" + c.charAt(1));
                sounds.add("" + c.charAt(2));
            } else if (numc >= 10) {
                sounds.add("" + c.charAt(0));
                sounds.add("" + c.charAt(1));
            } else {
                sounds.add("" + c.charAt(0));
            }
            sounds.add("punct");
            if (numd >= 100) {
                sounds.add("" + d.charAt(0));
                sounds.add("" + d.charAt(1));
                sounds.add("" + d.charAt(2));
            } else if (numd >= 10) {
                sounds.add("" + d.charAt(0));
                sounds.add("" + d.charAt(1));
            } else {
                sounds.add("" + d.charAt(0));
            }
            SoundPlayer.player(sounds);
        } catch (UnknownHostException ex) {
            Logger.getLogger(sistem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Sterge un fisier sau director dat dupa calea lui absoluta
    public static void del(String path) {
        try {
            Path p = Paths.get(path);
            Files.deleteIfExists(p);
            ArrayList<String> sounds = new ArrayList<String>();
            sounds.add("comanda succes");
            SoundPlayer.player(sounds);
        } catch (IOException ex) {
            Logger.getLogger(sistem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Creeaza un director dat dupa calea lui absoluta
    public static void mkdir(String path) {
        boolean success = (new File(path)).mkdirs();

        if (!success) {
            Gogu.addToHistory("Eroare");
            ArrayList<String> sounds = new ArrayList<String>();
            sounds.add("eroare");
            SoundPlayer.player(sounds);
        } else {
            Gogu.addToHistory("Director creat cu success");
            ArrayList<String> sounds = new ArrayList<String>();
            sounds.add("comanda succes");
            SoundPlayer.player(sounds);
        }
    }

    //Opreste programul si Inchide calculatorul
    public static void shutdown() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("shutdown -s -t 0");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(sistem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
