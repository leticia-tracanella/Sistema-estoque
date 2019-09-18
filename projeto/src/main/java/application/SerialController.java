package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Serie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import manipulacao.ManipulacaoSerial;

public class SerialController implements Initializable {
    @FXML public TextField nSerial;
    @FXML private Button opcaoCancelar;
    @FXML private Button opcaoOk;
    @FXML private Label labelM;
    public static Serie serie;

    ManipulacaoSerial chamada = new ManipulacaoSerial();
   	String valor = nSerial.getText();
    serie.setValorS(valor);
    @FXML
    public void botaoOk() throws IOException {
    if (nSerial == null || nSerial.getText().isEmpty()) {
    	labelM.setText("Obrigat�rio o preenchimento do campo!");
    }else {
 
        chamada.verificar(valor);
    	Main.changeScreen("opcao");
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
	
