package br.com.unibratec;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;
import br.com.unibratec.telas.Login;

public class ProjetoMIDLet extends MIDlet implements CommandListener{

	private boolean started;

	private UIController controller;

	public ProjetoMIDLet() {
		controller = UIController.createInstance(this);
	}

	protected void startApp() throws MIDletStateChangeException {
		if (!started) {
			controller.setCurrent(Login.getInstance("LOGIN"));
		}
	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	public void destroyApp(boolean arg0) {
		// TODO Auto-generated method stub

	}
	
	public void commandAction(Command arg0, Displayable arg1) {
		// TODO Auto-generated method stub
		
	}
}
