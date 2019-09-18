package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import application.model.Serie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@SuppressWarnings("unused")
public class EntradaController implements Initializable {

	@FXML
	private TextField DR;
	@FXML
	private TextField PATRIMONIO;
	@FXML
	private TextField MODELO;
	@FXML
	private TextField EMPRESA;
	@FXML
	private TextField NP;
	@FXML
	private Label LABEL;
	@FXML
	private TextField NNF;
	@FXML
	private TextField AR;
	@FXML
	private TextField TIPO;
	@FXML
	private TextField CATEGORIA;
	@FXML
	private TextField MARCA;
	@FXML
	private TextField VU;
	@FXML
	private TextField EMEI;
	@FXML
	private TextField MC;
	@FXML
    private Label LabelNS;
	@FXML
	private Button botaoOk;
	@FXML
	private Button botaoCancel;
	
	public void numSerie() throws IOException, Exception{
		Serie chamadaSerie = new Serie();
		String dado = chamadaSerie.getValorS();
		LabelNS.setText(dado);
	}
	@SuppressWarnings("resource")
	@FXML
	public void EntradaOk() throws IOException, Exception {
		String marca = "";
		String categoria = "";
		String tipo = "";
		String ar = "";
		String modelo = "";
		String mc = "";
		String emei = "";
		String patrimonio = "";
		String empresa = "";
		String np = "";
		String nnf = "";
		String vu = "";
		String dr = "";
		String se = "ESTOQUE";

		if (MODELO.getText().trim().isEmpty()) {
			LABEL.setText("Obrigatório o preenchimento dos campos!");
			return;
		}else if (AR.getText().trim().isEmpty()) {
			LABEL.setText("Obrigatório o preenchimento dos campos!");
			return;
		}else if(TIPO.getText().trim().isEmpty()) {
			LABEL.setText("Obrigatório o preenchimento dos campos!");
			return;
		}else if (CATEGORIA.getText().trim().isEmpty()) {
			LABEL.setText("Obrigatório o preenchimento dos campos!");
		}else if (MARCA.getText().trim().isEmpty()) {
			LABEL.setText("Obrigatório o preenchimento dos campos!");
		}else {
			modelo = MODELO.getText();
			ar = AR.getText();
			tipo = TIPO.getText();
			categoria = CATEGORIA.getText();
			marca = MARCA.getText();
			mc = MC.getText();
			emei = EMEI.getText();
			patrimonio = PATRIMONIO.getText();
			empresa = EMPRESA.getText();
			np = NP.getText();
			nnf = NNF.getText();
			vu = VU.getText();
			dr = DR.getText();
		}
		try {
			FileInputStream file = new FileInputStream(new File("Controle_De_Estoque.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int nRows = sheet.getPhysicalNumberOfRows();
			Row row = sheet.createRow(nRows);
			
			org.apache.poi.ss.usermodel.Cell drCell = row.createCell(0);
			drCell.setCellValue(dr);

			org.apache.poi.ss.usermodel.Cell patrimonioCell = row.createCell(1);
			patrimonioCell.setCellValue(patrimonio);

			org.apache.poi.ss.usermodel.Cell modeloCell = row.createCell(2);
			modeloCell.setCellValue(modelo);

			org.apache.poi.ss.usermodel.Cell empresaCell = row.createCell(4);
			empresaCell.setCellValue(empresa);

			org.apache.poi.ss.usermodel.Cell npCell = row.createCell(5);
			npCell.setCellValue(np);

			org.apache.poi.ss.usermodel.Cell nnfCell = row.createCell(6);
			nnfCell.setCellValue(nnf);

			org.apache.poi.ss.usermodel.Cell arCell = row.createCell(7);
			arCell.setCellValue(ar);

			org.apache.poi.ss.usermodel.Cell tipoCell = row.createCell(8);
			tipoCell.setCellValue(tipo);

			org.apache.poi.ss.usermodel.Cell categoriaCell = row.createCell(9);
			categoriaCell.setCellValue(categoria);

			org.apache.poi.ss.usermodel.Cell marcaCell = row.createCell(10);
			marcaCell.setCellValue(marca);

			org.apache.poi.ss.usermodel.Cell vuCell = row.createCell(11);
			vuCell.setCellValue(vu);

			org.apache.poi.ss.usermodel.Cell emeiCell = row.createCell(12);
			emeiCell.setCellValue(emei);

			org.apache.poi.ss.usermodel.Cell mcCell = row.createCell(13);
			mcCell.setCellValue(mc);
			
			org.apache.poi.ss.usermodel.Cell seCell = row.createCell(14);
			seCell.setCellValue(se);

			file.close();
			FileOutputStream outFile = new FileOutputStream(new File("Controle_De_Estoque.xlsx"));
			workbook.write(outFile);
			outFile.close();
			System.out.println("Arquivo editado com sucesso");

		} catch (

		FileNotFoundException e) {
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			System.out.println("Erro na edição do arquivo!");
		}
		Main.changeScreen("final");
	}

	@FXML
	public void EntradaCancelar() {
		Main.changeScreen("opcao");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
