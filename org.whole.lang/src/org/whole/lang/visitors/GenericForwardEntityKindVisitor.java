/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class GenericForwardEntityKindVisitor extends AbstractVisitor {
	public void visit(IEntity entity) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> ed = adaptee.wGetEntityDescriptor();

		//TODO workaround. move to a specific visitor 
		if (ed.getLanguageKit().getURI().equals(CommonsLanguageKit.URI)) {
			switch (ed.getOrdinal()) {
			case CommonsEntityDescriptorEnum.Resolver_ord:
	        	visitEntityResolver(entity);
	        	return;
			case CommonsEntityDescriptorEnum.Variable_ord:
			case CommonsEntityDescriptorEnum.InlineVariable_ord:
	        	visitEntityVariable((Variable) adaptee);
	        	return;
			case CommonsEntityDescriptorEnum.SameStageFragment_ord:
	        	visitSameStageFragment((SameStageFragment) adaptee);
	        	return;
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
	        	visitStageDownFragment((StageDownFragment) adaptee);
	        	return;
			case CommonsEntityDescriptorEnum.StageUpFragment_ord:
	        	visitStageUpFragment((StageUpFragment) adaptee);
	        	return;
			}
		}
		

//		entity = entity.wGetAdaptee();//TODO test
        switch(entity.wGetEntityKind()) {
        case SIMPLE:
        	visitSimpleEntity(entity);
        	break;
        case COMPOSITE:
        	visitCompositeEntity(entity);
        	break;
        case DATA:
        	visitDataEntity(entity);
        	break;
        }
	}


	public void visitSimpleEntity(IEntity entity) {
	}
	public void visitCompositeEntity(IEntity entity) {
	}
	public void visitDataEntity(IEntity entity) {		
	}

	public void visitEntityVariable(Variable entity) {	
	}
	public void visitEntityResolver(IEntity entity) {
	}

	public void visitSameStageFragment(SameStageFragment entity) {
		stagedVisit(entity.wGetRoot());
	}
	public void visitStageDownFragment(StageDownFragment entity) {
		stagedVisit(entity.wGetRoot(), -1);
	}
	public void visitStageUpFragment(StageUpFragment entity) {
		stagedVisit(entity.wGetRoot(), +1);
	}
}
