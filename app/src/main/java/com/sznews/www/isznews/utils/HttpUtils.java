package com.sznews.www.isznews.utils;

import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;

/**
 * Created by sznews on 2016/11/21.
 */

public class HttpUtils {

    public static void getNewsJSON(final String url, final android.os.Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn;
                InputStream is;
                try {
                    conn = (HttpURLConnection) new URL(url).openConnection();
                    conn.setRequestMethod("GET");
                    is = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = " ";
                    StringBuilder result = new StringBuilder();
                    while ((line = reader.readLine()) != null){
                        result.append(line);
                    }
                    Message msg = new Message();
                    msg.obj = result.toString();
                    handler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
