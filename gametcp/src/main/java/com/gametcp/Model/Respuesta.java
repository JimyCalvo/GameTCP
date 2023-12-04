package com.gametcp.Model;
public class Respuesta {
    private String ciudad;
    private int puntaje;

    public Respuesta() {
    }

    public Respuesta(String ciudad, int puntaje) {
        this.ciudad = ciudad;
        this.puntaje = puntaje;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "ciudad='" + ciudad + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }
}