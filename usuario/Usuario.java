
package usuario;

import comandos.EnviarMsg;
import comandos.ReceberMsg;

public class Usuario {
	private Servidor servidor;
	private Cliente cliente;
	private EnviarMsg enviarC;
	private int tamanho_arquivo;
	
	public Usuario(){
		this.cliente = new Cliente();
	}
	
	public void conectar(String ip, int porta, String caminho) {
		this.cliente.conectar(ip, porta);
		enviarC = new EnviarMsg(this.cliente.pegarSoquete());
		ReceberMsg receber = new ReceberMsg(this.cliente.pegarSoquete());
		receber.setCaminho(caminho);
		new Thread(receber).start();
		tamanho_arquivo = receber.getTamanho();
		this.cliente.setTamanho(tamanho_arquivo);
	}
	
	public int getTamanho() { //só pode ser usado após o conectar
		return this.tamanho_arquivo;
	}
	
	public void iniciarServidor(int porta, String caminho){
		this.servidor = new Servidor(porta, caminho);
		this.servidor.iniciar();
	}
	
	public void enviarMsg(String msg){
		this.enviarC.enviar(msg);
	}
}
