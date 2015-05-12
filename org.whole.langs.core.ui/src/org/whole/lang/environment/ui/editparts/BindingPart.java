/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.environment.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.environment.factories.EnvironmentEntityFactory;
import org.whole.lang.environment.model.Binding;
import org.whole.lang.environment.model.Value;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.figures.TableRowFigure;

/**
 * @author Riccardo Solmi
 */
public class BindingPart extends AbstractPart {
	protected IFigure createFigure() {
		TableRowFigure f = new TableRowFigure();
		f.getLayoutManager().withMargin(4,4,4,4);
		return f;
	}

	protected List<IEntity> getModelSpecificChildren() {
		Binding binding = getModelEntity();
		Value valueEntity = binding.getValue();
		IEntity value = Matcher.matchImpl(EnvironmentEntityDescriptorEnum.Value, valueEntity) ? valueEntity.getValue() : valueEntity.wGetAdaptee(true);
		List<IEntity> children = new ArrayList<IEntity>(4);
		children.add(EnvironmentEntityFactory.instance.createId(Integer.toHexString(System.identityHashCode(value))));
		children.add(ModelsEntityFactory.instance.createEntityType(value.wGetEntityDescriptor().getURI()));
		children.add(binding.getName());
		children.add(value);
		return children;
	}
}
