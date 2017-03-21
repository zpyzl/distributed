package paxos.core;

import java.util.HashSet;
import java.util.Set;

import paxos.network.Communication;

public abstract class Proposer {

	//one proposer only care for one seqNum
	private Integer seqNum;
		
	private Set<Acceptor> acceptors;
	
	private Set<Promise> promises = new HashSet<Promise>();
	
	public void run(){
		
	}
	
	//get a sequence number for prepare message
	public abstract Integer getSeq();
	
	//phase 1 a
	public void prepare(){
		this.seqNum = getSeq();
		
		SeqMsg seqMsg = new SeqMsg();
		seqMsg.setSeqNum(this.seqNum);
		
		//send to all acceptors or a majority? maybe should be larger than
		//a majority for fault tolerant, but not too big to prevent network congestion
		for( Acceptor acceptor : acceptors){
			Communication.sendMsg( acceptor.getServer(), seqMsg );
		}
	}
	
	//phase 2 a
	public void onReceivePromise(Promise promise){
		promises.add(promise);
										
		if( promises.size() > acceptors.size() / 2  ){
			Proposal acceptRequest = new Proposal();
			acceptRequest.setSeqNum(promise.getSeqNum());
			acceptRequest.setValue(promise.getHighestProposalValue());
			
			//send to all the promises' acceptors
			for( Promise eachPromise : promises){
				Communication.sendMsg( eachPromise.getAcceptor().getServer(), acceptRequest);
			}
		}
		
	}
	
	public Set<Acceptor> getAcceptors() {
		return acceptors;
	}

	public void setAcceptors(Set<Acceptor> acceptors) {
		this.acceptors = acceptors;
	}
}
