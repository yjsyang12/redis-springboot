package com.young.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * @author Young
 * @create 2021/6/4 15:15
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        byte[] data = datagramPacket.getData();
        socket.receive(datagramPacket);
        System.out.println(new java.lang.String(data, 0, data.length));

        socket.close();
    }
}
