//Student Name: Livia Menezes
//Student ID: 261066016
import java.util.Scanner;
import java.util.Random;

public class Mouse {

    public int printStatus(mouses, traps, cheese){
        System.out.println("[Status] cheese left: "+cheese+);

        //RATO SENDO PEGO

        //RATO COMENDO
    }




    public static void main(String[] args) {
        Random rand = new Random(); //instance of random class
        int min = 1;
        int max_mouses = 15; //generate random values from 1-25
              
        int x = rand.nextInt(max_mouses-min+1);
        System.out.println("Quantity of mouses: "+x);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the quantity of traps you'd like to try: ");
        int y = myObj.nextInt();
        //System.out.println("Quantity of traps: "+y);
        int cheese_qty = 10;
        //System.out.println("Initial quantity of cheese: "+cheese_qty+" grams.");

        String[] myArr = new String[x];

        //for (int a=0; a<x; a++){
        //    myArr[a]="mouse-"+(a+1);
            //System.out.println(myArr[a]);
        //}
        
    }
}
