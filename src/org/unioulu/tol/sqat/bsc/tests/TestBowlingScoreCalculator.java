package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {
	
	private BowlingGame bowlingGame; 
	
	@Before
	public void setup() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testTwoThrowsScore6() {
		Frame frame = new Frame(2, 4);
		bowlingGame.addFrame(frame);
		
		int score = bowlingGame.score();
		
		assertEquals(6, score);
	}

}
