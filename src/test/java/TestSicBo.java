
import CS3343.core.Player;
import CS3343.game.SicBo.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSicBo {
    /** sample of unit test */
    /** test SicBoInput */
    @Test
    public void testSicBoInputCheckSelect() {
        Player player = new Player();
        SicBoInput input = new SicBoInput(player);
        assertEquals(false, input.checkSelect("p"));

    }
    // @Test
    // public void testSicBoInput1() {
    // Player player = new Player();
    // SicBoInput input = new SicBoInput(player);
    // System.out.println("| S: Start \t\t\t |\n| Q: Exit \t\t\t |");
    // input.menuOption();
    // assertEquals("S",input.getChoice());
    //
    // }
    //
    // @Test
    // public void testSicBoInput2() {
    // Player player = new Player();
    // SicBoInput input = new SicBoInput(player);
    // input.getInput();
    // assertEquals("1&2",input.getChoice());
    //
    // }
    //
    // @Test
    // public void testSicBoInput3() {
    // Player player = new Player();
    // SicBoInput input = new SicBoInput(player);
    // input.getCost();
    // assertEquals(200,input.getMoney());
    //
    // }
    //
    // @Test
    // public void testSicBoInput4() {
    // Player player = new Player();
    // SicBoInput input = new SicBoInput(player);
    // input.tryAgain();
    // assertEquals("Y",input.getChoice());
    //
    // }

    /** test SicBo */
    @Test
    public void testIntro() {

        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        sicbo.intro();
    }

    /** test number */
    @Test
    public void testNumber1() {

        int[] dices = { 6, 4, 6 };
        String choice = "13";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkNumber(choice, dices));
    }

    @Test
    public void testNumber2() {

        int[] dices = { 1, 4, 1 };
        String choice = "6";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkNumber(choice, dices));
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
    public void testCheckPair() {
        int[] dices = { 1, 4, 1 };
        String choice = "1&4";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkPair(choice, dices));
    }

    @Test
    public void testCheckDouble1() {
        int[] dices = { 1, 1, 3 };
        String choice = "Double1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkDouble(choice, dices));
    }

    @Test
    public void testCheckDouble2() {
        int[] dices = { 1, 4, 3 };
        String choice = "Double1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkDouble(choice, dices));
    }

    @Test
    public void testCheckTriple1() {
        int[] dices = { 1, 1, 1 };
        String choice = "Triple1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkTriple(choice, dices));
    }

    @Test
    public void testCheckTriple2() {
        int[] dices = { 1, 3, 1 };
        String choice = "Triple1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkTriple(choice, dices));
    }

    @Test
    public void testCheckTripleAll1() {
        int[] dices = { 1, 1, 1 };
        String choice = "Triple for all";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkTriple(choice, dices));
    }

    @Test
    public void testCheckTripleAll2() {
        int[] dices = { 1, 3, 1 };
        String choice = "Triple for all";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkTriple(choice, dices));
    }

    @Test
    public void testCheckSingleDice1() {
        int[] dices = { 1, 3, 1 };
        String choice = "One dice 1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkSingleDice(choice, dices));
    }

    @Test
    public void testCheckSingleDice1false() {
        int[] dices = { 2, 3, 4 };
        String choice = "One dice 1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(false, sicbo.checkSingleDice(choice, dices));
    }

    @Test
    public void testCheckSingleDice2() {
        int[] dices = { 1, 3, 1 };
        String choice = "One two dice 1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkSingleDice(choice, dices));
    }

    @Test
    public void testCheckSingleDice3() {
        int[] dices = { 1, 1, 1 };
        String choice = "One three dice 1";
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(true, sicbo.checkSingleDice(choice, dices));
    }

    /** test */
    @Test
    public void testReward1() {
        String choice = "9";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 6, sicbo.reward(choice, result));
    }

    @Test
    public void testReward2() {
        String choice = "7";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 12, sicbo.reward(choice, result));
    }

    @Test
    public void testReward3() {
        String choice = "6";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 18, sicbo.reward(choice, result));
    }

    @Test
    public void testReward4() {
        String choice = "5";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 20, sicbo.reward(choice, result));
    }

    @Test
    public void testReward5() {
        String choice = "4";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 60, sicbo.reward(choice, result));
    }

    @Test
    public void testReward6() {
        String choice = "Big";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result, sicbo.reward(choice, result));
    }

    @Test
    public void testReward7() {
        String choice = "Small";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result, sicbo.reward(choice, result));
    }

    @Test
    public void testReward8() {
        String choice = "Double";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 11, sicbo.reward(choice, result));
    }

    @Test
    public void testReward9() {
        String choice = "Triple for all";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 30, sicbo.reward(choice, result));
    }

    @Test
    public void testReward10() {
        String choice = "Triple1";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 180, sicbo.reward(choice, result));
    }

    @Test
    public void testReward11() {
        String choice = "One dice 1";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result, sicbo.reward(choice, result));
    }

    @Test
    public void testReward12() {
        String choice = "One two dice 1";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 2, sicbo.reward(choice, result));
    }

    @Test
    public void testReward13() {
        String choice = "One three dice 1";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 3, sicbo.reward(choice, result));
    }

    @Test
    public void testReward14() {
        String choice = "One three dice 4";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 3, sicbo.reward(choice, result));
    }

    @Test
    public void testReward15() {
        String choice = "One three dice 6";
        int result = 100;
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        assertEquals(result + result * 3, sicbo.reward(choice, result));
    }

    /**test checkChoice*/
    @Test
    public void testCheckChoice1() {
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        int[] dices = { 2, 2, 4 };
        String choice = "Double2";
        assertEquals(true,sicbo.checkChoice(choice, dices));
    }
    
    @Test
    public void testCheckChoice2() {
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        int[] dices = { 2, 2, 2 };
        String choice = "Triple2";
        assertEquals(true,sicbo.checkChoice(choice, dices));
    }
    
    @Test
    public void testCheckChoice3() {
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        int[] dices = { 2, 3, 2 };
        String choice = "One dice 3";
        assertEquals(true,sicbo.checkChoice(choice, dices));
    }
    
    
    @Test
    public void testCheckChoice4() {
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        int[] dices = { 6, 3, 2 };
        String choice = "Big";
        assertEquals(true,sicbo.checkChoice(choice, dices));
    }
    @Test
    public void testCheckChoice5() {
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        int[] dices = { 3, 3, 3 };
        String choice = "One three dice 3";
        assertEquals(true,sicbo.checkChoice(choice, dices));
    }
    
    @Test
    public void testCheckChoice6() {
        Player player = new Player();
        SicBo sicbo = new SicBo(player);
        int[] dices = { 3, 4, 3 };
        String choice = "3&4";
        assertEquals(true,sicbo.checkChoice(choice, dices));
    }
    
    @Test
    public void testGamePlay() {
    	 Player player = new Player();
         SicBo sicbo = new SicBo(player);
        sicbo.gamePlay();
         
    }
}
