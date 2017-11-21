package funcoes;


/* 
 * salva o horario com precisão de milisegundos.
 * checa se o endereço de interesse está acessível.
 * salva o novo horário com precisão de milisegundos.
 * subtrai o segundo horário do primeiro e retorna o resultado.
 */


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

public class Rtt{
	
	private long fim;
	private long inicio;
	private InetAddress inet;
	
	public Rtt(String ip){
		try {
			this.inet = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long ping() {
		// TODO Auto-generated method stub
		try {
			
			this.inicio = new GregorianCalendar().getTimeInMillis();	
			
			if (this.inet.isReachable(5000)){
				this.fim = new GregorianCalendar().getTimeInMillis();
				return ((this.fim - this.inicio));
			}
		} catch ( Exception e ) {
		}
		return 0;		
	}

}
