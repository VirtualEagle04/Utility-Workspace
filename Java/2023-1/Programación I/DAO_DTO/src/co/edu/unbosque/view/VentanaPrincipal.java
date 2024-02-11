package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame{
	
	private JPanel fondo;
	
	private JMenuBar menubar;
	private JMenu planetas, galaxias, asteroides, agujeros_negros;
	//Planetas
	private JMenuItem crear_planeta, eliminar_planetaNombre, eliminar_planetaIndex, actualizar_planetaNombre, actualizar_planetaIndex, mostrar_planetas;
	//Galaxias
	private JMenuItem crear_galaxia, eliminar_galaxiaNombre, eliminar_galaxiaIndex, actualizar_galaxiaNombre, actualizar_galaxiaIndex, mostrar_galaxias;
	//Asteroides
	private JMenuItem crear_asteroide, eliminar_asteroideNombre, eliminar_asteroideIndex, actualizar_asteroideNombre, actualizar_asteroideIndex, mostrar_asteroides;
	//Agujeros Negros
	private JMenuItem crear_agujero, eliminar_agujeroNombre, eliminar_agujeroIndex, actualizar_agujeroNombre, actualizar_agujeroIndex, mostrar_agujeros;

	//Paneles Planetas
	private JPanel p_crear, p_deln, p_deli, p_actn, p_acti, p_show;
	//Paneles Galaxias
	private JPanel g_crear, g_deln, g_deli, g_actn, g_acti, g_show;
	//Paneles Asteroides
	private JPanel a_crear, a_deln, a_deli, a_actn, a_acti, a_show;
	//Paneles Agujeros
	private JPanel bh_crear, bh_deln, bh_deli, bh_actn, bh_acti, bh_show;

	private JTextField pcrear_campoN, pcrear_campoT, pcrear_campoH, pcrear_campoG, pcrear_campoD; 
	private JTextField pdeln_campoN, pdeli_campoI;
	private JTextField pactn_campoN, pactn_editarN, pactn_editarT, pactn_editarH, pactn_editarG, pactn_editarD;
	private JTextField pacti_campoN, pacti_editarN, pacti_editarT, pacti_editarH, pacti_editarG, pacti_editarD;
	private JLabel pcrear_indN, pcrear_indT, pcrear_indH, pcrear_indG, pcrear_indD, pcrear_exito;
	private JLabel pdeln_indN, pdeln_exito, pdeln_error;
	private JLabel pdeli_indI, pdeli_exito, pdeli_error;
	private JLabel pactn_indN, pactn_ind_editarN, pactn_ind_editarT, pactn_ind_editarH, pactn_ind_editarG, pactn_ind_editarD, pactn_exito; 
	private JLabel pacti_indN,pacti_ind_editarN, pacti_ind_editarT, pacti_ind_editarH, pacti_ind_editarG, pacti_ind_editarD, pacti_exito;
	private JTextArea pshow_console, gshow_console, ashow_console, bhshow_console;
	private JButton pcrear_confirmar, pdeln_confirmar, pdeli_confirmar, pactn_buscar, pactn_confirmar, pacti_buscar, pacti_confirmar; 
	private JTextField gcrear_campoN, gcrear_campoCP, gcrear_campoCE, gcrear_campoR; 
	private JLabel gcrear_indN, gcrear_indCT, gcrear_indCE, gcrear_indR, gcrear_exito;
	private JButton gcrear_confirmar; 
	private JTextField gdeln_campoN, gdeli_campoI, gactn_campoN, gactn_editarN, gactn_editarCP, gactn_editarCE, gactn_editarR;  
	private JLabel gdeln_indN, gdeln_exito, gdeln_error, gdeli_indI, gdeli_exito, gdeli_error, gactn_indN, gactn_ind_editarN;
	private JLabel gactn_ind_editarCP, gactn_ind_editarCE, gactn_ind_editarR, gactn_exito;
	private JButton gdeln_confirmar, gdeli_confirmar, gactn_buscar, gactn_confirmar;
	private JLabel gacti_indN, gacti_ind_editarN, gacti_ind_editarCP, gacti_ind_editarCE, gacti_ind_editarR, gacti_exito;
	private JTextField gacti_campoN, gacti_editarN, gacti_editarCP, gacti_editarCE, gacti_editarR;
	private JButton gacti_buscar, gacti_confirmar;
	private JTextField acrear_campoN, acrear_campoV, acrear_campoT, acrear_campoM, acrear_campoMN, adeln_campoN, adeli_campoI; 
	private JTextField aactn_campoN, aactn_editarN, aactn_editarV, aactn_editarT, aactn_editarM, aactn_editarCM;
	private JLabel acrear_indN, acrear_indV, acrear_indT, acrear_indM, acrear_indMN, acrear_exito, adeln_indN, adeln_exito, adeln_error;
	private JLabel adeli_indI, adeli_exito, adeli_error, aactn_indN, aactn_ind_editarN, aactn_ind_editarV, aactn_ind_editarT, aactn_ind_editarM, aactn_exito;
	private JLabel aactn_ind_editarCM, aacti_indN, aacti_ind_editarN, aacti_ind_editarV, aacti_ind_editarT, aacti_ind_editarM, aacti_ind_editarCM;
	private JButton acrear_confirmar, adeln_confirmar, adeli_confirmar, aactn_buscar, aactn_confirmar;
	private JLabel aacti_exito; 
	private JTextField aacti_campoN, aacti_editarN, aacti_editarV, aacti_editarT, aacti_editarM, aacti_editarCM; 
	private JButton aacti_buscar, aacti_confirmar;
	private JTextField bhcrear_campoN, bhcrear_campoM, bhcrear_campoMA, bhcrear_campoG, bhcrear_campoD, bhdeln_campoN, bhacti_campoN, bhacti_editarN, bhacti_editarM, bhacti_editarMA;
	private JTextField bhdeli_campoI, bhactn_campoN, bhactn_editarN, bhactn_editarM, bhactn_editarG, bhactn_editarD, bhacti_editarG;
	private JTextField bhacti_editarD, bhactn_editarMA;
	private JLabel bhcrear_indN, bhcrear_indM, bhcrear_indMA, bhcrear_indG, bhcrear_indD,  bhcrear_exito, bhdeln_indN;
	private JLabel bhdeln_exito, bhdeln_error, bhdeli_indI, bhdeli_exito, bhdeli_error, bhactn_indN, bhactn_ind_editarN, bhactn_ind_editarM;
	private JLabel bhactn_ind_editarG, bhactn_ind_editarD, bhactn_exito, bhacti_indN, bhacti_ind_editarM, bhacti_ind_editarN, bhacti_ind_editarMA;
	private JLabel bhacti_ind_editarG, bhacti_ind_editarD, bhacti_exito, bhactn_ind_editarMA;
	private JButton bhcrear_confirmar, bhdeln_confirmar, bhdeli_confirmar, bhactn_buscar, bhactn_confirmar,  bhacti_buscar, bhacti_confirmar; 




	public VentanaPrincipal() {
		
		setTitle("Planetario Interestelar");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setFocusable(true);

		//MenuItem
		//Planetas
		crear_planeta = new JMenuItem("Crear Planeta");
		crear_planeta.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_planetaNombre = new JMenuItem("Eliminar Planeta por Nombre");
		eliminar_planetaNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_planetaIndex = new JMenuItem("Eliinar Planeta por Index");
		eliminar_planetaIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_planetaNombre = new JMenuItem("Actualizar Planeta por Nombre");
		actualizar_planetaNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_planetaIndex = new JMenuItem("Actualizar Planeta por Index");
		actualizar_planetaIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		mostrar_planetas = new JMenuItem("Mostrar todos los Planetas");
		mostrar_planetas.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		//Galaxias
		crear_galaxia = new JMenuItem("Crear Galaxia");
		crear_galaxia.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_galaxiaNombre = new JMenuItem("Eliminar Galaxia por Nombre");
		eliminar_galaxiaNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_galaxiaIndex = new JMenuItem("Eliminar Galaxia por Index");
		eliminar_galaxiaIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_galaxiaNombre = new JMenuItem("Actualizar Galaxia por Nombre");
		actualizar_galaxiaNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_galaxiaIndex = new JMenuItem("Actualizar Galaxia por Index");
		actualizar_galaxiaIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		mostrar_galaxias = new JMenuItem("Mostrar todas las Galaxias");
		mostrar_galaxias.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		//Asteroides
		crear_asteroide = new JMenuItem("Crear Asteroide");
		crear_asteroide.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_asteroideNombre = new JMenuItem("Eliminar Asteroide por Nombre");
		eliminar_asteroideNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_asteroideIndex = new JMenuItem("Eliminar Asteroide por Index");
		eliminar_asteroideIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_asteroideNombre = new JMenuItem("Actualizar Asteroide por Nombre");
		actualizar_asteroideNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_asteroideIndex = new JMenuItem("Actualizar Asteroide por Index");
		actualizar_asteroideIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		mostrar_asteroides = new JMenuItem("Mostrar todos los Asteroides");
		mostrar_asteroides.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		//Agujeros Negros
		crear_agujero = new JMenuItem("Crear Agujero Negro");
		crear_agujero.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_agujeroNombre = new JMenuItem("Eliminar Agujero Negro por Nombre");
		eliminar_agujeroNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		eliminar_agujeroIndex = new JMenuItem("Eliminar Agujero Negro por Index");
		eliminar_agujeroIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_agujeroNombre = new JMenuItem("Actualizar Agujero Negro por Nombre");
		actualizar_agujeroNombre.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		actualizar_agujeroIndex = new JMenuItem("Actualizar Agujero Negro por Index");
		actualizar_agujeroIndex.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		mostrar_agujeros = new JMenuItem("Mostrar todos los Agujeros Negros");
		mostrar_agujeros.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));

		//Menus

		planetas = new JMenu("Planetas");
		planetas.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		planetas.add(crear_planeta);
		planetas.add(eliminar_planetaNombre);
		planetas.add(eliminar_planetaIndex);
		planetas.add(actualizar_planetaNombre);
		planetas.add(actualizar_planetaIndex);
		planetas.add(mostrar_planetas);

		galaxias = new JMenu("Galaxias");
		galaxias.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		galaxias.add(crear_galaxia);
		galaxias.add(eliminar_galaxiaNombre);
		galaxias.add(eliminar_galaxiaIndex);
		galaxias.add(actualizar_galaxiaNombre);
		galaxias.add(actualizar_galaxiaIndex);
		galaxias.add(mostrar_galaxias);

		asteroides = new JMenu("Asteroides");
		asteroides.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		asteroides.add(crear_asteroide);
		asteroides.add(eliminar_asteroideNombre);
		asteroides.add(eliminar_asteroideIndex);
		asteroides.add(actualizar_asteroideNombre);
		asteroides.add(actualizar_asteroideIndex);
		asteroides.add(mostrar_asteroides);

		agujeros_negros = new JMenu("Agujeros Negros");
		agujeros_negros.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 16));
		agujeros_negros.add(crear_agujero);
		agujeros_negros.add(eliminar_agujeroNombre);
		agujeros_negros.add(eliminar_agujeroIndex);
		agujeros_negros.add(actualizar_agujeroNombre);
		agujeros_negros.add(actualizar_agujeroIndex);
		agujeros_negros.add(mostrar_agujeros);

		//Menubar

		menubar = new JMenuBar();
		menubar.add(planetas);
		menubar.add(galaxias);
		menubar.add(asteroides);
		menubar.add(agujeros_negros);
		add(menubar);
		setJMenuBar(menubar);

		//Componentes

		fondo = new JPanel();
		fondo.setLayout(null);
		fondo.setBounds(0,0, 600, 600);
		fondo.setBackground(Color.DARK_GRAY);
		add(fondo);

		//Planetas
		p_crear = new JPanel();
		p_crear.setLayout(null);
		p_crear.setBounds(50, 25, 485, 475);
		p_crear.setBackground(Color.LIGHT_GRAY);

			pcrear_campoN = new JTextField();
			pcrear_campoN.setBounds(250, 70, 150, 20);
			p_crear.add(pcrear_campoN);

			pcrear_indN = new JLabel("Nombre: ");
			pcrear_indN.setBounds(70, 68, 150, 20);
			p_crear.add(pcrear_indN);

			pcrear_campoT = new JTextField();
			pcrear_campoT.setBounds(250, 110, 150, 20);
			p_crear.add(pcrear_campoT);

			pcrear_indT = new JLabel("Tamano: ");
			pcrear_indT.setBounds(70, 108, 150, 20);
			p_crear.add(pcrear_indT);

			pcrear_campoH = new JTextField();
			pcrear_campoH.setBounds(250, 150, 150, 20);
			p_crear.add(pcrear_campoH);

			pcrear_indH = new JLabel("Es Habitable? ");
			pcrear_indH.setBounds(70, 148, 150, 20);
			p_crear.add(pcrear_indH);

			pcrear_campoG = new JTextField();
			pcrear_campoG.setBounds(250, 190, 150, 20);
			p_crear.add(pcrear_campoG);

			pcrear_indG = new JLabel("Gravedad: ");
			pcrear_indG.setBounds(70, 188, 150, 20);
			p_crear.add(pcrear_indG);

			pcrear_campoD = new JTextField();
			pcrear_campoD.setBounds(250, 230, 150, 20);
			p_crear.add(pcrear_campoD);

			pcrear_indD = new JLabel("Distancia de la tierra: ");
			pcrear_indD.setBounds(70, 228, 150, 20);
			p_crear.add(pcrear_indD);

			pcrear_confirmar = new JButton();
			pcrear_confirmar.setBounds(140, 320, 200, 25);
			pcrear_confirmar.setText("Listo");
			p_crear.add(pcrear_confirmar);

			pcrear_exito = new JLabel("Creado Exitosamente");
			pcrear_exito.setForeground(Color.BLUE);
			pcrear_exito.setBounds(180, 370, 200, 25);
			p_crear.add(pcrear_exito).setVisible(false);

		fondo.add(p_crear).setVisible(false);

		p_deln = new JPanel();
		p_deln.setLayout(null);
		p_deln.setBounds(50, 25, 485, 475);
		p_deln.setBackground(Color.LIGHT_GRAY);

			pdeln_campoN = new JTextField();
			pdeln_campoN.setBounds(250, 70, 150, 20);
			p_deln.add(pdeln_campoN);

			pdeln_indN = new JLabel("Planeta que desea eliminar: ");
			pdeln_indN.setBounds(70, 68, 230, 20);
			p_deln.add(pdeln_indN);

			pdeln_confirmar = new JButton();
			pdeln_confirmar.setBounds(140, 320, 200, 25);
			pdeln_confirmar.setText("Listo");
			p_deln.add(pdeln_confirmar);

			pdeln_exito = new JLabel("Eliminado Exitosamente");
			pdeln_exito.setForeground(Color.BLUE);
			pdeln_exito.setBounds(180, 370, 200, 25);
			p_deln.add(pdeln_exito).setVisible(false);

			pdeln_error = new JLabel("Error en la Eliminacion");
			pdeln_error.setForeground(Color.RED);
			pdeln_error.setBounds(180, 370, 200, 25);
			p_deln.add(pdeln_error).setVisible(false);

		fondo.add(p_deln).setVisible(false);

		p_deli = new JPanel();
		p_deli.setLayout(null);
		p_deli.setBounds(50, 25, 485, 475);
		p_deli.setBackground(Color.LIGHT_GRAY);

			pdeli_campoI = new JTextField();
			pdeli_campoI.setBounds(280, 70, 150, 20);
			p_deli.add(pdeli_campoI);

			pdeli_indI = new JLabel("Posicion del Planeta que desea eliminar: ");
			pdeli_indI.setBounds(30, 68, 260, 20);
			p_deli.add(pdeli_indI);

			pdeli_confirmar = new JButton();
			pdeli_confirmar.setBounds(140, 320, 200, 25);
			pdeli_confirmar.setText("Listo");
			p_deli.add(pdeli_confirmar);

			pdeli_exito = new JLabel("Eliminado Exitosamente");
			pdeli_exito.setForeground(Color.BLUE);
			pdeli_exito.setBounds(180, 370, 200, 25);
			p_deli.add(pdeli_exito).setVisible(false);

			pdeli_error = new JLabel("Error en la Eliminacion");
			pdeli_error.setForeground(Color.RED);
			pdeli_error.setBounds(180, 370, 200, 25);
			p_deli.add(pdeli_error).setVisible(false);

		fondo.add(p_deli).setVisible(false);

		p_actn = new JPanel();
		p_actn.setLayout(null);
		p_actn.setBounds(50, 25, 485, 475);
		p_actn.setBackground(Color.LIGHT_GRAY);

			pactn_indN = new JLabel("Nombre del Planeta que desea editar:");
			pactn_indN.setBounds(140, 20, 300, 25);
			p_actn.add(pactn_indN);

			pactn_campoN = new JTextField();
			pactn_campoN.setBounds(145, 50, 200, 25);
			p_actn.add(pactn_campoN);

			pactn_buscar = new JButton("Buscar");
			pactn_buscar.setBounds(145, 80, 200, 25);
			p_actn.add(pactn_buscar);

			//Editar

			pactn_editarN = new JTextField();
			pactn_editarN.setBounds(250, 120, 150, 20);
			p_actn.add(pactn_editarN);

			pactn_ind_editarN = new JLabel("Nombre: ");
			pactn_ind_editarN.setBounds(70, 118, 150, 20);
			p_actn.add(pactn_ind_editarN);

			pactn_editarT = new JTextField();
			pactn_editarT.setBounds(250, 160, 150, 20);
			p_actn.add(pactn_editarT);

			pactn_ind_editarT = new JLabel("Tamano: ");
			pactn_ind_editarT.setBounds(70, 158, 150, 20);
			p_actn.add(pactn_ind_editarT);

			pactn_editarH = new JTextField();
			pactn_editarH.setBounds(250, 200, 150, 20);
			p_actn.add(pactn_editarH);

			pactn_ind_editarH = new JLabel("Es Habitable? ");
			pactn_ind_editarH.setBounds(70, 198, 150, 20);
			p_actn.add(pactn_ind_editarH);

			pactn_editarG = new JTextField();
			pactn_editarG.setBounds(250, 240, 150, 20);
			p_actn.add(pactn_editarG);

			pactn_ind_editarG = new JLabel("Gravedad: ");
			pactn_ind_editarG.setBounds(70, 238, 150, 20);
			p_actn.add(pactn_ind_editarG);

			pactn_editarD = new JTextField();
			pactn_editarD.setBounds(250, 280, 150, 20);
			p_actn.add(pactn_editarD);

			pactn_ind_editarD = new JLabel("Distancia de la tierra: ");
			pactn_ind_editarD.setBounds(70, 278, 150, 20);
			p_actn.add(pactn_ind_editarD);

			pactn_confirmar = new JButton();
			pactn_confirmar.setBounds(140, 370, 200, 25);
			pactn_confirmar.setText("Listo");
			p_actn.add(pactn_confirmar);

			pactn_exito = new JLabel("Creado Exitosamente");
			pactn_exito.setForeground(Color.BLUE);
			pactn_exito.setBounds(180, 420, 200, 25);
			p_actn.add(pactn_exito).setVisible(false);

		fondo.add(p_actn).setVisible(false);

		p_acti = new JPanel();
		p_acti.setLayout(null);
		p_acti.setBounds(50, 25, 485, 475);
		p_acti.setBackground(Color.LIGHT_GRAY);

			pacti_indN = new JLabel("Posicion del Planeta que desea editar:");
			pacti_indN.setBounds(140, 20, 300, 25);
			p_acti.add(pacti_indN);

			pacti_campoN = new JTextField();
			pacti_campoN.setBounds(145, 50, 200, 25);
			p_acti.add(pacti_campoN);

			pacti_buscar = new JButton("Buscar");
			pacti_buscar.setBounds(145, 80, 200, 25);
			p_acti.add(pacti_buscar);

			//Editar

			pacti_editarN = new JTextField();
			pacti_editarN.setBounds(250, 120, 150, 20);
			p_acti.add(pacti_editarN);

			pacti_ind_editarN = new JLabel("Nombre: ");
			pacti_ind_editarN.setBounds(70, 118, 150, 20);
			p_acti.add(pacti_ind_editarN);

			pacti_editarT = new JTextField();
			pacti_editarT.setBounds(250, 160, 150, 20);
			p_acti.add(pacti_editarT);

			pacti_ind_editarT = new JLabel("Tamano: ");
			pacti_ind_editarT.setBounds(70, 158, 150, 20);
			p_acti.add(pacti_ind_editarT);

			pacti_editarH = new JTextField();
			pacti_editarH.setBounds(250, 200, 150, 20);
			p_acti.add(pacti_editarH);

			pacti_ind_editarH = new JLabel("Es Habitable? ");
			pacti_ind_editarH.setBounds(70, 198, 150, 20);
			p_acti.add(pacti_ind_editarH);

			pacti_editarG = new JTextField();
			pacti_editarG.setBounds(250, 240, 150, 20);
			p_acti.add(pacti_editarG);

			pacti_ind_editarG = new JLabel("Gravedad: ");
			pacti_ind_editarG.setBounds(70, 238, 150, 20);
			p_acti.add(pacti_ind_editarG);

			pacti_editarD = new JTextField();
			pacti_editarD.setBounds(250, 280, 150, 20);
			p_acti.add(pacti_editarD);

			pacti_ind_editarD = new JLabel("Distancia de la tierra: ");
			pacti_ind_editarD.setBounds(70, 278, 150, 20);
			p_acti.add(pacti_ind_editarD);

			pacti_confirmar = new JButton();
			pacti_confirmar.setBounds(140, 370, 200, 25);
			pacti_confirmar.setText("Listo");
			p_acti.add(pacti_confirmar);

			pacti_exito = new JLabel("Creado Exitosamente");
			pacti_exito.setForeground(Color.BLUE);
			pacti_exito.setBounds(180, 420, 200, 25);
			p_acti.add(pacti_exito).setVisible(false);

		fondo.add(p_acti).setVisible(false);

		p_show = new JPanel();
		p_show.setLayout(null);
		p_show.setBounds(50, 25, 485, 475);
		p_show.setBackground(Color.LIGHT_GRAY);

			pshow_console = new JTextArea();
			pshow_console.setEditable(false);
			pshow_console.setBounds(43, 25, 400, 400);
			pshow_console.setBackground(Color.BLACK);
			pshow_console.setForeground(Color.WHITE);
			p_show.add(pshow_console);

		fondo.add(p_show).setVisible(false);

		//Galaxias
		g_crear = new JPanel();
		g_crear.setLayout(null);
		g_crear.setBounds(50, 25, 485, 475);
		g_crear.setBackground(Color.LIGHT_GRAY);

			gcrear_campoN = new JTextField();
			gcrear_campoN.setBounds(250, 70, 150, 20);
			g_crear.add(gcrear_campoN);

			gcrear_indN = new JLabel("Nombre: ");
			gcrear_indN.setBounds(70, 68, 150, 20);
			g_crear.add(gcrear_indN);

			gcrear_campoCP = new JTextField();
			gcrear_campoCP.setBounds(250, 110, 150, 20);
			g_crear.add(gcrear_campoCP);

			gcrear_indCT = new JLabel("Cantidad de Planetas: ");
			gcrear_indCT.setBounds(70, 108, 150, 20);
			g_crear.add(gcrear_indCT);

			gcrear_campoCE = new JTextField();
			gcrear_campoCE.setBounds(250, 150, 150, 20);
			g_crear.add(gcrear_campoCE);

			gcrear_indCE = new JLabel("Cantidad de Estrellas: ");
			gcrear_indCE.setBounds(70, 148, 150, 20);
			g_crear.add(gcrear_indCE);

			gcrear_campoR = new JTextField();
			gcrear_campoR.setBounds(250, 190, 150, 20);
			g_crear.add(gcrear_campoR);

			gcrear_indR = new JLabel("Radio: ");
			gcrear_indR.setBounds(70, 188, 150, 20);
			g_crear.add(gcrear_indR);

			gcrear_confirmar = new JButton();
			gcrear_confirmar.setBounds(140, 320, 200, 25);
			gcrear_confirmar.setText("Listo");
			g_crear.add(gcrear_confirmar);

			gcrear_exito = new JLabel("Creado Exitosamente");
			gcrear_exito.setForeground(Color.BLUE);
			gcrear_exito.setBounds(180, 370, 200, 25);
			g_crear.add(gcrear_exito).setVisible(false);

		fondo.add(g_crear).setVisible(false);

		g_deln = new JPanel();
		g_deln.setLayout(null);
		g_deln.setBounds(50, 25, 485, 475);
		g_deln.setBackground(Color.LIGHT_GRAY);

			gdeln_campoN = new JTextField();
			gdeln_campoN.setBounds(250, 70, 150, 20);
			g_deln.add(gdeln_campoN);

			gdeln_indN = new JLabel("Galaxia que desea eliminar: ");
			gdeln_indN.setBounds(70, 68, 230, 20);
			g_deln.add(gdeln_indN);

			gdeln_confirmar = new JButton();
			gdeln_confirmar.setBounds(140, 320, 200, 25);
			gdeln_confirmar.setText("Listo");
			g_deln.add(gdeln_confirmar);

			gdeln_exito = new JLabel("Eliminado Exitosamente");
			gdeln_exito.setForeground(Color.BLUE);
			gdeln_exito.setBounds(180, 370, 200, 25);
			g_deln.add(gdeln_exito).setVisible(false);

			gdeln_error = new JLabel("Error en la Eliminacion");
			gdeln_error.setForeground(Color.RED);
			gdeln_error.setBounds(180, 370, 200, 25);
			g_deln.add(gdeln_error).setVisible(false);

		fondo.add(g_deln).setVisible(false);

		g_deli = new JPanel();
		g_deli.setLayout(null);
		g_deli.setBounds(50, 25, 485, 475);
		g_deli.setBackground(Color.LIGHT_GRAY);

			gdeli_campoI = new JTextField();
			gdeli_campoI.setBounds(280, 70, 150, 20);
			g_deli.add(gdeli_campoI);

			gdeli_indI = new JLabel("Posicion de la Galaxia que desea eliminar: ");
			gdeli_indI.setBounds(30, 68, 260, 20);
			g_deli.add(gdeli_indI);

			gdeli_confirmar = new JButton();
			gdeli_confirmar.setBounds(140, 320, 200, 25);
			gdeli_confirmar.setText("Listo");
			g_deli.add(gdeli_confirmar);

			gdeli_exito = new JLabel("Eliminado Exitosamente");
			gdeli_exito.setForeground(Color.BLUE);
			gdeli_exito.setBounds(180, 370, 200, 25);
			g_deli.add(gdeli_exito).setVisible(false);

			gdeli_error = new JLabel("Error en la Eliminacion");
			gdeli_error.setForeground(Color.RED);
			gdeli_error.setBounds(180, 370, 200, 25);
			g_deli.add(gdeli_error).setVisible(false);

		fondo.add(g_deli).setVisible(false);

		g_actn = new JPanel();
		g_actn.setLayout(null);
		g_actn.setBounds(50, 25, 485, 475);
		g_actn.setBackground(Color.LIGHT_GRAY);

			gactn_indN = new JLabel("Nombre de la Galaxia que desea editar:");
			gactn_indN.setBounds(140, 20, 300, 25);
			g_actn.add(gactn_indN);

			gactn_campoN = new JTextField();
			gactn_campoN.setBounds(145, 50, 200, 25);
			g_actn.add(gactn_campoN);

			gactn_buscar = new JButton("Buscar");
			gactn_buscar.setBounds(145, 80, 200, 25);
			g_actn.add(gactn_buscar);

			//Editar

			gactn_editarN = new JTextField();
			gactn_editarN.setBounds(250, 120, 150, 20);
			g_actn.add(gactn_editarN);

			gactn_ind_editarN = new JLabel("Nombre: ");
			gactn_ind_editarN.setBounds(70, 118, 150, 20);
			g_actn.add(gactn_ind_editarN);

			gactn_editarCP = new JTextField();
			gactn_editarCP.setBounds(250, 160, 150, 20);
			g_actn.add(gactn_editarCP);

			gactn_ind_editarCP = new JLabel("Cantidad de Planetas: ");
			gactn_ind_editarCP.setBounds(70, 158, 150, 20);
			g_actn.add(gactn_ind_editarCP);

			gactn_editarCE = new JTextField();
			gactn_editarCE.setBounds(250, 200, 150, 20);
			g_actn.add(gactn_editarCE);

			gactn_ind_editarCE = new JLabel("Cantidad de Estrellas: ");
			gactn_ind_editarCE.setBounds(70, 198, 150, 20);
			g_actn.add(gactn_ind_editarCE);

			gactn_editarR = new JTextField();
			gactn_editarR.setBounds(250, 240, 150, 20);
			g_actn.add(gactn_editarR);

			gactn_ind_editarR = new JLabel("Radio: ");
			gactn_ind_editarR.setBounds(70, 238, 150, 20);
			g_actn.add(gactn_ind_editarR);

			gactn_confirmar = new JButton();
			gactn_confirmar.setBounds(140, 370, 200, 25);
			gactn_confirmar.setText("Listo");
			g_actn.add(gactn_confirmar);

			gactn_exito = new JLabel("Creado Exitosamente");
			gactn_exito.setForeground(Color.BLUE);
			gactn_exito.setBounds(180, 420, 200, 25);
			g_actn.add(gactn_exito).setVisible(false);

		fondo.add(g_actn).setVisible(false);

		g_acti = new JPanel();
		g_acti.setLayout(null);
		g_acti.setBounds(50, 25, 485, 475);
		g_acti.setBackground(Color.LIGHT_GRAY);

			gacti_indN = new JLabel("Posicion de la Galaxia que desea editar:");
			gacti_indN.setBounds(140, 20, 300, 25);
			g_acti.add(gacti_indN);

			gacti_campoN = new JTextField();
			gacti_campoN.setBounds(145, 50, 200, 25);
			g_acti.add(gacti_campoN);

			gacti_buscar = new JButton("Buscar");
			gacti_buscar.setBounds(145, 80, 200, 25);
			g_acti.add(gacti_buscar);

			//Editar

			gacti_editarN = new JTextField();
			gacti_editarN.setBounds(250, 120, 150, 20);
			g_acti.add(gacti_editarN);

			gacti_ind_editarN = new JLabel("Nombre: ");
			gacti_ind_editarN.setBounds(70, 118, 150, 20);
			g_acti.add(gacti_ind_editarN);

			gacti_editarCP = new JTextField();
			gacti_editarCP.setBounds(250, 160, 150, 20);
			g_acti.add(gacti_editarCP);

			gacti_ind_editarCP = new JLabel("Cantidad de Planetas: ");
			gacti_ind_editarCP.setBounds(70, 158, 150, 20);
			g_acti.add(gacti_ind_editarCP);

			gacti_editarCE = new JTextField();
			gacti_editarCE.setBounds(250, 200, 150, 20);
			g_acti.add(gacti_editarCE);

			gacti_ind_editarCE = new JLabel("Cantidad de Estrellas: ");
			gacti_ind_editarCE.setBounds(70, 198, 150, 20);
			g_acti.add(gacti_ind_editarCE);

			gacti_editarR = new JTextField();
			gacti_editarR.setBounds(250, 240, 150, 20);
			g_acti.add(gacti_editarR);

			gacti_ind_editarR = new JLabel("Radio: ");
			gacti_ind_editarR.setBounds(70, 238, 150, 20);
			g_acti.add(gacti_ind_editarR);

			gacti_confirmar = new JButton();
			gacti_confirmar.setBounds(140, 370, 200, 25);
			gacti_confirmar.setText("Listo");
			g_acti.add(gacti_confirmar);

			gacti_exito = new JLabel("Creado Exitosamente");
			gacti_exito.setForeground(Color.BLUE);
			gacti_exito.setBounds(180, 420, 200, 25);
			g_acti.add(gacti_exito).setVisible(false);

		fondo.add(g_acti).setVisible(false);

		g_show = new JPanel();
		g_show.setLayout(null);
		g_show.setBounds(50, 25, 485, 475);
		g_show.setBackground(Color.LIGHT_GRAY);

			gshow_console = new JTextArea();
			gshow_console.setBounds(43, 25, 400, 400);
			gshow_console.setBackground(Color.BLACK);
			gshow_console.setForeground(Color.WHITE);
			g_show.add(gshow_console);	

		fondo.add(g_show).setVisible(false);

		//Asteroides
		a_crear = new JPanel();
		a_crear.setLayout(null);
		a_crear.setBounds(50, 25, 485, 475);
		a_crear.setBackground(Color.LIGHT_GRAY);

			acrear_campoN = new JTextField();
			acrear_campoN.setBounds(250, 70, 150, 20);
			a_crear.add(acrear_campoN);

			acrear_indN = new JLabel("Nombre: ");
			acrear_indN.setBounds(70, 68, 150, 20);
			a_crear.add(acrear_indN);

			acrear_campoV = new JTextField();
			acrear_campoV.setBounds(250, 110, 150, 20);
			a_crear.add(acrear_campoV);

			acrear_indV = new JLabel("Velocidad: ");
			acrear_indV.setBounds(70, 108, 150, 20);
			a_crear.add(acrear_indV);

			acrear_campoT = new JTextField();
			acrear_campoT.setBounds(250, 150, 150, 20);
			a_crear.add(acrear_campoT);

			acrear_indT = new JLabel("Tamano: ");
			acrear_indT.setBounds(70, 148, 150, 20);
			a_crear.add(acrear_indT);

			acrear_campoM = new JTextField();
			acrear_campoM.setBounds(250, 190, 150, 20);
			a_crear.add(acrear_campoM);

			acrear_indM = new JLabel("Material: ");
			acrear_indM.setBounds(70, 188, 150, 20);
			a_crear.add(acrear_indM);

			acrear_campoMN = new JTextField();
			acrear_campoMN.setBounds(250, 230, 150, 20);
			a_crear.add(acrear_campoMN);

			acrear_indMN = new JLabel("Contiene Minerales? ");
			acrear_indMN.setBounds(70, 228, 150, 20);
			a_crear.add(acrear_indMN);

			acrear_confirmar = new JButton();
			acrear_confirmar.setBounds(140, 320, 200, 25);
			acrear_confirmar.setText("Listo");
			a_crear.add(acrear_confirmar);

			acrear_exito = new JLabel("Creado Exitosamente");
			acrear_exito.setForeground(Color.BLUE);
			acrear_exito.setBounds(180, 370, 200, 25);
			a_crear.add(acrear_exito).setVisible(false);

		fondo.add(a_crear).setVisible(false);

		a_deln = new JPanel();
		a_deln.setLayout(null);
		a_deln.setBounds(50, 25, 485, 475);
		a_deln.setBackground(Color.LIGHT_GRAY);

			adeln_campoN = new JTextField();
			adeln_campoN.setBounds(250, 70, 150, 20);
			a_deln.add(adeln_campoN);

			adeln_indN = new JLabel("Asteroide que desea eliminar: ");
			adeln_indN.setBounds(70, 68, 230, 20);
			a_deln.add(adeln_indN);

			adeln_confirmar = new JButton();
			adeln_confirmar.setBounds(140, 320, 200, 25);
			adeln_confirmar.setText("Listo");
			a_deln.add(adeln_confirmar);

			adeln_exito = new JLabel("Eliminado Exitosamente");
			adeln_exito.setForeground(Color.BLUE);
			adeln_exito.setBounds(180, 370, 200, 25);
			a_deln.add(adeln_exito).setVisible(false);

			adeln_error = new JLabel("Error en la Eliminacion");
			adeln_error.setForeground(Color.RED);
			adeln_error.setBounds(180, 370, 200, 25);
			a_deln.add(adeln_error).setVisible(false);

		fondo.add(a_deln).setVisible(false);

		a_deli = new JPanel();
		a_deli.setLayout(null);
		a_deli.setBounds(50, 25, 485, 475);
		a_deli.setBackground(Color.LIGHT_GRAY);

			adeli_campoI = new JTextField();
			adeli_campoI.setBounds(280, 70, 150, 20);
			a_deli.add(adeli_campoI);

			adeli_indI = new JLabel("Posicion del Asteroide que desea eliminar: ");
			adeli_indI.setBounds(30, 68, 260, 20);
			a_deli.add(adeli_indI);

			adeli_confirmar = new JButton();
			adeli_confirmar.setBounds(140, 320, 200, 25);
			adeli_confirmar.setText("Listo");
			a_deli.add(adeli_confirmar);

			adeli_exito = new JLabel("Eliminado Exitosamente");
			adeli_exito.setForeground(Color.BLUE);
			adeli_exito.setBounds(180, 370, 200, 25);
			a_deli.add(adeli_exito).setVisible(false);

			adeli_error = new JLabel("Error en la Eliminacion");
			adeli_error.setForeground(Color.RED);
			adeli_error.setBounds(180, 370, 200, 25);
			a_deli.add(adeli_error).setVisible(false);

		fondo.add(a_deli).setVisible(false);

		a_actn = new JPanel();
		a_actn.setLayout(null);
		a_actn.setBounds(50, 25, 485, 475);
		a_actn.setBackground(Color.LIGHT_GRAY);

			aactn_indN = new JLabel("Nombre del Asteroide que desea editar:");
			aactn_indN.setBounds(140, 20, 300, 25);
			a_actn.add(aactn_indN);

			aactn_campoN = new JTextField();
			aactn_campoN.setBounds(145, 50, 200, 25);
			a_actn.add(aactn_campoN);

			aactn_buscar = new JButton("Buscar");
			aactn_buscar.setBounds(145, 80, 200, 25);
			a_actn.add(aactn_buscar);

			//Editar

			aactn_editarN = new JTextField();
			aactn_editarN.setBounds(250, 120, 150, 20);
			a_actn.add(aactn_editarN);

			aactn_ind_editarN = new JLabel("Nombre: ");
			aactn_ind_editarN.setBounds(70, 118, 150, 20);
			a_actn.add(aactn_ind_editarN);

			aactn_editarV = new JTextField();
			aactn_editarV.setBounds(250, 160, 150, 20);
			a_actn.add(aactn_editarV);

			aactn_ind_editarV = new JLabel("Velocidad: ");
			aactn_ind_editarV.setBounds(70, 158, 150, 20);
			a_actn.add(aactn_ind_editarV);

			aactn_editarT = new JTextField();
			aactn_editarT.setBounds(250, 200, 150, 20);
			a_actn.add(aactn_editarT);

			aactn_ind_editarT = new JLabel("Tamano: ");
			aactn_ind_editarT.setBounds(70, 198, 150, 20);
			a_actn.add(aactn_ind_editarT);

			aactn_editarM = new JTextField();
			aactn_editarM.setBounds(250, 240, 150, 20);
			a_actn.add(aactn_editarM);

			aactn_ind_editarM = new JLabel("Material: ");
			aactn_ind_editarM.setBounds(70, 238, 150, 20);
			a_actn.add(aactn_ind_editarM);

			aactn_editarCM = new JTextField();
			aactn_editarCM.setBounds(250, 280, 150, 20);
			a_actn.add(aactn_editarCM);

			aactn_ind_editarCM = new JLabel("Contiene Minerales? ");
			aactn_ind_editarCM.setBounds(70, 278, 150, 20);
			a_actn.add(aactn_ind_editarCM);

			aactn_confirmar = new JButton();
			aactn_confirmar.setBounds(140, 370, 200, 25);
			aactn_confirmar.setText("Listo");
			a_actn.add(aactn_confirmar);

			aactn_exito = new JLabel("Creado Exitosamente");
			aactn_exito.setForeground(Color.BLUE);
			aactn_exito.setBounds(180, 420, 200, 25);
			a_actn.add(aactn_exito).setVisible(false);

		fondo.add(a_actn).setVisible(false);

		a_acti = new JPanel();
		a_acti.setLayout(null);
		a_acti.setBounds(50, 25, 485, 475);
		a_acti.setBackground(Color.LIGHT_GRAY);

			aacti_indN = new JLabel("Posicion del Asteroide que desea editar:");
			aacti_indN.setBounds(140, 20, 300, 25);
			a_acti.add(aacti_indN);

			aacti_campoN = new JTextField();
			aacti_campoN.setBounds(145, 50, 200, 25);
			a_acti.add(aacti_campoN);

			aacti_buscar = new JButton("Buscar");
			aacti_buscar.setBounds(145, 80, 200, 25);
			a_acti.add(aacti_buscar);

			//Editar

			aacti_editarN = new JTextField();
			aacti_editarN.setBounds(250, 120, 150, 20);
			a_acti.add(aacti_editarN);

			aacti_ind_editarN = new JLabel("Nombre: ");
			aacti_ind_editarN.setBounds(70, 118, 150, 20);
			a_acti.add(aacti_ind_editarN);

			aacti_editarV = new JTextField();
			aacti_editarV.setBounds(250, 160, 150, 20);
			a_acti.add(aacti_editarV);

			aacti_ind_editarV = new JLabel("Velocidad: ");
			aacti_ind_editarV.setBounds(70, 158, 150, 20);
			a_acti.add(aacti_ind_editarV);

			aacti_editarT = new JTextField();
			aacti_editarT.setBounds(250, 200, 150, 20);
			a_acti.add(aacti_editarT);

			aacti_ind_editarT = new JLabel("Tamano: ");
			aacti_ind_editarT.setBounds(70, 198, 150, 20);
			a_acti.add(aacti_ind_editarT);

			aacti_editarM = new JTextField();
			aacti_editarM.setBounds(250, 240, 150, 20);
			a_acti.add(aacti_editarM);

			aacti_ind_editarM = new JLabel("Material: ");
			aacti_ind_editarM.setBounds(70, 238, 150, 20);
			a_acti.add(aacti_ind_editarM);

			aacti_editarCM = new JTextField();
			aacti_editarCM.setBounds(250, 280, 150, 20);
			a_acti.add(aacti_editarCM);

			aacti_ind_editarCM = new JLabel("Contiene Minerales? ");
			aacti_ind_editarCM.setBounds(70, 278, 150, 20);
			a_acti.add(aacti_ind_editarCM);

			aacti_confirmar = new JButton();
			aacti_confirmar.setBounds(140, 370, 200, 25);
			aacti_confirmar.setText("Listo");
			a_acti.add(aacti_confirmar);

			aacti_exito = new JLabel("Creado Exitosamente");
			aacti_exito.setForeground(Color.BLUE);
			aacti_exito.setBounds(180, 420, 200, 25);
			a_acti.add(aacti_exito).setVisible(false);

		fondo.add(a_acti).setVisible(false);

		a_show = new JPanel();
		a_show.setLayout(null);
		a_show.setBounds(50, 25, 485, 475);
		a_show.setBackground(Color.LIGHT_GRAY);

			ashow_console = new JTextArea();
			ashow_console.setBounds(43, 25, 400, 400);
			ashow_console.setBackground(Color.BLACK);
			ashow_console.setForeground(Color.WHITE);
			a_show.add(ashow_console);

		fondo.add(a_show).setVisible(false);

		//Agujeros
		bh_crear = new JPanel();
		bh_crear.setLayout(null);
		bh_crear.setBounds(50, 25, 485, 475);
		bh_crear.setBackground(Color.LIGHT_GRAY);

			bhcrear_campoN = new JTextField();
			bhcrear_campoN.setBounds(250, 70, 150, 20);
			bh_crear.add(bhcrear_campoN);

			bhcrear_indN = new JLabel("Nombre: ");
			bhcrear_indN.setBounds(70, 68, 150, 20);
			bh_crear.add(bhcrear_indN);

			bhcrear_campoM = new JTextField();
			bhcrear_campoM.setBounds(250, 110, 150, 20);
			bh_crear.add(bhcrear_campoM);

			bhcrear_indM = new JLabel("Masa: ");
			bhcrear_indM.setBounds(70, 108, 150, 20);
			bh_crear.add(bhcrear_indM);

			bhcrear_campoMA = new JTextField();
			bhcrear_campoMA.setBounds(250, 150, 150, 20);
			bh_crear.add(bhcrear_campoMA);

			bhcrear_indMA = new JLabel("Momento Angular: ");
			bhcrear_indMA.setBounds(70, 148, 150, 20);
			bh_crear.add(bhcrear_indMA);

			bhcrear_campoG = new JTextField();
			bhcrear_campoG.setBounds(250, 190, 150, 20);
			bh_crear.add(bhcrear_campoG);

			bhcrear_indG = new JLabel("Gravedad: ");
			bhcrear_indG.setBounds(70, 188, 150, 20);
			bh_crear.add(bhcrear_indG);

			bhcrear_campoD = new JTextField();
			bhcrear_campoD.setBounds(250, 230, 150, 20);
			bh_crear.add(bhcrear_campoD);

			bhcrear_indD = new JLabel("Diametro: ");
			bhcrear_indD.setBounds(70, 228, 150, 20);
			bh_crear.add(bhcrear_indD);

			bhcrear_confirmar = new JButton();
			bhcrear_confirmar.setBounds(140, 320, 200, 25);
			bhcrear_confirmar.setText("Listo");
			bh_crear.add(bhcrear_confirmar);

			bhcrear_exito = new JLabel("Creado Exitosamente");
			bhcrear_exito.setForeground(Color.BLUE);
			bhcrear_exito.setBounds(180, 370, 200, 25);
			bh_crear.add(bhcrear_exito).setVisible(false);

		fondo.add(bh_crear).setVisible(false);

		bh_deln = new JPanel();
		bh_deln.setLayout(null);
		bh_deln.setBounds(50, 25, 485, 475);
		bh_deln.setBackground(Color.LIGHT_GRAY);

			bhdeln_campoN = new JTextField();
			bhdeln_campoN.setBounds(250, 70, 150, 20);
			bh_deln.add(bhdeln_campoN);

			bhdeln_indN = new JLabel("Agujero N. que desea eliminar: ");
			bhdeln_indN.setBounds(70, 68, 230, 20);
			bh_deln.add(bhdeln_indN);

			bhdeln_confirmar = new JButton();
			bhdeln_confirmar.setBounds(140, 320, 200, 25);
			bhdeln_confirmar.setText("Listo");
			bh_deln.add(bhdeln_confirmar);

			bhdeln_exito = new JLabel("Eliminado Exitosamente");
			bhdeln_exito.setForeground(Color.BLUE);
			bhdeln_exito.setBounds(180, 370, 200, 25);
			bh_deln.add(bhdeln_exito).setVisible(false);

			bhdeln_error = new JLabel("Error en la Eliminacion");
			bhdeln_error.setForeground(Color.RED);
			bhdeln_error.setBounds(180, 370, 200, 25);
			bh_deln.add(bhdeln_error).setVisible(false);

		fondo.add(bh_deln).setVisible(false);

		bh_deli = new JPanel();
		bh_deli.setLayout(null);
		bh_deli.setBounds(50, 25, 485, 475);
		bh_deli.setBackground(Color.LIGHT_GRAY);

			bhdeli_campoI = new JTextField();
			bhdeli_campoI.setBounds(280, 70, 150, 20);
			bh_deli.add(bhdeli_campoI);

			bhdeli_indI = new JLabel("Posicion del Agujero N. que desea eliminar: ");
			bhdeli_indI.setBounds(30, 68, 260, 20);
			bh_deli.add(bhdeli_indI);

			bhdeli_confirmar = new JButton();
			bhdeli_confirmar.setBounds(140, 320, 200, 25);
			bhdeli_confirmar.setText("Listo");
			bh_deli.add(bhdeli_confirmar);

			bhdeli_exito = new JLabel("Eliminado Exitosamente");
			bhdeli_exito.setForeground(Color.BLUE);
			bhdeli_exito.setBounds(180, 370, 200, 25);
			bh_deli.add(bhdeli_exito).setVisible(false);

			bhdeli_error = new JLabel("Error en la Eliminacion");
			bhdeli_error.setForeground(Color.RED);
			bhdeli_error.setBounds(180, 370, 200, 25);
			bh_deli.add(bhdeli_error).setVisible(false);

		fondo.add(bh_deli).setVisible(false);

		bh_actn = new JPanel();
		bh_actn.setLayout(null);
		bh_actn.setBounds(50, 25, 485, 475);
		bh_actn.setBackground(Color.LIGHT_GRAY);

			bhactn_indN = new JLabel("Nombre del Agujero N. que desea editar:");
			bhactn_indN.setBounds(140, 20, 300, 25);
			bh_actn.add(bhactn_indN);

			bhactn_campoN = new JTextField();
			bhactn_campoN.setBounds(145, 50, 200, 25);
			bh_actn.add(bhactn_campoN);

			bhactn_buscar = new JButton("Buscar");
			bhactn_buscar.setBounds(145, 80, 200, 25);
			bh_actn.add(bhactn_buscar);

			//Editar

			bhactn_editarN = new JTextField();
			bhactn_editarN.setBounds(250, 120, 150, 20);
			bh_actn.add(bhactn_editarN);

			bhactn_ind_editarN = new JLabel("Nombre: ");
			bhactn_ind_editarN.setBounds(70, 118, 150, 20);
			bh_actn.add(bhactn_ind_editarN);

			bhactn_editarM = new JTextField();
			bhactn_editarM.setBounds(250, 160, 150, 20);
			bh_actn.add(bhactn_editarM);

			bhactn_ind_editarM = new JLabel("Masa: ");
			bhactn_ind_editarM.setBounds(70, 158, 150, 20);
			bh_actn.add(bhactn_ind_editarM);

			bhactn_editarMA = new JTextField();
			bhactn_editarMA.setBounds(250, 200, 150, 20);
			bh_actn.add(bhactn_editarMA);

			bhactn_ind_editarMA = new JLabel("Momento Angular: ");
			bhactn_ind_editarMA.setBounds(70, 198, 150, 20);
			bh_actn.add(bhactn_ind_editarMA);

			bhactn_editarG = new JTextField();
			bhactn_editarG.setBounds(250, 240, 150, 20);
			bh_actn.add(bhactn_editarG);

			bhactn_ind_editarG = new JLabel("Gravedad: ");
			bhactn_ind_editarG.setBounds(70, 238, 150, 20);
			bh_actn.add(bhactn_ind_editarG);

			bhactn_editarD = new JTextField();
			bhactn_editarD.setBounds(250, 280, 150, 20);
			bh_actn.add(bhactn_editarD);

			bhactn_ind_editarD = new JLabel("Diametro: ");
			bhactn_ind_editarD.setBounds(70, 278, 150, 20);
			bh_actn.add(bhactn_ind_editarD);

			bhactn_confirmar = new JButton();
			bhactn_confirmar.setBounds(140, 370, 200, 25);
			bhactn_confirmar.setText("Listo");
			bh_actn.add(bhactn_confirmar);

			bhactn_exito = new JLabel("Creado Exitosamente");
			bhactn_exito.setForeground(Color.BLUE);
			bhactn_exito.setBounds(180, 420, 200, 25);
			bh_actn.add(bhactn_exito).setVisible(false);

		fondo.add(bh_actn).setVisible(false);

		bh_acti = new JPanel();
		bh_acti.setLayout(null);
		bh_acti.setBounds(50, 25, 485, 475);
		bh_acti.setBackground(Color.LIGHT_GRAY);

			bhacti_indN = new JLabel("Posicion del Agujero N. que desea editar:");
			bhacti_indN.setBounds(140, 20, 300, 25);
			bh_acti.add(bhacti_indN);

			bhacti_campoN = new JTextField();
			bhacti_campoN.setBounds(145, 50, 200, 25);
			bh_acti.add(bhacti_campoN);

			bhacti_buscar = new JButton("Buscar");
			bhacti_buscar.setBounds(145, 80, 200, 25);
			bh_acti.add(bhacti_buscar);

			//Editar

			bhacti_editarN = new JTextField();
			bhacti_editarN.setBounds(250, 120, 150, 20);
			bh_acti.add(bhacti_editarN);

			bhacti_ind_editarN = new JLabel("Nombre: ");
			bhacti_ind_editarN.setBounds(70, 118, 150, 20);
			bh_acti.add(bhacti_ind_editarN);

			bhacti_editarM = new JTextField();
			bhacti_editarM.setBounds(250, 160, 150, 20);
			bh_acti.add(bhacti_editarM);

			bhacti_ind_editarM = new JLabel("Masa: ");
			bhacti_ind_editarM.setBounds(70, 158, 150, 20);
			bh_acti.add(bhacti_ind_editarM);

			bhacti_editarMA = new JTextField();
			bhacti_editarMA.setBounds(250, 200, 150, 20);
			bh_acti.add(bhacti_editarMA);

			bhacti_ind_editarMA = new JLabel("Momento Angular: ");
			bhacti_ind_editarMA.setBounds(70, 198, 150, 20);
			bh_acti.add(bhacti_ind_editarMA);

			bhacti_editarG = new JTextField();
			bhacti_editarG.setBounds(250, 240, 150, 20);
			bh_acti.add(bhacti_editarG);

			bhacti_ind_editarG = new JLabel("Gravedad: ");
			bhacti_ind_editarG.setBounds(70, 238, 150, 20);
			bh_acti.add(bhacti_ind_editarG);

			bhacti_editarD = new JTextField();
			bhacti_editarD.setBounds(250, 280, 150, 20);
			bh_acti.add(bhacti_editarD);

			bhacti_ind_editarD = new JLabel("Diametro: ");
			bhacti_ind_editarD.setBounds(70, 278, 150, 20);
			bh_acti.add(bhacti_ind_editarD);

			bhacti_confirmar = new JButton();
			bhacti_confirmar.setBounds(140, 370, 200, 25);
			bhacti_confirmar.setText("Listo");
			bh_acti.add(bhacti_confirmar);

			bhacti_exito = new JLabel("Creado Exitosamente");
			bhacti_exito.setForeground(Color.BLUE);
			bhacti_exito.setBounds(180, 420, 200, 25);
			bh_acti.add(bhacti_exito).setVisible(false);

		fondo.add(bh_acti).setVisible(false);

		bh_show = new JPanel();
		bh_show.setLayout(null);
		bh_show.setBounds(50, 25, 485, 475);
		bh_show.setBackground(Color.LIGHT_GRAY);

			bhshow_console = new JTextArea();
			bhshow_console.setBounds(43, 25, 400, 400);
			bhshow_console.setBackground(Color.BLACK);
			bhshow_console.setForeground(Color.WHITE);
			bh_show.add(bhshow_console);

		fondo.add(bh_show).setVisible(false);

		setVisible(true);
	}




	public JPanel getFondo() {
		return fondo;
	}




	public void setFondo(JPanel fondo) {
		this.fondo = fondo;
	}




	public JMenuBar getMenubar() {
		return menubar;
	}




	public void setMenubar(JMenuBar menubar) {
		this.menubar = menubar;
	}




	public JMenu getPlanetas() {
		return planetas;
	}




	public void setPlanetas(JMenu planetas) {
		this.planetas = planetas;
	}




	public JMenu getGalaxias() {
		return galaxias;
	}




	public void setGalaxias(JMenu galaxias) {
		this.galaxias = galaxias;
	}




	public JMenu getAsteroides() {
		return asteroides;
	}




	public void setAsteroides(JMenu asteroides) {
		this.asteroides = asteroides;
	}




	public JMenu getAgujeros_negros() {
		return agujeros_negros;
	}




	public void setAgujeros_negros(JMenu agujeros_negros) {
		this.agujeros_negros = agujeros_negros;
	}




	public JMenuItem getCrear_planeta() {
		return crear_planeta;
	}




	public void setCrear_planeta(JMenuItem crear_planeta) {
		this.crear_planeta = crear_planeta;
	}




	public JMenuItem getEliminar_planetaNombre() {
		return eliminar_planetaNombre;
	}




	public void setEliminar_planetaNombre(JMenuItem eliminar_planetaNombre) {
		this.eliminar_planetaNombre = eliminar_planetaNombre;
	}




	public JMenuItem getEliminar_planetaIndex() {
		return eliminar_planetaIndex;
	}




	public void setEliminar_planetaIndex(JMenuItem eliminar_planetaIndex) {
		this.eliminar_planetaIndex = eliminar_planetaIndex;
	}




	public JMenuItem getActualizar_planetaNombre() {
		return actualizar_planetaNombre;
	}




	public void setActualizar_planetaNombre(JMenuItem actualizar_planetaNombre) {
		this.actualizar_planetaNombre = actualizar_planetaNombre;
	}




	public JMenuItem getActualizar_planetaIndex() {
		return actualizar_planetaIndex;
	}




	public void setActualizar_planetaIndex(JMenuItem actualizar_planetaIndex) {
		this.actualizar_planetaIndex = actualizar_planetaIndex;
	}




	public JMenuItem getMostrar_planetas() {
		return mostrar_planetas;
	}




	public void setMostrar_planetas(JMenuItem mostrar_planetas) {
		this.mostrar_planetas = mostrar_planetas;
	}




	public JMenuItem getCrear_galaxia() {
		return crear_galaxia;
	}




	public void setCrear_galaxia(JMenuItem crear_galaxia) {
		this.crear_galaxia = crear_galaxia;
	}




	public JMenuItem getEliminar_galaxiaNombre() {
		return eliminar_galaxiaNombre;
	}




	public void setEliminar_galaxiaNombre(JMenuItem eliminar_galaxiaNombre) {
		this.eliminar_galaxiaNombre = eliminar_galaxiaNombre;
	}




	public JMenuItem getEliminar_galaxiaIndex() {
		return eliminar_galaxiaIndex;
	}




	public void setEliminar_galaxiaIndex(JMenuItem eliminar_galaxiaIndex) {
		this.eliminar_galaxiaIndex = eliminar_galaxiaIndex;
	}




	public JMenuItem getActualizar_galaxiaNombre() {
		return actualizar_galaxiaNombre;
	}




	public void setActualizar_galaxiaNombre(JMenuItem actualizar_galaxiaNombre) {
		this.actualizar_galaxiaNombre = actualizar_galaxiaNombre;
	}




	public JMenuItem getActualizar_galaxiaIndex() {
		return actualizar_galaxiaIndex;
	}




	public void setActualizar_galaxiaIndex(JMenuItem actualizar_galaxiaIndex) {
		this.actualizar_galaxiaIndex = actualizar_galaxiaIndex;
	}




	public JMenuItem getMostrar_galaxias() {
		return mostrar_galaxias;
	}




	public void setMostrar_galaxias(JMenuItem mostrar_galaxias) {
		this.mostrar_galaxias = mostrar_galaxias;
	}




	public JMenuItem getCrear_asteroide() {
		return crear_asteroide;
	}




	public void setCrear_asteroide(JMenuItem crear_asteroide) {
		this.crear_asteroide = crear_asteroide;
	}




	public JMenuItem getEliminar_asteroideNombre() {
		return eliminar_asteroideNombre;
	}




	public void setEliminar_asteroideNombre(JMenuItem eliminar_asteroideNombre) {
		this.eliminar_asteroideNombre = eliminar_asteroideNombre;
	}




	public JMenuItem getEliminar_asteroideIndex() {
		return eliminar_asteroideIndex;
	}




	public void setEliminar_asteroideIndex(JMenuItem eliminar_asteroideIndex) {
		this.eliminar_asteroideIndex = eliminar_asteroideIndex;
	}




	public JMenuItem getActualizar_asteroideNombre() {
		return actualizar_asteroideNombre;
	}




	public void setActualizar_asteroideNombre(JMenuItem actualizar_asteroideNombre) {
		this.actualizar_asteroideNombre = actualizar_asteroideNombre;
	}




	public JMenuItem getActualizar_asteroideIndex() {
		return actualizar_asteroideIndex;
	}




	public void setActualizar_asteroideIndex(JMenuItem actualizar_asteroideIndex) {
		this.actualizar_asteroideIndex = actualizar_asteroideIndex;
	}




	public JMenuItem getMostrar_asteroides() {
		return mostrar_asteroides;
	}




	public void setMostrar_asteroides(JMenuItem mostrar_asteroides) {
		this.mostrar_asteroides = mostrar_asteroides;
	}




	public JMenuItem getCrear_agujero() {
		return crear_agujero;
	}




	public void setCrear_agujero(JMenuItem crear_agujero) {
		this.crear_agujero = crear_agujero;
	}




	public JMenuItem getEliminar_agujeroNombre() {
		return eliminar_agujeroNombre;
	}




	public void setEliminar_agujeroNombre(JMenuItem eliminar_agujeroNombre) {
		this.eliminar_agujeroNombre = eliminar_agujeroNombre;
	}




	public JMenuItem getEliminar_agujeroIndex() {
		return eliminar_agujeroIndex;
	}




	public void setEliminar_agujeroIndex(JMenuItem eliminar_agujeroIndex) {
		this.eliminar_agujeroIndex = eliminar_agujeroIndex;
	}




	public JMenuItem getActualizar_agujeroNombre() {
		return actualizar_agujeroNombre;
	}




	public void setActualizar_agujeroNombre(JMenuItem actualizar_agujeroNombre) {
		this.actualizar_agujeroNombre = actualizar_agujeroNombre;
	}




	public JMenuItem getActualizar_agujeroIndex() {
		return actualizar_agujeroIndex;
	}




	public void setActualizar_agujeroIndex(JMenuItem actualizar_agujeroIndex) {
		this.actualizar_agujeroIndex = actualizar_agujeroIndex;
	}




	public JMenuItem getMostrar_agujeros() {
		return mostrar_agujeros;
	}




	public void setMostrar_agujeros(JMenuItem mostrar_agujeros) {
		this.mostrar_agujeros = mostrar_agujeros;
	}




	public JPanel getP_crear() {
		return p_crear;
	}




	public void setP_crear(JPanel p_crear) {
		this.p_crear = p_crear;
	}




	public JPanel getP_deln() {
		return p_deln;
	}




	public void setP_deln(JPanel p_deln) {
		this.p_deln = p_deln;
	}




	public JPanel getP_deli() {
		return p_deli;
	}




	public void setP_deli(JPanel p_deli) {
		this.p_deli = p_deli;
	}




	public JPanel getP_actn() {
		return p_actn;
	}




	public void setP_actn(JPanel p_actn) {
		this.p_actn = p_actn;
	}




	public JPanel getP_acti() {
		return p_acti;
	}




	public void setP_acti(JPanel p_acti) {
		this.p_acti = p_acti;
	}




	public JPanel getP_show() {
		return p_show;
	}




	public void setP_show(JPanel p_show) {
		this.p_show = p_show;
	}




	public JPanel getG_crear() {
		return g_crear;
	}




	public void setG_crear(JPanel g_crear) {
		this.g_crear = g_crear;
	}




	public JPanel getG_deln() {
		return g_deln;
	}




	public void setG_deln(JPanel g_deln) {
		this.g_deln = g_deln;
	}




	public JPanel getG_deli() {
		return g_deli;
	}




	public void setG_deli(JPanel g_deli) {
		this.g_deli = g_deli;
	}




	public JPanel getG_actn() {
		return g_actn;
	}




	public void setG_actn(JPanel g_actn) {
		this.g_actn = g_actn;
	}




	public JPanel getG_acti() {
		return g_acti;
	}




	public void setG_acti(JPanel g_acti) {
		this.g_acti = g_acti;
	}




	public JPanel getG_show() {
		return g_show;
	}




	public void setG_show(JPanel g_show) {
		this.g_show = g_show;
	}




	public JPanel getA_crear() {
		return a_crear;
	}




	public void setA_crear(JPanel a_crear) {
		this.a_crear = a_crear;
	}




	public JPanel getA_deln() {
		return a_deln;
	}




	public void setA_deln(JPanel a_deln) {
		this.a_deln = a_deln;
	}




	public JPanel getA_deli() {
		return a_deli;
	}




	public void setA_deli(JPanel a_deli) {
		this.a_deli = a_deli;
	}




	public JPanel getA_actn() {
		return a_actn;
	}




	public void setA_actn(JPanel a_actn) {
		this.a_actn = a_actn;
	}




	public JPanel getA_acti() {
		return a_acti;
	}




	public void setA_acti(JPanel a_acti) {
		this.a_acti = a_acti;
	}




	public JPanel getA_show() {
		return a_show;
	}




	public void setA_show(JPanel a_show) {
		this.a_show = a_show;
	}




	public JPanel getBh_crear() {
		return bh_crear;
	}




	public void setBh_crear(JPanel bh_crear) {
		this.bh_crear = bh_crear;
	}




	public JPanel getBh_deln() {
		return bh_deln;
	}




	public void setBh_deln(JPanel bh_deln) {
		this.bh_deln = bh_deln;
	}




	public JPanel getBh_deli() {
		return bh_deli;
	}




	public void setBh_deli(JPanel bh_deli) {
		this.bh_deli = bh_deli;
	}




	public JPanel getBh_actn() {
		return bh_actn;
	}




	public void setBh_actn(JPanel bh_actn) {
		this.bh_actn = bh_actn;
	}




	public JPanel getBh_acti() {
		return bh_acti;
	}




	public void setBh_acti(JPanel bh_acti) {
		this.bh_acti = bh_acti;
	}




	public JPanel getBh_show() {
		return bh_show;
	}




	public void setBh_show(JPanel bh_show) {
		this.bh_show = bh_show;
	}




	public JTextField getPcrear_campoN() {
		return pcrear_campoN;
	}




	public void setPcrear_campoN(JTextField pcrear_campoN) {
		this.pcrear_campoN = pcrear_campoN;
	}




	public JTextField getPcrear_campoT() {
		return pcrear_campoT;
	}




	public void setPcrear_campoT(JTextField pcrear_campoT) {
		this.pcrear_campoT = pcrear_campoT;
	}




	public JTextField getPcrear_campoH() {
		return pcrear_campoH;
	}




	public void setPcrear_campoH(JTextField pcrear_campoH) {
		this.pcrear_campoH = pcrear_campoH;
	}




	public JTextField getPcrear_campoG() {
		return pcrear_campoG;
	}




	public void setPcrear_campoG(JTextField pcrear_campoG) {
		this.pcrear_campoG = pcrear_campoG;
	}




	public JTextField getPcrear_campoD() {
		return pcrear_campoD;
	}




	public void setPcrear_campoD(JTextField pcrear_campoD) {
		this.pcrear_campoD = pcrear_campoD;
	}




	public JTextField getPdeln_campoN() {
		return pdeln_campoN;
	}




	public void setPdeln_campoN(JTextField pdeln_campoN) {
		this.pdeln_campoN = pdeln_campoN;
	}




	public JTextField getPdeli_campoI() {
		return pdeli_campoI;
	}




	public void setPdeli_campoI(JTextField pdeli_campoI) {
		this.pdeli_campoI = pdeli_campoI;
	}




	public JTextField getPactn_campoN() {
		return pactn_campoN;
	}




	public void setPactn_campoN(JTextField pactn_campoN) {
		this.pactn_campoN = pactn_campoN;
	}




	public JTextField getPactn_editarN() {
		return pactn_editarN;
	}




	public void setPactn_editarN(JTextField pactn_editarN) {
		this.pactn_editarN = pactn_editarN;
	}




	public JTextField getPactn_editarT() {
		return pactn_editarT;
	}




	public void setPactn_editarT(JTextField pactn_editarT) {
		this.pactn_editarT = pactn_editarT;
	}




	public JTextField getPactn_editarH() {
		return pactn_editarH;
	}




	public void setPactn_editarH(JTextField pactn_editarH) {
		this.pactn_editarH = pactn_editarH;
	}




	public JTextField getPactn_editarG() {
		return pactn_editarG;
	}




	public void setPactn_editarG(JTextField pactn_editarG) {
		this.pactn_editarG = pactn_editarG;
	}




	public JTextField getPactn_editarD() {
		return pactn_editarD;
	}




	public void setPactn_editarD(JTextField pactn_editarD) {
		this.pactn_editarD = pactn_editarD;
	}




	public JTextField getPacti_campoN() {
		return pacti_campoN;
	}




	public void setPacti_campoN(JTextField pacti_campoN) {
		this.pacti_campoN = pacti_campoN;
	}




	public JTextField getPacti_editarN() {
		return pacti_editarN;
	}




	public void setPacti_editarN(JTextField pacti_editarN) {
		this.pacti_editarN = pacti_editarN;
	}




	public JTextField getPacti_editarT() {
		return pacti_editarT;
	}




	public void setPacti_editarT(JTextField pacti_editarT) {
		this.pacti_editarT = pacti_editarT;
	}




	public JTextField getPacti_editarH() {
		return pacti_editarH;
	}




	public void setPacti_editarH(JTextField pacti_editarH) {
		this.pacti_editarH = pacti_editarH;
	}




	public JTextField getPacti_editarG() {
		return pacti_editarG;
	}




	public void setPacti_editarG(JTextField pacti_editarG) {
		this.pacti_editarG = pacti_editarG;
	}




	public JTextField getPacti_editarD() {
		return pacti_editarD;
	}




	public void setPacti_editarD(JTextField pacti_editarD) {
		this.pacti_editarD = pacti_editarD;
	}




	public JLabel getPcrear_indN() {
		return pcrear_indN;
	}




	public void setPcrear_indN(JLabel pcrear_indN) {
		this.pcrear_indN = pcrear_indN;
	}




	public JLabel getPcrear_indT() {
		return pcrear_indT;
	}




	public void setPcrear_indT(JLabel pcrear_indT) {
		this.pcrear_indT = pcrear_indT;
	}




	public JLabel getPcrear_indH() {
		return pcrear_indH;
	}




	public void setPcrear_indH(JLabel pcrear_indH) {
		this.pcrear_indH = pcrear_indH;
	}




	public JLabel getPcrear_indG() {
		return pcrear_indG;
	}




	public void setPcrear_indG(JLabel pcrear_indG) {
		this.pcrear_indG = pcrear_indG;
	}




	public JLabel getPcrear_indD() {
		return pcrear_indD;
	}




	public void setPcrear_indD(JLabel pcrear_indD) {
		this.pcrear_indD = pcrear_indD;
	}




	public JLabel getPcrear_exito() {
		return pcrear_exito;
	}




	public void setPcrear_exito(JLabel pcrear_exito) {
		this.pcrear_exito = pcrear_exito;
	}




	public JLabel getPdeln_indN() {
		return pdeln_indN;
	}




	public void setPdeln_indN(JLabel pdeln_indN) {
		this.pdeln_indN = pdeln_indN;
	}




	public JLabel getPdeln_exito() {
		return pdeln_exito;
	}




	public void setPdeln_exito(JLabel pdeln_exito) {
		this.pdeln_exito = pdeln_exito;
	}




	public JLabel getPdeln_error() {
		return pdeln_error;
	}




	public void setPdeln_error(JLabel pdeln_error) {
		this.pdeln_error = pdeln_error;
	}




	public JLabel getPdeli_indI() {
		return pdeli_indI;
	}




	public void setPdeli_indI(JLabel pdeli_indI) {
		this.pdeli_indI = pdeli_indI;
	}




	public JLabel getPdeli_exito() {
		return pdeli_exito;
	}




	public void setPdeli_exito(JLabel pdeli_exito) {
		this.pdeli_exito = pdeli_exito;
	}




	public JLabel getPdeli_error() {
		return pdeli_error;
	}




	public void setPdeli_error(JLabel pdeli_error) {
		this.pdeli_error = pdeli_error;
	}




	public JLabel getPactn_indN() {
		return pactn_indN;
	}




	public void setPactn_indN(JLabel pactn_indN) {
		this.pactn_indN = pactn_indN;
	}




	public JLabel getPactn_ind_editarN() {
		return pactn_ind_editarN;
	}




	public void setPactn_ind_editarN(JLabel pactn_ind_editarN) {
		this.pactn_ind_editarN = pactn_ind_editarN;
	}




	public JLabel getPactn_ind_editarT() {
		return pactn_ind_editarT;
	}




	public void setPactn_ind_editarT(JLabel pactn_ind_editarT) {
		this.pactn_ind_editarT = pactn_ind_editarT;
	}




	public JLabel getPactn_ind_editarH() {
		return pactn_ind_editarH;
	}




	public void setPactn_ind_editarH(JLabel pactn_ind_editarH) {
		this.pactn_ind_editarH = pactn_ind_editarH;
	}




	public JLabel getPactn_ind_editarG() {
		return pactn_ind_editarG;
	}




	public void setPactn_ind_editarG(JLabel pactn_ind_editarG) {
		this.pactn_ind_editarG = pactn_ind_editarG;
	}




	public JLabel getPactn_ind_editarD() {
		return pactn_ind_editarD;
	}




	public void setPactn_ind_editarD(JLabel pactn_ind_editarD) {
		this.pactn_ind_editarD = pactn_ind_editarD;
	}




	public JLabel getPactn_exito() {
		return pactn_exito;
	}




	public void setPactn_exito(JLabel pactn_exito) {
		this.pactn_exito = pactn_exito;
	}




	public JLabel getPacti_indN() {
		return pacti_indN;
	}




	public void setPacti_indN(JLabel pacti_indN) {
		this.pacti_indN = pacti_indN;
	}




	public JLabel getPacti_ind_editarN() {
		return pacti_ind_editarN;
	}




	public void setPacti_ind_editarN(JLabel pacti_ind_editarN) {
		this.pacti_ind_editarN = pacti_ind_editarN;
	}




	public JLabel getPacti_ind_editarT() {
		return pacti_ind_editarT;
	}




	public void setPacti_ind_editarT(JLabel pacti_ind_editarT) {
		this.pacti_ind_editarT = pacti_ind_editarT;
	}




	public JLabel getPacti_ind_editarH() {
		return pacti_ind_editarH;
	}




	public void setPacti_ind_editarH(JLabel pacti_ind_editarH) {
		this.pacti_ind_editarH = pacti_ind_editarH;
	}




	public JLabel getPacti_ind_editarG() {
		return pacti_ind_editarG;
	}




	public void setPacti_ind_editarG(JLabel pacti_ind_editarG) {
		this.pacti_ind_editarG = pacti_ind_editarG;
	}




	public JLabel getPacti_ind_editarD() {
		return pacti_ind_editarD;
	}




	public void setPacti_ind_editarD(JLabel pacti_ind_editarD) {
		this.pacti_ind_editarD = pacti_ind_editarD;
	}




	public JLabel getPacti_exito() {
		return pacti_exito;
	}




	public void setPacti_exito(JLabel pacti_exito) {
		this.pacti_exito = pacti_exito;
	}




	public JTextArea getPshow_console() {
		return pshow_console;
	}




	public void setPshow_console(JTextArea pshow_console) {
		this.pshow_console = pshow_console;
	}




	public JTextArea getGshow_console() {
		return gshow_console;
	}




	public void setGshow_console(JTextArea gshow_console) {
		this.gshow_console = gshow_console;
	}




	public JTextArea getAshow_console() {
		return ashow_console;
	}




	public void setAshow_console(JTextArea ashow_console) {
		this.ashow_console = ashow_console;
	}




	public JTextArea getBhshow_console() {
		return bhshow_console;
	}




	public void setBhshow_console(JTextArea bhshow_console) {
		this.bhshow_console = bhshow_console;
	}




	public JButton getPcrear_confirmar() {
		return pcrear_confirmar;
	}




	public void setPcrear_confirmar(JButton pcrear_confirmar) {
		this.pcrear_confirmar = pcrear_confirmar;
	}




	public JButton getPdeln_confirmar() {
		return pdeln_confirmar;
	}




	public void setPdeln_confirmar(JButton pdeln_confirmar) {
		this.pdeln_confirmar = pdeln_confirmar;
	}




	public JButton getPdeli_confirmar() {
		return pdeli_confirmar;
	}




	public void setPdeli_confirmar(JButton pdeli_confirmar) {
		this.pdeli_confirmar = pdeli_confirmar;
	}




	public JButton getPactn_buscar() {
		return pactn_buscar;
	}




	public void setPactn_buscar(JButton pactn_buscar) {
		this.pactn_buscar = pactn_buscar;
	}




	public JButton getPactn_confirmar() {
		return pactn_confirmar;
	}




	public void setPactn_confirmar(JButton pactn_confirmar) {
		this.pactn_confirmar = pactn_confirmar;
	}




	public JButton getPacti_buscar() {
		return pacti_buscar;
	}




	public void setPacti_buscar(JButton pacti_buscar) {
		this.pacti_buscar = pacti_buscar;
	}




	public JButton getPacti_confirmar() {
		return pacti_confirmar;
	}




	public void setPacti_confirmar(JButton pacti_confirmar) {
		this.pacti_confirmar = pacti_confirmar;
	}




	public JTextField getGcrear_campoN() {
		return gcrear_campoN;
	}




	public void setGcrear_campoN(JTextField gcrear_campoN) {
		this.gcrear_campoN = gcrear_campoN;
	}




	public JTextField getGcrear_campoCP() {
		return gcrear_campoCP;
	}




	public void setGcrear_campoCP(JTextField gcrear_campoCP) {
		this.gcrear_campoCP = gcrear_campoCP;
	}




	public JTextField getGcrear_campoCE() {
		return gcrear_campoCE;
	}




	public void setGcrear_campoCE(JTextField gcrear_campoCE) {
		this.gcrear_campoCE = gcrear_campoCE;
	}




	public JTextField getGcrear_campoR() {
		return gcrear_campoR;
	}




	public void setGcrear_campoR(JTextField gcrear_campoR) {
		this.gcrear_campoR = gcrear_campoR;
	}




	public JLabel getGcrear_indN() {
		return gcrear_indN;
	}




	public void setGcrear_indN(JLabel gcrear_indN) {
		this.gcrear_indN = gcrear_indN;
	}




	public JLabel getGcrear_indCT() {
		return gcrear_indCT;
	}




	public void setGcrear_indCT(JLabel gcrear_indCT) {
		this.gcrear_indCT = gcrear_indCT;
	}




	public JLabel getGcrear_indCE() {
		return gcrear_indCE;
	}




	public void setGcrear_indCE(JLabel gcrear_indCE) {
		this.gcrear_indCE = gcrear_indCE;
	}




	public JLabel getGcrear_indR() {
		return gcrear_indR;
	}




	public void setGcrear_indR(JLabel gcrear_indR) {
		this.gcrear_indR = gcrear_indR;
	}




	public JLabel getGcrear_exito() {
		return gcrear_exito;
	}




	public void setGcrear_exito(JLabel gcrear_exito) {
		this.gcrear_exito = gcrear_exito;
	}




	public JButton getGcrear_confirmar() {
		return gcrear_confirmar;
	}




	public void setGcrear_confirmar(JButton gcrear_confirmar) {
		this.gcrear_confirmar = gcrear_confirmar;
	}




	public JTextField getGdeln_campoN() {
		return gdeln_campoN;
	}




	public void setGdeln_campoN(JTextField gdeln_campoN) {
		this.gdeln_campoN = gdeln_campoN;
	}




	public JTextField getGdeli_campoI() {
		return gdeli_campoI;
	}




	public void setGdeli_campoI(JTextField gdeli_campoI) {
		this.gdeli_campoI = gdeli_campoI;
	}




	public JTextField getGactn_campoN() {
		return gactn_campoN;
	}




	public void setGactn_campoN(JTextField gactn_campoN) {
		this.gactn_campoN = gactn_campoN;
	}




	public JTextField getGactn_editarN() {
		return gactn_editarN;
	}




	public void setGactn_editarN(JTextField gactn_editarN) {
		this.gactn_editarN = gactn_editarN;
	}




	public JTextField getGactn_editarCP() {
		return gactn_editarCP;
	}




	public void setGactn_editarCP(JTextField gactn_editarCP) {
		this.gactn_editarCP = gactn_editarCP;
	}




	public JTextField getGactn_editarCE() {
		return gactn_editarCE;
	}




	public void setGactn_editarCE(JTextField gactn_editarCE) {
		this.gactn_editarCE = gactn_editarCE;
	}




	public JTextField getGactn_editarR() {
		return gactn_editarR;
	}




	public void setGactn_editarR(JTextField gactn_editarR) {
		this.gactn_editarR = gactn_editarR;
	}




	public JLabel getGdeln_indN() {
		return gdeln_indN;
	}




	public void setGdeln_indN(JLabel gdeln_indN) {
		this.gdeln_indN = gdeln_indN;
	}




	public JLabel getGdeln_exito() {
		return gdeln_exito;
	}




	public void setGdeln_exito(JLabel gdeln_exito) {
		this.gdeln_exito = gdeln_exito;
	}




	public JLabel getGdeln_error() {
		return gdeln_error;
	}




	public void setGdeln_error(JLabel gdeln_error) {
		this.gdeln_error = gdeln_error;
	}




	public JLabel getGdeli_indI() {
		return gdeli_indI;
	}




	public void setGdeli_indI(JLabel gdeli_indI) {
		this.gdeli_indI = gdeli_indI;
	}




	public JLabel getGdeli_exito() {
		return gdeli_exito;
	}




	public void setGdeli_exito(JLabel gdeli_exito) {
		this.gdeli_exito = gdeli_exito;
	}




	public JLabel getGdeli_error() {
		return gdeli_error;
	}




	public void setGdeli_error(JLabel gdeli_error) {
		this.gdeli_error = gdeli_error;
	}




	public JLabel getGactn_indN() {
		return gactn_indN;
	}




	public void setGactn_indN(JLabel gactn_indN) {
		this.gactn_indN = gactn_indN;
	}




	public JLabel getGactn_ind_editarN() {
		return gactn_ind_editarN;
	}




	public void setGactn_ind_editarN(JLabel gactn_ind_editarN) {
		this.gactn_ind_editarN = gactn_ind_editarN;
	}




	public JLabel getGactn_ind_editarCP() {
		return gactn_ind_editarCP;
	}




	public void setGactn_ind_editarCP(JLabel gactn_ind_editarCP) {
		this.gactn_ind_editarCP = gactn_ind_editarCP;
	}




	public JLabel getGactn_ind_editarCE() {
		return gactn_ind_editarCE;
	}




	public void setGactn_ind_editarCE(JLabel gactn_ind_editarCE) {
		this.gactn_ind_editarCE = gactn_ind_editarCE;
	}




	public JLabel getGactn_ind_editarR() {
		return gactn_ind_editarR;
	}




	public void setGactn_ind_editarR(JLabel gactn_ind_editarR) {
		this.gactn_ind_editarR = gactn_ind_editarR;
	}




	public JLabel getGactn_exito() {
		return gactn_exito;
	}




	public void setGactn_exito(JLabel gactn_exito) {
		this.gactn_exito = gactn_exito;
	}




	public JButton getGdeln_confirmar() {
		return gdeln_confirmar;
	}




	public void setGdeln_confirmar(JButton gdeln_confirmar) {
		this.gdeln_confirmar = gdeln_confirmar;
	}




	public JButton getGdeli_confirmar() {
		return gdeli_confirmar;
	}




	public void setGdeli_confirmar(JButton gdeli_confirmar) {
		this.gdeli_confirmar = gdeli_confirmar;
	}




	public JButton getGactn_buscar() {
		return gactn_buscar;
	}




	public void setGactn_buscar(JButton gactn_buscar) {
		this.gactn_buscar = gactn_buscar;
	}




	public JButton getGactn_confirmar() {
		return gactn_confirmar;
	}




	public void setGactn_confirmar(JButton gactn_confirmar) {
		this.gactn_confirmar = gactn_confirmar;
	}




	public JLabel getGacti_indN() {
		return gacti_indN;
	}




	public void setGacti_indN(JLabel gacti_indN) {
		this.gacti_indN = gacti_indN;
	}




	public JLabel getGacti_ind_editarN() {
		return gacti_ind_editarN;
	}




	public void setGacti_ind_editarN(JLabel gacti_ind_editarN) {
		this.gacti_ind_editarN = gacti_ind_editarN;
	}




	public JLabel getGacti_ind_editarCP() {
		return gacti_ind_editarCP;
	}




	public void setGacti_ind_editarCP(JLabel gacti_ind_editarCP) {
		this.gacti_ind_editarCP = gacti_ind_editarCP;
	}




	public JLabel getGacti_ind_editarCE() {
		return gacti_ind_editarCE;
	}




	public void setGacti_ind_editarCE(JLabel gacti_ind_editarCE) {
		this.gacti_ind_editarCE = gacti_ind_editarCE;
	}




	public JLabel getGacti_ind_editarR() {
		return gacti_ind_editarR;
	}




	public void setGacti_ind_editarR(JLabel gacti_ind_editarR) {
		this.gacti_ind_editarR = gacti_ind_editarR;
	}




	public JLabel getGacti_exito() {
		return gacti_exito;
	}




	public void setGacti_exito(JLabel gacti_exito) {
		this.gacti_exito = gacti_exito;
	}




	public JTextField getGacti_campoN() {
		return gacti_campoN;
	}




	public void setGacti_campoN(JTextField gacti_campoN) {
		this.gacti_campoN = gacti_campoN;
	}




	public JTextField getGacti_editarN() {
		return gacti_editarN;
	}




	public void setGacti_editarN(JTextField gacti_editarN) {
		this.gacti_editarN = gacti_editarN;
	}




	public JTextField getGacti_editarCP() {
		return gacti_editarCP;
	}




	public void setGacti_editarCP(JTextField gacti_editarCP) {
		this.gacti_editarCP = gacti_editarCP;
	}




	public JTextField getGacti_editarCE() {
		return gacti_editarCE;
	}




	public void setGacti_editarCE(JTextField gacti_editarCE) {
		this.gacti_editarCE = gacti_editarCE;
	}




	public JTextField getGacti_editarR() {
		return gacti_editarR;
	}




	public void setGacti_editarR(JTextField gacti_editarR) {
		this.gacti_editarR = gacti_editarR;
	}




	public JButton getGacti_buscar() {
		return gacti_buscar;
	}




	public void setGacti_buscar(JButton gacti_buscar) {
		this.gacti_buscar = gacti_buscar;
	}




	public JButton getGacti_confirmar() {
		return gacti_confirmar;
	}




	public void setGacti_confirmar(JButton gacti_confirmar) {
		this.gacti_confirmar = gacti_confirmar;
	}




	public JTextField getAcrear_campoN() {
		return acrear_campoN;
	}




	public void setAcrear_campoN(JTextField acrear_campoN) {
		this.acrear_campoN = acrear_campoN;
	}




	public JTextField getAcrear_campoV() {
		return acrear_campoV;
	}




	public void setAcrear_campoV(JTextField acrear_campoV) {
		this.acrear_campoV = acrear_campoV;
	}




	public JTextField getAcrear_campoT() {
		return acrear_campoT;
	}




	public void setAcrear_campoT(JTextField acrear_campoT) {
		this.acrear_campoT = acrear_campoT;
	}




	public JTextField getAcrear_campoM() {
		return acrear_campoM;
	}




	public void setAcrear_campoM(JTextField acrear_campoM) {
		this.acrear_campoM = acrear_campoM;
	}




	public JTextField getAcrear_campoMN() {
		return acrear_campoMN;
	}




	public void setAcrear_campoMN(JTextField acrear_campoMN) {
		this.acrear_campoMN = acrear_campoMN;
	}




	public JTextField getAdeln_campoN() {
		return adeln_campoN;
	}




	public void setAdeln_campoN(JTextField adeln_campoN) {
		this.adeln_campoN = adeln_campoN;
	}




	public JTextField getAdeli_campoI() {
		return adeli_campoI;
	}




	public void setAdeli_campoI(JTextField adeli_campoI) {
		this.adeli_campoI = adeli_campoI;
	}




	public JTextField getAactn_campoN() {
		return aactn_campoN;
	}




	public void setAactn_campoN(JTextField aactn_campoN) {
		this.aactn_campoN = aactn_campoN;
	}




	public JTextField getAactn_editarN() {
		return aactn_editarN;
	}




	public void setAactn_editarN(JTextField aactn_editarN) {
		this.aactn_editarN = aactn_editarN;
	}




	public JTextField getAactn_editarV() {
		return aactn_editarV;
	}




	public void setAactn_editarV(JTextField aactn_editarV) {
		this.aactn_editarV = aactn_editarV;
	}




	public JTextField getAactn_editarT() {
		return aactn_editarT;
	}




	public void setAactn_editarT(JTextField aactn_editarT) {
		this.aactn_editarT = aactn_editarT;
	}




	public JTextField getAactn_editarM() {
		return aactn_editarM;
	}




	public void setAactn_editarM(JTextField aactn_editarM) {
		this.aactn_editarM = aactn_editarM;
	}




	public JTextField getAactn_editarCM() {
		return aactn_editarCM;
	}




	public void setAactn_editarCM(JTextField aactn_editarCM) {
		this.aactn_editarCM = aactn_editarCM;
	}




	public JLabel getAcrear_indN() {
		return acrear_indN;
	}




	public void setAcrear_indN(JLabel acrear_indN) {
		this.acrear_indN = acrear_indN;
	}




	public JLabel getAcrear_indV() {
		return acrear_indV;
	}




	public void setAcrear_indV(JLabel acrear_indV) {
		this.acrear_indV = acrear_indV;
	}




	public JLabel getAcrear_indT() {
		return acrear_indT;
	}




	public void setAcrear_indT(JLabel acrear_indT) {
		this.acrear_indT = acrear_indT;
	}




	public JLabel getAcrear_indM() {
		return acrear_indM;
	}




	public void setAcrear_indM(JLabel acrear_indM) {
		this.acrear_indM = acrear_indM;
	}




	public JLabel getAcrear_indMN() {
		return acrear_indMN;
	}




	public void setAcrear_indMN(JLabel acrear_indMN) {
		this.acrear_indMN = acrear_indMN;
	}




	public JLabel getAcrear_exito() {
		return acrear_exito;
	}




	public void setAcrear_exito(JLabel acrear_exito) {
		this.acrear_exito = acrear_exito;
	}




	public JLabel getAdeln_indN() {
		return adeln_indN;
	}




	public void setAdeln_indN(JLabel adeln_indN) {
		this.adeln_indN = adeln_indN;
	}




	public JLabel getAdeln_exito() {
		return adeln_exito;
	}




	public void setAdeln_exito(JLabel adeln_exito) {
		this.adeln_exito = adeln_exito;
	}




	public JLabel getAdeln_error() {
		return adeln_error;
	}




	public void setAdeln_error(JLabel adeln_error) {
		this.adeln_error = adeln_error;
	}




	public JLabel getAdeli_indI() {
		return adeli_indI;
	}




	public void setAdeli_indI(JLabel adeli_indI) {
		this.adeli_indI = adeli_indI;
	}




	public JLabel getAdeli_exito() {
		return adeli_exito;
	}




	public void setAdeli_exito(JLabel adeli_exito) {
		this.adeli_exito = adeli_exito;
	}




	public JLabel getAdeli_error() {
		return adeli_error;
	}




	public void setAdeli_error(JLabel adeli_error) {
		this.adeli_error = adeli_error;
	}




	public JLabel getAactn_indN() {
		return aactn_indN;
	}




	public void setAactn_indN(JLabel aactn_indN) {
		this.aactn_indN = aactn_indN;
	}




	public JLabel getAactn_ind_editarN() {
		return aactn_ind_editarN;
	}




	public void setAactn_ind_editarN(JLabel aactn_ind_editarN) {
		this.aactn_ind_editarN = aactn_ind_editarN;
	}




	public JLabel getAactn_ind_editarV() {
		return aactn_ind_editarV;
	}




	public void setAactn_ind_editarV(JLabel aactn_ind_editarV) {
		this.aactn_ind_editarV = aactn_ind_editarV;
	}




	public JLabel getAactn_ind_editarT() {
		return aactn_ind_editarT;
	}




	public void setAactn_ind_editarT(JLabel aactn_ind_editarT) {
		this.aactn_ind_editarT = aactn_ind_editarT;
	}




	public JLabel getAactn_ind_editarM() {
		return aactn_ind_editarM;
	}




	public void setAactn_ind_editarM(JLabel aactn_ind_editarM) {
		this.aactn_ind_editarM = aactn_ind_editarM;
	}




	public JLabel getAactn_exito() {
		return aactn_exito;
	}




	public void setAactn_exito(JLabel aactn_exito) {
		this.aactn_exito = aactn_exito;
	}




	public JLabel getAactn_ind_editarCM() {
		return aactn_ind_editarCM;
	}




	public void setAactn_ind_editarCM(JLabel aactn_ind_editarCM) {
		this.aactn_ind_editarCM = aactn_ind_editarCM;
	}




	public JLabel getAacti_indN() {
		return aacti_indN;
	}




	public void setAacti_indN(JLabel aacti_indN) {
		this.aacti_indN = aacti_indN;
	}




	public JLabel getAacti_ind_editarN() {
		return aacti_ind_editarN;
	}




	public void setAacti_ind_editarN(JLabel aacti_ind_editarN) {
		this.aacti_ind_editarN = aacti_ind_editarN;
	}




	public JLabel getAacti_ind_editarV() {
		return aacti_ind_editarV;
	}




	public void setAacti_ind_editarV(JLabel aacti_ind_editarV) {
		this.aacti_ind_editarV = aacti_ind_editarV;
	}




	public JLabel getAacti_ind_editarT() {
		return aacti_ind_editarT;
	}




	public void setAacti_ind_editarT(JLabel aacti_ind_editarT) {
		this.aacti_ind_editarT = aacti_ind_editarT;
	}




	public JLabel getAacti_ind_editarM() {
		return aacti_ind_editarM;
	}




	public void setAacti_ind_editarM(JLabel aacti_ind_editarM) {
		this.aacti_ind_editarM = aacti_ind_editarM;
	}




	public JLabel getAacti_ind_editarCM() {
		return aacti_ind_editarCM;
	}




	public void setAacti_ind_editarCM(JLabel aacti_ind_editarCM) {
		this.aacti_ind_editarCM = aacti_ind_editarCM;
	}




	public JButton getAcrear_confirmar() {
		return acrear_confirmar;
	}




	public void setAcrear_confirmar(JButton acrear_confirmar) {
		this.acrear_confirmar = acrear_confirmar;
	}




	public JButton getAdeln_confirmar() {
		return adeln_confirmar;
	}




	public void setAdeln_confirmar(JButton adeln_confirmar) {
		this.adeln_confirmar = adeln_confirmar;
	}




	public JButton getAdeli_confirmar() {
		return adeli_confirmar;
	}




	public void setAdeli_confirmar(JButton adeli_confirmar) {
		this.adeli_confirmar = adeli_confirmar;
	}




	public JButton getAactn_buscar() {
		return aactn_buscar;
	}




	public void setAactn_buscar(JButton aactn_buscar) {
		this.aactn_buscar = aactn_buscar;
	}




	public JButton getAactn_confirmar() {
		return aactn_confirmar;
	}




	public void setAactn_confirmar(JButton aactn_confirmar) {
		this.aactn_confirmar = aactn_confirmar;
	}




	public JLabel getAacti_exito() {
		return aacti_exito;
	}




	public void setAacti_exito(JLabel aacti_exito) {
		this.aacti_exito = aacti_exito;
	}




	public JTextField getAacti_campoN() {
		return aacti_campoN;
	}




	public void setAacti_campoN(JTextField aacti_campoN) {
		this.aacti_campoN = aacti_campoN;
	}




	public JTextField getAacti_editarN() {
		return aacti_editarN;
	}




	public void setAacti_editarN(JTextField aacti_editarN) {
		this.aacti_editarN = aacti_editarN;
	}




	public JTextField getAacti_editarV() {
		return aacti_editarV;
	}




	public void setAacti_editarV(JTextField aacti_editarV) {
		this.aacti_editarV = aacti_editarV;
	}




	public JTextField getAacti_editarT() {
		return aacti_editarT;
	}




	public void setAacti_editarT(JTextField aacti_editarT) {
		this.aacti_editarT = aacti_editarT;
	}




	public JTextField getAacti_editarM() {
		return aacti_editarM;
	}




	public void setAacti_editarM(JTextField aacti_editarM) {
		this.aacti_editarM = aacti_editarM;
	}




	public JTextField getAacti_editarCM() {
		return aacti_editarCM;
	}




	public void setAacti_editarCM(JTextField aacti_editarCM) {
		this.aacti_editarCM = aacti_editarCM;
	}




	public JButton getAacti_buscar() {
		return aacti_buscar;
	}




	public void setAacti_buscar(JButton aacti_buscar) {
		this.aacti_buscar = aacti_buscar;
	}




	public JButton getAacti_confirmar() {
		return aacti_confirmar;
	}




	public void setAacti_confirmar(JButton aacti_confirmar) {
		this.aacti_confirmar = aacti_confirmar;
	}




	public JTextField getBhcrear_campoN() {
		return bhcrear_campoN;
	}




	public void setBhcrear_campoN(JTextField bhcrear_campoN) {
		this.bhcrear_campoN = bhcrear_campoN;
	}




	public JTextField getBhcrear_campoM() {
		return bhcrear_campoM;
	}




	public void setBhcrear_campoM(JTextField bhcrear_campoM) {
		this.bhcrear_campoM = bhcrear_campoM;
	}




	public JTextField getBhcrear_campoMA() {
		return bhcrear_campoMA;
	}




	public void setBhcrear_campoMA(JTextField bhcrear_campoMA) {
		this.bhcrear_campoMA = bhcrear_campoMA;
	}




	public JTextField getBhcrear_campoG() {
		return bhcrear_campoG;
	}




	public void setBhcrear_campoG(JTextField bhcrear_campoG) {
		this.bhcrear_campoG = bhcrear_campoG;
	}




	public JTextField getBhcrear_campoD() {
		return bhcrear_campoD;
	}




	public void setBhcrear_campoD(JTextField bhcrear_campoD) {
		this.bhcrear_campoD = bhcrear_campoD;
	}




	public JTextField getBhdeln_campoN() {
		return bhdeln_campoN;
	}




	public void setBhdeln_campoN(JTextField bhdeln_campoN) {
		this.bhdeln_campoN = bhdeln_campoN;
	}




	public JTextField getBhacti_campoN() {
		return bhacti_campoN;
	}




	public void setBhacti_campoN(JTextField bhacti_campoN) {
		this.bhacti_campoN = bhacti_campoN;
	}




	public JTextField getBhacti_editarN() {
		return bhacti_editarN;
	}




	public void setBhacti_editarN(JTextField bhacti_editarN) {
		this.bhacti_editarN = bhacti_editarN;
	}




	public JTextField getBhacti_editarM() {
		return bhacti_editarM;
	}




	public void setBhacti_editarM(JTextField bhacti_editarM) {
		this.bhacti_editarM = bhacti_editarM;
	}




	public JTextField getBhacti_editarMA() {
		return bhacti_editarMA;
	}




	public void setBhacti_editarMA(JTextField bhacti_editarMA) {
		this.bhacti_editarMA = bhacti_editarMA;
	}




	public JTextField getBhdeli_campoI() {
		return bhdeli_campoI;
	}




	public void setBhdeli_campoI(JTextField bhdeli_campoI) {
		this.bhdeli_campoI = bhdeli_campoI;
	}




	public JTextField getBhactn_campoN() {
		return bhactn_campoN;
	}




	public void setBhactn_campoN(JTextField bhactn_campoN) {
		this.bhactn_campoN = bhactn_campoN;
	}




	public JTextField getBhactn_editarN() {
		return bhactn_editarN;
	}




	public void setBhactn_editarN(JTextField bhactn_editarN) {
		this.bhactn_editarN = bhactn_editarN;
	}




	public JTextField getBhactn_editarM() {
		return bhactn_editarM;
	}




	public void setBhactn_editarM(JTextField bhactn_editarM) {
		this.bhactn_editarM = bhactn_editarM;
	}




	public JTextField getBhactn_editarG() {
		return bhactn_editarG;
	}




	public void setBhactn_editarG(JTextField bhactn_editarG) {
		this.bhactn_editarG = bhactn_editarG;
	}




	public JTextField getBhactn_editarD() {
		return bhactn_editarD;
	}




	public void setBhactn_editarD(JTextField bhactn_editarD) {
		this.bhactn_editarD = bhactn_editarD;
	}




	public JTextField getBhacti_editarG() {
		return bhacti_editarG;
	}




	public void setBhacti_editarG(JTextField bhacti_editarG) {
		this.bhacti_editarG = bhacti_editarG;
	}




	public JTextField getBhacti_editarD() {
		return bhacti_editarD;
	}




	public void setBhacti_editarD(JTextField bhacti_editarD) {
		this.bhacti_editarD = bhacti_editarD;
	}




	public JTextField getBhactn_editarMA() {
		return bhactn_editarMA;
	}




	public void setBhactn_editarMA(JTextField bhactn_editarMA) {
		this.bhactn_editarMA = bhactn_editarMA;
	}




	public JLabel getBhcrear_indN() {
		return bhcrear_indN;
	}




	public void setBhcrear_indN(JLabel bhcrear_indN) {
		this.bhcrear_indN = bhcrear_indN;
	}




	public JLabel getBhcrear_indM() {
		return bhcrear_indM;
	}




	public void setBhcrear_indM(JLabel bhcrear_indM) {
		this.bhcrear_indM = bhcrear_indM;
	}




	public JLabel getBhcrear_indMA() {
		return bhcrear_indMA;
	}




	public void setBhcrear_indMA(JLabel bhcrear_indMA) {
		this.bhcrear_indMA = bhcrear_indMA;
	}




	public JLabel getBhcrear_indG() {
		return bhcrear_indG;
	}




	public void setBhcrear_indG(JLabel bhcrear_indG) {
		this.bhcrear_indG = bhcrear_indG;
	}




	public JLabel getBhcrear_indD() {
		return bhcrear_indD;
	}




	public void setBhcrear_indD(JLabel bhcrear_indD) {
		this.bhcrear_indD = bhcrear_indD;
	}




	public JLabel getBhcrear_exito() {
		return bhcrear_exito;
	}




	public void setBhcrear_exito(JLabel bhcrear_exito) {
		this.bhcrear_exito = bhcrear_exito;
	}




	public JLabel getBhdeln_indN() {
		return bhdeln_indN;
	}




	public void setBhdeln_indN(JLabel bhdeln_indN) {
		this.bhdeln_indN = bhdeln_indN;
	}




	public JLabel getBhdeln_exito() {
		return bhdeln_exito;
	}




	public void setBhdeln_exito(JLabel bhdeln_exito) {
		this.bhdeln_exito = bhdeln_exito;
	}




	public JLabel getBhdeln_error() {
		return bhdeln_error;
	}




	public void setBhdeln_error(JLabel bhdeln_error) {
		this.bhdeln_error = bhdeln_error;
	}




	public JLabel getBhdeli_indI() {
		return bhdeli_indI;
	}




	public void setBhdeli_indI(JLabel bhdeli_indI) {
		this.bhdeli_indI = bhdeli_indI;
	}




	public JLabel getBhdeli_exito() {
		return bhdeli_exito;
	}




	public void setBhdeli_exito(JLabel bhdeli_exito) {
		this.bhdeli_exito = bhdeli_exito;
	}




	public JLabel getBhdeli_error() {
		return bhdeli_error;
	}




	public void setBhdeli_error(JLabel bhdeli_error) {
		this.bhdeli_error = bhdeli_error;
	}




	public JLabel getBhactn_indN() {
		return bhactn_indN;
	}




	public void setBhactn_indN(JLabel bhactn_indN) {
		this.bhactn_indN = bhactn_indN;
	}




	public JLabel getBhactn_ind_editarN() {
		return bhactn_ind_editarN;
	}




	public void setBhactn_ind_editarN(JLabel bhactn_ind_editarN) {
		this.bhactn_ind_editarN = bhactn_ind_editarN;
	}




	public JLabel getBhactn_ind_editarM() {
		return bhactn_ind_editarM;
	}




	public void setBhactn_ind_editarM(JLabel bhactn_ind_editarM) {
		this.bhactn_ind_editarM = bhactn_ind_editarM;
	}




	public JLabel getBhactn_ind_editarG() {
		return bhactn_ind_editarG;
	}




	public void setBhactn_ind_editarG(JLabel bhactn_ind_editarG) {
		this.bhactn_ind_editarG = bhactn_ind_editarG;
	}




	public JLabel getBhactn_ind_editarD() {
		return bhactn_ind_editarD;
	}




	public void setBhactn_ind_editarD(JLabel bhactn_ind_editarD) {
		this.bhactn_ind_editarD = bhactn_ind_editarD;
	}




	public JLabel getBhactn_exito() {
		return bhactn_exito;
	}




	public void setBhactn_exito(JLabel bhactn_exito) {
		this.bhactn_exito = bhactn_exito;
	}




	public JLabel getBhacti_indN() {
		return bhacti_indN;
	}




	public void setBhacti_indN(JLabel bhacti_indN) {
		this.bhacti_indN = bhacti_indN;
	}




	public JLabel getBhacti_ind_editarM() {
		return bhacti_ind_editarM;
	}




	public void setBhacti_ind_editarM(JLabel bhacti_ind_editarM) {
		this.bhacti_ind_editarM = bhacti_ind_editarM;
	}




	public JLabel getBhacti_ind_editarN() {
		return bhacti_ind_editarN;
	}




	public void setBhacti_ind_editarN(JLabel bhacti_ind_editarN) {
		this.bhacti_ind_editarN = bhacti_ind_editarN;
	}




	public JLabel getBhacti_ind_editarMA() {
		return bhacti_ind_editarMA;
	}




	public void setBhacti_ind_editarMA(JLabel bhacti_ind_editarMA) {
		this.bhacti_ind_editarMA = bhacti_ind_editarMA;
	}




	public JLabel getBhacti_ind_editarG() {
		return bhacti_ind_editarG;
	}




	public void setBhacti_ind_editarG(JLabel bhacti_ind_editarG) {
		this.bhacti_ind_editarG = bhacti_ind_editarG;
	}




	public JLabel getBhacti_ind_editarD() {
		return bhacti_ind_editarD;
	}




	public void setBhacti_ind_editarD(JLabel bhacti_ind_editarD) {
		this.bhacti_ind_editarD = bhacti_ind_editarD;
	}




	public JLabel getBhacti_exito() {
		return bhacti_exito;
	}




	public void setBhacti_exito(JLabel bhacti_exito) {
		this.bhacti_exito = bhacti_exito;
	}




	public JLabel getBhactn_ind_editarMA() {
		return bhactn_ind_editarMA;
	}




	public void setBhactn_ind_editarMA(JLabel bhactn_ind_editarMA) {
		this.bhactn_ind_editarMA = bhactn_ind_editarMA;
	}




	public JButton getBhcrear_confirmar() {
		return bhcrear_confirmar;
	}




	public void setBhcrear_confirmar(JButton bhcrear_confirmar) {
		this.bhcrear_confirmar = bhcrear_confirmar;
	}




	public JButton getBhdeln_confirmar() {
		return bhdeln_confirmar;
	}




	public void setBhdeln_confirmar(JButton bhdeln_confirmar) {
		this.bhdeln_confirmar = bhdeln_confirmar;
	}




	public JButton getBhdeli_confirmar() {
		return bhdeli_confirmar;
	}




	public void setBhdeli_confirmar(JButton bhdeli_confirmar) {
		this.bhdeli_confirmar = bhdeli_confirmar;
	}




	public JButton getBhactn_buscar() {
		return bhactn_buscar;
	}




	public void setBhactn_buscar(JButton bhactn_buscar) {
		this.bhactn_buscar = bhactn_buscar;
	}




	public JButton getBhactn_confirmar() {
		return bhactn_confirmar;
	}




	public void setBhactn_confirmar(JButton bhactn_confirmar) {
		this.bhactn_confirmar = bhactn_confirmar;
	}




	public JButton getBhacti_buscar() {
		return bhacti_buscar;
	}




	public void setBhacti_buscar(JButton bhacti_buscar) {
		this.bhacti_buscar = bhacti_buscar;
	}




	public JButton getBhacti_confirmar() {
		return bhacti_confirmar;
	}




	public void setBhacti_confirmar(JButton bhacti_confirmar) {
		this.bhacti_confirmar = bhacti_confirmar;
	}

	

	
}
