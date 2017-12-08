package sortomania;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public abstract class Contestant extends Component{

	int contestantNumber;
	
	public Contestant() {
		super(0, 0, 70, 70);
	}
	
	public void setNumber(int i){
		contestantNumber = i;
		update();
	}

	/**
	 * TASK 1
	 * sorts a completely randomized array and returns the median
	 * @param random
	 * @return
	 */
	public abstract double sortAndGetMedian(int[] random);
	
	/**
	 * TASK 2
	 * sorts a completely randomized array of random Strings and returns the index of
	 * the given String in the resulting sorted array
	 * @param random
	 * @return
	 */
	public abstract int sortAndGetResultingIndexOf(String[] strings, String toFind);
	
	
	/**
	 * TASK 3
	 * sorts a mostly sorted array and returns the median
	 * @param random
	 * @return
	 */
	public abstract double mostlySortAndGetMedian(int[] mostlySorted);
	
	/**
	 * TASK 4
	 * sorts each array in a multi-dimensional array
	 * then returns the median of the medians
	 * @param random
	 * @return
	 */
	public abstract double sortMultiDim(int[][] grid);
	
	/**
	 * TASK 5
	 * sorts each array in a multi-dimensional array
	 * then returns the median of the medians
	 * @param random
	 * @return
	 */
	public abstract int sortAndSearch(Generic[] arr, Generic toFind);

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		g.drawString(""+contestantNumber, 0, getHeight());
	}

	/**
	 * Performs a show demonstrating the Contestant has started the next task
	 * @param i
	 */
	public void beginTask(int i) {
		// TODO Auto-generated method stub
		
	}


}
