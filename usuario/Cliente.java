package usuario;

import java.io.IOException;
import java.net.Socket;


public class Cliente {

	private Socket soquete;
	private int tamanho_arquivo;
	
	public void setTamanho(int tamanho) {
		this.tamanho_arquivo = tamanho;
	}
	
	public int getTamanho() {
		return this.tamanho_arquivo;
	}

	//estabele uma conexao com o endereco ip do outro computador e porta escolhida.
	public void conectar(String ip, int porta) {
		try {
			this.soquete = new Socket (ip, porta); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Socket pegarSoquete(){
		return this.soquete;
	}


}
