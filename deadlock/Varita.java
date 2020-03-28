package es.upm.dit.adsw.hogwarts.deadlock;

/**
 * Varita
 * 
 * @author diegomartin
 * @version 2020.03.20
 */
public class Varita extends ObjetoMágico{


	/**
	 * @param nombre 
	 */
	public Varita(String nombre) {
		super(nombre);
	}

	/**
	 * Coger varita
	 */
	public synchronized void coger() {
		try {
			while (this.estaOcupado())
				wait();
		} catch (InterruptedException ignored) {
		}
		System.out.println("Varita " + this.getNombre() + " ha sido cogida.");
		this.ocupar();;
	}

	/**
	 * Soltar varita
	 */
	public synchronized void soltar() {
		this.desocupar();;
		System.out.println("Varita " + this.getNombre() + " ha sido soltada.");
		notifyAll();
	}
}