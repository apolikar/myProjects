
import java.util.Scanner;

/*
Hi Ronan. I hope you well.
Here is the solution to my Assignment 2. Compare to Assignment 1 my code has more lines and
comments get larger. I tried to make the code as clean as possible (DRY not WET).
Let me know if I go to deep with a commenting in my code please.
Hopefully I did well.
Looking forward to your feedback.
Thank you.
*/


public class c2a2q1_2021_AleksejsPolikarpovs {
    public static void main(String[] args) {

        final String[] RAINBOW_COLOURS = {"red", "orange", "yellow", "green", "indigo", "violet", "blue"};   // array of all rainbow colours. Rainbow has never changing colours so we can make it final
        String[] modifiedArray = new String[RAINBOW_COLOURS.length];                                         // declare empty array same length as rainbow array. We will use it to store colours after we randomize colour sequence
        boolean validInput = false;                                                                          // boolean for input validation. Set to false

        while(!validInput){                                                                                  // while loop will be executed till valid input is correct
            randomizeArray(RAINBOW_COLOURS, modifiedArray);                                                  // we call randomizeArray method to change colour sequence
            int randomColourIndex = (int)Math.floor(Math.random() * 7);                                      // make random number between 0 and 6 (we will use it later to remove colour from array)
            String missingColour = modifiedArray[randomColourIndex];                                         // here we store our missing colour
            Scanner scanner = new Scanner(System.in);                                                        // declaring scanner
            System.out.println("What colour of the rainbow is missing from this list?" + "\n");              // ask user for input
            removeColour(modifiedArray, randomColourIndex);                                                  // this method will prompt colours except one(missingColour) which user should guess

            String userInput = scanner.nextLine();                                                           // user input will be stored in userInput variable
            if(emptyInput(userInput)){                                                                       // check if input is empty
                System.out.println("Empty input. Please try again.");                                        // inform user
                continue;                                                                                    // continue loop
            }
            if(userInput.equalsIgnoreCase(missingColour)){                                                   // if user input colour (not case sensitive) is same as missing colour
                System.out.println("Correct Answer!!!");                                                     // inform user that guess is correct
                validInput = true;                                                                           // change boolean value responsible for input validation to true. It will exit loop
                scanner.close();                                                                             // close scanner
            } else {                                                                                         // other possible scenarios
                System.out.println("Your guess is wrong... Right answer was " + missingColour + "\n");       // inform user that guess is wrong and show the right answer. Loop will continue execution again
            }
        }
    }

    /**
     * method checks if input is empty
     * @param input string to be checked
     * @return boolean result
     */
    static boolean emptyInput(String input) {
        for (int i = 0; i < input.length(); i++)                                                             // loop through string
            if (input.charAt(i) != ' ') {                                                                    // check if char at index i is not equal to empty char
                return false;
            }
        return true;
    }

    /**
     * method to hide item from array
     * @param array with colours
     * @param randomIndex random number in array length range
     */
    public static void removeColour(String[] array, int randomIndex) {
        for(int i = 0; i < array.length; i++) {                                                              // looping through modified array
            if(i == randomIndex) {                                                                           // if loop control variable is equal to random number we generated earlier
                continue;                                                                                    // we skip iteration for this
            }
            System.out.println(array[i]);                                                                    // all other iterations will prompt colour
        }
        System.out.println();                                                                                // empty line for visualization purpose
    }

    /**
     * method to populate array with items from another but with different sequence
     * @param array - "parent" array
     * @param modifiedArray array to store randomized sequence items from "parent" array
     */
    public static void randomizeArray(String[] array, String[] modifiedArray) {                              // method to populate empty array(modifiedArrayray) with values from other array(array) but with different item sequence

        int count = 0;                                                                                       // increment loop control variable
        while(count < array.length) {                                                                        // condition is while count is less than array length

            int randomNumber = (int)Math.floor(Math.random() * array.length);                                // random number in range 0 and last array item index. Will be used as array index later

            if(count == 0) {                                                                                 // used once to populate first index of array
                modifiedArray[count] = array[randomNumber];                                                  // modifiedArray index 0 will be assigned to random index of array
                count++;                                                                                     // increase increment loop control variable
            }

            if(count > 0) {                                                                                  // for rest of array
                boolean isRepaet = false;                                                                    // boolean to find repeating items. Set to false
                for(int i = 0; i < count; i++) {                                                             // loop through existing array items
                    if (modifiedArray[i].equals(array[randomNumber])) {                                      // check if item exists already in array
                        isRepaet = true;                                                                     // if item already exists
                        break;                                                                               // will break current execution and start loop again till array is fully populated
                    }
                }
                if(!isRepaet) {                                                                              // if item is unique in this array
                    modifiedArray[count] = array[randomNumber];                                              // item will be added to array
                    count++;                                                                                 // increase increment loop control variable
                }
            }
        }
    }
}























