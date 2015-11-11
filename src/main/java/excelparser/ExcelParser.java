package excelparser;

import excelparser.excel.ExcelReader;
import org.apache.poi.ss.usermodel.Row;
import excelparser.xml.XmlGenerator;

import java.io.*;
import java.util.Iterator;

/**
 * Created by mav on 11.11.2015.
 */
public class ExcelParser {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter path to file:");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String path = in.readLine();

        ExcelReader excelReader = new ExcelReader();

        Iterator<Row> rowIterator = excelReader.readExcelFile(path);

        if(rowIterator != null) {
            XmlGenerator xmlGenerator = new XmlGenerator();

            xmlGenerator.generateXml(rowIterator, "output.xml");
        }
        else {
            System.out.println("File format is not supported, sorry :(");
        }
    }
}
