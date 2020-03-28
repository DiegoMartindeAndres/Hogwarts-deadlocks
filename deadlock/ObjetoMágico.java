package es.upm.dit.adsw.hogwarts.deadlock;

public class ObjetoMágico {

	
	private boolean ocupado;
	private String nombre;

	public ObjetoMágico(String nombre) {
		this.ocupado = false;
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public boolean estaOcupado(){
		return this.ocupado;
	}
	
	public void ocupar(){
		this.ocupado = true;
	}
	
	public void desocupar(){
		this.ocupado = false;
	}	
	
}
