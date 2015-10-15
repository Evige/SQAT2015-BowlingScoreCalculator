package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private boolean isNextFrameBonus = false;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		frames.add(frame);
		
	}
	
	public void addAllFrames(List<Frame> allFrames) {
		this.frames = allFrames;
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int score = 0;
		for (Frame frame : frames) {
			if (isNextFrameBonus()) {
				score = score + frame.score();
				score = score * 2;
				this.isNextFrameBonus = false;
			} else {
				score = score + frame.score();
			}
	
			if (frame.isStrike()) {
				this.isNextFrameBonus = true;
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
