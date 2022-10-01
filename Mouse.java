//Student Name: Livia Menezes
//Student ID: 261066016
import java.util.Scanner;

public class Mouse {






    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
            System.out.println("Inform the inicial number of mouses:");
            int qty_mouses = myObj.nextInt();
        String[] myArr = new String[qty_mouses];

        for (int a=0; a<qty_mouses; a++){
            myArr[a]="mouse-"+(a+1);
            System.out.println(myArr[a]);
        }
        
    }
}
