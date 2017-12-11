package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;
import sortomania.Generic;

public class SampleContestant3 extends Contestant {

	@Override
	public double sortAndGetMedian(int[] random) {
		radixsort(random, random.length);
		
		return median(random);
	}
	
	public String toString(){
		return "THE BEAST";
	}
	
	// A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
	public String getSpriteName() {
		return BLANKA;
	}

    
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
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

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.ORANGE;
	}
}
