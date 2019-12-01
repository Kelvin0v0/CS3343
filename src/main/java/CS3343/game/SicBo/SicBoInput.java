package CS3343.game.SicBo;

import java.*;
import java.util.*;
import CS3343.core.*;

public class SicBoInput {
    private String select;
    private int cost;
    private Player player;
    // Scanner menu = ScannerSingleton.getScanner();
    // Scanner again = ScannerSingleton.getScanner();
    Scanner choice = ScannerSingleton.getScanner();
    public SicBoInput(Player player) {
        this.player = player;
    }

    // check choice weather exist
    public static boolean checkSelect(String choice) {
        String[] options = {"N","Y","s", "q", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "1&2", "1&3", "1&4", "1&5", "1&6", "2&3", "2&4", "2&5", "2&6", "3&4", "3&5", "3&6", "4&5", "4&6", "5&6",
                "Big", "Small", "Double1", "Double2", "Double3", "Double4", "Double5", "Double6", "Triple for all",
                "Triple1", "Triple2", "Triple3", "Triple4", "Triple5", "Triple6", "One dice 1", "One dice 2",
                "One dice 3", "One dice 4", "One dice 5", "One dice 6", "One two dice 1", "One two dice 2",
                "One two dice 3", "One two dice 4", "One two dice 5", "One two dice 6", "One three dice 1",
                "One three dice 2", "One three dice 3", "One three dice 4", "One three dice 5", "One three dice 6" };

        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(choice)) {
                return true;
            }
        }
        return false;
    }

    public void tryAgain() {
        String select;
        System.out.println("\nPlay again (Y:yes, N: no) ? ");
        while (true) {
            select = choice.nextLine();
            select = choice.nextLine();
            System.out.println("#"+select+"test ");
            if (select.charAt(0) =='Y' || select.charAt(0) =='N') {
                break;
            }else{
                System.out.println("Please input a Y/N");
            }
        }
        setChoice(select);
    }
    public void menuOption() {
        String select;
        while (true) {
        	
            select = choice.nextLine();
            if (select.charAt(0) =='s' || select.charAt(0) =='q') {
                break;
            }else{
                System.out.println("Please input a correct choice");
            }
        } 
        setChoice(select);
    }

    public void getInput() {
        String select = "";
        String name = player.getName();
        do {
            System.out.print(name + ", Choose the above Selection e.g Big, 1&2, (q: Exit): ");
            select = choice.nextLine();
            if (checkSelect(select) == false) {
                System.out.println("Please input a correct choice");
            }
        } while (checkSelect(select) == false);
        setChoice(select);
    }

    public void getCost() {
        int cost = 0;
        int balance = player.getBalance();
        System.out.print("Money for gamble" + "(Total you have:" + balance + ")" + ": ");
        do {
            cost = choice.nextInt();
            setMoney(cost);
            if(getMoney() > player.getBalance()){
                System.out.println("You don't so much money!!");
                System.out.print("Money for gamble: ");
            }else if(getMoney() <= 0){
                System.out.println("No money no game!!");
                System.out.print("Money for gamble: ");
            }
        } while (getMoney() > player.getBalance() || getMoney() <= 0);
    }

//    public SicBoInput(String select, int cost) {
//        this.select = select;
//        this.cost = cost;
//    }

    public String getChoice() {
        return select;
    }

    public int getMoney() {
        return cost;
    }

    public void setChoice(String select) {
        this.select = select;
    }

    public void setMoney(int money) {
        this.cost = money;
    }
}