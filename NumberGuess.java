import java.util.*;

public class NumberGuess {
    static ArrayList<String> scoreBoard = new ArrayList<String>();
    public static void main(String[] args) {
        NumberGuess methodChange = new NumberGuess();
        methodChange.menu(scoreBoard);
    }
    public void menu(ArrayList<String> scoreBoard) {
        NumberGuess methodChange = new NumberGuess();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("Select the option from the above actions: ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"Enter the Upper Boundary for Range to Guess: ");
                    int numberRange = input.nextInt();
                    
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber,numberRange);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("Thanks for playing the game!\n");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry. Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber, int numberRange) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        System.out.println();
        do {
            System.out.print("Guess the Number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("The Number is Lower Than Your Guess!!!");
            } else if (userGuess < randomNumber) {
                System.out.println("The Number is Higher Than Your Guess!!!");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You win! You in " + guess + "st try");
        } else {
            System.out.println("You win! You tried " + guess + " time(s) total");
        }
        String data= guess+" tries of range 1 to "+ numberRange;
        scoreBoard.add(data);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        Collections.sort(scoreBoard);
        for (String scores : scoreBoard) {
            System.out.println("Finished the game in " + scores );
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}