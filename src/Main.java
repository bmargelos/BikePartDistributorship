//I Pledge
//Brittany Margelos
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        Choices();

    }
    public static void Choices()throws IOException {
        ArrayList <BikePart> WareHouse = new ArrayList<BikePart>();
        FileInputStream fileIn = new FileInputStream("warehouseDB.txt");
        Scanner readLn = new Scanner(fileIn);
        fileIn.close();
        while(readLn.hasNext()){
            String nLine = readLn.nextLine();
            BikePart dbPart = new BikePart(nLine);
            WareHouse.add(dbPart);
        }
        Scanner Input = new Scanner(System.in);
        String Choice = "";
        while (!Choice.equalsIgnoreCase("Quit")) {
            System.out.println("Please select an option: \n" + "Read: Read an inventory delivery file \n" + "Enter: Enter a part \n" + "Sell: Sell a part \n" + "Display: display a part \n" + "SortName: Sort and Display parts by name \n" + "SortNumber: Sort parts by part name \n" + "Enter a choice:");
            Choice = Input.next();
            switch (Choice) {
                case "Read":
                    System.out.println("Enter the File you would like to read: ");
                    String inFileName = Input.next();
                    //User enters the name of the file ( in this case "inventory2.txt")
                    //reading in a file
                    try {
                        Scanner fIn = new Scanner(new FileInputStream(inFileName));
                        while (fIn.hasNext()) {
                            String nextLn = fIn.nextLine();
                            BikePart nxtPart = new BikePart(nextLn);
                            //hey we still need to know if a Part is in the array
                            for(BikePart Part : WareHouse){
                                if(Part.getPartNumber() == nxtPart.getPartNumber()){
                                    Part.setQuantity(Part.getQuantity()+nxtPart.getQuantity());
                                }else{
                                    WareHouse.add(nxtPart);
                                }
                            }
                        }
                        System.out.println("Read line " + inFileName + " was read successfully. \n");
                    } catch (FileNotFoundException e) {
                        System.err.println("File " + inFileName + " does not exist.");
                    }// end of catch FileNotFoundException
                    System.out.println(WareHouse.size());
                    break;
                case "Enter":
                    System.out.println("Enter Bike Part Details by Part Name,Part Number,List Price,Sale Price,Sale Status, Quantity:\nExample: (WTB_saddle,1234567890,33.00,25.58,false,1)");
                    break;
                case "Sell":
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Calendar calObj = Calendar.getInstance();
                    System.out.println("Please enter the Part Number: ");
                    int PartNumber = Input.nextInt();
                    System.out.println("How many items will be sold?: ");
                    int PartsSold = Input.nextInt();
                    if(WareHouse.size() > 0) {
                        for (BikePart part : WareHouse) {
                            if (part.getPartNumber() == PartNumber) {
                                part.setQuantity(part.getQuantity() - PartsSold);
                                System.out.println("Time Sold at: " + calObj.getTime());
                            } else {
                                System.out.println("Part is not Available");
                            }
                        }
                    }else{
                        System.out.println("Part is not available");
                    }
                    break;
                case "Display":
                    break;
                case "SortName":
                    break;
                case "SortNumber":
                    break;
                case "Quit":
                    File FileOut = new File("warehouseDB.txt");
                    FileWriter fWriter = new FileWriter(FileOut);
                    PrintWriter pWriter = new PrintWriter(fWriter);
                    if(WareHouse.size() > 0){
                        for (BikePart bikePart : WareHouse) {
                            pWriter.println(bikePart.getInfo());
                        }
                    }
                    pWriter.close();
                    break;
            }


        }
    }
}

