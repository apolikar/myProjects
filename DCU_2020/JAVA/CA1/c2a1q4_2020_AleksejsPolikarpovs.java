import java.util.Scanner;

public class c2a1q4_2020_AleksejsPolikarpovs
{

    public static void main(String[] args)
    {

        System.out.println("1. A code must contain no spaces\n" +                                              // instructions for user
                "2. A code must have between 5 and 10 characters (inclusive)\n" +
                "3. A code must begin with \\ and must end with \\\n" +
                "4. A code must contain at least one lowercase letter and at least one uppercase letter.");


        validateCode();                                                                                        // calling method (was part of exercise) which will validate user input
    }

    public static void validateCode()                                                                          // nothing be returned, so we use void method
    {

        while (true)                                                                                           // create while loop
        {

            System.out.print("Please enter a code: ");                                                         // ask user for input
            Scanner scanner = new Scanner(System.in);                                                          // create scanner class
            String userInput = scanner.nextLine();                                                             // input be stored in userInput variable

            boolean isUpperCased = false;                                                                      // create boolean variable. Set to false. if we find uppercase letter in string it will be changed to true
            boolean isLowerCased = false;                                                                      // create boolean variable. Set to false. if we find lowercase letter in string it will be changed to true

            for (byte i = 0; i < userInput.length(); i++)                                                      // looping through input
            {
                char currentChar = userInput.charAt(i);                                                        // variable currentChar will store one character of input. and will change through loop
                if (Character.isUpperCase(currentChar))                                                        // if current character is uppercase
                {
                    isUpperCased = true;                                                                       // boolean isUpperCased will set to true
                }
                else if (Character.isLowerCase(currentChar))                                                   // if current character is lowercase
                {
                    isLowerCased = true;                                                                       // boolean isLowerCased will set to true
                }
            }

            if (userInput.contains(" "))                                                                       // check if input have spaces
            {
                System.out.println("Code must contain no spaces.\nCode is invalid. Please try again.");        // inform user
            }
            else if (userInput.length() < 5 || userInput.length() > 10)                                        // check if user input is out of range
            {
                System.out.print("Code must be between 5 and 10 characters in length.\n" +                     // inform user
                        "Code is invalid. Please try again.\n");
            }
            else if (userInput.charAt(0) != '\\')                                                              // check if user input starts with backslash
            {
                System.out.println("Code must start with \\\n" +                                               // if not inform user
                        "Code is invalid. Please try again.");
            }
            else if (userInput.charAt(userInput.length() - 1) != '\\')                                         // check if user input ends with backslash
            {
                System.out.println("Code must end with \\\n" +                                                 // if not inform user
                        "Code is invalid. Please try again.");
            }
            else if (!isUpperCased)                                                                            // check if at least one character is uppercase
            {
                System.out.println("Code must contain at least one uppercase letter.\n" +                      // if not inform user
                        "Code is invalid. Please try again.");
            }
            else if (!isLowerCased)                                                                            // check if at least one character is lowercase
            {
                System.out.println("Code must contain at least one lowercase letter.\n" +                      // if not inform user
                        "Code is invalid. Please try again.");
            }
            else                                                                                               // if all checks passed
                {
                System.out.println("Code is valid.");                                                          // inform user that input is valid
                break;                                                                                         // exit loop
                }                                                                                              // THANK YOU!!!
        }
    }
}
