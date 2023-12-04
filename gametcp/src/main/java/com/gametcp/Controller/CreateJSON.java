package com.gametcp.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.gametcp.Model.Player;

public class CreateJSON {
    

    public int createJSON(String namePlayer, int puntaje, String ip) throws StreamWriteException, DatabindException, IOException{

        String rutaArchivo = "gametcp/src/main/resources/PlayersList.json"; // ruta 
        int idReturn =0;
        
        //      ----- Acceso a JSON ------

        ObjectMapper objectMapper =new ObjectMapper();
        File archivo = new File(rutaArchivo);
        try {
                
                List<Player> players;
                if(archivo.exists()){
                    players = objectMapper.readValue(archivo, objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
                }else{
                    players = new ArrayList<>();
                }
              //         ------- Id ---------
                int id = idPlayer(players);
                idReturn=id;


            // -----------Creacion de objeto Player----------
            Player player = new Player(id,namePlayer, puntaje,ip);
            if(!players.isEmpty()){
                boolean playerExists = players.stream().anyMatch(p -> p.getId() == id);
                if (!playerExists) {
                    players.add(player);
                    objectMapper.writeValue(archivo, players);
                    System.out.println("Archivo JSON actualizado exitosamente en: " + rutaArchivo);
                } else {
                    System.out.println("El jugador con ID " + id + " ya existe en el archivo.");
                }

            }else{
                players.add(player);
                objectMapper.writeValue(archivo, players);
                System.out.println("Archivo JSON actualizado exitosamente en: " + rutaArchivo);
            }
        } catch (MismatchedInputException mie) {
           
            System.out.println("El archivo JSON está vacío o no contiene datos válidos.");
            if (archivo.delete()) {
                System.out.println("Se eliminó el archivo JSON.");
                Player player = new Player(1,namePlayer, puntaje,ip);
                List<Player> players;
                players = new ArrayList<>();
                players.add(player);
                objectMapper.writeValue(archivo, players);
                idReturn=1;
                System.out.println("Archivo JSON actualizado exitosamente en: " + rutaArchivo);
            } else {
                System.out.println("No se pudo eliminar el archivo JSON.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idReturn;
        
     }

    private static int idPlayer(List<Player> players) {
        if (players.isEmpty()) {
            return 1;
            
        } else {
            return players.size() + 1;
            
        }
    }
}
