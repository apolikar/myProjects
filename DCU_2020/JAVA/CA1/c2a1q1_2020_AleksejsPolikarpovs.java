import java.util.Scanner;

    // Hi Ronan. I hope you well.
    // I tried to make my code easy to read for you and indent blocks as you prefer.
    // Honestly I used to different indentation from my previous experience. So I need to reedit my code after i finish.
    // So hopefully I did it right.
    // If you have any questions please contact me at alekseis.polikarpovs2@mail.dcu.ie.
    // Thank you!!!
    // Kind regards Aleksejs Polikarpovs

public class c2a1q1_2020_AleksejsPolikarpovs
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);                                                      // create scanner class

        while (true)                                                                                   // while loop will run until we break at right condition
        {

            System.out.print("Enter an integer between 1,000 and 999,999 : ");                         // ask user for input.
            String userInput = scanner.nextLine();                                                     // input will be declared to string userInput variable

            int userIntInput = 0;                                                                      // here we will store integer value of userInput, if it is possible to parse String ot int

            try                                                                                        // here we try to ->
            {
                userIntInput = Integer.parseInt(userInput.replace(",", ""));                           // -> parse user input to int. We replace comma with empty string symbol
            }
            catch (NumberFormatException ignored)                                                      // we ignore if any number format exception occur
            {
            }
            if (!userInput.contains(","))                                                              // here we check for user input if there is no any comma
            {
                if (userIntInput < 1_000)                                                              // all user input below 1_000 shouldn't have comma separation
                {
                    System.out.println("Invalid input");                                               // and because this input out of our range we inform about invalid input
                    continue;                                                                          // restart loop
                }
                System.out.println("Invalid input. Integers greater than 999 only accepted " +         // otherwise integer should have comma.
                        "with coma, to separate thousands from hundreds");
                continue;                                                                              // restart loop
            }
            if (userInput.contains(","))                                                               // check condition if input contain comma or comma's.
            {                                                                                          // Because user might have wrong comma separation we need to check where comma or commas located
                char comma = ',';
                int commaCount = 0;                                                                    // variable created to count how many commas we have in input
                for (int i = 0; i < userInput.length(); i++)                                           // looping through input ->
                {
                    if (userInput.charAt(i) == comma)                                                  // -> to see if every character is comma ->
                    {
                        commaCount++;                                                                  //  -> if comma found than commaCount increased each time by one
                    }
                }
                if (commaCount == 1)                                                                   // in our range user might have only one comma so we ->
                {
                    if (userInput.length() == 5 && userInput.charAt(1) != comma)                       // -> checking if right comma separation was made in range 1,000 - 9,999
                    {
                        System.out.println("Invalid input. Wrong comma separation. Please try again.");// let user know that comma separation was wrong
                        continue;                                                                      // restart loop
                    }
                    if (userInput.length() == 6 && userInput.charAt(2) != comma)                       // same but range is 10,000 - 99,999
                    {
                        System.out.println("Invalid input. Wrong comma separation. Please try again.");
                        continue;
                    }
                    if (userInput.length() == 7 && userInput.charAt(3) != comma)                       // same but range is 100,000 - 999,999
                    {
                        System.out.println("Invalid input. Wrong comma separation. Please try again.");
                        continue;
                    }
                }
                if (commaCount > 1)                                                                    // we cant have more than 1 comma in range 1,000 to 999,999
                {
                    System.out.println("Invalid input. Too many commas (maximum number 999,999 " +     // let user know about too many commas
                            "might have only one comma).");
                    continue;
                }
                if (userIntInput >= 1_000 && userIntInput <= 999_999)                                  // checking if input in our range
                {
                    System.out.println("The number entered (without comma) is : " + userIntInput);
                    scanner.close();                                                                   // closing scanner
                    break;                                                                             // exiting while loop
                }
                System.out.println("Invalid input " + userIntInput);                                   // if input not in our range, we let know that input is invalid
            }
        }
    }
}