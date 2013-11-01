package toos2;

public abstract  class Voter {
	public boolean vote;
	public int voted;
	
	public boolean vote() {		
		return vote;		
	}

	public Voter(boolean init) {		
		this.vote = init;
		this.voted++;
	}
	
	public int getVoted(){
		return voted;
	}

	public Voter() {
		this(true);
	}
}
