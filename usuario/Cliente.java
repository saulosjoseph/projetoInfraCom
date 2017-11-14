package usuario;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import funções.*;

public class Cliente {

	private Socket soquete;
	private int porta = 6969;
	//private EnviarMsg enviar;
	//private ReceberMsg receber;
	
	public void conectar(String ip) {
		try {
			this.soquete = new Socket (ip, porta); //estabele uma conexão com o endereço ip do outro computador (nesse caso local) e porta escolhida.
			//enviar = new EnviarMsg(this.soquete);
			//receber = new ReceberMsg(this.soquete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public void enviarMsg(String msg){
	//	enviar.enviar(msg);
	//}
	
	public void baixar(){
		try {
			new ReceberArquivo(this.soquete).baixar();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Socket pegarSoquete(){
		return this.soquete;
	}


}
