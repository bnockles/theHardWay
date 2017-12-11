package sortomania;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class ContestScreen extends ClickableScreen implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Contestant> participants;
	private ArrayList<Contestant> runnersUp;
	private TextLabel message;
	private int pairsCompeting;
	private int pairsFinished;
	private int round;

	public ContestScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void setparticipants(ArrayList<Contestant> p){
		this.participants = p;
		for(Contestant c: participants){
			addObject(c);
		}
	}

	public void displayMessage(String message){
		this.message.setText(message);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		runnersUp = new ArrayList<Contestant>();
		message = new TextLabel(5, 30, getWidth()-10, 40, "");
		message.setCustomAlign(0);
		viewObjects.add(message);
	}


	public void run() {
		round = 0;
		newRound();

	}

	/**
	 * Call by Pair after both contestants have finished sorting
	 */
	public void notifyFinish(){
		pairsFinished++;
		if(pairsFinished == pairsCompeting){
			removeLosers();
			if(participants.size() == 1){
				Contestant champ = participants.get(0);
				champ.move((getWidth()-champ.getWidth())/2, 90);
				displayMessage("The champion is "+champ);
				displayRunnersUp();

			}else{
				newRound();
			}

		}else{
			displayMessage("Waiting for "+(pairsCompeting-pairsFinished)+" pairs to finish.");
		}
	}

	private void displayRunnersUp() {
		runnersUp.sort(new Comparator<Contestant>() {

			@Override
			public int compare(Contestant o1, Contestant o2) {
				return o2.getScore() - o1.getScore();
			}

		});
		int initY = 310;
		int x = 25;
		int y = initY;
		for(Contestant c :runnersUp){
			addObject(c);
			Thread show = new Thread(new Runnable() {

				@Override
				public void run() {
					float visibility = 0f;
					while(visibility< 1.0){
						if(visibility < 1.0){
							c.setAlpha(visibility);
						}else{
							c.setAlpha(1.0f);
						}
						visibility+=.1;
						try {
							Thread.sleep(45);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			show.start();

			c.move(x, y);
			y+= c.getHeight()+10;
			if(y+c.getHeight() > getHeight()){
				y = initY;
				x+= c.getWidth()+10;
			}
		}

	}

	private void newRound() {
		round++;
		DataSets ds = new DataSets();
		pairsCompeting = 0;
		pairsFinished = 0;

		positionCompetitors();
		String[] texts = {"Begining round "+round+"...","On your marks...","Get set...","Go!","ROUND "+round};
		for(String s : texts){
			displayMessage(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		startCompeting(ds);



	}

	private void startCompeting(DataSets ds) {
		for(int i = 0; i < participants.size() - 1; i++){
			Contestant c1 = participants.get(i);
			Contestant c2 = participants.get(++i);
			Pair pair = new Pair(c1, c2);
			pairsCompeting++;
			CompetitionRunner cr1 = new CompetitionRunner(c1, ds, pair);
			CompetitionRunner cr2 = new CompetitionRunner(c2, ds, pair);
			Thread compete1 = new Thread(cr1);
			Thread compete2 = new Thread(cr2);
			compete1.start();
			compete2.start();	
		}
	}

	private void positionCompetitors() {
		int xa = 50;
		int xb = 480;
		int y = 50;
		int deltaY = 180;
		for(int i = 0; i < participants.size() - 1; i++){
			Contestant c1 = participants.get(i);
			Contestant c2 = participants.get(++i);
			c1.move(xa, y);
			c2.move(xb, y);
			y+= deltaY;
			if(y+deltaY>getHeight()){
				y=50;
				xa+=500;
				xb+=500;
			}
		}
	}

	private void removeLosers() {
		//		Iterator<Contestant> iterator = participants.iterator();
		for(int i = 0; i < participants.size(); i++){
			Contestant c = participants.get(i);
			if(!c.wonLastRound()){
				participants.remove(c);
				runnersUp.add(c);
				i--;
				if(participants.size() >1){
					Thread fadeOut = new Thread(new Runnable() {

						@Override
						public void run() {
							float visibility = 1.0f;
							while(visibility - .1 >0){
								visibility -= .1;
								c.setAlpha(visibility);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							ContestScreen.this.remove(c);
						}
					});
					fadeOut.start();
				}
			}
		}
	}

	

}
