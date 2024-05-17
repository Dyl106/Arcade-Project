import java.util.Scanner;
public class GameShow {
    private final int AMOUNT_QUESTIONS = 6;
    
    private int score;
    
    public GameShow(){
        score = 0;
    }
    
    public void score(boolean answerCorrect) {

        if (answerCorrect == true) {
            score = score + 1;
            System.out.println("Correct! You gained 1 point! Your score is now " + score);
        } else {
            System.out.println("Incorrect! You didn't gain any points ");
        }
    }
    
    public void ready() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Are you ready for the question? ");
            String firstReady = scanner.nextLine();
            boolean myBool = firstReady.equalsIgnoreCase("Yes");
            if (myBool) 
                break;
            else 
                continue;
        }    
    }
    
    public void firstQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many states are in America? ");
        int firstQuestion = scanner.nextInt();
        boolean gotFirstCorrect = firstQuestion == 50;
        score(gotFirstCorrect);
    }
    
    public void secondQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Washington D.C. a state? ");
        String secondQuestion = scanner.nextLine();
        boolean gotSecondCorrect = secondQuestion.equalsIgnoreCase("No");
        score(gotSecondCorrect);
    }
    
    public void thirdQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the biggest country in the world? ");
        String thirdQuestion = scanner.nextLine();
        boolean gotThirdCorrect = thirdQuestion.equalsIgnoreCase("Russia");
        score(gotThirdCorrect);
    }
    
    public void fourthQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the least populated continent? ");
        String fourthQuestion = scanner.nextLine();
        boolean gotFourthCorrect = fourthQuestion.equalsIgnoreCase("Antarctica");
        score(gotFourthCorrect);
    }
    
    public void fifthQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the population of the US (Round to the nearest million) ");
        int fifthQuestion = scanner.nextInt();
        boolean gotFifthCorrect = fifthQuestion == 334000000;
        score(gotFifthCorrect);
    }
    
    public void sixthQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many oceans are there? ");
        int sixthQuestion = scanner.nextInt();
        boolean gotSixthCorrect = sixthQuestion == 4;
        score(gotSixthCorrect);
    }
    
    public void finalScore() {
        double percentage = (double) score / AMOUNT_QUESTIONS * 100;
        double percentRounded = Math.round(percentage * 100.0) / 100.0;
        System.out.println("Congratulations, you got " + score + " out of "+ AMOUNT_QUESTIONS +" correct and scored " + percentRounded + "%");
    }
    
    
}