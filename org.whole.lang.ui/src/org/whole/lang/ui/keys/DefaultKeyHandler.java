/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.keys;

import org.whole.lang.ui.tools.EditPoint;
import org.whole.lang.ui.tools.IEditPointProvider;
import org.whole.lang.ui.tools.IWholeSelection;
import org.whole.lang.ui.tools.SelectionPart;

public class DefaultKeyHandler implements IKeyHandler {
	private static class SingletonHolder {
		private static final DefaultKeyHandler instance = new DefaultKeyHandler();
	}
	public static DefaultKeyHandler instance() {
		return SingletonHolder.instance;
	}
	protected DefaultKeyHandler() {
	}

	public EditPoint findNeighbour(IEditPointProvider editPointProvider, EditPoint editPoint, int direction) {
		return null;
	}
	
	public IWholeSelection calculateDoubleClickSelection(EditPoint editPoint) {
		return new SelectionPart(editPoint.focus);
	}
	
	public IWholeSelection calculateTripleClickSelection(EditPoint editPoint) {
		return calculateDoubleClickSelection(editPoint);
	}
}
