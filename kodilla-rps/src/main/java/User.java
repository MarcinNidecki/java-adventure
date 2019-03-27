import java.util.Scanner;

public class User {

    private String userName;
    private int numberOfRoundsWon;
    private Weapon selectedWeapon;
    private int selectedNumber;


    public Weapon SetSelectedWeapon(int x) {
        Scanner in = new Scanner(System.in);

       do {
           //Display the title of the chosen module
           switch (x) {
               case 1:
                   selectedWeapon = new Stone();
                   System.out.print("Wybrano Stone");
                   break;
               case 2:
                   selectedWeapon = new Scissors();
                   System.out.print("Wybrano Scissors");
                   break;
               case 3:
                   selectedWeapon = new Paper();
                   System.out.print("Paper");
                   break;
               default:
                   System.out.println("Invalid choice");
           }//end of switch
           return  selectedWeapon;
       }while (x ==1 || x ==2 || x ==3);

    }
    public int readNumber()  {
        Scanner input = new Scanner(System.in);
        int amount = 0;
        do {
            while (true) {


                try {
                    return input.nextInt();

                } catch (java.util.InputMismatchException e) {
                    System.out.println("error - only INT from 1 - 3");
                    input.nextLine();
                }
            }

        }while (amount==1 ||amount==2 ||amount==3);
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nickname: ");
        userName = input.nextLine();



    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }




}
