import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class User implements Serializable {

    private String userName;
    private int numberOfRoundsWonByUser = 0;
    private int numberOfRoundsWonbyComputer = 0;
    private Weapon selectedWeapon = null;
    private boolean play = true;
    private int numberOfPlayedRounds;
    private boolean endOfGame;
    private String choice;
    private int actualRoundNumber = 1;
    private int winner;
    private int maxNumberOfRound;

    String processSelectedMenuOption(String selectedOption) throws InterruptedException {

        endOfGame = false;

        switch (selectedOption) {

            case "x":
                System.out.println("Exit");
                System.out.println("Are you sure you want to end the game?");
                yesOrNotChoose();
                if (choice.equals("y")) {
                    endOfGame = true;
                    play = false;
                    maxNumberOfRound = 0;
                    return "x";
                }
                break;

            case "n":
                System.out.print("Do you want star new game?");
                yesOrNotChoose();
                if (choice.equals("y"))
                    endOfGame = false;
                return "n";

            case "r":
                Ranking.printRankingTop10();
                TimeUnit.SECONDS.sleep(5);
                return "r";

            default:
                return "wrong choose";

        }//end of switch


        return "error";   // WHY I CANT REMOVE THIS?
    }


    Weapon processSelectedWeaponOrMenuOption(String selectedChoice) throws InterruptedException {

        endOfGame = false;


        switch (selectedChoice) {
            case "1":
                selectedWeapon = new Rock();
                PrintOnScreen.textInBlue(userName + " selected: " + selectedWeapon.getShapeName());

                return selectedWeapon;

            case "2":
                selectedWeapon = new Scissors();
                PrintOnScreen.textInBlue(userName + " selected: " + selectedWeapon.getShapeName());
                return selectedWeapon;

            case "3":
                selectedWeapon = new Paper();
                PrintOnScreen.textInBlue(userName + " selected: " + selectedWeapon.getShapeName());
                return selectedWeapon;

            case "x":
                System.out.println("Exit");
                System.out.println("Are you sure you want to end the game?");
                yesOrNotChoose();
                if (choice.equals("y")) {

                    endOfGame = true;
                    play = false;
                    maxNumberOfRound = 0;
                }
                break;

            case "n":
                System.out.print("Do you want star new game?");
                yesOrNotChoose();
                if (choice.equals("y"))

                    endOfGame = true;
                break;
            case "r":
                Ranking.printRankingTop10();
                TimeUnit.SECONDS.sleep(5);
                break;

            default:
                System.out.println("wrong choose");


        }//end of switch
        return null;


    }

    void printWinner() throws IOException {
        if (getWinner() == getMaxNumberOfRound()) {

            String ANSI_RESET = "\u001B[0m";
            String ANSI_YELLOW = "\u001B[33m";
            PrintOnScreen.printHeader();
            String asciiArt2;

            if (numberOfRoundsWonByUser > numberOfRoundsWonbyComputer) {
                asciiArt2 = FigletFont.convertOneLine("     " + getUserName() + " WIN!!");
                System.out.println(ANSI_YELLOW + asciiArt2 + ANSI_RESET);
            } else if (numberOfRoundsWonbyComputer > numberOfRoundsWonByUser) {
                asciiArt2 = FigletFont.convertOneLine("    COMPUTER WIN!!");
                System.out.println(ANSI_YELLOW + asciiArt2 + ANSI_RESET);
            }
        }
    }

    void computerChoiceThenComparingWithPlayer(Weapon userWeapon, Rps rps, User user) throws InterruptedException {
        if (userWeapon != null) {
            Weapon computerWeapon = rps.computerChoice(user);
            PrintOnScreen.textInRed("Computer selected: " + computerWeapon.getShapeName());
            rps.compareWeapon(userWeapon, computerWeapon, user);
            user.setActualRoundNumber(user.getActualRoundNumber() + 1);
            TimeUnit.SECONDS.sleep(4);
        }
    }

    void resetGame() {
        actualRoundNumber = 0;
        numberOfRoundsWonByUser = 0;
        numberOfRoundsWonbyComputer = 0;
        selectedWeapon = null;
        actualRoundNumber = 1;
        endOfGame = false;
    }

    String getUserName() {
        return userName;
    }

    void setUserName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nickname: ");
        userName = input.nextLine();
    }

    void yesOrNotChoose() {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;


        while (!success) {

            System.out.print(" [y] - YES   [n] - NO");

            try {
                choice = scanner.nextLine().toLowerCase();
                if (choice.equals("y") || choice.equals("n"))
                    success = true;

            } catch (java.util.InputMismatchException e) {
                System.out.println("error - only N or Y is accepted");
                scanner.nextLine();
            }
        }

    }

    void printHeaderWithNumberOfRound() {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";


        System.out.println(ANSI_GREEN +
                " --------------- ");

        System.out.println("|  ROUND NR. "
                + actualRoundNumber + " |                                   " + ANSI_BLUE + userName + " win(s): " + numberOfRoundsWonByUser + ANSI_RED + "               Computer win(s): " + numberOfRoundsWonbyComputer + ANSI_GREEN + "            ");
        System.out.println(" --------------- " + ANSI_RESET);


    }

    void whoIsLeading() {
        if (getNumberOfRoundsWonbyComputer() > getNumberOfRoundsWonByUser()) {
            setWinner(getNumberOfRoundsWonbyComputer());
        } else {
            setWinner(getNumberOfRoundsWonByUser());
        }
    }

    void askIfWantToPlayAgain() {
        if (!isEndOfGame()) {
            System.out.println("Do you wanna play again?");
            yesOrNotChoose();
            chceckIfChoiceEqualN();
        }
    }

    void chceckIfChoiceEqualN() {

        if (getChoice().equals("n")) {
            setPlay(false);
        }

    }

    int setNumberOfPlayedRounds(int numberOfPlayedRounds) {
        this.numberOfPlayedRounds = numberOfPlayedRounds;
        return numberOfPlayedRounds;
    }


    boolean isPlay() {
        return play;
    }

    void setPlay(boolean play) {
        this.play = play;
    }

    boolean isEndOfGame() {
        return endOfGame;
    }

    public void setEndOfGame(boolean endOfGame) {
        this.endOfGame = endOfGame;
    }

    String getChoice() {
        return choice;
    }


    int getNumberOfRoundsWonbyComputer() {
        return numberOfRoundsWonbyComputer;
    }

    void setNumberOfRoundsWonbyComputer(int numberOfRoundsWonbyComputer) {
        this.numberOfRoundsWonbyComputer = numberOfRoundsWonbyComputer;
    }

    int getNumberOfRoundsWonByUser() {
        return numberOfRoundsWonByUser;
    }

    void setNumberOfRoundsWonByUser(int numberOfRoundsWonByUser) {
        this.numberOfRoundsWonByUser = numberOfRoundsWonByUser;
    }

    int getActualRoundNumber() {
        return actualRoundNumber;
    }

    void setActualRoundNumber(int actualRoundNumber) {
        this.actualRoundNumber = actualRoundNumber;
    }

    int getWinner() {
        return winner;
    }

    void setWinner(int winner) {
        this.winner = winner;
    }

    int getMaxNumberOfRound() {
        return maxNumberOfRound;
    }

    void setMaxNumberOfRound(int maxNumberOfRound) {
        this.maxNumberOfRound = maxNumberOfRound;
    }

    Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(Weapon selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }

    @Override
    public String toString() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
}
