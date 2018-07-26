import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

/**
 * Application
 */
public class Application {
    DataInput input = new DataInput();


    public static void main(String[] args) {
        Application app = new Application();
        
        app.calculate();
    }

    public void calculate(){
        int[] coordinates = input.getCoordinatesFromInput();
        int commonSideY, commonSideX;

        // int ax1 = 0;
        // int ay1 = 1;

        // int ax2 = 2;
        // int ay2 = 3;

        // int bx1 = 4;
        // int by1 = 5;

        // int bx2 = 6;
        // int by2 = 7;



        commonSideX = calculateIntersectionLength(coordinates[0],coordinates[2],coordinates[4],coordinates[6]);
        commonSideY = calculateIntersectionLength(coordinates[1],coordinates[3],coordinates[5],coordinates[7]);
        System.out.println(commonSideX + " X");
        System.out.println(commonSideY + " Y");

        System.out.println(commonSideY * commonSideX + " dddd");

    }


    private Integer calculateIntersectionLength(Integer a, Integer b, Integer c, Integer d){


        List<Integer> firstRectSide = new ArrayList<>();
        List<Integer> secondRectSide = new ArrayList<>();
        List<Integer> commons = new ArrayList<Integer>();

        System.out.println("FIRST");
        for(int element = a; element<=b; element++){
            firstRectSide.add(element);
            System.out.println(element);
        }

        System.out.println("SECOND");
        for(int element = c; element<=d; element++){
            secondRectSide.add(element);
            System.out.println(element);
        }
        
        for (Integer pointFromfirstRectSide : firstRectSide) {
            for(Integer pointFromsecondRectSide : secondRectSide){
                if (pointFromfirstRectSide == pointFromsecondRectSide) {
                    commons.add(pointFromfirstRectSide);
                }
            }
        }

        if (commons.isEmpty()){
            return commons.size();
        }
        else{
            return commons.size()-1;
        }

        

        
    }
}