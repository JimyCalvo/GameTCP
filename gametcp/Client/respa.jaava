import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ReceivingClientTCP {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Dirección IP del servidor
        int serverPort = 5000; // Puerto del servidor
        int idPlayer=0;
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                Socket clientSocket = new Socket(serverAddress, serverPort);
                System.out.println("Conectado al servidor: " + serverAddress + ":" + serverPort);

                
                PrintWriter outPrintWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));

                // Bucle para recibir mensajes del servidor
                String serverResponse;
                
                while ((serverResponse = reader.readLine()) != null) {
                    
                    if(serverResponse.equals("Por favor, ingresa tu nombre: ")){
                        
                        System.out.print(serverResponse);
            
                        String name = scanner.nextLine();
                        outPrintWriter.println(name);
                        


                    }else if(serverResponse.equals("#")){
                        String aux=reader.readLine();
                        idPlayer = Integer.parseInt(aux);
                       
                    }else if(serverResponse.equals("\t Escribe el literal correspondiente: ")){
                        String respuesta="";
                        boolean aux = true;
                        System.out.print("\t Escribe el literal correspondiente: ");
                        do {
                            String opcion = scanner.nextLine();
                            switch (opcion) {
                                case "a":
                                case "A":
                                case "b":
                                case "B":
                                case "c":
                                case "C":
                                case "d":
                                case "D":
                                    aux = false;
                                    respuesta=opcion.toUpperCase();
                                    break;
                                default:
                                    System.out.print("\t Opción no válida. Debes ingresar a, b, c o d: ");
                                    break;
                            }
                        } while (aux);
                        
                        outPrintWriter.println(idPlayer);
                        outPrintWriter.println(respuesta);
                        
                    }else if(serverResponse.equals("█")){
                        System.out.print("█");
                    }
                    else{
                        System.out.println(serverResponse);
                    }
                }
 
                // Cerrar recursos
                reader.close();
                clientSocket.close();
                System.out.println("Conexión cerrada.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            
            e.printStackTrace();
        }

        

    }


    
}
