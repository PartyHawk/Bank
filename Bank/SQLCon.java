import java.sql.*;
import java.util.Properties;

public class SQLCon {
	private Connection con;
    private Statement stmt;
    private ResultSet rSet;
    
    public SQLCon() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		Properties p = new Properties();
    		p.put("user", "root");
    		p.put("password", "");
            con = DriverManager.getConnection("jdbc:mysql://localhost/debank", p);
            //145.24.222.152:22
            
            stmt = con.createStatement();

    	}
    	catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet query(String query){
        try{

            rSet = stmt.executeQuery(query);
            return rSet;
            
//            while (rSet.next()){
//                System.out.println(rSet.getString("help_topic_id") + " " + rSet.getString("name"));
//            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getValue(String klantnummer, String column) {
    	try {
	    	String query = "SELECT " + column + " FROM persoonlijkeinfo WHERE klantnummer = '" + klantnummer;
	    	rSet = stmt.executeQuery(query + "'");
	    	rSet.next();
	    	return rSet.getString(column);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public void setValue(String klantnummer, String column, String value) {
    	try {
    		String query = "UPDATE `persoonlijkeinfo` SET " + column + " = " + value + " WHERE klantnummer = '" + klantnummer;
	    	stmt.executeUpdate(query + "'");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void setBlocked(String klantnummer, String value) {
    	try {
    		String query = "UPDATE `persoonlijkeinfo` SET blocked =  " + value + " WHERE  klantnummer = '" + klantnummer;
    		stmt.executeUpdate(query + "'");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void withdraw(String klantnummer, int value) { 
    	try {
    		String query = "UPDATE `persoonlijkeinfo` SET saldo = (saldo - " + value + ") WHERE  klantnummer = '" + klantnummer;
    		stmt.executeUpdate(query + "'");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void addFout(String klantnummer) {
    	try {
    		if(Integer.parseInt(getValue(klantnummer, "fouten")) >= 3) {
    			setBlocked(klantnummer, "1");
    		} 
    		else {
    			String query = "UPDATE `persoonlijkeinfo` SET fouten = (fouten + 1) WHERE  klantnummer = '" + klantnummer;
    			stmt.executeUpdate(query + "'");
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }	
}
