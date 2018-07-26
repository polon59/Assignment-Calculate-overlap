import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

/**
 * Application
 */
public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.calculate();
    }

    public void calculate(){

        int ax1 = 2;
        int ay1 = 5;

        int ax2 = 5;
        int ay2 = 9;

        int bx1 = -3;
        int by1 = 2;

        int bx2 = 8;
        int by2 = 11;



        Integer commonSideX = calculateIntersectionLength(ax1,ax2,bx1,bx2);
        Integer commonSideY = calculateIntersectionLength(ay1,ay2,by1,by2);
        System.out.println(commonSideX + " X");
        System.out.println(commonSideY + " Y");

        System.out.println(commonSideY * commonSideX + " dddd");

    }


    private Integer calculateIntersectionLength(Integer a, Integer b, Integer c, Integer d){
                                                //   5,         -2          8,           2


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