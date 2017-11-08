package nocklesHierarchies;

public class Predator extends ReproductionAnimal {

	
//	private Habitat matingArea;
	
	public Predator(Habitat matingArea){
		super(matingArea);
	}
	
	
	public Predator(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(matingArea, description, trait1, trait2);
	}

	public static final String[] PREDATORS = {"wolf","bear","lion","bobcat"};
	

	
	public String getName(){
		return PREDATORS[(int)(Math.random()* PREDATORS.length)];
	}

	public static void main(String[] args) {
		Wilderness wilderness = new Wilderness("A Wooded Area",10);
		Predator p = new Predator(wilderness);
		wilderness.addAnimal(p);
		wilderness.simulate(2);
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		if(getDescription().equals(mate.getDescription()) && mate.getSex() != getSex()){
			Predator baby = new Predator(habitat, getDescription(), 
					Trait.getDominantTrait(getTrait1(), mate.getTrait1()),
					Trait.getDominantTrait(getTrait2(), mate.getTrait2()));
			this.mated = true;
			mate.mated = true;
			return baby;
		}
		return null;
	}
	
	public void act(){
		int i = 0;
		while(i < habitat.getAnimals().length){
			Animal target = habitat.getAnimals()[i];
			if(target instanceof Prey){//SPECIAL NOTE: For code to compile, you must create a 'Prey' class. It will be written in the next activity.
				habitat.removeAnimal(i);
				System.err.println(this + " ate a "+target);
				
				break;
			}
			i++;
		}
		
		if(i == habitat.getAnimals().length){
			System.err.println(this +"died of starvation");
			habitat.removeAnimal(this);
		}
		else if(age > 5){
			System.err.println(this +"died of old age");
			habitat.removeAnimal(this);
		}else{
			increaseAge();
			if(!mated) mate();
		}
	}

}
