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

import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.model.Name;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.operations.IDecorationManager;
import org.whole.lang.operations.ValidatorOperation;

/**
 * @author Riccardo Solmi
 */
public class ImpDefUseValidatorVisitor extends ImpIdentityVisitor {
	protected final IBindingManager bindingManager;
    protected String name;

	public ImpDefUseValidatorVisitor(ValidatorOperation operation) {
    	setOperation(operation);		
    	bindingManager = BindingManagerFactory.instance.createBindingManager();
	}

	IDecorationManager decorationManager;
	public IDecorationManager getDecorationManager() {
		if (decorationManager == null) {
			decorationManager = ((ValidatorOperation) getOperation()).getDecorationManager();
		}
		return decorationManager;
	}

	
	public void visit(FunctionDeclaration entity) {
		
		entity.getType().accept(this);
		entity.getName().accept(this);
		bindingManager.wDef(name, entity);

		bindingManager.wEnterScope();
		stagedVisit(entity.getBody());
		bindingManager.wExitScope();			
	}

	public void visit(Name entity) {
//		getDecorationManager().addWarning(entity, "test di decorazione", entity.toString());
	}
}
