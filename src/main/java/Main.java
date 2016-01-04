package main.java;

/**
 * Created by Ethan on 1/4/16.
 */
public class Main {
    public static void main(String[] args){
        CSVParser parser = new CSVParser(args[0], "http://localhost:3000");
        parser.process();
    }
}
