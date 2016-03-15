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
package org.whole.lang.visitors;

import java.util.HashSet;
import java.util.Set;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class GenericDistinctVisitor extends AbstractVisitor {
	private Set<IEntity> visitSet;

	public GenericDistinctVisitor(Set<IEntity> visitSet) {
        this.visitSet = visitSet;
    }

	@Override
	public IVisitor clone(ICloneContext cc) {
		GenericDistinctVisitor visitor = (GenericDistinctVisitor) super.clone(cc);
		visitor.visitSet = new HashSet<IEntity>(visitSet);
		return visitor;
	}

	public void visit(IEntity entity) {
		if (!visitSet.add(entity))
			throw new VisitException();
	}
}
