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
	private boolean isChainValid()
	{
		for (int i = 1; i <= chain.size()-1 ; i++)
		{
			Block currentBlock = chain.get(i);
			Block prevBlock = chain.get(i - 1);
			
			try {
				if(currentBlock.hash != currentBlock.calculateHash())
				{
					System.out.println("Invalid hash");
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(currentBlock.prevHash != prevBlock.hash){
				System.out.println("Invalid previous hash");
				return false;
			}
			
			if(currentBlock.index != prevBlock.index+1){
				System.out.println("Invalid index");
				return false;
			}
		}
		
		
		return true;
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