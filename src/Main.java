//I Pledge
//Brittany Margelos

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    /**
     * @param args prints how many lines the user enters
     *             printing all parts that cost less than $20
     */

 public static void main(String[] args) throws FileNotFoundException {
     File inFile = new File("warehouseDB.txt");
     Scanner sc = new Scanner(inFile);
     while (sc.hasNextLine()) {
         String line = sc.nextLine();
         System.out.println(line);
     }
     sc.close();
 }//end of PSVM
}//end of main class