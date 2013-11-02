package toos2;

import java.util.ArrayList;

public class Census7 implements Census {

	@Override
	public boolean voting(ArrayList<Voter> voters) throws Exception {
		boolean toReturn = true;
		if (voters != null) {
			for(Voter v: voters) {
				if (v !=null){
					if (!v.vote()) {
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

}
