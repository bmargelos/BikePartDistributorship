//I Pledge
//Brittany Margelos
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        FileReader("warehouseDB.txt");
        Choices();


    }
    public static void Choices()throws IOException {
        ArrayList <BikePart> WareHouse = new ArrayList<BikePart>();
        Scanner Input = new Scanner(System.in);
        String Choice = "";
        while (!Choice.equalsIgnoreCase("Quit")) {
            System.out.println("Please select an option: \n" + "Read: Read an inventory delivery file \n" + "Enter: Enter a part \n" + "Sell: Sell a part \n" + "Display: display a part \n" + "SortName: Sort and Display parts by name \n" + "SortNumber: Sort parts by part name \n" + "Enter a choice:");
            Choice = Input.next();
            switch (Choice) {
                case "Read":
                    System.out.println("Enter the File you would like to read: ");
                    String inFileName = Input.nextLine();
                    //User enters the name of the file ( in this case "inventory2.txt")
                    inFileName = Input.nextLine();
                    int i = 0;
                    //reading in a file
                    try {
                        Scanner fIn = new Scanner(new FileInputStream(inFileName));

                        while (fIn.hasNext()) {
                            //contents[i] = fIn.nextLine();
                            String nextLn = fIn.nextLine();
                            BikePart nxtPart = partConstructor(nextLn);
                            boolean Present = ifPresent(WareHouse,nxtPart);
                            if(!Present){
                                WareHouse.add(nxtPart);
                            }else{
                                int index = WareHouse.indexOf(nxtPart.getPartNumber());
                                BikePart Current = WareHouse.get(index);
                                Current.setQuantity(Current.getQuantity() + nxtPart.getQuantity() );
                            }
                            //System.out.print(contents[i]);
                            //i++;
                        }
                        System.out.println("Read line "+ inFileName + " was read successfully. \n");
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
                    File FileOut = new File("warehouseDB.txt");
                    FileWriter fWriter = new FileWriter(FileOut);
                    PrintWriter pWriter = new PrintWriter(fWriter);

                    int Length = WareHouse.size();
                    for(int f = 0; f< Length;f++){
                        String Info = WareHouse.get(f).getInfo();
                        pWriter.println(Info);
                    }
                    pWriter.close();

            }


        }
    }

    public static void FileReader(String filename) throws FileNotFoundException {
        FileInputStream inFile;
        inFile = new FileInputStream(filename);
        Scanner sc = new Scanner(inFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            BikePart newPart = new BikePart(line);

        }
        sc.close();


    }
    public static boolean ifPresent(ArrayList<BikePart> list,BikePart Part){
        return list.contains(Part);
    }
    public static BikePart partConstructor(String info){
        BikePart newPart = new BikePart(info);
        return newPart;
    }





}

