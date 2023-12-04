package com.gametcp.Controller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametcp.Model.Pregunta;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Quiz {

    public Pregunta obtenerPreguntaPorId(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "gametcp/src/main/java/com/gametcp/DataBase/Quiz.json";  // Reemplaza con tu JSON
        try {
            File file = new File(jsonString);
            List<Pregunta> preguntas = objectMapper.readValue(file, new TypeReference<List<Pregunta>>() {});

            for (Pregunta pregunta : preguntas) {
                if (pregunta.getId() == id) {
                    return pregunta;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;  
    }
}
