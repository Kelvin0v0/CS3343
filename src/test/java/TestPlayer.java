import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CS3343.core.*;
import CS3343.game.BlackJack.Deck;

public class TestPlayer {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	public Player player;

	@BeforeEach
	public void init() {
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	void testGetName() {
		String result;
		player = new Player("Name");
		result = player.getName();
		assertEquals("Name", result);
	}
	
	@Test
	void testGetBalance() {
		int result;
		player = new Player();
		result = player.getBalance();
		assertEquals(500, result);
	}
	
	@Test
	void testGetWin() {
		int result;
		player = new Player();
		result = player.getWin();
		assertEquals(0, result);
	}
	@Test
	void testGetLose() {
		int result;
		player = new Player();
		result = player.getLose();
		assertEquals(0, result);
	}
	
	@Test
	void testWin() {
		player = new Player();
		player.win(100);
		assertEquals("Won 100\n", outContent.toString());
	}
	
	@Test
	void testLose() {
		player = new Player();
		player.lose(100);
		assertEquals("Lost 100\n", outContent.toString());
	}
	
}
