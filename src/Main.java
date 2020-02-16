//I Pledge
//Brittany Margelos
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // FileReader("warehouseDB.txt");
        ArrayList<BikePart> Inventory = new ArrayList<BikePart>();
        Choices();

    }

    public static void Choices() throws FileNotFoundException {

        Scanner Input = new Scanner(System.in);
        String Choice = " ";
        while (!Choice.equalsIgnoreCase("Quit")) {
            System.out.println("Please select an option: \n" + "Read: Read an inventory delivery file \n" + "Enter: Enter a part \n" + "Sell: Sell a part \n" + "Display: display a part \n" + "SortName: Sort and Display parts by name \n" + "SortNumber: Sort parts by part name \n" + "Enter a choice:");
            Choice = Input.next();
            switch (Choice) {
                case "Read":
                    readCase();
                case "Enter":
                    enterCase();
                case "Sell":
                case "Display":
                case "SortName":
                case "SortNumber":
                case "Quit":
                    break;

            }


        }
    }

    private static void readCase() throws FileNotFoundException {
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter the File you would like to read: ");
        String inFileName = Input.nextLine();

        int i = 0;

        //reading in a file
        try {
            Scanner fIn = new Scanner(new FileInputStream(inFileName));

            while (fIn.hasNext()) {
                String nextLn = fIn.nextLine();

            }
            //catching the file not found error if user enter's wrong file
        } catch (FileNotFoundException e) {
            System.err.println("File " + inFileName + " does not exist.");
        }// end of catch FileNotFoundException
    }
    private static void enterCase() throws FileNotFoundException {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter partname: ");
        String partName = Input.nextLine();
        System.out.print("Enter partnum: ");
        int partNum = Integer.parseInt(Input.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(Input.nextLine());
        System.out.print("Enter sales price: ");
        double salesPrice = Double.parseDouble(Input.nextLine());
        System.out.print("Enter onsale (true or false): ");
        boolean onsale = Boolean.parseBoolean(Input.nextLine());
        System.out.print("Enter warehouse quantity: ");
        int quantity = Integer.parseInt(Input.nextLine());


    }


        public static void FileReader (String inFileName) throws FileNotFoundException {
            FileInputStream inFile;
            inFile = new FileInputStream(inFileName);
            Scanner sc = new Scanner(inFile);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
            }
            sc.close();

        }


    }

