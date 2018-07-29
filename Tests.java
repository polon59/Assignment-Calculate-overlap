/**
 * Tests
 */
public class Tests {
    private Calculations calculations;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\u001B[30m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public Tests(Calculations calculations){
        this.calculations = calculations;
    }


    public void handleTests(){
        int[] firstTestCoordinates = {-1,-1,10,10,-1,0,3,9};
        int firstExpectedOutput = 36;
        int[] secondTestCoordinates = {-12,-4,-1,-2,0,0,100,3000};
        int secondExpectedOutput = 0;
        
        handleTest(firstTestCoordinates,firstExpectedOutput,1);
        handleTest(secondTestCoordinates, secondExpectedOutput, 2);
    }


    private void handleTest(int[] testCoordinates, int expectedOutput, int testNumber){
        
        int output = calculations.countIntersectionArea(testCoordinates);
        displayTestResult(expectedOutput, output, testNumber);
    
    }


    private void displayTestResult(int expectedOutput, int output, int testNumber){
        System.out.println("\n"+ ANSI_BLACK + "TEST " + testNumber + "\n expected output - "+ANSI_RESET + ANSI_CYAN + expectedOutput + ANSI_RESET);
        System.out.println(ANSI_BLACK + "recieved output - " +ANSI_RESET + ANSI_CYAN + output + ANSI_RESET);
        if (expectedOutput == output){
            System.out.println(ANSI_GREEN + "RESULT: PASSED ✅" + ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED + "RESULT: FAILED ⛔ " + ANSI_RESET);
        }
        System.out.println("\n");
    }

}