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
    private ShapeDrawer shapeDrawer;
    private Tests test;
    private String mode;


    public Application(String mode){
        this.mode = mode;
        input = new DataInput();
        calculations = new Calculations();
        shapeDrawer = new ShapeDrawer();
        test = new Tests(calculations);
    }


    public void launchMainMenu() {
        int currentOption = Integer.MAX_VALUE;

        while (currentOption != 0) {

            System.out.println("1 - perform calc., 2 - test, 0 - exit");
            if (mode == "adv"){
                System.out.println("advanced mode");
            }else{
                System.out.println("auto mode");
            }

            currentOption = input.getOptionNumber();

            switch (currentOption) {
                case 1:
                    Display.clearScreen(); 
                    performCalculation();
                    break;

                case 2:
                    Display.clearScreen();
                    test.handleTests();
                    break;
            
                default:
                    break;
            }
        }
        
    }

    private void performCalculation(){
        int area;
        int[] coordinates;

        try {
            if (mode == "auto"){
                coordinates = input.getCoordinatesFromInput();
            }
            else{
                coordinates = input.getAdvancedInput();
            }
            
            area = calculations.countIntersectionArea(coordinates);
            shapeDrawer.drawShapes(coordinates);
            calculations.checkIfOverlap(area);
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format");
        }
    }


    
}