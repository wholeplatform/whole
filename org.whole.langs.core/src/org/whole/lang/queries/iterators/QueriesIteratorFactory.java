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
package org.whole.lang.queries.iterators;

import java.util.Set;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class QueriesIteratorFactory extends IteratorFactory {
	public static CartesianProductIterator cartesianProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		return new CartesianProductIterator(iterators);
	}

	public static PointwiseProductIterator pointwiseProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		return new PointwiseProductIterator(iterators);
	}

	public static IEntityIterator<?> tupleFactoryIterator(IEntityIterator<?>... tupleIterators) {
		return new TupleFactoryIterator(tupleIterators);
	}

	public static <E extends IEntity> SelectIterator<E> selectIterator(IEntityIterator<E> selectIterator, IEntityIterator<? extends IEntity> fromIterator, IEntityIterator<? extends IEntity> whereIterator) {
		return new SelectIterator<E>(selectIterator, fromIterator, whereIterator);
	}

//	public static <E extends IEntity> SelectIterator<E> doIterator(IEntityIterator<E> doIterator) {
//		return selectIterator(doIterator, selfIterator(), emptyIterator());
//	}

	public static <E extends IEntity> IEntityIterator<E> callIterator(String name, IEntityIterator<? extends E>... argsIterators) {
    	return new CallIterator<E>(name, argsIterators);
    }
	public static <E extends IEntity> IEntityIterator<E> scopeIterator(IEntityIterator<E> scopeIterator, String environmentName, Set<String> localNames) {
    	return new LocalScopeIterator<E>(scopeIterator, localNames);
    }

	public static <E extends IEntity> IEntityIterator<E> deleteIterator(IEntityIterator<E> valuesIterator) {
		return new DeleteIterator<E>(valuesIterator);
	}

	public static <E extends IEntity> CartesianUpdateIterator<E> cartesianUpdateIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator) {
		return new CartesianUpdateIterator<E>(valuesIterator, toIterator);
	}

	public static <E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator) {
		return new PointwiseUpdateIterator<E>(valuesIterator, toIterator);
	}

	public static <E extends IEntity> CartesianInsertIterator<E> cartesianInsertIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator, Placement placement) {
		return new CartesianInsertIterator<E>(valuesIterator, toIterator, placement);
	}

	public static <E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator, Placement placement) {
		return new PointwiseInsertIterator<E>(valuesIterator, toIterator, placement);
	}
}
