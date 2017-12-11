package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;
import sortomania.Generic;

public class SampleContestant extends Contestant{


	@Override
	public double sortAndGetMedian(int[] random) {
		Arrays.sort(random);
		
		return median(random);
	}
	
	public String toString(){
		return "Wizard";
	}

	private double median(int[] sorted) {
		if (sorted.length % 2 == 0){
			return (sorted[sorted.length/2] + sorted[sorted.length/2-1])/2.0;
		}
		return sorted[sorted.length/2];
	}
	
	public double sortAndGetMedian(double[] random) {
		Arrays.sort(random);
		
		return median(random);
	}
	
	private double median(double[] sorted) {
		if (sorted.length % 2 == 0){
			return (sorted[sorted.length/2] + sorted[sorted.length/2-1])/2.0;
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
			quickSort(row,0,row.length-1);
			rowMedians[i] = median(row);

			i++;
		}
		return sortAndGetMedian(rowMedians);
	}
	
    private void quickSort(int[] array, int lowerIndex, int higherIndex) {
        
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (i < array.length && array[i] < pivot) {
                i++;
            }
            while (j>= 0 && array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array,lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,i, higherIndex);
    }
 
    private void exchangeNumbers(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
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

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.blue;
	}

	@Override
	public String getSpriteName() {
		return CHUN_LI;
	}


}
