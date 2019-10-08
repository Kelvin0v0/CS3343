package CS3343.game.Roulette;
import java.util.*;
import CS3343.core.*;
import CS3343.game.Game;

public class Roulette implements Game{
  Scanner scan = ScannerSingleton.getScanner();
  private Player player;
  public Roulette(Player player){
    this.player = player;
  }

  public void intro(){
    System.out.println("Intro run in Roulette"); //tell em how much money they have
  }

  private int getBetSize(){
    System.out.println("Please enter how much you want to bet. You currently have " + player.getBalance());
    int bet = scan.nextInt();
    if(bet<=0 || bet>player.getBalance()){
      System.out.println("Invalid amount");
      return getBetSize();
    }
    return bet;
  }

  public void betParity(Player player, ArrayList bets){
    int bet = getBetSize();
    //Now getting player choice of odd or even
    System.out.println("1:Odd\n2:Even");
    int num = scan.nextInt();          //need to create func that gets valid input in a loop
    try{
      bets.add(new ParityRouletteBet(player,bet,num));
    }catch(NotOnBoardException e){
      System.out.println("Failed! Please choose either 0 or 1");
    }
    System.out.println("Bet set! " + "$" + bet+ " with 2:1 payout");
  }

  public void betSingle(Player player, ArrayList bets){
    int bet = getBetSize();
    //Now getting player choice of odd or even
    System.out.println("Pick a number from 0-36");
    int num = scan.nextInt();          //need to create func that gets valid input in a loop
    try{
      bets.add(new SingleRouletteBet(player,bet,num));
    }catch(NotOnBoardException e){
      System.out.println("Failed! Please choose a number from 0-36");
    }
    System.out.println("Bet set! " + "$" + bet + " with 35:1 payout");
  }
 
  public void gamePlay(){     //could maybe make it static
    char option;
    ArrayList <RouletteBet> bets = new ArrayList<RouletteBet>();
    while(true){
      System.out.println("1:View Rules");
      System.out.println("2:Bet on a specific number");
      System.out.println("3:Bet on odds or evens");
      System.out.println("Q:Quit");
      option = scan.next().charAt(0);
      switch(option){
        case '1':
          System.out.println("RULES RULES RULEs");
          break;
        case '2': 
          betSingle(player,bets);
          break;
        case '3':
          betParity(player, bets);
          break; 
        case 'Q':
          return;
      }
    }

    // System.out.println("Running Wheel");
    // Wheel wheel = Wheel.getWheel();
    // System.out.println(wheel.getNum());
    // System.out.println(wheel.getPar());
    // System.out.println("Running Bets");
    
    // System.out.println("Pick num for single square");
    // int number = scan.nextInt();
    // try{
    //   RouletteBet bet = new SingleRouletteBet(new PlayerStub(),10,number);
    //   bet.execBet();
    // }catch(Exception e){
    //   System.out.println(e);
    // }
  
    // System.out.println("Pick num for parity");
    // number = scan.nextInt();
    // try{
    //   RouletteBet bet = new ParityRouletteBet(new PlayerStub(),10,number);
    //   bet.execBet();
    // }catch(Exception e){
    //   System.out.println(e);
    // }
  }
}
