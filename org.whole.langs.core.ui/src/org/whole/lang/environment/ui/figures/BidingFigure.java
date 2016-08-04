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
package org.whole.lang.environment.ui.figures;

import org.eclipse.draw2d.ChangeEvent;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.EyeFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.ViewportTracking;

/**
 * @author Enrico Persiani
 */
public class BidingFigure extends ContentPaneFigure {

	public BidingFigure() {
		setLayoutManager(new TableRowLayout().withMargin(4,4,4,4));
		initContentPanes(4);

		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2, ViewportTracking.BOTH));

		IEntityFigure toggleFigure = new EntityFigure(new MonoLayout().withAutoresizeWeight(1.0f))
				.withViewportTracking(ViewportTracking.BOTH);
		EyeFigure eye = new EyeFigure();
		EntityToggle entityToggle = new EntityToggle(eye, null);
		entityToggle.addChangeListener((ChangeEvent event) -> eye.setClosed(entityToggle.isSelected()));
		toggleFigure.add(createFoldingToggle(entityToggle, 3));
		add(toggleFigure);
	
		addWithPlaceHolder(createContentPane(3));

		clickFoldingToggle(0);
	}
}
