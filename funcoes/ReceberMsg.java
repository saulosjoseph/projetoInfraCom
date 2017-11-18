package funcoes;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReceberMsg implements Runnable{

	private InputStream input;
	private Socket soquete;
	private Scanner s;
	private String msg;

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
	public void run() {
		// TODO Auto-generated method stub
		while(s.hasNextLine()) {
			this.msg = s.nextLine();
			if(msg.equals("baixar")){
				new EnviarArquivo(this.soquete).enviar();
			}
			this.imprimir("recebido de " + this.soquete.getInetAddress().getHostAddress() + " : " + this.msg);
		}
	}
	
	public void imprimir(String msg){
		System.out.println(msg);
	}

}
