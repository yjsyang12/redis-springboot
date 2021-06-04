package com.young.udp;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Young
 * @create 2021/6/4 15:46
 */
public class UdpReceiver {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);

            byte[] msg = packet.getData();
            String message = new String(msg, 0, msg.length);
            System.out.println(message);
            if (msg.length > 0 && message.startsWith("bye")) {
                break;
            }
        }

        socket.close();
    }
}
