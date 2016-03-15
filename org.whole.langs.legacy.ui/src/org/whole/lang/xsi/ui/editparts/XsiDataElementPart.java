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
package org.whole.lang.xsi.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.editparts.AbstractDataEntityPart;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsi.ui.figures.XsiDataElementFigure;

/** 
 * @author Enrico Persiani
 */
public class XsiDataElementPart extends AbstractDataEntityPart {
	protected boolean isRoot;

	public XsiDataElementPart(boolean isRoot) {
		this.isRoot = isRoot;
	}

	protected IFigure createFigure() {
		IEntityFigure figure = new XsiDataElementFigure(true, createLabel());
		if (isRoot)
			figure.setBorder(new MarginBorder(4, 8, 2, 4));
		return figure;
	}

	protected EntityLabel createLabel() {
		String tagName = MappingStrategyUtils.getElementNCName(getModelEntity());
		EntityLabel label = LabelFactory.createContent(tagName);
		label.setIcon(NotationImages.XML_TAG16);
		return label;
	}
}
