package toos2;

import java.util.ArrayList;

public class Census3 implements Census {

	@Override
	public boolean voting(ArrayList<Voter> voters) {
		int notNullVotes = 0;
		int nullVotes = 0;
		boolean result = true;
		if(voters != null) {
			for (Voter v : voters) {
				if (v != null) {
					if (v.vote() == false) {
						result = false;
					}
					notNullVotes += 1;
				} else {
					nullVotes += 1;
				}
			}
		} else {
			return true;
		}
		
		if (notNullVotes + nullVotes > voters.size()) {
			//throw new Exception( "Valid voters has voted more than once.");
		} else {
			if (notNullVotes + nullVotes < voters.size()) {
				//throw new Exception( "Valid voters has not voted.");
			} else {
				return result;
			}
		}
		return result;
	}

}
