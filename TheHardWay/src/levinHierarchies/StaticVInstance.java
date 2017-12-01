package levinHierarchies;

public class StaticVInstance {

	private int myNumber;
	private static String s = "The Universal String";
	
	public static void main(String[] args)
	{
		System.out.println(myNumber);
		System.out.println(s);
		
		StaticVInstance instance = new StaticVInstance(5);
		System.out.println(instance.myNumber);
		
	}
	public StaticVInstance(int myNumber) {
		this.myNumber = myNumber;
		
	}

}
