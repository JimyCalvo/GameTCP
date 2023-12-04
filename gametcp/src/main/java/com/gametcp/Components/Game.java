package com.gametcp.Components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import com.gametcp.Controller.Quiz;
import com.gametcp.Controller.UpdateScore;
import com.gametcp.Model.Pregunta;

public class Game implements Runnable {
    private Socket clientSocket;

    public Game(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        int idPlayer = 0;
        int contador = 1;
        Quiz quiz = new Quiz();
        String pregunta;
        int puntaje = 0;
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            PrintWriter writer = new PrintWriter(outputStreamWriter, true);
            BufferedReader entradaReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer.println("\n\n\n\n");
            writer.println("   ╔═══════════════════════════════════════════════════════════════════════════════╗");
            writer.println("   ║      ■        ■       ■        G E O Q U E S T       ■        ■       ■       ║");
            writer.println("   ╚═══════════════════════════════════════════════════════════════════════════════╝\n\n\n");
            Thread.sleep(1000);
            do {
                Pregunta preguntaSeleccionada = quiz.obtenerPreguntaPorId(contador);
                pregunta = preguntaSeleccionada.getPregunta();
                System.out.println("\n" + contador + ". ¿Qué ciudad está más cerca de " + pregunta + " ?\n");
                writer.println("\n\t" + contador + ". ¿Qué ciudad está más cerca de " + pregunta + " ?");
                writer.println("\t a. " + preguntaSeleccionada.getRespuestas().get(0).getCiudad() );
                writer.println("\t b. " + preguntaSeleccionada.getRespuestas().get(1).getCiudad() );
                writer.println("\t c. " + preguntaSeleccionada.getRespuestas().get(2).getCiudad() );
                writer.println("\t d. " + preguntaSeleccionada.getRespuestas().get(3).getCiudad() + "\n");
                writer.println("\t Escribe el literal correspondiente: ");
                
                try{
                    idPlayer = Integer.parseInt(entradaReader.readLine());
                }catch(NumberFormatException nue){nue.printStackTrace();}

                String literal = entradaReader.readLine();
                int puntos;
                UpdateScore updateScore = new UpdateScore();

                switch (literal) {

                    case "A":
                        puntos = preguntaSeleccionada.getRespuestas().get(0).getPuntaje();
                        System.out.println("Respondio: " + preguntaSeleccionada.getRespuestas().get(0).getCiudad());
                        System.out.println("Puntos: " + puntos);
                        puntaje = updateScore.newScore(idPlayer, puntos);

                        break;
                    case "B":
                        puntos = preguntaSeleccionada.getRespuestas().get(1).getPuntaje();
                        System.out.println("Respondio: " + preguntaSeleccionada.getRespuestas().get(1).getCiudad());
                        System.out.println("Puntos: " + puntos);
                        puntaje = updateScore.newScore(idPlayer, puntos);
                        break;
                    case "C":
                        puntos = preguntaSeleccionada.getRespuestas().get(2).getPuntaje();
                        System.out.println("Respondio: " + preguntaSeleccionada.getRespuestas().get(2).getCiudad());
                        System.out.println("Puntos: " + puntos);
                        puntaje = updateScore.newScore(idPlayer, puntos);
                        break;
                    case "D":
                        puntos = preguntaSeleccionada.getRespuestas().get(3).getPuntaje();
                        System.out.println("Respondio: " + preguntaSeleccionada.getRespuestas().get(3).getCiudad());
                        System.out.println("Puntos: " + puntos);
                        puntaje = updateScore.newScore(idPlayer, puntos);

                        break;
                    default:
                        break;
                }

                contador++;
                writer.println("\n\t\t\t ╔════════════════════════════════╗");
                writer.println("\t\t\t           Puntos:  " + puntaje);
                writer.println("\t\t\t ╚════════════════════════════════╝\n");

            } while (contador != 21);
            writer.println("\n\n");

            writer.println("     ▓▓▓                          ▓                                              ▓▓▓                            "); 
            writer.println("   ▓   ▓                                                                          ▓                            "); 
            writer.println("   ▓      ▓ ▓▓   ▓▓▓    ▓▓▓    ▓▓     ▓▓▓    ▓▓▓      ▓ ▓▓    ▓▓▓   ▓ ▓▓          ▓  ▓   ▓   ▓▓ ▓   ▓▓▓   ▓ ▓▓  "); 
            writer.println("   ▓      ▓▓  ▓     ▓  ▓   ▓    ▓        ▓  ▓         ▓▓  ▓  ▓   ▓  ▓▓  ▓         ▓  ▓   ▓  ▓  ▓       ▓  ▓▓  ▓ "); 
            writer.println("   ▓  ▓▓  ▓      ▓▓▓▓  ▓        ▓     ▓▓▓▓   ▓▓▓      ▓▓  ▓  ▓   ▓  ▓             ▓  ▓   ▓   ▓▓     ▓▓▓▓  ▓     "); 
            writer.println("   ▓   ▓  ▓     ▓   ▓  ▓   ▓    ▓    ▓   ▓      ▓     ▓ ▓▓   ▓   ▓  ▓         ▓   ▓  ▓  ▓▓  ▓      ▓   ▓  ▓     "); 
            writer.println("    ▓▓▓   ▓      ▓▓▓▓   ▓▓▓    ▓▓▓    ▓▓▓▓  ▓▓▓▓      ▓       ▓▓▓   ▓          ▓▓▓    ▓▓ ▓   ▓▓▓    ▓▓▓▓  ▓     "); 
            writer.println("                                                      ▓                                     ▓   ▓               "); 
            writer.println("                                                      ▓                                      ▓▓▓                "); 
            Thread.sleep(1500);
            System.out.println("Jugador a Finalizado.....");
            writer.close();
            entradaReader.close();
            clientSocket.close();

        } catch (SocketException se) {
            // Manejar la excepción de SocketException: Connection reset
            if (se.getMessage().equalsIgnoreCase("Connection reset")) {
                System.out.println("La conexión con el cliente se a perdido.");
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
