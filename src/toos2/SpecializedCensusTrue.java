package toos2;

import java.util.ArrayList;

// For C2
public class SpecializedCensusTrue implements Census {
	private int trueVotes = 0;
	
	@Override		
	public boolean voting(ArrayList<Voter> voters) throws Exception {
		boolean toReturn = true;
		if (voters != null) {
			for(Voter v: voters) {
				if (v !=null){
					if (!v.vote()) {
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

}
