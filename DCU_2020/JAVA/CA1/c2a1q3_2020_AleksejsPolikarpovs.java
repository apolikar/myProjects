import java.util.Scanner;

public class c2a1q3_2020_AleksejsPolikarpovs
{

    public static void main(String[] args)
    {


        Scanner scanner = new Scanner(System.in);                                                               // create scanner class
        int userInput;                                                                                          // variable created to store user input.

        while (true)                                                                                            // while loop runs until we break
        {

            System.out.print("Enter an integer that is odd, in the range of 3 to 15 (inclusive): ");            // ask user for input

            if (scanner.hasNextInt())                                                                           // specify that input must be an integer
            {

                userInput = scanner.nextInt();                                                                  // assign input to userInput variable

                if ((userInput >= 3 && userInput <= 15) && userInput % 2 != 0)                                  // checking if input in our range and is odd
                {
                    break;                                                                                      // exiting loop
                }
                else                                                                                            // left only numbers which is out of range and even numbers only
                    {
                    System.out.println("Invalid entry, number must be in range, and must be odd.");             // inform user about wrong input
                    scanner.nextLine();                                                                         // handle next line.
                    }
            }
            else                                                                                                // if number entered is not an integer
            {
                System.out.println("Invalid entry, number must be an integer.");                                // inform user about wrong input
                scanner.nextLine();                                                                             // handle next line
            }
        }

        String emptySymbol = " ";                                                                               // assign empty character to emptySymbol variable
        final int middleRow = userInput / 2 + 1;                                                                // here we find a middle row (integer division!!! for example 9 / 2 = 4, 4 + 1 = 5)
        int spaceBetweenChar = -1;                                                                              // space between @ symbols. each row will increase value by 2. when we run for loop first and last iteration dont need empty space.
                                                                                                                // but second iteration will need one empty space between @ symbol. ( -1 + 2 = 1 output: @ @). third iteration (1 + 2 = 3 output @   @) ....
        for (int i = 1; i <= userInput; i++)                                                                    // loop number of times (user input)
        {
            if (i == 1)                                                                                         // first iteration
            {
                System.out.println(emptySymbol.repeat(middleRow - i) + "@");                                    // print empty symbol (MIDDLE ROW - I  !!!) than @ symbol
            }
            else if (i > 1 && i <= middleRow)                                                                   // iterate till middle row included (will print middle line as well)
            {
                spaceBetweenChar += 2;                                                                          // adding two empty symbols between @ every iteration
                System.out.println(emptySymbol.repeat(middleRow - i) + "@" +                                    // printing empty symbols + @ + amount empty symbol + @
                                         emptySymbol.repeat(spaceBetweenChar) + "@");
            }
            else if (i < userInput)                                                                             // will print rest after middle line.
            {
                spaceBetweenChar -= 2;                                                                          // empty spaces between @ symbols will be decreased by 2
                System.out.println(emptySymbol.repeat(i - middleRow) + "@" +                                    // print same as in previous steps, but here we reverse (I - MIDDLE ROW !!!)
                                         emptySymbol.repeat(spaceBetweenChar) + "@");
            }
            else                                                                                                // print last iteration of loop. will be same as first iteration
            {
                System.out.println(emptySymbol.repeat(i - middleRow) + "@");
            }
        }
    }
}





