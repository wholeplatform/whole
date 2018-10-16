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
public class IfEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected boolean conditionValue;
	protected boolean isFirstValue;

	@SuppressWarnings("unchecked")
	public IfEvaluator(IExecutable<IEntity> conditionExecutable, IExecutable<IEntity> doExecutable) {
		super(conditionExecutable, doExecutable);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		isFirstValue = true;
	}

	@Override
	protected boolean isValidResultProducer() {
		return isLastProducer();
	}

	@Override
	protected IEntity scopedEvaluateNext(boolean merge) {
		mergeLookaheadScope = merge;
		IEntity result = evaluateNext();
		mergeLookaheadScope = true;
		return result;
	}

	public IEntity evaluateNext() {
		if (isFirstProducer()) {
			conditionValue = scopedEvaluateAsBooleanOrFail(true);
			selectFollowingProducer();
		}

		return lastEntity = conditionValue ? enforceSomeValue(scopedEvaluateNext()) : null;
//FIXME		return lastEntity = conditionValue ? enforceSomeValue(getProducer().evaluateNext()) : null;
	}

//	@Override
//	public IBindingScope lookaheadScope() {
//		if (lastEntity == null)
//			return super.lookaheadScope();
//		IBindingScope scope = BindingManagerFactory.instance.createSimpleScope();
//		scope.wAddAll(getProducer(0).iterator().lookaheadScope());
//		scope.wAddAll(getProducer(1).iterator().lookaheadScope());
//		return scope;
//	}

//	public IEntity evaluateRemaining() {
//		if (isFirstProducer()) {
//			conditionValue = scopedEvaluateAsBooleanOrFail(true);
//			selectFollowingProducer();				
//		}
//			
//		return conditionValue ? enforceSomeValue(scopedEvaluateRemaining()) : null;
//	}

	protected IEntity enforceSomeValue(IEntity entity) {
		if (isFirstValue) {
			isFirstValue = false;
			return entity != null ? entity : BindingManagerFactory.instance.createVoid();
		} else
			return entity;
	}

	protected String toStringPrefix() {
		return "if ";
	}
	protected String toStringSeparator() {
		return " do ";
	}
	protected String toStringSuffix() {
		return "";
	}
}

