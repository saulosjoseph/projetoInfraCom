package cliente;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket; //para definir o endereço ip e a porta do server.

public class Cliente {

	int tamanhoArquivo = 220525; //tamanho varável para o arquivo.
	int bytesLidos; //estatísticas dos bytes lidos do inputStream.
	int total = 0; //total de bytes lidos
	private Socket soquete;
	private byte[] array_byte;
	private InputStream is;

	public Cliente() {
	}

	public void conectar(String ip, int porta) {
		try {
			this.soquete = new Socket (ip, porta); //estabele uma conexão com o endereço ip do outro computador (nesse caso local) e porta escolhida.
			this.array_byte = new byte[tamanhoArquivo]; //agirá como um buffer para armazenar dados temporários.
			this.is = soquete.getInputStream(); //coletar toda a informação passando pelo conexão.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void baixar() {
		try {
			FileOutputStream fos = new FileOutputStream("/home/saulosj/eclipse-workspace/Transfer/src/testes/recebidos/teste.txt.7z");
			BufferedOutputStream bos = new BufferedOutputStream(fos); //escreve os dados adquiridos no arquivo especificado.
			bytesLidos = is.read(array_byte, 0, array_byte.length); //dados lidos são armazenados em array_ byte.
			total = bytesLidos;		
			do {
				bytesLidos = is.read(array_byte, total, (array_byte.length - total)); //Lê novamente do inputStream, e se bytesLidos >= 0, o total será atualizado
				if (bytesLidos >= 0){
					total = total + bytesLidos;
				}
			} while(bytesLidos > -1); 
			bos.write(array_byte, 0, total); //após todos os dados serem lidos, os dados são escritos para o arquivo especificado e os recursos serão fechados.
			bos.flush();
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //aponta para o arquivo onde serão armazenados os dados copiados do servidor.
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void desconectar() {
		try {
			this.soquete.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}


