import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private int theNumber;
	private int numOfTries = 0;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			numOfTries++;
			if (guess < theNumber) {
				message = guess + " is too low. Try again.";
			} else if (guess > theNumber) {
				message = guess + " is too high. Try again.";
			} else {
				message = guess + " is correct. You win after " + numOfTries + " tries! Let's play again!";
				btnPlayAgain.setVisible(true);
//				newGame();
			} 
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
	}

	public GuessingGame() {
		setTitle("Yashwanth's Hi-Lo Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel label_2 = new JLabel("Guess a number between 1 and 100:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 104, 207, 13);
		getContentPane().add(label_2);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(243, 102, 96, 19);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuess.setBounds(111, 162, 96, 32);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.LEFT);
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput.setBounds(98, 210, 317, 13);
		getContentPane().add(lblOutput);

		JLabel label_1 = new JLabel("Yashwanth's Hi-Lo Guessing Game");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(42, 36, 338, 32);
		getContentPane().add(label_1);
		
		btnPlayAgain = new JButton("Play Again!");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnPlayAgain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPlayAgain.setBounds(240, 162, 124, 32);
		getContentPane().add(btnPlayAgain);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
	}
}
