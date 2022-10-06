//Student Name: Livia Menezes
//Student ID: 261066016

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mouse {

    //Status method - each round == 1 second
    public static int statusOfMouses(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index, int lostCheese){
        if (index%2==0){ //If even index, add 10g of cheese
            cheese += 10;
            System.out.println("[Action] Cheese Machine add 10 grams of cheese");
        }
        System.out.println("\n[Status] cheese left: "+cheese+"\n"); //printing status of cheese
        
        if (mouses==0 || mouseList.size()==0){ //If there're no more mouses, the program can be finished
            System.out.println("Total cheese lost: "+lostCheese); 
            return 0;
        } else if (index%5==0) { //Every 5 seconds (rounds), owner empties traps
            return trapCleaning(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese);
        } else { //Else, run the next methods of program
            return mouseRemoval(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese);
        }
        
    }

    //Action method for mouses getting caught or not
    public static int mouseRemoval(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index, int lostCheese){
        List proxyList = new ArrayList(); //creating a proxy list
        Random rd = new Random();

        for (int j=0; j<mouseList.size();j++){ //loop for 50% chance of mouse getting caught
            boolean mousefate = rd.nextBoolean(); //random boolean
            if(mousefate==true && traps>0){ //If true, mouse is caught
                System.out.println("[Action] mouse-"+mouseList.get(j)+" get caught by trap\n");
                mouses--; //decrement of qty of mouses
                traps--; //decrement of available traps
                deadMousesList.add(mouseList.get(j));
            } else {
                proxyList.add(mouseList.get(j)); //fulfilling proxy list
            }
        }
        mouseList = proxyList; //replacing current mouse list by proxy list
        return eatingMouse(mouses, traps, cheese, mouseList, deadMousesList, index+1, lostCheese); //calling next method - mouses eating the cheese
    }

    //Action method for cleaning the traps
    public static int trapCleaning(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index, int lostCheese){
        List emptyList = new ArrayList(); //creation of empty list
        System.out.println("========================================================"); //printing pattern
        for (int j=0; j<deadMousesList.size();j++){ //Loop for printing the removal of the mouses from traps
            System.out.println("[Action] Store owner remove mouse-"+deadMousesList.get(j));
            traps ++; //Increment of available traps
        }
        deadMousesList = emptyList; //zeroing out dead mouses list
        System.out.println ("========================================================\n"); //printing pattern
        return mouseRemoval(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese); //returning to next step- mouse removal method
    }

    //Action method for mouses eating cheese
    public static int eatingMouse(int mouses, int traps, int cheese, List mouseList, List deadMousesList, int index, int lostCheese){
        int tempcheese = cheese/3;
        if (cheese <= 0 || mouseList.size()==0){ //If there's no more cheese nor mouses, go for Status method
            return statusOfMouses(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese);
        }  else if (cheese>0 && cheese<=3){ //If there's less than 3g of cheese
            System.out.println("[Action] mouse-"+mouseList.get(0)+" eat "+cheese+" grams of cheese"); //only 1 rat gets to eat it
            lostCheese += cheese;
            cheese = 0; //cheese gets zeroed out
            System.out.println("[Status] cheese left: "+cheese+"\n");
            return statusOfMouses(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese); //Return to Status method
        } else if (cheese>3 && cheese%3==0) { //If there's more than 3g, a qty multiple of 3
            
            for (int j=0; j<Math.min(tempcheese,mouses);j++){ //loop for each rat eeting until cheese's finished or there's no more rats to eat
                System.out.println("[Action] mouse-"+mouseList.get(j)+" eat 3 grams of cheese");
                lostCheese += 3; //increment of lost cheese
                cheese -= 3; //cheese decrement
                System.out.println("[Status] cheese left: "+cheese+"\n");
            }
            return statusOfMouses(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese); //return to Status method

        } else { //Else...
            
            for (int j=0; j<Math.min(tempcheese,mouses);j++){ //loop for each rat eeting until cheese's finished or there's no more rats to eat
                System.out.println("[Action] mouse-"+mouseList.get(j)+" eat 3 grams of cheese");
                lostCheese += 3; //increment of lost cheese
                cheese -= 3; //cheese decrement
                System.out.println("[Status] cheese left: "+cheese+"\n");
                
                if (cheese>0 && cheese<=3 && j<mouseList.size()-1){ //If statement for the last mouse consume the rest of cheese (<3g)
                    System.out.println("[Action] mouse-"+mouseList.get(j+1)+" eat "+cheese+" grams of cheese");
                    lostCheese += cheese;
                    cheese = 0; //cheese decrement
                    System.out.println("[Status] cheese left: "+cheese+"\n");
                }
            }
            return statusOfMouses(mouses, traps, cheese, mouseList, deadMousesList, index, lostCheese);   //return to Status method
        }
    }

    public static void main(String[] args) {
        List mList = new ArrayList(); //List of mouses
        int cheese_qty = 10; //Initial qty of cheese
        int x = 5; //Initial qty of mouses
        int y = 3; //Qty of traps
        int i = 1; //index
        int cheeseL = 0;

        for (int a=0; a<x; a++){ //fulfilling the list of mouse
            mList.add(a+1);
        }

        List deadmList = new ArrayList(); //List of dead mouses
        System.out.println(statusOfMouses(x, y, cheese_qty, mList, deadmList, i, cheeseL)); //calling status method

    }
}
