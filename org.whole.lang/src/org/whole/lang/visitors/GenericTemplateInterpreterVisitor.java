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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.SubstituteException;
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
	@SuppressWarnings("unchecked")
	public void visit(IEntity entity) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> ed = adaptee.wGetEntityDescriptor();
		IEntity result;

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
	        	IEntity oldSelfEntity = getBindings().wGet("self");
//TODO for testing
//	        	if (oldSelfEntity == null)
//	        		oldSelfEntity = null;
	        	final int stageShift0 = -1;
	        	stagedVisit(adaptee.wGetRoot(), stageShift0);

	        	if (getBindings().wGet("self") != oldSelfEntity)
	        		getBindings().wDef("self", oldSelfEntity);

	        	//TODO test only
//	        	if (isResultIterator())
//	        		result = BehaviorUtils.evaluateResult(getBindings());

	        	result = getResult();
	        	if (getStage()+stageShift0>0 && result!=null)
	        		setResult(GenericEntityFactory.instance.create(
		       				CommonsEntityDescriptorEnum.StageDownFragment,
		       				//CommonsEntityFactory.instance.createStageDownFragment(
	        				EntityUtils.cloneIfParented(result)
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
					if (BindingManagerFactory.instance.isVoid(value))
						setResult(value);
					else {
						QuantifierEnum.Value quantifierValue = variable.getQuantifier().getValue();
	    				
						if (quantifierValue.isComposite()) {
							Variable newVariable = EntityUtils.clone(variable);
							newVariable.getQuantifier().setValue(quantifierValue.toOptional());

							if (EntityUtils.isInlineVariable(variable)) {
								//TODO constantChildIterator should call EntityUtils.convert(childValue, varType)
								setResultIterator(
										IteratorFactory.sequenceIterator(
											IteratorFactory.constantChildIterator(value),
											IteratorFactory.constantIterator(newVariable, true)));
							} else {
								EntityDescriptor<?> varType = variable.getVarType().getValue();
								try {
									setResultIterator(
											IteratorFactory.sequenceIterator(
												IteratorFactory.constantIterator(EntityUtils.convertCloneIfParented(value, varType), true),
												IteratorFactory.constantIterator(newVariable, true)));
								} catch (IllegalArgumentException e) {
									throw new SubstituteException(variable, value.wGetEntityDescriptor());					
								}
							}
						} else {
							if (EntityUtils.isInlineVariable(variable)) {
								//TODO constantChildIterator should call EntityUtils.convert(childValue, varType)
								setResultIterator(
										IteratorFactory.constantChildIterator(value));
							} else {
								EntityDescriptor<?> varType = variable.getVarType().getValue();
								try {
									setResult(EntityUtils.convertCloneIfParented(value, varType));
								} catch (IllegalArgumentException e) {
									throw new SubstituteException(variable, value.wGetEntityDescriptor());					
								}
							}
						}
					}
					return;
				} //FIXME else continue
			}
		}

		result = ((InternalIEntity) adaptee).wShallowClone();
		IEntity oldSelfEntity2 = getBindings().wGet("self");
//TODO for testing
//  	if (oldSelfEntity2 == null)
//    		oldSelfEntity2 = null;

    	for (int i=0; i<result.wSize(); i++) {
    		int resultSize = result.wSize();
			visit(result.wGet(i));
			int nextResultSize = result.wSize();
			i += (nextResultSize - resultSize);

			if (isResultIterator()) {
				IEntityIterator<?> iterator = getResultIterator();
				setResultIterator(null);
				IEntity selfEntity = getBindings().wGet("self");
	        	if (selfEntity != oldSelfEntity2)
	        		getBindings().wDef("self", selfEntity = oldSelfEntity2);
				iterator.reset(selfEntity);
				FeatureDescriptor resultChildDescriptor = result.wGetFeatureDescriptor(i);
				if (EntityUtils.isComposite(result)) {
    				result.wRemove(i--);
    				if (iterator.hasNext()) {
    					ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
    					getBindings().wEnterScope(resettableScope);
    					resultSize = result.wSize();
	    				for (IEntity e : iterator) {
	    					nextResultSize = result.wSize();
	    					i += (nextResultSize - resultSize);
	    					if (BindingManagerFactory.instance.isVoid(e))
	    						resultSize = nextResultSize;
	    					else {
		    					result.wAdd(++i, EntityUtils.convertCloneIfReparenting(e, resultChildDescriptor));
		    					resultSize = result.wSize();
	    					}
	    					resettableScope.commit();
	    				}
    					resettableScope.rollback();
	    				getBindings().wExitScope();
    				}
				} else {
					IEntity e = null;
    				if (iterator.hasNext()) {
    					ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
    					getBindings().wEnterScope(resettableScope);
	    				for (IEntity r : iterator) {
	    					if (!BindingManagerFactory.instance.isVoid(r))
		    					e = r;
	    					resettableScope.commit();
	    				}
    					resettableScope.rollback();
	    				getBindings().wExitScope();
    				}
					if (e != null)
						result.wSet(i, EntityUtils.convertCloneIfReparenting(e, resultChildDescriptor));
					else
						result.wRemove(i);
				}
			} else {
				IEntity child = getResult();
				if (child != null && !BindingManagerFactory.instance.isVoid(child)) {
					FeatureDescriptor resultChildDescriptor = result.wGetAdaptee(false).wGetFeatureDescriptor(i);
    				result.wSet(i, EntityUtils.convertCloneIfReparenting(child, resultChildDescriptor));
    			}  else
					result.wRemove(i);
    		}

			IEntity selfEntity = getBindings().wGet("self");
        	if (selfEntity != oldSelfEntity2)
        		getBindings().wDef("self", selfEntity = oldSelfEntity2);

    	}
		setResult(result);
	}
}
