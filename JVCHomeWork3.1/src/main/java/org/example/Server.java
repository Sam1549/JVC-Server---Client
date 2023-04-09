package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ){
                    System.out.printf("New connection accepted. Port: %d", clientSocket.getPort());

                    out.println("Write your name");

                    final String name = in.readLine();

                    out.println("Are you child? (yes/no)");
                    if(in.readLine() == "yes"){
                        out.printf("Welcome to the kids area, %s! Let's play!",name);
                    }else {
                        out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!",name);
                    }


                }
            }

        }
    }
}
