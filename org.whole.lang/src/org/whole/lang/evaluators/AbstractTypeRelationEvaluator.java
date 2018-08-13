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
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTypeRelationEvaluator extends AbstractPureConditionalSupplierEvaluator<IEntity> {
	protected final String typeUri;

	public AbstractTypeRelationEvaluator(String typeUri) {
		this.typeUri = typeUri;
	}

	protected abstract boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd);
	protected abstract String predicateName(); 

	public IEntity get() {
		EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
		EntityDescriptor<?> typeEd = getEntityDescriptor(typeUri, selfEd, getBindings());
		return BindingManagerFactory.instance.createValue(test(typeEd, selfEd));
	}
	
	public static final EntityDescriptor<?> getEntityDescriptor(String edUri, EntityDescriptor<?> selfEd, IBindingManager bm) {
		return ResourceUtils.hasFragmentPart(edUri) ?
				CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, true, bm) : selfEd.getEntityDescriptorEnum().valueOf(edUri);		
	}

	public void toString(StringBuilder sb) {
		sb.append(predicateName());
		sb.append("(\"");
		sb.append(typeUri);
		sb.append("\")");
	}
}

