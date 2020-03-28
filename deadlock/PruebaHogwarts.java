package es.upm.dit.adsw.hogwarts.deadlock;

public class PruebaHogwarts {  
	  public static void main(String[] args) {  
	    Varita varitaSnape = new Varita("de Snape");
	    Varita varitaDumble = new Varita("de Dumbledore");
	    
	    Sombrero seleccionador = new Sombrero("Seleccionador 🎓");
	    Sombrero cups = new Sombrero("Cups 🧢");
	    
	    Gryffindor harryPotter = new Gryffindor("Harry Potter", seleccionador, varitaDumble,100);  
	    Slytherin dracoMalfoy = new Slytherin("Draco Malfoy", seleccionador, varitaDumble,100);
	    Slytherin volde  = new Slytherin("Lord Voldemort", cups, varitaDumble,100);
	    
	    
	    harryPotter.start();  
	    dracoMalfoy.start();  
	    volde.start();
	  }  
	}  