package sortomania.contestants;

import java.util.Arrays;

import sortomania.Contestant;
import sortomania.Generic;

public class SampleContestant4 extends Contestant{

	@Override
	public double sortAndGetMedian(int[] random) {
		sort(random);
		
		return median(random);
	}
	
	public String toString(){
		return "Flawed contestant";
	}
	
    private int[] numbers;
    private int[] helper;

	
    public void sort(int[] values) {
        this.numbers = values;
        this.helper = new int[values.length];
        mergesort(0, values.length - 1);
    }
	
    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
//        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
//        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }

	private double median(int[] sorted) {
		if (sorted.length % 2 == 0){
			return (sorted[sorted.length/2-1] + sorted[sorted.length/2])/2.0;
		}
		return sorted[sorted.length/2];
	}
	
	public String getSpriteName() {
		return DEE_JAY;
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
			rowMedians[i] = sortAndGetMedian(row);

			i++;
		}
		return sortAndGetMedian(rowMedians);
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


}
