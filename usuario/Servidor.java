package usuario;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import comandos.ReceberMsg;


public class Servidor implements Runnable{

	private ServerSocket server;
	private Socket soquete;
	private int porta;
	private String caminho;
	
	public Servidor(int porta, String caminho) {
		this.porta = porta;
		this.caminho = caminho;
	}
	
	public void iniciar(){
		new Thread(this).start();
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			server = new ServerSocket(this.porta);
			System.out.println("esperando cliente...");
			while(true) {
				this.soquete = server.accept(); //espera por qualquer conexao de clientes.
				System.out.println("------------------------------");
				System.out.println(this.soquete.getInetAddress().getHostAddress() + " conectado");
				ReceberMsg receber = new ReceberMsg(this.soquete); //classe que espera a msg "baixar" para confirmar o pedido de download.
				receber.setCaminho(this.caminho); //especifica o caminho onde est� o arquivo a ser enviado.
				new Thread(receber).start(); //inicia a thread para enviar ou n�o o arquivo.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
	}

}
