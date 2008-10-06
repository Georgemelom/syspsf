package br.com.unibratec;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;
import br.com.unibratec.telas.Login;

public class ProjetoMIDLet extends MIDlet {
	
	private boolean started;
	
	private UIController controller;
	

	public ProjetoMIDLet() {
		controller = UIController.createInstance(this);
	}

	public void destroyApp(boolean arg0) {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		if (!started) {
			controller.setCurrent(Login.getInstance("LOGIN"));
		}
	}
	
	

}
