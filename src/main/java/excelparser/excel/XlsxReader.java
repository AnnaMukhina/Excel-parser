package excelparser.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by mav on 11.11.2015.
 */
public class XlsxReader {
    protected Iterator<Row> readFile(FileInputStream fileInputStream) throws IOException {
        //Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        return sheet.iterator();
    }
}
