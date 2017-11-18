package dados;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;

public class ReceberArquivo{

	int tamanhoArquivo = 13107200; //tamanho varável para o arquivo.
	int bytesLidos; //estatísticas dos bytes lidos do inputStream.
	int total = 0; //total de bytes lidos
	private Socket soquete;
	private byte[] array_byte;
	private InputStream is;
	
	public ReceberArquivo(Socket soquete){
		this.soquete = soquete; //estabele uma conexão com o endereço ip do outro computador (nesse caso local) e porta escolhida.
		try {
			this.is = this.soquete.getInputStream();
			this.array_byte = new byte[tamanhoArquivo];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //coletar toda a informação passando pelo conexão.
	}

	public void baixar() throws SocketException {
		try {
			FileOutputStream fos = new FileOutputStream("/home/CIN/ssj2/Downloads/b.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos); //escreve os dados adquiridos no arquivo especificado.
			this.bytesLidos = this.is.read(this.array_byte, 0, this.array_byte.length); //dados lidos são armazenados em array_ byte.
			this.total = this.bytesLidos;
			do {
				this.bytesLidos = this.is.read(this.array_byte, this.total, (this.array_byte.length - this.total)); //Lê novamente do inputStream, e se bytesLidos >= 0, o total será atualizado
				System.out.println("baixando...");
				//new Thread(new Rtt(this.soquete.getInetAddress().getHostAddress())).run();
				if (bytesLidos >= 0){
					total = total + bytesLidos;
				}
			} while(bytesLidos > -1); 
			bos.write(array_byte, 0, total); //após todos os dados serem lidos, os dados são escritos para o arquivo especificado e os recursos serão fechados.
			bos.flush();
			bos.close();
			System.out.println("download completo");
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
