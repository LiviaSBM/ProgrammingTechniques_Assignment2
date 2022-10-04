//Student Name: Livia Menezes
//Student ID: 261066016
import java.util.Scanner;

import javax.print.attribute.standard.PrinterState;
import javax.print.event.PrintEvent;
import javax.swing.JSpinner.DateEditor;

import java.io.PrintStream;
import java.lang.ref.Cleaner.Cleanable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mouse {

    public static int printStatus(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, List deadMouses){
        if (index!=0 && index%5==0){ 
            System.out.println(trapCleaning(traps, remainingTraps, deadMouses));
        }

        if (mouses <= 0){
            int totalLost = (10 + (index*5)) - cheese;
            System.out.println("Total cheese lost = "+totalLost);
            return 0;
        }

        cheese += 5;
        System.out.println("[Status] cheese left: "+cheese+" g");

        return catchingMouse(mouses, traps, cheese, myArr, index, remainingTraps, deadMouses);
    }

    public static int catchingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, List deadMouses){
        Random rd = new Random();
        		
        if (traps<=mouses){
            for (int j=0; j<traps; j++){
                boolean mousefate = rd.nextBoolean();
                if (mousefate == true){
                    System.out.println("mouse-"+myArr[j]+" caught by trap");
                    deadMouses.add(myArr[j]);
                    myArr = removeMouse(myArr, index);
                    remainingTraps --;
                    mouses --;
                }
            }
        } else {
            for (int j=0; j<mouses; j++){
                boolean mousefate = rd.nextBoolean();
                if (mousefate == true){
                    System.out.println("mouse-"+myArr[j]+" caught by trap");
                    deadMouses.add(myArr[j]);
                    myArr = removeMouse(myArr, index);
                    remainingTraps --;
                    mouses--;
                }
            }
        }
        
        return eatingMouse(mouses, traps, cheese, myArr, index, remainingTraps,deadMouses);
    }

    public static int eatingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, List deadMouses){

        if (cheese <=0 || myArr.length<=0){
            return printStatus(mouses, traps, cheese, myArr, index+1, remainingTraps, deadMouses);
        } else if (cheese<=3 && cheese>0){
            System.out.println("mouse-"+myArr[0]+" ate "+cheese+" grams of cheese");
            cheese = 0;
            return printStatus(mouses, traps, cheese, myArr, index+1, remainingTraps, deadMouses);
        } else {
            int cheeseIndex = cheese/3;
            for (int j=0; j<Math.min(cheeseIndex, myArr.length);j++){
                System.out.println("mouse-"+myArr[j]+" ate 3 grams of cheese");
                cheese -= 3;
            }
            return printStatus(mouses, traps, cheese, myArr, index+1, remainingTraps, deadMouses);
        }     
    }

    public static int[] removeMouse(int[] myArr, int index){
        int[] proxyArray = new int[myArr.length - 1];
        for (int i = 0, k=0; i<myArr.length; i++) { 
            if (i == index) { 
                continue; 
            } 
            proxyArray[k++] = myArr[i]; 
        }
        return proxyArray;
    }

    public static int trapCleaning (int traps, int remainingTraps, List deadMouses){
        System.out.println("========================================================");
        for (int j=0; j<deadMouses.size()-1;j++){
            System.out.println("Store owner remove mouse-"+deadMouses.get(j));
        }
        System.out.println("========================================================");
        return eatingMouse(remainingTraps, remainingTraps, remainingTraps, null, traps, remainingTraps, deadMouses);

    }

    public static void main(String[] args) {
        Random rand = new Random(); //instance of random class
        int min = 1;
        int max_mouses = 8; //setting the range for generating random values

        int x = rand.nextInt(max_mouses-min+1);
        System.out.println("Quantity of mouses: "+x);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the quantity of traps you'd like to try: ");
        int y = myObj.nextInt();
        //System.out.println("Quantity of traps: "+y);
        int cheese_qty = 10;
        //System.out.println("Initial quantity of cheese: "+cheese_qty+" grams.");

        int[] arr = new int[x];

        for (int a=0; a<x; a++){
            arr[a]=(a+1);
            //System.out.println(myArr[a]);
        }

        List dMouses = new ArrayList();
        int i = 0;
        int rTraps = y;
        System.out.println(printStatus(x, y, cheese_qty-5, arr, i, rTraps, dMouses));
        
    }
}
