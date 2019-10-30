package CS3343.game.Roulette;
import CS3343.core.*;

//import CS3343.game.NotOnBoardException;

public class SingleRouletteBet extends RouletteBet {
    private int bet, num;
    private Player player;
    public SingleRouletteBet(Player player, int bet, int num) throws NotOnBoardException{
        this.player = player;
        //check if number is on the board
        if(num<0 || num>36){
            throw new NotOnBoardException();       
        }
        this.num = num;
        this.bet = bet;
    }

    public boolean execBet(){
        if(Wheel.getWheel().getNum()==num){
            player.win(bet*34);
            return true;
        }else{
            player.lose(bet);
            return false;
        }
    }
    
    public void display() {
    	System.out.println("You bet "+bet+ " on "+num);
    }
}