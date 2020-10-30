package dad.javafx.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Modelo {

	StringProperty password = new SimpleStringProperty();
	StringProperty md5 = new SimpleStringProperty();
	StringProperty usuario = new SimpleStringProperty();

	public Modelo(String usuario, String password) {

		this.setPassword(password);
		this.setUsuario(usuario);

	}

	public boolean comprobarPasswordMD5(String ruta) {

		boolean passwordCorrecta = false;
		File archivo = new File(ruta);
		FileReader fr;
		BufferedReader br;
		String linea;

		this.setMd5(DigestUtils.md5Hex(this.getPassword()).toUpperCase());

		try {

			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {

				if (linea.contains(this.getUsuario().toLowerCase()) && linea.contains(this.getMd5())) {

					passwordCorrecta = true;

				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return passwordCorrecta;
	}

	public final StringProperty passwordProperty() {
		return this.password;
	}

	public final String getPassword() {
		return this.passwordProperty().get();
	}

	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public final StringProperty md5Property() {
		return this.md5;
	}

	public final String getMd5() {
		return this.md5Property().get();
	}

	public final void setMd5(final String md5) {
		this.md5Property().set(md5);
	}

	public final StringProperty usuarioProperty() {
		return this.usuario;
	}

	public final String getUsuario() {
		return this.usuarioProperty().get();
	}

	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}

}
