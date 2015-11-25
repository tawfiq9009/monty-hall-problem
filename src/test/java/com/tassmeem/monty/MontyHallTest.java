package com.tassmeem.monty;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MontyHallTest {

	private MontyHall montyHall;
	private InputStream stdin;
	
	@Before
	public void initMontyHall() {
		montyHall = new MontyHall();
		stdin = System.in;
	}
	
	@After
	public void clear(){
		montyHall = null;
		System.setIn(stdin);
	}
	
	@Test
	public void testInvalidInput() {
		
		System.setIn(new ByteArrayInputStream("X".getBytes()));
		Result result = montyHall.playGame(3);
		assertNotNull(result);
		assertEquals(ResultMessage.INVALID_INPUT, result.getResultMessage());
	}
	
	@Test
	public void testInputOutOfRange() {
		
		System.setIn(new ByteArrayInputStream("5".getBytes()));
		Result result = montyHall.playGame(3);
		assertNotNull(result);
		assertEquals(ResultMessage.INPUT_OUT_OF_RANGE, result.getResultMessage());
		
	}
	
	@Test
	public void testReturnResult() {
		
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Result result = montyHall.playGame(3);
		
		assertNotNull(result);
		
		if (result.getResultMessage() == ResultMessage.WIN) {
			
			assertTrue(result.isWin());
		} else {
			
			assertEquals(ResultMessage.LOST, result.getResultMessage());
			assertFalse(result.isWin());
		}
	}
	
	@Test
	public void testWinCase() {
		
		Result result = play(1, 1, 2, false);
		
		assertTrue(result.isWin());
		
		result = play(2, 1, 2, true);
		
		assertTrue(result.isWin());
		
	}
	
	@Test
	public void testLostCase() {
		
		Result result = play(1, 2, 1, false);
		
		assertFalse(result.isWin());
		
		result = play(2, 2, 1, true);
		
		assertFalse(result.isWin());
		
	}
	
	/**
	 * 
	 * Simulate final piece of code to check result
	 *  
	 * @param carDoor
	 * @param chosenDoorNumber
	 * @param otherDoor
	 * @param changed
	 * @return
	 */
	private Result play(int carDoor, int chosenDoorNumber, int otherDoor, boolean changed){
		
		if ((changed && otherDoor == carDoor) || (!changed && chosenDoorNumber == carDoor)) {

			return new Result(ResultMessage.WIN, true);
		}

		return new Result(ResultMessage.LOST, false);
	}

}
