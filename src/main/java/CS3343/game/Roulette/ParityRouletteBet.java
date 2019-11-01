package CS3343.game.Roulette;
import CS3343.core.*;

//import CS3343.game.NotOnBoardException;

public class ParityRouletteBet extends RouletteBet {
    private int bet, par;
    public ParityRouletteBet(Player player, int bet, int parity) throws NotOnBoardException{
        this.player = player;
        //check if number is on the board
        if(parity<0 || parity>1){
            throw new NotOnBoardException();       
        }
        this.par = parity;
        this.bet = bet;
    }

    public boolean execBet(){
        if(Wheel.getWheel().getPar()==par){
            player.win(bet);
            return true;
        }else{
            player.lose(bet);
            return false;
        }
    }
    
    public void display() {
    	String parity = (par==1)?"Odd" :"Even";
    	System.out.println("You bet "+bet+ " on "+parity);
    }
}