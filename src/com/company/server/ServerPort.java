package com.company.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPort {

    private int port = 10001;
    private ServerSocket server;

    private SocketInterface application;

    public ServerPort (SocketInterface application) {
        this.application = application;
    }

    public void start() throws IOException {
        System.out.println("Server start...");
        server = new ServerSocket(port, 5);
        System.out.println("Server running at: http://localhost: " + port);

        run();
    }

    private void run() {
        while(true) {
            try {
                Socket socket = server.accept();
                Thread thread = new Thread(new RequestHandler(socket, application));
                thread.start();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
