package excelparser;

import excelparser.excel.ExcelReader;
import org.apache.poi.ss.usermodel.Row;
import excelparser.xml.XmlGenerator;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import java.io.*;
import java.util.Iterator;

/**
 * Created by mav on 11.11.2015.
 */
public class ExcelParser {
    public static void main(String[] args) throws IOException {
        ExcelParser excelParser = new ExcelParser();

        excelParser.parseExcelToXml();
    }

    private void parseExcelToXml() {
        try {
            System.out.println("Enter path to file:");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String path = in.readLine();

            Validator validator = new Validator();

            validator.checkPathToFile(path);

            ExcelReader excelReader = new ExcelReader();

            Iterator<Row> rowIterator = excelReader.readExcelFile(path);

            if(rowIterator != null) {
                XmlGenerator xmlGenerator = new XmlGenerator();

                xmlGenerator.generateXml(rowIterator, "output.xml");
            }

        } catch (FileNotFoundException e ) {
            System.out.println(e.getMessage());

            parseExcelToXml();
        } catch (FileFormatException e ) {
            System.out.println(e.getMessage());

            parseExcelToXml();
        } catch (IOException e) {
            throw new RuntimeException("Error with i/o.");
        }
    }
}
