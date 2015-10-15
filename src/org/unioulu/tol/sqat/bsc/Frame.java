package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	private boolean isStrike = false;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		int score = 0;
		if (firstThrow == 10) {
			this.isStrike = true;
			score = 10;
		} else {
			score = firstThrow + secondThrow;
		}
		
		return score;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		return isStrike;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}
}
