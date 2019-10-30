import CS3343.core.*;
import CS3343.game.Roulette.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.String;
import org.*;
import org.junit.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRoulette {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	private final InputStream originalIn = System.in;
	private final String first_menu = "1:View Rules\n\"2:Bet on a specific number\n3:Bet on odds or evens\nQ:Quit\n";

	@Before
	public void setUpStreams(){
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	/*
	 * 
	 * need to check output and arraylist content. 
	 * also need to go back into classes and make sure players have enough money
	 * need to go back and use player class instead of stub
	 * need to use stub for test cases.
	 * 
	 */
	
	
	
	@Test
	public void testParityOdd() {
		System.setIn(new ByteArrayInputStream("3 50 1".getBytes()));
		Roulette roulette = new Roulette(new Player());
		roulette.gamePlay();
//		assertEquals(first_menu+"",outContent.toString());
	}

	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	    System.setIn(originalIn);
	}
}
