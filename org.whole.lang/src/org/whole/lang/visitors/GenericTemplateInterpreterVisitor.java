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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class GenericTemplateInterpreterVisitor extends AbstractVisitor {
    @Override
	public void setExecutableResult(IExecutable executable) {
		if (executable != null)
			executable.setBindings(getBindings());
		super.setExecutableResult(executable);
	}

	public void visit(IEntity entity) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> ed = adaptee.wGetEntityDescriptor();

		//TODO workaround move into a separate visitor
		if (ed.getLanguageKit().getURI().equals(CommonsLanguageKit.URI)) {
			switch (ed.getOrdinal()) {
			case CommonsEntityDescriptorEnum.Resolver_ord:
				break;
			case CommonsEntityDescriptorEnum.SameStageFragment_ord:
				stagedVisit(adaptee.wGetRoot());
				if (getStage()>0)
		       		setResult(GenericEntityFactory.instance.create(
		       				CommonsEntityDescriptorEnum.SameStageFragment,
		       				//CommonsEntityFactory.instance.createSameStageFragment(
		       				EntityUtils.cloneIfParented(getResult())));
	        	return;
			case CommonsEntityDescriptorEnum.RootFragment_ord:
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
	        	setResult(null);
	        	IEntity oldSelfEntity = getBindings().wGet(IBindingManager.SELF);
	        	final int stageShift0 = -1;
	        	stagedVisit(adaptee.wGetRoot(), stageShift0);

	        	if (getBindings().wGet(IBindingManager.SELF) != oldSelfEntity)
	        		getBindings().wDef(IBindingManager.SELF, oldSelfEntity);

	        	if (getStage()+stageShift0>0 && !isExecutableResult())
	        		setResult(GenericEntityFactory.instance.create(
		       				CommonsEntityDescriptorEnum.StageDownFragment,
		       				//CommonsEntityFactory.instance.createStageDownFragment(
	        				EntityUtils.cloneIfParented(getResult())
	        				/*, stageShift0*/));
	        	return;
			case CommonsEntityDescriptorEnum.StageUpFragment_ord:
				final int stageShift = +1;
				stagedVisit(adaptee.wGetRoot(), stageShift);

				if (getStage()>0) {
					setResult(GenericEntityFactory.instance.create(
		       				CommonsEntityDescriptorEnum.StageUpFragment,
		       				//CommonsEntityFactory.instance.createStageUpFragment(
							EntityUtils.cloneIfParented(BehaviorUtils.evaluateResult(getBindings()))
							/*, stageShift*/));
				}
				return;
			case CommonsEntityDescriptorEnum.Variable_ord:
			case CommonsEntityDescriptorEnum.InlineVariable_ord:
	        	Variable variable = (Variable) adaptee;

	        	String varName = variable.getVarName().getValue();
	        	IEntity value = getBindings().wGet(varName);
				if (value != null) {
					CommonsInterpreterVisitor.setVariableValueResult(getBindings(), variable, value);
					return;
				} //FIXME else continue
			}
		}

		IEntity entityClone = ((InternalIEntity) adaptee).wShallowClone();
		IEntity oldSelfEntity2 = getBindings().wGet(IBindingManager.SELF);

    	for (int index=0; index<entityClone.wSize(); index++) {
    		int resultSize = entityClone.wSize();
			visit(entityClone.wGet(index));
			int nextResultSize = entityClone.wSize();
			index += (nextResultSize - resultSize);

			if (isExecutableResult()) {
				IExecutable executable = getExecutableResult();
				setExecutableResult(null);
				IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
	        	if (selfEntity != oldSelfEntity2)
	        		getBindings().wDef(IBindingManager.SELF, selfEntity = oldSelfEntity2);
				executable.reset(selfEntity);
				FeatureDescriptor childFeatureDescriptor = entityClone.wGetFeatureDescriptor(index);
				if (EntityUtils.isComposite(entityClone)) {
    				entityClone.wRemove(index--);
 
//TODO test and replace
//					IBindingScope nextScope = BindingManagerFactory.instance.createSimpleScope();
//					IBindingScope resultScope = null;
//
//					try {
//						getBindings().wEnterScope(nextScope, true);
//
//	    				IEntity first = executable.evaluateNext();
//						if (first != null) {
//	    					resultScope = nextScope.clone();
//	    					nextScope.wClear();
//
//	    					resultSize = entityClone.wSize();
//	    					for (IEntity e = first; e != null; e = executable.evaluateNext()) {
//		    					nextResultSize = entityClone.wSize();
//		    					index += (nextResultSize - resultSize);
//		    					if (BindingManagerFactory.instance.isVoid(e))
//		    						resultSize = nextResultSize;
//		    					else {
//			    					entityClone.wAdd(++index, EntityUtils.convertCloneIfReparenting(e, childFeatureDescriptor));
//			    					resultSize = entityClone.wSize();
//		    					}
//		    					resultScope = nextScope.clone();
//		    					nextScope.wClear();
//		    				}
//						}
//					} finally {
//	    				getBindings().wExitScope();
//	    				if (resultScope != null)
//	    					getBindings().wAddAll(resultScope);
//					}

    				IEntity first = executable.evaluateNext();
					if (first != null) {
						ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
    					getBindings().wEnterScope(resettableScope);
    					resultSize = entityClone.wSize();
    					for (IEntity e = first; e != null; e = executable.evaluateNext()) {
	    					nextResultSize = entityClone.wSize();
	    					index += (nextResultSize - resultSize);
	    					if (BindingManagerFactory.instance.isVoid(e))
	    						resultSize = nextResultSize;
	    					else {
		    					entityClone.wAdd(++index, EntityUtils.convertCloneIfReparenting(e, childFeatureDescriptor));
		    					resultSize = entityClone.wSize();
	    					}
	    					resettableScope.commit();
	    				}
    					resettableScope.rollback();
	    				getBindings().wExitScope();
    				}
				} else {
					IEntity e = null;
					IEntity first = executable.evaluateNext();
					if (first != null) {
    					ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
    					getBindings().wEnterScope(resettableScope);
    					for (IEntity r = first; r != null; r = executable.evaluateNext()) {
	    					if (!BindingManagerFactory.instance.isVoid(r))
		    					e = r;
	    					resettableScope.commit();
	    				}
    					resettableScope.rollback();
	    				getBindings().wExitScope();
    				}
					if (e != null)
						entityClone.wSet(index, EntityUtils.convertCloneIfReparenting(e, childFeatureDescriptor));
					else
						entityClone.wRemove(index);
				}
			} else {
				IEntity child = getResult();
				if (child != null && !BindingManagerFactory.instance.isVoid(child)) {
					FeatureDescriptor resultChildDescriptor = entityClone.wGetAdaptee(false).wGetFeatureDescriptor(index);
    				entityClone.wSet(index, EntityUtils.convertCloneIfReparenting(child, resultChildDescriptor));
    			}  else
					entityClone.wRemove(index);
    		}

			IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
        	if (selfEntity != oldSelfEntity2)
        		getBindings().wDef(IBindingManager.SELF, selfEntity = oldSelfEntity2);

    	}
		setResult(entityClone);
	}
}
