package nocklesHierarchies;

public class RoamingAnimal extends Animal {

	protected Habitat habitat;
	private boolean sex;
	
	public RoamingAnimal(Habitat matingArea) {
		super();
		this.habitat = matingArea;
		sex = Math.random() > .5;
	}

	public RoamingAnimal(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(description, trait1, trait2);
		this.habitat = matingArea;
		sex = Math.random() > .5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean getSex() {
		return sex;
	}
	
	public void mate(){
		System.out.println(this +" does not have a mating ritual.");
	}
	
	public void act(){

		increaseAge();
		if(getAge() > 5 || !habitat.eatPlantFood()){
			habitat.removeAnimal(this);;
		}else{
			if(!mated){
				mate();
			}
		}
	}

}
