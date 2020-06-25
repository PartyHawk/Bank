import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
//
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame{
	
	private Noob noob = new Noob();
	
	private Mailer mail = new Mailer();
	private final String bankMail = "debank.bon@gmail.com";
	private final String bankMailPass = "debank123";
	
	private SQLCon sql;
	private String user;
	private String userName;
	private String savings;
	private int attempts;
	private int withdrawn;
	
	private biljetOpties options = new biljetOpties(10, 10, 10);
	private int[][] bills = new int[3][10]; 
	
	
	private JPanel screenPanel = new JPanel();
	private JLayeredPane layeredPane = new JLayeredPane();
	private JLabel timeLabel = new JLabel("00:00:00");
    private JLabel dateLabel = new JLabel("Sun, 22 Oct");
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");  
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Timer timer = new Timer("Timer");	

    private JLabel Attempt = new JLabel("");

    private int clientBalance;
    private JLabel balance = new JLabel("\u20AC " + clientBalance);
    private String account;
    private JLabel lblAccount_1 = new JLabel(account);
    private JLabel label_15 = new JLabel("\u20AC ");
    private JLabel error = new JLabel("Please contact your bank", SwingConstants.CENTER);
    private Boolean Language = true;
    private String amount = "";
   
    
    
    //welcome scherm
    JButton next = new JButton("Next Screen");

    private JLabel lblInsertCard = new JLabel("Welcome by de bank", SwingConstants.CENTER);

    //inlog scherm
    private JButton btnContinue_1 = new JButton("Continue");
    private JTextField userText = new JTextField(6);
    private JPasswordField passwordText = new JPasswordField(6);
    private JButton btnClear_1 = new JButton("Clear");
    private JButton btnAbort = new JButton("Abort");
    private JButton btnTaal = new JButton("Change Language");
    private JLabel lblInsertPin = new JLabel("Please login", SwingConstants.CENTER);

    //Home Screen
    private JLabel option = new JLabel("Please select an option", SwingConstants.CENTER);
    private JButton btnBalance = new JButton("Balance");
    private JButton btnWithdrawal = new JButton("Withdraw");
    private JButton btnFast = new JButton("Fast \u20AC 70");
    private JButton btnStop = new JButton("Abort");
  //Balance Screen
    private JButton btnHome2 = new JButton("Home");
    private JButton btnWithdrawal2 = new JButton("Withdraw");
    private JButton btnFast2 = new JButton("Fast \u20AC 70");
    private JButton btnAbort3 = new JButton("Abort");
    private JLabel lblBalance = new JLabel("Balance:");
    private JLabel lblAccount = new JLabel("Account:");
  //Withdrawal Screen
    private JButton btnHome3 = new JButton("Home");
    private JLabel lblPleaseSelectAn = new JLabel("Please select an amount", SwingConstants.CENTER);
    private JLabel lblPressDTo = new JLabel("Press D to enter a custom amount");
    private JButton btnOther = new JButton("Other");
    private JButton btnAbort4 = new JButton("Abort");
    private JButton button = new JButton("\u20AC 20");
    private JButton button_3 = new JButton("\u20AC 50");
    private JButton button_4 = new JButton("\u20AC 10");
  //Custom Amount Screen
    private JButton btnHome4 = new JButton("Home");
    private JTextField custom = new JTextField(100000);
    private JLabel PEA = new JLabel("Please enter an amount", SwingConstants.CENTER);
    private JButton btnContinue = new JButton("Continue");
    private JButton btnClear = new JButton("Clear");
    private JButton btnAbort5 = new JButton("Abort");
    private JLabel lblAmount = new JLabel("Amount:");
    private JLabel lblNoteThisAtm = new JLabel("NOTE: This ATM only returns 10, 20 and 50 euro bills.");
  //Thanks Screen
    private JLabel ThanksFor = new JLabel("Thank you for choosing De Bank!");
    private JLabel lblNiceday = new JLabel("Have a nice day!");
    private JButton billChoice1 = new JButton("10€");
    private JButton billChoice2 = new JButton("20€");
    private JButton billChoice3 = new JButton("50€");
  //Biljetten
    private JLabel lblkeuze = new JLabel("choose what kind of bills you want");
    private JButton keuze1 = new JButton();
    private JButton keuze2 = new JButton();
    private JButton keuze3 = new JButton();
    private JButton keuze4 = new JButton();
    private JButton keuze5 = new JButton();
    private JButton keuze6 = new JButton();
    JPanel Welcome = new JPanel();
    JPanel PinCode = new JPanel();
    JPanel Home = new JPanel();
    JPanel Bills = new JPanel();
    JPanel Balance = new JPanel();
    JPanel Withdrawal = new JPanel();
    JPanel CustAmount = new JPanel();
    JPanel AmountPanel = new JPanel();
    JPanel WaitingScreen = new JPanel();
    JPanel Receipt = new JPanel();
    JPanel Thanks = new JPanel();
    JPanel BiljetOpties = new JPanel();
    
    
    
	public Test(SQLCon sql) {
		
		super("De Bank");
		
		this.sql = sql;
		
		setContentPane(screenPanel);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1450, 800);
		setUndecorated(true);;
		getContentPane().setLayout(null);


		dateLabel.setForeground(Color.ORANGE);
		dateLabel.setFont(new Font("Arial", Font.BOLD, 36));
		dateLabel.setBounds(1100, 70, 280, 70);
		getContentPane().add(dateLabel);

		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	        	LocalDateTime localDateTime = LocalDateTime.now();  
	            
	            timeLabel.setText(localDateTime.format(timeFormat));
	            dateLabel.setText(localDateTime.format(dateFormat));
	        }
	    };
    
	    timer.scheduleAtFixedRate(repeatedTask, 0L, 1000L);
	    timeLabel.setBounds(1200, 5, 163, 109);
	    screenPanel.add(timeLabel);
	    

	    timeLabel.setForeground(Color.ORANGE);
	    timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
	    
	    
	    layeredPane.setBounds(0, 0, 1450, 800);
	    screenPanel.add(layeredPane);
	    layeredPane.setLayout(new CardLayout(0, 0));
	    
	

	//Welcome screen
	Welcome.setBounds(0, 0, 1450, 800);
	layeredPane.add(Welcome, "name_283576622166910");
	Welcome.setLayout(null);

	JLabel label_D = new JLabel("D", SwingConstants.CENTER);
	label_D.setOpaque(true);
	label_D.setForeground(Color.WHITE);
	label_D.setFont(new Font("Arial", Font.PLAIN, 50));
	label_D.setBackground(Color.LIGHT_GRAY);
	label_D.setBounds(1300, 700, 75, 75);
	Welcome.add(label_D);
	
	
	next.setFont(new Font("Arial", Font.PLAIN, 24));
	next.setFocusPainted(false);
	next.setBounds(1050, 700, 230, 80);
	Welcome.add(next);
	next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(PinCode);
				}
			});
	
	lblInsertCard.setBounds(450, 170, 600, 200);
	Welcome.add(lblInsertCard);
	lblInsertCard.setFont(new Font("Arial", Font.PLAIN, 50));
	lblInsertCard.setForeground(Color.RED);
	
	//PinCode
	PinCode.setBounds(0, 0, 1450, 800);
	layeredPane.add(PinCode, "name_283576638687168");
	PinCode.setLayout(null);
	
	btnContinue_1.setForeground(Color.BLACK);
//	btnContinue_1.setBackground(Color.BLACK);
	btnContinue_1.setFont(new Font("Arial", Font.PLAIN, 25));
	btnContinue_1.setFocusPainted(false);
	btnContinue_1.setBounds(1050, 400, 230, 80);
	PinCode.add(btnContinue_1);
	btnContinue_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			user = userText.getText();
			String passwd = sql.getValue(user, "pincode");
			
//			try {
//				String x = noob.phpverbinding("info|" + user + "|" + passwordText.getText(), "inloggen.php");
//			}
//			catch(Exception ec) {
//				ec.printStackTrace();
//			}
//			
			if(passwordText.getText().equals(passwd) && sql.getValue(user, "blocked").equals("0")) {
				sql.setValue(user, "fouten", "0");
				PinCode.remove(Attempt);
				savings = sql.getValue(user, "saldo");
				balance.setText("\u20AC" + savings);
				userName = sql.getValue(user, "Voornaam");
				lblAccount_1.setText(userName);
				SwitchPanels(Home);
				userText.setText("");
				passwordText.setText("");
			}
			else {
				sql.addFout(userText.getText());
				attempts = 3 - Integer.parseInt(sql.getValue(user, "fouten"));
				SwitchPanels(WaitingScreen);
//				userText.setText("");
				passwordText.setText("");
				
				Attempt.setForeground(Color.RED);
				System.out.println(attempts);
				Attempt.setText("Attempts left: " + attempts);
				Attempt.setFont(new Font("Arial", Font.PLAIN, 50));
				Attempt.setBounds(500, 550, 400, 100);
				PinCode.add(Attempt);
				
			}
			
		}
		});	

	btnAbort.setForeground(Color.BLACK);
	btnAbort.setFont(new Font("Arial", Font.PLAIN, 25));
//	btnAbort.setBackground(Color.BLACK);
	btnAbort.setBounds(130, 500, 230, 80);
	PinCode.add(btnAbort);
	btnAbort.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Welcome);
			userText.setText("");
			passwordText.setText("");
			}	
		});
	
	btnTaal.setFont(new Font("Arial", Font.PLAIN, 25));
	btnTaal.setFocusPainted(false);
	btnTaal.setBounds(1050, 700, 230, 80);
	PinCode.add(btnTaal);
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	JLabel label_A = new JLabel("A", SwingConstants.CENTER);
	label_A.setOpaque(true);
	label_A.setForeground(Color.WHITE);
	label_A.setFont(new Font("Arial", Font.PLAIN, 40));
	label_A.setBackground(Color.LIGHT_GRAY);
	label_A.setBounds(1300, 400, 75, 75);
	PinCode.add(label_A);

	JLabel label_30 = new JLabel("D", SwingConstants.CENTER);
	label_30.setOpaque(true);
	label_30.setForeground(Color.WHITE);
	label_30.setFont(new Font("Arial", Font.PLAIN, 40));
	label_30.setBackground(Color.LIGHT_GRAY);
	label_30.setBounds(1300, 700, 75, 75);
	PinCode.add(label_30);	
	
	JLabel label_31 = new JLabel("#", SwingConstants.CENTER);
	label_31.setVerticalAlignment(SwingConstants.BOTTOM);
	label_31.setOpaque(true);
	label_31.setForeground(Color.WHITE);
	label_31.setFont(new Font("Arial", Font.PLAIN, 50));
	label_31.setBackground(Color.LIGHT_GRAY);
	label_31.setBounds(30, 500, 75, 75);
	PinCode.add(label_31);
	
	lblInsertPin.setFont(new Font("Arial", Font.PLAIN, 70));
	lblInsertPin.setBounds(0, 100, 1450, 194);
	lblInsertPin.setForeground(Color.RED);
	PinCode.add(lblInsertPin);
	
	JLabel namelabel = new JLabel("User ID: ");
	namelabel.setForeground(Color.BLACK);
	namelabel.setFont(new Font("Arial", Font.PLAIN, 30));
	namelabel.setBounds(350, 300, 150, 50);
	PinCode.add(namelabel);
	
	JLabel passwordLabel = new JLabel("Password: ");
	passwordLabel.setForeground(Color.BLACK);
	passwordLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	passwordLabel.setBounds(350, 400, 150, 50);
	PinCode.add(passwordLabel);
	
	passwordText.setFont(new Font("Lucida Grande", Font.BOLD, 30));
	passwordText.setBounds(600,400,200,50);
	PinCode.add(passwordText);
	
	userText.setFont(new Font("Lucida Grande", Font.BOLD, 30));
	userText.setBounds(600, 300, 200, 50);
	PinCode.add(userText);
	
//	Attempt.setForeground(Color.RED);
//	System.out.println(attempts);
//	Attempt.setText("Attempts left: " + attempts);
//	Attempt.setFont(new Font("Arial", Font.PLAIN, 50));
//	Attempt.setBounds(500, 550, 400, 100);
//	PinCode.add(Attempt);
	   
	
	//Bill choice
	Bills.setBounds(0, 0, 1450, 800);
	layeredPane.add(Bills, "name_283576656510015");
	Bills.setLayout(null);
	
	billChoice1.setForeground(Color.BLACK);
	billChoice1.setFocusPainted(false);
	billChoice1.setFont(new Font("Arial", Font.PLAIN, 25));
	billChoice1.setBounds(1050, 400, 230, 75);
	Bills.add(billChoice1);
	billChoice1.setOpaque(true);
	
	billChoice2.setForeground(Color.BLACK);
	billChoice2.setFocusPainted(false);
	billChoice2.setFont(new Font("Arial", Font.PLAIN, 25));
	billChoice2.setBounds(1050, 500, 230, 75);
	Bills.add(billChoice2);
	billChoice2.setOpaque(true);
	
	billChoice3.setForeground(Color.BLACK);
	billChoice3.setFocusPainted(false);
	billChoice3.setFont(new Font("Arial", Font.PLAIN, 25));
	billChoice3.setBounds(1050, 600, 230, 75);
	Bills.add(billChoice3);
	billChoice3.setOpaque(true);
	
	JLabel bA = new JLabel("A", SwingConstants.CENTER);
	bA.setForeground(Color.BLACK);
	bA.setBackground(Color.LIGHT_GRAY);
	bA.setFont(new Font("Arial", Font.PLAIN, 40));
	bA.setBounds(1300, 400, 75, 75);
	Bills.add(bA);
	bA.setOpaque(true);
	
	JLabel bB = new JLabel("B", SwingConstants.CENTER);
	bB.setForeground(Color.BLACK);
	bB.setBackground(Color.LIGHT_GRAY);
	bB.setFont(new Font("Arial", Font.PLAIN, 40));
	bB.setBounds(1300, 500, 75, 75);
	Bills.add(bB);
	bB.setOpaque(true);
	
	JLabel bC = new JLabel("C", SwingConstants.CENTER);
	bC.setForeground(Color.BLACK);
	bC.setBackground(Color.LIGHT_GRAY);
	bC.setFont(new Font("Arial", Font.PLAIN, 40));
	bC.setBounds(1300, 600, 75, 75);
	Bills.add(bC);
	bC.setOpaque(true);
	
	JLabel bAst = new JLabel("#", SwingConstants.CENTER);
	bAst.setForeground(Color.BLACK);
	bAst.setBackground(Color.LIGHT_GRAY);
	bAst.setFont(new Font("Arial", Font.PLAIN, 40));
	bAst.setBounds(30, 500, 75, 75);
	Bills.add(bAst);
	bAst.setOpaque(true);
	
	JLabel Hash5 = new JLabel("*", SwingConstants.CENTER);
	Hash5.setVerticalAlignment(SwingConstants.BOTTOM);
	Hash5.setOpaque(true);
	Hash5.setForeground(Color.BLACK);
	Hash5.setFont(new Font("Arial", Font.PLAIN, 50));
	Hash5.setBackground(Color.LIGHT_GRAY);
	Hash5.setBounds(30, 600, 75, 75);
	Bills.add(Hash5);
	
	JLabel naam = new JLabel("De Bank", SwingConstants.CENTER);
	naam.setForeground(new Color(100, 149, 237));
	naam.setFont(new Font("Arial", Font.PLAIN, 99));
	naam.setBounds(0, 50, 1450, 150);
	Bills.add(naam);
	
	JButton btnAbort2 = new JButton("Abort");
	btnAbort2.setForeground(Color.BLACK);
	btnAbort2.setBackground(new Color(0,0,0));
	btnAbort2.setFont(new Font("Arial", Font.PLAIN, 25));
	btnAbort2.setBounds(130, 500, 150, 75);
	Bills.add(btnAbort2);
	btnAbort2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Welcome);
			userText.setText("");
			}	
		});
	
	JButton btnHome = new JButton("Home");
	btnHome.setForeground(Color.BLACK);
	btnHome.setBackground(new Color(255, 51, 51));
	btnHome.setFont(new Font("Arial", Font.PLAIN, 25));
	btnHome.setBounds(130, 600, 150, 75);
	Bills.add(btnHome);
	btnHome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Home);
			}	
		});
	
	JLabel choice = new JLabel("Please select a choice of bills", SwingConstants.CENTER);
	choice.setForeground(Color.BLACK);
	choice.setFont(new Font("Arial", Font.PLAIN, 70));
	choice.setBounds(0, 250, 1450, 113);
	Bills.add(choice);
	   
	
	//Home Screen
	Home.setBounds(0, 0, 1450, 800);
	layeredPane.add(Home, "name_283576674161350");
	Home.setLayout(null);
	
	JLabel A = new JLabel("A", SwingConstants.CENTER);
	A.setOpaque(true);
	A.setForeground(Color.WHITE);
	A.setBackground(Color.LIGHT_GRAY);
	A.setFont(new Font("Arial", Font.PLAIN, 40));
	A.setBounds(1300, 400, 75, 75);
	Home.add(A);
	
	JLabel B = new JLabel("B", SwingConstants.CENTER);
	B.setOpaque(true);
	B.setForeground(Color.WHITE);
	B.setFont(new Font("Arial", Font.PLAIN, 40));
	B.setBackground(Color.LIGHT_GRAY);
	B.setBounds(1300, 500, 75, 75);
	Home.add(B);
	
	JLabel C = new JLabel("C", SwingConstants.CENTER);
	C.setOpaque(true);
	C.setForeground(Color.WHITE);
	C.setFont(new Font("Arial", Font.PLAIN, 40));
	C.setBackground(Color.LIGHT_GRAY);
	C.setBounds(1300, 600, 75, 75);
	Home.add(C);
	//Home.add(D);
	
	JLabel Asterisk = new JLabel("#", SwingConstants.CENTER);
	Asterisk.setVerticalAlignment(SwingConstants.BOTTOM);
	Asterisk.setOpaque(true);
	Asterisk.setForeground(Color.WHITE);
	Asterisk.setFont(new Font("Arial", Font.PLAIN, 50));
	Asterisk.setBackground(Color.LIGHT_GRAY);
	Asterisk.setBounds(30, 500, 75, 75);
	Home.add(Asterisk);
	
	JLabel name = new JLabel("De Bank", SwingConstants.CENTER);
	name.setForeground(new Color(100, 149, 237));
	name.setFont(new Font("Arial", Font.PLAIN, 99));
	name.setBounds(0, 50, 1450, 150);
	Home.add(name);
	
	option.setForeground(Color.BLACK);
	option.setFont(new Font("Arial", Font.PLAIN, 70));
	option.setBounds(0, 300, 1450, 113);
	Home.add(option);
	
	btnBalance.setForeground(Color.BLACK);
	btnBalance.setFocusPainted(false);
//	btnBalance.setBackground(Color.BLACK);
	btnBalance.setFont(new Font("Arial", Font.PLAIN, 25));
	btnBalance.setBounds(1050, 400, 230, 80);
	Home.add(btnBalance);
	btnBalance.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Balance);
			}	
		});
	
	btnWithdrawal.setForeground(Color.BLACK);
	btnWithdrawal.setFocusPainted(false);
//	btnWithdrawal.setBackground(Color.BLACK);
	btnWithdrawal.setFont(new Font("Arial", Font.PLAIN, 25));
	btnWithdrawal.setBounds(1050, 500, 230, 80);
	Home.add(btnWithdrawal);
	btnWithdrawal.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Withdrawal);
			}	
		});
	
	btnFast.setForeground(Color.BLACK);
	btnFast.setFocusPainted(false);
//	btnFast.setBackground(Color.BLACK);
	btnFast.setFont(new Font("Arial", Font.PLAIN, 25));
	btnFast.setBounds(1050, 600, 230, 80);
	Home.add(btnFast);
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	btnStop.setForeground(Color.BLACK);
//	btnStop.setBackground(Color.BLACK);
	btnStop.setFont(new Font("Arial", Font.PLAIN, 25));
	btnStop.setBounds(130, 500, 230, 80);
	Home.add(btnStop);
	btnStop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Welcome);
			}	
		});
	
	//Balance
	Balance.setBounds(0, 0, 1450, 800);
	layeredPane.add(Balance, "name_283576692845461");
	Balance.setLayout(null);
	
	JLabel label = new JLabel("A", SwingConstants.CENTER);
	label.setOpaque(true);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Arial", Font.PLAIN, 40));
	label.setBackground(Color.LIGHT_GRAY);
	label.setBounds(1300, 400, 75, 75);
	Balance.add(label);
	
	JLabel label_1 = new JLabel("B", SwingConstants.CENTER);
	label_1.setOpaque(true);
	label_1.setForeground(Color.WHITE);
	label_1.setFont(new Font("Arial", Font.PLAIN, 40));
	label_1.setBackground(Color.LIGHT_GRAY);
	label_1.setBounds(1300, 500, 75, 75);
	Balance.add(label_1);
	
	JLabel label_2 = new JLabel("C", SwingConstants.CENTER);
	label_2.setOpaque(true);
	label_2.setForeground(Color.WHITE);
	label_2.setFont(new Font("Arial", Font.PLAIN, 40));
	label_2.setBackground(Color.LIGHT_GRAY);
	label_2.setBounds(1300, 600, 75, 75);
	Balance.add(label_2);
	
	JLabel label_3 = new JLabel("D", SwingConstants.CENTER);
	label_3.setOpaque(true);
	label_3.setForeground(Color.WHITE);
	label_3.setFont(new Font("Arial", Font.PLAIN, 40));
	label_3.setBackground(Color.LIGHT_GRAY);
	label_3.setBounds(1300, 700, 75, 75);
	Balance.add(label_3);
	
	JLabel label_4 = new JLabel("#", SwingConstants.CENTER);
	label_4.setVerticalAlignment(SwingConstants.BOTTOM);
	label_4.setOpaque(true);
	label_4.setForeground(Color.WHITE);
	label_4.setFont(new Font("Arial", Font.PLAIN, 50));
	label_4.setBackground(Color.LIGHT_GRAY);
	label_4.setBounds(30, 500, 75, 75);
	Balance.add(label_4);
	
	JLabel Hash2 = new JLabel("*", SwingConstants.CENTER);
	Hash2.setVerticalAlignment(SwingConstants.BOTTOM);
	Hash2.setOpaque(true);
	Hash2.setForeground(Color.WHITE);
	Hash2.setFont(new Font("Arial", Font.PLAIN, 50));
	Hash2.setBackground(Color.LIGHT_GRAY);
	Hash2.setBounds(30, 600, 75, 75);
	Balance.add(Hash2);
	
	JLabel name2 = new JLabel("De Bank ", SwingConstants.CENTER);
	name2.setForeground(new Color(100, 149, 237));
	name2.setFont(new Font("Arial", Font.PLAIN, 99));
	name2.setBounds(0, 50, 1450, 150);
	Balance.add(name2);
	
	btnHome2.setForeground(Color.BLACK);
	btnHome2.setBackground(new Color(255, 51, 51));
	btnHome2.setFont(new Font("Arial", Font.PLAIN, 25));
	btnHome2.setBounds(130, 600, 230, 75);
	Balance.add(btnHome2);
	btnHome2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Home);
			}	
		});
	
	btnWithdrawal2.setFocusPainted(false);
	btnWithdrawal2.setForeground(Color.BLACK);
	btnWithdrawal2.setFont(new Font("Arial", Font.PLAIN, 25));
	btnWithdrawal2.setBackground(new Color(255, 204, 51));
	btnWithdrawal2.setBounds(1050, 500, 230, 75);
	Balance.add(btnWithdrawal2);
	btnWithdrawal2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Withdrawal);
			}	
		});
	
	btnFast2.setFocusPainted(false);
	btnFast2.setForeground(Color.BLACK);
	btnFast2.setFont(new Font("Arial", Font.PLAIN, 25));
	btnFast2.setBackground(new Color(153, 0, 204));
	btnFast2.setBounds(1050, 600, 230, 75);
	Balance.add(btnFast2);
	//////////////////////////////////////////////////////////////////////////////////////////
	
	btnAbort3.setFocusPainted(false);
	btnAbort3.setForeground(Color.BLACK);
	btnAbort3.setFont(new Font("Arial", Font.PLAIN, 25));
//	btnAbort3.setBackground(new Color(0,0,0));
	btnAbort3.setBounds(130, 500, 230, 75);
	Balance.add(btnAbort3);
	btnAbort3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Welcome);
			userText.setText("");
			}	
		});
	
	balance.setForeground(Color.BLACK);
//	balance.setText("\u20AC" );
	balance.setHorizontalAlignment(SwingConstants.RIGHT);
	balance.setFont(new Font("Arial", Font.PLAIN, 50));
	balance.setBounds(650, 250, 300, 55);
	Balance.add(balance);
	
	lblAccount_1.setForeground(Color.BLACK);
	lblAccount_1.setHorizontalAlignment(SwingConstants.RIGHT);
	lblAccount_1.setFont(new Font("Arial", Font.PLAIN, 50));
	lblAccount_1.setBounds(650, 300, 300, 55);
	Balance.add(lblAccount_1);
	
	lblBalance.setForeground(Color.BLACK);
	lblBalance.setFont(new Font("Arial", Font.PLAIN, 50));
	lblBalance.setBounds(450, 250, 300, 55);
	Balance.add(lblBalance);
	
	lblAccount.setForeground(Color.BLACK);
	lblAccount.setFont(new Font("Arial", Font.PLAIN, 50));
	lblAccount.setBounds(450, 300, 300, 47);
	Balance.add(lblAccount);
	
	
	//Withdrawal
	Withdrawal.setBounds(0, 0, 1450, 800);
	layeredPane.add(Withdrawal, "name_283576710870671");
	Withdrawal.setLayout(null);
	
	JLabel label_5 = new JLabel("De Bank", SwingConstants.CENTER);
	label_5.setForeground(new Color(100, 149, 237));
	label_5.setFont(new Font("Arial", Font.PLAIN, 99));
	label_5.setBounds(0, 50, 1450, 150);
	Withdrawal.add(label_5);
	
	JLabel label_6 = new JLabel("A", SwingConstants.CENTER);
	label_6.setOpaque(true);
	label_6.setForeground(Color.WHITE);
	label_6.setFont(new Font("Arial", Font.PLAIN, 40));
	label_6.setBackground(Color.LIGHT_GRAY);
	label_6.setBounds(1300, 400, 75, 75);
	Withdrawal.add(label_6);
	
	JLabel label_7 = new JLabel("B", SwingConstants.CENTER);
	label_7.setOpaque(true);
	label_7.setForeground(Color.WHITE);
	label_7.setFont(new Font("Arial", Font.PLAIN, 40));
	label_7.setBackground(Color.LIGHT_GRAY);
	label_7.setBounds(1300, 500, 75, 75);
	Withdrawal.add(label_7);
	
	JLabel label_8 = new JLabel("C", SwingConstants.CENTER);
	label_8.setOpaque(true);
	label_8.setForeground(Color.WHITE);
	label_8.setFont(new Font("Arial", Font.PLAIN, 40));
	label_8.setBackground(Color.LIGHT_GRAY);
	label_8.setBounds(1300, 600, 75, 75);
	Withdrawal.add(label_8);
	
	JLabel label_9 = new JLabel("D", SwingConstants.CENTER);
	label_9.setOpaque(true);
	label_9.setForeground(Color.WHITE);
	label_9.setFont(new Font("Arial", Font.PLAIN, 40));
	label_9.setBackground(Color.LIGHT_GRAY);
	label_9.setBounds(1300, 700, 75, 75);
	Withdrawal.add(label_9);
	
	JLabel label_10 = new JLabel("#", SwingConstants.CENTER);
	label_10.setVerticalAlignment(SwingConstants.BOTTOM);
	label_10.setOpaque(true);
	label_10.setForeground(Color.WHITE);
	label_10.setFont(new Font("Arial", Font.PLAIN, 50));
	label_10.setBackground(Color.LIGHT_GRAY);
	label_10.setBounds(30, 500, 75, 75);
	Withdrawal.add(label_10);
	
	JLabel Hash3 = new JLabel("*", SwingConstants.CENTER);
	Hash3.setVerticalAlignment(SwingConstants.BOTTOM);
	Hash3.setOpaque(true);
	Hash3.setForeground(Color.WHITE);
	Hash3.setFont(new Font("Arial", Font.PLAIN, 50));
	Hash3.setBackground(Color.LIGHT_GRAY);
	Hash3.setBounds(30, 600, 75, 75);
	Withdrawal.add(Hash3);
	
	btnHome3.setForeground(Color.BLACK);
//	btnHome3.setBackground(Color.BLACK);
	btnHome3.setFont(new Font("Arial", Font.PLAIN, 25));
	btnHome3.setBounds(130, 600, 230, 75);
	Withdrawal.add(btnHome3);
	btnHome3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Home);
			}	
		});
	
	lblPleaseSelectAn.setForeground(Color.BLACK);
	lblPleaseSelectAn.setFont(new Font("Arial", Font.PLAIN, 70));
	lblPleaseSelectAn.setBounds(0, 200, 1450, 113);
	Withdrawal.add(lblPleaseSelectAn);
	
	lblPressDTo.setForeground(Color.BLACK);
	lblPressDTo.setHorizontalAlignment(SwingConstants.CENTER);
	lblPressDTo.setFont(new Font("Arial", Font.ITALIC, 40));
	lblPressDTo.setBounds(0, 300, 1450, 131);
	Withdrawal.add(lblPressDTo);
	
	button.setForeground(Color.BLACK);
	button.setFont(new Font("Arial", Font.PLAIN, 25));
	button.setFocusPainted(false);
	button.setBackground(new Color(0, 153, 51));
	button.setBounds(1050, 500, 230, 75);
	Withdrawal.add(button);
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	button_3.setForeground(Color.BLACK);
	button_3.setFont(new Font("Arial", Font.PLAIN, 25));
	button_3.setFocusPainted(false);
	button_3.setBackground(new Color(0, 153, 51));
	button_3.setBounds(1050, 600, 230, 75);
	Withdrawal.add(button_3);
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	btnOther.setForeground(Color.BLACK);
//	btnOther.setBackground(Color.BLACK);
	btnOther.setFont(new Font("Arial", Font.PLAIN, 25));
	btnOther.setFocusPainted(false);
	btnOther.setBounds(1050, 700, 230, 75);
	Withdrawal.add(btnOther);
	btnOther.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(CustAmount);
			}	
		});
	
	button_4.setForeground(Color.BLACK);
	button_4.setFont(new Font("Arial", Font.PLAIN, 25));
	button_4.setFocusPainted(false);
	button_4.setBackground(new Color(0, 153, 51));
	button_4.setBounds(1050, 400, 230, 75);
	Withdrawal.add(button_4);
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	btnAbort4.setForeground(Color.BLACK);
	btnAbort4.setFont(new Font("Arial", Font.PLAIN, 25));
	btnAbort4.setFocusPainted(false);
//	btnAbort4.setBackground(Color.BLACK);
	btnAbort4.setBounds(130, 500, 230, 75);
	Withdrawal.add(btnAbort4);
	btnAbort4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Welcome);
			userText.setText("");
			}	
		});

	//Input custom amount screen
    CustAmount.setBounds(0, 0, 1450, 800);
    layeredPane.add(CustAmount, "name_283576729940309");
    CustAmount.setLayout(null);
    
    custom.setFont(new Font("Lucida Grande", Font.BOLD, 30));
	custom.setBounds(650,400,200,50);
	CustAmount.add(custom);
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    btnHome4.setForeground(Color.BLACK);
    btnHome4.setBackground(new Color(255, 51, 51));
    btnHome4.setFont(new Font("Arial", Font.PLAIN, 25));
    btnHome4.setBounds(130, 600, 230, 75);
    CustAmount.add(btnHome4);
    btnHome4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwitchPanels(Home);
			}	
		});
    
   
    JLabel name4 = new JLabel("De Bank", SwingConstants.CENTER);
    name4.setForeground(new Color(100, 149, 237));
    name4.setFont(new Font("Arial", Font.PLAIN, 99));
    name4.setBounds(0, 50, 1450, 150);
    CustAmount.add(name4);
    
    JLabel OptC = new JLabel("C", SwingConstants.CENTER);
    OptC.setOpaque(true);
    OptC.setForeground(Color.BLACK);
    OptC.setFont(new Font("Arial", Font.PLAIN, 40));
    OptC.setBackground(Color.LIGHT_GRAY);
    OptC.setBounds(1300, 600, 75, 75);
    CustAmount.add(OptC);

    JLabel OptAst = new JLabel("#", SwingConstants.CENTER);
    OptAst.setVerticalAlignment(SwingConstants.BOTTOM);
    OptAst.setOpaque(true);
    OptAst.setForeground(Color.BLACK);
    OptAst.setFont(new Font("Arial", Font.PLAIN, 50));
    OptAst.setBackground(Color.LIGHT_GRAY);
    OptAst.setBounds(30, 500, 75, 75);
    CustAmount.add(OptAst);
    
    JLabel Hash4 = new JLabel("*", SwingConstants.CENTER);
    Hash4.setVerticalAlignment(SwingConstants.BOTTOM);
    Hash4.setOpaque(true);
    Hash4.setForeground(Color.BLACK);
    Hash4.setFont(new Font("Arial", Font.PLAIN, 50));
    Hash4.setBackground(Color.LIGHT_GRAY);
    Hash4.setBounds(30, 600, 75, 75);
    CustAmount.add(Hash4);
    

    PEA.setForeground(Color.BLACK);
    PEA.setFont(new Font("Arial", Font.PLAIN, 70));
    PEA.setBounds(0, 250, 1450, 113);
    CustAmount.add(PEA);
    
    btnContinue.setForeground(Color.BLACK);
    btnContinue.setFont(new Font("Arial", Font.PLAIN, 25));
    btnContinue.setFocusPainted(false);
    btnContinue.setBackground(new Color(0, 153, 51));
    btnContinue.setBounds(1050, 600, 230, 75);
    CustAmount.add(btnContinue);
    
    btnContinue.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int a = Integer.parseInt(savings);
			int b = Integer.parseInt(custom.getText());
			
			if(a >= b && options.getMax() >= b) {
				bills = options.getOpties(b);
				withdrawn = Integer.parseInt(custom.getText());
				custom.setText("");
				SwitchPanels(BiljetOpties);
			}
			else {
				SwitchPanels(WaitingScreen);
			}
		}	
	});
    
    btnAbort5.setForeground(Color.BLACK);
    btnAbort5.setFont(new Font("Arial", Font.PLAIN, 25));
    btnAbort5.setFocusPainted(false);
//    btnAbort5.setBackground(new Color(0,0,0));
    btnAbort5.setBounds(130, 500, 230, 75);
    CustAmount.add(btnAbort5);
    btnAbort5.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		SwitchPanels(Welcome);
    		}	
	    });
    
    lblAmount.setForeground(Color.BLACK);
    lblAmount.setFont(new Font("Arial", Font.PLAIN, 30));
    lblAmount.setBackground(Color.BLACK);
    lblAmount.setBounds(500, 400, 150, 40);
    CustAmount.add(lblAmount);
    
    
    lblNoteThisAtm.setForeground(new Color(255, 255, 255));
    lblNoteThisAtm.setFont(new Font("Arial", Font.PLAIN, 20));
    lblNoteThisAtm.setBounds(500, 500, 600, 25);
	CustAmount.add(lblNoteThisAtm);
	    	
 	//WaitingScreen error
 	WaitingScreen.setBounds(0, 0, 1450, 800);
 	layeredPane.add(WaitingScreen, "name_283576748705653");
 	WaitingScreen.setLayout(null);
 	JButton back = new JButton("Back");

 	back.setForeground(Color.BLACK);

 	back.setFont(new Font("Arial", Font.PLAIN, 25));

 	back.setBounds(1050, 700, 230, 80);

 	 WaitingScreen.add(back);

 	back.addActionListener(new ActionListener() {

 	    public void actionPerformed(ActionEvent e) {

 	    SwitchPanels(PinCode);

 	    }

 	    });
	    	
 	JLabel name5 = new JLabel("De Bank", SwingConstants.CENTER);
 	name5.setForeground(new Color(100, 149, 237));
 	name5.setFont(new Font("Arial", Font.PLAIN, 99));
 	name5.setBounds(0, 50, 1450, 150);
 	WaitingScreen.add(name5);
	    	
 	JLabel Check = new JLabel(" Something went wrong.", SwingConstants.CENTER);
 	Check.setForeground(Color.BLACK);
 	Check.setFont(new Font("Arial", Font.PLAIN, 60));
 	Check.setBounds(0, 300, 1450, 100);
 	WaitingScreen.add(Check);
	    
 	error.setForeground(Color.BLACK);
    error.setFont(new Font("Arial", Font.PLAIN, 50));
    error.setBounds(0, 400, 1450, 100);
    WaitingScreen.add(error);
    
    // Receipt screen
	Receipt.setBounds(0, 0, 1450, 800);
	layeredPane.add(Receipt, "name_283576776422392");
	Receipt.setLayout(null);
	
	JLabel name6 = new JLabel("De Bank", SwingConstants.CENTER); 
	name6.setForeground(new Color(100, 149, 237));
	name6.setFont(new Font("Arial", Font.PLAIN, 99));
	name6.setBounds(0, 50, 1450, 150);
	Receipt.add(name6);
	    	
	JLabel label_11 = new JLabel("D", SwingConstants.CENTER);
	label_11.setOpaque(true);
	label_11.setForeground(Color.WHITE);
	label_11.setFont(new Font("Arial", Font.PLAIN, 40));
	label_11.setBackground(Color.LIGHT_GRAY);
	label_11.setBounds(1300, 600, 75, 75);
	Receipt.add(label_11);
	    	
	JLabel label_12 = new JLabel("*", SwingConstants.CENTER);
	label_12.setVerticalAlignment(SwingConstants.BOTTOM);
	label_12.setOpaque(true);
	label_12.setForeground(Color.WHITE);
	label_12.setFont(new Font("Arial", Font.PLAIN, 50));
	label_12.setBackground(Color.LIGHT_GRAY);
	label_12.setBounds(30, 600, 75, 75);
	Receipt.add(label_12);    
	    
	JButton btnYes = new JButton("Yes");
	btnYes.setForeground(Color.BLACK);
	btnYes.setFont(new Font("Arial", Font.PLAIN, 25));
	btnYes.setFocusPainted(false);
	btnYes.setBackground(new Color(0, 153, 51));
	btnYes.setBounds(130, 600, 230, 75);
	Receipt.add(btnYes);
	btnYes.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.out.println("Withdrawn: " + withdrawn);
    		mail.send(bankMail, bankMailPass, sql.getValue(user, "email"), "De Bank transactiebon", "-----------------------------\nnaam:\t" + userName + "\nklantnummer: " + user + "\nbedrag:\t" + withdrawn + "\nbedankt voor het pinnen bij debank\n-----------------------------");
    		sql.withdraw(user, withdrawn);
    		SwitchPanels(Thanks);
    		}	
	    });
	///////////////////////////////////////////////////////////////////////////////////////    	
	
	JButton btnNo = new JButton("No");
	btnNo.setForeground(Color.BLACK);
	btnNo.setFont(new Font("Arial", Font.PLAIN, 25));
	btnNo.setFocusPainted(false);
	btnNo.setBounds(1050, 600, 230, 75);
	Receipt.add(btnNo);
	btnNo.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.out.println("Withdrawn: " + withdrawn);
    		sql.withdraw(user, withdrawn);
    		SwitchPanels(Thanks);
    		}
	    });
	/////////////////////////////////////////////////////////////////////////////////    
	
	JLabel Receiptyn = new JLabel("Would you like a receipt?");
	Receiptyn.setForeground(Color.BLACK);
	Receiptyn.setHorizontalAlignment(SwingConstants.CENTER);
	Receiptyn.setFont(new Font("Arial", Font.PLAIN, 70));
	Receiptyn.setBounds(0, 300, 1450, 86);
	Receipt.add(Receiptyn);
	
	//End screen	
	Thanks.setBounds(0, 0, 1450, 800);
	layeredPane.add(Thanks, "name_283576795371413");
	Thanks.setLayout(null);    	
	    	
	ThanksFor.setFont(new Font("Arial", Font.PLAIN, 70));
	ThanksFor.setForeground(Color.BLACK);
	ThanksFor.setHorizontalAlignment(SwingConstants.CENTER);
	ThanksFor.setBounds(0, 300, 1450, 111);
	Thanks.add(ThanksFor);
	    
	    
	lblNiceday.setFont(new Font("Arial", Font.PLAIN, 60));
	lblNiceday.setForeground(Color.BLACK);
	lblNiceday.setHorizontalAlignment(SwingConstants.CENTER);
	lblNiceday.setBounds(0, 450, 1450, 81);
	Thanks.add(lblNiceday);
	
	JButton ending = new JButton("Back to welcome screen");
	ending.setForeground(Color.BLACK);
	ending.setFont(new Font("Arial", Font.PLAIN, 25));
	ending.setBounds(1050, 700, 300, 75);
	Thanks.add(ending);
	
	ending.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	SwitchPanels(Welcome);
	    }
	});
	
	BiljetOpties.setBounds(0,0,1450,800);
	layeredPane.add(BiljetOpties);
	BiljetOpties.setLayout(null);

	 
	JLabel name7 = new JLabel("De Bank", SwingConstants.CENTER);

	name7.setForeground(new Color(100, 149, 237));
	name7.setFont(new Font("Arial", Font.PLAIN, 99));
	name7.setBounds(0, 50, 1450, 150);
	BiljetOpties.add(name7);

	    
	lblkeuze.setForeground(Color.BLACK);
	lblkeuze.setFont(new Font("Arial", Font.PLAIN, 30));
	lblkeuze.setBounds(500, 200, 700, 50);
	BiljetOpties.add(lblkeuze);

	    

	keuze1.setForeground(Color.BLACK);
	keuze1.setFont(new Font("Arial", Font.PLAIN, 25));
	keuze1.setBounds(80, 300, 500, 130);
	BiljetOpties.add(keuze1);
	
	keuze1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	if(bills[0][0] > 0 || bills[1][0] > 0 || bills[2][0] > 0) {
	    		SwitchPanels(Receipt);
	    	}
	    }
	});
	 
	keuze2.setForeground(Color.BLACK);
	keuze2.setFont(new Font("Arial", Font.PLAIN, 25));
	keuze2.setBounds(80, 450, 500, 130);
	BiljetOpties.add(keuze2);
	
	keuze2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	if(bills[0][1] > 0 || bills[1][1] > 0 || bills[2][1] > 0) {
	    		SwitchPanels(Receipt);
	    	}
	    }
	});

	keuze3.setForeground(Color.BLACK);
	keuze3.setFont(new Font("Arial", Font.PLAIN, 25));
	keuze3.setBounds(80, 600, 500, 130);
	BiljetOpties.add(keuze3);
	keuze3.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
	    	if(bills[0][2] > 0 || bills[1][2] > 0 || bills[2][2] > 0) {
	    		SwitchPanels(Receipt);
	    	}
	    }
	});

	keuze4.setForeground(Color.BLACK);
	keuze4.setFont(new Font("Arial", Font.PLAIN, 25));
	keuze4.setBounds(850, 300, 500, 130);
	BiljetOpties.add(keuze4);
	keuze4.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
	    	if(bills[0][3] > 0 || bills[1][3] > 0 || bills[2][3] > 0) {
	    		SwitchPanels(Receipt);
	    	}
	    }
	});
 
	keuze5.setForeground(Color.BLACK);
	keuze5.setFont(new Font("Arial", Font.PLAIN, 25));
	keuze5.setBounds(850, 450, 500, 130);
	BiljetOpties.add(keuze5);
	keuze5.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
	    	if(bills[0][4] > 0 || bills[1][4] > 0 || bills[2][4] > 0) {
	    		SwitchPanels(Receipt);
	    	}
	    }
	});

	keuze6.setForeground(Color.BLACK);
	keuze6.setFont(new Font("Arial", Font.PLAIN, 25));
	keuze6.setBounds(850, 600, 500, 130);
	BiljetOpties.add(keuze6);
	keuze6.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {  
	    	if(bills[0][5] > 0 || bills[1][5] > 0 || bills[2][5] > 0) {
	    		SwitchPanels(Receipt);
	    	}
	    }
	});

	   
	
	setVisible(true);
	
	}
	
	private void optionButtons() {
		keuze1.setText(getOptionString(1));
		keuze2.setText(getOptionString(2));
		keuze3.setText(getOptionString(3));
		keuze4.setText(getOptionString(4));
		keuze5.setText(getOptionString(5));
		keuze6.setText(getOptionString(6));
	}
	
	private String getOptionString(int i) {
		String s = "";
		if(bills[0][i-1] > 0) s+= bills[0][i-1] + "x50 ";
		if(bills[1][i-1] > 0) s+= bills[1][i-1] + "x20 ";
		if(bills[2][i-1] > 0) s+= bills[2][i-1] + "x10";
//		String s = bills[0][i-1] + "x50 " + bills[1][i-1] + "x20 " + bills[2][i-1] + "x10";
		return s;
	}
	
	private void billButton(int amount, JButton button) {
		if(options.getMax() >= amount  && Integer.parseInt(savings) >= amount) {
			button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					withdrawn = amount;
					SwitchPanels(Receipt);
				}
		    });
		}
		else {
			button.setBackground(new Color(255, 0, 0));
		}
	}
	
	private void fast() {
		if(options.getMax() >= 70 && Integer.parseInt(savings) >= 70) {
			btnFast.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					withdrawn = 70;
					SwitchPanels(Receipt);
				}	
			});
		}
		else {
			btnFast.setBackground(new Color(255, 0, 0));
		}
	}
	
	public void SwitchPanels(JPanel panel) {
		if(panel == Home) fast();
		if(panel == BiljetOpties) {
			optionButtons();
		}
		if(panel == Withdrawal) {
			billButton(10, button_4);
			billButton(20, button);
			billButton(50, button_3);
		}
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	
	}

    public void changeLanguage() {

    	if(Language) {
    //Set Dutch
    	btnHome2.setText("Thuis");
    	btnHome3.setText("Thuis");
    	btnHome4.setText("Thuis");
    	//next.setIcon(new ImageIcon(Test.class.getResource("/img/UK.jpg")));
    	lblInsertCard.setText("Voer alstublieft uw kaart in");
    	btnContinue_1.setText("Doorgaan");
    	btnClear_1.setText("Wis uit");
    	btnAbort.setText("Stop");
    	//button_9.setIcon(new ImageIcon(Test.class.getResource("/img/UK.jpg")));
    	lblInsertPin.setText("Voer alstublieft uw pincode in"); 
    	option.setText("Maak een keuze alstublieft"); 
    	btnBalance.setText("Saldo"); 
    	btnWithdrawal.setText("Opname"); 
    	btnFast.setText("Snel \u20AC 70");
    	btnStop.setText("Stop"); 
    	btnWithdrawal2.setText("Opname"); 
    	btnFast2.setText("Snel \u20AC 70");
    	btnAbort3.setText("Stop"); 
    	lblBalance.setText("Saldo:"); 
    	lblAccount.setText("Rekening:"); 
    	lblPleaseSelectAn.setText("Selecteer een bedrag"); 
    	lblPressDTo.setText("Druk op D om een eigen bedrag in te voeren"); 
    	btnOther.setText("Ander"); 
    	btnAbort4.setText("Stop"); 
    	PEA.setText("Vul alstublieft een bedrag in"); 
    	btnContinue.setText("Doorgaan"); 
    	btnClear.setText("Wis uit"); 
    	btnAbort5.setText("Stop"); 
    	lblAmount.setText("Bedrag:"); 
    	lblNoteThisAtm.setText("Opmerking: Deze pinautomaat geeft alleen 10, 20 en 50 euro biljetten uit"); 
    	ThanksFor.setText("Bedankt dat u De Bank gekozen hebt"); 
    	lblNiceday.setText("Nog een prettige dag toegewenst!");
    	Language = false;
    	}
    else if(!Language) {
    //Set English
    btnHome2.setText("Home");
   	btnHome3.setText("Home");
   	btnHome4.setText("Home");
   	//next.setIcon(new ImageIcon(Test.class.getResource("/img/Image 045.jpg")));
   	lblInsertCard.setText("Please Insert Your Card");
   	btnContinue_1.setText("Continue");
   	btnClear_1.setText("Clear");
   	btnAbort.setText("Abort");
   	//button_9.setIcon(new ImageIcon(Test.class.getResource("/img/Image 045.jpg")));
   	lblInsertPin.setText("Please Insert Your Pin Code"); 
   	option.setText("Please select an option"); 
   	btnBalance.setText("Balance"); 
   	btnWithdrawal.setText("Withdraw"); 
   	btnFast.setText("Fast \u20AC 70"); 
   	btnStop.setText("Abort"); 
   	btnWithdrawal2.setText("Withdraw");  
   	btnFast2.setText("Fast \u20AC 70"); 
   	btnAbort3.setText("Abort"); 
   	lblBalance.setText("Balance:"); 
   	lblAccount.setText("Account:"); 
   	lblPleaseSelectAn.setText("Please select an amount"); 
   	lblPressDTo.setText("Press D to enter a custom amount"); 
   	btnOther.setText("Other"); 
   	btnAbort4.setText("Abort"); 
   	PEA.setText("Please enter an amount"); 
   	btnContinue.setText("Continue"); 
   	btnClear.setText("Clear"); 
   	btnAbort5.setText("Abort"); 
   	lblAmount.setText("Amount:"); 
   	lblNoteThisAtm.setText("NOTE: This ATM only returns 10, 20 and 50 euro bills."); 
   	ThanksFor.setText("Thank you"); 
   	lblNiceday.setText("Have a nice day!");
   	Language = true;
    	}
    }
}