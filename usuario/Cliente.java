package usuario;

import java.io.IOException;
import java.net.Socket;


public class Cliente {

	private Socket soquete;

	public void conectar(String ip, int porta) {
		try {
			this.soquete = new Socket (ip, porta); //estabele uma conexão com o endereço ip do outro computador (nesse caso local) e porta escolhida.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Socket pegarSoquete(){
		return this.soquete;
	}


}
