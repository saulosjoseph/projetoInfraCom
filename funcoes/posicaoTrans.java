package funcoes;

/*
 * inicia o objeto com o tamanho total do arquivo a ser baixado.
 * 
 */

public class posicaoTrans {
	private long tamTotal;;
	
	//inicia o objeto com o tamanho total do arquivo a ser baixado.	
	public posicaoTrans(long total){
		this.tamTotal = total;
	}
	
	/*
	 * usa a quantidade de bits já salvos no buffer como parametro.
	 * retorna a posição atual em %.
	 */
	public long atual(long atual){
		return (atual*100)/this.tamTotal;
	}
}
