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
package org.whole.lang.e4.ui.util;

/**
 * @author Enrico Persiani
 */
public class ChangeTracker {
	public static final Object SKIP = new Object();

	protected Object[] tracked;

	protected ChangeTracker(Object... tracked) {
		this.tracked = tracked;
	}

	public static ChangeTracker create(Object... tracked) {
		return new ChangeTracker(tracked);
	}

	public boolean isChanged(Object... objects) {
		if (tracked.length != objects.length)
			return true;
		for (int i=0; i<objects.length; i++)
			if (objects[i] != SKIP && !objects[i].equals(tracked[i]))
				return true;
		return false;
	}

	public synchronized boolean testChangedAndUpdate(Object... objects) {
		boolean changed = isChanged(objects);
		if (changed) {
			Object[] updated = new Object[objects.length];
			for (int i=0; i<objects.length; i++)
				updated[i] = (objects[i] == SKIP && i<tracked.length)  ? tracked[i] : objects[i];
			tracked = updated;
		}
		return changed;
	}
}
