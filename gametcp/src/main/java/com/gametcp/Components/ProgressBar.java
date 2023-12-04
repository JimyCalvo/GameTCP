package com.gametcp.Components;

public class ProgressBar {
    public static void progressBar() {
        int timePause=10;
         for(int i=0; i<75;i++){
            System.out.print("█");
            pausar(timePause);
         }
    }
    private static void pausar(int timePause) {
        try {
            Thread.sleep(timePause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }   

}
