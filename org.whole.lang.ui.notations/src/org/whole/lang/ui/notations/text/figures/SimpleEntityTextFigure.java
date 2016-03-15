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
package org.whole.lang.ui.notations.text.figures;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.IVisibilityManager;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.ManagedContentPaneFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class SimpleEntityTextFigure extends ManagedContentPaneFigure {
	private IFigure delimiter1, delimiter2, childrenFigure;

	public SimpleEntityTextFigure(EntityDescriptor<?> ed, IVisibilityManager visibilityManager, ActionListener linkListener) {
		super(new ColumnLayout().withSpacing(1), visibilityManager);
		int childSize = ed.childFeatureSize();
		initContentPanes(childSize);

		if (childSize == 0) {
			EntityFigure typeRow = new EntityFigure(new RowLayout().withSpacing(3));
			typeRow.addDeclaration(ed.getName());
			typeRow.addContentLight("{}");
			add(typeRow);
			return;
		}
		EntityFigure typeRow = new EntityFigure(new RowLayout().withSpacing(3));
		typeRow.add(createFoldingToggle(getVisibilityPaneIndex()+1));
		typeRow.addDeclaration(ed.getName());
		typeRow.addContentLight("{");
		typeRow.add(createVisibilityToggle());
		typeRow.add(delimiter1 = addContentLight("}"));
		add(typeRow);

		childrenFigure = new EntityFigure(new ColumnLayout().withSpacing(1));
		for (int i=0; i<childSize; i++) {
			EntityFigure featureRow = new EntityFigure(
					new RowLayout().withMinorAlignment(Alignment.LEADING).withMarginLeft(24));
			featureRow.addContent(ed.getEntityFeatureDescriptor(i).getName());
			featureRow.addContentLighter(": ");
			featureRow.add(createContentPane(i));
			childrenFigure.add(featureRow);
		}	
		for (int i=childSize, size=ed.featureSize(); i<size; i++) {
			EntityFigure featureRow = new EntityFigure(
					new RowLayout().withMinorAlignment(Alignment.LEADING).withMarginLeft(24));
			featureRow.addContent(ed.getEntityFeatureDescriptor(i).getName());
			featureRow.addContentLighter(": ");
			featureRow.add(new EntityButton(linkListener, i));
			childrenFigure.add(featureRow);
		}
		add(childrenFigure);

		delimiter2 = addContentLight("}");
		
		delimiter1.setVisible(false);

		initVisibilityToggle();
	}

	protected IFigure getContentPaneContainer() {
		return childrenFigure;
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == getVisibilityPaneIndex()+1) {
			boolean visible = !childrenFigure.isVisible();
			delimiter1.setVisible(!visible);
			childrenFigure.setVisible(visible);
			delimiter2.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}
}
