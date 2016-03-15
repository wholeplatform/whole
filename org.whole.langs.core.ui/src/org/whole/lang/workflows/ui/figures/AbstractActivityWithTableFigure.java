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
package org.whole.lang.workflows.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractActivityWithTableFigure extends AbstractActivityFigure {
	public AbstractActivityWithTableFigure(int contentPanes, Image image) {
		super(contentPanes, image);
	}

	protected IFigure createContentFigure() {
		return createTableFigure(createTableLayout(2));
	}
	protected ICompositeEntityLayout createTableLayout(int columns) {
		return new TableLayout(columns).withRowSpacing(2).withColumnSpacing(8).withMargin(4, 5, 5, 5);
	}
	protected abstract TableFigure createTableFigure(ICompositeEntityLayout layout);
}
