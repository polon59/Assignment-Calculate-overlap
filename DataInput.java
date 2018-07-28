import java.util.Scanner;

/**
 * DataInput
 */
public class DataInput {

    private int[] convertedCoordinates;
    private String[] splittedUsersCoordinates;
    private String usersCoordinates;


    public int[] getCoordinatesFromInput(){

        Scanner input = new Scanner(System.in);
        usersCoordinates = input.next();
        
        splitUsersCoordinates();
        convertUsersCoordinatesToInt();


        return convertedCoordinates;
    }


    private void splitUsersCoordinates(){

        splittedUsersCoordinates = usersCoordinates.split(",");
    }


    private void convertUsersCoordinatesToInt(){

        convertedCoordinates = new int[8];

        for (int i = 0; i < splittedUsersCoordinates.length; i++){
            convertedCoordinates[i] = Integer.valueOf(splittedUsersCoordinates[i]);
        }
    }


    public int getOptionNumber(){

        Scanner usersChoice = new Scanner(System.in);
        // use class wiew
        System.out.println("Select option");

        int option = usersChoice.nextInt();
        usersChoice.nextLine();

        return option;
    }
}