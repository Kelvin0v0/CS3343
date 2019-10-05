package CS3343;
import java. Scanner;
import CS3343.game.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello World");
        Scanner input = new Scanner(System. in);
        boolean whileFlag = true;
        while(whileFlag){
          System.out.println("Press 1 for Roulette, 'q' to quit");
          switch(input.nextChar()){
            case 'q':
              whileFlag = false;
              break;
            case '1':
              Roulette roulette = new Roulette();
              roulette.gamePlay();
          }
        }



}


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
    }
}
