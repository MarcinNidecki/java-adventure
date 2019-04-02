import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Rps {


    private static void printWithDelays(String data, TimeUnit unit, long delay)
            throws InterruptedException {

        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }

    void startGame() {

        System.out.println("Let's start the game!! \n\n");
    }

    int readNumber(int maximumRound) {
        int start = 1;
        Scanner input = new Scanner(System.in);
        int amount;
        System.out.print("Choose how many winning rounds you want to play.");


        while (true) {

            System.out.print(" Select  [" + start + " to " + maximumRound + "]: ");
            try {
                amount = input.nextInt();
                if (amount >= start && amount <= maximumRound)
                    return amount;

            } catch (java.util.InputMismatchException e) {
                System.out.println("error - only INT from " + start + " - " + maximumRound);
                input.nextLine();
            }
        }
    }

    void printWeapon() throws InterruptedException {

        printWithDelays("3 2 1 GO\n", TimeUnit.MILLISECONDS, 400);
        System.out.print("\n\n[1] - Rock  [2] - Scissors   [3] - Paper                                      [r] - RANKING    [x] - GAME OVER    [n] - NEW GAME  \n\n");
    }

    private Weapon takeTheStrongestWeapon(int randomChoice, Weapon userWeapon) {

        switch (randomChoice) {

            case 1:
                return new Rock();

            case 2:
                return new Scissors();

            case 3:
                return new Paper();

            case 4:
                return userWeapon;

            default:
                System.out.print("Something went wrong");

        }

        return null;
    }

    Weapon computerChoiceCheckUserChoiceAndTakeStrongerWeapon(User user) {

        Random rand = new Random();
        int randomChoice = rand.nextInt(4) + 1;


        switch (user.getSelectedWeapon().getShapeName()) {

            case "Rock":
                return takeTheStrongestWeapon(randomChoice, new Scissors());

            case "Paper":
                return takeTheStrongestWeapon(randomChoice, new Scissors());

            case "Scissors":
                return takeTheStrongestWeapon(randomChoice, new Rock());

            default:
                System.out.print("Something go wrong!");
        }
        return null;
    }

    void compareWeapon(Weapon selectedWeaponByUser, Weapon computerWeapon, User user) {

        switch (selectedWeaponByUser.getShapeName()) {

            case "Rock":
                if (computerWeapon.getShapeName().equals("Rock")) {
                    System.out.println(" REMIS");
                } else if (computerWeapon.getShapeName().equals("Paper")) {
                    user.setNumberOfRoundsWonbyComputer(user.getNumberOfRoundsWonbyComputer() + 1);
                    System.out.println(" Computer wins!");
                } else if (computerWeapon.getShapeName().equals("Scissors")) {
                    user.setNumberOfRoundsWonByUser(user.getNumberOfRoundsWonByUser() + 1);
                    System.out.println(user.getUserName() + "  win!");
                }
                break;

            case "Paper":
                if (computerWeapon.getShapeName().equals("Paper")) {
                    System.out.println(" REMIS");
                } else if (computerWeapon.getShapeName().equals("Rock")) {
                    user.setNumberOfRoundsWonByUser(user.getNumberOfRoundsWonByUser() + 1);
                    System.out.println(user.getUserName() + "  win!");
                } else if (computerWeapon.getShapeName().equals("Scissors")) {
                    user.setNumberOfRoundsWonbyComputer(user.getNumberOfRoundsWonbyComputer() + 1);
                    System.out.println(" Computer wins!");
                }
                break;

            case "Scissors":
                if (computerWeapon.getShapeName().equals("Scissors")) {
                    System.out.println(" REMIS");
                } else if (computerWeapon.getShapeName().equals("Rock")) {
                    user.setNumberOfRoundsWonbyComputer(user.getNumberOfRoundsWonbyComputer() + 1);
                    System.out.println(" Computer wins!");
                } else if (computerWeapon.getShapeName().equals("Paper")) {
                    user.setNumberOfRoundsWonByUser(user.getNumberOfRoundsWonByUser() + 1);
                    System.out.println(user.getUserName() + "  win!");
                }
                break;

            default:
                System.out.print("Something go wrong");

        }

    }
}
