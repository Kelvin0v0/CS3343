package BlackJackTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CS3343.core.Player;
import CS3343.game.BlackJack.BlackJack;
import CS3343.game.BlackJack.Deck;

public class TestBlackJack {
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Player player;

	@BeforeEach
	public void init() {
		player = new Player();
		player.setName("Player1");
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void testCheckBalance() {
		BlackJack bg = new BlackJack(player);
		assertTrue(bg.checkBalance(400,500));
	}
	@Test
	public void testCheckBalance2() {
		BlackJack bg = new BlackJack(player);
		assertTrue(bg.checkBalance(500,500));
	}
	@Test
	public void testCheckBalance3() {
		BlackJack bg = new BlackJack(player);
		assertFalse(bg.checkBalance(500,400));
	}
	@Test
	public void testCheckBalance4() {
		BlackJack bg = new BlackJack(player);
		assertFalse(bg.checkBalance(0,400));
	}
	
	@Test
	public void testCheckGameCondition1() {
		BlackJack bg = new BlackJack(player);
		Deck deck = new Deck();
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		bg.setPlayerDeck(deck);
		assertEquals(bg.checkGameCondition(),0);
	}
	@Test
	public void testCheckGameCondition2() {
		BlackJack bg = new BlackJack(player);
		Deck deck = new Deck();
		Deck cpuDeck = new Deck();
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		cpuDeck.getCards().add("A");
		cpuDeck.getCards().add("J");
		bg.setPlayerDeck(deck);
		bg.setCpuDeck(cpuDeck);
		assertEquals(bg.checkGameCondition(),1);
	}
	@Test
	public void testCheckGameCondition3() {
		BlackJack bg = new BlackJack(player);
		Deck deck = new Deck();
		Deck cpuDeck = new Deck();
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		bg.setPlayerDeck(deck);
		bg.setCpuDeck(cpuDeck);
		assertEquals(bg.checkGameCondition(),2);
	}
	@Test
	public void testCheckGameCondition4() {
		BlackJack bg = new BlackJack(player);
		Deck deck = new Deck();
		Deck cpuDeck = new Deck();
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		bg.setPlayerDeck(deck);
		bg.setCpuDeck(cpuDeck);
		assertEquals(bg.checkGameCondition(),0);
	}
	@Test
	public void testCheckGameCondition5() {
		BlackJack bg = new BlackJack(player);
		Deck deck = new Deck();
		Deck cpuDeck = new Deck();
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		bg.setPlayerDeck(deck);
		bg.setCpuDeck(cpuDeck);
		assertEquals(bg.checkGameCondition(),3);
	}
	@Test
	public void testCheckGameCondition6() {
		BlackJack bg = new BlackJack(player);
		Deck deck = new Deck();
		Deck cpuDeck = new Deck();
		deck.getCards().add("Q");
		deck.getCards().add("Q");
		deck.getCards().add("A");
		cpuDeck.getCards().add("Q");
		cpuDeck.getCards().add("Q");
		bg.setPlayerDeck(deck);
		bg.setCpuDeck(cpuDeck);
		assertEquals(bg.checkGameCondition(),4);
	}
	
	@Test
	public void testGameInit() {
		BlackJack bg = new BlackJack(player);
		
	}
	
}
