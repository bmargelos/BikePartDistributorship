//I Pledge
//Brittany Margelos

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader("warehouseDB.txt");
        Choices();
    }

    public static void Choices() {
        Scanner Input = new Scanner(System.in);
        String Choice = "";
        while (!Choice.equalsIgnoreCase("Quit")) {
            System.out.println("Please select an option: \n" + "Read: Read an inventory delivery file \n" + "Enter: Enter a part \n" + "Sell: Sell a part \n" + "Display: display a part \n" + "SortName: Sort and Display parts by name \n" + "SortNumber: Sort parts by part name \n" + "Enter a choice:");
            Choice = Input.next();
            switch (Choice) {
                case "Read":
                    readCase();
                case "Enter":
                    enterCase();
                case "Sell":
                    sellCase();
                case "Display":
                    displayCase():
                case "SortName":
                    sortName():
                case "SortNumber":
                    sortNumber():
                case "Quit":

            }//beginning of Switch statements

        }//start of while loop
    }//choices method


    private static void readCase() {
        System.out.println("Enter the File you would like to read: ");
        Scanner Input = new Scanner(System.in);
        String inFileName = "";
        String[] contents = new String[200];
        //User enters the name of the file ( in this case "inventory.txt")
        System.out.print("Enter Input FileName ");
        inFileName = Input.nextLine();

        int i = 0;

        //reading in a file
        try {
            Scanner fIn = new Scanner(new FileInputStream(inFileName));

            while (fIn.hasNext()) {
                contents[i] = fIn.nextLine();
                i++;
            }
            //catching the file not found error if user enter's wrong file
        } catch (FileNotFoundException e) {
            System.err.println("File " + inFileName + " does not exist.");
        }// end of catch FileNotFoundException
    }
    private static void enterCase() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter PartName: ");
        String partName = Input.nextLine();
        System.out.print("Enter Part Number: ");
        int partNum = Integer.parseInt(Input.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(Input.nextLine());
        System.out.print("Enter sales price: ");
        double salesPrice = Double.parseDouble(Input.nextLine());
        System.out.print("is the item # on sale? Enter True or False: ");
        boolean onsale = Boolean.parseBoolean(Input.nextLine());
        System.out.print("Enter warehouse quantity: ");
        int quantity = Integer.parseInt(Input.nextLine());
    }// end of enterCase

    private static void sellCase(){
        Scanner Input = new Scanner(System.in);
            System.out.print("Enter part number: ");
            int partNum = Integer.parseInt(Input.nextLine());
            //Inventory i = .sellPart(partNum);
            //if (i == null)
                System.out.println("Part not in DB.");
           // else
                //System.out.println(i + (new Date()).toString());
       // }

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
