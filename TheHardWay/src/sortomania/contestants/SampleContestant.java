package sortomania.contestants;

import java.awt.Graphics2D;
import java.util.Arrays;

import sortomania.Contestant;

public class SampleContestant extends Contestant{


	@Override
	public double sortAndGetMedian(int[] random) {
		Arrays.sort(random);
		
		return median(random);
	}

	private double median(int[] sorted) {
		if (sorted.length % 2 == 0){
			return (sorted[sorted.length/2] + sorted[sorted.length/2])/2.0;
		}
		return sorted[sorted.length/2];
	}
	
	public double sortAndGetMedian(double[] random) {
		Arrays.sort(random);
		
		return median(random);
	}
	
	private double median(double[] sorted) {
		if (sorted.length % 2 == 0){
			return (sorted[sorted.length/2] + sorted[sorted.length/2])/2.0;
		}
		return sorted[sorted.length/2];
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		Arrays.sort(strings);
		int i = -1;
		for(int j = 0; j < strings.length; j++){
			if(strings[j].equals(toFind)){
				i = j;
				break;
			}
		}
		return i;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {

		return sortAndGetMedian(mostlySorted);
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		double[] rowMedians = new double[grid.length];
		int i = 0;
		for(int[] row : grid){
			rowMedians[i] = sortAndGetMedian(row);
			i++;
		}
		return sortAndGetMedian(rowMedians);
	}

	@Override
	public int sortAndSearch(int[] arr, int toFind) {
		Arrays.sort(arr);
		int i = -1;
		for(int j = 0; j < arr.length; j++){
			if(arr[j]==toFind){
				i = j;
				break;
			}
		}
		return i;
	}


}
