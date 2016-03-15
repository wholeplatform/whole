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
package org.whole.lang.ui.actions;


/**
 * @author Enrico Persiani
 */
public final class NullActionRedirection implements IActionRedirection {

	private static class SingletonHolder {
		private static final NullActionRedirection instance = new NullActionRedirection();
	}
	public static NullActionRedirection instance() {
		return SingletonHolder.instance;
	}

	private NullActionRedirection() {
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public void performCut() {
		throw new UnsupportedOperationException();
	}
	@Override
	public void performCopy() {
		throw new UnsupportedOperationException();
	}
	@Override
	public void performPaste() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void performSelectAll() {
		throw new UnsupportedOperationException();
	}

	public void performUndo() {
		throw new UnsupportedOperationException();
	}

	public void performRedo() {
		throw new UnsupportedOperationException();
	}
}
