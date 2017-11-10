package levinHierarchies;

public class ArrayIteration {
	
	public static void main(String[] args)
	{
		int[] numbers  = new int[10];
		
		String[] words = {"apple", "foo", "elimu ni nguvu", "Newman", "ABC", "GoTech"};
		

		
		
		printArray(words);
		
		System.out.println(sumNumbers(numbers)); // why does this print 0?
		
		for (int i = 0; i< numbers.length; i++)
		{
			numbers[i] = (int)(Math.random() * 10); //How would you change this code to give random numbers from 1 - 10?
		}
		
//		System.out.println(sumNumbers(numbers)); //Is this answer correct? Can you print out the array to verify?
		
		
	}
	
	public static void printArray(String[] words)
	{
		//How does the loop below work?
		for (String word : words)
		{
			System.out.println(word);
		}
	}
	
	public static int sumNumbers(int[] numbers)
	{
		int total = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			total = total + numbers[i];
		}
		return total;
	}
}
