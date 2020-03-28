package es.upm.dit.adsw.hogwarts.deadlock;

/**
 * Sombrero
 * 
 * @author diegomartin
 * @version 2020.03.20
 */
public class Sombrero extends ObjetoMágico {

	public Sombrero(String nombre) {
		super(nombre);
	}


	
	/**
	 * Poner el sobrero
	 */
	public synchronized void poner() {
		try {
			while (this.estaOcupado())
				wait();
		} catch (InterruptedException ignored) {
		}
		System.out.println("Sombrero " + this.getNombre() + " ocupado");
		this.ocupar();
	}

	/**
	 * Quitar el sombrero
	 */
	public synchronized void quitar() {
		this.desocupar();;
		System.out.println("Sombrero " + this.getNombre() + " libre");
		notifyAll();
	}
}