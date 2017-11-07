package nocklesHierarchies;

public class Habitat extends Environment {

	private Animal[] animals;
	
	public static void main(String[] args) {
		Habitat h = new Habitat(10);
		Animal first = new Animal();
		h.addAnimal(first);
		h.printStatus();
	}


	public Habitat(int livingCapacity) {
		animals = new Animal[livingCapacity];
	}

	public void printStatus() {
		System.out.println("Habitants:");
		for(Animal a: animals) {
			System.out.println(a);
		}
	}

	
	public void addAnimal(Animal animal) {
		int i = 0;
		while(i < animals.length) {
			if(animals[i] == null) {
				animals[i] = animal;
				break;
			}
			i++;
		}
		if(i == animals.length) {
			System.out.println("The habitat has reached its maximum capacity.");
		}
	}


}
