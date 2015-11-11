package excelparser.xml;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by mav on 11.11.2015.
 */
public class XmlGenerator {
    public void generateXml(Iterator<Row> rowIterator, String path) throws IOException {
        StringBuilder output = writeContent(rowIterator);
        writeXmlToFile(output, path);
    }

    private StringBuilder writeContent(Iterator<Row> rowIterator) {
        String beginning = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<table>\n";

        StringBuilder output = new StringBuilder();

        output.append(beginning);

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            output.append("\t<row>\n");
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BOOLEAN:
                        output.append("\t\t<cell>" + cell.getBooleanCellValue() + "</cell>\n");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        output.append("\t\t<cell>" + cell.getNumericCellValue() + "</cell>\n");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        output.append("\t\t<cell>" + cell.getStringCellValue() + "</cell>\n");
                        break;
                }
            }
            output.append("\t</row>\n");
        }
        output.append("</table>");
        return output;
    }

    private void writeXmlToFile(StringBuilder output, String path) throws IOException {
        FileWriter out = new FileWriter(path);

        out.write(String.valueOf(output));

        out.close();
    }
}