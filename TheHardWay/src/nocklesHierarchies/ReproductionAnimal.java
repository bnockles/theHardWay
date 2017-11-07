package nocklesHierarchies;

public class ReproductionAnimal extends Animal {

	private boolean male;
	
	public ReproductionAnimal() {
		super();
		male = Math.random() > .5;
	}

	public static void main(String[] args) {
		ReproductionAnimal animal1 = new ReproductionAnimal();
		ReproductionAnimal animal2 = new ReproductionAnimal();
		ReproductionAnimal youngAnimal = animal1.getOffSpring(animal2);
		while(youngAnimal == null) {
			animal2 = new ReproductionAnimal();
			youngAnimal = animal1.getOffSpring(animal2);
		}
		System.out.println(animal1);
		System.out.println(animal2);
		System.out.println(youngAnimal);
	}
	
	public ReproductionAnimal getOffSpring(ReproductionAnimal mate) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
