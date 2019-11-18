package CS3343.game.SlotMachine;
import java.util.*;
import java.util.concurrent.TimeUnit;

import CS3343.core.Player;
import CS3343.core.ScannerSingleton;
import CS3343.game.Game;
public class SlotMachine implements Game{
	Scanner scan = ScannerSingleton.getScanner();
	private static int numberOfSymbols = 13;
	private static String symbols[] = {"1","2","3","4","5","6","7","8","9","J","Q","K","A"};
	private static int costToPlay = 50;
	public Player player;
	
	public SlotMachine(Player player) {
		this.player = player;
	}
	@Override
	
	public void intro() {
		// TODO Auto-generated method stub
		System.out.println("ENTER GAME INTRO AND RULES");
		
	}
	
	public boolean allaces(int n1 , int n2 , int n3)
	{
		if (n1==12 && checkMatch3(n1 , n2 , n3))
			return true;
		return false;
	}
	
	public boolean alljacks(int n1 , int n2 , int n3)
	{
		if (n1==9 && checkMatch3(n1 , n2 , n3))
			return true;
		return false;
	}
	
	public boolean straight (int n1 , int n2 , int n3)
	{
		if((Math.abs(n2-n1)==1 && Math.abs(n3-n2)==1) || (Math.abs(n3-n2)==1 && Math.abs(n3-n1)==1) || (Math.abs(n3-n1)==1) && (Math.abs(n2-n1)==1))
			return true;
		return false;
	}
	
	public boolean allkings(int n1 , int n2 , int n3)
	{
		if (n1==11 && checkMatch3(n1 , n2 , n3))
			return true;
		return false;
	}
	
	public boolean allqueens(int n1 , int n2 , int n3)
	{
		if (n1==10 && checkMatch3(n1 , n2 , n3))
			return true;
		return false;
	}
	
	public boolean checkMatch2(int n1, int n2, int n3) {//return index of match
		if((n1 == n2) || (n1 == n3) || (n2==n3))
			return true;
		
		return false;
	}
	
	public boolean checkMatch3(int n1, int n2, int n3) {
		if((n1 == n2) && (n2 == n3))
			return true;
		return false;
	}
	
	
	private boolean checkBalance() {
		if(this.getPlayer().getBalance() >= costToPlay)
			return true;
		return false;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	private void playGame() {
		int val1 = (int)(Math.random()*13) % numberOfSymbols;
		int val2 = (int)(Math.random()*13) % numberOfSymbols;
		int val3 = (int)(Math.random()*13) % numberOfSymbols;
		System.out.println("Spin.....ing:");
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Game Result:\t" + symbols[val1] + "\t");
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(symbols[val2] + "\t");
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(symbols[val3]);
		
		if( allkings(val1,val2,val3) || allqueens(val1,val2,val3) || alljacks(val1,val2,val3) || allaces(val1,val2,val3)) {
			System.out.println("Congrats! You won: " + (costToPlay*10));
			this.getPlayer().win(costToPlay*10);
			this.getPlayer().setBalance(costToPlay*10);
			System.out.println(this.getPlayer().getBalance());

		}
		
		else if (checkMatch3(val1,val2,val3)) {
			System.out.println("Congrats! You won: " + (costToPlay*8));
			this.getPlayer().win(costToPlay*8);
			this.getPlayer().setBalance(costToPlay*8);
			System.out.println(this.getPlayer().getBalance());

		}
		else if (checkMatch2(val1,val2,val3)) {
			System.out.println("Congrats! You won: " + (costToPlay*2));
			this.getPlayer().win(costToPlay*2);
			
			this.getPlayer().setBalance(costToPlay*2);
			System.out.println(this.getPlayer().getBalance());
			}
		
		else if (straight (val1,val2,val3)) {
			System.out.println("Congrats! You won: " + (costToPlay*5));
			this.getPlayer().win(costToPlay*5);
			
			this.getPlayer().setBalance(costToPlay*5);
			System.out.println(this.getPlayer().getBalance());
			}
		
		
		else {
			System.out.println("Oh no! You lost: " + costToPlay);
			this.getPlayer().lose(costToPlay);
			
			this.getPlayer().setBalance(costToPlay*-1);
			System.out.println(this.getPlayer().getBalance());
			}
		
	}

	@Override
	public void gamePlay() {
		// TODO Auto-generated method stub
		while(true) {
			char c;
			System.out.println("");
			System.out.println("Your Balance= " + this.getPlayer().getBalance());
			System.out.println("1. View Rules");
			System.out.println("2. Play for "+ costToPlay);
			System.out.println("q. Press q to exit");
			c = scan.next().charAt(0);
			
			switch(c) {
			case '1':	System.out.println("Game Rules: "
					+ "just hit the play button to start spinning , if you match 2/3 or 3/3 cards shown on the screen then you win money!!"
					+ ".If none of the cards match then you don't win anything");
						break;
			case '2':	
				if (this.checkBalance()) {
					this.playGame();
					break;
				}
				else {
					System.out.println("Oh No! You do not have enough balance. This is why you should not gamble. Good Luck.");
				}
			case 'q':
			case 'Q':	return;
			}
		}
	}
}
