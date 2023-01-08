import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Integer diceNumber;
    private final Integer tryCount;
    private final Scanner scan1; // for Enter
    private final Random rand1;

    public Game(Integer tryCount, Integer diceNumber) {
        this.diceNumber = diceNumber;
        this.tryCount = tryCount;
        scan1 = new Scanner(System.in);
        rand1 = new Random();
    }

    public void play (Player pl, Integer target) {
        System.out.println("\n" + pl.getName() + "'s turn. The target number is " + target);

        int[] dices = new int[diceNumber];

        for(int i = 0; i < tryCount; i++) { // how many times
            for(int j = 0; j < diceNumber; j++) {  // how many dices
                dices[j] = rand1.nextInt(10); // creating numbers from 0 to 10
                System.out.print(dices[j] + " ");
                if(target == dices[j]) {
                    pl.increasePoints();
                }
            }
//            for(int j : dices) {
//                if (j == target){
//                    pl.increasePoints();
//                }
//            }
            System.out.println("\nPress Enter:");
            scan1.nextLine();
        }
        System.out.println(pl.getName() +  " has got " + pl.getPoints() + " point(s)");
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public Integer getDiceNumber() {
        return diceNumber;
    }
}
