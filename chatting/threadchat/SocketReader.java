package com.google.chapter.chatting.threadchat;

import com.google.chapter.chatting.threadchat.SocketReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketReader implements Runnable {
    private Socket socket;
    private BufferedReader br;
    public SocketReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String temp = new String();
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                temp = br.readLine();
                System.out.println(temp);
                if (temp.endsWith("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
