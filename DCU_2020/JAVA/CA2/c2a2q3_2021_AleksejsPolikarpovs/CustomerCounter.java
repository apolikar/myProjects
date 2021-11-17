
import java.util.ArrayList;

class CustomerCounter                                                                                  // all methods inside this class belongs to class and not to object(static).
{

    private static int currentCustomerAmount;                                                          // variable represents how many customers in the venue at the moment
    private static int maxCapacity;                                                                    // should be set before GUI
    public static ArrayList<CustomerCounter> allCustomers = new ArrayList<>();                         // this ArrayList will store references for every instance we created for each customer

    public static String getCurrentCustomerAmount(){                                                   // getter for current customer amount used in GUI to represent number in String type
        return "" + currentCustomerAmount;
    }

    public static void setMaxCapacity(int capacity){                                                   // setter to introduce max capacity to our program
        maxCapacity = capacity;
    }

    public static String getMaxCapacity(){                                                             // getter for max capacity used in GUI to represent number in String type
        return "" + maxCapacity;
    }

    /**
     * method prints information in graphic user interface regards venue free spaces
     * @return String message
     */
    public static String messegeGui(){
        String alarmMessege = "Maximum number of " + maxCapacity +                                     // alarm message notifying that venue is full
                " customers reached, please ask next customer to wait";
        String messege = "It is okay to let another customer in";                                      // message notifying that venue is not full and customer might enter venue
        if(currentCustomerAmount == 0){                                                                // message notifying venue is empty
            return "Venue is EMPTY.";
        }
        return currentCustomerAmount == maxCapacity ? alarmMessege : messege;                          // ternary operator decides which message should be displayed
    }

    /**
     * method where decision is made before letting another customer in
     * will be invoked when "let person in" button is pressed
     */
    public static void customerEnters(){

        if(currentCustomerAmount < maxCapacity){                                                       // block executes only if max capacity is not reached
            currentCustomerAmount++;                                                                   // increases amount of customers by one
            System.out.println("One customer let in to the venue." +                                   // prints announcement in to the terminal
                    " TOTAL CUSTOMERS ON VENUE: " + currentCustomerAmount);                            // creates object for each customer and adds it in to ArrayList
            createCustomerObject();                                                                    // creates customer object and adds it in to ArrayList
            if(currentCustomerAmount == maxCapacity){                                                  // if max capacity reached
                System.out.println("Venue is FULL.");                                                  // prints announcement in to the terminal
            }
        }
    }

    /**
     * method where decision is made when customer left venue
     * will be invoked when "let person out" button is pressed
     */
    public static void customerLeaves(){
        if (currentCustomerAmount > 0){                                                                // amount of customers can't be less than zero, so we need to implement that condition
            currentCustomerAmount--;                                                                   // decreases amount of customers by one
            System.out.println("One customer left venue." +                                            // prints announcement in to the terminal
                    " TOTAL CUSTOMERS ON VENUE: " + currentCustomerAmount);
            if(currentCustomerAmount == 0){                                                            // if condition when venue is empty reached
                System.out.println("Venue is EMPTY");                                                  // prints announcement in to the terminal
            }
        }
    }

    /**
     * method creates CustomerCounter object for every customer in
     */                                                                                                 // access modifier is private because we use this method inside customerEnters() method which is already in CustomerCounter class
    private static void createCustomerObject(){                                                         // method where per every customer an object is made. Might be used to to see how many customers attended the venue(list.size())
        // ArrayList is  better choice in my opinion because it is resizable. We don't know how many customers might attend venue
        allCustomers.add(new CustomerCounter());                                                        // adding object in to the ArrayList
        System.out.println("Instances in ArrayList: " + allCustomers.size());                             // printed for presentation purposes only to see how many objects were made
    }
}
