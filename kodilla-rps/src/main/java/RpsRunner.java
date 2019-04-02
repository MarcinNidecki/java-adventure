import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RpsRunner {

    public static void main(String[] args) throws InterruptedException, IOException {

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
            PrintOnScreen.printMenuOption(user);

            // check if user don't want to abort game
            if (!user.isEndOfGame()) {
                user.setUserName();
                //set maximum allowed round needed to win
                user.setMaxNumberOfRound(user.setNumberOfPlayedRounds(rps.readNumber(3)));
                do {
                    PrintOnScreen.clearScreen();
                    PrintOnScreen.printHeader();
                    user.printHeaderWithNumberOfRound();
                    rps.printWeapon();
                    Weapon userWeapon = user.processSelectedWeaponOrMenuOption(userScanner.nextLine());
                    user.computerChoiceThenComparingWithPlayer(userWeapon, rps, user);
                    TimeUnit.SECONDS.sleep(1);
                    user.whoIsLeading();

                    //repeat the rounds until someone wins
                } while (user.getWinner() < user.getMaxNumberOfRound());

                user.printWinner();
                ranking.addToRanking(user.getUserName());
                ranking.saveRanking();
                user.askIfWantToPlayAgain();
            }

        } while (user.isPlay());
    }
}
