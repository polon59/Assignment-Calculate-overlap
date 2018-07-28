import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

/**
 * Application
 * -1,-1,10,10,-1,0,3,9
 * 
 * -12,-4,-1,-2,0,0,100,3000
 */
public class Application {
    private DataInput input;
    private Calculations calculations;


    public Application(){
        input = new DataInput();
        calculations = new Calculations();
    }


    public void launchMainMenu() {
        int currentOption = Integer.MAX_VALUE;

        while (currentOption != 0) {
            
            System.out.println("1 - perform calc,, 2 - test, 0 - exit");
            currentOption = input.getOptionNumber();

            switch (currentOption) {
                case 1:
                    performCalculation();
                    break;

                case 2:
                    
                    break;
            
                default:
                    break;
            }
        }
        
    }

    private void performCalculation(){
        int area;
        int[] coordinates = input.getCoordinatesFromInput();
        area = calculations.countIntersectionArea(coordinates);
        calculations.checkIfOverlap(area);
    }


    
}