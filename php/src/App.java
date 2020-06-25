import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class App {

    public static void main(String[] args) throws IOException {

        try {
            String rekeningnmr ="OZ-TEST-12345678";
            FileWriter myWriter = new FileWriter("test.txt");
            myWriter.write(rekeningnmr);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            // open a connection to the site
            URL url = new URL("http://77.248.124.54/php/test.php");
            URLConnection con = url.openConnection();
            // activate the output
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            // send your parameters to your site
            ps.print("firstKey=eerste");
            ps.print("&secondKey=tweede");

            // we have to get the input stream in order to actually send the request
            con.getInputStream();

            // close the print stream
            ps.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // file is .php bestand
        // inlogen is inlogen.php
    
        public String phpverbinding(String rekeningnmr, String file) throws IOException {
            String returnstring = null;
            try {
                FileWriter myWriter = new FileWriter("test.txt");
                myWriter.write(rekeningnmr);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
                try {
                // open a connection to the site
                URL url = new URL("http://77.248.124.54/gui4/src/" + file);
                URLConnection con = url.openConnection();
                // activate the output
                con.setDoOutput(true);
                // we have to get the input stream in order to actually send the request
                con.getInputStream();
                // close the print stream
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println("code: " + line);
                    returnstring = line;
                }
                //con.getInputStream().close();
            } catch (MalformedURLException e) {
        
            }
                return returnstring;
        
            }
    }
}

