package agh.blockchain.mine;

import agh.blockchain.block.Block;
import agh.blockchain.chain.Blockchain;

public class Miner {

	public static void mineNewBlock(String data) throws Exception {

		Block blockToMine = new Block(Blockchain.chain.size(), data, Blockchain.transactionsToAdd);
		Blockchain.addBlock(blockToMine);
	}
}
