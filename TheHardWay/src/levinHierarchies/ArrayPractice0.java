package levinHierarchies;

public class ArrayPractice0 {

	public static void main (String[] args) //Check out the parameter to main, it's an array!
	{
		int [] unInitialized; 
		//this is like a placeholder for an array
		
		double [] declaredButUninitialized = new double[10]; 
		//This creates empty spaces for 10 doubles
		
		String [] Initialized = {"bacon", "donut", "coffee"};
		//This creates an array of strings, and sets the values.
		
		//Predict what will be printed by each of the lines below. 
		print("Item 2 of Unitialized " + declaredButUninitialized[2] + " ");
		print ("Item 2 of Initialized: " + Initialized[2]);
		print(Initialized.length+"");
		
		
		
	}
	
	//This is a helper method because I got tired of typing System.out.println()
	public static void print(String word)
	{
		System.out.println(word);
	}
}
