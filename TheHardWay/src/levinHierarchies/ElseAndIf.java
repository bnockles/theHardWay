package levinHierarchies;

public class ElseAndIf {
	
	/*
	 * Type this code into your own project. Try running the code. Does it do what you expected?
	 */
	public static void main (String[] args)
	{
		int people = 30;
		int cars = 40;
		int buses = 15;
		
		if (cars > people)
		{
			System.out.println( "We should take the cars.");
		}
		//Do we need the else in this else if statement? What happens if we remove it?
		//Try it and re-run the code, add a comment here with your results.
		else if (cars < people)
		{
			System.out.println("We should not take the cars.");
		}
		else
		{
			System.out.println("We can't decide.");
		}
		
		if ( buses > cars)
		{
			System.out.println("That's too many buses.");
		}
		else if (buses < cars)
		{
			System.out.println("Maybe we could take the buses");
		}
		else {
			System.out.println("We still can't decide.");
		}
		
		if (people > buses)
		{
			System.out.println("All right, let's just take the buses.");
		}
		else
		{
			System.out.println("Fine, let's stay home then.");
		}
			
	}

}
