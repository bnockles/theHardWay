package sortomania;

import java.util.Arrays;
import java.util.Comparator;

public class DataSets {

	private int[][] task1DataSets;//random
	private int[][] task1DataSetsSorted;
	private double[] task1Median;
	
	private String[][] task2DataSets;//random
	private String[][] task2DataSetsSorted;//random
	private String[] task2Key;
	private int[] task2Index;
	
	private int[][] task3DataSets;//mostly sorted
	private int[][] task3DataSetsSorted;//mostly sorted
	private double[] task3Median;
	
	private int[][][] task4DataSets;//2D arrays
	private int[][][] task4DataSetsSorted;//2D arrays
	private double[] task4Median;
	
	private Generic[][] task5DataSets;//2D arrays
	private Generic[][] task5DataSetsSorted;//2D arrays
	private int[] task5Index;
	private Generic[] task5Key;
	
	int reps;
	
	
	public DataSets() {
		reps = 10;
		int l = 10000;
		task1DataSets = new int[reps][];
		task1DataSetsSorted = new int[reps][];
		task1Median = new double[reps];
		for(int i = 0; i < task1DataSets.length; i++){
			task1DataSets[i] = randomIntsArr(l);
			int[] copy = new int[l];
			for(int j = 0; j < copy.length; j++){
				copy[j] = task1DataSets[i][j];
			}
			Arrays.sort(copy);
			task1DataSetsSorted[i] = copy; 
			task1Median[i] = median(copy);
		}
		
		task2DataSets = new String[reps][];
		task2DataSetsSorted = new String[reps][];
		task2Key = new String[reps];
		task2Index = new int[reps];
		for(int i = 0; i < task2DataSets.length; i++){
			task2DataSets[i] = randomStringArr(l, 5);
			String[] copy = new String[l];
			for(int j = 0; j < copy.length; j++){
				copy[j] = task2DataSets[i][j];
			}
			Arrays.sort(copy);
			task2DataSetsSorted[i] = copy; 
			task2Index[i] =(int)(Math.random() * task2DataSets.length);
			task2Key[i] = copy[task2Index[i]];
		}
		
		
		task3DataSets = new int[reps][];
		task3DataSetsSorted = new int[reps][];
		task3Median = new double[reps];
		for(int i = 0; i < task3DataSets.length; i++){
			task3DataSets[i] = randomIntsArr(l);
			Arrays.sort(task3DataSets);
			int[] copy = new int[l];
			for(int j = 0; j < copy.length; j++){
				copy[j] = task3DataSets[i][j];
			}
			task3DataSetsSorted[i] = copy;
			task3Median[i] = median(copy);
			unSort(task3DataSets[i]);
		}
		
		task4DataSets = new int[reps][][];
		task4DataSetsSorted  = new int[reps][][];//2D arrays
		task4Median = new double[reps];
		for(int i = 0; i < task4DataSets.length; i++){
			task4DataSets[i] = randomIntsArr1(l);
			int[][] copy = new int[l][l];
			double[] medians = new double[l];
			
			for(int j = 0; j < copy.length; j++){
				int[] rowCopy = new int[l];
				for(int k = 0; k < rowCopy.length; k++){
					rowCopy[k] = task4DataSets[i][j][k];
				}
				Arrays.sort(rowCopy);
				copy[j] = rowCopy;
				medians[0] = median(rowCopy);
			}
			task4Median[i] = median(medians);
			task4DataSetsSorted[i] = copy;
		}
		
		
		task5DataSets = new Generic[reps][];
		task5DataSetsSorted = new Generic[reps][];
		task5Index = new int[reps];
		task5Key = new Generic[reps];
		for(int i = 0; i < task5DataSets.length; i++){
			task5DataSets[i] = randomGeneric(l);
			Generic[] copy = new Generic[l];
			for(int j = 0; j < copy.length; j++){
				copy[j] = task5DataSets[i][j];
			}
			Arrays.sort(copy);
			task5DataSetsSorted[i] = copy;
			task5Index[i] = (int)(copy.length);
			task5Key[i] = copy[task5Index[i]];
		}
	}
	
	
	private static  double median(double[] sorted) {
		if (sorted.length % 2 == 0){
			return (sorted[sorted.length/2] + sorted[sorted.length/2])/2.0;
		}
		return sorted[sorted.length/2];
	}
	
	public int getTotalTrials(){
		return reps;
		
	}

	public int[] getTask1Data(int trial){
		return task1DataSets[trial];
	}
	
	public String[] getTask2Data(int trial){
		return task2DataSets[trial];
	}
	
	public String getTask2Key(int trial){
		return task2Key[trial];
	}
	
	public int[] getTask3Data(int trial){
		return task3DataSets[trial];
	}
	
	public int[][] getTask4Data(int trial){
		return task4DataSets[trial];
	}
	
	public Generic[] getTask5Data(int trial){
		return task5DataSets[trial];
	}
	
	public static int[] randomIntsArr(int num)
	{
		int [] arr = new int [num];
		while (num > 0)
		{
			num--;
			arr[num] = (int)(Math.random()*10000);
		}
		return arr;
	}
	
	public  int[][] randomIntsArr1(int num)
	{
		int [][] arr = new int[num][num];
		int i = 0;
		while (i < num)
		{
			arr[i] = randomIntsArr(num);
			i++;
		}
		return arr;
	}
	
	//removes any time that is 2 standard deviations from mean
//	
//	public double score(double[] times)
//	{
//		//Calculate standard deviation
//		double sum = 0;
//		double[] squareTimes = Arrays.copyOf(times, times.length);
//
//		double mean = average(times);
//		
//		sum = 0;
//		for (int i=0; i<times.length; i++)
//		{
//
//			sum += Math.pow((times[i] - mean),2.0); 
//			
//		}
//
//		double stdDev = Math.sqrt(sum/times.length);
//		
//		//remove outliers
//		for (int i = 0;i < times.length; i++)
//		{
//			if (times[i] > mean + (2*stdDev))
//			{
//				times[i] = mean;
//			}
//			if (times[i] < mean - (2*stdDev))
//			{
//				times[i] = mean;
//			}
//		}
//		sum  = average(times);
//		System.out.println("\nAverage Time: " + sum +" milliseconds");
//		return sum;
//
//	}
	
	public static double average(double[] times)
	{
		double sum = 0;
		for (double x : times)
		{
			sum += x;
		}
		return sum/times.length;
	}

	public static String[] randomStringArr(int num, int length)
	{
		
		String [] arr = new String [num];
		while (num > 0)
		{
			int i = 0;
			String s = "";
			while (i < length)
			{
				char c = (char)((Math.random()*26)+97);
				s = s + c;
				i++;
			}
			num--;
			arr[num] = s;
		}
		return arr;
	}
	
	public void checkTest1(Contestant c, int studentResponse[], int studentMedian, int trial)
	{
		int[] origArr = task1DataSetsSorted[trial];
		
		if (Arrays.equals(studentResponse,origArr))
		{
			System.out.print("Sorted");
		}

		else
		{
			System.out.print("Unsorted : (");
		}

		if (task1Median[trial] == studentMedian)
		{
			System.out.print(" Median Correct ");
		}

		else
		{
			System.out.print(" Median Not Correct ");
		}
		pause(1000);
		
	}
	public void checkTest2(String testArr[], String origArr[], int index, String Key)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\nSorted : )\n");
		}

		else
		{
			System.out.println("\nUnsorted : (\n");
		}

		if (Arrays.binarySearch(origArr, Key) == index)
		{
			System.out.println("\nIndex Correct : )\n");
		}

		else
		{
			System.out.println("\n Index Not Correct : (\n");
		}
		pause(1000);
	}
	public Generic[] randomGeneric(int x)
	{
		Generic[] arr = new Generic[x];
		
		for (int i = 0; i < x; i++)
		{
			arr[i] = new Generic();
		}
		return arr;
	}
	
	public void checkTest5(Generic testArr[], Generic origArr[], int index, Generic Key)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\nSorted : )\n");
		}

		else
		{
			System.out.println("\nUnsorted : (\n");
		}

		if (Arrays.binarySearch(origArr, Key) == index)
		{
			System.out.println("\nIndex Correct : )\n");
		}

		else
		{
			System.out.println("\n Index Not Correct : (\n");
		}
		pause(1000);
	}
	public void checkTest3(int testArr[], int origArr[], int median)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\nSorted : )\n");
			pause(100);
		}

		else
		{
			System.out.println("\nUnsorted : (\n");
			pause(100);
		}

		if (median(origArr) == median)
		{
			System.out.println("\nMedian Correct : )\n");
			pause(100);
		}
		else
		{
			System.out.println("\nMedian Not Correct : (\n");

		}
		pause(1000);
		
	}
	public void checkTest4(int[][] testArr, int [][] origArr, int median)
	{
		System.out.println("Checking Test Results");
		int [] medArr = new int[origArr.length];
		for (int i  = 0; i<origArr.length; i++)
		{
			medArr[i] = median(origArr[i]);
		}
		
		Arrays.sort(origArr, new Comparator<int[]>(){
			public int compare(int [] a, int [] b)
			{
				return median(a) - median(b);
			}
		});

		Arrays.sort(medArr);
		int temp = median(medArr);
		
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\n Sorted : )\n");
		}
		else
		{
			System.out.println("\n Unsorted : (\n");
		}
		pause(100);
		if (temp == median)
		{
			System.out.println("\nMedian Correct : )\n");
		}
		else
		{
			System.out.println("\nMedian Not Correct : (\n");
			pause(1000);
		}
		
	}
	public void unSort(int[]arr)
	{
		int percent = (int)(Math.random()*10);
		int count = (arr.length*percent)/100;
		
		while (count > 0)
		{
			int spot = (int)(Math.random()*arr.length);
			int swap = (int)(Math.random()*arr.length);
			int i = arr[spot];
			arr[spot] = arr[swap];
			arr[swap] = i;
			count--;
		}
		
	}
	public int median (int [] arr)
	{
		if (arr.length % 2 == 1) return arr[(arr.length/2)];
		
		return ((arr[(arr.length/2)-1] + arr[(arr.length/2)])/2);
	}
	
	public void pause(long ms)
	{
		try 
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
		}
	}
}
