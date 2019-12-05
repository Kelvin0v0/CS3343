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
	
	public Deck getPlayerDeck() {
		return this.playerDeck;
	}
	public Deck getCpuDeck() {
		return this.cpuDeck;
	}
	public void setPlayerDeck(Deck deck) {
		this.playerDeck = deck;
	}
	public void setCpuDeck(Deck deck) {
		this.cpuDeck = deck;
	}
	
//	public void gameStart2() {
//		System.out.println("    /$$   /$$$$$$$ /$$                  /$$         /$$$$$                  /$$         /$$   \n" + 
//				"  /$$$$$$| $$__  $| $$                 | $$        |__  $$                 | $$       /$$$$$$ \n" + 
//				" /$$__  $| $$  \\ $| $$ /$$$$$$  /$$$$$$| $$   /$$     | $$ /$$$$$$  /$$$$$$| $$   /$$/$$__  $$\n" + 
//				"| $$  \\__| $$$$$$$| $$|____  $$/$$_____| $$  /$$/     | $$|____  $$/$$_____| $$  /$$| $$  \\__/\n" + 
//				"|  $$$$$$| $$__  $| $$ /$$$$$$| $$     | $$$$$$/ /$$  | $$ /$$$$$$| $$     | $$$$$$/|  $$$$$$ \n" + 
//				" \\____  $| $$  \\ $| $$/$$__  $| $$     | $$_  $$| $$  | $$/$$__  $| $$     | $$_  $$ \\____  $$\n" + 
//				" /$$  \\ $| $$$$$$$| $|  $$$$$$|  $$$$$$| $$ \\  $|  $$$$$$|  $$$$$$|  $$$$$$| $$ \\  $$/$$  \\ $$\n" + 
//				"|  $$$$$$|_______/|__/\\_______/\\_______|__/  \\__/\\______/ \\_______/\\_______|__/  \\__|  $$$$$$/\n" + 
//				" \\_  $$_/                                                                            \\_  $$_/ \n" + 
//				"   \\__/                                                                                \\__/   \n" + 
//				"                                                                                             ");
//		System.out.println("Welcom ! "+player.getName());
//		System.out.println("Your Balance: "+player.getBalance());
//		System.out.print("Want to win some cash??? (Y/N)");
//		
//		char isPlay = this.inGame.next().charAt(0);
//		
//		while(isPlay!='Y'&&isPlay!='N') {
//			System.out.println("Invalid input. Please re-enter: ");
//		}
//		
//		if(isPlay=='N') {
//			System.out.println("Bye!");
//			return;
//		}
//		
//		playerDeck.dealCard();
//		playerDeck.dealCard();
//		cpuDeck.dealCard();
//		cpuDeck.dealCard();
//		
//	}
	
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
		System.out.println("Welcome! "+player.getName());
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
			if(!checkBalance(this.betValue,this.player.getBalance())) {
				System.out.println("You don't have enough money.");
			}
		}while(!checkBalance(this.betValue,this.player.getBalance()));
		this.betAccumunate += this.betValue; 
		this.getPlayer().bet(betValue);
		System.out.println("Total bet Value: "+this.betAccumunate);
		System.out.println("Player's balance: "+this.getPlayer().getBalance());
		this.roundCnt++;
	}
	
	public boolean checkBalance(int bet, int balance) {
		if(bet>balance) {
			return false;
		}
		return true;
	}
	
	public void askAction() {
		
		System.out.print("What do you want to do? Bet, Hit, Stop: ");
		char action = this.actionScanner.next().charAt(0);
		System.out.println(action);
		switch(action) {
			case 'B': {
				this.inputBet();
				break;
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

				switch(checkGameCondition()) {
					case 0:{
						System.out.println("You Busted!");
						System.out.println("Your balance: "+this.getPlayer().getBalance());
						break;
					}
					case 1:{
						System.out.println("You Losed !");
						System.out.println("Your balance: "+this.getPlayer().getBalance());
						this.playing = 0;
						break;
					}
					case 2:{
						System.out.println("Cpu busted! You win !");
						this.getPlayer().setBalance(betAccumunate*2);
						System.out.println("Your balance: "+this.getPlayer().getBalance());
						this.playing = 0;
						break;
					}
					case 3:{
						System.out.println("Draw!");
						this.playing = 0;
						this.getPlayer().setBalance(betAccumunate);
						break;
					}
					case 4:{
						System.out.println("You are bigger then cpu, you win.");
						this.playing = 0;
						this.getPlayer().setBalance(betAccumunate*2);
						break;
					}
				}
				
				return; 
			}
			default: System.out.println("Something wrong...");
			this.playing = 0;
			return;
		}
	}
	
	public int checkGameCondition() {
		if(playerDeck.calCardSum()>21) {
			return 0; //player busted
		}else if(cpuDeck.calCardSum()<22 && cpuDeck.calCardSum()>playerDeck.calCardSum()) {
			return 1; //cpu win
		}else if(cpuDeck.calCardSum()>21) {
			return 2; //cpu busted
		}else if(cpuDeck.calCardSum()==playerDeck.calCardSum()) {
			return 3; //draw
		}
		return 4; //you win
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
				if (checkGameCondition()==0) {
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
