
import java.util.Scanner;
import java.util.Stack;


public class Quiz {


    // inner class Question
    private class Question {
        private final int firstDigit = generateRandom(9); //
        private int secondDigit;
        private String consoleOutput;
        private int result;

        public Question() {                  // constructor will set values for fields
            generateSecondDigit();
            createOutput();
            countResult();
        }

        /**
         * method to count result for question depends on current level
         */
        private void countResult(){
            switch (level) {
                case 1:
                case 2:
                    result = firstDigit + secondDigit;
                    break;
                case 3:
                    result = firstDigit - secondDigit;
            }
        }

        /**
         * method generates question output for console depending on current level
         */
        private void createOutput(){
            switch (level) {
                case 1:
                case 2:
                    consoleOutput = firstDigit + " + " + secondDigit + " = ";
                    break;
                case 3:
                    consoleOutput = firstDigit + " - " + secondDigit + " = ";
            }
        }

        /**
         * method assigning value to a second random digit depends on level
         */
        private void generateSecondDigit() {
            switch (level) {
                case 1:
                    secondDigit = generateRandom(9 - firstDigit - 1);
                    break;
                case 2:
                    secondDigit = generateRandom(9);
                    break;
                case 3:
                    secondDigit = generateRandom(firstDigit);
            }
        }

        /**
         * method generates random number
         * @param maxValue max int value generated number might be
         * @return int random value
         */
        private int generateRandom(int maxValue) {
            return (int) Math.floor(Math.random() * maxValue + 1);
        }
    }


    private int level = 1;
    private int tries;
    private boolean isComplete;
    private final Scanner scanner = new Scanner(System.in);         // open scanner;
    private final Stack<Question> questionStack = new Stack<>();    // questionStack will store questions

    /**
     * method to run quiz
     * access modifier is public
     */
    public void runQuiz() {
        System.out.println("Starting the test, there are 3 levels.\n" +
                        "To advance to each level, you must get 3 questions right in the previous level");

        populateQuestionStack();                                    // will populate stack with level 1 three questions

        while (!isComplete) {                                       // while loop runs till isComplete is true

            if(askQuestion(validInput())){                          // if askQuestion (with valid intput as parameter) return true
                correctGuess();                                     // correctGuess method runs
            } else {
                incorrectGuess();                                   // else incorrectGuess runs
            }
        }
        scanner.close();                                            // close scanner
    }

    /**
     * method to populate questionStack with questions
     * Each correct answered question will pop() question from a list
     */
    private void populateQuestionStack(){
        questionStack.add(new Question());                          // add question in stack
        questionStack.add(new Question());
        questionStack.add(new Question());
    }

    /**
     * method prints question to console and awaiting for user input
     * if user input is invalid (empty input, string input etc ... ) informs user
     * @return valid int userGuess
     */
    private int validInput() {
        boolean isValid = false;
        int userGuess = 0;

        while (!isValid){
            System.out.print(questionStack.peek().consoleOutput);   // peek last question in stack and print consoleOutput
            String input = scanner.nextLine().trim();               // input is trimmed
            if(input.isEmpty()){                                    // if input is empty inform user
                System.out.println("You should enter integer number to proceed ... ");
                continue;
            }
            try {                                                   // try to parse input to string
                userGuess = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException e){                      // if parsing is not possible loop will run again until input might be parsed to int
                System.out.println("You should enter integer number to proceed ... ");
            }
        }

        return userGuess;
    }

    /**
     * method to check if userGuess is correct
     * @return boolean value
     */
    private boolean askQuestion(int validInput) {
        return validInput == questionStack.peek().result;           // check if question result is same with userGuess
    }

    /**
     * method with logic if user guess is correct
     */
    private void correctGuess() {
        questionStack.pop();                                       // remove question from stack

        if(questionStack.empty()) {                                // check if stack is empty
            level++;                                               // level up
            if (level == 4) {                                      // if level == 4 we terminate program
                isComplete = true;
                System.out.println("You completed the test, thank you!");
                return;
            }

            System.out.println("Congratulations, advancing to level " + level);
            populateQuestionStack();                               // populate stack again, but with leveled up questions
        }
    }

    /**
     *  method with logic if user guess is incorrect
     */
    private void incorrectGuess() {
        tries++;                                                    // increment tries by one

        if(tries == 2){                                             // if tries value is 2 we need to change question
            System.out.println("Oops, that is not right. Answer was : " +
                    questionStack.peek().result);
            tries = 0;
            questionStack.pop();                                    // remove question from stack
            questionStack.push(new Question());                     // and add another one
            return;
        }

        System.out.println("That is not right. Try again ...");
    }
}

