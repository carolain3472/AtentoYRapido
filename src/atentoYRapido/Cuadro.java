
/*
 * Programaci�n Interactiva. 
 * Autor: Carolain Jimenez Bedoya - 2071368 
 * Mini-proyecto 1: Juego Atento y Rapido. 
 */

package atentoYRapido;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Cuadro. Es la clase que me indica los colores con los que estaran representados los cuadros.
 */
public class Cuadro {  

	/** The color principal. */
	private int colorPrincipal; //Es el color que se guarda en cada cuadro




	/**
	 * Instantiates a new cuadro. Es el constructor de la clase, donde se inicializan los atributos.
	 */
	public Cuadro () {  
		colorPrincipal=0;

	}

	/**
	 * Cambiar color. Metodo que escoge un numero aleatorio entre 1 y 24
	 */
	public void cambiarColor() { 
		Random aleatorio = new Random();
		colorPrincipal= aleatorio.nextInt(24)+1;
	}



	/**
	 * Gets the color. Metodo que guarda el numero aleatorio de la funcion anterior.
	 *
	 * @return the color. Retorna un numero entre el 1 y el 24.
	 */
	public int getColor(){ 
		return colorPrincipal;
	}

	/**
	 * Total dise�os. Guarda el dise�o que se elija del numero del 1 al 24 eliminando los numeros repetidos. 
	 *
	 * @param eseDise�o the ese dise�o
	 */
	public void totalDise�os(int eseDise�o) { 
		// TODO Auto-generated method stub
		colorPrincipal=eseDise�o;

	}


}






