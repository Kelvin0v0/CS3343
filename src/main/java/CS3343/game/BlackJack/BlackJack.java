package CS3343.game.BlackJack;

import java.util.Scanner;
import java.util.ArrayList;
import CS3343.core.*;
public class BlackJack {
	
	private Player player;
	private int betValue = 0;
	private int roundCnt = 0;
	private int betAccumunate = 0;
	private int playing = 1;
	Scanner betScanner = new Scanner(System.in);
	Scanner inGame = new Scanner(System.in);
	Scanner actionScanner = new Scanner(System.in);
	
	Deck playerDeck = new Deck();
	Deck cpuDeck = new Deck();
	
	public BlackJack(Player player){
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void gameInit() {
		int quitFlag = 0;
		System.out.println("    /$$   /$$$$$$$ /$$                  /$$         /$$$$$                  /$$         /$$   \n" + 
				"  /$$$$$$| $$__  $| $$                 | $$        |__  $$                 | $$       /$$$$$$ \n" + 
				" /$$__  $| $$  \\ $| $$ /$$$$$$  /$$$$$$| $$   /$$     | $$ /$$$$$$  /$$$$$$| $$   /$$/$$__  $$\n" + 
				"| $$  \\__| $$$$$$$| $$|____  $$/$$_____| $$  /$$/     | $$|____  $$/$$_____| $$  /$$| $$  \\__/\n" + 
				"|  $$$$$$| $$__  $| $$ /$$$$$$| $$     | $$$$$$/ /$$  | $$ /$$$$$$| $$     | $$$$$$/|  $$$$$$ \n" + 
				" \\____  $| $$  \\ $| $$/$$__  $| $$     | $$_  $$| $$  | $$/$$__  $| $$     | $$_  $$ \\____  $$\n" + 
				" /$$  \\ $| $$$$$$$| $|  $$$$$$|  $$$$$$| $$ \\  $|  $$$$$$|  $$$$$$|  $$$$$$| $$ \\  $$/$$  \\ $$\n" + 
				"|  $$$$$$|_______/|__/\\_______/\\_______|__/  \\__/\\______/ \\_______/\\_______|__/  \\__|  $$$$$$/\n" + 
				" \\_  $$_/                                                                            \\_  $$_/ \n" + 
				"   \\__/                                                                                \\__/   \n" + 
				"                                                                                             ");
		System.out.println("Welcom ! "+player.getName());
		System.out.println("Your Balance: "+player.getBalance());
		System.out.print("Want to win some cash??? (Y/N)");
		
		
		char isPlay = this.inGame.next().charAt(0);
		
		while(isPlay!='Y'&&isPlay!='N') {
			System.out.println("please re-enter: ");
			isPlay = this.inGame.next().charAt(0);
		}
		if(isPlay=='N') {
			System.out.println("Bye");
			return; 
		}
		
		
		while(quitFlag == 0) {
			quitFlag = this.gameStart();
		}
		System.out.println("Bye");
	}
	
	
	public void inputBet() {
		do {
			System.out.print("Place your Bet: ");
			this.betValue =  this.betScanner.nextInt();
			if(this.betValue>this.player.getBalance()) {
				System.out.println("You don't have enough money.");
			}
		}while(this.betValue>this.player.getBalance());
		this.betAccumunate += this.betValue; 
		this.getPlayer().setBalance(this.getPlayer().getBalance()-this.betValue);
		System.out.println("Total bet Value: "+this.betAccumunate);
		this.roundCnt++;
	}
	
	public void askAction() {
		
		System.out.print("What do you want to do? Bet, Hit, Stop: ");
		char action = this.actionScanner.next().charAt(0);
		System.out.println(action);
		switch(action) {
			case 'B': {
				this.inputBet();
			}
			case 'H': {
				playerDeck.dealCard();
				break;
			}
			case 'S': {
				while(cpuDeck.calCardSum()<17) {
					cpuDeck.dealCard();
				}
				cpuDeck.printAllCpuCard();
				playerDeck.printCard();
				if (cpuDeck.calCardSum()<22 && cpuDeck.calCardSum()>playerDeck.calCardSum()) {
					System.out.println("You Losed !");
					System.out.println("Your balance: "+this.getPlayer().getBalance());
					this.playing = 0;
					return;
				}else if(cpuDeck.calCardSum()>21) {
					System.out.println("Cpu busted! You win !");
					this.getPlayer().setBalance(this.getPlayer().getBalance()+betAccumunate*2);
					System.out.println("Your balance: "+this.getPlayer().getBalance());
					this.playing = 0;
					return;
				}else if(cpuDeck.calCardSum()==playerDeck.calCardSum()) {
					System.out.println("Draw!");
					this.playing = 0;
					return;
				}
				break;
			}
			default: System.out.println("Something wrong...");
			this.playing = 0;
			return;
		}
	}
	
	public int gameStart() {

		playerDeck.dealCard();
		playerDeck.dealCard();
		cpuDeck.dealCard();
		cpuDeck.dealCard();

		
		while(playing==1) {
			if(roundCnt==0) {
				this.inputBet();
				cpuDeck.printCpuCard();
				playerDeck.printCard();
			}else {
				if (playerDeck.calCardSum()>21) {
					playerDeck.printCard();
					System.out.println("Busted !!!");
					playing=0;
				}else{
					if(roundCnt!=1) {
						cpuDeck.printCpuCard();
						playerDeck.printCard();
						System.out.println("Total bet Value: "+betAccumunate);
					}
					roundCnt++;
					this.askAction();
				}
			}
		}
		return 1;
	}
}
