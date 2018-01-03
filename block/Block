package agh.blockchain.block;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import agh.blockchain.chain.Blockchain;
import agh.blockchain.encrypt.HashAlgorithm;

public class Block {

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getPrevHash() {
		return prevHash;
	}

	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getProof() {
		return proof;
	}

	public void setProof(long proof) {
		this.proof = proof;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	private int index;
	private Date timestamp;
	private String prevHash;
	private String hash;
	private String data;
	private long proof;
	private List<Transaction> transactions;

	public Block(int index, String data, List<Transaction> transactions) {
		this.index = index;
		this.timestamp = Calendar.getInstance().getTime();
		this.data = data;

		if (Blockchain.chain.size() == 0) {
			this.prevHash = "";
			
		} else {
			
			String prevHash = Blockchain.getLastBlock().hash;
			this.prevHash = prevHash;
		}

		this.transactions = transactions;

		String base = "";
		String newHash = "";

		try {
			
			base = calculateBaseForHash();
			newHash = HashAlgorithm.toSha256(base);
			this.setHash(newHash);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mineBlock(int difficulty) {
		String zeroes = new String(new char[difficulty]).replace('\0', '0');
		String base = "";
		while (!hash.substring(0, difficulty).equals(zeroes)) {
			proof++;
			try {
				base = calculateBaseForHash();
				hash = HashAlgorithm.toSha256(base);
				this.setHash(hash);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Date getActualDate() {
		return Calendar.getInstance().getTime();
	}

	public String calculateBaseForHash() throws Exception {
		String base = Integer.toString(index) + Long.toString(proof) + prevHash + data;
		return base;
	}

}
