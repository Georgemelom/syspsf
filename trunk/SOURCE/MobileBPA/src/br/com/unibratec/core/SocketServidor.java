package br.com.unibratec.core;

import java.io.*;
import javax.microedition.io.*;
import javax.microedition.midlet.*;

public class SocketServidor extends MIDlet implements Runnable{

    public SocketServidor() {
    }
    
    public void destroyApp(boolean unconditional) {}
    
    protected void pauseApp() {}
    
    protected void startApp(){
            Thread t = new Thread(this);
            t.start();
    }

    public void run() {
            try {
                    ServerSocketConnection conexaoServer = (ServerSocketConnection)Connector.open("socket://:5000");
                    SocketConnection conexao = (SocketConnection)conexaoServer.acceptAndOpen();
                    System.out.println("SERVIDOR: Conexão aceita");
                    OutputStream OS = conexao.openOutputStream();
                    String message = "SERVIDOR: Hello Cliente! Vamos testar a comunicação!";
                    try {
                        OS.write(message.getBytes());
                        OS.write("\r\n".getBytes());
                        System.out.println("SERVIDOR: Mensagem enviada");
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }
                    OS.close();
                    conexao.close();
                    conexaoServer.close();            
            } catch (Exception exc) {
                   System.out.println(exc);
              }
        }     
} 
