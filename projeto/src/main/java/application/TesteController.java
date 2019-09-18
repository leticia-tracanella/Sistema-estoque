package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TesteController {
    @FXML public TextField NC;
    @FXML public TextField LOGIN;
    @FXML public TextField NU;
    @FXML public TextField CC;
    @FXML public TextField LOCALIDADE;
    @FXML public TextField LP;
    @FXML public TextField ARR;
    @FXML public TextField DL;
    @FXML public TextField OBS;
    @FXML public Button RetiradaOK;
    @FXML public Button RetiradaCancelar;
    @FXML private Label LABEL1;
    @FXML private Label LABELRNS;
    
	@SuppressWarnings("resource")
	public void RetiradaBOk(String codigo2) throws IOException {	
    	String lp = null;
    	String nc = null;
    	String nu = null;
    	String localidade = null;
    	String arr = null;
    	String obs = null;
    	String login = null;
    	String cc = null;
    	String dl = null;
    	String labelrns = null;
    	
    	if (LOGIN.getText().trim().isEmpty()) {
			LABEL1.setText("Obrigatório o preenchimento dos campos!");
			return;
    	}else if(LOCALIDADE.getText().trim().isEmpty()) {
			LABEL1.setText("Obrigatório o preenchimento dos campos!");
			return;
    	}else if(ARR.getText().trim().isEmpty()) {
			LABEL1.setText("Obrigatório o preenchimento dos campos!");
			return;
    	}else if (DL.getText().trim().isEmpty()){
			LABEL1.setText("Obrigatório o preenchimento dos campos!");
			return;
    	}else {
    		lp = LP.getText();
    		nc = NC.getText();
    		nu = NU.getText();
    		localidade = LOCALIDADE.getText();
    		arr = ARR.getText();
    		obs = OBS.getText();
    		login = LOGIN.getText();
    		cc = CC.getText();
    		dl = DL.getText();
			
    	}	
    		SerialController chamadaSerial = new SerialController();
    		chamadaSerial.botaoOk();
    		try {
    			FileInputStream fileRetirada = new FileInputStream(new File("Controle_De_Estoque.xlsx"));
    			XSSFWorkbook workbookRetirada = new XSSFWorkbook(fileRetirada);
    			XSSFSheet sheet = workbookRetirada.getSheetAt(0);
    			int nRows2 = sheet.getPhysicalNumberOfRows();
    			Row row = sheet.createRow(nRows2);
    			
    			org.apache.poi.ss.usermodel.Cell lpCell = row.createCell(20);
    			lpCell.setCellValue(lp);

    			org.apache.poi.ss.usermodel.Cell ncCell = row.createCell(15);
    			ncCell.setCellValue(nc);;

    			org.apache.poi.ss.usermodel.Cell nuCell = row.createCell(17);
    			nuCell.setCellValue(nu);;

    			org.apache.poi.ss.usermodel.Cell localidadeCell = row.createCell(19);
    			localidadeCell.setCellValue(localidade);

    			org.apache.poi.ss.usermodel.Cell arrCell = row.createCell(21);
    			arrCell.setCellValue(arr);

    			org.apache.poi.ss.usermodel.Cell obsCell = row.createCell(23);
    			obsCell.setCellValue(obs);

    			org.apache.poi.ss.usermodel.Cell loginCell = row.createCell(16);
    			loginCell.setCellValue(login);

    			org.apache.poi.ss.usermodel.Cell ccCell = row.createCell(18);
    			ccCell.setCellValue(cc);

    			org.apache.poi.ss.usermodel.Cell dlCell = row.createCell(22);
    			dlCell.setCellValue(dl);


    			fileRetirada.close();
    			FileOutputStream outFile = new FileOutputStream(new File("Controle_De_Estoque.xlsx"));
    			workbookRetirada.write(outFile);
    			outFile.close();
    			System.out.println("Arquivo editado com sucesso");

    		} catch (

    		FileNotFoundException e) {
    			System.out.println("Arquivo Excel não encontrado!");
    		} catch (IOException e) {
    			System.out.println("Erro na edição do arquivo!");
    		}
    		
    		
    }
	
    
	@FXML
    public void RetiradaBCancelar() {
    	System.exit(0);
    }

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
