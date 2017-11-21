package dados;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import comandos.EnviarMsg;

import funcoes.Rtt;
import funcoes.posicaoTrans;

public class EnviarArquivo{

	private Socket soquete;
	private Rtt ping;
	private File arquivo;
	private int tamanho;
	private byte[] array_byte;
	private FileInputStream fin;
	private DataOutputStream dos;
	private posicaoTrans posi;

	public EnviarArquivo(Socket soquete){
		this.soquete = soquete;
	}

	public void preparar(String caminho) { //necessita que o caminho para o arquivo seja especificado.
		// TODO Auto-generated method stub
		try {
			this.arquivo = new File(caminho); //define o documento a ser transferido.
			this.tamanho = (int)this.arquivo.length(); //define o tamanho do arquivo (em bytes)
			this.array_byte = new byte[this.tamanho]; //cria um array de bytes com o tamanho(em bytes) do arquivo a ser transferido para armazenar dados temporários.
			this.fin = new FileInputStream(this.arquivo); //define para ler os dados contidos no arquivo a ser transferido.
			this.dos = new DataOutputStream(this.soquete.getOutputStream());
			this.ping = new Rtt(this.soquete.getInetAddress().getHostAddress());
			
			//envia tamanho do arquivo para o cliente
			new EnviarMsg(this.soquete).enviar(String.valueOf(this.tamanho));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getTamanho() { //retorna o  tamanho do arquivo
		return this.tamanho;
	}

	public void enviar() throws IOException{

		int bytesLidos = 0; 	        	        
		long totalLido = 0;

		this.posi = new posicaoTrans((int)this.arquivo.length());

		while ((bytesLidos=fin.read(array_byte)) != -1) {
			dos.write(this.array_byte, 0, bytesLidos);
			totalLido += bytesLidos;
			System.out.println("ping: "+ping.ping());
			System.out.println(posi.atual(totalLido)+ "% transferido");
		}
		
		fin.close();
		dos.close(); 
		System.out.println("Arquivo transferido com sucesso.");
	}

}
