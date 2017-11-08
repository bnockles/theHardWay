package nocklesHierarchies;

public class Prey extends ReproductionAnimal {


	public static final String[] PREY = {"bunny"};

	public static void main(String[] args) {
		Wilderness wilderness = new Wilderness("A Wooded Area",20);
		Predator predator1 = new Predator(wilderness,"wolf",new Trait(),new Trait());
		Predator predator2 = new Predator(wilderness,"wolf",new Trait(),new Trait());
		Prey prey1 = new Prey(wilderness);
		Prey prey2 = new Prey(wilderness);
		Prey prey3 = new Prey(wilderness);
		Prey prey4 = new Prey(wilderness);
		wilderness.addAnimal(prey1);
		wilderness.addAnimal(prey2);
		wilderness.addAnimal(prey3);
		wilderness.addAnimal(prey4);
		wilderness.addAnimal(predator1);
		wilderness.addAnimal(predator2);
		wilderness.simulate(10);
	}

	public Prey(Habitat matingArea) {
		super(matingArea);
	}

	public Prey(Habitat habitat, String description, Trait dominantTrait, Trait dominantTrait2) {
		super(habitat,description,dominantTrait,dominantTrait2);
	}

	public String getName(){
		return PREY[(int)(Math.random()* PREY.length)];
	}

	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		if(getDescription().equals(mate.getDescription()) && mate.getSex() != getSex()){
			Prey baby = new Prey(habitat, getDescription(), 
					Trait.getDominantTrait(getTrait1(), mate.getTrait1()),
					Trait.getDominantTrait(getTrait2(), mate.getTrait2()));
			this.mated = true;
			mate.mated = true;
			return baby;
		}
		return null;
	}
	






}
