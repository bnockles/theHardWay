package sortomania;

import java.util.ArrayList;
import sortomania.contestants.*;

import guiTeacher.GUIApplication;

public class Runner extends GUIApplication{

	
	static ContestScreen screen;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4596548043619696133L;

	public Runner() {
		super(1200, 800);
		
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

		competition.runContest();
	}

	public void runContest(){
		Thread compete = new Thread(screen);
		compete.start();
	}
	


	
	void populate(ArrayList<Contestant> participants){
		int x = 40; 
		int y = 60; 
		for(int i = 0; i < 4; i++){
			
			Contestant c = new SampleContestant();
			if(i == 1){
				c = new SampleContestant2();
			}
			if(i == 2){
				c = new SampleContestant3();
			}
			if(i == 3){
				c = new SampleContestant4();
			}
			
			c.setX(x);
			c.setY(y);
			c.setNumber(i+1);
			y+=c.getHeight()+10;
			participants.add(c);
			Thread animation = new Thread(c);
			animation.start();
		}
		
	}

	@Override
	public void initScreen() {
		ArrayList<Contestant> participants = new ArrayList<Contestant>();
		populate(participants);
		randomize(participants);
		screen = new ContestScreen(getWidth(), getHeight());
		screen.setparticipants(participants);
		setScreen(screen);
	}

}
