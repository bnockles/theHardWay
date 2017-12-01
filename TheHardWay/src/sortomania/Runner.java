package sortomania;

import java.util.ArrayList;

public abstract class Runner {

	public Runner() {
		ArrayList<ContestEntry> participants = new ArrayList<ContestEntry>();
		populate(participants);
	}

	public static void main(String[] args) {
		Runner competition = new Runner();
		
	}

	abstract void populate(ArrayList<ContestEntry> participants);

}
