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
                processLine(line);
            }
            br.close();
        } catch(IOException e){
            System.out.println("Error when reading file: " + e);
        }
    }

    //format line as a JSON object, pass it to the send() method
    private void processLine(String line) {
        //this will involve parsing and such later
        String[] tokens = line.split(",");
        JSONObject obj = new JSONObject();
        for(int i = 0; i < tokens.length; i++) {
            obj.put(Integer.toString(i), tokens[i]);
        }
        send(obj);
    }

    //send the info to a server
    private void send(JSONObject json) {
        try {
            URL url = new URL(serverName);
            System.out.println(url);
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
