package usuario;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//import funções.EnviarArquivo;
//import funções.EnviarMsg;
import funções.ReceberMsg;

public class Servidor implements Runnable{

	private ServerSocket server;
	private Socket soquete;
	private int porta = 6969;
	//private EnviarMsg enviar;
	
	public void iniciar(){
		new Thread(this).start();
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			server = new ServerSocket(this.porta);
			System.out.println("esperando cliente...");
			while(true) {
				this.soquete = server.accept(); //espera por qualquer conexão de clientes.
				System.out.println("------------------------------");
				System.out.println(this.soquete.getInetAddress().getHostAddress() + " conectado");
				//enviar = new EnviarMsg(this.soquete);
				//enviar.enviar("ajuda() para mostrar ajuda");
				//new EnviarArquivo(this.soquete).enviar();
				new Thread(new ReceberMsg(this.soquete)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
	}

}
