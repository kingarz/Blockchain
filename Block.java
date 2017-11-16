import java.util.Calendar;
import java.util.Date;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Block {

	public Block(int index, String data) {
		this.index = index;
		this.timestamp = Calendar.getInstance().getTime();
		this.data = data;
		this.prevHash = "";
		try {
			this.hash = calculateHash();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//trzeba dopisac metode do tworzenia transakcji
	public int index;
	public Date timestamp;
	//public long proof;
	public String prevHash;
	public String hash;
	public String data;
	//public Transaction[] transaction;
	
	public Date getActualDate(){
		return Calendar.getInstance().getTime();
	}

	public String calculateHash() throws Exception {

		// converts Date to String (format below)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String stringDate = df.format(timestamp);

		String toHash = Integer.toString(index) + prevHash + stringDate + data;

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(toHash.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

}