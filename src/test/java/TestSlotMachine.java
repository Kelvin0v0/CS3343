import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CS3343.core.Player;
import CS3343.game.SlotMachine.SlotMachine;

class TestSlotMachine {


	@Test
	void testMatch2_1() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine (null);
		result = slotMachine.checkMatch2(1, 2, 3);
		assertEquals(false , result);
		
	}
	
	@Test
	void testMatch2_2() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine (null);
		result = slotMachine.checkMatch2(1, 1, 3);
		assertEquals(true , result);
		
	}
	
	@Test
	void testMatch3_1() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine (null);
		result = slotMachine.checkMatch3(1, 1, 3);
		assertEquals(false , result);
		
	}
	@Test
	void testMatch3_2() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine (null);
		result = slotMachine.checkMatch3(3, 3, 3);
		assertEquals(true , result);
		
	}
	@Test
	void testallkings() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine(null);
		result = slotMachine.allkings(11, 11, 11);
		assertEquals(true , result);
	}
	@Test
	void testallqueens() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine(null);
		result = slotMachine.allqueens(10, 10, 10);
		assertEquals(true , result);
	}
	@Test
	void testallaces() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine(null);
		result = slotMachine.allaces(12, 12, 12);
		assertEquals(true , result);
	}
	@Test
	void testalljacks() {
		boolean result;
		SlotMachine slotMachine = new SlotMachine(null);
		result = slotMachine.alljacks(9, 9, 9);
		assertEquals(true , result);
	}
	@Test
	void teststraight()
	{
		boolean result;
		SlotMachine slotMachine = new SlotMachine(null);
		result = slotMachine.straight(4, 5, 6);
		assertEquals(true , result);
	}
	
	
	
}
	
	
