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
package org.whole.lang.commons.visitors;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.BaseFragment;
import org.whole.lang.commons.model.InlineVariable;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.model.TemplateFragment;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.SubstituteException;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.MissingVariableException;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class CommonsInterpreterVisitor extends CommonsIdentityVisitor {
    @Override
	public void setExecutableResult(IExecutable executable) {
		if (executable != null)
			executable.setBindings(getBindings());
		super.setExecutableResult(executable);
	}

	public void visit(RootFragment entity) {
		stagedVisit(entity.wGetRoot(), 0);
	}

	public void visit(SameStageFragment entity) {
		stagedVisit(entity.wGetRoot(), 0);
	}

	public void visit(StageDownFragment entity) {
		setResult(null);
		stagedVisit(entity.wGetRoot(), -1);
	}

	public void visit(StageUpFragment entity) {
		stagedVisit(entity.wGetRoot(), +1);

		if (isExecutableResult()) {
			IExecutable templateExecutable = getExecutableResult();
			setExecutableResult(executableFactory().createCompose(
					executableFactory().createSingleValuedRunnable((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity))
							bm.setResult(EntityUtils.cloneIfParented(selfEntity));
					}).withSourceEntity(entity), templateExecutable));
		} else {
			IEntity result = getResult();

			if (result!=null && EntityUtils.hasParent(result))
				setResult(EntityUtils.clone(result));
		}
	}

	@Override
	public void visit(BaseFragment entity) {
		stagedVisit(entity.wGetRoot(), -1,
				EntityUtils.safeStringValue(entity.wGet(CommonsFeatureDescriptorEnum.phase), null));
	}

	@Override
	public void visit(TemplateFragment entity) {
		stagedVisit(entity.wGetRoot(), +1,
				EntityUtils.safeStringValue(entity.wGet(CommonsFeatureDescriptorEnum.phase), null));
	}

	public void visit(Variable entity) {
		evaluate(entity, getBindings());
	}
	public void visit(InlineVariable entity) {
		evaluate(entity, getBindings());
	}
	public static final IEntity evaluate(Variable variable, IBindingManager bm) {
    	String varName = variable.getVarName().getValue();
    	IEntity value = BindingUtils.wGet(bm, varName);
		if (value != null) {
			setVariableValueResult(bm, variable, value);
			return value;
		} else
			throw new VisitException(new MissingVariableException(varName).withSourceEntity(variable).withBindings(bm));
	}


	public static void setVariableValueResult(IBindingManager bm, Variable variable, IEntity value) {
		if (BindingManagerFactory.instance.isVoid(value))
			bm.setResult(value);
		else {
			EntityDescriptor<?> varType = variable.getVarType().getValue();
			QuantifierEnum.Value quantifierValue = variable.getQuantifier().getValue();
			
			if (quantifierValue.isComposite()) {
				Variable newVariable = EntityUtils.clone(variable);
				newVariable.getQuantifier().setValue(quantifierValue.toOptional());

				if (EntityUtils.isInlineVariable(variable)) {
					bm.setExecutableResult(
							ExecutableFactory.instance(bm).createSequence(
								ExecutableFactory.instance(bm).createConstantChild(inlineValues(value, varType)),
								ExecutableFactory.instance(bm).createConstant(newVariable, true)));
				} else {
					try {
						bm.setExecutableResult(
								ExecutableFactory.instance(bm).createSequence(
									ExecutableFactory.instance(bm).createConstant(EntityUtils.convertCloneIfParented(value, varType), true),
									ExecutableFactory.instance(bm).createConstant(newVariable, true)));
					} catch (IllegalArgumentException e) {
						throw new SubstituteException(variable, value.wGetEntityDescriptor());					
					}
				}
			} else {
				if (EntityUtils.isInlineVariable(variable)) {
					bm.setExecutableResult(
							ExecutableFactory.instance(bm).createConstantChild(inlineValues(value, varType)));
				} else {
					try {
						bm.setResult(EntityUtils.convertCloneIfParented(value, varType));
					} catch (IllegalArgumentException e) {
						throw new SubstituteException(variable, value.wGetEntityDescriptor());					
					}
				}
			}
		}
	}
	public static IEntity inlineValues(IEntity container, EntityDescriptor<?> varType) {
		IEntity result = BindingManagerFactory.instance.createTuple();

		for (int i=0, size=container.wSize(); i<size; i++)
			result.wAdd(EntityUtils.convertCloneIfParented(container.wGet(i), varType));
		
		return result;
	}

	@Override
	public void visit(Resolver entity) {
	}


	public boolean visitAdapter(IEntityAdapter entity) {
		return evaluateAdapter(entity, getOperation());
	}

	public static final boolean visitAdapter(IEntityAdapter entity, IOperation op) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> adapteeEd = adaptee.wGetEntityDescriptor();

		if (entity.wGetEntityDescriptor().equals(adapteeEd))
			return true;
		else {
			op.stagedVisit(adaptee, 0);
			return false;
		}
	}
	public static final boolean evaluateAdapter(IEntityAdapter entity, IOperation op) {
		boolean result = visitAdapter(entity, op);

//FIXME workaround for accept(this) without getResult (replace with evaluate)
		if (!result && op != null)
			BehaviorUtils.evaluateResult(op.getOperationEnvironment());

		return result;
	}
}
