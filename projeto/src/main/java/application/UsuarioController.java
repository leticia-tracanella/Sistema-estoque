package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class UsuarioController implements Initializable {
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private PasswordField senha;
    @FXML private TextField usuario;
    @FXML private Label labelMensagem;

	@FXML
	private void acaoDoBotao1() throws IOException {
		if(usuario.getText().equals("Admin") && senha.getText().equals("Admin123")) {
			Main.changeScreen("serial");
		}
		else {
			labelMensagem.setText("Usuario ou senha incorretos!");
		}
	}
	
    @FXML
    private void botaoCancelar(ActionEvent event) {
    	System.exit(0);
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	} 
}