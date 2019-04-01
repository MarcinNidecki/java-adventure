import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class User implements Serializable {

    private String userName;
    private int numberOfRoundsWonByUser =0;
    private int numberOfRoundsWonbyComputer =0;
    private Weapon selectedWeapon = null;
    private int numberOfPlayedRounds;
    private boolean play = true;
    private boolean endOfGame;
    private String choice;
    private int actualRoundNumber =1;
    private int winner;
    private int maxNumberOfRound;

    public String firtMenu(String x) throws InterruptedException {

        endOfGame = false;

        do {

            switch (x) {

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
                    System.out.println("wrong choose");

            }//end of switch

        }while (x.equals("x") ||x.equals("s") || x.equals("r"));
        return "error";
    }


    public Weapon userChoice(String x) throws InterruptedException {

        endOfGame = false;

        do {

            switch (x) {
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
           return  null;
       }while (x.equals("1") || x.equals("2")|| x.equals("3") || x.equals("x") ||x.equals("s")|| x.equals("r"));

    }
    public void printWinner() throws IOException {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        PrintOnScreen.printHeader();
        String asciiArt2;

        if (numberOfRoundsWonByUser > numberOfRoundsWonbyComputer){
            asciiArt2 = FigletFont.convertOneLine("     "+ getUserName() + " WIN!!");
            System.out.println(ANSI_YELLOW + asciiArt2 + ANSI_RESET);
        } else if (numberOfRoundsWonbyComputer > numberOfRoundsWonByUser){
            asciiArt2 = FigletFont.convertOneLine("    COMPUTER WIN!!");
            System.out.println(ANSI_YELLOW + asciiArt2 + ANSI_RESET);
        }

    }

    public void resetGame() {
        actualRoundNumber = 0;
        numberOfRoundsWonByUser = 0;
        numberOfRoundsWonbyComputer = 0;
        selectedWeapon = null;
        actualRoundNumber = 1;
        endOfGame = false;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nickname: ");
        userName = input.nextLine();
    }
    public void yesOrNotChoose () {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;



               while (!success){

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
    public void printHeaderWithNumberOfRound() throws IOException {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";


        System.out.println(ANSI_GREEN +
                           " --------------- ");

        System.out.println("|  ROUND NR. "
               + actualRoundNumber  + " |                                   "+ANSI_BLUE + userName +  " win(s): " + numberOfRoundsWonByUser +  ANSI_RED+ "               Computer win(s): " +numberOfRoundsWonbyComputer + ANSI_GREEN +"            ");
        System.out.println(" --------------- "+ ANSI_RESET);


    }

    public int setNumberOfPlayedRounds(int numberOfPlayedRounds) {
        this.numberOfPlayedRounds = numberOfPlayedRounds;
        return numberOfPlayedRounds;
    }


    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public boolean isEndOfGame() {
        return endOfGame;
    }

    public void setEndOfGame(boolean endOfGame) {
        this.endOfGame = endOfGame;
    }

    public String getChoice() {
        return choice;
    }


    public int getNumberOfRoundsWonbyComputer() {
        return numberOfRoundsWonbyComputer;
    }

    public void setNumberOfRoundsWonbyComputer(int numberOfRoundsWonbyComputer) {
        this.numberOfRoundsWonbyComputer = numberOfRoundsWonbyComputer;
    }

    public int getNumberOfRoundsWonByUser() {
        return numberOfRoundsWonByUser;
    }

    public void setNumberOfRoundsWonByUser(int numberOfRoundsWonByUser) {
        this.numberOfRoundsWonByUser = numberOfRoundsWonByUser;
    }

    public int getActualRoundNumber() {
        return actualRoundNumber;
    }

    public void setActualRoundNumber(int actualRoundNumber) {
        this.actualRoundNumber = actualRoundNumber;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getMaxNumberOfRound() {
        return maxNumberOfRound;
    }

    public void setMaxNumberOfRound(int maxNumberOfRound) {
        this.maxNumberOfRound = maxNumberOfRound;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(Weapon selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }

    @Override
    public String toString() {
        return  userName;
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
