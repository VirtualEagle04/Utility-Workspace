package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner.NumberEditor;

import co.edu.unbosque.model.AgujeroNegroDAO;
import co.edu.unbosque.model.AsteroideDAO;
import co.edu.unbosque.model.GalaxiaDAO;
import co.edu.unbosque.model.PlanetaDAO;
import co.edu.unbosque.model.PlanetaDTO;
import co.edu.unbosque.view.Console;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener{

	private PlanetaDAO pdao;
	private GalaxiaDAO gdao;
	private AsteroideDAO adao;
	private AgujeroNegroDAO bhdao;

	private Console con;
	private VentanaPrincipal vp;
	private int temp_indice;
	
	public Controller() {
		pdao = new PlanetaDAO();
		gdao = new GalaxiaDAO();
		adao = new AsteroideDAO();
		bhdao = new AgujeroNegroDAO();

		con = new Console();		
	}
	
	public void correrGUI() {
		vp = new VentanaPrincipal();
		agregarLectores();
	}
	
	public void agregarLectores() {

		//Planetas
		vp.getCrear_planeta().addActionListener(this);
		vp.getCrear_planeta().setActionCommand("MenuCrearPlaneta");

		vp.getPcrear_confirmar().addActionListener(this);
		vp.getPcrear_confirmar().setActionCommand("MenuPCrearConfirmar");

		vp.getEliminar_planetaNombre().addActionListener(this);
		vp.getEliminar_planetaNombre().setActionCommand("MenuEliminarPlanetaNombre");

		vp.getPdeln_confirmar().addActionListener(this);
		vp.getPdeln_confirmar().setActionCommand("MenuPDelnConfirmar");

		vp.getEliminar_planetaIndex().addActionListener(this);
		vp.getEliminar_planetaIndex().setActionCommand("MenuEliminarPlanetaIndex");

		vp.getPdeli_confirmar().addActionListener(this);
		vp.getPdeli_confirmar().setActionCommand("MenuPDeliConfirmar");

		vp.getActualizar_planetaNombre().addActionListener(this);
		vp.getActualizar_planetaNombre().setActionCommand("MenuActualizarPlanetaNombre");

		vp.getPactn_confirmar().addActionListener(this);
		vp.getPactn_confirmar().setActionCommand("MenuPActnConfirmar");

		vp.getPactn_buscar().addActionListener(this);
		vp.getPactn_buscar().setActionCommand("MenuPActnBuscar");

		vp.getActualizar_planetaIndex().addActionListener(this);
		vp.getActualizar_planetaIndex().setActionCommand("MenuActualizarPlanetaIndex");

		vp.getPacti_buscar().addActionListener(this);
		vp.getPacti_buscar().setActionCommand("MenuPActiBuscar");

		vp.getPacti_confirmar().addActionListener(this);
		vp.getPacti_confirmar().setActionCommand("MenuPactiConfirmar");

		vp.getMostrar_planetas().addActionListener(this);
		vp.getMostrar_planetas().setActionCommand("MenuMostrarPlanetas");


		//Galaxia
		vp.getCrear_galaxia().addActionListener(this);
		vp.getCrear_galaxia().setActionCommand("MenuCrearGalaxia");

		vp.getGcrear_confirmar().addActionListener(this);
		vp.getGcrear_confirmar().setActionCommand("MenuGCrearConfirmar");

		vp.getGcrear_confirmar().addActionListener(this);
		vp.getGcrear_confirmar().setActionCommand("MenuGDelnConfirmar");

		vp.getEliminar_galaxiaNombre().addActionListener(this);
		vp.getEliminar_galaxiaNombre().setActionCommand("MenuEliminarGalaxiaNombre");

		vp.getGdeln_confirmar().addActionListener(this);
		vp.getGdeln_confirmar().setActionCommand("MenuGDelnConfirmar");

		vp.getEliminar_galaxiaIndex().addActionListener(this);
		vp.getEliminar_galaxiaIndex().setActionCommand("MenuEliminarGalaxiaIndex");

		vp.getGdeli_confirmar().addActionListener(this);
		vp.getGdeli_confirmar().setActionCommand("MenuGDeliConfirmar");

		vp.getActualizar_galaxiaNombre().addActionListener(this);
		vp.getActualizar_galaxiaNombre().setActionCommand("MenuActualizarGalaxiaNombre");
		
		vp.getGacti_confirmar().addActionListener(this);
		vp.getGacti_confirmar().setActionCommand("MenuGactnConfirmar");

		vp.getGactn_confirmar().addActionListener(this);
		vp.getGactn_confirmar().setActionCommand("MenuGActnConfirmar");

		vp.getActualizar_galaxiaIndex().addActionListener(this);
		vp.getActualizar_galaxiaIndex().setActionCommand("MenuActualizarGalaxiaIndex");

		vp.getGacti_buscar().addActionListener(this);
		vp.getGacti_buscar().setActionCommand("MenuGactiBuscar");

		vp.getGacti_confirmar().addActionListener(this);
		vp.getGacti_confirmar().setActionCommand("MenuGActiConfirmar");

		vp.getMostrar_galaxias().addActionListener(this);
		vp.getMostrar_galaxias().setActionCommand("MenuMostrarGalaxias");

		//Asteroides
		vp.getCrear_asteroide().addActionListener(this);
		vp.getCrear_asteroide().setActionCommand("MenuCrearAsteroide");

		vp.getAcrear_confirmar().addActionListener(this);
		vp.getAcrear_confirmar().setActionCommand("MenuACrearConfirmar");

		vp.getEliminar_asteroideNombre().addActionListener(this);
		vp.getEliminar_asteroideNombre().setActionCommand("MenuEliminarAsteroideNombre");

		vp.getGdeln_confirmar().addActionListener(this);
		vp.getGdeln_confirmar().setActionCommand("MenuGDelnConfirmar");

		vp.getEliminar_asteroideIndex().addActionListener(this);
		vp.getEliminar_asteroideIndex().setActionCommand("MenuEliminarAsteroideIndex");

		vp.getGdeli_confirmar().addActionListener(this);
		vp.getGdeli_confirmar().setActionCommand("MenuGDeliConfirmar");

		vp.getActualizar_asteroideNombre().addActionListener(this);
		vp.getActualizar_asteroideNombre().setActionCommand("MenuActualizarAsteroideNombre");

		vp.getGactn_confirmar().addActionListener(this);
		vp.getGactn_confirmar().setActionCommand("MenuGActnConfirmar");

		vp.getGactn_buscar().addActionListener(this);
		vp.getGactn_buscar().setActionCommand("MenuGActnBuscar");

		vp.getActualizar_asteroideIndex().addActionListener(this);
		vp.getActualizar_asteroideIndex().setActionCommand("MenuActualizarAsteroideIndex");

		vp.getGacti_confirmar().addActionListener(this);
		vp.getGacti_confirmar().setActionCommand("MenuGActiConfirmar");

		vp.getGacti_buscar().addActionListener(this);
		vp.getGacti_buscar().setActionCommand("MenuGActiBuscar");

		vp.getMostrar_asteroides().addActionListener(this);
		vp.getMostrar_asteroides().setActionCommand("MenuMostrarAsteroides");

		//Agujeros Negros
		vp.getCrear_agujero().addActionListener(this);
		vp.getCrear_agujero().setActionCommand("MenuCrearAgujero");

		vp.getBhcrear_confirmar().addActionListener(this);
		vp.getBhcrear_confirmar().setActionCommand("MenuBHCrearConfirmar");

		vp.getEliminar_agujeroNombre().addActionListener(this);
		vp.getEliminar_agujeroNombre().setActionCommand("MenuEliminarAgujeroNombre");

		vp.getBhdeln_confirmar().addActionListener(this);
		vp.getBhdeln_confirmar().setActionCommand("MenuBHDelnConfirmar");

		vp.getEliminar_agujeroIndex().addActionListener(this);
		vp.getEliminar_agujeroIndex().setActionCommand("MenuEliminarAgujeroIndex");

		vp.getBhdeli_confirmar().addActionListener(this);
		vp.getBhdeli_confirmar().setActionCommand("MenuBHDeliConfirmar");

		vp.getActualizar_agujeroNombre().addActionListener(this);
		vp.getActualizar_agujeroNombre().setActionCommand("MenuActualizarAgujeroNombre");

		vp.getBhactn_confirmar().addActionListener(this);
		vp.getBhactn_confirmar().setActionCommand("MenuBHActnConfirmar");

		vp.getBhactn_buscar().addActionListener(this);
		vp.getBhactn_buscar().setActionCommand("MenuBHBActnBuscar");

		vp.getActualizar_agujeroIndex().addActionListener(this);
		vp.getActualizar_agujeroIndex().setActionCommand("MenuActualizarAgujeroIndex");

		vp.getBhacti_confirmar().addActionListener(this);
		vp.getBhacti_confirmar().setActionCommand("MenuBHActiConfirmar");

		vp.getBhacti_buscar().addActionListener(this);
		vp.getBhacti_buscar().setActionCommand("MenuBHActi0Buscar");

		vp.getMostrar_agujeros().addActionListener(this);
		vp.getMostrar_agujeros().setActionCommand("MenuMostrarAgujeros");


		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		principal: switch(e.getActionCommand()) {
			case "MenuCrearPlaneta":{

				vp.getP_crear().setVisible(true);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);


				break;
			}
			case "MenuPCrearConfirmar": {

				boolean validacion = true;

				String temp_nombre = vp.getPcrear_campoN().getText();
				

				float temp_tamano = 0;
				try{
					temp_tamano = Float.parseFloat(vp.getPcrear_campoT().getText());
				}catch (NumberFormatException e2){
					vp.getPcrear_campoT().setText("");
					vp.getPcrear_campoT().setBackground(Color.RED);
					validacion = false;
				}

				boolean temp_h = false;
				if (vp.getPcrear_campoH().getText().toLowerCase().contains("s")){
					temp_h = true;
				}
				else{
					temp_h = false;
				}

				float temp_grav = 0;
				try{
					temp_grav = Float.parseFloat(vp.getPcrear_campoG().getText());
				}catch (NumberFormatException e2){
					vp.getPcrear_campoG().setText("");
					vp.getPcrear_campoG().setBackground(Color.RED);
					validacion = false;
				} 

				float temp_dist = 0;
				try{
					temp_dist = Float.parseFloat(vp.getPcrear_campoD().getText());
				}catch (NumberFormatException e2){
					vp.getPcrear_campoD().setText("");
					vp.getPcrear_campoD().setBackground(Color.RED);
					validacion = false;
				}
				

				if(validacion){
					pdao.crear(temp_nombre, temp_tamano, temp_h, temp_grav, temp_dist);
					vp.getPcrear_campoN().setBackground(Color.WHITE);
					vp.getPcrear_campoT().setBackground(Color.WHITE);
					vp.getPcrear_campoH().setBackground(Color.WHITE);
					vp.getPcrear_campoG().setBackground(Color.WHITE);
					vp.getPcrear_campoD().setBackground(Color.WHITE);

					vp.getPcrear_campoN().setText("");
					vp.getPcrear_campoT().setText("");
					vp.getPcrear_campoH().setText("");
					vp.getPcrear_campoG().setText("");
					vp.getPcrear_campoD().setText("");

				}
				

				break;

			}
			case "MenuEliminarPlanetaNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(true);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuPDelnConfirmar": {

				String temp_eliminiar = vp.getPdeln_campoN().getText();
				 
				if(pdao.eliminarPorNombre(temp_eliminiar)){
					vp.getPdeln_exito().setVisible(true);
					vp.getPdeln_error().setVisible(false);
				}
				else{
					vp.getPdeln_error().setVisible(true);;
					vp.getPdeln_exito().setVisible(false);
				}
				



				break;
			}
			case "MenuEliminarPlanetaIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(true);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuPDeliConfirmar": {

				try{
					int index = Integer.parseInt(vp.getPdeli_campoI().getText());
					if (pdao.eliminarPorIndex(index)){
						vp.getPdeli_exito().setVisible(true);
						vp.getPdeli_error().setVisible(false);
					}

				} catch (NumberFormatException e2){
					vp.getPdeli_error().setVisible(true);
					vp.getPdeli_exito().setVisible(false);
				}

				break;
				
			}
			case "MenuActualizarPlanetaNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(true);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuPActnBuscar": {
				
				String temp_nombre_editar = vp.getPactn_campoN().getText();

				temp_indice = pdao.devolverIndiceNombre(temp_nombre_editar);

				if(temp_indice != 100){
					vp.getPactn_editarN().setText(pdao.getLista().get(temp_indice).getNombre());
					vp.getPactn_editarT().setText(pdao.getLista().get(temp_indice).getTamano()+"");
					if(pdao.getLista().get(temp_indice).isEs_habitable()){
						vp.getPactn_editarH().setText("Si");
					}
					else{
						vp.getPactn_editarH().setText("No");
					}
					vp.getPactn_editarG().setText(pdao.getLista().get(temp_indice).getGravedad()+"");
					vp.getPactn_editarD().setText(pdao.getLista().get(temp_indice).getDistancia_desde_tierra()+"");
					
				}
				else{
					vp.getPactn_editarN().setBackground(Color.RED);
					vp.getPactn_editarT().setBackground(Color.RED);
					vp.getPactn_editarH().setBackground(Color.RED);
					vp.getPactn_editarG().setBackground(Color.RED);
					vp.getPactn_editarD().setBackground(Color.RED);
				}
				
				
				break;
			}
			case "MenuPActnConfirmar": {

				boolean validacion = true;

				String temp_nombre = vp.getPactn_editarN().getText();


				float temp_tamano = 0;
				try{
					temp_tamano = Float.parseFloat(vp.getPactn_editarT().getText());
				}catch (NumberFormatException e2){
					vp.getPactn_editarT().setText("");
					vp.getPactn_editarT().setBackground(Color.RED);
					validacion = false;
				}

				boolean temp_h = false;
				if (vp.getPactn_editarH().getText().toLowerCase().contains("s")){
					temp_h = true;
				}
				else{
					temp_h = false;
				}

				float temp_grav = 0;
				try{
					temp_grav = Float.parseFloat(vp.getPactn_editarG().getText());
				}catch (NumberFormatException e2){
					vp.getPactn_editarG().setText("");
					vp.getPactn_editarG().setBackground(Color.RED);
					validacion = false;
				}

				if(validacion){
					pdao.actualizarPorNombre(vp.getPactn_campoN().getText(), temp_nombre, temp_tamano, temp_h, temp_tamano, temp_grav);
				}

				break;
			}
			case "MenuActualizarPlanetaIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(true);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuPActiBuscar": {
				

				try{
					temp_indice = Integer.parseInt(vp.getPacti_campoN().getText());
				}catch(NumberFormatException e2){
					vp.getPacti_campoN().setText("");
					vp.getPacti_campoN().setBackground(Color.RED);
				}

				if(temp_indice != 100){
					vp.getPacti_editarN().setText(pdao.getLista().get(temp_indice).getNombre());
					vp.getPacti_editarT().setText(pdao.getLista().get(temp_indice).getTamano()+"");
					if(pdao.getLista().get(temp_indice).isEs_habitable()){
						vp.getPacti_editarH().setText("Si");
					}
					else{
						vp.getPacti_editarH().setText("No");
					}
					vp.getPacti_editarG().setText(pdao.getLista().get(temp_indice).getGravedad()+"");
					vp.getPacti_editarD().setText(pdao.getLista().get(temp_indice).getDistancia_desde_tierra()+"");
					
				}
				else{
					vp.getPacti_editarN().setBackground(Color.RED);
					vp.getPacti_editarT().setBackground(Color.RED);
					vp.getPacti_editarH().setBackground(Color.RED);
					vp.getPacti_editarG().setBackground(Color.RED);
					vp.getPacti_editarD().setBackground(Color.RED);
				}
				
				break;
			}
			case "MenuMostrarPlanetas":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(true);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				vp.getPshow_console().setText(pdao.mostrarTodo());

				break;
			}
			
			case "MenuCrearGalaxia":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(true);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuGCrearConfirmar": {

				boolean validacion = true;

				String temp_nombre = vp.getGcrear_campoN().getText();


				int temp_cp = 0;
				try{
					temp_cp = Integer.parseInt(vp.getGcrear_campoCP().getText());
				}catch (NumberFormatException e2){
					vp.getGcrear_campoCP().setText("");
					vp.getGcrear_campoCP().setBackground(Color.RED);
					validacion = false;
				}

				int temp_ce = 0;
				try{
					temp_cp = Integer.parseInt(vp.getGcrear_campoCE().getText());
				}catch (NumberFormatException e2){
					vp.getGcrear_campoCE().setText("");
					vp.getGcrear_campoCE().setBackground(Color.RED);
					validacion = false;
				}

				float temp_r = 0;
				try{
					temp_r = Float.parseFloat(vp.getGcrear_campoR().getText());
				}catch (NumberFormatException e2){
					vp.getGcrear_campoR().setText("");
					vp.getGcrear_campoR().setBackground(Color.RED);
					validacion = false;
				}

				if(validacion){
					gdao.gCrear(temp_nombre, temp_cp, temp_ce, temp_r);
					vp.getGcrear_campoN().setBackground(Color.WHITE);
					vp.getGcrear_campoCP().setBackground(Color.WHITE);
					vp.getGcrear_campoCE().setBackground(Color.WHITE);
					vp.getGcrear_campoR().setBackground(Color.WHITE);
				}

			}
			case "MenuEliminarGalaxiaNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(true);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuEliminarGalaxiaIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(true);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuActualizarGalaxiaNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(true);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuActualizarGalaxiaIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(true);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuMostrarGalaxias":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(true);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuCrearAsteroide":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(true);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuEliminarAsteroideNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(true);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuEliminarAsteroideIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(true);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuActualizarAsteroideNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(true);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuActualizarAsteroideIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(true);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuMostrarAsteroides":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(true);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuCrearAgujero":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(true);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuEliminarAgujeroNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(true);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuEliminarAgujeroIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(true);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuActualizarAgujeroNombre":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(true);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuActualizarAgujeroIndex":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(true);
				vp.getBh_acti().setVisible(false);

				break;
			}
			case "MenuMostrarAgujero":{

				vp.getP_crear().setVisible(false);
				vp.getP_deln().setVisible(false);
				vp.getP_deli().setVisible(false);
				vp.getP_actn().setVisible(false);
				vp.getP_acti().setVisible(false);
				vp.getP_show().setVisible(false);

				vp.getG_crear().setVisible(false);
				vp.getG_deln().setVisible(false);
				vp.getG_deli().setVisible(false);
				vp.getG_actn().setVisible(false);
				vp.getG_acti().setVisible(false);
				vp.getG_show().setVisible(false);

				vp.getA_crear().setVisible(false);
				vp.getA_deln().setVisible(false);
				vp.getA_deli().setVisible(false);
				vp.getA_actn().setVisible(false);
				vp.getA_acti().setVisible(false);
				vp.getA_show().setVisible(false);

				vp.getBh_crear().setVisible(false);
				vp.getBh_deln().setVisible(false);
				vp.getBh_deli().setVisible(false);
				vp.getBh_actn().setVisible(false);
				vp.getBh_acti().setVisible(false);
				vp.getBh_acti().setVisible(true);

				break;
			}
			default: 


		}
		
		
	}

	
	
}
