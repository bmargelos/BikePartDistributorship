//I Pledge
//Brittany Margelos
//BRO

import java.util.Scanner;
public class Main {
    /**
     *
     * @param args
     *prints how many lines the user enters
     * printing all parts that cost less than $20
     */
    public static void main(String[] args){
        // creating a scanner so a user can enter how many lines they want to put in the program
        Scanner in = new Scanner(System.in);
        System.out.print("How many lines do you have?");
        int num = in.nextInt();
        System.out.println(num);
        //user can enter bike part info
        System.out.println("Now enter the lines:");


        // creating a 4-loop that goes up to the number of lines the user has entered
        BikePart [] bpArray= new BikePart[num];
        for( int x = 0; x<num; x++){
            String info = in.next();
            BikePart bp = new BikePart(info);
            bpArray[x]=bp;
            System.out.println(info );
        }//end of 4-loop

        //making a 4-loop and printing all parts that cost less than $20
        System.out.println("");
        System.out.println("Now printing the bike parts that are less than $20");
        for (int x=0; x<bpArray.length; x++){
            if(bpArray[x].price<20)
                System.out.println(bpArray[x].partName+ "," + bpArray[x].partNumber + ","+ bpArray[x].price+ "," + bpArray[x].salesPrice + "," + bpArray[x].onSale);
        }// end of 4-loop

    }//end of PSVM
}//end of Main class
