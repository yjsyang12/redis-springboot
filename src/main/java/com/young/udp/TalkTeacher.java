package com.young.udp;

/**
 * @author Young
 * @create 2021/6/4 16:27
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSender(5555,7777,"localhost")).start();
        new Thread(new TalkReceiver(8888,"学生")).start();
    }
}
