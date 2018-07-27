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
    DataInput input = new DataInput();



    public void launchMainMenu() {
        int currentOption = Integer.MAX_VALUE;

        while (currentOption != 0) {
            System.out.println("1 - perform calc,, 2 - test, 0 - exit");
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
        area = countIntersectionArea(coordinates);
        checkIfOverlap(area);
    }


    private void checkIfOverlap(int area) {
        if (area == 0){
            System.out.println("Theese rectangles have no overlapping area.");
        }
        else{
            System.out.println("Overlapping area = " + area);
        }
    }


    private int countIntersectionArea(int[] coordinates){
        int commonSideY, commonSideX, area;
        commonSideX = calculateSideLength(coordinates[0],coordinates[2],coordinates[4],coordinates[6]);
        commonSideY = calculateSideLength(coordinates[1],coordinates[3],coordinates[5],coordinates[7]);
        area = commonSideX * commonSideY;
        return area;
    }


    private List<Integer> findCommonCoordinates(List<Integer> firstRectSide, List<Integer> secondRectSide){
        List<Integer> commons = new ArrayList<Integer>();

        for (Integer pointFromfirstRectSide : firstRectSide) {
            for(Integer pointFromsecondRectSide : secondRectSide){
                if (pointFromfirstRectSide == pointFromsecondRectSide) {
                    commons.add(pointFromfirstRectSide);
                }
            }
        }
        return commons;
    }


    private Integer calculateSideLength(Integer a, Integer b, Integer c, Integer d){

        List<Integer> firstRectSide = new ArrayList<>();
        List<Integer> secondRectSide = new ArrayList<>();
        List<Integer> commons = new ArrayList<Integer>();

        for(int element = a; element<=b; element++){
            firstRectSide.add(element);
        }

        for(int element = c; element<=d; element++){
            secondRectSide.add(element);
        }
        
        commons = findCommonCoordinates(firstRectSide, secondRectSide);

        if (commons.isEmpty()){
            return commons.size();
        }

        return commons.size()-1;
    }
}