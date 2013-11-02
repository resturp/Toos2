package toos2;

import java.util.ArrayList;

public class Census5 implements Census {

	@Override
	public boolean voting(ArrayList<Voter> voters) {
		// TODO Auto-generated method stub
		boolean id[] = new boolean[voters.size()]; // id has voted?
		for (int i = 0; i < voters.size(); i++) {
			id[i] = false;
		}
		
		boolean result = true;
		int i = 0;
		for(Voter v: voters) {
			boolean vote = v.vote();
			id[i] = true;
			if (result == true && vote == false) {
				result = false;
			}
			i++;
		}
		
		for (i = 0; i < voters.size(); i++) {
			boolean voted = id[i];
			if (voted) {
				result = false;
				i = voters.size(); // Break out loop
			}			
		}
		
		return result;
	}

}
