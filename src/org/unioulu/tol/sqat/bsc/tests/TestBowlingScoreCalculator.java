package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	
	@Test
	public void testScoreIs8After1Frame() {
		bowlingGame.addFrame(new Frame(2, 6));
		
		int score = bowlingGame.score();
		
		assertEquals(8, score);
	}
	
	@Test
	public void testScoreIs16After2Frames() {
		bowlingGame.addFrame(new Frame(0, 8));
		bowlingGame.addFrame(new Frame(8, 0));
		
		int score = bowlingGame.score();
		
		assertEquals(16, score);
	}
	
	@Test
	public void testGameConsistOf10Frames() {
		List<Frame> frames = new ArrayList<>();
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		
		bowlingGame.addAllFrames(frames);
		
		boolean isGameFinished = bowlingGame.isGameFinished();
		
		assertEquals(true, isGameFinished);
	}
	
	@Test
	public void gameScore81WhenGameIsFinished() {
		List<Frame> frames = new ArrayList<>();
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		frames.add(new Frame(2, 4));
		
		bowlingGame.addAllFrames(frames);
		
		int score = bowlingGame.score();
		
		assertEquals(81, score);
		
	}

}
