/*package versie2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

class Test2 extends Test{

    //Create global variables
	private Test as;
//	private ReceiptPrinter printer;
   
    private String clientCard = null;
    private Boolean login = false;
    private String enteredPin = "";
    private String choice;
    private String buttonValue;
    private String changeLanguage;
    private int pinLength = 0;
    private String amount = "";
    
    //Connection database = new Connection();
    

    //Constructor
    //Create all parts used in the bank, and set bounds of the window then do transaction
    public Test2(){ 
    	
        as = new Test();                                                   
                         
    }
    
    public void run() {
    	
}//
    
    
    
    //Method to display the Welcome screen and get input from the card reader and keypad.
    private void Welcome() {
    	as.displayPanel("Welcome");
        
    	
    }
    
    //Method to get the pincode and give it to the server which will check if the correct information is given
    private void PinCode() {
    	as.displayPanel("PinCode");
        		
        	}
    //Method to show the Home screen
    private void Home() {
    	
    	as.displayPanel("Home");
    	
    }
    //Method to show the Balance screen of the GUI
    private void Balance() {
    	//Get the balance from the server
    	as.displayPanel("Balance");
    }
   	//Function to show the withdraw Screen
   	private void Withdraw() {
	as.displayPanel("Withdrawal");
    
   	}

   	//Function to show the Custom Amount screen
    private void CustAmount() {
    //Reset amount and then display it
    as.customAmount(amount);
    as.displayPanel("CustAmount");	
    
    }
    //Method to show the different billchoices
    private void Billchoices() {
    	as.displayPanel("Bills");
    }
    
    //Method to show Receipt screen   		String withdrawAmount, String billChoice, Boolean fast
    private void Receipt() {
    	//Set up the variables and get the transactionID from the database
    	as.displayPanel("Receipt");
    	
    	
		}
    //Method to show a error message screen and then go on to the end screen
    private void WaitingScreen(String errorMessage) {
    	as.errorMessage(errorMessage);
    	as.displayPanel("WaitingScreen");
    	//try{
        //    Thread.sleep(3000);
        //}
        //catch(InterruptedException e){
        //    e.printStackTrace();
        //}
    	//Thanks();
    }
    //Method to show the end screen and reset all the variables used frequently
    private void Thanks() {
    	as.displayPanel("Thanks");
    	
    	try{
            Thread.sleep(1500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    	as.resetPin();
    	clientCard = null;
    	login = false;
    	enteredPin = "";    
    	pinLength = 0;
    	amount = "";
    	
        Welcome(); 
    }
    
}
*/