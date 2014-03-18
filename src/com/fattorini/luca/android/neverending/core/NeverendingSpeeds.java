package com.fattorini.luca.android.neverending.core;

/**
 * 
 * @author luca-fattorini
 * 
 */
public enum NeverendingSpeeds {
	falcon(2, 10), rockBiter(1, 20);

	private int delta;
	private int frequency;

	private NeverendingSpeeds(int delta, int frequency) {
		this.delta = delta;
		this.frequency = frequency;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
