package com.young.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Young
 * @create 2021/6/4 15:08
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        String msg = "hello,kugoo~";
        byte[] bytes = msg.getBytes();

        InetAddress inetAddress = InetAddress.getByName("localhost");

        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length
                , inetAddress, 9090);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
