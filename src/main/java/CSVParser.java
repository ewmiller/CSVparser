package main.java;

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

    public void output(){
        System.out.println(fileName);
        System.out.println(serverName);
    }


}
