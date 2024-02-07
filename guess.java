package Guess;

import java.util.Random;
import java.util.Scanner;

public class guess {
    public static void main(String[] args) {
        Random rand=new Random();
        int guess,question,lives=3;
        System.out.println("Guess a number from 0-9.");
        question=rand.nextInt(10);
        Scanner scanner= new Scanner(System.in);
        while (lives!=0) {
            guess=scanner.nextInt();
                   if (guess==question) {
            System.out.println("You win.");
            System.out.println("Lives left: "+lives);
        } else if (guess>question) {
                System.out.println("Guess lower");
                lives--;
                System.out.println("Lives left: "+lives);
        } else{
                 System.out.println("Guess Higher");
                lives--;
                System.out.println("Lives left: "+lives);
        }
        }
        if (lives==0) {
            System.out.println("You loose.");
            System.out.println("Answer was:"+question);
        }
        scanner.close();
    }
}
