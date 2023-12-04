package com.gametcp.Model;

import java.util.Objects;
public class Player {
    private int id;
    private String nombre;
    private int puntaje;
    private String ip;
    public Player() {
    }



    public Player(int id, String nombre, int  puntaje, String ip) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.ip = ip;
    }
    public int getId() {
        return id;
    }


    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && puntaje == player.puntaje && Objects.equals(nombre, player.nombre) && Objects.equals(ip, player.ip);
    }

     @Override
    public int hashCode() {
        return Objects.hash(id, nombre, puntaje,ip);
    }



    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ",nombre='" + nombre + '\'' +
                ", puntaje=" + puntaje +
                ", ip='" + ip + '\'' +
                '}';
    }

    
}
