/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.midi.*;

/**
 *
 * @author Adrian
 */
public class SoundPlayer {

    static MediaPlayer mp;
    static ArrayList<String> queue = new ArrayList<String>();
    static boolean isPlaying = false;
    static Media hit;

    public static void player(ArrayList<String> sound) {
        for (String it : sound) {
            System.out.println(it);
            String bip = it + ".mp3";
            queue.add(bip);
        }

        if (!queue.isEmpty()) {
            String last = queue.remove(0);
            hit = new Media(new File(last).toURI().toString());
            mp = new MediaPlayer(hit);
            mp.play();

            mp.setOnEndOfMedia(new Runnable() {
                public void run() {
                    player(new ArrayList<String>());
                }
            });
        }
    }
}
