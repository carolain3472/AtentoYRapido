

/*
 * Programaci�n Interactiva. 
 * Autor: Carolain Jimenez Bedoya - 2071368 
 * Mini-proyecto 1: Juego Atento y Rapido. 
 */


package atentoYRapido;

import java.awt.EventQueue;



// TODO: Auto-generated Javadoc
/**
 * The Class PrincipalAtentoYRapido.Clase que contiene el m�todo main, e inicia el programa. 
 */
public class PrincipalAtentoYRapido { //Es la clase principal, su objetivo es ejecutar la GUI 

	/**
	 * The main method.  M�todo principal en Java.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run () {

				VistaGUIAtentoYRapido myVista= new VistaGUIAtentoYRapido();
			}
		});	

	}

}
