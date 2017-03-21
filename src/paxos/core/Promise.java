package paxos.core;

public class Promise {
	
	private Integer seqNum;
	private String highestProposalValue;
	private Acceptor acceptor;
	
	public Integer getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}
	public String getHighestProposalValue() {
		return highestProposalValue;
	}
	public void setHighestProposalValue(String highestProposalValue) {
		this.highestProposalValue = highestProposalValue;
	}
	public Acceptor getAcceptor() {
		return acceptor;
	}
	public void setAcceptor(Acceptor acceptor) {
		this.acceptor = acceptor;
	}
	
	
	
}
