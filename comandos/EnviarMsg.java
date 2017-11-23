package comandos;

/*
 * envia mensagens de comando
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class EnviarMsg{

	private Socket soquete;
	private PrintStream ps;

	public EnviarMsg(Socket soquete){
		this.soquete = soquete;
		try {
			this.ps = new PrintStream(this.soquete.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enviar(String msg) {
		ps.println(msg);
		System.out.println("mensagem enviada para " + this.soquete.getInetAddress().getHostAddress());
	}
}
