import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class SoulmateFinder {
     public static void main(String[] args) {
         int StationStart = TravellerNumber("Where did your journey start?");
         int StationEnd = TravellerNumber("Where did your journey end?");
         int size = args.length;
         int soulmatesNumber = 0;
         if (size != 0) {
             for (int i = 0; i < size; i++) {
                 ArrayList<String> start1 = ReadFile(args[i]);
                 //System.out.println(start1.size());
                 for(int x = 0; x<start1.size(); x+=3){
                     //System.out.println(start1.get(x));
                     boolean travellers = overlappingJourneys(StationStart, StationEnd, Integer.valueOf(start1.get(x+1)), Integer.valueOf(start1.get(x+2)));
                     if (travellers ==true){
                         System.out.println(start1.get(x)+ " might be the soulmate.");
                         soulmatesNumber +=1;

                     }
                 }
             }
             System.out.println("Number of potential soulmates: " + soulmatesNumber);

         }else {
             System.out.println("Number of potential soulmates: " + (getTravellers(StationStart, StationEnd)));
         }
     }
    public static ArrayList<String> ReadFile(String filename) {
        int ItemNumber = 0;
        ArrayList<String> Array = null;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            Array = new ArrayList<String>();
            while (myReader.hasNext()) {
                String ArrayItem = myReader.next();
                Array.add(ArrayItem);
                //ItemNumber = Integer.valueOf(ArrayItem);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: " + filename + " not found.");
        }
        return Array;

    }
    public static String TravellerData(String Question) {
        Scanner Data = new Scanner(System.in);
        System.out.println(Question);
        String Traveller = Data.nextLine();

        return Traveller;

    }
    public static int TravellerNumber(String Question) {
        Scanner Data = new Scanner(System.in);
        System.out.println(Question);
        int Traveller = Data.nextInt();
        return Traveller;

    }

    public static boolean overlappingLongJourneys(int start1, int end1, int start2, int end2, int n){
         boolean found = false;
         int overlap = end1 - start2;
         if (overlap>=n ){
             found = true;
         }


return found;
    }

    public static boolean overlappingJourneys(int start1, int end1, int start2, int end2){
        boolean Overlap = false;
        if (start2 < end1){
            Overlap = true;

        }
        return Overlap;


    }

    public static int getTravellers(int start, int end) {
        Scanner TravellerInput = new Scanner(System.in);
        System.out.println("Enter the overall number of travellers on the train: ");
        int NumberOfTravellers = TravellerInput.nextInt();
        int numberOfSoulmates = 0;
        int i = 1;
        while (i <= NumberOfTravellers) {

            String Name = TravellerData("Enter the traveller's name:");

            int Station = TravellerNumber("Enter the boarding station:");

            int exit = TravellerNumber("Enter the exit station:");

            boolean Soulmate = overlappingJourneys(start, end, Station, exit);

            if (Soulmate == true) {
                numberOfSoulmates += 1;
                System.out.println(Name + " might be the soulmate.");

            }else {
                System.out.println(Name + " is not the soulmate.");
            }

            i++;


        }
        return numberOfSoulmates;


    }

}
