package usuario;

public class Main { 
	/**
	 * @param args	
	 */
	public static void main(String[] args) {
		int porta = 6969;
		String caminho = "C:\\Users\\alpsi\\Desktop\\teste2\\copia.txt";
		
		Usuario usuario1 = new Usuario();		
		usuario1.conectar("localhost", porta, caminho);
		usuario1.enviarMsg("baixar");
	}

}
