package com.young.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author Young
 * @create 2021/6/4 15:46
 */
public class UdpSender {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = reader.readLine();

            byte[] bytes = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length
                    , new InetSocketAddress("localhost", 6666));

            socket.send(packet);


            if ("bye".equals(msg)) {
                break;
            }
        }

        socket.close();
    }
}
