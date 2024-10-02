package com.example.streamlitdashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StreamlitDashboard {
    public StreamlitDashboard() {
        // Create a GUI for your dashboard
        JFrame frame = new JFrame("Streamlit Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(new JLabel("Streamlit Dashboard"));
        JButton launchApp1Button = new JButton("Uplift ChatBot");
        JButton launchApp2Button = new JButton("Mindfulness And Breathing");

        launchApp1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("streamlit", "run", "streamlit_apps/app.py");
                    processBuilder.start();
                } catch (IOException ex) {
                    System.err.println("Error launching Streamlit App 1: " + ex.getMessage());
                }
            }
        });

        launchApp2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("streamlit", "run", "streamlit_apps/cml.py");
                    processBuilder.start();
                } catch (IOException ex) {
                    System.err.println("Error launching Streamlit App 1: " + ex.getMessage());}
            }
        });

        frame.add(launchApp1Button);
        frame.add(launchApp2Button);

        frame.setSize(300, 250);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        StreamlitDashboard dashboard = new StreamlitDashboard();
    }
}