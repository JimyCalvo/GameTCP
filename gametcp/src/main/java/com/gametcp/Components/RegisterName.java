package com.gametcp.Components;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import com.gametcp.Controller.CreateJSON;

public class RegisterName implements Runnable {
    private Socket clientSocket;
    private IdPlayerGame idPlayerGame;

    public RegisterName(Socket clientSocket, IdPlayerGame idPlayerGame) {
        this.clientSocket = clientSocket;
        this.idPlayerGame = idPlayerGame;
    }

    public RegisterName(Socket clienSocket) {
        this.clientSocket = clienSocket;
    }

    @Override
    public void run()  {

            try {
                BufferedReader entradaReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream outputStream = clientSocket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter salidaWriter = new PrintWriter(outputStreamWriter, true);

                String namePlayer;
                Boolean nameBoolean= true;
                int idPlayer;
                int scorePlayer = 0;
                CreateJSON createJSON = new CreateJSON();
                String ipPlayer = clientSocket.getInetAddress().getHostAddress();
                do {
                        salidaWriter.println("Por favor, ingresa tu nombre: ");
                        namePlayer = entradaReader.readLine();
                        if ( !namePlayer.isEmpty()) {
                            nameBoolean=false;
                           System.out.println("Nombre recibido: " + namePlayer); 
                        }

                } while (nameBoolean);
                idPlayer = createJSON.createJSON(namePlayer, scorePlayer, ipPlayer);
                System.out.println(idPlayer+" estes es el id");
                
                                
                System.out.println("\n\t\t\t Jugador registrado, ¡Exitosamente!\n");
                System.out.println("\t\t══════════════════════════════════════════ ");
                System.out.println("\t\t|            InFormación del Jugador        |");
                System.out.println("\t\t══════════════════════════════════════════ ");
                System.out.println("\t\t Nombre:  " + namePlayer);
                System.out.println("\t\t IP:      " + ipPlayer);
                System.out.println("\t\t Puntaje: " + scorePlayer);
                System.out.println("\t\t ID:      " + idPlayer);
                System.out.println("\t\t============================================\n");
                salidaWriter.println("\n\t\t\t Jugador registrado, ¡Exitosamente!\n");
                salidaWriter.println("\t\t\t══════════════════════════════════════════");
                salidaWriter.println("\t\t\t|            InFormacion del Jugador       |");
                salidaWriter.println("\t\t\t══════════════════════════════════════════ \n");
                salidaWriter.println("\t\t\t  ID:      "+idPlayer);
                salidaWriter.println("\t\t\t  Nombre:  " + namePlayer);
                salidaWriter.println("\t\t\t  IP:      " + ipPlayer);
                salidaWriter.println("\t\t\t  Puntaje: " + scorePlayer);
                salidaWriter.println("\n\t\t\t══════════════════════════════════════════\n\n");

                salidaWriter.println("#");
                salidaWriter.println(idPlayer);
                for (int i = 0; i < 90; i++) {
                    salidaWriter.println("█");
                    Thread.sleep(10);
                }
                Thread.sleep(500);
                if (idPlayerGame!=null) {
                    idPlayerGame.setIdPlayer(idPlayer);
                }
                
                
               

               

                // entradaReader.close();
                // salidaWriter.close();

            } catch (SocketException se) {
                // Manejar la excepción de SocketException: Connection reset
                if (se.getMessage().equalsIgnoreCase("Connection reset")) {
                    System.out.println("La conexión con el cliente se a perdido.");
                }else if(se.getMessage().equalsIgnoreCase("Socket is closed")){
                    System.out.println("El socket ya está cerrado.");
                } else {
                    se.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

}
