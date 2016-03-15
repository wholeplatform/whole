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

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.ui.editparts.IEntityPart;


public class CompoundSelection extends SelectionPart {
	protected List<IWholeSelection> selectionList;

	public CompoundSelection(IWholeSelection first, IWholeSelection second) {
		selectionList = new ArrayList<IWholeSelection>();
		selectionList.add(first);
		selectionList.add(second);
	}

	public Kind getKind() {
		return Kind.COMPOUND;
	}

	public int size() {
		return selectionList.size();
	}

	@Override
	public IWholeSelection get(int i) {
		return selectionList.get(i);
	}

	@Override
	public IWholeSelection add(IWholeSelection selection) {
		if (selection == EmptySelection.instance)
			return this;
		if (selection.getKind() == Kind.COMPOUND) {
			for (int i=0; i<selection.size(); i++)
				selectionList.add(selection.get(i));
		} else
			selectionList.add(selection);
		return this;
	}

	@Override
	public IEntityPart getPart() {
		throw new IllegalArgumentException();
	}
	
	@Override
	public int getStartPosition() {
		throw new IllegalArgumentException();
	}

	@Override
	public int getEndPosition() {
		throw new IllegalArgumentException();
	}
}
