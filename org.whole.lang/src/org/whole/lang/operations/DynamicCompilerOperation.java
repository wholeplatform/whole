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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.GenericTemplateInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class DynamicCompilerOperation extends AbstractOperation {
	public static final String ID = "DynamicCompiler";

	public static IBindingScope compile(IEntity model, IBindingManager bm) {
		bm.wEnterScope();
		IOperation op = new DynamicCompilerOperation(bm);
		op.stagedVisit(model, 0);
		bm.wExitScope();

		//TODO return iterator in result entity value

		IBindingScope re = op.getResultsScope();
		IEntity result = re.getResult();
		if (result != null) {
	    	Object rv = result.wGetValue();
	    	if (rv instanceof IVisitor)
	    		((IVisitor) rv).setBindings(bm);
		} else {
			re.getResultIterator().setBindings(bm);
		}
		return re;
	}

	protected DynamicCompilerOperation(IBindingManager bm) {
		super(ID, bm, null);
	}

	protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		if (normalizedStage > 0)
			return new GenericTemplateInterpreterVisitor();
		else
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					setResultIterator(IteratorFactory.templateInterpreterIterator(entity).withSourceEntity(entity));
				}
			};
	}
}
