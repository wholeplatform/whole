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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class DynamicCrossLanguageVariantVisitor extends AbstractDynamicVariantVisitor {
	protected Map<EntityDescriptor<?>, IVisitor> cases;

	public DynamicCrossLanguageVariantVisitor() {
		cases = new HashMap<EntityDescriptor<?>, IVisitor>();
	}

	public void addVisit(EntityDescriptor<?> ed, IVisitor visitor) {
		cases.put(ed, visitor);
	}
	public void removeVisit(EntityDescriptor<?> ed) {
		cases.remove(ed);
	}

	public void visit(IEntity entity) {
		IVisitor caseVisitor = cases.get(entity.wGetEntityDescriptor());
		if (caseVisitor == null)
			caseVisitor = superVisitor;
		if (caseVisitor == null)
			throw new VisitException();

		caseVisitor.visit(entity);
	}
}
