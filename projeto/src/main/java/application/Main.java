package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	
	private static Stage stage;
	private static Scene usuarioScene;
	private static Scene serialScene;
	private static Scene opcaoScene;
	private static Scene entradaScene;
	private static Scene saidaScene;
	private static Scene alteracaoScene;
	private static Scene finalScene;

	@Override
	public void start(Stage primaryStage) throws IOException{
		stage = primaryStage;
		
		primaryStage.setTitle("Sistema de Estoque");
		
		Pane fxmlUsuario = FXMLLoader.load(getClass().getResource("Usuario.fxml"));
		usuarioScene = new Scene(fxmlUsuario, 466, 233);
		
		Pane fxmlSerial = FXMLLoader.load(getClass().getResource("Serial.fxml"));
		serialScene = new Scene(fxmlSerial, 322, 212);
		
		Pane fxmlOpcao = FXMLLoader.load(getClass().getResource("Opcao.fxml"));
		opcaoScene = new Scene(fxmlOpcao, 412, 205);
		
		Pane fxmlEntrada = FXMLLoader.load(getClass().getResource("Entrada.fxml"));
		entradaScene = new Scene(fxmlEntrada, 770, 510);
		
		Pane fxmlSaida = FXMLLoader.load(getClass().getResource("Saida.fxml"));
		saidaScene = new Scene(fxmlSaida, 770, 438);
		
		Pane fxmlAlteracao = FXMLLoader.load(getClass().getResource("Alteracao.fxml"));
		alteracaoScene = new Scene(fxmlAlteracao, 800, 800);
		
		Pane fxmlFinal = FXMLLoader.load(getClass().getResource("Final.fxml"));
		finalScene = new Scene(fxmlFinal, 316, 220);
		
		primaryStage.setScene(usuarioScene);
		primaryStage.show();
	}
	public static void changeScreen(String src) {
		switch (src){
			case "usuario":
				stage.setScene(usuarioScene);
				break;
			case "serial":
				stage.setScene(serialScene);
				break;
			case "opcao":
				stage.setScene(opcaoScene);
				break;
			case "entrada":
				stage.setScene(entradaScene);
				break;
			case "retirada":
				stage.setScene(saidaScene);
				break;
			case "alteracao":
				stage.setScene(alteracaoScene);
				break;
			case "final":
				stage.setScene(finalScene);
				break;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
