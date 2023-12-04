package com.gametcp.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gametcp.Components.Game;
import com.gametcp.Components.ProgressBar;
import com.gametcp.Components.RegisterName;
import com.gametcp.Components.Welcome;

public class ServerTCP {
    public  void serverTCP(){
        
        int puerto = 5000;
        ProgressBar.progressBar();
        System.out.println("\n\n\t\t Servidor TCP iniciado en el puerto: " + puerto+"\n");
        try {
            ServerSocket serverSocket =  new ServerSocket(puerto);
            System.out.println("\t\t\t Esperando conexiones...");
            ExecutorService executorService = Executors.newFixedThreadPool(1);

            while (true) {
                Socket socketClients = serverSocket.accept();
                System.out.println("Se establecio la conexion con: " + socketClients.getInetAddress().getHostAddress());
                
                // Hilo de Bienvenida
                Runnable welcome = new Welcome(socketClients);
                executorService.submit(welcome);
                
                // Hilo de Name
               Runnable  hiloName = new RegisterName(socketClients);
                executorService.submit(hiloName);

                 // Hilo de Game
               Runnable  gameHilo = new Game(socketClients);
                executorService.submit(gameHilo);
            }
            
        }catch (SocketException se) {
            if (se.getMessage().equalsIgnoreCase("Connection reset")) {
                System.out.println("La conexión con el cliente se a perdido.");
            } else {
                se.printStackTrace();
            }
        }
         catch (IOException e) {
            e.printStackTrace();

        }
    }
    
    
}
