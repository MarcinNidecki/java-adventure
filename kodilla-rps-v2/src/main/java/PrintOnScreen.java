import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.util.Scanner;

class PrintOnScreen {
    static void clearScreen() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

    static void printMenuOption(User user) throws InterruptedException {
        Scanner userScanner = new Scanner(System.in);
        String x;
        do {

            System.out.print("[r] - RANKING    [x] - GAME OVER    [n] - NEW GAME  \n\n");
            x = user.processSelectedMenuOption(userScanner.nextLine());
        } while ((x.equals("r") || x.equals("wrong choose")));
    }

    static void printHeader() throws IOException {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_YELLOW +
                "                                                                                                --------------------------");
        System.out.println("                                                                                               |  Author: Marcin Nidecki  |");
        System.out.println("                                                                                                --------------------------"
                + ANSI_RESET);
        String asciiArt1 = FigletFont.convertOneLine("Rock Paper Scissors");
        System.out.println(ANSI_RED + asciiArt1 + ANSI_RESET);

    }


    static void textInRed(String string) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED + string + ANSI_RESET);
    }

    static void textInBlue(String string) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        System.out.println(ANSI_BLUE + string + ANSI_RESET);
    }


}
