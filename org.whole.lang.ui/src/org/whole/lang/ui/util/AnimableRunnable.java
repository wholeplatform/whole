/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.ui.util;

import org.eclipse.draw2d.Animation;
import org.eclipse.swt.widgets.Display;

/** 
 * @author Enrico Persiani, Riccardo Solmi
 */
public abstract class AnimableRunnable implements Runnable {
	public static final int DEFAULT_DELAY = 250;
	public static final int NO_ANIMATION = 0;
	private int millis;

	public AnimableRunnable() {
		this(DEFAULT_DELAY);
	}
	public AnimableRunnable(int millis) {
		this.millis = millis;
	}

	protected static boolean animate = true;
	public static boolean isEnabled() {
		return animate;
	}
	public static boolean enableAnimation(final boolean animate) {
		boolean animateOld = AnimableRunnable.animate;
		//TODO test
		if (animate && animateOld != animate) {
			final Display display = Display.getDefault();
			Runnable runnable = new Runnable() {
				private boolean schedule = true;
				public void run() {
					if (schedule) {
						display.timerExec(100, this);
						schedule = false;
					} else
						AnimableRunnable.animate = animate;
				}
			};
			// reschedule after all UI updates
			display.wake();
			display.asyncExec(runnable);
		} else
			AnimableRunnable.animate = animate;
		return animateOld;
	}

	public final void run() {
		if (!animate || millis == NO_ANIMATION)
			doRun();
		else {
			Animation.markBegin();
			boolean oldAnimate = enableAnimation(false);
			doRun();
			enableAnimation(oldAnimate);
			Animation.run(millis);
		}
	}

	public abstract void doRun();

	public void asyncExec() {
		Display.getDefault().asyncExec(this);
	}

	public void syncExec() {
		Display.getDefault().syncExec(this);
	}
}
