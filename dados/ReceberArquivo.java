package dados;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;

import funcoes.Rtt;
import funcoes.posicaoTrans;

public class ReceberArquivo{

	private Socket soquete;
	private byte[] array_byte;
	private InputStream is;
	private Rtt ping;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private posicaoTrans posi;

	public ReceberArquivo(Socket soquete, String tamanho, String caminho){
		this.soquete = soquete;
		this.posi = new posicaoTrans(Long.valueOf(tamanho).longValue());
		try {
			this.is = this.soquete.getInputStream();
			this.array_byte = new byte[52428800];
			this.ping = new Rtt(this.soquete.getInetAddress().getHostAddress());
			this.fos = new FileOutputStream(caminho);
			this.bos = new BufferedOutputStream(fos); //escreve os dados adquiridos no arquivo especificado.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void baixar() throws SocketException {
		try {

	        int bytesLidos = 0; 	        	        
	        long totalLido = 0;
	        
			
			while((bytesLidos=is.read(this.array_byte))!=-1){
	            bos.write(this.array_byte, 0, bytesLidos); 
	            totalLido += bytesLidos;
	            System.out.println("ping: "+ping.ping());
	            System.out.println(posi.atual(totalLido)+ "% transferido");
			}

			bos.flush(); 
			bos.close();
			this.soquete.close();	
			System.out.println("Arquivo transferido com sucesso.");


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
