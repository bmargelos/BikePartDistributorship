//I Pledge
//Brittany Margelos

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader("warehouseDB.txt");
        Choices();

    }

    public static void Choices(){
        Scanner Input = new Scanner(System.in);
        String Choice = "";
        while (!Choice.equalsIgnoreCase("Quit")) {
            System.out.println("Please select an option: \n" + "Read: Read an inventory delivery file \n" + "Enter: Enter a part \n" + "Sell: Sell a part \n" + "Display: display a part \n" + "SortName: Sort and Display parts by name \n" + "SortNumber: Sort parts by part name \n" + "Enter a choice:");
            Choice = Input.next();
            switch(Choice) {
                case "Read":
                    System.out.println("Enter the File you would like to read: ");

                case "Enter":
                case "Sell":
                case "Display":
                case "SortName":
                case "SortNumber":
                case "Quit":

            }

        }
    }



        public static void FileReader (String filename) throws FileNotFoundException {
            FileInputStream inFile;
            inFile = new FileInputStream(filename);
            Scanner sc = new Scanner(inFile);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

            }
            sc.close();
        }

    }

