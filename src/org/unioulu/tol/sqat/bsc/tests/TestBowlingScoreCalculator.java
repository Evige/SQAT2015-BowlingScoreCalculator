package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import java.util.List;

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
	public void testOneFrameThrown() {
		Frame frame = new Frame(2, 4);
		bowlingGame.addFrame(frame);
		
		int framesCount = bowlingGame.getFramesCount();
		
		assertEquals(1, framesCount);
	}
	
	@Test
	public void testTwoFramesThrown() {
		bowlingGame.addFrame(new Frame(2, 4));
		bowlingGame.addFrame(new Frame(3, 2));
		
		int framesCount = bowlingGame.getFramesCount();
		
		assertEquals(2, framesCount);
	}

}
