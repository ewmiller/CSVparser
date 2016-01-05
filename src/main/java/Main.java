package main.java;

/**
 * Created by ewmiller on 1/4/16.
 */
public class Main {
    public static void main(String[] args){

        //args[0] is the filename, args[1] is the server to send results to
        CSVParser2 parser = new CSVParser2();
        parser.process(args[0]);
    }
}
