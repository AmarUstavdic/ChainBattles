package com.myproject.game;

import com.myproject.game.network.kademlia.*;
import java.io.IOException;
import java.net.*;


public class Main {

    private static String localIp;
    private static String bootstrapIp = "172.17.0.2";
    private static boolean isBootstrap;
    private static final int port = 5000;
    private static final int B = 8;
    private static final int K = 2;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) isBootstrap = false;
        else isBootstrap = Boolean.parseBoolean(args[0]);
        localIp = InetAddress.getLocalHost().getHostAddress();


        KademliaDHT kademliaDHT = new KademliaDHT(InetAddress.getByName(localIp), port, isBootstrap, B, K);


        // run GUI
        //SwingUtilities.invokeLater(GameGUI::new);
    }

}
