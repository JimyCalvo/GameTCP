package com.gametcp.Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    private List<Integer> numerosGenerados = new ArrayList<>();
    private Random random = new Random();

    public int generarNumeroAleatorio() {
        int numeroAleatorio;
        do {
            numeroAleatorio = random.nextInt(20) + 1; 
        } while (numerosGenerados.contains(numeroAleatorio));

        numerosGenerados.add(numeroAleatorio);
        return numeroAleatorio;
    }
}
