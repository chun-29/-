package com.google.chapter.socketdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTcp {
    public static void main(String[] args) {
        int serverPort = 6666;
        String message;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            while ((message = bufferedReader.readLine())!=null) {
                System.out.println(message);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
