package com.young.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author Young
 * @create 2021/6/4 16:13
 */
public class TalkSender implements Runnable {

    private DatagramSocket socket = null;
    private BufferedReader reader = null;

    private int fromPort;
    private int toPort;
    private String toIp;

    public TalkSender(int fromPort, int toPort, String toIp) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.toIp = toIp;

        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            String msg = null;
            try {
                msg = reader.readLine();
                byte[] bytes = msg.getBytes();

                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length
                        , new InetSocketAddress(this.toIp, this.toPort));
                socket.send(packet);

                if ("bye".equals(msg)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
