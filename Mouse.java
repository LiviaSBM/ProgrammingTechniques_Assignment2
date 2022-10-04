//Student Name: Livia Menezes
//Student ID: 261066016
import java.util.Scanner;
import javax.print.event.PrintEvent;
import java.io.PrintStream;
import java.lang.ref.Cleaner.Cleanable;
import java.util.Random;

public class Mouse {

    public String printStatus(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps){
        
        if (mouses <= 0){
            int totalLost = (10 + (index*5)) - cheese;
            return "Total cheese lost = "+totalLost;
        }

        cheese += 5;
        System.out.println("[Status] cheese left: "+cheese+" g");

        return catchingMouse(mouses, traps, cheese, myArr, index, remainingTraps);
    }

    public int catchingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps){
        Random rd = new Random();
        caughtMouses deadMouses = new caughtMouses();
		
        if (traps<=mouses){
            for (int j=0; j<traps; j++){
                boolean mousefate = rd.nextBoolean();
                if (mousefate == true){
                    System.out.println("mouse-"+myArr[i]+" caught by trap");
                    deadMouses.AddScore(myArr[j]);
                    myArr = removeMouse(myArr, index);
                    remainingTraps --;
                    mouses --;
                }
            }
        } else {
            for (int j=0; j<mouses; j++){
                boolean mousefate = rd.nextBoolean();
                if (mousefate == true){
                    System.out.println("mouse-"+myArr[i]+" caught by trap");
                    deadMouses.AddScore(myArr[j]);
                    myArr = removeMouse(myArr, index);
                    remainingTraps --;
                    mouses--;
                }
            }
        }
        
        return eatingMouse(mouses, traps, cheese, myArr, index, remainingTraps,deadMouses);
    }

    public int eatingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps, int[] deadMouses){
        //PAREI AQUI

        for (int j=0; j<myArr.length;j++){
            if (cheese <=0){
                index++;
                if (index%5==0){
                    System.out.println(trapCleaning(traps, remainingTraps));
                }
                return printStatus(mouses, traps, cheese, myArr, index, remainingTraps);
            } else if (cheese<=3 && cheese>0){
                System.out.println("mouse-"+myArr[j]+" ate "+cheese+" grams of cheese");
                index++;
                if (index%5==0){
                    System.out.println(trapCleaning(traps, remainingTraps));
                }
                cheese = 0;
                return printStatus(mouses, traps, cheese, myArr, index, remainingTraps);
            } else {
                System.out.println("mouse-"+myArr[j]+" ate 3 grams of cheese");
                cheese -= 3;
                return eatingMouse(mouses, traps, cheese, myArr, index, remainingTraps);
            }
        }
    }

    public int removeMouse(int[] myArr, int index){
        int[] proxyArray = new int[myArr.length - 1];
        for (int i = 0, k=0; i<myArr.length; i++) { 
            if (i == index) { 
                continue; 
            } 
            proxyArray[k++] = myArr[i]; 
        }
        return proxyArray;
    }

    public String trapCleaning (int traps, int remainingTraps, int[] deadMouses){
        System.out.println("========================================================");
        for (int j=0; i<deadMouses.length;j++){
            System.out.println("Store owner remove mouse-"+deadMouses[j]);
        }
        return "========================================================";
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

        int[] arr = new int[x];

        for (int a=0; a<x; a++){
            myArr[a]=(a+1);
            //System.out.println(myArr[a]);
        }

        int i = 0;
        int rTraps = y;
        System.out.println(PrintStream(x, y, cheese_qty-5, arr, i, rTraps));
        
    }
}
