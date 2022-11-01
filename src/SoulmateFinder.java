import java.util.Scanner;
public class SoulmateFinder {
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
        int i = 0;
        boolean found = false;
        while (i <= NumberOfTravellers && found == false) {

            String Name = TravellerData("Enter the traveller's name:");

            int Station = TravellerNumber("Enter the boarding station:");

            int exit = TravellerNumber("Enter the exit station:");

            boolean Soulmate = overlappingJourneys(start, end, Station, exit);

            if (Soulmate == true) {
                numberOfSoulmates += 1;
                System.out.println(Name + " might be the soulmate.");

            }else {
                System.out.println(Name + " is not the soulmate.");
                found = true;
            }

            i++;


        }
        return numberOfSoulmates;


    }

}
