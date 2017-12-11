package sortomania;

public final class Pair {

	private Contestant c1;
	private Contestant c2;
	private Contestant winner;
	
	
	public Pair(Contestant c1, Contestant c2) {
		this.c1 = c1;
		this.c2 = c2;
	}


	public Contestant getWinner() {
		return winner;
	}


	public synchronized void setWinner(Contestant winner) {
		if(this.winner == null){
			this.winner = winner;
			winner.markVictorious(true);
			System.out.println("Winner declared.");
		}else{
			System.out.println("Winner already declared.");
			winner.markVictorious(false);
			Runner.screen.notifyFinish();
		}
	}
	
	

}
