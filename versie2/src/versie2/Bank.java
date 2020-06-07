package versie2;

public class Bank {

	public static void main(String[] args) {
		SQLCon sql = new SQLCon();
		sql.withdraw("OZ-DEBA-12547862", "10000");
//		Mailer mail = new Mailer();
//		mail.send("dubank.bonnetje@gmail.com","dubank123","pimvdtoorn@hotmail.com","test","test");  
	}

}
