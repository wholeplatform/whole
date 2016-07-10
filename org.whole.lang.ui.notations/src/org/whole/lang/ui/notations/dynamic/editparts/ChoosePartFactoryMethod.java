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
package org.whole.lang.ui.notations.dynamic.editparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Riccardo Solmi
 */
public class ChoosePartFactoryMethod<T extends IEditPartFactory> implements IOptionalPartFactoryMethod<T> {
	private List<IOptionalPartFactoryMethod<T>> factoryMethods = new ArrayList<>();

	public ChoosePartFactoryMethod<T> when(IPredicatePartFactoryMethod<T> predicate, IEntityPartFactoryMethod<T> factoryMethod) {
		WhenPartFactoryMethod<T> whenFactoryMethod = new WhenPartFactoryMethod<T>(predicate, factoryMethod);
		factoryMethods.add(whenFactoryMethod);
		return this;
	}
	public ChoosePartFactoryMethod<T> otherwise(IEntityPartFactoryMethod<T> factoryMethod) {
		factoryMethods.add(factoryMethod);
		return this;
	}


	public Optional<IEntityPart> apply(T contextFactory, IEntityPart contextPart, IEntity entity) {
		for (IOptionalPartFactoryMethod<T> factoryMethod : factoryMethods) {
			Optional<IEntityPart> result = factoryMethod.apply(contextFactory, contextPart, entity);
			if (result.isPresent())
				return result;
		}
		return Optional.empty();
	}
}