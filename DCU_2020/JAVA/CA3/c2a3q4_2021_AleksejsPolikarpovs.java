
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class c2a3q4_2021_AleksejsPolikarpovs {

    public static void main(String[] args) throws IOException {           // exception might be thrown if file is not found

        FileReader fr = new FileReader("C:\\Users\\apoli\\" +
                "OneDrive\\Documents\\C2 _Assignment3\\Q4\\text.txt");    // create a new object of FileReader class by supplying path
        BufferedReader br=new BufferedReader(fr);                         // create a new object of BufferReader class and provide our file to read from
        StringBuilder file = new StringBuilder();                         // StringBuilder is used to concatenate our text from a file to one string

        while(br.ready()){                                                // while buffer stream is ready
            String temp = br.readLine();                                  // store line of text in temporary string
            file.append(temp);                                            // and append it to StringBuilder file
        }
        fr.close();                                                       // after all text is appended to stringBuilder file
        br.close();                                                       // we close file reader and buffer reader

        HashSet<String> allowedMakes = new HashSet<>();                   // creating unique set of cars. HashSet might contains only unique items
        allowedMakes.add("porsche");
        allowedMakes.add("audi");
        allowedMakes.add("mitsubishi");
        allowedMakes.add("bmw");
        allowedMakes.add("volvo");


        String[] strArray = file.toString().split(" ");                   // create string array with all cars from file
        HashMap<String, Integer> carsInfo = new HashMap<>();              // create HashMap with String key and Integer value

        int count = 0;
        for (String i : allowedMakes) {                                   // nested loop to loop through our unique car set
            for (String k : strArray){                                    // and string array with all cars from input
                if (i.equals(k)){                                         // if match found
                    count++;                                              // increment count
                }
            }
            carsInfo.put(i, count);                                       // put car make(String) : count (integer) to HashMap
            count = 0;                                                    // reset count
        }

        System.out.println("\nContents of file: \n" + file + "\n");       // prints content of file
        for(String result : carsInfo.keySet()){                           // loop through hash map
            System.out.println(result + " : " + carsInfo.get(result));    // and print result
        }
    }
}
