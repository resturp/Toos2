package toos2;

import java.util.ArrayList;

public class Census1 implements Census {

	@Override
	public boolean voting(ArrayList<Voter> voters) {
		// TODO Auto-generated method stub
		if (!(voters == null)) {
			for(Voter v: voters) {
				if (!(v ==null)){
					if (!v.vote()) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
