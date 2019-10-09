import CS3343.game.Roulette.*;
import CS3343.core.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestSingleRoulette{
    @Test
    public void testCorrect() throws NotOnBoardException{
        RouletteBet bet = new SingleRouletteBet(new PlayerStub(), 10, 1);
        Wheel.getWheel().setWheel(1);
        boolean res = bet.execBet();
        assertEquals(true,res);
    }

    @Test
    public void testWrong() throws NotOnBoardException{
        RouletteBet bet = new SingleRouletteBet(new PlayerStub(), 10, 1);
        Wheel.getWheel().setWheel(2);
        boolean res = bet.execBet();
        assertEquals(false,res);
    }

    @Test
    public void testNotOnBoard(){
        try{
            RouletteBet bet = new SingleRouletteBet(new PlayerStub(), 10, 37);
        }catch(NotOnBoardException e){
            return;
        }
        assertEquals(false,true);
    }
}