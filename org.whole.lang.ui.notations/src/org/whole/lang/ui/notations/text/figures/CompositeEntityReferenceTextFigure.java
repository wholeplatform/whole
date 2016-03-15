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
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityReferenceTextFigure extends ContentPaneFigure {
	protected ActionListener linkListener;
	protected IFigure delimiter1, delimiter2;
	protected CompositeFigure compositeFigure;

	public CompositeEntityReferenceTextFigure(EntityDescriptor<?> ed, ActionListener linkListener) {
		super(new ColumnLayout());
		initContentPanes(1);
		this.linkListener = linkListener;

		EntityFigure typeRow = new EntityFigure(new RowLayout());
		typeRow.addDeclaration(ed.getName());
		typeRow.addContent(" [");
		typeRow.add(createFoldingToggle(0));
		typeRow.add(delimiter1 = addContent("]"));
		add(typeRow);

		compositeFigure = new CompositeFigure(
				new ColumnLayout().withSpacing(5).withMarginLeft(24));
		compositeFigure.setBorder(null);
		add(createContentPane(0, compositeFigure));

		delimiter2 = addContent("]");
		
		delimiter1.setVisible(false);
	}

	public void setAdjacentSize(int size) {
		for (int i=compositeFigure.getChildren().size(); i<size; i++) {
			EntityFigure featureRow = new EntityFigure(new TableRowLayout()
					.withMinorAlignment(Alignment.LEADING));
			featureRow.add(new EntityButton(linkListener, i));
			compositeFigure.add(featureRow);
		}

		while (compositeFigure.getChildren().size() > size)
			compositeFigure.remove((IFigure) compositeFigure.getChildren().get(size));

		revalidate();
		repaint();
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 0) {
			IFigure contentPane = getContentPane(paneIndex);
			boolean visible = !contentPane.isVisible();
			delimiter1.setVisible(!visible);
			contentPane.setVisible(visible);
			delimiter2.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}
}
