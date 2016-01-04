package main.java;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;

/**
 * Created by Ethan on 1/4/16.
 */
public class CSVParser {

    String fileName;
    String serverName;


    public CSVParser(String fileName, String serverName){
        this.fileName = fileName;
        this.serverName = serverName;
    }

    public void process(){
        System.out.println(fileName);
        System.out.println(serverName);

        try {
            Path path = Paths.get("src/main/resources/", fileName);
            File file = new File(path.toUri());
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch(IOException e){
            System.out.println("Error when reading file: " + e);
        }
    }



}
