//I Pledge
//Brittany Margelos

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException{
    FileReader("warehouseDB.txt");

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
