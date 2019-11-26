package CS3343.core;


public class Player {
	private String name;
	private int balance;
	private int win;
	private int lose;
	
    public Player(){
		setName("Guest");
		this.balance = 0;
		setBalance(500);
		this.win = 0;
		this.lose = 0;
	}
	
	public Player(String pName){
		setName(pName);
		this.balance = 0;
		setBalance(500);
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

	//the player need bet 
	public void bet(int betCost){
		this.balance = this.balance - betCost;
	}

	public void setBalance(int n) {
		this.balance = this.balance + n;
	}
	
	public int getWin() {
		return win;
	}

	public void win(int n) {
		this.win = this.win+n;
		System.out.println("Won " + n);
	}

	public int getLose() {
		return lose;
	}

	public void lose(int n) {
		this.lose = this.lose + n;
		System.out.println("Lost " + n);
	}
	
}