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
package org.whole.lang.commons.visitors;

import org.whole.lang.commons.model.ICommonsEntity;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Riccardo Solmi
 */
public class CommonsDynamicCompilerVisitor extends CommonsIdentityDefaultVisitor {
	@Override
	public void visit(ICommonsEntity entity) {
		setResultIterator(IteratorFactory.templateInterpreterIterator(entity).withSourceEntity(entity));
	}

	@Override
	public void visit(StageDownFragment entity) {
		if (getStage() > 0)
			super.visit(entity);
		else {
			setResult(null);
			BehaviorUtils.lazyEvaluate(entity.wGetRoot(), -1, getBindings());
		}
	}
}
