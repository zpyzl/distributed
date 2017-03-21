package paxos.core;

import paxos.network.Communication;
import paxos.network.Server;

public abstract class Acceptor {
	
	private Server server;

	private Integer highestPromised;
	
	private String highestAcceptedValue;
	
	//phase 1 b
	public void onReceivePrepare(SeqMsg seqMsg){
		if( seqMsg.getSeqNum() > this.highestPromised ){
			promise( seqMsg );
		}
	}
	
	private void promise(SeqMsg seqMsg) {
		//make this seqMsg the highest seq number ever promised, 
		//thus smaller seq will be ignored.
		this.highestPromised = seqMsg.getSeqNum();
		
		sendPromise( seqMsg.getSender(), seqMsg.getSeqNum(), this.highestAcceptedValue );
	}

	private void sendPromise(Server target, Integer seqNum, String highestProposalValue) {
		Promise promise = new Promise();
		promise.setSeqNum(seqNum);
		promise.setHighestProposalValue(highestProposalValue);
		promise.setAcceptor(this);
		
		Communication.sendMsg( target, promise);
	}

	//phase 2 b
	public void onReceiveAccept(Proposal acceptRequest){
		//accept unless promised a higher number prepare
		if( acceptRequest.getSeqNum() > this.highestPromised ){
			accept( acceptRequest );
			this.highestAcceptedValue = acceptRequest.getValue();
		}
	}
	
	public abstract void accept(Proposal proposal);
	
	
	
	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

}
