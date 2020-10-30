package dad.javafx.controller;

import dad.javafx.model.Modelo;
import dad.javafx.view.Vista;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;

public class Controller {

	private Modelo modelo;
	private Vista vista = new Vista();
	public BooleanProperty cierraVentana;

	public Controller() {
		
		cierraVentana = new SimpleBooleanProperty(false);
		vista.getButton_acceder().setOnAction(e -> btnPush(e));
		vista.getButton_cancelar().setOnAction(e -> cancelPush(e));
		
	}

	private BooleanProperty cancelPush(ActionEvent e) {
			
		this.cierraVentana.setValue(true);
		
		return this.cierraVentana;
				
	}

	private void btnPush(ActionEvent e) {
		
		modelo = new Modelo(vista.getTextField_usuario().getText(), vista.getPasswordField().getText());
		
		if (modelo.comprobarPasswordMD5("F:\\Escritorio\\Desarrollo de Aplicaciones Multiplataforma\\2_Recuperacion\\DAD\\programasEclipseJavaFX\\InicioSesionMVC\\src\\main\\resources\\users\\users.csv")) {

			vista.permitirAcceso();

		} else {

			vista.denegarAcceso();

		}

	}
	
	public BooleanProperty isCierraVentana() {
		return cierraVentana;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public Vista getVista() {
		return vista;
	}

}
