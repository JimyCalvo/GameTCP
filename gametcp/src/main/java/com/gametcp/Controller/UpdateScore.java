package com.gametcp.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametcp.Model.Player;

public class UpdateScore {
    public int newScore (int id, int nuevoPuntaje){
        
        String rutaArchivo = "gametcp/src/main/resources/PlayersList.json"; // ruta 
        int aux=0;


        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File archivo = new File(rutaArchivo);
            List<Player> players;

            if (archivo.exists()) {
                // Si el archivo ya existe, lee la información actual
                players = objectMapper.readValue(archivo, objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));

                // Encuentra el jugador con el ID proporcionado
                Optional<Player> jugadorOptional = players.stream().filter(jugador -> jugador.getId() == id).findFirst();

                if (jugadorOptional.isPresent()) {
                    Player jugador = jugadorOptional.get();
                    aux=jugador.getPuntaje()+nuevoPuntaje;


                    jugador.setPuntaje(aux);


                    objectMapper.writeValue(archivo, players);

                    System.out.println("Puntaje actualizado exitosamente para el jugador con ID " + id);
                } else {
                    System.out.println("No se encontró ningún jugador con el ID " + id);
                }
            } else {
                System.out.println("El archivo de players no existe. No se puede actualizar el puntaje.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aux;
    }
}
