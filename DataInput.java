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
        input.close();
        splitUsersCoordinates();
        convertUsersCoordinatesToInt();

        return convertedCoordinates;

    }

    private void splitUsersCoordinates(){
        splittedUsersCoordinates = usersCoordinates.split(",");

        for (String element : splittedUsersCoordinates){
            System.out.println(element);
        }
    }

    private void convertUsersCoordinatesToInt(){
        convertedCoordinates = new int[8];

        for (int i = 0; i < splittedUsersCoordinates.length; i++){
            convertedCoordinates[i] = Integer.valueOf(splittedUsersCoordinates[i]);
        }

        for (int number : convertedCoordinates){
            System.out.println(number);
        }
    }
}