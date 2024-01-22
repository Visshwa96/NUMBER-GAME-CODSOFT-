import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Number_game1 extends JFrame {

    private int randomNumber;
    private JTextField guessField;
    private JLabel resultLabel;

    public Number_game1() {
        // Set up the frame
        setTitle("Number Guessing Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Initialize components
        initializeComponents();

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;
    }

    private void initializeComponents() {
        // Create layout manager
        setLayout(new FlowLayout());

        // Create components
        JLabel instructionLabel = new JLabel("Enter your guess (1-100):");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

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
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Too low. Try again.");
            } else {
                resultLabel.setText("Too high. Try again.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Number_game1().setVisible(true);
            }
        });
    }
}
