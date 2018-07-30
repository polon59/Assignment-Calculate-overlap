import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

/**
 * DataInput
 */
public class DataInput {

    private int[] convertedCoordinates;
    private String[] splittedUsersCoordinates;
    private String usersCoordinates;

    public DataInput(){
        convertedCoordinates = new int[8];
    }

    public int[] getCoordinatesFromInput() throws NumberFormatException{

        Scanner input = new Scanner(System.in);
        usersCoordinates = input.next();
        
        splitUsersCoordinates();
        convertUsersCoordinatesToInt();

        return convertedCoordinates;
    }


    private void splitUsersCoordinates(){
        splittedUsersCoordinates = usersCoordinates.split(",");
    }


    private void convertUsersCoordinatesToInt() throws NumberFormatException{
        

        for (int i = 0; i < splittedUsersCoordinates.length; i++){
            convertedCoordinates[i] = Integer.valueOf(splittedUsersCoordinates[i]);
        }
    }


    public int getOptionNumber(){

        Scanner usersChoice = new Scanner(System.in);
        // use class wiew
        System.out.println("Select option");
        int option = Integer.MAX_VALUE;

        try {
            option = usersChoice.nextInt();
            usersChoice.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

        return option;
    }

    public int[] getAdvancedInput(){
        Scanner input = new Scanner(System.in);
        int validCoordinates = 0;

        while (validCoordinates < convertedCoordinates.length) {

            try {
                convertedCoordinates[validCoordinates] = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("It must be a number!");
                continue;
            }
            validCoordinates++;
        }
        
        return convertedCoordinates;
    }
}