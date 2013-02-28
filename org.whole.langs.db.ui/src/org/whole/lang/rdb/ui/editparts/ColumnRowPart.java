/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.rdb.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.model.Column;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.figures.TableRowFigure;

/**
 * @author Enrico Persiani
 */
public class ColumnRowPart extends AbstractPart {
	protected IFigure createFigure() {
		return new TableRowFigure();
	}

	@Override
	protected List<IEntity> getModelSpecificChildren() {
		List<IEntity> children = new ArrayList<IEntity>(9);
		Column entity = getModelEntity();
		children.add(entity.getName());
		children.add(entity.getFeatureName());
		children.add(entity.getFeatureType());
		children.add(entity.getType());
		children.add(entity.getSize());
		children.add(entity.getDecimals());
		children.add(entity.getNullable());
		children.add(entity.getDefaultValue());
		children.add(entity.getRemarks());
		return children;
	}
}
