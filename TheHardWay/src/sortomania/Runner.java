package sortomania;

import java.util.ArrayList;
import sortomania.contestants.*;

import guiTeacher.GUIApplication;

public class Runner extends GUIApplication{

	
	ContestScreen screen;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4596548043619696133L;

	public Runner() {
		super(800, 500);
		Thread compete = new Thread(screen);
		compete.start();
	}

	private void randomize(ArrayList a) {
		for(int i = 0; i < a.size(); i++){
			Object o = a.get(i);
			int rand = (int)(Math.random()*a.size());
			a.set(i, a.get(rand));
			a.set(rand, o);
		}
		
	}

	public static void main(String[] args) {
		Runner competition = new Runner();
		competition.setVisible(true);
		Thread go = new Thread(competition);
		go.start();

		
	}



	
	void populate(ArrayList<Contestant> participants){
		int x = 40; 
		int y = 40; 
		for(int i = 0; i < 16; i++){
			SampleContestant c = new SampleContestant();
			c.setX(x);
			c.setY(y);
			c.setNumber(i);
			y+=c.getHeight()+10;
			participants.add(c);
		}
		
	}

	@Override
	public void initScreen() {
		ArrayList<Contestant> participants = new ArrayList<Contestant>();
		populate(participants);
		randomize(participants);
		ContestScreen screen = new ContestScreen(getWidth(), getHeight());
		screen.setparticipants(participants);
		setScreen(screen);
	}

}
