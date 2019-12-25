package com.google.chapter.chatting.client;

import com.google.chapter.chatting.threadchat.SocketReader;
import com.google.chapter.chatting.threadchat.SocketWriter;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        Thread send = new Thread(new SocketWriter(socket,"我"));
        Thread reception = new Thread(new SocketReader(socket));
        send.start();
        reception.start();
    }
}
