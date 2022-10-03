//Student Name: Livia Menezes
//Student ID: 261066016
import java.util.Scanner;
import javax.print.event.PrintEvent;
import java.io.PrintStream;
import java.util.Random;

public class Mouse {

    public int printStatus(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps){
        System.out.println("[Status] cheese left: "+cheese+" g");

        //FAZER IF I%5==0, LIMPAR AS TRAPS



        //RATO SENDO PEGO

        //RATO COMENDO
    }

    public int catchingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps){
        Random rd = new Random();
        if (traps<=mouses){
            for (int j=0; j<traps; j++){
                boolean mousefate = rd.nextBoolean();
                if (mousefate == true){
                    System.out.println("mouse-"+myArr[i]+" caught by trap");
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
                    myArr = removeMouse(myArr, index);
                    remainingTraps --;
                    mouses--;
                }
            }
        }
        
        return //MÉTODO DO RATO COMENDO
    }

    public int eatingMouse(int mouses, int traps, int cheese, int[] myArr, int index, int remainingTraps){
        //PAREI AQUI

        for (int j=0; j<myArr.length;j++){
            if (cheese<=3 && cheese>0){
                System.out.println("mouse-"+myArr[j]+" ate "+cheese+" grams of cheese");
                cheese = 0;
                break;
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
        System.out.println(PrintStream(x, y, cheese_qty, arr, i, rTraps));
        
    }
}
