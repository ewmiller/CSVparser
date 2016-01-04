package main.java;

/**
 * Created by Ethan on 1/4/16.
 */
public class CSVParser {

    String fileName;

    public CSVParser(String fileName){
        this.fileName = fileName;
    }

    public void output(){
        System.out.println(fileName);
    }
}
