package br.com.unibratec.telas;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;

import br.com.unibratec.core.UIController;

public class Paciente extends MIDlet implements CommandListener {
	
	private TextField pcNome;
	private TextField pcCns;
	private TextField pcDtNasc;
	private List pcSexo;
	private TextField pcEndereco;
	private TextField pcCidade;
	private TextField pcLocalidade;
		
	private Command cmd_sair;
	private Command cmd_ok;
	private Command cmd_voltar;

	//Novo
    private RecordStore rs = null;
    private Form telaInicial, adicionaReg;
    private Display display;
    private Alert alerta;
    
   //fim novo
    
    
	private static Paciente instance;

	public static Paciente getInstance(String title) {
		if (instance == null) {
			instance = new Paciente(title);
		}
		return instance;
	}
	
	

	private Paciente(String title) {
		super();

		pcNome = new TextField("Nome: ", "", 20, TextField.ANY);
		pcCns = new TextField("CNS: ", "", 12, TextField.ANY);
		pcDtNasc = new TextField("Data Nasc.: ", "", 10, TextField.ANY);
		pcSexo = new List("Masculino",List.EXCLUSIVE);
		pcSexo = new List("Feminino",List.EXCLUSIVE);
		pcEndereco = new TextField("Endereço: ", "", 20, TextField.ANY);
		pcCidade = new TextField("Cidade: ", "", 20, TextField.ANY);
		pcLocalidade = new TextField("Localidade: ", "", 20, TextField.ANY);
	
		append(pcNome);
		append(pcCns);
		append(pcDtNasc);
		append(pcEndereco);
		append(pcCidade);
		append(pcLocalidade);

		cmd_sair = new Command("sair", Command.EXIT, 1);
		cmd_voltar = new Command("voltar", Command.BACK, 1);
		cmd_ok = new Command("Ok", Command.OK, 2);

		addCommand(cmd_sair);
		addCommand(cmd_voltar);
		addCommand(cmd_ok);
		setCommandListener(this);

	}
	
	 private void append(TextField pcLocalidade2) {
		// TODO Auto-generated method stub
		
	}



	private void addCommand(Command cmd_ok2) {
		// TODO Auto-generated method stub
		
	}



	private void setCommandListener(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}



	public void startApp() {
	        try {
	            rs = RecordStore.openRecordStore("RSBpad", true );
	            rs.addRecordListener(new testeRecordListener());
	          }
	        catch (Exception exc){
	          mostrarAlerta("Erro ao abrir o RecordStore",exc.toString());
	          }
	        display.setCurrent(telaInicial);
	   }

	 public void pauseApp(){
	   }

	 public void destroyApp( boolean unconditional ) {
	        notifyDestroyed();
	   }
	  
	
	private void mostrarAlerta(String tipoAlerta, String msg){
	        alerta = new Alert(tipoAlerta, msg, null, AlertType.WARNING); 
	        alerta.setTimeout(Alert.FOREVER); 
	        display.setCurrent(alerta);
	   }
	 
	public class testeRecordListener implements RecordListener {
		 public void recordAdded(RecordStore recordStore, int recordId){
		  //executado ao adicionar um registro
		  System.out.println("Registro adicionado!");
		 }
		 public void recordDeleted(RecordStore recordStore, int recordId){
		  //executado ao apagar um registro
		  System.out.println("Registro apagado!");
		 }
		 public void recordChanged(RecordStore recordStore, int recordId){
		  //executado ao modificar um registro
		  System.out.println("Registro modificado!");
		 }
		}
	
	private void adicionarRegistro(){
	    try{
	   ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
	   DataOutputStream DOS = new DataOutputStream(BAOS);
	   DOS.writeUTF(pcNome.getString());
	   DOS.writeUTF(pcCns.getString());
	   DOS.writeUTF(pcDtNasc.getString());
	   DOS.writeUTF(pcEndereco.getString());
	   DOS.writeUTF(pcLocalidade.getString());
	   DOS.writeUTF(pcSexo.getString(0));
	   
	   
	   byte [] bRec = BAOS.toByteArray();
	            rs.addRecord(bRec,0,bRec.length);
	            DOS.close();
	            BAOS.close();
	            display.setCurrent(telaInicial);
	  }
	      catch (Exception exc) {
	            mostrarAlerta("Erro em adicionar",exc.toString());
	     }
	 }
	
	

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd.equals(cmd_sair)) {
			UIController.getInstance().sair();
		} else if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
		} else if (cmd.equals(cmd_ok)) {
			UIController.getInstance().paciente();
		}
	}
}
