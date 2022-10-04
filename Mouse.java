//Student Name: Livia Menezes
//Student ID: 261066016

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mouse {

    public static int printStatus(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, List deadMouses){
        System.out.println("[Status] cheese left: "+cheese+"\n");
        if (index!=0 && index%5==0){ 
            System.out.println(trapCleaning(traps, remainingTraps, deadMouses));
        }

        if (mouses <= 0){
            int totalLost = (10 + (index*5)) - cheese;
            System.out.println("[Status] Total cheese lost = "+totalLost);
            return 0;
        }

        if (index%2==0 && index!=0){
            System.out.println("[Action] Cheese Machine add 10 grams of cheese");
            cheese += 10;
            System.out.println("[Status] cheese left: "+cheese+"\n");
        }
        
        return catchingMouse(mouses, traps, cheese, myArr, index, remainingTraps, deadMouses);
    }

    public static int catchingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, List deadMouses){
        Random rd = new Random();
        		
        for (int j=0; j<Math.min(remainingTraps,mouses); j++){
            boolean mousefate = rd.nextBoolean();
            if (mousefate == true){
                System.out.println("[Action] mouse-"+myArr[j]+" caught by trap"+"\n");
                deadMouses.add(myArr[j]);
                myArr = removeMouse(myArr, j);
                remainingTraps --;
                mouses --;
            }
        }

        //if (remainingTraps<=mouses){
        //    for (int j=0; j<remainingTraps; j++){
        //        boolean mousefate = rd.nextBoolean();
        //        if (mousefate == true){
        //            System.out.println("[Action] mouse-"+myArr[j]+" caught by trap"+"\n");
        //            deadMouses.add(myArr[j]);
        //            myArr = removeMouse(myArr, j);
        //            remainingTraps --;
        //            mouses --;
        //        }
        //    }
        //} else {
        //    for (int j=0; j<mouses; j++){
        //        boolean mousefate = rd.nextBoolean();
        //        if (mousefate == true){
         //           System.out.println("[Action] mouse-"+myArr[j]+" caught by trap"+"\n");
         //           deadMouses.add(myArr[j]);
         //           myArr = removeMouse(myArr, j);
        //            remainingTraps --;
        //            mouses--;
        //        }
        //    }
        //}
        
        return eatingMouse(mouses, traps, cheese, myArr, index, remainingTraps,deadMouses);
    }

    public static int eatingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, List deadMouses){

        if (cheese <=0 || myArr.length<=0){
            return printStatus(mouses, traps, cheese, myArr, index+1, remainingTraps, deadMouses);
        } else if (cheese<=3 && cheese>0){
            System.out.println("[Action] mouse-"+myArr[0]+" ate "+cheese+" grams of cheese");
            cheese = 0;
            System.out.println("[Status] cheese left: "+cheese+"\n");
            return printStatus(mouses, traps, cheese, myArr, index+1, remainingTraps, deadMouses);
        } else {
            int cheeseIndex = cheese/3;
            for (int j=0; j<Math.min(cheeseIndex, myArr.length);j++){
                System.out.println("[Action] mouse-"+myArr[j]+" ate 3 grams of cheese");
                cheese -= 3;
                System.out.println("[Status] cheese left: "+cheese+"\n");
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
        int min = 6;
        int max_mouses = 15; //setting the range for generating random values

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
        System.out.println(printStatus(x, y, cheese_qty, arr, i, rTraps, dMouses));
        
    }
}
