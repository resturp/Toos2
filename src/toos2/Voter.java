package toos2;

public class Voter {
	public boolean vote;
	private int voted;
	
	public boolean vote() {		
		this.voted++;
		return vote;		
	}

	public Voter(boolean init) {		
		this.vote = init;
	}
	
	public void resetVoted() {
		voted = 0;
	}
	public int getVoted(){
		return voted;
	}

	public Voter() {
		this(true);
	}
}
