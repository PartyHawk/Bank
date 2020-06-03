package versie2;

import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.SwingUtilities;

class Guio{  
    //Main program
    public static void main(String[] args) throws URISyntaxException {   
        //Create a Bank and an ATM
    	SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
            	Test myATM = new Test();
            	myATM.setVisible(true);
            }
        });

	
    }
}