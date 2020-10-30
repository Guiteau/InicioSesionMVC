package dad.javafx.inicioSesionMVC;

import dad.javafx.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private Controller controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new Controller();
		
		Scene escena = new Scene(controller.getVista(), 300, 150);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Iniciar sesión");		
		primaryStage.show();
		
		controller.cierraVentana.addListener((ob, ov, nv)->{
			
			if(nv == true) 

				primaryStage.close();
			
		});
		
	}

	public static void main(String[] args) {

		launch(args);
		
	}

}
