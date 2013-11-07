package toos2;

import java.util.ArrayList;

// For C2
public class SpecializedCensus {
	
	private int trueVotes = 0;
	private int falseVotes = 0;
		
	public boolean voting(ArrayList<Voter> voters) throws Exception {
		boolean toReturn = true;
		if (voters != null) {
			for(Voter v: voters) {
				if (v !=null){
					if (!v.vote()) {
						falseVotes++;
						toReturn = false;
					} else {
						trueVotes++;
					}
					if (v.getVoted() !=1) {
						throw new Exception(" voted more then once ");
					}
				}
			}
		}
		return toReturn;
	}
	
	public int getTrueVotes() {
		return trueVotes;
	}
	
	public int getFalseVotes() {
		return falseVotes;
	}

}
