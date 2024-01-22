//importing modules
import javax.swing.*;
import java.lang.Math;

import static java.lang.Integer.parseInt;

public class Number_game extends JFrame{
    static int computer_guess;
    int user_guess;
     int count1;
    JLabel result1 = new JLabel();
    JTextField t1 = new JTextField(10);
    JLabel count_number = new JLabel("Remaining Guesses:5");
        Number_game(){
            count1 = 5;

            JLabel lb2 = new JLabel("Enter Your Guess:");


                JButton but1 = new JButton("Guess");
                but1.addActionListener(e -> {
                    try {
                        guess_function();
                    }catch(NumberFormatException e1){
                        System.out.println("Invalid Input enter correct number");
                    }

                });
            //intializing the gui window
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Number Game");
        setLayout(null);
        result1.setBounds(80,100,200,40);
        but1.setBounds(85,60,100,30);
        lb2.setSize(120,40);
        lb2.setHorizontalAlignment(SwingConstants.CENTER);
        lb2.setVerticalAlignment(SwingConstants.CENTER);
        setLocationRelativeTo(null);
        t1.setBounds(130,10,75,20);
        count_number.setBounds(50,35,150,20);

        add(result1);
        add(t1);
        add(but1);
        add(lb2);
        add(count_number);


    } // constructor to define GUI
    void guess_function() {
        user_guess = parseInt(t1.getText());
            if (user_guess > computer_guess) {
                result1.setText("Too High.Try Again");
            } else if (user_guess < computer_guess) {
                result1.setText("Too Low.Try Again");
            } else {
                result1.setText("Congrats Guessed the Number");
                disableTextField();
            }
            count1-=1;
            if(count1 == 0){
                count_number.setText("Sorry Failed to guess");
                disableTextField();
            }
            updateCountLabel();
        }
        void updateCountLabel(){
            count_number.setText("Remaining Guessed:"+count1);
        }
        void disableTextField(){
            t1.setEnabled(false);
        }

    public static void main(String[] args){
        //Execution of GUI APPLICATION
        new Number_game();
        final int MAX = 10;
        final int MIN = 1;

        computer_guess = (int) (Math.random() * (MAX - MIN + 1) + MIN);
    }
}
