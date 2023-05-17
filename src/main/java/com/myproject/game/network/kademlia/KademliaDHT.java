package com.myproject.game.network.kademlia;


import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  THIS IS THE MAIN CLASS OF THE KADEMLIA DHT
 */

public class KademliaDHT {

    private final RoutingTable routingTable;
    private final InMessageQueue inMessageQueue;
    private final OutMessageQueue outMessageQueue;
    private final KademliaMessageReceiver messageReceiver;
    private final KademliaMessageSender messageSender;
    private final RoutingTableUpdater routingTableUpdater;
    private final PingHandler pingHandler;

    public KademliaDHT(InetAddress ip, int port, boolean isBootstrapNode, int B, int K) {
        this.routingTable = new RoutingTable(ip, port, isBootstrapNode, B, K);
        this.inMessageQueue = new InMessageQueue();
        this.outMessageQueue = new OutMessageQueue();
        this.messageReceiver = new KademliaMessageReceiver(inMessageQueue);
        this.messageSender = new KademliaMessageSender(outMessageQueue);
        this.routingTableUpdater = new RoutingTableUpdater(routingTable,60000);
        this.pingHandler = new PingHandler(routingTable, 30000);



        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(messageReceiver);
        executorService.submit(routingTableUpdater);
        executorService.submit(pingHandler);

        // only used for debugging purposes
        executorService.submit(new DebugCLI(routingTable));

    }

}
