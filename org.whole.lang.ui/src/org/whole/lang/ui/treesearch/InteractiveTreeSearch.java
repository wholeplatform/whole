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
package org.whole.lang.ui.treesearch;

import java.util.BitSet;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 * @author Riccardo Solmi
 */
public class InteractiveTreeSearch implements ITreeSearch {
	protected BitSet inheritedInteractiveStack = new BitSet();

	protected boolean peekInheritedInteractiveEdit(IFigure figure) {
		if (inheritedInteractiveStack.length() > 0)
			return inheritedInteractiveStack.get(inheritedInteractiveStack.length()-1);
		else
			return true; //TODO test calculateInteractiveEdit(figure.getParent());
	}

	public boolean prune(IFigure figure) {
		boolean value;
		if (figure instanceof IEntityFigure) {
			IEntityFigure entityFigure = (IEntityFigure) figure;
			value = entityFigure.isInteractiveInherited() ?
					peekInheritedInteractiveEdit(figure) : entityFigure.isInteractiveEdit();
		} else
			value = peekInheritedInteractiveEdit(figure);
	
		inheritedInteractiveStack.set(inheritedInteractiveStack.length(), value);
		return false;
	}

	public boolean accept(IFigure figure) {
		boolean value = peekInheritedInteractiveEdit(figure);
		if (inheritedInteractiveStack.length() > 0)
			inheritedInteractiveStack.clear(inheritedInteractiveStack.length()-1);
		return value;
	}

	public static boolean calculateInteractiveEdit(IFigure figure) {
		if (figure == null)
			return true;
		else if (figure instanceof IEntityFigure) {
			IEntityFigure entityFigure = (IEntityFigure) figure;
			return entityFigure.isInteractiveInherited() ?
					calculateInteractiveEdit(figure.getParent()) : entityFigure.isInteractiveEdit();			
		} else
			return calculateInteractiveEdit(figure.getParent());
	}

	public static boolean calculateInteractiveBrowse(IFigure figure) {
		if (figure == null)
			return true;
		else if (figure instanceof IEntityFigure) {
			IEntityFigure entityFigure = (IEntityFigure) figure;
			return entityFigure.isInteractiveInherited() ?
					calculateInteractiveBrowse(figure.getParent()) : entityFigure.isInteractiveBrowse();			
		} else
			return calculateInteractiveBrowse(figure.getParent());
	}
}