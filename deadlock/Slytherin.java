package es.upm.dit.adsw.hogwarts.deadlock;

public class Slytherin extends Thread {

	private String nombre;
	private Sombrero miSombrero;
	private Varita miVarita;
	private int sueño;

	public Slytherin(String nombre, Sombrero gorro, Varita miVarita, int sueño) {
		this.nombre = "🐍 Slytherin:\t" + nombre;
		this.miSombrero = gorro;
		this.miVarita = miVarita;
		this.sueño = sueño;
	}

	@Override
	public void run() {
		while (true) {
			miVarita.coger();
			System.out.println(this.nombre + " usa varita:\t" + this.miVarita.getNombre());

			try {
				Thread.sleep(this.sueño);
			} catch (Exception ignored) {
			}

			miSombrero.poner();
			System.out.println(this.nombre + " se pone el sombrero:\t" + this.miSombrero.getNombre());

			try {
				System.out.println(this.nombre + "\t:entra en la sección crítica y LANZA EL HECHIZO!");
				Thread.sleep(this.sueño);
			} catch (Exception ignored) {
			}
			miVarita.soltar();
			miSombrero.quitar();
		}
	}
}
