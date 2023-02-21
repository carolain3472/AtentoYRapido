
/*
 * Programación Interactiva. 
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
 * The Class AtentoYRapidoMando. Es la clase donde se establecen las reglas del juego. 
 */
public class AtentoYRapidoMando {



	/** The punto. */
	private int punto,  vida, acumuladorAcierto, acumuladorFallo, ronda; //Establece los enteros del juego

	/** The comparar. */
	private boolean comparar;//Booleano que compara cuadros dentro de un arrayList

	/** The cuadros. */
	private ArrayList<Cuadro> cuadros = new ArrayList<Cuadro>(); //ArrayList de cuadros

	/** The todos diseños. */
	private ArrayList<Integer> todosDiseños = new ArrayList<Integer>(); //ArrayList de imagenes 



	/**
	 * Instantiates a new atento Y rapido mando. Es el constructor de la clase, donde se inicializan los atributos
	 */
	public AtentoYRapidoMando() {  

		vida = 3;
		punto=0;
		ronda=1;
		acumuladorFallo=0;
		acumuladorAcierto=0;

		for(int i=0;i<3; i++ ) { //inician siendo 3 cuadros dentro del juego
			Cuadro nuevoCuadro= new Cuadro();
			cuadros.add(nuevoCuadro);

		}


		for(int i=1;i<=24; i++ ) { //Son en total 24 imagenes 
			todosDiseños.add(i);

		}

	}


	/**
	 * Comparar acierto false. Funcion que determina si dentro dl array de cuadrados exiten dos valores iguales
	 *
	 * @return true, if successful, retorna un booleano dependiendo si hay o no cuadros iguales
	 */
	public boolean compararAciertoFalse(){

		for(int cuadroInicial = 0; cuadroInicial < cuadros.size(); cuadroInicial++) {

			for(int cuadroComparador =cuadroInicial+1; cuadroComparador < cuadros.size(); cuadroComparador++) { 

				if(cuadros.get(cuadroInicial).getColor() == cuadros.get(cuadroComparador).getColor()) {
					return true;

				}
			}
		}		
		return false;
	}




	/**
	 * Verificar. Funcion que determina los valores del punto, la vida dependiendo si hubo coincidencia en los cuadros, ademas de determinar cuando el usuario acierta y cuando falla. 
	 */
	public void verificar(){ 


		comparar=compararAciertoFalse();

		if (comparar==true) {

			acumuladorAcierto= acumuladorAcierto+ 1;
			punto= 5*acumuladorAcierto;

		}else {

			acumuladorFallo=acumuladorFallo+1;
			vida= 3-acumuladorFallo;
		}	
	}



	/**
	 * Cambiar colores. Es la funcion que determina los numeros disponibles para determinar una imagen que no se haya repetido antes y almacenar los numeros disponibles dentro de un array
	 */
	public void cambiarColores() { 


		cuadros.get(0).cambiarColor();   //inicia con el primer cuadro un numero aleatorio
		int cualDiseño = cuadros.get(0).getColor();
		todosDiseños.remove(todosDiseños.indexOf(cualDiseño)); //Elimina el numero del array


		for(int i = 1; i<cuadros.size(); i++) {

			cuadros.get(i).cambiarColor();
			int eseDiseño = cuadros.get(i).getColor(); //Obtiene el segundo numero pero con la condicion de que este no puede ser el primero
			if(todosDiseños.contains(eseDiseño)) {
				todosDiseños.remove(todosDiseños.indexOf(eseDiseño)); //elimina dicho numero del array
			}else {
				while(!todosDiseños.contains(eseDiseño)) {   
					cuadros.get(i).cambiarColor();    //Busca un numero disponible
					eseDiseño= cuadros.get(i).getColor();
				}

				todosDiseños.remove(todosDiseños.indexOf(eseDiseño)); 
				cuadros.get(i).totalDiseños(eseDiseño);

			}

		}

		todosDiseños.clear(); //Elimina los numeros no disponibles 

		for (int i=1;i<25; i++) {

			todosDiseños.add(i); //Guarda dentro de un array los numeros disponibles 
		}
	}






	/**
	 * Gets the aciertos. Devuelve el total de aciertos
	 *
	 * @return the aciertos Retorna un numero de aciertos
	 */
	public int getAciertos() { 

		return acumuladorAcierto;
	}




	/**
	 * Calcular ronda. Establece el numero de la ronda en la que se encuentra el usuario
	 *
	 * @return the int
	 */
	public int calcularRonda() { 
		ronda= acumuladorAcierto + acumuladorFallo;
		return ronda;
	}



	/**
	 * Gets the fallos. Devuelve el total de fallos
	 *
	 * @return the fallos. Retorna el numero de fallos
	 */
	public int getFallos() { //Devuelve el total de fallos
		return acumuladorFallo;
	}


	/**
	 * Gets the punto. Devuelve el punto, por cada acierto son 5 puntos 
	 *
	 * @return the punto, retorna un numero de puntuación
	 */
	public int getPunto() { 
		return punto;

	}


	/**
	 * Gets the vidas. Obtiene las vidas que tiene el usuario
	 *
	 * @return the vidas. Retorna un numero del 0 al 3
	 */
	public int getVidas() { //Devuelve el valor de las vidas
		return vida;
	}




	/**
	 * Gets the color principal. Funcion que guarda las posiciones de cada cuadro 
	 * @return the color principal 
	 */
	public ArrayList<Cuadro> getColorPrincipal() { 
		return cuadros;

	}

	/**
	 * Reiniciar juego. Funcion que establece las condiciones iniciales del juego
	 */
	public void reiniciarJuego() { 
		vida = 3;
		punto=0;
		ronda=1;
		acumuladorFallo=0;
		acumuladorAcierto=0;

		cuadros.clear();
		for(int i=0;i<3; i++ ) {
			Cuadro nuevoCuadro= new Cuadro();
			cuadros.add(nuevoCuadro);
		}
	}



	/**
	 * Añadir cuadros. Funcion que añade más cuadros al arrayList de cuadros
	 */
	public void añadirCuadros() { 
		Cuadro otroCuadro= new Cuadro();
		cuadros.add(otroCuadro);
	}


	/**
	 * Eliminar una vida Y fallo. Función que elimina una vida y aumenta un fallo
	 */
	public void eliminarUnaVidaYFallo() {
		acumuladorFallo=acumuladorFallo+1;
		vida= 3-acumuladorFallo;

	}






}
	
 