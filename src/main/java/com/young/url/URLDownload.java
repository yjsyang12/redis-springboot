package com.young.url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Young
 * @create 2021/6/4 16:52
 */
public class URLDownload {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/young/secret.txt");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream is = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("secret.text");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        is.close();
        urlConnection.disconnect();

    }
}
