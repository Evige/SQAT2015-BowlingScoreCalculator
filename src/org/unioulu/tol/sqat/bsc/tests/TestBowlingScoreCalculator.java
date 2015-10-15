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
	public void testgameScore81WhenGameIsFinished() {
		List<Frame> frames = new ArrayList<>();
		frames.add(new Frame(1, 5));
		frames.add(new Frame(3, 6));
		frames.add(new Frame(7, 2));
		frames.add(new Frame(3, 6));
		frames.add(new Frame(4, 4));
		frames.add(new Frame(5, 3));
		frames.add(new Frame(3, 3));
		frames.add(new Frame(4, 5));
		frames.add(new Frame(8, 1));
		frames.add(new Frame(2, 6));
		
		bowlingGame.addAllFrames(frames);
		
		int score = bowlingGame.score();
		
		assertEquals(81, score);
	}
	
	@Test
	public void testFirstThrowIsStrike() {
		List<Frame> frames = new ArrayList<>();
		frames.add(new Frame(10, 0));
		
		bowlingGame.addAllFrames(frames);
		bowlingGame.score();
	
		List<Frame> framesFromGame = bowlingGame.getFrames();
		
		boolean isStrike = framesFromGame.get(0).isStrike();
		
		assertEquals(true, isStrike);
	}
	
	@Test
	public void testStrikeCountedCorrectlyToScore() {
		List<Frame> frames = new ArrayList<>();
		frames.add(new Frame(10, 0));
		frames.add(new Frame(3, 6));
		
		bowlingGame.addAllFrames(frames);
		int score = bowlingGame.score();
		
		assertEquals(19, score);
	}

}
