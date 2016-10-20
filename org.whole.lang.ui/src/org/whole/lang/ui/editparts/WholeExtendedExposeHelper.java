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
package org.whole.lang.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.whole.lang.ui.figures.IFoldableFigure;

/**
 * @author Enrico Persiani
 */
public class WholeExtendedExposeHelper implements ExtendedExposeHelper {
	protected GraphicalEditPart hostPart;

	public WholeExtendedExposeHelper(GraphicalEditPart hostPart) {
		this.hostPart = hostPart;
	}
	public void exposeChild(EditPart childPart) {
		if (!(childPart instanceof GraphicalEditPart))
			return;
		IFigure figure = ((GraphicalEditPart) childPart).getFigure();
		for (IFoldableFigure foldable : getFoldableAncestors(figure))
			for (Toggle toggle : foldable.getFoldingToggles(figure))
				if (toggle.isSelected())
					toggle.doClick();
	}

	public void exposeDescendant(EditPart descendantPart) {
		List<?> children = hostPart.getChildren();
		while (!children.contains(descendantPart))
			descendantPart = descendantPart.getParent();
		exposeChild(descendantPart);
	}

	private List<IFoldableFigure> getFoldableAncestors(IFigure figure) {
		IFigure hostFigure = hostPart.getFigure();
		List<IFoldableFigure> result = new ArrayList<IFoldableFigure>(1);
		IFigure foldableFigure = figure;
		do {
			//FIXME ? workaround
			if (foldableFigure == null)
				break;

			foldableFigure = foldableFigure.getParent();
			if (foldableFigure instanceof IFoldableFigure)
				result.add((IFoldableFigure) foldableFigure);
		} while (foldableFigure != hostFigure);
		return result;
	}
}
