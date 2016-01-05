package main.java;

import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ethan on 1/5/16.
 */

//Uses the super-csv library instead of simple string-splitting to read the CSV file
public class CSVParser2 {
    public CSVParser2(){}

    public void process(String fileName){
        try {
            Path path = Paths.get("src/main/resources/", fileName);
            File file = new File(path.toUri());
            ICsvListReader reader = new CsvListReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
