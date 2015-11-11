package excelparser.excel;

import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by mav on 11.11.2015.
 */
public class ExcelReader {
    public Iterator<Row> readExcelFile (String path) throws IOException {
        String extension = path.substring(path.lastIndexOf(".") + 1);

        if(extension.equals("xls")) {
            FileInputStream fileInputStream = new FileInputStream(new File(path));

            XlsReader xlsReader = new XlsReader();

            Iterator<Row> rowIterator = xlsReader.readFile(fileInputStream);

            fileInputStream.close();

            return rowIterator;
        }
        else if(extension.equals("xlsx")) {
            FileInputStream fileInputStream = new FileInputStream(new File(path));

            XlsxReader xlsxReader = new XlsxReader();

            Iterator<Row> rowIterator =  xlsxReader.readFile(fileInputStream);

            fileInputStream.close();

            return rowIterator;
        } else {
            return  null;
        }
    }
}
