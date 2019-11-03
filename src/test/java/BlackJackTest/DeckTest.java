package BlackJackTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CS3343.game.BlackJack.Deck;

public class DeckTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	public Deck deck;
	
	@BeforeEach
	public void init() {
		System.setOut(new PrintStream(outContent));
		deck = new Deck();
		deck.getCards().add("2");
		deck.getCards().add("J");
	}
	
	@After
	public void finish() {
		System.setOut(System.out);
	}
	@Test
	public void testPrintCard() {
		deck.printCard();
		assertEquals("Your Deck: 2 J \n",outContent.toString());
	}
	
	@Test
	public void testPrintCpuCard() {
		deck.printCpuCard();
		assertEquals("Cpu's Deck: ? J \n",outContent.toString());
	}
	
	@Test
	public void testPrintAllCpuDeck() {
		deck.printAllCpuCard();
		assertEquals("CPU's Deck: 2 J \n",outContent.toString());
	}
	
	@Test
	public void testcalCardSum() {
		assertEquals(12,deck.calCardSum());
		Deck deckWithAce = new Deck();
		deckWithAce.getCards().add("A");
		assertEquals(11,deckWithAce.calCardSum());
		Deck deckWithAceGreaterThenTen = new Deck();
		deckWithAceGreaterThenTen.getCards().add("J");
		deckWithAceGreaterThenTen.getCards().add("3");
		deckWithAceGreaterThenTen.getCards().add("A");
		assertEquals(14,deckWithAceGreaterThenTen.calCardSum());
	}
}

