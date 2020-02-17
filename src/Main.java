//I Pledge
//Brittany Margelos
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    static List<BikePart> Inventory;
    public static void main(String[] args) throws IOException {
        // FileReader("warehouseDB.txt");
        Inventory = LoadInventory();
    }

    public static void Choices() throws IOException {

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
    private static void enterCase() throws IOException {
        BikePart bikePart = new BikePart();
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter partname: ");
        bikePart.setName(Input.nextLine());
        System.out.print("Enter partnum: ");
        bikePart.setPartNumber(Integer.parseInt(Input.nextLine()));//int partNum = Integer.parseInt(Input.nextLine());
        System.out.print("Enter price: ");
        bikePart.setPrice(Double.parseDouble(Input.nextLine()));//double price = Double.parseDouble(Input.nextLine());
        System.out.print("Enter sales price: ");
        bikePart.setPricesSales(Double.parseDouble(Input.nextLine()));//double salesPrice = Double.parseDouble(Input.nextLine());
        System.out.print("Enter onsale (true or false): ");
        bikePart.setOnSale(Boolean.parseBoolean(Input.nextLine()));//boolean onsale = Boolean.parseBoolean(Input.nextLine());
        System.out.print("Enter warehouse quantity: ");
        bikePart.setQuantity(Integer.parseInt(Input.nextLine()));//int quantity = Integer.parseInt(Input.nextLine());
        processInfo(bikePart);
    }

    static void processInfo(BikePart bikePart) throws IOException {

        FileWriter writer = new FileWriter("warehouseDB.txt", true);
        boolean existPart = false;

        for (BikePart  bikePartTmp: Inventory ) {
            //System.out.println(bikePartTmp.getName());
            if(bikePartTmp.getName().equals(bikePart.getName())){
                existPart = true;
                writer.write(bikePart.getName()+","+bikePart.getPartNumber()+","+bikePart.getPrice()+","+bikePart.getSalesPrice()+","+bikePart.getOnSale()+","+bikePart.getQuantity()+"\n");
            }else{
                writer.write(bikePartTmp.getName()+","+bikePartTmp.getPartNumber()+","+bikePartTmp.getPrice()+","+bikePartTmp.getSalesPrice()+","+bikePartTmp.getOnSale()+","+bikePartTmp.getQuantity()+"\n");
            }
        }

        //add if not exist
        if(!existPart){
            writer.write(bikePart.getName()+","+bikePart.getPartNumber()+","+bikePart.getPrice()+","+bikePart.getSalesPrice()+","+bikePart.getOnSale()+","+bikePart.getQuantity()+"\n");
        }

        writer.close();
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

    public static List<BikePart> LoadInventory() throws FileNotFoundException {
        List<BikePart> lstTemp = new ArrayList<>();

        Scanner sc = new Scanner(new File("inventory.txt"));

        while (sc.hasNextLine())
            lstTemp.add(new BikePart(sc.nextLine()));

        return lstTemp;
    }


}