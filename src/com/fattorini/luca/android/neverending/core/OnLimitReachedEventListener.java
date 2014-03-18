package com.fattorini.luca.android.neverending.core;

/**
 * 
 * @author luca-fattorini
 * 
 */
public interface OnLimitReachedEventListener {

	/**
	 * OnLimitReached Event.
	 * 
	 * @param mode
	 * @param scrollController
	 */
	public void onLimitReached(NeverendingModes mode, NeverendingScrollController scrollController);
}
