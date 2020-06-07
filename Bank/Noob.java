import java.io.*;
import java.net.*;


public class Noob {
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
		    URL url = new URL("http://77.248.124.54/php/" + file);
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
