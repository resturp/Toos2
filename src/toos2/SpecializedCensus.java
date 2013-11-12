package toos2;

import java.util.ArrayList;

// For C2
public class SpecializedCensus extends Census7{
	
	private int trueVotes = 0;
	private int falseVotes = 0;
		
	public boolean voting(ArrayList<Voter> voters) throws Exception {
		trueVotes = 0;
		falseVotes = 0;
		
		if (voters != null) {
			for(Voter v: voters) {
				if (v !=null){
					if (!v.vote()) {
						falseVotes++;
					} else {
						trueVotes++;
					}
					v.resetVoted();
				}
			}
		}
		return super.voting(voters);
	}
	
	public int getTrueVotes() {
		return trueVotes;
	}
	
	public int getFalseVotes() {
		return falseVotes;
	}

}
