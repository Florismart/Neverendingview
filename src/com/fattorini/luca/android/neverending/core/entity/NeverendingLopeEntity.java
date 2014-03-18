package com.fattorini.luca.android.neverending.core.entity;

import com.fattorini.luca.android.neverending.core.NeverendingSpeeds;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class NeverendingLopeEntity {
	private int delta;
	private int frequency;

	public NeverendingLopeEntity(int delta, int frequency) {
		this.delta = delta;
		this.frequency = frequency;
	}

	public NeverendingLopeEntity(NeverendingSpeeds configuredSpeed) {
		this.delta = configuredSpeed.getDelta();
		this.frequency = configuredSpeed.getFrequency();
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
