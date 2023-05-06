package com.mygame.app.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;


public class MainView extends JPanel {

    private final Color shipColor = new Color(131, 131, 131);
    private final Color shipDarkColor = new Color(80, 80, 80);
    private final int shipTileWidth = 40;
    private final int shipTileHeight = 40;


    public MainView(int width, int height) {
        this.setPreferredSize(new Dimension(width,height));
        this.setSize(new Dimension(width, height));

        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);

        this.setBackground(Color.BLACK);


        ClassLoader classLoader = MainView.class.getClassLoader();
        InputStream fontStream = classLoader.getResourceAsStream("fonts/ProgressPersonalUse-EaJdz.ttf");
        Font customFont;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            customFont = customFont.deriveFont(Font.PLAIN, 90); // Adjust the font size as needed
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            customFont = new Font("Arial", Font.PLAIN, 24); // Fallback font
        }


        JLabel title = new JLabel("BATTLESHIP");
        JLabel label1 = new JLabel("THE CLASSIC NAVAL COMBAT GAME");
        JLabel label2 = new JLabel("DECENTRALIZED EDITION");

        title.setFont(customFont);
        title.setForeground(Color.WHITE);

        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setForeground(new Color(252, 203, 42));

        label2.setFont(new Font("Arial",Font.PLAIN,20));
        label2.setForeground(new Color(27, 74, 255));

        JButton singleBtn = new JButton("Single player");
        JButton multiBtn = new JButton("Multiplayer");

        Font btnFont = new Font("Arial",Font.BOLD,27);
        singleBtn.setPreferredSize(new Dimension(300,70));
        singleBtn.setForeground(Color.WHITE);
        singleBtn.setFont(btnFont);
        singleBtn.setFocusable(false);
        singleBtn.setBackground(new Color(166, 166, 166));
        multiBtn.setPreferredSize(new Dimension(300, 70));
        multiBtn.setForeground(Color.WHITE);
        multiBtn.setFont(btnFont);
        multiBtn.setFocusable(false);
        multiBtn.setBackground(new Color(166, 166, 166));



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 10, 0, 10);



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        this.add(label1, gbc);

        gbc.gridy = 1;
        this.add(title, gbc);

        gbc.insets = new Insets(0, 10, 30, 10);
        gbc.gridy = 2;
        this.add(label2, gbc);

        gbc.insets = new Insets(10, 10, 0, 10);
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        this.add(singleBtn, gbc);

        gbc.gridy = 4;
        this.add(multiBtn, gbc);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        // ship to right
        int shipX = 600;
        int shipY = 50;
        int shipLength = 5;
        g2d.setColor(shipColor);
        g2d.fillRoundRect(shipX, shipY, shipLength*shipTileWidth,shipTileHeight,15,15);
        g2d.setColor(shipDarkColor);
        for (int i = 0; i < shipLength; i++) {
            int shipDetailX = (i * shipTileWidth) + shipX + shipTileWidth/4;
            int shipDetailY = shipTileHeight/4 + shipY;
            g2d.fillOval(shipDetailX, shipDetailY, shipTileWidth/2, shipTileHeight/2);
        }


        // ship bottom right
        shipX = 650;
        shipY = 400;
        shipLength = 3;
        g2d.setColor(shipColor);
        g2d.fillRoundRect(shipX, shipY, shipTileWidth,shipLength*shipTileHeight,15,15);
        g2d.setColor(shipDarkColor);
        for (int i = 0; i < shipLength; i++) {
            int shipDetailX = shipTileHeight/4 + shipX;
            int shipDetailY = (i * shipTileWidth) + shipY + shipTileWidth/4;
            g2d.fillOval(shipDetailX, shipDetailY, shipTileWidth/2, shipTileHeight/2);
        }


        // ship to right
        shipX = 50;
        shipY = 450;
        shipLength = 4;
        g2d.setColor(shipColor);
        g2d.fillRoundRect(shipX, shipY, shipLength*shipTileWidth,shipTileHeight,15,15);
        g2d.setColor(shipDarkColor);
        for (int i = 0; i < shipLength; i++) {
            int shipDetailX = (i * shipTileWidth) + shipX + shipTileWidth/4;
            int shipDetailY = shipTileHeight/4 + shipY;
            g2d.fillOval(shipDetailX, shipDetailY, shipTileWidth/2, shipTileHeight/2);
        }


        // ship to right top
        shipX = 200;
        shipY = 50;
        shipLength = 2;
        g2d.setColor(shipColor);
        g2d.fillRoundRect(shipX, shipY, shipLength*shipTileWidth,shipTileHeight,15,15);
        g2d.setColor(shipDarkColor);
        for (int i = 0; i < shipLength; i++) {
            int shipDetailX = (i * shipTileWidth) + shipX + shipTileWidth/4;
            int shipDetailY = shipTileHeight/4 + shipY;
            g2d.fillOval(shipDetailX, shipDetailY, shipTileWidth/2, shipTileHeight/2);
        }


        // ship top left 2x
        shipX = 650;
        shipY = 400;
        shipLength = 3;
        g2d.setColor(shipColor);
        g2d.fillRoundRect(shipX, shipY, shipTileWidth,shipLength*shipTileHeight,15,15);
        g2d.setColor(shipDarkColor);
        for (int i = 0; i < shipLength; i++) {
            int shipDetailX = shipTileHeight/4 + shipX;
            int shipDetailY = (i * shipTileWidth) + shipY + shipTileWidth/4;
            g2d.fillOval(shipDetailX, shipDetailY, shipTileWidth/2, shipTileHeight/2);
        }


        // ship bottom right
        shipX = 50;
        shipY = 0;
        shipLength = 3;
        g2d.setColor(shipColor);
        g2d.fillRoundRect(shipX, shipY, shipTileWidth,shipLength*shipTileHeight,15,15);
        g2d.setColor(shipDarkColor);
        for (int i = 0; i < shipLength; i++) {
            int shipDetailX = shipTileHeight/4 + shipX;
            int shipDetailY = (i * shipTileWidth) + shipY + shipTileWidth/4;
            g2d.fillOval(shipDetailX, shipDetailY, shipTileWidth/2, shipTileHeight/2);
        }




    }
}
