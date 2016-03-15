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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.whole.lang.ui.figures.IQualifiedFigure;
import org.whole.lang.ui.figures.OverQualifiedDataEntityFigure;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractOverQualifiedDataEntityPart extends AbstractDataEntityPart {
	protected IFigure createFigure() {
		return new OverQualifiedDataEntityFigure();
	}

	protected Label getLabel() {
		return ((IQualifiedFigure) getFigure()).getNameLabel();
	}

	@Override
	protected void refreshVisuals() {
//no		super.refreshVisuals();
		String qname = getModelEntity().wStringValue();
		((IQualifiedFigure) getFigure()).setQualifierName(getQualifierPart(qname));
    	getLabel().setText(getNamePart(qname));
	}
	protected abstract String getQualifierPart(String qname);
	protected String getNamePart(String qname) {
		return ResourceUtils.stripResourcePart(qname);
	}
}
