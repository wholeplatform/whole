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
package org.whole.lang.xsd.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractNodePart;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xsd.model.DeclaredContent;
import org.whole.lang.xsd.ui.figures.DeclaredContentFigure;

/**
 * @author Enrico Persiani
 */
public class DeclaredContentPart extends AbstractNodePart {
	protected boolean hideOptionals;

	public DeclaredContentPart(boolean hideOptionals) {
		this.hideOptionals = hideOptionals;
	}
	public DeclaredContentPart() {
		this(false);
	}

	protected IFigure createFigure() {
		return new DeclaredContentFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		DeclaredContent entity = getModelEntity();
		List<IEntity> children = new ArrayList<IEntity>(3);
		children.add(entity.getModelGroup());
		children.add(entity.getAttributeUses());
		children.add(entity.getAnyAttribute());
		return children;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}
	protected void refreshVisuals() {
		DeclaredContentFigure figure = (DeclaredContentFigure) getFigure();
		List<IEntity> children = getModelChildren();
		for (int i=0, size=children.size(); i<size; i++) {
			IEntity child = children.get(i);
			figure.setContentPaneVisible(i, !hideOptionals ||
					(!EntityUtils.isResolver(child) && !(EntityUtils.isComposite(child) && child.wIsEmpty())));
		}
	}
}
