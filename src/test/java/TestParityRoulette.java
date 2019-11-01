import CS3343.game.Roulette.*;
import CS3343.core.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestParityRoulette{
    @Test
    public void testOddCorrect() throws NotOnBoardException{
        RouletteBet bet = new ParityRouletteBet(new Player(), 10, 1);
        Wheel.getWheel().setWheel(13);
        boolean res = bet.execBet();
        assertEquals(true,res);
    }
    @Test
    public void testOddWrong() throws NotOnBoardException{
        RouletteBet bet = new ParityRouletteBet(new Player(), 10, 1);
        Wheel.getWheel().setWheel(12);
        boolean res = bet.execBet();
        assertEquals(false,res);
    }
    @Test
    public void testEvenCorrect() throws NotOnBoardException{
        RouletteBet bet = new ParityRouletteBet(new Player(), 10, 0);
        Wheel.getWheel().setWheel(14);
        boolean res = bet.execBet();
        assertEquals(true,res);
    }

    @Test
    public void testEvenWrong() throws NotOnBoardException{
        RouletteBet bet = new ParityRouletteBet(new Player(), 10, 0);
        Wheel.getWheel().setWheel(15);
        boolean res = bet.execBet();
        assertEquals(false,res);
    }

    @Test
    public void testZeroEven() throws NotOnBoardException{
        RouletteBet bet = new ParityRouletteBet(new Player(), 10, 0);
        Wheel.getWheel().setWheel(0);
        boolean res = bet.execBet();
        assertEquals(false,res);
    }
    
    @Test
    public void testZeroOdd() throws NotOnBoardException{
        RouletteBet bet = new ParityRouletteBet(new Player(), 10, 1);
        Wheel.getWheel().setWheel(0);
        boolean res = bet.execBet();
        assertEquals(false,res);
    }

    @Test
    public void testNotOnBoard(){
        try{
            RouletteBet bet = new ParityRouletteBet(new Player(), 10, 2);
        }catch(NotOnBoardException e){
            return;
        }
        assertEquals(false,true);
    }
}