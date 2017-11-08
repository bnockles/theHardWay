package nocklesHierarchies;

public class Habitat extends Environment {

	private Animal[] animals;
	private int plantFood;
	private int growthRate;
	
	public static void main(String[] args) {
		Habitat h = new Habitat(5);
		int count = 0;
		while(count < 6){
			Animal a = new Animal();
			h.addAnimal(a);
			count++;
		}
		System.out.println(h);
	}


	public Habitat(int livingCapacity) {
		plantFood = livingCapacity;
		growthRate = plantFood/2;
		animals = new Animal[livingCapacity];
	}

	public String toString() {
		String s = super.toString()+"\nHabitants:\n"+animalReport();;
		return s;
	}
	
	public String animalReport(){
		String s = "";
		for(Animal a: animals) {
			s += a+"\n";
		}
		return s;
	}
	
	public Animal[] getAnimals(){
		return animals;
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
	}
	
	public void growPlants(){
		plantFood+= growthRate;
		System.out.println("\nThere is enough plant food for "+plantFood+" herbivores.");
	}


	public void removeAnimal(int i) {
		animals[i] = null;
	}
	
	public void removeAnimal(Animal a) {
		for(int i = 0; i < animals.length; i++){
			if (animals[i] == a)animals[i] = null;
		}
	}


	public boolean eatPlantFood() {
		if(plantFood > 0){
			plantFood--;
			return true;
		}
		return false;
	}


}
