import java.util.Scanner;

public class c2a1q2_2020_AleksejsPolikarpovs
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);                                          // create scanner for user input

        int winTrack = 0;                                                                  // variable to store the right guess amount. Every right guess will be increased by one
        int gamesPlayed = 0;                                                               // variable to track games played. It will be increased by one if input is integer in a right range

        while (true)                                                                       // while loop created. We can exit loop when gamesPlayed is 5
        {
            if (gamesPlayed == 5)                                                          // if gamesPlayed is 5
            {
                System.out.println("\nYou got " + winTrack + " right out of 5");           // show the total number of correct guesses
                scanner.close();                                                           // close scanner
                break;                                                                     // exiting loop
            }

            int dieToss = (int) Math.floor(Math.random() * 6 + 1);                         // simulating die toss random number (range 1 to 6)
            System.out.print("Guess the next dice throw (1-6): ");                         // asking for user input.

            if (scanner.hasNextInt())                                                      // specify that input must be an integer
            {
                int userInput = scanner.nextInt();                                         // user input will be stored in userInput variable
                if (userInput <= 0 || userInput >= 7) {                                    // checking if user input is in range
                    System.out.println("Number must be between 1 and 6 " +                 // inform user that input is not in range
                            "inclusive, please try again.");
                    scanner.nextLine();                                                    // handle next line
                }
                else if (userInput == dieToss)                                             // if number entered exactly the same as die toss
                {
                    System.out.println("Congratulations, you guessed right!");             // inform user that guess is right
                    scanner.nextLine();                                                    // handle next line
                    winTrack++;                                                            // increase the right guess amount by one
                    gamesPlayed++;                                                         // increase amount of games played by one
                }
                else                                                                       // if input in range and guess is not right
                {
                    System.out.println("Hard luck, last throw was " + dieToss);            // inform user that guess is not right and show him what right guess
                    scanner.nextLine();                                                    // handle next line
                    gamesPlayed++;                                                         // increase amount of games played by one
                }
            }
            else
                {                                                                          // if input not an integer
                System.out.println("Number must be an integer, please try again");         // inform that input should be an integer
                scanner.nextLine();                                                        // handle next line
                }
        }
    }
}
