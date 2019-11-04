package CS3343;

import CS3343.game.Roulette.*;
import CS3343.game.SicBo.SicBo;
import CS3343.core.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

class TestGame {
	@Test
	public void testOddCorrect() throws NotOnBoardException {
		RouletteBet bet = new ParityRouletteBet(new Player(), 10, 1);
		Wheel.getWheel().setWheel(13);
		boolean res = bet.execBet();
		assertEquals(true, res);
	}

	@Test
	public void testOddWrong() throws NotOnBoardException {
		RouletteBet bet = new ParityRouletteBet(new Player(), 10, 1);
		Wheel.getWheel().setWheel(12);
		boolean res = bet.execBet();
		assertEquals(false, res);
	}

	@Test
	public void testEvenCorrect() throws NotOnBoardException {
		RouletteBet bet = new ParityRouletteBet(new Player(), 10, 0);
		Wheel.getWheel().setWheel(14);
		boolean res = bet.execBet();
		assertEquals(true, res);
	}

	@Test
	public void testEvenWrong() throws NotOnBoardException {
		RouletteBet bet = new ParityRouletteBet(new Player(), 10, 0);
		Wheel.getWheel().setWheel(15);
		boolean res = bet.execBet();
		assertEquals(false, res);
	}

	@Test
	public void testZeroEven() throws NotOnBoardException {
		RouletteBet bet = new ParityRouletteBet(new Player(), 10, 0);
		Wheel.getWheel().setWheel(0);
		boolean res = bet.execBet();
		assertEquals(false, res);
	}

	@Test
	public void testZeroOdd() throws NotOnBoardException {
		RouletteBet bet = new ParityRouletteBet(new Player(), 10, 1);
		Wheel.getWheel().setWheel(0);
		boolean res = bet.execBet();
		assertEquals(false, res);
	}

	@Test
	public void testNotOnBoard1() {
		try {
			RouletteBet bet = new ParityRouletteBet(new Player(), 10, 2);
		} catch (NotOnBoardException e) {
			return;
		}
		assertEquals(false, true);
	}

	/** testRoulette */

	private final InputStream originalIn = System.in;

	/*
	 * Roulette obj must be created after the input stream has been changed
	 * 
	 */
	@Test
	public void testgetBetSizeSecond() {
		System.setIn(new ByteArrayInputStream("501 50 1 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		int res = roulette.getBetSize();
		assertEquals(res, 50);
	}

	@Test
	public void testgetBetSizeMax() {
		System.setIn(new ByteArrayInputStream("500 50 1 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		int res = roulette.getBetSize();
		assertEquals(res, 500);
	}

	@Test
	public void testgetBetSizeZero() {
		System.setIn(new ByteArrayInputStream("0 50 1 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		int res = roulette.getBetSize();
		assertEquals(res, 50);
	}

	@Test
	public void testBetParity() {
		System.setIn(new ByteArrayInputStream("50 1 ".getBytes()));
		Roulette roulett = new Roulette(new PlayerStub());
		ArrayList<RouletteBet> bets = new ArrayList<RouletteBet>();
		roulett.betParity(bets);
		assertTrue(bets.get(0) instanceof ParityRouletteBet);
	}

	@Test
	public void testBetSingle() {
		System.setIn(new ByteArrayInputStream("50 0 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		ArrayList<RouletteBet> bets = new ArrayList<RouletteBet>();
		roulette.betSingle(bets);
		assertTrue(bets.get(0) instanceof SingleRouletteBet);
	}

	@Test
	public void testExecClear() {
		System.setIn(new ByteArrayInputStream("50 0 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		ArrayList<RouletteBet> bets = new ArrayList<RouletteBet>();
		roulette.betSingle(bets);
		roulette.execute(bets);
		assertTrue(bets.isEmpty());
	}

	// @After
	public void restoreStreams() {
//	    System.setOut(originalOut);
//	    System.setErr(originalErr);
		System.setIn(originalIn);
	}

	/** testSicBo */
	@Test
	public void testIntro() {
		Player player = new Player();
		SicBo sicbo = new SicBo(player);
		sicbo.intro();
	}
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

	/** testsingleRoulette */
	@Test
	public void testCorrect() throws NotOnBoardException {
		RouletteBet bet = new SingleRouletteBet(new Player(), 10, 1);
		Wheel.getWheel().setWheel(1);
		boolean res = bet.execBet();
		assertEquals(true, res);
	}

	@Test
	public void testWrong() throws NotOnBoardException {
		RouletteBet bet = new SingleRouletteBet(new Player(), 10, 1);
		Wheel.getWheel().setWheel(2);
		boolean res = bet.execBet();
		assertEquals(false, res);
	}

	@Test
	public void testNotOnBoard() {
		try {
			RouletteBet bet = new SingleRouletteBet(new Player(), 10, 37);
		} catch (NotOnBoardException e) {
			return;
		}
		assertEquals(false, true);
	}

	/** testWheel */

	private Wheel wheel;

	/*
	 * @Before public void init(){ wheel = Wheel.getWheel(); }
	 */
	@Test
	public void testSpin() {
		Wheel wheel = Wheel.getWheel();
		boolean flag = true;
		int num;
		for (int i = 0; i < 100; i++) {
			wheel.spin();
			num = wheel.getNum();
			if (num < 0 || num > 36) {
				flag = false;
				break;
			}
		}
		assertEquals(true, flag);
	}

	@Test
	public void testParityZero() {
		Wheel wheel = Wheel.getWheel();
		assertEquals(-1, wheel.calcParity(0));
	}

	@Test
	public void testParityEven() {
		Wheel wheel = Wheel.getWheel();
		assertEquals(0, wheel.calcParity(36));
	}

	@Test
	public void testParityOdd() {
		Wheel wheel = Wheel.getWheel();
		assertEquals(1, wheel.calcParity(17));
	}

	@Test
	public void testParityMatchEven() {
		Wheel wheel = Wheel.getWheel();
		wheel.setWheel(2);
		assertEquals(0, wheel.getPar());
	}

	@Test
	public void testParityMatchOdd() {
		Wheel wheel = Wheel.getWheel();
		wheel.setWheel(3);
		assertEquals(1, wheel.getPar());
	}

	@Test
	public void testParityMatchZero() {
		Wheel wheel = Wheel.getWheel();
		wheel.setWheel(0);
		assertEquals(-1, wheel.getPar());
	}
}