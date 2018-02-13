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
package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.model.IImpEntity;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.operations.IDecorationManager;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ImpResolverValidatorVisitor extends ImpIdentityDefaultVisitor {
	public ImpResolverValidatorVisitor(ValidatorOperation operation) {
    	setOperation(operation);		
	}
	
	IDecorationManager decorationManager;
	public IDecorationManager getDecorationManager() {
		if (decorationManager == null) {
			decorationManager = ((ValidatorOperation) getOperation()).getDecorationManager();
		}
		return decorationManager;
	}

	public void visit(IImpEntity entity) {
		if (EntityUtils.isResolver(entity) && !(CommonsEntityDescriptorEnum.StageUpFragment.equals(entity.wGetModel().getFragment().wGetEntityDescriptor())))
			getDecorationManager().addWarning(entity, "Incomplete program", entity.toString());
	}

}
