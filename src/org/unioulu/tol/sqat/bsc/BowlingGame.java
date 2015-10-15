package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private boolean isNextFrameBonus = false;
	private boolean strikeHappened = false;
	private boolean multipleStrikes = false;
	private boolean bonusThrowGranted = false;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		frames.add(frame);
		
	}
	
	public void addAllFrames(List<Frame> allFrames) {
		this.frames = allFrames;
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
		frames.add(new Frame(firstThrow, secondThrow));
	}
	
	public int score(){
		int score = 0;
		int frameCount = 1;
		for (Frame frame : frames) {
			if (isNextFrameBonus()) {
				if (strikeHappened) {
					if (multipleStrikes) {
						int multipleStrikeBonus = frame.getFirstThrow();
						score = score + (frame.score() * 2 + multipleStrikeBonus);
					} else {
						score = score + (frame.score() * 2);
					}
				} else {
					int spareBonus = frame.getFirstThrow();
					score = score + (frame.score() + spareBonus);
					this.multipleStrikes = false;
				}
				this.isNextFrameBonus = false;
			} else {
				score = score + frame.score();
			}
	
			if (frame.isStrike()) {
				this.isNextFrameBonus = true;
				if (strikeHappened == true) {
					this.multipleStrikes = true;
				} 
				this.strikeHappened = true;
			}
			
			if (frame.isSpare()) {
				this.isNextFrameBonus = true;
				this.strikeHappened = false;
			}
			
			frameCount = frameCount + 1;
			if (frameCount == 10 && frame.isSpare()) {
				
			}
		}
		
		return score;
	}
	
	public boolean isNextFrameBonus(){
		return this.isNextFrameBonus;
	}
	
	public int getFramesCount() {
		return frames.size();
	}
	
	public boolean isGameFinished() {
		if (frames.size() == 10) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Frame> getFrames() {
		return this.frames;
	}
}
