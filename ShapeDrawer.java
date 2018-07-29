import java.util.HashMap;
import java.util.Map;

/**
 * ShapeDrawer
 */

public class ShapeDrawer {
    String[][] coordinateSystem = new String[25][25];
    Map<Integer,Integer> indexes = createIndexesMap();




    private Map<Integer,Integer> createIndexesMap(){
        Map<Integer,Integer> indexes = new HashMap<>();
        indexes.put(12, 0);
        indexes.put(11, 1);
        indexes.put(10, 2);
        indexes.put(9, 3);
        indexes.put(8, 4);
        indexes.put(7, 5);
        indexes.put(6, 6);
        indexes.put(5, 7);
        indexes.put(4, 8);
        indexes.put(3, 9);
        indexes.put(2, 10);
        indexes.put(1, 11);
        indexes.put(0, 12);
        indexes.put(-1, 13);
        indexes.put(-2, 14);
        indexes.put(-3, 15);
        indexes.put(-4, 16);
        indexes.put(-5, 17);
        indexes.put(-6, 18);
        indexes.put(-7, 19);
        indexes.put(-8, 20);
        indexes.put(-9, 21);
        indexes.put(-10, 22);
        indexes.put(-11, 23);
        indexes.put(-12, 24);
        return indexes;
    }
    

    public static void main(String[] args) {
        ShapeDrawer shapeDrawer = new ShapeDrawer();
        int[] sampleCoordinates = {-2,-2,-4,-4,-1,0,3,9};
        shapeDrawer.drawShapes(sampleCoordinates);


    }

    public int createYIndexByCoordinate(int coordinate){

        return indexes.get(coordinate);
    }

    public void drawShapes(int[] coordinates){
        int[] firstSquare = {coordinates[0],coordinates[1],coordinates[2],coordinates[3]};
        int[] secondSquare = {coordinates[4],coordinates[5],coordinates[6],coordinates[7]};
        createCoordinateSystem();
        drawSingleShape(firstSquare);
        //drawSingleShape(secondSquare);
        printCoordinateSystem();
    }


    private void drawSingleShape(int[] shapeCoordinates){
        int minX, minY, maxX, maxY;
        minX = shapeCoordinates[0]+12;
        maxX = shapeCoordinates[2]+12;
        minY = createYIndexByCoordinate(shapeCoordinates[1]);
        maxY = createYIndexByCoordinate(shapeCoordinates[3]);

        coordinateSystem[minY][minX] = "─┐";
        coordinateSystem[maxY][maxX] = " └";
        coordinateSystem[maxY][minX] = "─┘";
        coordinateSystem[minY][maxX] = " ┌";

        for (int yIndex = 0; yIndex < coordinateSystem.length; yIndex++){
            for (int xIndex = 0; xIndex<coordinateSystem[yIndex].length; xIndex++){
                if((yIndex == maxY && xIndex > maxX && xIndex < minX )|| (yIndex == minY && xIndex > maxX && xIndex < minX)){
                    coordinateSystem[yIndex][xIndex] = "──";
                }
                else if((xIndex == maxX && yIndex < maxY && yIndex > minY )|| (xIndex == minX && yIndex < maxY && yIndex > minY)){
                    coordinateSystem[yIndex][xIndex] = " │";
                }

            }
        }
        System.out.println(maxX);
        System.out.println(maxY);

    }

    private String createIcon(int index, boolean reverse){
        String[] coordinatesIcons = {" ⑫"," ⑪"," ⑩"," ⓽"," ⓼"," ⓻"," ⓺"," ⓹"," ⓸"," ⓷"," ⓶"," ⓵"," ⓪","-⓵","-⓶","-⓷","-⓸","-⓹","-⓺","-⓻","-⓼","-⓽","-⑩","-⑪","-⑫"};
        if (reverse){
            return coordinatesIcons[coordinatesIcons.length - index -1];
        }
        else{
            return coordinatesIcons[index];
        }
    }


    private String findSquareValueByIndex(int xIndex, int yIndex){
        String currentSquareValue;
        if (yIndex == 12 && xIndex == 12){
            currentSquareValue = createIcon(12,false);
        }

        else if (yIndex == 12){
            currentSquareValue = createIcon(xIndex,true);               
        }

        else if (xIndex == 12){
            currentSquareValue = createIcon(yIndex,false);     
        }
        else{
            currentSquareValue = "  ";
        }


        return currentSquareValue;
    }



    public void createCoordinateSystem(){

        for (int yIndex = 0; yIndex < coordinateSystem.length; yIndex++){
            for (int xIndex = 0; xIndex<coordinateSystem[yIndex].length; xIndex++){
                coordinateSystem[yIndex][xIndex] = findSquareValueByIndex(xIndex, yIndex);
            }
        }
    }

    public void printCoordinateSystem(){
        for (int yIndex = 0; yIndex < coordinateSystem.length; yIndex++){
            for (int xIndex = 0; xIndex<coordinateSystem[yIndex].length; xIndex++){
                System.out.print(coordinateSystem[yIndex][xIndex]);
            }
            System.out.print("\n");
        }
    }
}