
import CS3343.core.Player;
import CS3343.game.SicBo.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSicBo {
    /** sample of unit test */

    /** test number */
    @Test
    public void testNumber() {

        int[] dices = { 6, 4, 6 };
        String choice = "13";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkNumber(choice, dices));
    }
    
    /** test big small */
    @Test
    public void testBigSmall1() {

        int[] dices = { 4, 4, 4 };
        String choice = "Big";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkBigSmall(choice, dices));
    }

    @Test
    public void testBigSmall2() {

        int[] dices = { 1, 2, 3 };
        String choice = "Big";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkBigSmall(choice, dices));
    }

    @Test
    public void testBigSmall3() {

        int[] dices = { 6, 4, 6 };
        String choice = "Big";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkBigSmall(choice, dices));
    }
    @Test
    public void testBigSmall4() {

        int[] dices = { 1, 1, 1 };
        String choice = "Small";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkBigSmall(choice, dices));
    }
    @Test
    public void testBigSmall5() {

        int[] dices = { 3, 4, 3 };
        String choice = "Small";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkBigSmall(choice, dices));
    }
    @Test
    public void testBigSmall6() {

        int[] dices = { 1, 2, 2 };
        String choice = "Small";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkBigSmall(choice, dices));
    }
    
    /** test  */

}
