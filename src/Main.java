import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void displayTime(){

        LocalDateTime time1 = LocalDateTime.now();   // to print today's date and time
        DateTimeFormatter form1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter form2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Hello! Today is: " + time1.format(form1) + ". Current time is: " + time1.format(form2) + "\n");

    }

    public static Player createPlayer(Scanner scan1){

        System.out.print("\nPlayer 2 enter your name and surname, please: ");  // asking for the second players name and surname
        String name = scan1.next();
        String surname = scan1.next();

        Player pl2 = new Player (name, surname, 0);  // creating second player

        System.out.println("\nHello! " + pl2.getName() + " " + pl2.getSurname() + ", you are Player 2 to " +
                "play the game of dices");

        return pl2;
    }

    public static Game createGame(Scanner scan2){

        System.out.print("\nPlease, enter how many tries you want to do: ");  // asking for tries of the game
        int tryCount = scan2.nextInt();
        System.out.print("\nPlease, enter how many dices you want to show: ");
        int diceNumber = scan2.nextInt();

        Game game2 = new Game(tryCount, diceNumber);  // creating new game

        System.out.println("\nThe game will consists of " + game2.getTryCount() + " tries, with "
                + game2.getDiceNumber() + " dices.");

        return game2;
    }

    public static ArrayList<Integer> askTargets(Scanner scan3){

        ArrayList<Integer> targets = new ArrayList<>();

        System.out.print("\nPlayer1 give your target digit, please: ");  // asking for a target digit from player1
        int player1Numb = scan3.nextInt();  // 1st player target digit
        targets.add(player1Numb);

        System.out.print("\nPlayer2 give your target digit, please: ");  // asking for a target digit from player2
        int player2Numb = scan3.nextInt();  // 2nd player target digit
        targets.add(player2Numb);

        return targets;
    }

    public static void printWinner(Player pl1, Player pl2){

        if(pl1.getPoints() > pl2.getPoints()) {  // checking points
            System.out.println("\n" + pl1.getName() + " has got " + pl1.getPoints() + " point(s), he wins!");

        } else if (pl1.getPoints() < pl2.getPoints()) {
            System.out.println("\n" + pl2.getName() + " has got " + pl2.getPoints() + " point(s), he wins!");

        } else {
            System.out.println("\n" + pl1.getName() + " has got " + pl1.getPoints() +
                    "point(s), and " + pl2.getName() + " has got " + pl2.getPoints() + " point(s). It is a draw!");
        }
    }

    public static void main(String[] args){

        // displaying time
        displayTime();


        // scanner creation
        Scanner scan1 = new Scanner(System.in); // scanner for next using


        // creating players
        Player pl1 = new Player("Galymzhan", "Turysbekov", 0);  // creating new player
        System.out.println("Hello, " + pl1.getName() + " " + pl1.getSurname() + " you are Player 1 of the game of dices.");
        Player pl2 = createPlayer(scan1);  // creating new player


        // creating game and asking for targets
        Game game1 = createGame(scan1); // creating new game
        ArrayList<Integer> targets = askTargets(scan1);// asking for target numbers


        // game playing
        game1.play(pl1, targets.get(0));  // player 1 plays
        game1.play(pl2, targets.get(1));  // // player 2 plays
        printWinner(pl1, pl2);  // prints the winner


        // scanner closing
        scan1.close();
    }
}
