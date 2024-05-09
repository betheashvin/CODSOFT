package Task1;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


    public class Main {
        public static void main(String[] args) {
            Random rnum = new Random();
            // #1
            int num = rnum.nextInt(10) + 1;

            Scanner scan = new Scanner(System.in);
            int score = 0;
            String res = "y";
            boolean found = false;
            while (Objects.equals(res, "y")) {
                System.out.println("Dear user, you have ten attempts to guess the number.");

                for (int i = 0; i < 10; i++) {
                    System.out.println("Guess the number: ");
                    int guess = scan.nextInt();

                    if (guess > num)
                        System.out.println("The guess number is more than the actual number.");

                    else if (guess < num)
                        System.out.println("The guess number is less than the actual number.");
                    else {
                        System.out.println("The guess number is correct");
                        found = true;
                        System.out.println("The score is " + (++score) + ".");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Dear user, you have lost the game.");
                    System.out.println("The score is " + (score) + ".");
                }
                System.out.println("Do you wish to play the game again : y OR n ? ");
                found=false;
                scan.nextLine();
                res = scan.nextLine();
            }
        }
    }



