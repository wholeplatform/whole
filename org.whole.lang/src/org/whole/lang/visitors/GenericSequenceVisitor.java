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

import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class GenericSequenceVisitor extends AbstractBinaryVisitor<IVisitor> {
    public GenericSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
    	super(visitor1, visitor2);
    }

    public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
    
    //test model context
    public void visit(IEntityContext context) {
		wGetVisitor1().visit(context);
		wGetVisitor2().visit(context);
	}
}
