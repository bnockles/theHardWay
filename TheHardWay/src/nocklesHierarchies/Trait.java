package nocklesHierarchies;

public class Trait {

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
	
	private String description;
	private int index;
	
	
	public static final void main(String[] args){
		Trait longTailed = new Trait(1);
		Trait shortTailed = new Trait(6);
		System.out.println(longTailed+" and "+shortTailed+" are the same trait: "+longTailed.equals(shortTailed));
	}
	
	public Trait() {
		index = (int)(Math.random()*traits.length);
		description = traits[index];
	}
	
	public Trait(int index) {
		this.index = index;
		description = traits[index];
	}
	
	public String toString(){
		return description;
	}
	
	private int getIndex(){
		return index;
	}
	
	public boolean equals(Object o){
		
		return (o instanceof Trait) && (this.getIndex() - ((Trait)o).getIndex()) % (traits.length/2) == 0;
	}
	
	public static Trait getDominantTrait(Trait t1, Trait t2){
		if(t1.getIndex()<t2.getIndex())return t1;
		return t2;
	}
	
}

/**
 *QUESTIONS:
 *(Questions do not need to be copied, but after you finish, you can prepare your responses for discussion:
 *This class overrides the "equals" method. The way it overrides it is unexpected. What determines
 *whether or not two traits are "equal"? 
*/