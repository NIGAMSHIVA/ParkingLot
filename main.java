import java.util.Scanner;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int bikeslot[] = new int[5];
        int carslot[] = new int[5];
        
        parking parkingObj = new parking(); 
        while (true) {
            System.out.println("Do you want to park or unpark");
            String ask = sc.nextLine();
            ask = ask.toUpperCase();

            if (ask.equals("PARK")) {
                System.out.println("Please enter Vehicle type");
                String vec = sc.nextLine();
                vec = vec.toUpperCase();
                System.out.println("Please enter Registration Number");
                String RC = sc.nextLine();
                RC = RC.toUpperCase();
                parkingObj.identify(vec, RC, bikeslot, carslot);
            }
            else if (ask.equals("UNPARK")) {
                System.out.println("Enter Registration number which is to be unparked ");
                String RC1 = sc.nextLine();
                RC1 = RC1.toUpperCase();
                parkingObj.unpark(RC1, bikeslot, carslot);
            }
        }
        
    }
}
