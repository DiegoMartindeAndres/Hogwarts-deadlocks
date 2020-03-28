package es.upm.dit.adsw.hogwarts.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PruebaHogwartsLivelock {  
	
    private static final Lock cerrojo1 = new ReentrantLock();
    private static final Lock cerrojo2 = new ReentrantLock();
    
	  public static void main(String[] args) {  
	    
	    Gryffindor harryPotter = new Gryffindor("Harry Potter", cerrojo1, cerrojo2,0);  
	    //Gryffindor hermione = new Gryffindor("Hermione Granger", cerrojo1, cerrojo2,100);
	    
	    Slytherin dracoMalfoy = new Slytherin("Draco Malfoy", cerrojo1, cerrojo2,0);
	    	    
	    harryPotter.start();  
	    dracoMalfoy.start();
	    //hermione.start();

	  }  
	}  