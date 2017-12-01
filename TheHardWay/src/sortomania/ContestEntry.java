package sortomania;

public abstract class ContestEntry {

	public ContestEntry() {
		// TODO Auto-generated constructor stub
	}

	public abstract int sortAndGetMedian(int[] random);
	
	public abstract int sortAndGetResultingIndexOf(String[] strings, String toFind);
	
	public abstract int mostlySortAndGetMedian(int[] mostlySorted);
	
	public abstract int sortMultiDim(int[][] grid);
	
	public abstract int sortAndSearch(int[] arr);
	
}
