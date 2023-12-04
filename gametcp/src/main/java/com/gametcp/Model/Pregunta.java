package com.gametcp.Model;

import java.util.List;

public class Pregunta {
    private int id;
    private String pregunta;
    private List<Respuesta> respuestas;

    public Pregunta() {
    }

    public Pregunta(int id, String pregunta, List<Respuesta> respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                "pregunta='" + pregunta + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }
}
