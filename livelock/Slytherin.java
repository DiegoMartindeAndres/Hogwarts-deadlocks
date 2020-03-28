package es.upm.dit.adsw.hogwarts.livelock;

import java.util.concurrent.locks.Lock;

public class Slytherin extends Thread {

	private String nombre;
	private Lock cerrojo1;
	private Lock cerrojo2;
	private int sueño;

	public Slytherin(String nombre, Lock cerrojo1, Lock cerrojo2, int sueño) {
		this.nombre = "🐍Slytherin:\t" + nombre;
		this.cerrojo1 = cerrojo1;
		this.cerrojo2 = cerrojo2;
		this.sueño = sueño;
	}

	@Override
	public void run() {

		while (true) { // no haría falta ponerlo porque se bloquearía siempre.
			try {
				while (!this.cerrojo2.tryLock()) {
					System.out.println(this.nombre + " : \t espera al cerrojo 2.");
					Thread.sleep(this.sueño);
				}
				System.out.println(this.nombre + " : \t ha obtenido el cerrojo 2.");

				while (!this.cerrojo1.tryLock()) {
					System.out.println(this.nombre + " : \t espera al cerrojo 1.");
					Thread.sleep(this.sueño);
				}
				System.out.println(this.nombre + " : \t ha obtenido el cerrojo 1.");

				System.out.println(this.nombre + " : \t entra en la sección crítica y LANZA EL HECHIZO!");
				this.cerrojo1.unlock();
				System.out.println(this.nombre + " : \t devuelve el cerrojo 1.");
				this.cerrojo2.unlock();
				System.out.println(this.nombre + " : \t devuelve el cerrojo 2.");

			} catch (InterruptedException e) {
				// can be ignored here for this sample
			}
		}
	}
}
