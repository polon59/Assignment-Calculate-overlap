/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        String mode = "auto";

        if (args.length > 0){
            mode = "adv";
        }

        Application application = new Application(mode);
        application.launchMainMenu();
    }

    
}