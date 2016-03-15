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
package org.whole.lang.ui.figures;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.editparts.IVisibilityManager;
import org.whole.lang.ui.layout.IEntityLayout;

/**
 * @author Riccardo Solmi
 */
public abstract class ManagedContentPaneFigure extends ContentPaneFigure {
	protected IVisibilityManager visibilityManager;

	public ManagedContentPaneFigure(IEntityLayout layout, IVisibilityManager visibilityManager) {
		super(layout);
		this.visibilityManager = visibilityManager;
	}

	protected Toggle createVisibilityToggle() {
		return createFoldingToggle(new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND), getVisibilityPaneIndex());
	}
	protected void initVisibilityToggle() {
		if (visibilityManager.isChildrenVisibilityInitiallyEnabled())
			clickFoldingToggle(toggleIndexOf(getVisibilityPaneIndex()));
	}
	protected Toggle getVisibilityToggle() {
		return getFoldingToggle(toggleIndexOf(getVisibilityPaneIndex()));
	}
	protected int getVisibilityPaneIndex() {
		return getContentPanesSize();
	}

	public void setContentPaneVisible(int paneIndex, boolean visible) {
		((IFigure) getContentPaneContainer().getChildren().get(paneIndex)).setVisible(visible);
	}
	protected abstract IFigure getContentPaneContainer();

	@Override
	public List<Toggle> getFoldingToggles(IFigure figure) {
		List<Toggle> toggles = super.getFoldingToggles(figure);

		int paneIndex = ancestorOrSelfContentPaneIndexOf(figure);
		if (paneIndex > 0 && !visibilityManager.isChildVisible(paneIndex))
			toggles.add(getVisibilityToggle());

		return toggles;
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == getVisibilityPaneIndex())
			if (getVisibilityToggle().isSelected())
				for (int i=0, size=contentPanes.length; i<size; i++)
					setContentPaneVisible(i, visibilityManager.isChildVisible(i));
			else
				for (int i=0, size=contentPanes.length; i<size; i++)
					setContentPaneVisible(i, true);
	}
}
