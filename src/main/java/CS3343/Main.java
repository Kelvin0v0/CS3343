package CS3343;

import java.util.Scanner;

import CS3343.game.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = ScannerSingleton.getScanner();
    System.out.println("hello World");

    boolean whileFlag = true;
    while (whileFlag) {
      // clear last new line
      System.out.println("Press 1 for Roulette, 2 for sicbo, 'q' to quit");
      String selection = scanner.nextLine();
      char firstChar = (selection.length() == 0) ? 'q' : selection.charAt(0);

      switch (firstChar) {
      case 'q':
        whileFlag = false;
        break;
      case '1':
        Roulette roulette = new Roulette();
        roulette.gamePlay();
        break;
      case '2':
        SicBo sicbo = new SicBo();
        sicbo.intro();
        sicbo.gamePlay();
        break;
      }

      if (firstChar != 'q') {
        scanner.nextLine();
      }
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
