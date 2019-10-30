package CS3343.game.Roulette;
import java.util.*;
import CS3343.core.*;
import CS3343.game.Game;

public class Roulette implements Game{
  Scanner scan = new Scanner(System.in);
  private Player player;
  private int balance;
  public Roulette(Player player){
    this.player = player;
    this.balance = player.getBalance();
  }

  public void intro(){
    System.out.println("Intro run in Roulette"); //tell em how much money they have
  }

  public int getBetSize(){
    System.out.println("Please enter how much you want to bet. You currently have " + player.getBalance() 
     + " and " + (player.getBalance() - balance) + " of that has already been bet");
    int bet = scan.nextInt();
    if(bet<=0 || bet>balance){
      System.out.println("Invalid amount");
      return getBetSize();
    }
    return bet;
  }

  public void betParity(ArrayList <RouletteBet> bets){ //took out Player player param
    int bet = getBetSize();
    //Now getting player choice of odd or even                                                                                              
    System.out.println("0:Even\n1:Odd");
    int num = scan.nextInt();          //need to create func that gets valid input in a loop
    try{
      bets.add(new ParityRouletteBet(player,bet,num));
      balance -= bet;
    }catch(NotOnBoardException e){
      System.out.println("Failed! Please choose either 0 or 1");
      betParity(bets);
    }
    System.out.println("Bet set! " + "$" + bet+ " with 2:1 payout");
  }

  public void betSingle(ArrayList<RouletteBet> bets){
    int bet = getBetSize();
    //Now getting player choice of odd or even
    System.out.println("Pick a number from 0-36");
    int num = scan.nextInt();          //need to create func that gets valid input in a loop - then dont have to throw exception
    try{
      bets.add(new SingleRouletteBet(player,bet,num));
    }catch(NotOnBoardException e){
      System.out.println("Failed! Please choose a number from 0-36");
    }
    System.out.println("Bet set! " + "$" + bet + " with 35:1 payout");
  }
  
  public void execute(ArrayList<RouletteBet> bets) {
	int j = 0;
	while (bets.size() > j) {
		bets.get(j).execBet();
		j++;
	}
	bets.clear();
	balance = player.getBalance();
  }
 
  public void display(ArrayList<RouletteBet> bets) {
	int j = 0;
	while (bets.size() > j) {
		bets.get(j).display();
		j++;
	}
  }
 
  
  public void gamePlay(){     //could maybe make it static
    char option;
    ArrayList <RouletteBet> bets = new ArrayList<RouletteBet>();
    while(true){
      System.out.println("1:View Rules");
      System.out.println("2:Bet on a specific number");
      System.out.println("3:Bet on odds or evens");
      System.out.println("4:Spin the wheel");
      System.out.println("5:View bets");
      System.out.println("Q:Quit");
      option = scan.next().charAt(0);
      switch(option){
        case '1':
          System.out.println("RULES RULES RULEs");
          break;
        case '2': 
          betSingle(bets);
          break;
        case '3':
          betParity(bets);
          break; 
        case '4':
            execute(bets);
            break; 
        case '5':
        	display(bets);
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
