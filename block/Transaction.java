package agh.blockchain.block;

public class Transaction {

	public Transaction(String sender, String recipient, double amount) {

		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	private String sender;
	private String recipient;
	private double amount;
}
