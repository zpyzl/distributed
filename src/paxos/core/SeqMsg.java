package paxos.core;

import paxos.network.Msg;

public class SeqMsg extends Msg{

	private Integer seqNum;
	
	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}
	
	
}
