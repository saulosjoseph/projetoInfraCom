package comandos;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import dados.EnviarArquivo;
import dados.ReceberArquivo;

/*
 * recebe mensagens de comando
 */

public class ReceberMsg implements Runnable{

	private InputStream input;
	private Socket soquete;
	private Scanner s;
	private String msg;
	private EnviarArquivo enviar;
	private String caminho;
	private int tamanho_arquivo;
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public  int getTamanho() { //retorna tamanho do arquivo
		return this.tamanho_arquivo;
	}
	
	public ReceberMsg(Socket soquete){
		this.soquete = soquete;
		try {
			this.input = this.soquete.getInputStream();
			this.s = new Scanner(this.input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * fica "ouvindo" a conexão de comandos.
	 * ao chegar mensagens checa se elas estão protocoladas.
	 * se estiverem protocoladas, seguem o protocolo.
	 * caso contrário, infere-se que a mensagem seja o tamanho do arquivo especificado para download e segue o protocolo.
	 */
	public void run() {
		// TODO Auto-generated method stub
		while(s.hasNextLine()) {
			this.msg = s.nextLine();
			if(msg.equals("ok")){
				try {
					this.enviar.enviar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (msg.equals("baixar")){
				this.enviar = new EnviarArquivo(this.soquete);
				this.enviar.preparar(this.caminho);
				this.tamanho_arquivo = this.enviar.getTamanho();
			} else {
				try {
					new EnviarMsg(this.soquete).enviar("ok");
					new ReceberArquivo(this.soquete, msg, this.caminho).baixar();
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.imprimir("recebido de " + this.soquete.getInetAddress().getHostAddress() + ": " + this.msg);
		}
	}
	
	public void imprimir(String msg){
		System.out.println(msg);
	}

}
