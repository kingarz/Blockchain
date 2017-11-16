import java.util.ArrayList;
import java.util.List;

public class Blockchain{
	
	public Blockchain(){
		this.chain.add(createGenesisBlock());
	}
	
	public List<Block> chain = new ArrayList<Block>();
	public void newTransaction(Transaction t){
		
	}
	
	public void addBlock(Block b){
	
		b.prevHash = getLastBlock().hash;
		b.data = "Block nb 2";
		b.index = getLastBlock().index + 1;
		try {
			b.hash = b.calculateHash();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.timestamp = b.getActualDate();
		this.chain.add(b);
	}
	
	private String hashBlock(){
		return "";
	}
	
	private long proofOfWork(){
		return 1;
	}
	
	public Block createGenesisBlock(){
		return new Block(1,"A new block");
	}
	
	public Block getLastBlock(){
		return chain.get(chain.size()-1);
	}
	
	public static void main(String [] args){
		System.out.println("test");
		Blockchain testBlock = new Blockchain();
		testBlock.addBlock(new Block(1,"Hey1"));
		testBlock.addBlock(new Block(2,"Hey2"));
		System.out.println("");
	}
}