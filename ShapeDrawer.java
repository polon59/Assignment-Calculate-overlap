import java.util.HashMap;
import java.util.Map;

/**
 * ShapeDrawer
 */

public class ShapeDrawer {
    private String[][] coordinateSystem;
    private Map<Integer,Integer> indexes;
    private final String ANSI_RESET;
    private final String ANSI_RED;
    private final String ANSI_GREEN;


    public ShapeDrawer(){
        coordinateSystem = new String[25][25];
        indexes = new HashMap<>();
        ANSI_RESET = "\u001B[0m";
        ANSI_RED = "\u001B[31m";
        ANSI_GREEN = "\u001B[32m";
        createIndexesMap();        
    }
    

    private void createIndexesMap(){
        int index = 0;
        int coordinate = 12;

        while (index <= 25){
            indexes.put(coordinate, index);
            index++;
            coordinate--;
        }
    }
    

    public static void main(String[] args) {
        ShapeDrawer shapeDrawer = new ShapeDrawer();
        int[] sampleCoordinates = {-12,-12,12,12,-1,0,3,9};
        shapeDrawer.drawShapes(sampleCoordinates);
    }


    private int createYIndexByCoordinate(int coordinate){
        return indexes.get(coordinate);
    }


    private boolean checkIfPossibleToDraw(int[]coordinates){
        boolean possible = true;

        for (int coordinate : coordinates){
            if (coordinate >12 || coordinate < -12) {
                possible = false;
            }
        }
        return possible;
    }


    public void drawShapes(int[] coordinates){
        if (checkIfPossibleToDraw(coordinates)) {
            int[] firstSquare = {coordinates[0],coordinates[1],coordinates[2],coordinates[3]};
            int[] secondSquare = {coordinates[4],coordinates[5],coordinates[6],coordinates[7]};
            createCoordinateSystem();
            drawSingleShape(firstSquare,1);
            drawSingleShape(secondSquare,2);
            printCoordinateSystem();
        }
        else{
            System.out.println("I cannot draw shapes with theese coordinates. (max val = 12, min val = -12)");
        }
    }


    private void drawSingleShape(int[] shapeCoordinates, int colorID){
        int minX, minY, maxX, maxY;
        String color;

        if (colorID == 1){
            color = ANSI_GREEN;
        }
        else{
            color = ANSI_RED;
        }

        minX = shapeCoordinates[0]+12;
        maxX = shapeCoordinates[2]+12;
        minY = createYIndexByCoordinate(shapeCoordinates[1]);
        maxY = createYIndexByCoordinate(shapeCoordinates[3]);

        if (maxY > 12){
            coordinateSystem[minY][minX] = color+"─┐"+ANSI_RESET;
            coordinateSystem[maxY][maxX] = color+" └"+ANSI_RESET;
            coordinateSystem[maxY][minX] = color+"─┘"+ANSI_RESET;
            coordinateSystem[minY][maxX] = color+" ┌"+ANSI_RESET;
        }

        else{
            coordinateSystem[minY][minX] = color+" └"+ANSI_RESET;
            coordinateSystem[maxY][maxX] = color+"─┐"+ANSI_RESET;
            coordinateSystem[maxY][minX] = color+" ┌"+ANSI_RESET;
            coordinateSystem[minY][maxX] = color+"─┘"+ANSI_RESET;
        }

        for (int yIndex = 0; yIndex < coordinateSystem.length; yIndex++){
            for (int xIndex = 0; xIndex<coordinateSystem[yIndex].length; xIndex++){
                if(yIndex != 12 && xIndex != 12){
                    if((yIndex == maxY && xIndex > maxX && xIndex < minX )|| (yIndex == minY && xIndex > maxX && xIndex < minX)){
                        coordinateSystem[yIndex][xIndex] = color+"──"+ANSI_RESET;
                    }
                    else if((xIndex == maxX && yIndex < maxY && yIndex > minY )|| (xIndex == minX && yIndex < maxY && yIndex > minY)){
                        coordinateSystem[yIndex][xIndex] = color+" │"+ANSI_RESET;
                    }
                    else if((xIndex == maxX && yIndex > maxY && yIndex < minY )|| (xIndex == minX && yIndex > maxY && yIndex < minY)){
                        coordinateSystem[yIndex][xIndex] = color+" │"+ANSI_RESET;
                    }
                    else if((yIndex == maxY && xIndex < maxX && xIndex > minX )|| (yIndex == minY && xIndex < maxX && xIndex > minX)){
                        coordinateSystem[yIndex][xIndex] = color+"──"+ANSI_RESET;
                    }
                }
            }
        }
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