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
package org.whole.lang.xsi.ui.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Enrico Persiani
 */
public class XsiSimpleStructuralFigure extends NodeFigure {

	public XsiSimpleStructuralFigure(int size) {
		setLayoutManager(new ColumnLayout());
		setBorder(new MarginBorder(4));
		initContentPanes(size);
		
		for (int i=0; i<size; i++)
			add(createContentPane(i));
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		List<ConnectionAnchor> anchors = new ArrayList<ConnectionAnchor>();
		for (int i=0; i<getContentPanesSize(); i++)
			anchors.addAll(findTargetAnchors(getContentPane(i)));
		return anchors.toArray(new ConnectionAnchor[anchors.size()]);
	}

	@SuppressWarnings("unchecked")
	public static List<ConnectionAnchor> findTargetAnchors(IFigure figure) {
		List<ConnectionAnchor> anchors = new ArrayList<ConnectionAnchor>();
		List<IFigure> children = figure.getChildren();
		for (int i=0; i<children.size(); i++) {
			IFigure child = children.get(i);
			if (child instanceof INodeFigure) {
				INodeFigure nodeFigure = (INodeFigure) child;
				for (int j=0, size=nodeFigure.getTargetAnchorsSize(); j<size; j++)
					anchors.add(nodeFigure.getTargetAnchor(j));
			} else
				anchors.addAll(findTargetAnchors(child));
		}
		return anchors;
	}
}
