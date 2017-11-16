public class Transaction {

	public Transaction(String sender, String recipient, double amount) {

		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}

	public String sender;
	public String recipient;
	public double amount;
}
