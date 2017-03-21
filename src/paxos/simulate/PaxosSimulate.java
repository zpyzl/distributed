package paxos.simulate;

import java.util.HashSet;
import java.util.Set;

import paxos.core.Acceptor;
import paxos.core.Proposer;


public class PaxosSimulate {

	public static void main(String[] args){
		Set<Proposer> proposers = new HashSet<Proposer>();
		Set<Acceptor> acceptors = new HashSet<Acceptor>();
		
		for( Proposer proposer : proposers ){
			proposer.setAcceptors(acceptors);
			
			proposer.prepare();
			
		}
	}
}
