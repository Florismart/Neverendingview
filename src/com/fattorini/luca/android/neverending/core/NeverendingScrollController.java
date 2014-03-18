package com.fattorini.luca.android.neverending.core;

import android.os.Handler;

import com.fattorini.luca.android.neverending.core.entity.NeverendingLopeEntity;
import com.fattorini.luca.android.neverending.view.NeverendingScrolllable;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class NeverendingScrollController {
	private NeverendingScrolllable neverendingScrollable;

	private boolean enabled;
	private NeverendingModes mode;

	private NeverendingLopeEntity lopeEntity;
	private int scrollRestartInterval = 3000;

	private Handler scrollHandler = new Handler();
	private Handler scrollRestarterHandler = new Handler();

	public NeverendingScrollController(boolean enabled, NeverendingModes mode, NeverendingScrolllable neverendingScrollable,
			NeverendingLopeEntity lopeEntity) {
		this.enabled = enabled;
		this.mode = mode;
		this.neverendingScrollable = neverendingScrollable;
		this.lopeEntity = lopeEntity;

		if (enabled)
			scrollHandler.post(scrollRunner);
	}

	private Runnable scrollRunner = new Runnable() {
		@Override
		public void run() {
			neverendingScrollable.scroll(lopeEntity.getDelta(), mode.getDirection());
			if (enabled)
				scrollHandler.postDelayed(this, lopeEntity.getFrequency());
		}
	};

	private Runnable scrollRestarterRunner = new Runnable() {
		@Override
		public void run() {
			if (NeverendingModes.natural.equals(mode))
				neverendingScrollable.scrollBaseNaturalPosition();
			else
				neverendingScrollable.scrollBaseInnaturalPosition();
			start();
		}
	};

	/**
	 * 
	 * Start the Neverendingscrolling.
	 */
	public NeverendingScrollController start() {
		if (!enabled)
			scrollHandler.postDelayed(scrollRunner, lopeEntity.getFrequency());
		enabled = true;
		return this;
	}

	/**
	 * 
	 * Stop the Neverendingscrolling.
	 */
	public NeverendingScrollController stop() {
		enabled = false;
		return this;
	}

	/**
	 * 
	 * @param mode
	 * @return fluent istance of Controller.
	 */
	public NeverendingScrollController setMode(final NeverendingModes mode) {
		this.mode = mode;
		return this;
	}

	/**
	 * 
	 * @return current NeverendingModes.
	 */
	public NeverendingModes getMode() {
		return mode;
	}

	/**
	 * OnLimitReached event. Stops Neverendingscrolling and resume from base
	 * position.
	 */
	public void onLimitReached() {
		stop();
		scrollRestarterHandler.postDelayed(scrollRestarterRunner, scrollRestartInterval);
	}

}
