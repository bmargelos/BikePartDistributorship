//I Pledge
//Brittany Margelos
//BRO
import java.io.File;
import java.io.
import java.util.Scanner;

import java.io.InputStreamReader
import java.util.Scanner
public class Main {
    /**
     * @param args prints how many lines the user enters
     *             printing all parts that cost less than $20
     */
    public static void main(String[] args) throws IOException{
        File inFile = new File("warehouseDB.txt");
        Scanner sc = new Scanner(inFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();
    } // end of PSVM
}//end of main




/**
    }
        public String FileReader() throws FileNotFoundException {
            BufferedReader reader = new BufferedReader(new FileReader("testinventory.txt"))
            public String readAllLines (BufferedReader reader) throws IOException {
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }

                return content.toString();
            }
        }
//

        /*        // creating a scanner so a user can enter how many lines they want to put in the program
        Scanner in = new Scanner(System.in);
        System.out.print("How many lines do you have?");
        int num = in.nextInt();
        System.out.println(num);
        //user can enter bike part info
        System.out.println("Now enter the lines:");
*/


