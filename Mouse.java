//Student Name: Livia Menezes
//Student ID: 261066016
import java.util.Scanner;
import java.util.Random;

public class Mouse {






    public static void main(String[] args) {
    //    Scanner myObj = new Scanner(System.in);
    //        System.out.println("Inform the inicial number of mouses:");
    //        int qty_mouses = myObj.nextInt();
        
        Random rand = new Random(); //instance of random class
        int lowerbound = 1;
        int upperbound = 25; //generate random values from 1-25
              
        int qty_mouses = rand.nextInt(upperbound-lowerbound+1);
        System.out.println(qty_mouses);


        String[] myArr = new String[qty_mouses];

        for (int a=0; a<qty_mouses; a++){
            myArr[a]="mouse-"+(a+1);
            System.out.println(myArr[a]);
        }
        
    }
}
