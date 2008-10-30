package br.com.unibratec.telas;

import java.io.IOException;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Image;

public class Alerta extends Alert {
	
	private Image img;
	
	private static Alert instance;

	public static Alert getInstance(String title) {
		if (instance == null) {
			instance = new Alerta(title);
		}
		return instance;
	}

	private Alerta(String title) {
		super(title);
		
		try {
			img = Image.createImage("/alert.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		setImage(img);
		setTimeout(4000);
	}

}
