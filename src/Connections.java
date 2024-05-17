import java.util.Scanner;
import java.util.Arrays;

public class Connections {
    private static final String[] currentWords = {"BARK", "GROWL", "HOWL", "WHINE", "ARM", "BRANCH", "CHAPTER", "WING", "CRADLE", "FONT", "ROOT", "SOURCE", "CLUE", "FROWN", "MELLOW", "PREEN"};
    private static final String GUESSED = "-----";
    private static final String[] group1 = {"BARK", "GROWL", "HOWL", "WHINE"}; // sorted!
    private static final String[] group2 = {"ARM", "BRANCH", "CHAPTER", "WING"}; // sorted!
    private static final String[] group3 = {"CRADLE", "FONT", "ROOT", "SOURCE"}; // sorted!
    private static final String[] group4 = {"CLUE", "FROWN", "MELLOW", "PREEN"}; // sorted!
    private static Scanner scanner = new Scanner(System.in);
    
    public static void play() {
        System.out.println("\n" + "Welcome to Connections!" + "\n");
        shuffleArray(currentWords);
        // printArrayOnThreeLines(currentWords);
        while (!allStringsMatch(currentWords, GUESSED)) {
            printArrayOnThreeLines(currentWords);
            String guesses[] = getGuesses();
                
            if (checkIfGroup(guesses)) {
                updateCurrentWords(currentWords, guesses);
            }
            else {
                System.out.println("Incorrect, try again!" + "\n");
                continue;
            }
        }
        System.out.println("Congrats, you won!");
    }
    
    private static boolean allStringsMatch(String[] array, String target) {
        for (String str : array) {
            if (!str.equals(target)) {
                return false;
            }
        }
        return true;
    }
    
    private static void updateCurrentWords(String[] currentWords, String[] groupToRemove) {
        for (String word : groupToRemove) {
            for (int i = 0;i< currentWords.length; i++) {
                if (currentWords[i].equals(word)) {
                    currentWords[i] = GUESSED;
                    break;
                } 
            }
        }
    }
    
    private static String[] getGuesses() {
        String[] userGroup;
        while ( true ) {
            System.out.println("\n" + "Enter your three guesses with a space in between: " + "\n");
            String userInput = scanner.nextLine();
            System.out.println();
            userGroup = userInput.split(" ");
            if ( userGroup.length != 4 ) {
                System.out.println("Invalid input. You must enter three words.");
            }
            else {
                break;
            }
        }
        return userGroup;
    }
    
    private static boolean checkIfGroup(String[] guesses) {
    
        for(int i = 0; i<4; i++) {
            guesses[i] = guesses[i].toUpperCase();
        }

        //check if equal
        Arrays.sort(guesses);
        if (Arrays.equals(guesses, group1)) {
            return true;
        }
        if (Arrays.equals(guesses, group2)) {
            return true;
        }
        if (Arrays.equals(guesses, group3)) {
            return true;
        }
        
        if (Arrays.equals(guesses, group4)) {
            return true;
        }
        
        return false;
    }
    
    private static void shuffleArray(String[] array) {
        for (int i=0; i<array.length; i++){
            int random= (int)(Math.random()*array.length);
            String temp= array[random];
            array[random]= array[i];
            array[i]= temp;
        }
    }
    
    private static void printArrayOnThreeLines(String[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
            if(i % 4 == 3) {
                System.out.println();
            } 
        }
    }
}