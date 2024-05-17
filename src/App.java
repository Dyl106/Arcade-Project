import java.util.Scanner;
import java.util.Arrays;

public class App
{
    public static void main(String[] args)
    {
        // This is just example code!
        // You will add this to your arcade project (in your sandbox area)
        
        System.out.println("Welcome to the arcade!");
        System.out.println("What game would you like to play?");
        System.out.println("1 - CONNECTIONS");
        System.out.println("2 - TIC TAC TOE");
        System.out.println("3 - TRIVIA");
        System.out.println("4 - QUIT");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("1")) {
            Connections.play();
        }
        
        if (input.equals("2")) {
            TicTacToe TTT = new TicTacToe();
            TTT.play(scanner);
        }
        
        if (input.equals("3")) {
            GameShow fun = new GameShow();
            fun.ready();
            fun.firstQuestion();
            fun.ready();
            fun.secondQuestion();
            fun.ready();
            fun.thirdQuestion();
            fun.ready();
            fun.fourthQuestion();
            fun.ready();
            fun.fifthQuestion();
            fun.ready();
            fun.sixthQuestion();
            fun.finalScore();
        }
        
        if (input.equals("4")) {
            return;
        }
    }
}