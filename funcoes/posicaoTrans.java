package funcoes;

public class posicaoTrans {
	private long tamTotal;;
	
	public posicaoTrans(long total){
		this.tamTotal = total;
	}
	
	public long atual(long atual){
		return (atual*100)/this.tamTotal;
	}
}
