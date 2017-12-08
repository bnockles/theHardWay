package sortomania;

public class CompetitionRunner implements Runnable {

	Contestant c;
	
	public CompetitionRunner(Contestant c, DataSets ds) {
		this.c= c;
	}

	@Override
	public void run() {
		c.beginTask(1);
		ds.chec
	}

}
