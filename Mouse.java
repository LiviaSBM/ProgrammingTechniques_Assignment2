//Student Name: Livia Menezes
//Student ID: 261066016

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mouse {

    public static int printStatus(int mouses, int cheese, List mousesList, int index, int remainingTraps, List deadMousesList){
        System.out.println("[Status] cheese left: "+cheese+"\n");
        if (index%5==0){ 
            System.out.println(trapCleaning(mouses, cheese, mousesList, index, remainingTraps, deadMousesList));
        } else if (mouses <= 0 || mousesList.size() <= 0){
            int totalLost = (10 + ((index-1)*5)) - cheese;
            System.out.println("[Status] Total cheese lost = "+totalLost);
            return 0;
        } else if (index%2==0){
            System.out.println("[Action] Cheese Machine add 10 grams of cheese");
            cheese += 10;
            System.out.println("[Status] cheese left: "+cheese+"\n");
        }
        
        return catchingMouse(mouses, cheese, mousesList, index, remainingTraps, deadMousesList);
    }

    public static int catchingMouse(int mouses, int cheese, List mousesList, int index, int remainingTraps, List deadMousesList){
        Random rd = new Random();
        int min= Math.min(remainingTraps,mouses);

        List proxyList = new ArrayList();

        for (int j=0; j<min; j++){
            boolean mousefate = rd.nextBoolean();
            if (mousefate == true){
                System.out.println("[Action] mouse-"+mousesList.get(j)+" caught by trap"+"\n");
                deadMousesList.add(mousesList.get(j));
                //mousesList.remove(j);
                remainingTraps --;
                mouses --;
                //min --;
            } else {
                proxyList.add(mousesList.get(j));
            }
        }
        mousesList = proxyList;
        return eatingMouse(mouses, cheese, mousesList, index, remainingTraps,deadMousesList);
    }

    public static int eatingMouse(int mouses, int cheese, List mousesList, int index, int remainingTraps, List deadMousesList){

        if (cheese <=0 || mousesList.size()<=0){
            return printStatus(mouses, cheese, mousesList, index+1, remainingTraps, deadMousesList);
        } else if (cheese<=3 && cheese>0){
            System.out.println("[Action] mouse-"+mousesList.get(0)+" ate "+cheese+" grams of cheese");
            cheese = 0;
            System.out.println("[Status] cheese left: "+cheese+"\n");
            return printStatus(mouses, cheese, mousesList, index+1, remainingTraps, deadMousesList);
        } else {
            int cheeseIndex = cheese/3;
            cheeseIndex = Math.min(cheeseIndex, mousesList.size());
            for (int j=0; j<cheeseIndex;j++){
                System.out.println("[Action] mouse-"+mousesList.get(j)+" ate 3 grams of cheese");
                cheese -= 3;
                System.out.println("[Status] cheese left: "+cheese+"\n");
            }
            return printStatus(mouses, cheese, mousesList, index+1, remainingTraps, deadMousesList);
        }     
    }

    // public static int[] removeMouse(List mousesList, int index){
    //     int[] proxyArray = new int[myArr.length - 1];
    //     for (int i = 0, k=0; i<myArr.length; i++) { 
    //         if (i == index) { 
    //             continue; 
    //         } 
    //         proxyArray[k++] = myArr[i]; 
    //     }
    //     return proxyArray;
    // }

    public static int trapCleaning (int mouses, int cheese, List mousesList, int index, int remainingTraps, List deadMousesList){
        int removal = deadMousesList.size();
        System.out.println("========================================================");
        for (int j=0; j<removal;j++){
            System.out.println("Store owner remove mouse-"+deadMousesList.get(j));
            remainingTraps ++;
            deadMousesList.remove(0);
        }
        System.out.println("========================================================");

        return eatingMouse(mouses, cheese, mousesList, index, remainingTraps, deadMousesList);

    }

    public static void main(String[] args) {
        List mList = new ArrayList();

        int cheese_qty = 10;
        int x = 5;
        int y=3;
        int i = 1;

        for (int a=0; a<x; a++){
            mList.add(a+1);
        }

        //Random rand = new Random(); //instance of random class
        //int min = 1;
        //int max_mouses = 3; //setting the range for generating random values

        //int x = rand.nextInt(max_mouses-min+1);
        //System.out.println("Quantity of mouses: "+x);

        //Scanner myObj = new Scanner(System.in);
        //System.out.println("Enter the quantity of traps you'd like to try: ");
        //int y = myObj.nextInt();
        //System.out.println("Quantity of traps: "+y);
        
        //System.out.println("Initial quantity of cheese: "+cheese_qty+" grams.");

        //int[] arr = new int[x];

        //for (int a=0; a<x; a++){
        //    arr[a]=(a+1);
            //System.out.println(myArr[a]);
        //}

        List dMousesList = new ArrayList();
        System.out.println(printStatus(x, cheese_qty, mList, i, y, dMousesList));
        
    }
}
