package toos2;

import java.util.ArrayList;

public class Census2 implements Census {

	@Override
	public boolean voting(ArrayList<Voter> voters) {
		for(Voter v: voters) {
			if( v.vote() == false ) {
				return false;
			}
		}
		return true;
	}

}
