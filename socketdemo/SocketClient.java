package com.google.chapter.socketdemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("服务器的ip",10068);
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,"UTF-8");
            System.out.println("请输入数据：");
            Scanner sc = new Scanner(System.in);
            String data = sc.nextLine();
            writer.write(data);
            writer.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            System.out.println("客户端地址:"+socket.getInetAddress().getHostAddress());
            while((info = bufferedReader.readLine())!=null){
                System.out.println("客户端接收:"+ info);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            writer.close();
            outputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
