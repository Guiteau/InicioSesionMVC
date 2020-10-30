package dad.javafx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Vista extends VBox {
	
	private Label label_usuario, label_password;
	private Button button_acceder, button_cancelar;
	private TextField textField_usuario;
	private PasswordField passwordField;
	
	public Vista() {
		
		super();
		
		label_usuario = new Label("Usuario: ");
		label_password = new Label("Contraseña: ");
		
		button_acceder = new Button("Acceder");
		button_cancelar = new Button("Cancelar");
		
		textField_usuario = new TextField();
		textField_usuario.setPromptText("Usuario");
		
		passwordField = new PasswordField();
		passwordField.setPromptText("Contraseña");

		GridPane gridPane = new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		
		gridPane.setGridLinesVisible(false);
		
		gridPane.add(label_usuario, 0, 0);
		gridPane.add(textField_usuario, 1, 0);
		gridPane.add(label_password, 0, 1);
		gridPane.add(passwordField, 1, 1);
		
		HBox bottomHbox = new HBox(15, button_acceder, button_cancelar);
		bottomHbox.setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(gridPane, bottomHbox);
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(false);
		
	}
	
	public void permitirAcceso() {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Acceso permitido");
		alert.setContentText("Las credenciales de acceso son válidas.");

		alert.showAndWait();
		
	}
	
	public void denegarAcceso() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o la contraseña no son válidos.");

		alert.showAndWait();
		
	}

	public Label getLabel_usuario() {
		return label_usuario;
	}

	public Label getLabel_password() {
		return label_password;
	}

	public Button getButton_acceder() {
		return button_acceder;
	}

	public Button getButton_cancelar() {
		return button_cancelar;
	}

	public TextField getTextField_usuario() {
		return textField_usuario;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

}
