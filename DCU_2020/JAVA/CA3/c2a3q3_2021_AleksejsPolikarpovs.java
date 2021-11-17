
import java.util.Arrays;
import java.util.Scanner;

public class c2a3q3_2021_AleksejsPolikarpovs {

    public static void main(String[] args) {

        int[] original = new int[4];
        int[] modified = new int[4];

        populateArray(original);                                                                    // populate original array

        int sumTotal = 0;                                                                           // total sum of all elements in array
        int arrayLastIndex = original.length - 1;                                                   // array last index
        sumTotal = sum(arrayLastIndex, original, sumTotal);                                         // recursive method sum will assign total value to variable
        populate(modified.length, sumTotal, original, modified);                                    // recursive method populate will populate modified array

        System.out.println("Original array: " + Arrays.toString(original));                         // print result
        System.out.println("Modified array: " + Arrays.toString(modified));
    }


    /**
     * method will populate original array with integers in range values
     * @param original array to populate
     */
    public static void populateArray(int[] original){
        Scanner scanner = new Scanner(System.in);                                                   // open scanner
        int index = 0;                                                                              // array index to populate

        while (index < original.length){                                                            // until array is full
            System.out.print("Enter an integer in the range of 1 to 9 (inclusive): ");
            String input = scanner.nextLine().trim();                                               // input is trimmed
            if(input.isEmpty()){                                                                    // if input is empty inform user
                System.out.println("You should enter integer number to proceed ... ");
                continue;                                                                           // continue loop
            }
            try {                                                                                   // try to parse input from string to int
                int userInput = Integer.parseInt(input);
                if(userInput > 0 && userInput < 10){                                                // if input is in range
                    original[index] = userInput;                                                    // populate array index with value
                    index++;                                                                        // increment index
                    continue;                                                                       // continue loop
                }

                System.out.println("Invalid entry, number must be in range.");
            } catch (NumberFormatException e){                                                      // if parsing is not possible loop will run again until input might be parsed to int
                System.out.println("You should enter integer number to proceed ... ");
            }
        }
        scanner.close();                                                                            // close scanner
    }


    /**
     * recursive method to find total sum of array int
     * @param i last index of array
     * @param array to perform action on
     * @param sum variable to assign value
     * @return int sum of all array elements
     */
    public static int sum(int i, int[] array, int sum){
        if(i < 0)                                                                                   // base case (if index less than zero)
            return sum;                                                                             // return sum

        sum += array[i];                                                                            // add element value to sum
        return sum(i - 1, array, sum);                                                            // recursive return with index - 1
    }

    /**
     * recursive void method to populate modified array
     * with the sum of every other element in the array
     * @param i modified array last index
     * @param sum int value of all elements sum
     * @param original array to perform action on
     * @param modified array to populate
     */
    public static void populate(int i, int sum, int[] original, int[] modified){
        if(i == 0)                                                                                   // base case
            return;

        i--;                                                                                         // decrement index each iteration
        modified[i] = sum - original[i];                                                             // populate modified array index
        populate(i, sum, original, modified);                                                        // recursive method call until base condition is met
    }
}





