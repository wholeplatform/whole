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

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public class DynamicMonoLanguageVariantVisitor extends AbstractDynamicVariantVisitor {
	private IVisitor[] cases;
	private ILanguageKit languageKit;

	public DynamicMonoLanguageVariantVisitor(ILanguageKit languageKit) {
		this.languageKit = languageKit;
		this.cases = new IVisitor[languageKit.getEntityDescriptorEnum().size()];
	}

	public void addVisit(EntityDescriptor<?> ed, IVisitor visitor) {
		cases[ed.getOrdinal()] = visitor;
	}
	public void removeVisit(EntityDescriptor<?> ed) {
		cases[ed.getOrdinal()] = null;
	}

	public void visit(IEntity entity) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		IVisitor caseVisitor = null;
		if (ed.getLanguageKit().equals(languageKit))
			caseVisitor = cases[ed.getOrdinal()];
		if (caseVisitor == null)
			caseVisitor = superVisitor;
		if (caseVisitor == null)
			throw new VisitException();

		caseVisitor.visit(entity);
	}
}
