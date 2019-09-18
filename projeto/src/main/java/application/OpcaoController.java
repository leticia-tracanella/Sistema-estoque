package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import application.model.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class OpcaoController implements Initializable {

	@FXML
	private Button OpcaoCancelar;
	@FXML
	private Button Opcao0k;
	@FXML
	public ComboBox<Categoria> opcategorias;
	@FXML
	private Label LabelText;
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private ObservableList<Categoria> obsCategorias;

	@FXML
	private void pegarValor() throws IOException {
		Categoria categoria = opcategorias.getSelectionModel().getSelectedItem();
		// System.out.println("ID:"+categoria.getId()+" - NOME: "+categoria.getNome());

		// sai do metodo
		if (categoria == null) {
			LabelText.setText("Obrigatório o preenchimento do campo!");
			return;
		}
		if (categoria.getNome().equals("Entrada")) {
			Main.changeScreen("entrada");
		} else if (categoria.getNome().equals("Retirada")) {
			Main.changeScreen("retirada");
		} else {
			Main.changeScreen("alteracao");
		}
	}

	public void carregarCategorias() {
		if (categorias != null && categorias.size() == 3) {
			return;
		}

		Categoria categoria1 = new Categoria(1, "Entrada");
		Categoria categoria2 = new Categoria(2, "Retirada");
		Categoria categoria3 = new Categoria(3, "Alteracao");

		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);

		obsCategorias = FXCollections.observableArrayList(categorias);
		opcategorias.setItems(obsCategorias);
	}

	@FXML
	private void OpcaoCancelar() {
		Main.changeScreen("serial");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.carregarCategorias();
	}
}
