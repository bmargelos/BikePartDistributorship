//I Pledge...
//Brittany Margelos
//Ben Hichak
//Luis Maldonado
import java.awt.Color;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import static java.awt.Color.black;
import static java.awt.Color.red;

public class Main {
    /**
     *
     * @param args main
     * @throws IOException for the switch statement choices
     */
    public static void main(String[] args) throws IOException {
        Choices();
    }

    /**
     *
     * @throws IOException for reading in a file
     */
    public static void Choices() throws IOException {
        ArrayList<BikePart> WareHouse = new ArrayList<>();
        FileInputStream fileIn = new FileInputStream("warehouseDB.txt");
        Scanner readLn = new Scanner(fileIn);

        while (readLn.hasNext()) {
            String nLine = readLn.nextLine();
            BikePart dbPart = new BikePart(nLine);
            WareHouse.add(dbPart);
        }
        fileIn.close();
        Scanner Input = new Scanner(System.in);
        String Choice = "";

        while (!Choice.equalsIgnoreCase("Quit")) {
            System.out.println("Please select an option: \n" + "Read: Read an inventory delivery file \n" + "Enter: Enter a part \n" + "Sell: Sell a part \n" + "Display: display a part \n" + "SortName: Sort and Display parts by name \n" + "SortNumber: Sort parts by part name \n" + "Enter a choice:");
            Choice = Input.next();
            Choice = Choice.toUpperCase();
            switch (Choice) {
                case "READ":
                    try{
                        System.out.println("Enter the File you would like to read:" );
                        String inFileName = Input.next();
                        //User enters the name of the file ( in this case "inventory2.txt")
                        //reading in a file
                        Scanner fIn = new Scanner(new FileInputStream(inFileName));
                        while (fIn.hasNext()) {
                            String nextLn = fIn.nextLine();
                            boolean rfound = false;
                            int rIndex = 0;
                            BikePart ePart = new BikePart(nextLn);
                            for (int d = 0; d < WareHouse.size(); d++) {
                                int pNext = WareHouse.get(d).getPartNumber();
                                if (ePart.getPartNumber() == pNext) {
                                    rfound = true;
                                    rIndex = d;
                                }
                            }
                            if (rfound) {
                                WareHouse.get(rIndex).setQuantity(WareHouse.get(rIndex).getQuantity() + ePart.getQuantity());
                            } else {
                                WareHouse.add(ePart);
                            }

                        }

                        System.out.println(inFileName + " was read successfully. \n");
                    } catch (FileNotFoundException e) {
                        System.err.println("File does not exist.");
                        System.out.println("");
                    }// end of catch FileNotFoundException
                    break;
                case "ENTER":
                    try {
                        System.out.println("Enter Bike Part Details by Part Name,Part Number,List Price,Sale Price,Sale Status, Quantity:\nExample: (WTB_saddle,1234567890,33.00,25.58,false,1)");
                        String eInfo = Input.next();
                        boolean efound = false;
                        int eIndex = 0;
                        BikePart ePart = new BikePart(eInfo);
                        for (int d = 0; d < WareHouse.size(); d++) {
                            int pNext = WareHouse.get(d).getPartNumber();
                            if (ePart.getPartNumber() == pNext) {
                                efound = true;
                                eIndex = d;
                            }
                        }
                        if (efound) {
                            WareHouse.get(eIndex).setQuantity(WareHouse.get(eIndex).getQuantity() + ePart.getQuantity());
                        } else {
                            WareHouse.add(ePart);
                        }
                        System.out.println("");
                    }catch(Exception e){
                        System.err.println("Incorrect Input"+"\n");
                }
                    break;
                case "SELL":
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Calendar calObj = Calendar.getInstance();
                    System.out.println("Please enter the Part Number: ");
                    int PartNumber = Input.nextInt();
                    int uIndex = 0;
                    boolean found = false;
                    for (int d = 0; d < WareHouse.size(); d++) {
                        int pNumb = WareHouse.get(d).getPartNumber();
                        if (pNumb == PartNumber) {
                            uIndex = getIndex(WareHouse, WareHouse.get(d));
                            found = true;
                        }
                    }
                    if (found) {
                        double sPrice = 0;
                        boolean isSal = WareHouse.get(uIndex).getOnSale();
                        if (isSal) {
                            sPrice = WareHouse.get(uIndex).getSalesPrice();
                        } else {
                            sPrice = WareHouse.get(uIndex).getPrice();
                        }
                        System.out.println("\n"+ WareHouse.get(uIndex).getName() + " Price: " + sPrice + " OnSale: " + WareHouse.get(uIndex).getOnSale());
                        WareHouse.get(uIndex).setQuantity(WareHouse.get(uIndex).getQuantity() - 1);
                        System.out.println("Time Sold:  " + calObj.getTime() + "\n");

                    } else {
                        System.err.println("Part was not found!" + "\n");
                    }

                    break;
                case "DISPLAY":
                    System.out.println("Enter the Part Name: ");
                    String pName = Input.next();
                    int nIndex = 0;
                    boolean isSale = false;
                    boolean Found = false;
                    double pDisplay = 0.0;
                    for (int l = 0; l < WareHouse.size(); l++) {
                        String cName = WareHouse.get(l).getName();
                        if (cName.equals(pName)) {
                            nIndex = getIndex(WareHouse, WareHouse.get(l));
                            isSale = WareHouse.get(nIndex).getOnSale();
                            Found = true;
                            if (isSale) {
                                pDisplay = WareHouse.get(nIndex).getSalesPrice();
                            } else {
                                pDisplay = WareHouse.get(nIndex).getPrice();
                            }

                        }
                    }
                    if (!Found) {
                        System.err.println("The part was not found"+" \n");
                    } else {
                        System.out.println("\n"+ WareHouse.get(nIndex).getName() + " " + "Cost: " + pDisplay + " " + WareHouse.get(nIndex).getQuantity() + "\n");
                    }

                    break;
                case "SORTNAME":
                    if (WareHouse.size() > 0) {
                        int counts = 0;
                        while (counts < 50) {
                            for (int a = 0, b = 1; b < WareHouse.size(); a++, b++) {
                                String Temp1 = WareHouse.get(a).getName().toUpperCase();
                                String Temp2 = WareHouse.get(b).getName().toUpperCase();
                                int Value = Temp1.compareTo(Temp2);
                                if (Value > 0) {
                                    Collections.swap(WareHouse, a, b);
                                }
                            }
                            counts++;
                        }
                        System.out.println("");
                        for (int a = 0; a < WareHouse.size(); a++) {
                            System.out.println(WareHouse.get(a).getInfo());
                    }
                        System.out.println("");
                    }else{
                        System.err.println("Warehouse is empty." + "\n");
                    }
                     break;
                    case "SORTNUMBER":
                        if(WareHouse.size() > 0) {
                            int count = 0;
                            while (count < 50) {
                                for (int a = 0, b = 1; b < WareHouse.size(); a++, b++) {
                                    int Temp1 = WareHouse.get(a).getPartNumber();
                                    int Temp2 = WareHouse.get(b).getPartNumber();
                                    if (Temp1 > Temp2) {
                                        Collections.swap(WareHouse, a, b);
                                    }
                                }
                                count++;
                            }
                            System.out.println("");
                            for (int a = 0; a < WareHouse.size(); a++) {
                                System.out.println(WareHouse.get(a).getInfo());
                            }
                            System.out.println("");
                        }else{
                            System.err.println("Warehouse is empty."+"\n");
                        }
                        break;
                    case "QUIT":
                        File FileOut = new File("warehouseDB.txt");
                        FileWriter fWriter = new FileWriter(FileOut);
                        PrintWriter pWriter = new PrintWriter(fWriter);
                        for (int k = 0; k < WareHouse.size(); k++) {
                            pWriter.println(WareHouse.get(k).getInfo());
                        }
                        pWriter.close();
                        break;
                default:
                    System.err.println("\n" + "Invalid Input!" + "\n" + "Please Enter Another Choice." + "\n");

            }


            }
        }

    /**
     *
     * @param list of a arrayList indices
     * @param part bike part array of parts
     * @return the array list parts
     */
        public static int getIndex (ArrayList list, BikePart part){
            return list.indexOf(part);
        }

    }




