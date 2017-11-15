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
			
			displaySky();
			pause(300);
			expand();
			update();
			count--;
			System.out.println("");
		}
	}

	private void update() {
		for(int row = 0; row< sky.length; row++) {
			for(int col = 0; col < sky[row].length; col++) {
				if(sky[row][col].equals("0")) {
					sky[row][col] = "o";
				
				}else if(sky[row][col].equals("O")) {
					sky[row][col] = "0";
				
				}
			}
		}
	}
	


	private void expand() {
		for(int row = 0; row< sky.length; row++) {
			for(int col = 0; col < sky[row].length; col++) {
				if(sky[row][col].equals("0")) {
					ripple(row,col);
					sky[row][col] = "o";
				}
			}
		}
	}

	private void ripple(int row, int col) {
		A: for(int i = row - 1; i <= row+1; i++) {
			for(int j = col -1; j <= col +1; j++) {
				if(i >= 0 && i < sky.length && j >= 0 && j < sky[i].length) {
					if(sky[i][j].equals(" ")) {
						sky[i][j] = "O";
//						break A;
					}
				}
			}
		}
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
		sky = new String[9][9];
		for(String[] row: sky) {
			for(int col = 0; col < row.length; col++) {
				row[col] = " ";
			}
		}
		sky[4][4] = "0";
	}
	
}
