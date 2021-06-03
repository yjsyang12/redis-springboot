package com.young.tcpFile;


import java.io.*;
import java.net.Socket;

/**
 * @author Young
 * @create 2021/6/3 16:47
 */
public class FileClientTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8024);

        OutputStream os = socket.getOutputStream();

        File file = new File("src/main/resources/test.png");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        fis.close();
        os.close();
        socket.close();
    }
}
