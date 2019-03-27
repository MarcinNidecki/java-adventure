import java.util.Scanner;

public class RpsRunner {


    public static void main(String[] args) throws InterruptedException {
        Rps rps = new Rps();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        do {
            rps.startGame();
            user.setUserName();
            int round = rps.readNumberOfRound();
            System.out.print(round);

            do {
                rps.printWeapon();
                user.SetSelectedWeapon(user.readNumber());
                round--;
            } while (round > 0);

            System.out.println("Do you wanna play again? Y - YES   N - NO");
        }while (play==true);

    }
}
