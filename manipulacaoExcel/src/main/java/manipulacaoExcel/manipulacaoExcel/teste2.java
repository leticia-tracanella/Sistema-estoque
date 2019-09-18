package manipulacaoExcel.manipulacaoExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.commons.collections4.IteratorUtils;



public class teste2 {
    public static void main(String[] args) throws IOException
    {
            FileInputStream file = new FileInputStream(new File("Controle_De_Estoque_Cenesp.xlsx"));
            Workbook workbook = new HSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            
 
            

    }
    public List<?> toList(Iterator<?> iterator){
    	return IteratorUtils.toList(iterator);
    	
    }
}
