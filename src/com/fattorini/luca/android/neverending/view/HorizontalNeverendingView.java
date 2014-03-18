package com.fattorini.luca.android.neverending.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import com.fattorini.luca.android.neverending.R;
import com.fattorini.luca.android.neverending.core.NeverendingModes;
import com.fattorini.luca.android.neverending.core.NeverendingScrollController;
import com.fattorini.luca.android.neverending.core.NeverendingSpeeds;
import com.fattorini.luca.android.neverending.core.OnLimitReachedEventListener;
import com.fattorini.luca.android.neverending.core.entity.NeverendingLopeEntity;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class HorizontalNeverendingView extends HorizontalScrollView implements NeverendingScrolllable {
	private NeverendingScrollController controller;
	private OnLimitReachedEventListener limitReachedListener;

	public HorizontalNeverendingView(Context context) {
		super(context);
	}

	public HorizontalNeverendingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttributes(context, attrs);
	}

	public HorizontalNeverendingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initAttributes(context, attrs);
	}

	protected void initAttributes(final Context context, final AttributeSet attrs) {
		boolean enabled = true;
		NeverendingModes mode = NeverendingModes.natural;
		if (attrs != null) {
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Neverender);
			enabled = a.getBoolean(R.styleable.Neverender_enabled, true);
			int modeIndex = a.getInteger(R.styleable.Neverender_mode, 0);
			mode = NeverendingModes.values()[modeIndex > NeverendingModes.values().length ? 0 : modeIndex];
			a.recycle();
		}
		controller = new NeverendingScrollController(enabled, mode, this, new NeverendingLopeEntity(NeverendingSpeeds.rockBiter));
	}

	@Override
	public void scroll(final int delta, final int direction) {
		scrollBy(delta * direction, 0);
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldX, int oldY) {
		super.onScrollChanged(x, y, oldX, oldY);

		if (NeverendingModes.natural.equals(controller.getMode())) {
			if (x + getWidth() >= getChildAt(0).getWidth())
				onLimitReached();
		} else {
			if (x <= 0)
				onLimitReached();
		}

	}

	protected void onLimitReached() {
		if (limitReachedListener != null)
			limitReachedListener.onLimitReached(controller.getMode(), controller);
		else
			controller.onLimitReached();
	}

	public NeverendingScrollController getController() {
		return controller;
	}

	public void setController(NeverendingScrollController controller) {
		this.controller = controller;
	}

	@Override
	public void scrollBaseNaturalPosition() {
		scrollTo(0, 0);
	}

	@Override
	public void scrollBaseInnaturalPosition() {
		scrollTo(getChildAt(0).getWidth(), 0);
	}

	/**
	 * 
	 * @return OnLimitReachedEventListener.
	 */
	public OnLimitReachedEventListener getLimitReachedListener() {
		return limitReachedListener;
	}

	/**
	 * 
	 * @param limitReachedListener
	 *            .
	 */
	public void setLimitReachedListener(OnLimitReachedEventListener limitReachedListener) {
		this.limitReachedListener = limitReachedListener;
	}

}
