package com.google.chapter.chatting.threadchat;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketWriter implements Runnable {
    private Socket socket;
    private String userName;
    private PrintWriter pw;
    public SocketWriter(Socket socket,String userName) {
        this.socket = socket;
        this.userName = userName;
    }
    @Override
    public void run() {
        String temp = new String();
        Scanner input = new Scanner(System.in);
        try {
            pw = new PrintWriter(socket.getOutputStream(),true);
            while (true) {
                temp = input.nextLine();
                pw.println(userName+ ":"+ temp);
                if (temp.endsWith("bye")) {
                    break;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
