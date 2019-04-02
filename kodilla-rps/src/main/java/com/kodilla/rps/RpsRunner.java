import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RpsRunner {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {

        Rps rps = new Rps();
        User user = new User();
        Scanner userScanner = new Scanner(System.in);
        Ranking ranking = new Ranking();
        ranking.readMap();


        do {

            user.resetGame();
            PrintOnScreen.clearScreen();
            PrintOnScreen.printHeader();

            rps.startGame();
            String x;
            do {

                System.out.print("[r] - RANKING    [x] - GAME OVER    [n] - NEW GAME  \n\n");
                x = user.firtMenu(userScanner.nextLine());
            } while ((x.equals("r") || x.equals("wrong choose")));

            if (!user.isEndOfGame()) {
                user.setUserName();
                // rps.readNumber(x)  set maximum   of round needed to win
                user.setMaxNumberOfRound(user.setNumberOfPlayedRounds(rps.readNumber(3)));
                do {

                    PrintOnScreen.clearScreen();
                    PrintOnScreen.printHeader();
                    user.printHeaderWithNumberOfRound();
                    rps.printWeapon();
                    Weapon userWeapon = user.userChoice(userScanner.nextLine());


                    if (userWeapon != null) {
                        Weapon computerWeapon = rps.computerChoice(user);
                        PrintOnScreen.textInRed("Computer selected: " + computerWeapon.getShapeName());
                        rps.compareWeapon(userWeapon, computerWeapon, user);
                        user.setActualRoundNumber(user.getActualRoundNumber() + 1);
                        TimeUnit.SECONDS.sleep(4);
                    }

                    TimeUnit.SECONDS.sleep(1);
                    if (user.getNumberOfRoundsWonbyComputer() > user.getNumberOfRoundsWonByUser()) {
                        user.setWinner(user.getNumberOfRoundsWonbyComputer());
                    } else {
                        user.setWinner(user.getNumberOfRoundsWonByUser());
                    }
                } while (user.getWinner() < user.getMaxNumberOfRound());


                if (user.getWinner() == user.getMaxNumberOfRound())
                    user.printWinner();
                ranking.addToRanking(user.getUserName());
                ranking.saveMap();

                if (!user.isEndOfGame()) {
                    System.out.println("Do you wanna play again?");
                    user.yesOrNotChoose();

                    if (user.getChoice().equals("n")) {
                        user.setPlay(false);
                    }
                }
            }

        }while (user.isPlay());
    }
}
