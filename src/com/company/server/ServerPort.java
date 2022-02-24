package com.company.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/** FERTIG **/
public class ServerPort implements Runnable{

    private int port = 10001;
    private ServerSocket listen;

    public void start() {
            try {
        InetAddress bindAddr = InetAddress.getByName("localhost");
        System.out.println("Server start...");
        listen = new ServerSocket(port, 5,bindAddr);
        System.out.println("Server running at: http://localhost: " + port);

        while(true) {
            Socket currentClient = listen.accept();
            Thread thread = new Thread(() -> new Router(currentClient));
            thread.start();

        }

        } catch (IOException e){
                e.printStackTrace();
            }

    }

    @Override
    public void run() {
        start();
    }

}
