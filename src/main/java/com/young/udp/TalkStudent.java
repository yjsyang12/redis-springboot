package com.young.udp;

/**
 * @author Young
 * @create 2021/6/4 16:24
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSender(6666, 8888, "localhost")).start();
        new Thread(new TalkReceiver(7777, "老师")).start();
    }
}
