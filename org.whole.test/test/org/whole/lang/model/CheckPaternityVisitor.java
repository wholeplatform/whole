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
package org.whole.lang.model;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class CheckPaternityVisitor extends GenericIdentityVisitor {
	private IBindingManager bm;

	public CheckPaternityVisitor() {
		bm = BindingManagerFactory.instance.createBindingManager();
	}

	@Override
	public void visit(IEntity entity) {
		bm.wDef("parent", entity.wGetParent());
		GenericTraversalFactory.instance.downUp(
			new GenericIdentityVisitor() {
				public void visit(IEntity entity) {
					bm.wEnterScope();
					bm.wDef("parent", entity);
				}
			},
			new GenericIdentityVisitor() {
				public void visit(IEntity entity) {
					bm.wExitScope();
					if (bm.wGet("parent") != entity.wGetParent())
						throw new VisitException();
				}
			}, false
		).visit(entity);
	}

	public static boolean check(IEntity entity) {
		try {
			new CheckPaternityVisitor().visit(entity);
			return true;
		} catch (VisitException e) {
			return false;
		}
	}
}
