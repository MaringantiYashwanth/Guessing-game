import java.util.Scanner;

public class Madlibs {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a color: ");
			String color = sc.nextLine();
			System.out.println("Enter a past tense verb: ");
			String pastTenseVerb = sc.nextLine();
			System.out.println("Enter an adjective: ");
			String adjective = sc.nextLine();
			System.out.println("Enter a noun: ");
			String noun = sc.nextLine();
			
			
			System.out.println("The " + color + " dragon " + pastTenseVerb + " at the " + adjective);
			System.out.println(" knight, who rode in on a sturdy, giant" + noun + ".");
			
		}
	}
}
