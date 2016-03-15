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

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.notations.outline.figures.AbstractOutlineSimpleNodeFigure;

/** 
 * @author Enrico Persiani, Riccardo Solmi
 */
public class XsiSimpleElementNodeFigure extends AbstractOutlineSimpleNodeFigure {
	protected Label label;

	public XsiSimpleElementNodeFigure(boolean startOpened, Label label, int attributes, int contents) {

		super(startOpened, attributes+contents);

		if (attributes+contents == 0)
			getFoldingToggle(0).setVisible(false);
		else
			bindFoldingToggle(-1, 0);

		EntityFigure labelContainer = getLabelFigure();
		labelContainer.add(this.label = label);
		for (int i=0; i<attributes; i++)
			labelContainer.add(createContentPane(i));

		IFigure contentsFigure = getContentsFigure();
		for (int i=attributes; i<attributes+contents; i++) {
			contentsFigure.add(createContentPane(i, new MarginBorder(4, 0, 0, 0)));
			bindFoldingToggle(0, i);
		}
		add(contentsFigure);
	}

	protected IFigure contents;
	protected IFigure getContentsFigure() {
		if (contents == null)
			contents = new EntityFigure(new ColumnLayout().withMarginLeft(16));
		return contents;
	}
	
	public void setContentPaneVisible(int index, boolean visible) {
		getContentPane(index).setVisible(visible);
		invalidateTargetAnchors();
	}

	protected void toggleVisibility(int paneIndex) {
		getContentsFigure().setVisible(!getContentsFigure().isVisible());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<IFigure> getContents() {
		return getContentsFigure().getChildren();
	}

	@Override
	protected boolean isContentVisible() {
		return getContentsFigure().isVisible();
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		IFigure toggle = getFoldingToggle(0);
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(toggle.isVisible() ? toggle : getLabelFigure() , 0, 0.5)
		};
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		IFigure toggle = getFoldingToggle(0);
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(toggle.isVisible() ? toggle : getLabelFigure() , 0.5, 1.0)
		};
	}
}
