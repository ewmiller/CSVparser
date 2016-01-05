package main.java;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by Ethan on 1/5/16.
 */

//Uses the super-csv library instead of simple string-splitting to read the CSV file
public class CSVParser2 {
    public CSVParser2(){}

    public void process(String fileName){

        //uses CsvListReader from super-csv library
        try {
            Path path = Paths.get("src/main/resources/", fileName);
            File file = new File(path.toUri());
            ICsvListReader reader = new CsvListReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);

            reader.getHeader(true); // the file has a header w/ name of each column

            //array of processors, one for each column of the CSV
            CellProcessor[] processorz = new CellProcessor[]{
                    new NotNull(),
                    new NotNull(),
                    new NotNull(),
                    new Optional(),
                    new NotNull()
            };

            List<Object> carList;
            while((carList = reader.read(processorz)) != null){
                System.out.println(carList);
            }

        } catch(IOException e){
            System.out.println(e);
        }
    }
}
