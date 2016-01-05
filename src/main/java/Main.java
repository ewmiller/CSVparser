package main.java;

/**
 * Created by ewmiller on 1/4/16.
 */
public class Main {
    public static void main(String[] args){

        //args[0] is the filename, args[1] is the server to send results to
        CSVParser parser = new CSVParser();
        parser.sendAsJSON(args[0], args[1]);
    }
}
