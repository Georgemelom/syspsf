package br.com.unibratec.core;

import javax.microedition.io.*;
import javax.microedition.midlet.*;

public class TesteConexao extends MIDlet {
    
    public TesteConexao() {}
    
    public void pauseApp(){}
    
    public void destroyApp(boolean unconditional){
        notifyDestroyed();}
    
    public void startApp(){
        try {
                 String URL ="http://bpad.com.br";
                   Connection conexao = Connector.open(URL, Connector.READ_WRITE); 
                   System.out.println("Conectado com "+URL );
                   conexao.close();
                   System.out.println("Conexao fechada");
            }
            catch( Exception exc ){
                    System.out.println("URL não pode ser aberta -"+exc );
            }
            destroyApp(true);
    }
} 
