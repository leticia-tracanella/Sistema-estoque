package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class FinalController implements Initializable{
	
	public void Iniciar() throws IOException{
		Main.changeScreen("serial");
	}
	
	public void sair() throws IOException{
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
