import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Rps {


    private int numberOfRound;

    public User getUser() {
        return user;
    }

    private User user = new User();


    public void startGame() {

        System.out.println("Let's start the game!! \n\n");

    }

    public static void printWithDelays(String data, TimeUnit unit, long delay)
            throws InterruptedException {
        System.out.println("");
        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }

    public int readNumberOfRound()  {
        Scanner input = new Scanner(System.in);
        int amount = 0;
        do {
            while (true) {

                System.out.print("Number of round (MAX 4 round)");
                try {
                    return input.nextInt();

                } catch (java.util.InputMismatchException e) {
                    System.out.println("error - only INT from 1 - 4");
                    input.nextLine();
                }
            }

        }while (amount==1 ||amount==2 ||amount==3 || amount==4);
    }
    public void printWeapon() throws InterruptedException {

        printWithDelays("3 2 1 GO",TimeUnit.MILLISECONDS, 400);
        System.out.print("\n\n[1] - Stone  [2] - Scissors   [3] - Paper");
    }
    public int getNumberOfRound() {
        return numberOfRound;
    }

    public void setNumberOfRound(int numberOfRound) {
        this.numberOfRound = numberOfRound;
    }
}
