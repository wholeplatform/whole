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
package org.whole.lang.semantics.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.semantics.model.Configuration;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.ui.figures.ConfigurationFigure;
import org.whole.lang.ui.editparts.AbstractCompositePart;

/**
 * @author Riccardo Solmi
 */
public class ConfigurationPart extends AbstractCompositePart {
	protected IFigure createFigure() {
		return new ConfigurationFigure();
	}
	@Override
	public ConfigurationFigure getFigure() {
		return (ConfigurationFigure) super.getFigure();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		Configuration entity = getModelEntity();
		getFigure().showAsInternal(!(entity.size()==1 && Matcher.isAssignableAsIsFrom(
				SemanticsEntityDescriptorEnum.Environment, entity.wGet(0))));
	}
}
