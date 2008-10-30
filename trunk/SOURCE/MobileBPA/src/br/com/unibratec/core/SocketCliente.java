package br.com.unibratec.core;

import java.io.*;
import javax.microedition.io.*;
import javax.microedition.midlet.*;

public class SocketCliente extends MIDlet implements Runnable{
    
    public SocketCliente() {}
    
    public void destroyApp(boolean unconditional) {}
    
    protected void pauseApp() {}
    
    protected void startApp(){
            Thread t = new Thread(this);
            t.start();
    }

    public void run() {
            try {
                    SocketConnection conexao = (SocketConnection)Connector.open("socket://localhost:5000");
                    System.out.println("CLIENTE: Conectado ao servidor");
                    InputStream IS = conexao.openInputStream();
                    while (true) {
                        StringBuffer buff = new StringBuffer();
                        int dadosEntrada = 0;
                        while (((dadosEntrada = IS.read()) != '\n') && (dadosEntrada != -1)) {
                                buff.append((char)dadosEntrada);
                        }
                        if (dadosEntrada == -1) {
                                break;
                        }
                        System.out.println("CLIENTE: Mensagem recebida = " + buff.toString());
                    }
                    IS.close();
                    conexao.close();
            }catch (Exception exc){
                System.out.println(exc);
            }
        } 
} 
