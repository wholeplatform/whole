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
package org.whole.lang.operations;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class NormalizerOperation extends AbstractOperation {
	public static final String ID = "normalizer";

	public static <E extends IEntity> E normalize(E entity) {
		return normalize(entity, BindingManagerFactory.instance.createArguments());
	}
	public static <E extends IEntity> E normalize(E entity, IBindingManager args) {
		new NormalizerOperation(args).stagedVisit(entity);
		return entity;
	}

	protected NormalizerOperation(IBindingManager args) {
		super(ID, args, null);
	}
	
	@Override
	protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		return GenericTraversalFactory.instance.identity();
	}
}
