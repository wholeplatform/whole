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
package org.whole.lang.xsd.ui.editparts;

import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsi.ui.editparts.XsiSimpleElementPart;

/**
 * @author Enrico Persiani
 */
public class XsdSimpleElementPart extends XsiSimpleElementPart {
	public XsdSimpleElementPart(boolean hideOptionals, boolean isRoot) {
		super(hideOptionals, isRoot);
	}

	@Override
	protected boolean showAsAttribute(IMappingStrategy strategy, IEntity child) {
		//FIXME should use the mapping strategy
		switch (child.wGetEntityDescriptor().getOrdinal()) {
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
		case XsdEntityDescriptorEnum.Attributes_ord:
		case XsdEntityDescriptorEnum.Bounded_ord:
		case XsdEntityDescriptorEnum.Unbounded_ord:
			return true;
		default:
			return super.showAsAttribute(strategy, child);
		}
	}
}
