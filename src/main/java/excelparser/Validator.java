package excelparser;

import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import java.io.*;

/**
 * Created by mav on 16.11.2015.
 */
public class Validator {
    protected void checkPathToFile(String path) throws FileFormatException, FileNotFoundException {
        String extension = path.substring(path.lastIndexOf(".") + 1);

        if(extension.equals("xls") || extension.equals("xlsx")) {
            File file = new File(path);

            if(!file.exists() || !file.isFile()) {
                throw new FileNotFoundException("File was not found. Please enter valid path to file.");
            }
        }
        else {
            throw new FileFormatException("File must have .xls or .xlsx format." +
                    " Please enter path to file with supported format.");
        }
    }
}
