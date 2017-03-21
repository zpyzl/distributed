package paxos.network;

public class Msg {

	private Server sender;
	private Server receiver;
	
	public Server getSender() {
		return sender;
	}
	public void setSender(Server sender) {
		this.sender = sender;
	}
	public Server getReceiver() {
		return receiver;
	}
	public void setReceiver(Server receiver) {
		this.receiver = receiver;
	}
	
	
}
