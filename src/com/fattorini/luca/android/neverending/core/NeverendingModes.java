package com.fattorini.luca.android.neverending.core;

/**
 * 
 * @author luca-fattorini
 * 
 */
public enum NeverendingModes {
	natural(1), innatural(-1);

	private int direction;

	private NeverendingModes(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}

}
