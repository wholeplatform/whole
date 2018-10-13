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
package org.whole.lang.evaluators;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ForEvaluator extends ComposeEvaluator {
	protected boolean hasForValue = false;
	protected boolean isFirstValue = true;

	public ForEvaluator(IExecutable<IEntity> forExecutable, IExecutable<IEntity> doExecutable) {
		super(forExecutable, doExecutable);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		hasForValue = false;
		isFirstValue = true;
	}

	@Override
	protected boolean needMergeExecutorScope(/*int producerIndex*/) {
		return mergeLookaheadScope;// super.mergeExecutorScope() ;//&& isLastProducer();
	}

	@Override
	protected IEntity enforceSomeValue(IEntity entity) {
		if (isFirstValue && hasForValue) {
			isFirstValue = false;
			return entity != null ? entity : BindingManagerFactory.instance.createVoid();
		} else
			return entity;
	}

	protected String toStringPrefix() {
		return "for ";
	}
	protected String toStringSeparator() {
		return " do ";
	}
	protected String toStringSuffix() {
		return "";
	}
}

