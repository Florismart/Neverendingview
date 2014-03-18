package com.fattorini.luca.android.neverending.view;

/**
 * 
 * @author luca-fattorini
 * 
 */
public interface NeverendingScrolllable {

	/**
	 * 
	 * @param delta
	 * @param direction
	 */
	public void scroll(final int delta, final int direction);

	/**
	 * Scroll view in base Natural position: if Horizontal will scroll to (0,0)
	 * - if Vertical will scroll to (0,0).
	 */
	public void scrollBaseNaturalPosition();

	/**
	 * Scroll view in base Innatural position: if Horizontal will scroll to
	 * (max_x,0) - if Vertical will scroll to (0,max_y).
	 */
	public void scrollBaseInnaturalPosition();
}
