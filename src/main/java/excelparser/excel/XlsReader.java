package excelparser.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by mav on 11.11.2015.
 */
public class XlsReader {
   protected Iterator<Row> readFile(FileInputStream fileInputStream) throws IOException {
        //Get the workbook instance for XLS file
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        //Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows from first sheet
        return  sheet.iterator();
    }
}
