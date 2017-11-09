package cliente;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket; //para definir o endereço ip e a porta do server.

public class Cliente {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        int tamanhoArquivo = 2022386; //tamanho varável para o arquivo.
        int bytesLidos; //estatísticas dos bytes lidos do inputStream.
        int total = 0; //total de bytes lidos
        
        Socket soquete = new Socket ("127.0.0.1", 13000); //estabele uma conexão com o endereço ip do outro computador (nesse caso local) e porta escolhida.
        byte[] array_byte = new byte[tamanhoArquivo]; //agirá como um buffer para armazenar dados temporários.
         InputStream is = soquete.getInputStream(); //coletar toda a informação passando pelo conexão.
         FileOutputStream fos = new FileOutputStream("/home/saulosj/eclipse-workspace/Transfer/src/testes/recebidos/teste3.txt"); //aponta para o arquivo onde serão armazenados os dados copiados do servidor.
         BufferedOutputStream bos = new BufferedOutputStream(fos); //escreve os dados adquiridos no arquivo especificado.
         bytesLidos = is.read(array_byte, 0, array_byte.length); //dados lidos são armazenados em array_ byte.
         total = bytesLidos;
         
         do {
        	 bytesLidos = is.read(array_byte, total, (array_byte.length - total)); //Lê novamente do inputStream, e se bytesLidos >= 0, o total será atualizado
             if (bytesLidos >= 0){
                     total = total + bytesLidos;
             }
         } while(bytesLidos > -1); //quando bytesLidos for -1 ou menos, todos os dados foram lidos do inputStream (fim do loop);
         
         bos.write(array_byte, 0, total); //após todos os dados serem lidos, os dados são escritos para o arquivo especificado e os recursos serão fechados.
         bos.flush();
         bos.close();
         soquete.close();         
    }

}


