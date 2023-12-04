package com.gametcp.Components;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Welcome implements Runnable {
    private Socket clienSocket;

    public Welcome(Socket clienSocket) {
        this.clienSocket = clienSocket;
    }

    @Override
    public void run() {
        try {
            OutputStreamWriter writerStreamWriter = new OutputStreamWriter(clienSocket.getOutputStream(), "UTF-8");
            BufferedWriter writer = new BufferedWriter(writerStreamWriter);
            writer.write("\n");    
            writer.write("\n\t\t\t█═══════════════════════════════════════════════════════════════════█");
            writer.write("\n\t\t\t║                                                                   ║");
            writer.write("\n\t\t\t║        ╔══╗                   ╔╗       ╔╗          ╔╗    ╔╗       ║");
            writer.write("\n\t\t\t║        ║╔╗║                   ║║       ║║          ║║    ║║       ║");
            writer.write("\n\t\t\t║        ║╚╝╚╦╦══╦═╗╔╗╔╦══╦═╗╔╦═╝╠══╗    ║╠╗╔╦══╦══╦═╝╠══╦═╣║       ║");
            writer.write("\n\t\t\t║        ║╔═╗╠╣║═╣╔╗╣╚╝║║═╣╔╗╬╣╔╗║╔╗║  ╔╗║║║║║╔╗║╔╗║╔╗║╔╗║╔╩╝       ║");
            writer.write("\n\t\t\t║        ║╚═╝║║║═╣║║╠╗╔╣║═╣║║║║╚╝║╚╝╠╗ ║╚╝║╚╝║╚╝║╔╗║╚╝║╚╝║║╔╗       ║");
            writer.write("\n\t\t\t║        ╚═══╩╩══╩╝╚╝╚╝╚══╩╝╚╩╩══╩══╩╣ ╚══╩══╩═╗╠╝╚╩══╩══╩╝╚╝       ║");
            writer.write("\n\t\t\t║                                    ╝       ╔═╝║                   ║");
            writer.write("\n\t\t\t║                                            ╚══╝                   ║");
            writer.write("\n\t\t\t█═══════════════════════════════════════════════════════════════════█ \n\n");
           
           Thread.sleep(400);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    
}
