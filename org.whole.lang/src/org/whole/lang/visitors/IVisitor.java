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
package org.whole.lang.visitors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.ISourceable;



/**
 * @author Riccardo Solmi
 */
public interface IVisitor extends ICloneable, ISourceable {
	public IVisitor withSourceEntity(IEntity entity);

	public IVisitor clone();
	public IVisitor clone(ICloneContext cc);

    public IOperation getOperation();
    public void setOperation(IOperation operation);
    public IBindingManager getBindings();
    public void setBindings(IBindingManager bm);

    public void visit(IEntity entity);
    public boolean visitAdapter(IEntityAdapter entity);

	public void toString(StringBuilder sb);
}
