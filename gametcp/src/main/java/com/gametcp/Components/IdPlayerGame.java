package com.gametcp.Components;

public class IdPlayerGame {

    private int idPlayer;

    

    public synchronized void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }



    public synchronized int getIdPlayer() {
        return idPlayer;
    }
   

}
