package com.google.chapter.chatting.server;

import com.google.chapter.chatting.threadchat.SocketReader;
import com.google.chapter.chatting.threadchat.SocketWriter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    public static void main(String[] args) throws IOException {
        int serverPort = 8888;
        ServerSocket server = new ServerSocket(serverPort);
        Socket socket = server.accept();
        Thread send = new Thread(new SocketWriter(socket,"网管"));
        Thread reception = new Thread(new SocketReader(socket));
        send.start();
        reception.start();
    }
}
