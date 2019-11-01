import CS3343.core.*;
import CS3343.game.Roulette.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.String;
import org.junit.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class testRoulette {
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
		assertEquals(res,50);
	}
	
	@Test
	public void testgetBetSizeMax() {
		System.setIn(new ByteArrayInputStream("500 50 1 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		int res = roulette.getBetSize();
		assertEquals(res,500);
	}
	
	@Test
	public void testgetBetSizeZero() {
		System.setIn(new ByteArrayInputStream("0 50 1 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		int res = roulette.getBetSize();
		assertEquals(res,50);
	}
	
	@Test
	public void testBetParity() {
		System.setIn(new ByteArrayInputStream("50 1 ".getBytes()));
		Roulette roulett = new Roulette(new PlayerStub());
		ArrayList <RouletteBet> bets = new ArrayList<RouletteBet>();
		roulett.betParity(bets);
		assertTrue(bets.get(0) instanceof ParityRouletteBet);
	}

	
	@Test
	public void testBetSingle() {
		System.setIn(new ByteArrayInputStream("50 0 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		ArrayList <RouletteBet> bets = new ArrayList<RouletteBet>();
		roulette.betSingle(bets);
		assertTrue(bets.get(0) instanceof SingleRouletteBet);
	}
	
	@Test
	public void testExecClear() {
		System.setIn(new ByteArrayInputStream("50 0 ".getBytes()));
		Roulette roulette = new Roulette(new PlayerStub());
		ArrayList <RouletteBet> bets = new ArrayList<RouletteBet>();
		roulette.betSingle(bets);
		roulette.execute(bets);
		assertTrue(bets.isEmpty());
	}

	
	//@After
	public void restoreStreams() {
//	    System.setOut(originalOut);
//	    System.setErr(originalErr);
	    System.setIn(originalIn);
	}
}
