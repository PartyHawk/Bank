package versie2;
import java.sql.*;

public class SQLCon{

    public void test(){
        try{

            // Class.forName("com.mysql.cj.jdbc.Driver");
    
            Connection con = DriverManager.getConnection("jdbc:mysql://145.24.222.26/test?user=ubuntu-0984053&password=T49z56");
            //("jdbc:mysql://145.24.222.152:22/root//debank", "ubuntu-0984053", "T49z56");

            Statement stmt = con.createStatement();

            ResultSet rSet = stmt.executeQuery("Select Voornaam, Achternaam, klantnummer from persoonlijkeinfo");

            while (rSet.next()){
                System.out.println(rSet.getString("Voornaam") + " " + rSet.getString("Achternaam") + "\t" + rSet.getString("klantnummer"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}