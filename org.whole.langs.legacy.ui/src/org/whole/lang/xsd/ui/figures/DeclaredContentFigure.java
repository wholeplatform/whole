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
package org.whole.lang.xsd.ui.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.xsi.ui.figures.XsiSimpleStructuralFigure;

/**
 * @author Enrico Persiani
 */
public class DeclaredContentFigure extends NodeFigure {
	public DeclaredContentFigure() {
		setLayoutManager(new ColumnLayout());
		initContentPanes(3);
		
		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2));
	}

	public void setContentPaneVisible(int index, boolean visible) {
		getContentPane(index).setVisible(visible);
		invalidateTargetAnchors();
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		List<ConnectionAnchor> anchors = new ArrayList<ConnectionAnchor>(3);
		for (int i=0; i<getContentPanesSize(); i++) {
			IFigure contentPane = getContentPane(i);
			if (contentPane.isVisible())
				anchors.addAll(XsiSimpleStructuralFigure.findTargetAnchors(contentPane));
		}
		return anchors.toArray(new ConnectionAnchor[anchors.size()]);
	}
}
