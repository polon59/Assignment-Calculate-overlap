
public class Display {

    int[] coordinatesDisplay;
    
    public Display(){
        coordinatesDisplay = new int[8];
    }


    private void setInitialCoordinatesValues(){
        int i = 0;

        while(i < coordinatesDisplay.length){
            coordinatesDisplay[i] = "x =   ,";
            i++;
            coordinatesDisplay[i] = "y =    ";
        }
    }

    private void resetIndexesColors(){
        
    }


    public void displayCoordinatesImage(int currentIndex){
        coordinatesDisplay[currentIndex] = 
        System.out.println();
    }
}