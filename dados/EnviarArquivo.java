package dados;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class EnviarArquivo{

	private Socket soquete;

	public EnviarArquivo(Socket soquete){
		this.soquete = soquete;
	}

	public void enviar() {
		// TODO Auto-generated method stub
		try {
			File transferir = new File("/home/CIN/ssj2/Downloads/a.pdf"); //define o documento a ser transferido.
			byte[] array_byte = new byte[(int)transferir.length()]; //cria um array de bytes com o tamanho(em bytes) do arquivo a ser transferido para armazenar dados temporários.
			FileInputStream fin = new FileInputStream(transferir); //define para ler os dados contidos no arquivo a ser transferido.
			BufferedInputStream bin = new BufferedInputStream(fin);
			bin.read(array_byte, 0, array_byte.length); //após as definições anteriores, lê o arquivo a ser transferido e array_byte será preenchido com os dados dele.

			OutputStream os = soquete.getOutputStream(); //cria um canal para se comunicar com o cliente.
			os.write(array_byte, 0, array_byte.length); //escreve os dados armazenados no array_byte no OutputStream (para que seja enviado para o cliente).
			os.flush();

			soquete.close(); //fecha a porta.
			bin.close();
			System.out.println("arquivo enviado para " + this.soquete.getInetAddress().getHostAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
