package CS3343;

import java.util.Scanner;

import CS3343.core.*;
import CS3343.game.SicBo.*;
import CS3343.game.Roulette.*;
import CS3343.game.SlotMachine.*;
import CS3343.game.BlackJack.*;

public class Main {
  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = ScannerSingleton.getScanner();
    boolean whileFlag = true;
    System.out.println("    _    ___ ___  _   _  \n" + "   / \\  |_ _/ _ \\| \\ | | \n"
        + "  / _ \\  | | | | |  \\| | \n" + " / ___ \\ | | |_| | |\\  | \n" + "/_/   \\_\\___\\___/|_| \\_| ");
    System.out.println("What's your name?");
    String pName = scanner.nextLine();
    Player player = new Player(pName);
    // System.out.print("\033[H\033[2J");
    System.out.flush();
    while (whileFlag) {
      // clear last new line

      System.out.println("Hello " + player.getName() + '.' + " Welcome to AION Casino");
      System.out.println("Choose a game! \n" + "1 : Roulette \n" + "2 : Sicbo \n" + "3 : BlackJack \n"
          + "4 : Slot Machine  \n" + "q : Quit");
      String selection = scanner.nextLine();
      char firstChar = (selection.length() == 0) ? 'q' : selection.charAt(0);

      switch (firstChar) {
      case 'q':
        whileFlag = false;
        break;
      case '1':
        Roulette roulette = new Roulette(player);
        roulette.gamePlay();
        break;
      case '2':
        SicBo sicbo = new SicBo(player);
        sicbo.gamePlay();
        break;
      case '3':
        BlackJack blackjack = new BlackJack(player);
        blackjack.gameInit();
        break;
      case '4':
        SlotMachine slotMachine = new SlotMachine(player);
        slotMachine.gamePlay();
        break;
      default:
        System.out.println("PLease Enter Correct Choice");
        break;

      }

      // if (firstChar != 'q') {
      //   scanner.nextLine();
      // }
    }

  }

  /*
   * Game game= null;// = new Game(); game.intro();
   * 
   * boolean isGameEnd = false; do{
   * 
   * isGameEnd = game.gamePlay(); } while (isGameEnd == false);
   * 
   * game.result();
   * 
   */

}
