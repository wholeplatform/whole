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
package org.whole.lang.ui.tools;

import org.whole.lang.ui.editparts.IEntityPart;

public class SelectionPart implements IWholeSelection {
	protected IEntityPart part;

	public SelectionPart(IEntityPart part) {
		this.part = part;
	}
	public SelectionPart() {
		this(null);
	}

	public Kind getKind() {
		return Kind.PART;
	}
	
	public int size() {
		return 1;
	}

	public IWholeSelection add(IWholeSelection selection) {
		if (selection == EmptySelection.instance)
			return this;
		else
			return new CompoundSelection(this, selection);
	}

	public IWholeSelection addAll(IWholeSelection... selections) {
		IWholeSelection first = this;
		for (int i = 0; i<selections.length; i++)
			first = first.add(selections[i]);
		return first;
	}

	public IWholeSelection get(int i) {
		if (i != 0)
			throw new IllegalArgumentException();
		return this;
	}

	public IEntityPart getPart() {
		return part;
	}

	public int getEndPosition() {
		throw new IllegalArgumentException();
	}
	
	public int getStartPosition() {
		throw new IllegalArgumentException();
	}
}
