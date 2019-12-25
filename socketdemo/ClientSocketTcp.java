package com.google.chapter.socketdemo;

import com.google.chapter.chatting.client.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: classprogram
 * @Description: ClientSockeTcp
 * @author: chun
 * @date: 2019/12/2 下午
 */
public class ClientSocketTcp {
    public static void main(String[] args) {
        String message = "今天天气真好!";
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 6666;
            Socket socket = new Socket(serverAddress, serverPort);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(message);
            bufferedWriter.flush();
            socket.shutdownOutput();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (ConnectException e) {
            System.out.println("can not get connection,please try again");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
