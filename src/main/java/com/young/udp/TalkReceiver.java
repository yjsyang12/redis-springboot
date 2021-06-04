package com.young.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Young
 * @create 2021/6/4 16:19
 */
public class TalkReceiver implements Runnable {

    private DatagramSocket socket = null;

    private int port;
    private String msgFrom;

    public TalkReceiver(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] msg = packet.getData();
            String message = new String(msg, 0, msg.length);
            System.out.println(msgFrom + ": " + message);
            if (msg.length > 0 && message.startsWith("bye")) {
                break;
            }
        }
        socket.close();
    }
}
