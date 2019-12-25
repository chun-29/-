package com.google.chapter.socketdemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;
    InetAddress internetAddress = null;
    public ServerThread(Socket socket,InetAddress inetAddress) {
        this.socket = socket;
        this.internetAddress = internetAddress;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        OutputStreamWriter writer = null;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("服务器端接收:" + "{'from_client':'"+ socket.getInetAddress().getHostAddress()+"','data':'"+info+"'}");
            }
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            writer = new OutputStreamWriter(outputStream,"UFT-8");
            writer.write("{'to_client':'"+internetAddress.getHostAddress()+"','data':'我是服务器数据'}");
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null) {
                    writer.close();
                }
                if(outputStream != null) {
                    outputStream.close();
                }
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
                if(inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if(inputStream != null) {
                    inputStream.close();
                }
                if(socket != null) {
                    socket.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
