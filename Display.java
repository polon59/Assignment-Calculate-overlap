
public class Display {

    private String[] coordinatesDisplay;
    private int[] coordinatesValues;
    private final String ANSI_RESET;
    private final String ANSI_BLACK;
    private final String ANSI_RED;
    private final String ANSI_GREEN;
    private final String ANSI_CYAN;
    
    
    public Display(){
        coordinatesDisplay = new String[8];
        ANSI_RESET = "\u001B[0m";
        ANSI_BLACK = "\u001B[30m";
        ANSI_RED = "\u001B[31m";
        ANSI_GREEN = "\u001B[32m";
        ANSI_CYAN = "\u001B[36m";
        setInitialCoordinatesValues();
        
    }


    private void setInitialCoordinatesValues(){
        int i = 0;

        while(i < coordinatesDisplay.length){
            coordinatesDisplay[i] = ANSI_BLACK + "-- " + ANSI_RESET;
            i++;

            // if (i<7){
            //     coordinatesDisplay[i] = ANSI_BLACK + "y =    " + ANSI_RESET;
            // }
            
        }
    }

    private void resetIndexesColors(int currentIndex){
        // for (String coordinate : coordinatesDisplay) {
        //     if (!(coordinate.equals("x =   ,"))|| !(coordinate.equals("y =    "))) {
        //         coordinate = ANSI_GREEN + coordinatesValues[currentIndex]+ ANSI_RESET;
        //     }
        if (currentIndex != 0){
            coordinatesDisplay[currentIndex-1] = ANSI_GREEN + coordinatesValues[currentIndex-1] + ANSI_RESET;
        }
        
        //}
        // for (int number : coordinatesValues){
        //     System.out.println(number);
        // }
        // System.out.println("==========");
        // for (String symbol : coordinatesDisplay){
        //     System.out.println(symbol);
        // }
    }


    public void displayCoordinatesImage(int currentIndex, int[] convertedCoordinates){
        StringBuilder squareImage = new StringBuilder();
        this.coordinatesValues = convertedCoordinates;
        resetIndexesColors(currentIndex);
        coordinatesDisplay[currentIndex] = ANSI_CYAN + "__" + ANSI_RESET;
        System.out.println("Current " + currentIndex);

        squareImage.append("                   ");
        squareImage.append(coordinatesDisplay[2]);
        squareImage.append(ANSI_BLACK + "," + ANSI_RESET);
        squareImage.append(coordinatesDisplay[3]);
        squareImage.append("\n");
        squareImage.append(ANSI_GREEN);
        squareImage.append("   ┌────────────────────┐\n");
        squareImage.append("   │                    │\n   │                    │\n");
        squareImage.append("   │                    │\n   │                    │\n");
        squareImage.append("   └────────────────────┘\n ");
        squareImage.append(ANSI_RESET);
        squareImage.append("  ");
        squareImage.append(coordinatesDisplay[0]);
        squareImage.append(ANSI_BLACK + "," + ANSI_RESET);
        squareImage.append(coordinatesDisplay[1]);
        squareImage.append("\n\n\n");

        squareImage.append("                   ");
        squareImage.append(coordinatesDisplay[6]);
        squareImage.append(ANSI_BLACK + "," + ANSI_RESET);
        squareImage.append(coordinatesDisplay[7]);
        squareImage.append("\n");
        squareImage.append(ANSI_RED);
        squareImage.append("   ┌────────────────────┐\n");
        squareImage.append("   │                    │\n   │                    │\n");
        squareImage.append("   │                    │\n   │                    │\n");
        squareImage.append("   │                    │\n   │                    │\n");
        squareImage.append("   └────────────────────┘\n ");
        squareImage.append(ANSI_RESET);
        squareImage.append("  ");
        squareImage.append(coordinatesDisplay[4]);
        squareImage.append(ANSI_BLACK + "," + ANSI_RESET);
        squareImage.append(coordinatesDisplay[5]);

        System.out.print("\033[H\033[2J");
        System.out.println(squareImage.toString());
        

    }
}