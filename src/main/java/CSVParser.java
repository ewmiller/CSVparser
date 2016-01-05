package main.java;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;
import java.net.*;
import org.json.simple.*;


/**
 * Created by ewmiller on 1/4/16.
 */
public class CSVParser {

    public CSVParser(){

    }

    public void sendAsJSON(String fileName, String serverName){
        System.out.println(fileName);
        System.out.println(serverName);

        try {
            Path path = Paths.get("src/main/resources/", fileName);
            File file = new File(path.toUri());
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                processLineToJSON(line, serverName);
            }
            br.close();
        } catch(IOException e){
            System.out.println("Error when reading file: " + e);
        }
    }

    //format line as a JSON object, pass it to the send() method
    //uses json-simple library
    private void processLineToJSON(String line, String serverName) {
        //this will involve parsing and such later
        String[] tokens = line.split(",");
//        CsvListReader csvReader = new CsvListReader()
        JSONObject obj = new JSONObject();
        for(int i = 0; i < tokens.length; i++) {
            obj.put(Integer.toString(i), tokens[i]);
        }
        sendJSON(obj, serverName);
    }

    //send the info to a server
    private void sendJSON(JSONObject json, String serverName) {
        try {
            URL url = new URL(serverName);
            String charset = "UTF-8";
            URLConnection connection = url.openConnection();

            //POST request
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", charset);
            connection.setRequestProperty("Content-Type", "application/json" + charset);
            OutputStream output = connection.getOutputStream();
            output.write(json.toString().getBytes(charset));

            //Response
            InputStream response = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            String s;
            while((s = reader.readLine()) != null){
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }


}
