/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogu;

import java.awt.*;
import java.awt.event.*;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;

/**
 *
 * @author Adrian
 */
public class Gogu {

    String command = new String();
    public static JTextArea history;

    /**
     * @param args the command line arguments
     */
    private static void createAndShowGUI() {

        JFrame frame = new JFrame("GOGU");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField cmd = new JTextField();
        history = new JTextArea();
        JScrollPane scroll = new JScrollPane(history);
        cmd.setPreferredSize(new Dimension(800, 100));
        scroll.setPreferredSize(new Dimension(800, 500));
        //history.setPreferredSize(new Dimension(800, 500));
        Font font = new Font("Courier", Font.BOLD, 20);
        cmd.setFont(font);
        history.setFont(font);
        history.setEditable(false);

        cmd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (cmd.getText().length() != 0) {
                        history.setText(history.getText() + '\n' + "-> " + cmd.getText());
                        InterpretCommand.Resolve(cmd.getText());
                        cmd.setText("");
                    }
                }
            }
        });

        //Add the ubiquitous "Hello World" label.
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        frame.getContentPane().add(cmd, BorderLayout.SOUTH);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //cvbcbvsdfsdfasdad
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                JFXPanel fxPanel = new JFXPanel();
            }
        });
    }

    public static void addToHistory(String s) {
        history.setText(history.getText() + '\n' + s);
    }

}
