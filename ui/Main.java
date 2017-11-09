package ui;

import servidor.Servidor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor servidor = new Servidor(13000);
		servidor.start();	
	}

}
