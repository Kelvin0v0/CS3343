package CS3343.core;

// public abstract class Player{  //Antony please change this to a concrete class when youre done with it
//     public abstract int getBalance();
//     public abstract void lose(int n);
//     public abstract void win(int n);
// }
public class Player {
	private String name;
	private int balance;
	private int win;
	private int lose;
	private double winRate;
    
    public Player(){
		setName("Guest");
		this.balance = 0;
		setBalance(500);
		this.winRate = 0;
		this.win = 0;
		this.lose = 0;
	}
	
	public Player(String pName){
		setName(pName);
		this.balance = 0;
		setBalance(500);
		this.winRate = 0;
		this.win = 0;
		this.lose = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int n) {
		this.balance = this.balance + n;
	}
	public void setWinrate() {
		this.winRate = this.win/(this.win+this.lose);
	}
	public double getWinRate() {
		return winRate;
	}
	
	public int getWin() {
		return win;
	}

	public void win(int n) {
		this.win = this.win+n;
	}

	public int getLose() {
		return lose;
	}

	public void lose(int n) {
		this.lose = this.lose + n;
	}
	
}