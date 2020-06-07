import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.SwingUtilities;

public class Bank {

	public static void main(String[] args) throws URISyntaxException{
		SwingUtilities.invokeLater(new Runnable(){
			SQLCon sql = new SQLCon();
			
            public void run() {
            	Test myATM = new Test(sql);
            	myATM.setVisible(true);
            }
		});
	}

}
