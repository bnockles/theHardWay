package nocklesHierarchies;

public class Animal {

	private String description;

	
	public static final String[] traits = {
			"striped",
			"long-tailed",
			"furry",
			"brown",
			"short-eared",
			
			"spotted",
			"short-tailed",
			"hairless",
			"white",
			"long-eared"}; 
	
	public static void main(String[] args) {

		for(int i = 0; i < 10; i++) {
			Animal someAnimal = new Animal();
			System.out.println(someAnimal);
		}
	}
	
	public Animal() {
		description = "a "+createTraits()+" animal";
	}

	private String createTraits() {
		int trait1 = (int)(Math.random()*traits.length);
		int trait2 = (int)(Math.random()*traits.length);
		while(Math.abs(trait1 - trait2)%traits.length == 0) {
			trait2 = (int)(Math.random()*traits.length);
		}
		return traits[trait1]+", "+traits[trait2];
	}

	public String toString() {
		return getClass()+": " + description;
	}


	

}
