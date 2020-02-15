//I Pledge
//Brittany Margelos
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileOutputStream;
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
                    String inFileName = Input.nextLine();


                    //ArrayList<BikePart> bp = new ArrayList<>();

                    //User enters the name of the file ( in this case "bikeParts.txt")
                    System.out.print("Enter Input FileName ");
                    inFileName = Input.nextLine();
                    int i = 0;

                    //reading in a file
                    try {
                        Scanner fIn = new Scanner(new FileInputStream(inFileName));

                        while (fIn.hasNext()) {
                            //contents[i] = fIn.nextLine();
                            //System.out.print(contents[i]);
                            //System.out.println("Read line "+ (i + 1));
                            i++;
                        }

                        //catching the file not found error if user enter's wrong file
                    } catch (FileNotFoundException e) {
                        System.err.println("File " + inFileName + " does not exist.");
                    }// end of catch FileNotFoundException

                case "Enter":
                case "Sell":
                case "Display":
                case "SortName":
                case "SortNumber":
                case "Quit":
                    break;

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

