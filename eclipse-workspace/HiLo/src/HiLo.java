import java.util.Scanner;
import javax.swing.*;

public class HiLo {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int numberOfTries = 0;
			String playAgain = "";
			JFrame window = new JFrame("Bryson's Window");
			JPanel panel = new JPanel();
			JButton button = new JButton("Click me!");
			panel.add(button);
			window.add(panel);
			window.setSize(300, 100);
			button.addActionListener(e -> System.out.println("Ouch! You clicked me!"));
			window.setVisible(true);
			do {
				// Create a random number for the user to guess
				int theNumber = (int) (Math.random() * 200 + 1);
				theNumber -= 100;
				int guess = 0;
				System.out.println("Guess a number between -100 and 100:");
				while (guess != theNumber) {
					guess = sc.nextInt();
					if (guess < theNumber) {
						System.out.println(guess + " is too low. Try again.");
					} else if (guess > theNumber) {
						System.out.println(guess + " is too high. Try again.");
					} else {
						System.out.println(guess + " is correct. You win!");
					}
				} // End of while loop for guessing
				System.out.println("Would you like to play again(y/n)?");
				playAgain = sc.next();
				numberOfTries++;
			} while (playAgain.equalsIgnoreCase("y"));
			System.out.println("You took " + numberOfTries + " tries.");
		}
		
		System.out.println("Thank you for playing! GoodBye.");
	}

}
