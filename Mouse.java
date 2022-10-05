//Student Name: Livia Menezes
//Student ID: 261066016

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mouse {

    public static int statusOfMouses(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index){
        System.out.println("Seconds: "+index);
        System.out.println("[MAIN Status] cheese left: "+cheese);
        System.out.println("Qty of mouses: "+mouses);
        System.out.println("List of mouses: "+mouseList);
        System.out.println("List of dead mouses on traps: "+deadMousesList);
        System.out.println("Qty of remaining traps: "+traps);

        if (mouses==0 || mouseList.size()==0){
            int cheeselost = (index-1)*5-cheese;
            System.out.println("Total cheese lost: "+cheeselost);
            return 0;
        } else if (index%5==0) {
            return trapCleaning(mouses, traps, cheese, mouseList, deadMousesList, index);
        } else {
            return mouseRemoval(mouses, traps, cheese, mouseList, deadMousesList, index);
        }
        
    }

    public static int mouseRemoval(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index){
        List proxyList = new ArrayList();
        Random rd = new Random();

        for (int j=0; j<mouseList.size();j++){
            boolean mousefate = rd.nextBoolean();
            if(mousefate==true && traps>0){
                System.out.println("[Action] mouse-"+mouseList.get(j)+" get caught\n");
                mouses--;
                traps--;
                deadMousesList.add(mouseList.get(j));
            } else {
                proxyList.add(mouseList.get(j));
            }
        }
        mouseList = proxyList;
        return eatingMouse(mouses, traps, cheese, mouseList, deadMousesList, index+1);
    }

    public static int trapCleaning(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index){
        List emptyList = new ArrayList();
        System.out.println("========================================================");
        for (int j=0; j<deadMousesList.size();j++){
            System.out.println("[Action] Store owner remove mouse-"+deadMousesList.get(j));
            traps ++;
        }
        deadMousesList = emptyList;
        System.out.println("========================================================\n");
        return mouseRemoval(mouses, traps, cheese, mouseList, deadMousesList, index);
    }

    public static int eatingMouse(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index){
        if (cheese <= 0){
            return statusOfMouses(mouses, traps, cheese, mouseList, deadMousesList, index);
        }  else if (cheese>0&&cheese<=3){
            System.out.println("[Action] mouse-"+mouseList.get(0)+" eat "+cheese+" grams of cheese");
            System.out.println("[Status] cheese left: "+cheese+"\n");
            cheese = 0;
            return statusOfMouses(mouses, traps, cheese, mouseList, deadMousesList, index);
        } else {
            int tempcheese = cheese/3;
            for (int j=0; j<Math.min(tempcheese,mouses);j++){
                System.out.println("[Action] mouse-"+mouseList.get(j)+" eat 3 grams of cheese");
                System.out.println("[Status] cheese left: "+cheese+"\n");
            }
            cheese -= (tempcheese*3);
            return eatingMouse(mouses, traps, tempcheese, mouseList, deadMousesList, index);
        }
    }



    public static void main(String[] args) {
        List mList = new ArrayList();
        int cheese_qty = 10;
        int x = 8;
        int y=5;
        int i = 1;

        for (int a=0; a<x; a++){
            mList.add(a+1);
        }

        List deadmList = new ArrayList();
        System.out.println(statusOfMouses(x, y, cheese_qty, mList, deadmList, i));

    }
}
