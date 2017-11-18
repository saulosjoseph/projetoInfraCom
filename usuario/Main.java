package usuario;

public class Main { 
	/**
	 * @param args	
	 */
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();		
		usuario1.conectar("localhost");
		usuario1.enviarMsg("baixar");
	}

}
