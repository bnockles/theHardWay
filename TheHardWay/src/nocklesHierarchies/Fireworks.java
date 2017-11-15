package nocklesHierarchies;

public class Fireworks {

	private String[][] sky;
	
	public static void main(String[] args) {
		Fireworks show = new Fireworks();
		String s = "a";
		show.start();
	}

	private void start() {
		int count = 8;
		while(count > 0) {
			explode();
			displaySky();
			pause(40);
		}
	}

	private void explode() {
		// TODO Auto-generated method stub
		
	}

	private void displaySky() {
		for(String[] row: sky) {
			for(String element: row) {
				System.out.print(element);
			}
			System.out.println("");
		}
	}

	private void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Fireworks() {
		sky = new String[8][8];
		for(String[] row: sky) {
			for(int col = 0; col < row.length; col++) {
				row[col] = " ";
			}
		}
		sky[4][4] = "O";
	}
	
}
