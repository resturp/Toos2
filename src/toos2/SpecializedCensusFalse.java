package toos2;

import java.util.ArrayList;

// For C2
public class SpecializedCensusFalse extends Census7 {
	private int falseVotes = 0;
		
	@Override	
	public boolean voting(ArrayList<Voter> voters) throws Exception {
	    //We should calc the number of falsevoters
		//And then return the super implementation
		//of voting. But then the vote() metods
		//of the voters would be called twice.
		
		//return super.voting(voters);
		
		boolean toReturn = true;
		if (voters != null) {
			for(Voter v: voters) {
				if (v !=null){
					if (!v.vote()) {
						falseVotes++;
						toReturn = false;
					}
					if (v.getVoted() !=1) {
						throw new Exception(" voted more then once ");
					}
				}
			}
		}
		return toReturn;
	}
	
	public int getFalseVotes() {
		return falseVotes;
	}

}
