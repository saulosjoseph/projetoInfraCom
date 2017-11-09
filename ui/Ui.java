package ui;


import cliente.Cliente;

public class Ui {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente client = new Cliente();
		client.conectar("127.0.0.1", 13000);
		client.baixar();		
	}
}
