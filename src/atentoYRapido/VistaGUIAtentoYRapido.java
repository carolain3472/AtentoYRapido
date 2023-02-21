package atentoYRapido;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import misComponentes.Titulos;



// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUIAtentoYRapido.
 */
public class VistaGUIAtentoYRapido extends JFrame {
	//Atributos

	/** The panel 8. */// Se estableció una imagen por cada panel
	private JPanel zonaRecuento,zonaJuego,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8;
	
	/** The punto. */
	private JLabel cuadro1,cuadro2,cuadro3,cuadro4,cuadro5,cuadro6,cuadro7,cuadro8,vida,punto;
	
	/** The valor puntos. */
	private JTextField valorVidas,valorPuntos;
	
	/** The pulsar. */
	private JButton salir, jugar, pulsar; 
	
	/** The atento Y rapido. */
	private AtentoYRapidoMando atentoYRapido;
	
	/** The recuento. */
	private Titulos titulo,recuento;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The escucha. */
	private Escucha escucha;
	
	/** The tiempo reconocer. */ //Se establecieron 3 timers
	private Timer tiempo1,tiempoBorde,tiempoReconocer;
	
	/** The botones. */
	private String [] botones = { " Sí", "No"};


	/**
	 * Instantiates a new vista GUI atento Y rapido. Se realiza toda la interfaz grafica
	 */
	public VistaGUIAtentoYRapido() {

		initGUI();  //Donde creo los componentes gráficos

		this.setUndecorated(true);
		this.pack();
		this.setBackground(new Color (31,160,133));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	/**
	 * Inits the GUI.
	 */
	private void initGUI() {

		//Configuración de container y Layout 

		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints contenedor = new GridBagConstraints();

		//Creacion del objeto control y escucha 

		escucha = new Escucha ();
		atentoYRapido= new AtentoYRapidoMando ();

		//configurar componentes graficos 

		titulo = new Titulos("Juego Atento y Rapido", 30, new Color(31, 97, 141)); // Color.BLACK 

		contenedor.gridx=0;
		contenedor.gridy=0;
		contenedor.gridwidth=5;
		contenedor.fill= GridBagConstraints.HORIZONTAL;
		add(titulo,contenedor); //Lo adiciono a la ventana grafica

		//Boton salir 
		salir=new JButton("Salir");
		salir.addActionListener(escucha); 
		contenedor.gridx=0;
		contenedor.gridy=5;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;
		contenedor.anchor=GridBagConstraints.LAST_LINE_END;
		add(salir,contenedor);


		//recuento
		recuento= new Titulos("Puntos", 24, new Color(8,116,146));
		contenedor.gridx=1;
		contenedor.gridy=4;
		contenedor.gridwidth=4;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.HORIZONTAL;
		contenedor.anchor=GridBagConstraints.CENTER;

		add(recuento,contenedor);

		//Zona de puntos y vida
		zonaRecuento= new JPanel();
		zonaRecuento.setLayout(new GridLayout(2,2));
		vida = new JLabel("Vidas");
		punto= new JLabel("Puntos");
		valorVidas= new JTextField(2);
		valorVidas.setEditable(false); 

		valorPuntos= new JTextField(2);
		valorPuntos.setEditable(false);

		zonaRecuento.add(vida);
		zonaRecuento.add(valorVidas);
		zonaRecuento.add(punto);
		zonaRecuento.add(valorPuntos);
		zonaRecuento.setBackground(new Color (16, 161, 161));

		contenedor.gridx=1;
		contenedor.gridy=5 ;
		contenedor.gridwidth=4;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;
		contenedor.anchor=GridBagConstraints.CENTER;

		add(zonaRecuento,contenedor);


		//timer 
		tiempo1 = new Timer (3000,escucha);
		tiempoBorde= new Timer (1000,escucha);
		tiempoReconocer= new Timer (2000,escucha);


		//zonaJuego 

		zonaJuego = new JPanel();
		zonaJuego.setBackground(new Color(224, 230, 241 ));
		zonaJuego.setPreferredSize(new Dimension(850,426));
		contenedor.gridx=0;
		contenedor.gridy=1;
		contenedor.gridwidth=4;
		contenedor.gridheight=2;
		contenedor.fill= GridBagConstraints.NONE;


		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");

		cuadro1 = new JLabel (imagen);
		zonaJuego.add(cuadro1);

		cuadro2 = new JLabel (imagen);
		zonaJuego.add(cuadro2);

		cuadro3 = new JLabel (imagen);
		zonaJuego.add(cuadro3);

		cuadro4 = new JLabel (imagen);
		zonaJuego.add(cuadro4);

		cuadro5 = new JLabel (imagen);
		zonaJuego.add(cuadro5);

		cuadro6 = new JLabel (imagen);
		zonaJuego.add(cuadro6);

		cuadro7 = new JLabel (imagen);
		zonaJuego.add(cuadro7);

		cuadro8 = new JLabel (imagen);
		zonaJuego.add(cuadro8);

		zonaJuego.setVisible(true);
		add(zonaJuego,contenedor);


		//Paneles que conteneran cada cuadro	

		panel1 = new JPanel();
		panel1.setBackground(new Color(224, 230, 241 ));
		panel1.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=0;
		contenedor.gridy=1;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro1 = new JLabel (imagen);
		cuadro1.setVisible(false);
		panel1.add(cuadro1);

		add(panel1,contenedor);



		panel2= new JPanel();
		panel2.setBackground(new Color(224, 230, 241 ));
		panel2.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=1;
		contenedor.gridy=1;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro2 = new JLabel (imagen);
		cuadro2.setVisible(false);
		panel2.add(cuadro2);

		add(panel2,contenedor);



		panel3= new JPanel();
		panel3.setBackground(new Color(224, 230, 241 ));
		panel3.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=2;
		contenedor.gridy=1;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpg");
		cuadro3 = new JLabel (imagen);
		cuadro3.setVisible(false);
		panel3.add(cuadro3);

		add(panel3,contenedor);



		panel4= new JPanel();
		panel4.setBackground(new Color(224, 230, 241 ));
		panel4.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=3;
		contenedor.gridy=1;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro4 = new JLabel (imagen);
		cuadro4.setVisible(false);
		panel4.add(cuadro4);

		add(panel4,contenedor);



		panel5= new JPanel();
		panel5.setBackground(new Color(224, 230, 241 ));
		panel5.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=0;
		contenedor.gridy=2;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro5 = new JLabel (imagen);
		cuadro5.setVisible(false);
		panel5.add(cuadro5);

		add(panel5,contenedor);


		panel6= new JPanel();
		panel6.setBackground(new Color(224, 230, 241 ));
		panel6.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=1;
		contenedor.gridy=2;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro6 = new JLabel (imagen);
		cuadro6.setVisible(false);
		panel6.add(cuadro6);

		add(panel6,contenedor);


		panel7= new JPanel();
		panel7.setBackground(new Color(224, 230, 241 ));
		panel7.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=2;
		contenedor.gridy=2;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro7 = new JLabel (imagen);
		cuadro7.setVisible(false);
		panel7.add(cuadro7);

		add(panel7,contenedor);


		panel8= new JPanel();
		panel8.setBackground(new Color(224, 230, 241 ));
		panel8.setPreferredSize(new Dimension(210,215));
		contenedor.gridx=3;
		contenedor.gridy=2;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;

		imagen = new ImageIcon("src/imagenesAR1/01.jpeg");
		cuadro8 = new JLabel (imagen);
		cuadro8.setVisible(false);
		panel8.add(cuadro8);

		add(panel8,contenedor);


		//Boton acierto 

		pulsar= new JButton("PUlSAR");
		pulsar.setPreferredSize(new Dimension(140,140));
		pulsar.addActionListener(escucha);
		pulsar.setBorder(new BevelBorder(BevelBorder.RAISED));
		pulsar.setBackground(new Color( 130, 140, 190));

		contenedor.gridx=4;
		contenedor.gridy=2;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.NONE;
		add(pulsar,contenedor);


		//boton de iniciar juego

		jugar = new JButton("Jugar");
		jugar.addActionListener(escucha);
		jugar.setPreferredSize(new Dimension(120,50));
		jugar.setBackground(new Color(40, 113, 177));
		contenedor.gridx=4;
		contenedor.gridy=1;
		contenedor.gridwidth=1;
		contenedor.gridheight=1;
		contenedor.fill= GridBagConstraints.PAGE_END;
		add(jugar,contenedor);

	}

	/**
	 * The Class Escucha. La clase encargada de determinar las acciones cada que se escuche el evento
	 */
	private class Escucha implements ActionListener{
		
		/**
		 * Action performed.
		 *
		 * @param eventAction the event action
		 */
		@Override
		public void actionPerformed(ActionEvent eventAction) {

			Random aleatorio= new Random();
			int colorOtro = aleatorio.nextInt(atentoYRapido.getColorPrincipal().size());

			if (eventAction.getSource()==salir) {

				String mensaje = "Puntuación: "+ atentoYRapido.getPunto()+
						"\nAciertos: "+atentoYRapido.getAciertos()+
						"\nFallos: "+atentoYRapido.getFallos()+ "\n¿Deseas volver a jugar? ";


				int result= JOptionPane.showOptionDialog (null, mensaje, "Resultado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);

				if(result == JOptionPane.YES_OPTION) {

					inicioJuego();

					componentesIniciales();

					atentoYRapido.reiniciarJuego(); 
				}

				if(result == JOptionPane.NO_OPTION) {
					System.exit(0); 
				}

			}


			if (eventAction.getSource()==jugar) {

				zonaJuego.setVisible(false);
				jugar.setVisible(false);

				inicioJuego();

				valorVidas.setText(String.valueOf(3));


			}  else if(eventAction.getSource()==tiempo1) {

               //Cambia las imagenes cuando el tiempo se cumple 

				atentoYRapido.getColorPrincipal().get(colorOtro).cambiarColor();
				int cualCuadro = atentoYRapido.getColorPrincipal().get(colorOtro).getColor();
				imagen= new ImageIcon("src/imagenesAR1/"+cualCuadro+".jpg");

				
				switch(colorOtro+1)
				{
				case 1: cuadro1.setIcon(imagen);
				cuadro1.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				case 2: cuadro2.setIcon(imagen);
				cuadro2.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				case 3: cuadro3.setIcon(imagen);
				cuadro3.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				case 4: cuadro4.setIcon(imagen);
				cuadro4.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				case 5: cuadro5.setIcon(imagen);
				cuadro5.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));


				break;

				case 6: cuadro6.setIcon(imagen);
				cuadro6.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				case 7: cuadro7.setIcon(imagen);
				cuadro7.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				case 8: cuadro8.setIcon(imagen);
				cuadro8.setBorder(new MatteBorder(5 , 3, 7, 5, Color.BLUE));

				break;

				}


				tiempoBorde.start();


				if (atentoYRapido.compararAciertoFalse()) {


					tiempoReconocer.start();
					tiempoReconocer.setInitialDelay(3000); //Da un tiempo de espera de 3 sg para dar click
				}


			}else if (eventAction.getSource()==tiempoBorde) {

				cuadro1.setBorder(null);
				cuadro2.setBorder(null);
				cuadro3.setBorder(null);
				cuadro4.setBorder(null);
				cuadro5.setBorder(null);
				cuadro6.setBorder(null);
				cuadro7.setBorder(null);
				cuadro8.setBorder(null);

				tiempoBorde.stop();
				

			}else if ((eventAction.getSource()==tiempoReconocer)) { //Si el tiempo de espera termino y no presionaron pulsar

			
				atentoYRapido.eliminarUnaVidaYFallo();
				valorVidas.setText(String.valueOf(atentoYRapido.getVidas()));
				tiempoReconocer.stop();
				atentoYRapido.cambiarColores();
				obtenerNuevosCuadros();

				acabarElJuego();


			}else if (eventAction.getSource()==pulsar) { //Si presiona pulsar,antes de culminar el tiempo de espera, el tiempo se detiene

				tiempoReconocer.stop();

				atentoYRapido.compararAciertoFalse();
				atentoYRapido.verificar();
				valorPuntos.setText(String.valueOf(atentoYRapido.getPunto()));
				valorVidas.setText(String.valueOf(atentoYRapido.getVidas()));


				if(atentoYRapido.compararAciertoFalse()==true) {
					atentoYRapido.añadirCuadros();

				}

				obtenerNuevosCuadros();

				acabarElJuego();

			}
		}

	}



	/**
	 * Inicio juego.//Establece las condiciones iniciales del juego, lo que aparecerá en la GUI al instante de iniciar el juego
	 */
	private void inicioJuego() {
		zonaJuego.setVisible(false);

		atentoYRapido.cambiarColores();

		cuadro1.setVisible(true);
		cuadro2.setVisible(true);
		cuadro3.setVisible(true);


		//atentoYRapido.cambiarColores();
		imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
		cuadro1.setIcon(imagen);

		//atentoYRapido.cambiarColores();
		imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
		cuadro2.setIcon(imagen);

		//atentoYRapido.cambiarColores();

		imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
		cuadro3.setIcon(imagen);


		valorPuntos.setText(String.valueOf(atentoYRapido.getPunto()));
		valorVidas.setText(String.valueOf(atentoYRapido.getVidas()));

		tiempo1.start();
	}


	/**
	 * Obtener nuevos cuadros.//Agrega los nuevos cuadros de acuerdo a cada acierto y que estos cambien de imagen sin repetirse. 
	 */
	private void obtenerNuevosCuadros() {

		atentoYRapido.cambiarColores();

		if(atentoYRapido.getAciertos()==0) {

			atentoYRapido.cambiarColores();

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
			cuadro1.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
			cuadro2.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
			cuadro3.setIcon(imagen);


		}else if(atentoYRapido.getAciertos()==1) { 

			atentoYRapido.cambiarColores();

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
			cuadro1.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
			cuadro2.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
			cuadro3.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(3).getColor()+".jpg");
			cuadro4.setIcon(imagen);

			cuadro4.setVisible(true);
		}

		if(atentoYRapido.getAciertos()==2) {

			atentoYRapido.cambiarColores();
			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
			cuadro1.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
			cuadro2.setIcon(imagen);


			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
			cuadro3.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(3).getColor()+".jpg");
			cuadro4.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(4).getColor()+".jpg");
			cuadro5.setIcon(imagen);
			cuadro5.setVisible(true);

		} 

		if(atentoYRapido.getAciertos()==3) {
			atentoYRapido.cambiarColores();

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
			cuadro1.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
			cuadro2.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
			cuadro3.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(3).getColor()+".jpg");
			cuadro4.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(4).getColor()+".jpg");
			cuadro5.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(5).getColor()+".jpg");
			cuadro6.setIcon(imagen);
			cuadro6.setVisible(true);

		}

		if(atentoYRapido.getAciertos()==4) {
			atentoYRapido.cambiarColores();

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
			cuadro1.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
			cuadro2.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
			cuadro3.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(3).getColor()+".jpg");
			cuadro4.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(4).getColor()+".jpg");
			cuadro5.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(5).getColor()+".jpg");
			cuadro6.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(6).getColor()+".jpg");
			cuadro7.setIcon(imagen);
			cuadro7.setVisible(true);
		}

		if(atentoYRapido.getAciertos()>=5) {

			atentoYRapido.cambiarColores();

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(0).getColor()+".jpg");
			cuadro1.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(1).getColor()+".jpg");
			cuadro2.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(2).getColor()+".jpg");
			cuadro3.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(3).getColor()+".jpg");
			cuadro4.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(4).getColor()+".jpg");
			cuadro5.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(5).getColor()+".jpg");
			cuadro6.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(6).getColor()+".jpg");
			cuadro7.setIcon(imagen);

			imagen= new ImageIcon("src/imagenesAR1/"+ atentoYRapido.getColorPrincipal().get(7).getColor()+".jpg");
			cuadro8.setIcon(imagen);
			cuadro8.setVisible(true);


		}



	}

	/**
	 * Componentes iniciales.Es la visualización principal de la interfaz lo que el usuario se encuentra al abrir el juego.
	 */
	private void componentesIniciales() {
		valorPuntos.setText(String.valueOf(0));
		valorVidas.setText(String.valueOf(0));
		zonaJuego.setVisible(true);
		jugar.setVisible(true);
		tiempo1.stop();
		tiempoBorde.stop();
		cuadro4.setVisible(false);
		cuadro5.setVisible(false);
		cuadro6.setVisible(false);
		cuadro7.setVisible(false);
		cuadro8.setVisible(false);

	}



	/**
	 * Acabar el juego. Establece las formas en las que el juego culmina y las respectivas ventanas que debe abrir 
	 */
	private void acabarElJuego() {
		if(atentoYRapido.getVidas()==0) {

			String mensaje1 = "PERDISTE!!!"+"\nPuntuación: "+ atentoYRapido.getPunto()+
					"\nAciertos: "+atentoYRapido.getAciertos()+
					"\nFallos: "+atentoYRapido.getFallos()+ "\n¿Deseas volver a jugar? ";



			int result= JOptionPane.showOptionDialog (null, mensaje1, "Resultado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

			if(result == JOptionPane.YES_OPTION) {

				inicioJuego();

				componentesIniciales();

				atentoYRapido.reiniciarJuego(); 
			}

			if(result == JOptionPane.NO_OPTION) {
				System.exit(0); 
			}

		}



		if(atentoYRapido.calcularRonda()==12) {

			String mensaje2 = "GANASTE!!!"+"\nPuntuación: "+ atentoYRapido.getPunto()+
					"\nAciertos: "+atentoYRapido.getAciertos()+
					"\nFallos: "+atentoYRapido.getFallos()+ "\n¿Deseas volver a jugar? ";



			int result= JOptionPane.showOptionDialog (null, mensaje2, "Resultado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);

			if(result == JOptionPane.YES_OPTION) {

				inicioJuego();

				componentesIniciales();

				atentoYRapido.reiniciarJuego(); 
			}

			if(result == JOptionPane.NO_OPTION) {
				System.exit(0); 
			}

		}
	}
}		
