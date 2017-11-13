package levinHierarchies;

public class BinarySearch {
	
	
	public static void main (String[] args)
	{
		int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] test2 = {0, 4, 5, 6, 12, 15, 17, 23, 29};
		
		System.out.println(binSearch(test1, 3)); //2
		System.out.println(linSearch(test1, 3)); //2
		
		System.out.println(binSearch(test2, 23)); //7
		System.out.println(linSearch(test2, 23)); //7
		
		System.out.println(binSearch(test2, 25)); //-1
		System.out.println(linSearch(test2, 25)); //-1
		
		System.out.println(binSearch(test1, 10)); //9
		System.out.println(linSearch(test1, 1)); //0
		
		System.out.println(binSearch(test1, 1)); // 0
	}
	
	
	
	
	
	//returns the position of num in arr, or -1 if not found
	//pre-condition arr is an array of integers in ascending order
	public static int binSearch(int[] arr, int num)
	{
		int first = 0;
		int last = arr.length - 1;
		
		while(first <= last)
		{
			int mid = (first + last)/2;
			
			int guess = arr[mid];
			
			if  (guess == num)
			{
				return mid;
			}
			
			if (guess > num)
			{
				last  = mid - 1;
			}
			
			if (guess < num)
			{
				first = mid + 1;
			}
		}
		return -1;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int linSearch(int [] arr, int num)
	{
		for(int x = 0; x<arr.length; x++)
		{
			if (arr[x] == num)
			{
				return x;
			}
			
		}
		return -1;
	}

}
