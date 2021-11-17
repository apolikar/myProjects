
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class c2a2q2_2021_AleksejsPolikarpovs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);                                                      // declaring scanner
        char charValid = ' ';                                                                          // declaring empty char. Later it will be assigned, after input validation
        int[] intArray = new int[5];                                                                   // declaring empty array. array[0] will be numeric equivalent of char, the rest will store integers
        int count = 1;                                                                                 // declaring count, will be used as index to populate array[1 - 4] with integers
        boolean isValid = false;                                                                       // boolean for input validation. Set to false

        while (!isValid) {                                                                             // while loop will be executed till valid input is correct

            if (charValid == ' ') {                                                                    // block runs only if char variable is empty
                System.out.println("Enter character in range A - E:");                                 // ask user for input
                String inputChar = scanner.nextLine();                                                 // user input will be stored in inputChar variable
                if(emptyInput(inputChar)){                                                             // check if input is empty
                    System.out.println("Empty input. Please try again.");                              // inform user
                    continue;                                                                          // continue loop
                }

                char testChar = inputChar.toUpperCase().charAt(0);                                     // assign first char of String to testChar variable. We will check if inputChar.length() < 3 on next line. Input will be non case sensitive.
                if (inputChar.length() < 2 && charValidation(testChar, intArray)) {                    // check if input length is equal to 1(char) and invoke charValidation method which checks if char is in range
                    charValid = testChar;                                                              // assign charValid to testChar. After this step loop will ignore this block
                } else {
                    System.out.println("Invalid input. Please try again.");                            // inform user that input was invalid
                    continue;                                                                          // continue loop
                }
            }

            if (count < intArray.length) {                                                             // block runs till array is fully populated. Each time integer added to array, count will be increased
                System.out.println("Enter integer in range 1 - 9:");                                   // ask user for input
                String stringInt = scanner.nextLine();                                                 // user input will be stored in inputChar variable
                if(emptyInput(stringInt)){                                                             // check if input is empty
                    System.out.println("Empty input. Please try again.");                              // inform user
                    continue;                                                                          // continue loop
                }

                try {                                                                                  // in this block we try
                    int inputInt = Integer.parseInt(stringInt);                                        // parse string into int

                    if (inputInt > 0 && inputInt < 10) {                                               // check if input is in requested range 1- 9
                        intArray[count] = inputInt;                                                    // if value is in condition range it will be added in to intArray
                        count++;                                                                       // increase count
                    } else {
                        System.out.println("Invalid input. Please try again.");                        // inform user that input was invalid
                    }

                    if (count == intArray.length) {                                                    // runs only if array is fully populated, count will be equal to array length
                        isValid = true;                                                                // set isValid to true. It will be exit condition for our while loop
                        scanner.close();                                                               // close scanner
                    }
                } catch (NumberFormatException e){                                                     // if input can't be parsed into int NumberFormatException will be thrown
                    System.out.println("Invalid input. Please try again.");                            // inform user
                }
            }
        }

        new c2a2q2_2021_AleksejsPolikarpovs().writeToFile(intArray, charValid);                        // main method creates an object of this class type and calls the writetoFile() method

    }
    
    /**
     * method checks if input is empty
     * @param input string to be checked
     * @return boolean result
     */
    static boolean emptyInput(String input) {                                                           
         for (int i = 0; i < input.length(); i++)                                                      // loop through string
            if (input.charAt(i) != ' ') {                                                              // check if char at index i is not equal to empty char
                return false;
            }
        return true;
    }

    /**
     * method performs char validation and adds numeric equivalent of char in to array
     * @param testChar char to test
     * @param intArray array to test
     * @return boolean after char validation
     */
    static boolean charValidation(char testChar, int[] intArray) {
        char[] validChars = {'A', 'B', 'C', 'D', 'E'};                                                  // range of chars. Might be updated later
        boolean result = false;                                                                         // boolean used for return statement. Set to false

        for(int i = 0; i < validChars.length; i++){                                                     // loop through valid chars array
            if(validChars[i] == testChar){                                                              // if provided char(testChar) is in range of valid chars(validChars)
                intArray[0] = i + 1;                                                                    // numeric equivalent of char is based on alphabetic sequence. (example A = index(i = 0) + 1). Value will be added to provided array(intArray)
                result = true;                                                                          // char is found in range. return boolean value will be set to true
            }
        }
        return result;
    }

    /**
     * method generates text output
     * @param intArray array with int values
     * @param charValid validated char
     * @return char, int values and total by multiplying the numeric equivalent of the char by
     * the sum of the integer
     */
    String outputToFile(int[] intArray, char charValid) {
        StringBuilder result = new StringBuilder("" + charValid + "|");                                 // StringBuilder gives better performance with String concatenation. Our char and separation symbol already assigned
        int sum = 0;                                                                                    // sum of all integers will be here
        for(int i = 1; i < intArray.length; i++){                                                       // in our intArray integers starts from index 1. So we loop only through integers
            result.append(intArray[i]).append("|");                                                     // each time String result will be appended with integer and separation symbol(|)
            sum += intArray[i];                                                                         // and each integer will be added to sum
        }
        return result.toString() + (sum * intArray[0]);
    }

    /**
     * method generates name for (YYYYMMDD).dat file
     * @return file name
     */
    String getDate() {
        LocalDate myDateObj = LocalDate.now();                                                          // creating today's date object
        String result = "" + myDateObj;                                                                 // turn it to the String
        return result.replaceAll("-", "") + ".dat";                                                     // return String with requested format and ".dat" extension. Later will be used to name our file
    }

    /**
     * method writes text in to the file
     * @param intArray array with int values
     * @param charValid validated char
     */
    void writeToFile(int[] intArray, char charValid) {
        File file = new File(getDate());                                                                // File object is a representation of a file stored on a computer
        try {                                                                                           // might generate java.io.IOException which is checked exception. So we need to handle it. This block will try:
            FileWriter fw = new FileWriter(getDate());                                                  // FileWriter object created for writing streams of characters. getDate() method invoked to provide file name
            BufferedWriter bw = new BufferedWriter(fw);                                                 // create BufferedWriter object to provide buffering for Writer instances
            PrintWriter pw = new PrintWriter(bw);                                                       // create PrintWriter object to print text to provided file
            pw.println("char|int1|int2|int3|int4|total");                                               // print heading to a file
            pw.println(outputToFile(intArray, charValid));								           	    // print our generated String in outputToFile method
            System.out.println("SUCCESS!");                                                             // inform user that program is successfully complete
            pw.close();                                                                                 // close PrintWriter object
        } catch (IOException e) {                                                                       // if IOException catch
            System.out.println("Something went wrong ... ");                                            // inform user that something went wrong
        }
    }
}
