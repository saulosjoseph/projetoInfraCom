package servidor;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.net.Socket;            //classes socket para definar porta de conexão com o servidor e aceitar tentativas de conexão por parte do cliente.
import java.net.ServerSocket;    


public class Servidor implements Runnable{

	private ServerSocket server;
	private Socket soquete;
	private int porta;

	public Servidor(int porta) {
		this.porta = porta;
	}
	
	public void start() {
		try {
			server = new ServerSocket(this.porta);
			while(true) {
				this.soquete = server.accept(); //espera por qualquer conexão de clientes.
				new Thread(this).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Conexão aceita: " + soquete);
			File transferir = new File("/home/saulosj/eclipse-workspace/Transfer/src/testes/teste.txt.7z"); //define o documento a ser transferido.
			byte[] array_byte = new byte[(int)transferir.length()]; //cria um array de bytes com o tamanho(em bytes) do arquivo a ser transferido para armazenar dados temporários.
			FileInputStream fin = new FileInputStream(transferir); //define para ler os dados contidos no arquivo a ser transferido.
			BufferedInputStream bin = new BufferedInputStream(fin);
			bin.read(array_byte, 0, array_byte.length); //após as definições anteriores, lê o arquivo a ser transferido e array_byte será preenchido com os dados dele.

			OutputStream os = soquete.getOutputStream(); //cria um canal para se comunicar com o cliente.
			System.out.println("enviando arquivo...");
			os.write(array_byte, 0, array_byte.length); //escreve os dados armazenados no array_byte no OutputStream (para que seja enviado para o cliente).
			os.flush();

			soquete.close(); //fecha a porta.
			bin.close();
			System.out.println("Transferência completa.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Servidor servidor = new Servidor(13000);
		servidor.start();
	}

}


