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

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsi.ui.figures.XsiCompositeElementNodeFigure;

/** 
 * @author Enrico Persiani
 */
public class XsiCompositeElementPart extends AbstractCompositePart {
	protected boolean isRoot;

	public XsiCompositeElementPart(boolean isRoot) {
		this.isRoot = isRoot;
	}

	@Override
	protected IFigure createFigure() {
		boolean startOpened = !getContents().isEmpty();
		IEntityFigure figure = new XsiCompositeElementNodeFigure(startOpened, createLabel());
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

	@Override
	public IEntityFigure getContentPaneFigure() {
		return (IEntityFigure) ((IEntityFigure) getFigure()).getContentPane(0);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List getModelChildren() {
		return getContents();
	}

	private List<IEntity> contents;
	private List<IEntity> getContents() {
		if (contents == null)
			return createFeatureList();
		return contents;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		createFeatureList();
		super.propertyChangeUI(evt);
	}

	private List<IEntity> createFeatureList() {
		contents = new ArrayList<IEntity>();
		IEntityIterator<IEntity> i = IteratorFactory.childIterator();
		i.reset(getModelEntity());
		for (IEntity feature : i)
			contents.add(feature);
		return contents;
	}
}
