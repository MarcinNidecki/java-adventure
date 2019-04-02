import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Rps {


    public void startGame() {

        System.out.println("Let's start the game!! \n\n");
    }


    public int readNumber(int maximumRound)  {
        int start = 1;
        Scanner input = new Scanner(System.in);
        int amount;
        System.out.print("Choose how many winning rounds you want to play.");

        do {

            while (true) {

                System.out.print(" Select  [" + start + " to " + maximumRound + "]: ");
                try {
                    amount = input.nextInt();
                    if (amount >=start && amount <=maximumRound)
                        return amount;

                } catch (java.util.InputMismatchException e) {
                    System.out.println("error - only INT from " + start + " - "+ maximumRound);
                    input.nextLine();
                }
            }

        }while (amount >=start && amount <=maximumRound);
    }

    public static void printWithDelays(String data, TimeUnit unit, long delay)
            throws InterruptedException {

        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }

    public void printWeapon() throws InterruptedException {

        printWithDelays("3 2 1 GO\n",TimeUnit.MILLISECONDS, 400);
        System.out.print("\n\n[1] - Rock  [2] - Scissors   [3] - Paper                                      [r] - RANKING    [x] - GAME OVER    [n] - NEW GAME  \n\n");
    }

    public  Weapon helpForTheComputer (int x, Weapon userWeapon) {

        switch (x) {

            case 1:
                return new Rock();


            case 2:
                return  new Scissors();


            case 3:
                return new Paper();

            case 4:
                return userWeapon;


            default:
                System.out.print("Something went wrong");

        }


        return null;
    }

    public Weapon computerChoice(User user) {

        Random rand = new Random();
        int x = rand.nextInt(4) + 1;


        switch (user.getSelectedWeapon().getShapeName()) {

            case "Rock":
                return helpForTheComputer(x,new Scissors());

            case "Paper":
                return helpForTheComputer(x, new Scissors());

            case "Scissors":
                return helpForTheComputer(x, new Rock());

            default:
                System.out.print("Something go wrong!");
        }
        return null;
    }

    public void compareWeapon(Weapon selectedWeaponByUser, Weapon computerWeapon, User user) {

        switch (selectedWeaponByUser.getShapeName()) {

            case "Rock":
                if (computerWeapon.getShapeName().equals("Rock")) {
                    System.out.println(" REMIS");
                } else if (computerWeapon.getShapeName() == "Paper") {
                    user.setNumberOfRoundsWonbyComputer(user.getNumberOfRoundsWonbyComputer()+1);
                    System.out.println(" Computer wins!");
                } else if (computerWeapon.getShapeName() == "Scissors") {
                    user.setNumberOfRoundsWonByUser(user.getNumberOfRoundsWonByUser()+1);
                    System.out.println(user.getUserName() +"  win!");
                } break;

            case "Paper":
                if (computerWeapon.getShapeName() == "Paper") {
                    System.out.println(" REMIS");
                } else if (computerWeapon.getShapeName() == "Rock") {
                    user.setNumberOfRoundsWonByUser(user.getNumberOfRoundsWonByUser()+1);
                    System.out.println(user.getUserName() +"  win!");
                } else if (computerWeapon.getShapeName() == "Scissors") {
                    user.setNumberOfRoundsWonbyComputer(user.getNumberOfRoundsWonbyComputer()+1);
                    System.out.println(" Computer wins!");
                } break;

            case "Scissors":
                if (computerWeapon.getShapeName() == "Scissors") {
                    System.out.println(" REMIS");
                } else if (computerWeapon.getShapeName() == "Rock") {
                    user.setNumberOfRoundsWonbyComputer(user.getNumberOfRoundsWonbyComputer()+1);
                    System.out.println(" Computer wins!");
                } else if (computerWeapon.getShapeName() == "Paper") {
                    user.setNumberOfRoundsWonByUser(user.getNumberOfRoundsWonByUser()+1);
                    System.out.println(user.getUserName() +"  win!");
                } break;

                default:
                    System.out.print("Something go wrong");

        }

    }
}
