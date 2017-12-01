package nocklesHierarchies;


/**
 * 
 * The Hard Way Is Easier 
With the help of this book, you will do the incredibly simple things that all programmers
 do to learn a programming language: 1. Go through each exercise. 2. Type in each sample 
 exactly. 3. Make it run. That�s it. This will be very diffi cult at fi rst, but stick
  with it. If you go through this book and do each exercise for one or two hours a night,
   you will have a good foundation for moving on to another www.it-ebooks.info ptg11539604
    2 LEARN PYTHON THE HARD WAY book. You might not really learn �programming� from this 
    book, but you will learn the foundation skills you need to start learning the language.
     This book�s job is to teach you the three most essential skills that a beginning 
     programmer needs to know: reading and writing, attention to detail, and spotting 
     differences. 

Reading and Writing 
It seems stupidly obvious, but if you have a problem typing, you will have a problem 
learning to code. Especially if you have a problem typing the fairly odd characters in
 source code. Without this simple skill, you will be unable to learn even the most basic 
 things about how software works. Typing the code samples and getting them to run will 
 help you learn the names of the symbols, get you familiar with typing them, and get 
 you reading the language. 

Attention to Detail 
The one skill that separates bad programmers from good programmers is attention to detail.
 In fact, it�s what separates the good from the bad in any profession. Without paying 
 attention to the tiniest details of your work, you will miss key elements of what you 
 create. In programming, this is how you end up with bugs and diffi cult- to- use systems.
  By going through this book and copying each example exactly, you will be training your 
  brain to focus on the details of what you are doing, as you are doing it. 

Spotting Differences 
A very important skill�which most programmers develop over time� is the ability to visually
 notice differences between things. An experienced programmer can take two pieces of code 
 that are slightly different and immediately start pointing out the differences. Programmers
  have invented tools to make this even easier, but we won�t be using any of these. You
   first have to train your brain the hard way�then you can use the tools. While you do these 
   exercises, typing each one in, you will make mistakes. It�s inevitable; even seasoned 
   programmers make a few. Your job is to compare what you have written to what�s required 
   and fix all the differences. By doing so, you will train yourself to notice mistakes, 
   bugs, and other problems.

 * @author bnockles
 *
 *Sequence:
 *1. Environment
 *2. Trait
 *3. Animal
 *4. Habitat
 *5. Roaming Animal
 *5. Reproduction Animal
 *6. Wilderness
 *7. Active Animal
 *8. Predator
 *9. Prey
 *
 */
public class Environment {

	private int plants;
	private int growthRate;
	
	public static void main(String[] args) {
		Environment farm = new Environment(10);
		System.out.println(farm);
		farm.growPlants();
	}
	
	public Environment(int plants){
		this.plants = plants;
		this.growthRate = plants/2;
	}
	
	public void growPlants(){
		plants+= growthRate + 1.81*plants;
		System.out.println("\nThere are "+plants+" plants.");
	}


	public boolean eatPlants() {
		if(plants > 0){
			plants--;
			return true;
		}
		return false;
	}


	public String toString() {
		return "An vast field";
	}
}
