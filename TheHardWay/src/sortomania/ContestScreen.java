package sortomania;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class ContestScreen extends ClickableScreen implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Contestant> participants;
	
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
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}

	
	public void run() {
		DataSets ds = new DataSets();
		for(Contestant c: participants){
			CompetitionRunner cr = new CompetitionRunner(c, ds);
			Thread compete = new Thread(cr);
			compete.start();
			
		}
	}
}
