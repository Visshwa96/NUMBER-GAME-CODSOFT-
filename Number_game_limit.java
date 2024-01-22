import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Number_game_limit extends JFrame {

    private int randomNumber;
    private JTextField guessField;
    private JLabel resultLabel;
    private int remainingGuesses;

    public Number_game_limit() {
        // Set up the frame
        setTitle("Number Guessing Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Initialize components
        initializeComponents();

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        // Set the maximum number of guesses
        remainingGuesses = 10;
        updateGuessLabel();
    }

    private void initializeComponents() {
        // Create layout manager
        setLayout(new FlowLayout());

        // Create components
        JLabel instructionLabel = new JLabel("Enter your guess (1-100):");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("Remaining Guesses: 10");

        // Add components to the frame
        add(instructionLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);

        // Add action listener to the button
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        try {
            // Get the user's guess
            int userGuess = Integer.parseInt(guessField.getText());

            // Check if the guess is correct
            if (userGuess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the number.");
                disableGuessing();
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Too low. Try again.");
            } else {
                resultLabel.setText("Too high. Try again.");
            }

            // Decrease the remaining guesses
            remainingGuesses--;

            // Update the remaining guesses label
            updateGuessLabel();

            // Check if the player has run out of guesses
            if (remainingGuesses == 0) {
                resultLabel.setText("Sorry, you've run out of guesses. The correct number was " + randomNumber + ".");
                disableGuessing();
            }

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    private void updateGuessLabel() {
        resultLabel.setText("Remaining Guesses: " + remainingGuesses);
    }

    private void disableGuessing() {
        guessField.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Number_game_limit().setVisible(true);
            }
        });
    }
}
