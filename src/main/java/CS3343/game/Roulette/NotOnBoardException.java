package CS3343.game.Roulette;

public class NotOnBoardException extends Exception { 
    public NotOnBoardException() {
        super("Invalid numbers selected for the roulette board");
    }
}