//I Pledge
//Brittany Margelos

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException{
    FileReader("warehouseDB.txt");
    Scanner Input = new Scanner(System.in);
    System.out.println("Enter a choice");
    String UserChoice = Input.next();
    String Choice = "";
    while(Choice != "Quit"){
        System.out.println("Please select an option:"+"Read: Read an inventory delivery file"+"Enter: Enter a part"+"Sell: Sell a part" +"Display: display a part"+"SortName: Sort and Display parts by name"+"SortNumber: Sort parts by part name");in
        
    }

    }




    public static void FileReader (String filename) throws FileNotFoundException{
            FileInputStream inFile;
            inFile = new FileInputStream(filename);
            Scanner sc = new Scanner(inFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

            }
            sc.close();
        }

    }
