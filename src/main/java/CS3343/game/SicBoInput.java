package CS3343.game;

import java.*;
import java.util.*;

public class SicBoInput {
    private String select;
    private int cost;

    public static SicBoInput getInput() {
        Scanner choice = ScannerSingleton.getScanner();

        System.out.print("Your Choice e.g Big, 1&2: ");
        String select = choice.nextLine();
        System.out.print("Money for gamble: ");
        int cost = choice.nextInt();

        return new SicBoInput(select, cost);

    }

    public SicBoInput(String select, int cost) {
        this.select = select;
        this.cost = cost;
    }

    public String getChoice() {
        return select;
    }

    public int getMoney() {
        return cost;
    }

}