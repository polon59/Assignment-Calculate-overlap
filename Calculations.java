import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Calculations
 */
public class Calculations {

    public void checkIfOverlap(int area) {
        if (area == 0){
            System.out.println("Theese rectangles have no overlapping area.");
        }
        else{
            System.out.println("Overlapping area = " + area);
        }
    }


    public int countIntersectionArea(int[] coordinates){
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