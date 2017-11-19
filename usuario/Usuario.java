package usuario;

import comandos.EnviarMsg;
import comandos.ReceberMsg;

public class Usuario {
	private Servidor servidor;
	private Cliente cliente;
	private EnviarMsg enviarC;
	
	
	public Usuario(){
		this.cliente = new Cliente();
	}
	
	public void conectar(String ip){
		this.cliente.conectar(ip);
		enviarC = new EnviarMsg(this.cliente.pegarSoquete());
		new Thread(new ReceberMsg(this.cliente.pegarSoquete())).start();
	}
	
	public void iniciarServidor(){
		this.servidor = new Servidor();
		this.servidor.iniciar();
	}
	
	public void enviarMsg(String msg){
		this.enviarC.enviar(msg);
	}
}
