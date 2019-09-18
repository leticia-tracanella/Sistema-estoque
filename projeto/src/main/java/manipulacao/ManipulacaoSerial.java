package manipulacao;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManipulacaoSerial{
	
		@SuppressWarnings({ "resource", "static-access" })
		public boolean verificar(String codigo) {	
		        try
		        {
		            FileInputStream fileSerial = new FileInputStream(new File("Controle_De_Estoque.xlsx"));
		            XSSFWorkbook workbookserial = new XSSFWorkbook(fileSerial);
		            XSSFSheet sheet = workbookserial.getSheetAt(0);
		            Iterator<Row> rowIterator = sheet.iterator();
		            while (rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();
		                Iterator<Cell> cellIterator = row.cellIterator();
		                while (cellIterator.hasNext())
		                {
		                    Cell cell = cellIterator.next();
		                    String a = "";
		                    if (cell.getColumnIndex()==3) {
	                    		a = cell.getStringCellValue();
		                    	if (a.equals(codigo)) {
		                    		return true;
		                    	}else {
		                    		return false;
		                    	}
		                    }
		                }     
		            fileSerial.close();
		            }
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		        return false;
		    }

		
		}	

