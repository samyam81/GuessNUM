package Guess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class guessnum implements ActionListener{
    public static void main(String[] args) {
        new guessnum();
    }

    JFrame frame;
    JTextField textfield1,textField2,textField3;
    JButton[] numButtons=new JButton[10];  
    JPanel panel;

    Font myFont=new Font("Serif",Font.BOLD,30);
    int question,guess,lives=3;
    Random mama=new Random();

    guessnum(){
        frame =new JFrame("Guess-The-Num");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(192,192,192));
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield1=new JTextField();
        textfield1.setBounds(49,27,291,49);
        textfield1.setFont(myFont);
        textfield1.setText("Guess the num");
        
        textfield1.setEditable(false);

        for (int i = 0; i < 10; i++) {
                numButtons[i]=new JButton(String.valueOf(i));
                numButtons[i].addActionListener(this);
                numButtons[i].setFont(myFont);
                numButtons[i].setFocusable(false);
        }

        panel=new JPanel();
        panel.setBounds(49,99,299,299);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(new Color(255,215,0));

        panel.add(numButtons[0]);
        panel.add(numButtons[3]);
        panel.add(numButtons[8]);

        panel.add(numButtons[2]);
        panel.add(numButtons[7]);
        panel.add(numButtons[9]);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);

        panel.add(new JLabel(""));
        panel.add(numButtons[1]);

        textField2=new JTextField();
        textField2.setBounds(206,421,142,49);
        textField2.setFont(myFont);
        textField2.setText("Live="+String.valueOf(lives));
        textField2.setEditable(false);

        textField3=new JTextField();
        textField3.setBounds(50,421,142,49);
        textField3.setFont(myFont);
        textField3.setEditable(false);


        frame.add(panel);
        frame.add(textfield1);
        frame.add(textField2);
        frame.add(textField3);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    int question = mama.nextInt(10);
    textfield1.setText(" _");

    for (int i = 0; i < numButtons.length; i++) {
        if (e.getSource() == numButtons[i]) {
            String buttonText = numButtons[i].getText();
            guess = Integer.parseInt(buttonText);

            if (question == guess) {
                textField3.setText("Correct");
                textfield1.setText("You win!!");

                for (int j = 0; j < numButtons.length; j++) {
                    numButtons[j].setEnabled(false);
                    numButtons[j].setBackground(Color.PINK);
                }
            } else if (question > guess) {
                textField3.setText("Higher");
                lives -= 1;
                textField2.setText(String.valueOf(lives));
            } else {
                textField3.setText("Lower");
                lives -= 1;
                textField2.setText(String.valueOf(lives));
            }
        }
    }

    if (lives == 0) {
        textfield1.setText("Answer: " + String.valueOf(question));
        textField3.setText("You lose.");
        textField2.setText("GAME 0VER.");
        
        for (int j = 0; j < numButtons.length; j++) {
            numButtons[j].setEnabled(false);
            numButtons[j].setBackground(Color.darkGray);
        }
    }
}
}

