package nocklesHierarchies;

public class ReproductionAnimal extends RoamingAnimal {



	public static void main(String[] args) {
		Habitat h = new Habitat(3);
		ReproductionAnimal animal1 = new ReproductionAnimal(h);
		ReproductionAnimal animal2 = new ReproductionAnimal(h);
		ReproductionAnimal youngAnimal = animal1.getOffspring(animal2);
		while(youngAnimal == null) {
			animal2 = new ReproductionAnimal(h);
			youngAnimal = animal1.getOffspring(animal2);
		}
		System.out.println(animal1 + " and a\n" + animal2);
		System.out.println("had a baby and it was a\n"+youngAnimal);
	}

	public ReproductionAnimal(Habitat matingArea) {
		super(matingArea);

	}

	public ReproductionAnimal(Habitat matingArea, String description, Trait trait1, Trait trait2){
		super(matingArea, description, trait1, trait2);
	}



	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		if(getDescription().equals(mate.getDescription()) && mate.getSex() != getSex()){
			ReproductionAnimal baby = new ReproductionAnimal(habitat, getDescription(), 
					Trait.getDominantTrait(getTrait1(), mate.getTrait1()),
					Trait.getDominantTrait(getTrait2(), mate.getTrait2()));
			this.mated = true;
			mate.mated = true;
			return baby;
		}
		return null;
	}



	public void mate(){

		int i = 0;
		while(i < habitat.getAnimals().length){
			Animal target = habitat.getAnimals()[i];
			if(target instanceof ReproductionAnimal && target.getDescription().equals(getDescription())){
				Animal baby = getOffspring((ReproductionAnimal)target);
				if(baby != null){//SPECIAL NOTE: For code to compile, you must create a 'Prey' class. It will be written in the next activity.
					habitat.addAnimal(baby);
					break;
				}
			}
			i++;
		}

	}



}
