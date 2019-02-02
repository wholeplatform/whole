/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.properties.visitors;

import org.whole.lang.model.IEntity;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.model.Property;
import org.whole.lang.properties.model.PropertyName;
import org.whole.lang.properties.model.PropertyValue;

/**
 * @author Enrico Persiani
 */
public class PropertiesInterpreterVisitor extends PropertiesTraverseAllVisitor {
    @Override
	public void visit(PropertyName entity) {
		setResult(entity);
	}

	@Override
	public void visit(PropertyValue entity) {
		setResult(entity);
	}

	@Override
	public void visit(Property entity) {
		entity.getName().accept(this);
		String name = getResult().wStringValue();

		entity.getValue().accept(this);
		IEntity value = getResult();

		getBindings().wDef(name, value);
	}

	public void visit(Properties entity) {
		entity.getDefaults().accept(this);
		entity.getEntries().accept(this);
	}
}
