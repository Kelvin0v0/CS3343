
import CS3343.game.SicBo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSicBo {
    /** sample of unit test */

    @Test
    public void testNumber() {

        int[] dices = { 6, 4, 6 };
        String choice = "13";
        SicBo sicbo = new SicBo();
        assertEquals(true, sicbo.checkNumber(choice, dices));
    }
    
    @Test
    public void testBigSmall1() {

        int[] dices = { 4, 4, 4 };
        String choice = "Big";
        SicBo sicbo = new SicBo();
        assertEquals(false, sicbo.checkBigSmall(choice, dices));
    }

    @Test
    public void testBigSmall2() {

        int[] dices = { 1, 2, 3 };
        String choice = "Big";
        SicBo sicbo = new SicBo();
        assertEquals(false, sicbo.checkBigSmall(choice, dices));
    }

    @Test
    public void testBigSmall3() {

        int[] dices = { 6, 4, 6 };
        String choice = "Big";
        SicBo sicbo = new SicBo();
        assertEquals(true, sicbo.checkBigSmall(choice, dices));
    }
    @Test
    public void testBigSmall4() {

        int[] dices = { 1, 1, 1 };
        String choice = "Small";
        SicBo sicbo = new SicBo();
        assertEquals(false, sicbo.checkBigSmall(choice, dices));
    }
    @Test
    public void testBigSmall5() {

        int[] dices = { 3, 4, 3 };
        String choice = "Small";
        SicBo sicbo = new SicBo();
        assertEquals(true, sicbo.checkBigSmall(choice, dices));
    }
    @Test
    public void testBigSmall6() {

        int[] dices = { 1, 2, 2 };
        String choice = "Small";
        SicBo sicbo = new SicBo();
        assertEquals(true, sicbo.checkBigSmall(choice, dices));
    }
    

}
