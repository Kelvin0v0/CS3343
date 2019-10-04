
package CS3343;

import CS3343.game.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello World");

/*
        Game game= null;// = new Game();
        game.intro();

        boolean isGameEnd = false;
        do{

            isGameEnd = game.gamePlay();
        }
        while (isGameEnd == false);

        game.result();

*/      
        SicBo sicbo = new SicBo();
        sicbo.intro();
        sicbo.gamePlay();
        sicbo.result();
    }
}