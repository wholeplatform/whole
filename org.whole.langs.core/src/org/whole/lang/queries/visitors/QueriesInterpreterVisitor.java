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
package org.whole.lang.queries.visitors;

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.queries.model.Addition;
import org.whole.lang.queries.model.AdditionStep;
import org.whole.lang.queries.model.BooleanLiteral;
import org.whole.lang.queries.model.ByteLiteral;
import org.whole.lang.queries.model.CharLiteral;
import org.whole.lang.queries.model.Children;
import org.whole.lang.queries.model.Create;
import org.whole.lang.queries.model.DateLiteral;
import org.whole.lang.queries.model.Division;
import org.whole.lang.queries.model.DivisionStep;
import org.whole.lang.queries.model.DoubleLiteral;
import org.whole.lang.queries.model.EntityType;
import org.whole.lang.queries.model.Equals;
import org.whole.lang.queries.model.EqualsStep;
import org.whole.lang.queries.model.Expression;
import org.whole.lang.queries.model.Feature;
import org.whole.lang.queries.model.FeatureStep;
import org.whole.lang.queries.model.Features;
import org.whole.lang.queries.model.FloatLiteral;
import org.whole.lang.queries.model.GreaterOrEquals;
import org.whole.lang.queries.model.GreaterOrEqualsStep;
import org.whole.lang.queries.model.GreaterThan;
import org.whole.lang.queries.model.GreaterThanStep;
import org.whole.lang.queries.model.IQueriesEntity;
import org.whole.lang.queries.model.IntLiteral;
import org.whole.lang.queries.model.LessOrEquals;
import org.whole.lang.queries.model.LessOrEqualsStep;
import org.whole.lang.queries.model.LessThan;
import org.whole.lang.queries.model.LessThanStep;
import org.whole.lang.queries.model.LongLiteral;
import org.whole.lang.queries.model.Multiplication;
import org.whole.lang.queries.model.MultiplicationStep;
import org.whole.lang.queries.model.Name;
import org.whole.lang.queries.model.NotEquals;
import org.whole.lang.queries.model.NotEqualsStep;
import org.whole.lang.queries.model.Registry;
import org.whole.lang.queries.model.Remainder;
import org.whole.lang.queries.model.RemainderStep;
import org.whole.lang.queries.model.SelfStep;
import org.whole.lang.queries.model.ShortLiteral;
import org.whole.lang.queries.model.Singleton;
import org.whole.lang.queries.model.StringLiteral;
import org.whole.lang.queries.model.Subtraction;
import org.whole.lang.queries.model.SubtractionStep;
import org.whole.lang.queries.model.VariableRefStep;
import org.whole.lang.queries.model.VoidLiteral;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.util.MathUtils;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class QueriesInterpreterVisitor extends QueriesIdentityDefaultVisitor {
    @Override
	public void visit(Expression entity) {
    	DynamicCompilerOperation.compile(entity, getBindings());
    }

	protected IEntity evaluate(IQueriesEntity entity) {
		setResult(null);
    	entity.accept(this);
    	IEntity result = getResult();
    	if (result == null)
    		throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(entity).withBindings(getBindings());
    	return result;
	}
	protected final boolean booleanValue(IQueriesEntity exp) {
		return evaluate(exp).wBooleanValue();
	}
	protected final int intValue(IQueriesEntity exp) {
		return evaluate(exp).wIntValue();
	}
	protected final String stringValue(IQueriesEntity exp) {
		return evaluate(exp).wStringValue();
	}
	protected final IEntity getSelfEntity(IEntity sourceEntity) {
		IEntity self = getBindings().wGet(IBindingManager.SELF);
		if (self == null)
			throw new MissingVariableException(IBindingManager.SELF).withSourceEntity(sourceEntity).withBindings(getBindings());
		return self;
	}

	@Override
	public void visit(SelfStep entity) {
		withSourceEntity(entity);
		setResult(getSelfEntity(entity));
	}

	@Override
	public void visit(VariableRefStep entity) {
		String varName = entity.getValue();
		IEntity value = BindingUtils.wGet(getBindings(), varName);
		if (value == null)
			throw new MissingVariableException(varName).withSourceEntity(entity).withBindings(getBindings());
		setResult(value);
	}

	@Override
	public void visit(FeatureStep entity) {
		IEntity self = getSelfEntity(entity);
		String featureName = entity.getValue();
		FeatureDescriptor fd = self.wGetLanguageKit().getFeatureDescriptorEnum().valueOf(featureName);
		if (fd == null || !self.wContains(fd))
			visit((Expression) entity);
		else
			setResult(self.wGet(fd));
	}

	@Override
	public void visit(Create entity) {
		try {
			String typeName = stringValue(entity.getEntityType());
			EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.parseEntityDescriptor(typeName);
			if (ed == null)
				throw new WholeIllegalArgumentException("The requested entity does not exist: "+typeName).withSourceEntity(entity).withBindings(getBindings());
	
			IEntityRegistryProvider provider = RegistryConfigurations.valueOf(((Registry) evaluate(entity.getRegistry())).getValue().getName());
			IEntityFactory ef = GenericEntityFactory.instance(provider);
			IEntity entityPrototype;

			Expression expression = entity.getWhereClause();
			if (Matcher.matchImpl(QueriesEntityDescriptorEnum.Children, expression)) {
				IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
				if (ed.getEntityKind().isData()) {
					((Children) expression).get(0).accept(this);
					IEntity result = getResult();
	        		if (result == null)
	        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(((Children) expression).get(0)).withBindings(getBindings());

					entityPrototype = DataTypeUtils.convertCloneIfParented(result, ed);
					resetSelfEntity(selfEntity);
				} else if (ed.getEntityKind().isComposite()) {
					int argsSize = expression.wSize();
					FeatureDescriptor efd = ed.getEntityFeatureDescriptor(0);
					List<IEntity> values = new ArrayList<>(argsSize);
					for (int i = 0; i < argsSize; i++) {
						((Children) expression).get(i).accept(this);
						IEntity result = getResult();
		        		if (result != null)
		        			values.add(EntityUtils.convertCloneIfReparenting(result, efd));
						resetSelfEntity(selfEntity);
					}
					entityPrototype = ef.create(ed, values.toArray(new IEntity[0]));
				} else {
					IEntity[] values = new IEntity[expression.wSize()];
					for (int i = 0; i < values.length; i++) {
						((Children) expression).get(i).accept(this);
						IEntity result = getResult();
		        		if (result == null)
		        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(((Children) expression).get(i)).withBindings(getBindings());

						values[i] = EntityUtils.convertCloneIfReparenting(result, ed.getEntityFeatureDescriptor(i));
						resetSelfEntity(selfEntity);
					}
					entityPrototype = ef.create(ed, values);
				}
			} else {
				IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
				entityPrototype = ef.create(ed);
				resetSelfEntity(entityPrototype);

				if (ed.getEntityKind().isData()) {
					IEntity result = evaluate(expression);
	        		if (result == null)
	        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(((Children) expression).get(0)).withBindings(getBindings());

	        		if (!BindingManagerFactory.instance.isVoid(result))
	        			entityPrototype = DataTypeUtils.convertCloneIfParented(result, ed);
				} else {
					setResult(null);
					expression.accept(this);
					IExecutable e = getExecutableResult();
					setExecutableResult(null);
					resetIterator(e);

					boolean isComposite = ed.getEntityKind().isComposite();
					int index = 0;
					IEntity child = null;
					while ((isComposite || index < entityPrototype.wSize()) && (child = e.evaluateNext()) != null) {
						if (BindingManagerFactory.instance.isVoid(child)) {
							if (index >= entityPrototype.wSize())
								entityPrototype.wAdd(index, CommonsEntityFactory.instance.createResolver());
						} else {
							if (index < entityPrototype.wSize())
								entityPrototype.wSet(index, EntityUtils.convertCloneIfReparenting(child, entityPrototype.wGetFeatureDescriptor(index)));
							else
								entityPrototype.wAdd(index, EntityUtils.convertCloneIfReparenting(child, entityPrototype.wGetFeatureDescriptor(index)));
						}
						index++;
					}
				}

				resetSelfEntity(selfEntity);
			}

			setResult(entityPrototype);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, entity, getBindings());
		}
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	@Override
	public void visit(EntityType entity) {
		setResultValue(entity);
	}

	@Override
	public void visit(Registry entity) {
		setResult(entity);
	}

	@Override
	public void visit(Children entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Features entity) {
		IEntity entityPrototype = getBindings().wGet(IBindingManager.SELF);
		EntityDescriptor<?> ed = entityPrototype.wGetEntityDescriptor();
		if (!ed.getEntityKind().isSimple())
			throw new WholeIllegalArgumentException("Expecting a simple entity self").withSourceEntity(entity).withBindings(getBindings());//FIXME WholeMessages.no_simple

		IExecutable[] executableChain = new IExecutable[ed.featureSize()];

		for (int i=0, size=entity.wSize(); i<size; i++) {
			Feature feature = entity.get(i);
			feature.accept(this);

			if (!Matcher.matchImpl(QueriesEntityDescriptorEnum.Feature, feature))
				throw new WholeIllegalArgumentException("Expecting a Feature").withSourceEntity(entity).withBindings(getBindings());

			String name = stringValue(feature.getName());
			FeatureDescriptor fd = ed.getFeatureDescriptorEnum().valueOf(name);
			int index = 0;
			if (fd != null && (index = ed.indexOf(fd)) != -1) {
				evaluate(feature.getValue());
				executableChain[index] = getExecutableResult();
			}
		}

		for (int i=0, size=executableChain.length; i<size; i++)
			if (executableChain[i] == null)
				executableChain[i] = executableFactory().createConstant(BindingManagerFactory.instance.createVoid(), true);

		setExecutableResult(executableFactory().createSequence(executableChain).withSourceEntity(entity));
	}

	@Override
	public void visit(Feature entity) {
		setResult(entity);
	}

	@Override
	public void visit(Name entity) {
		setResultValue(entity);
	}

	protected void resetIterator(IExecutable executable) {
		IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
		executable.reset(selfEntity != null ? selfEntity : NullEntity.instance);
	}
	protected void resetSelfEntity(IEntity selfEntity) {
		if (getBindings().wGet(IBindingManager.SELF) != selfEntity)
			if (getBindings().wIsSet(IBindingManager.SELF))
				getBindings().wSet(IBindingManager.SELF, selfEntity);
			else
				getBindings().wDef(IBindingManager.SELF, selfEntity);	
	}

    @Override
	public void visit(BooleanLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(ByteLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(CharLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(DoubleLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(FloatLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(IntLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(LongLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(ShortLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(DateLiteral entity) {
    	setResultValue(entity);
	}
    @Override
	public void visit(StringLiteral entity) {
    	setResultValue(entity);
	}
    @Override
    public void visit(VoidLiteral entity) {
    	setResult(BindingManagerFactory.instance.createVoid());
    }

    @Override
	public void visit(AdditionStep entity) {
		setResult(MathUtils.additionElseNull(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(SubtractionStep entity) {
		setResult(MathUtils.subtractionElseNull(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(MultiplicationStep entity) {
		setResult(MathUtils.multiplicationElseNull(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(DivisionStep entity) {
		setResult(MathUtils.divisionElseNull(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(RemainderStep entity) {
		setResult(MathUtils.remainderElseNull(getSelfEntity(entity), evaluate(entity.getExpression())));
	}

	@Override
	public void visit(EqualsStep entity) {
		setResult(MathUtils.equalsElseFalse(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(NotEqualsStep entity) {
		setResult(MathUtils.notEqualsElseFalse(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(LessThanStep entity) {
		setResult(MathUtils.lessThanElseFalse(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(LessOrEqualsStep entity) {
		setResult(MathUtils.lessOrEqualsElseFalse(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(GreaterThanStep entity) {
		setResult(MathUtils.greaterThanElseFalse(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(GreaterOrEqualsStep entity) {
		setResult(MathUtils.greaterOrEqualsElseFalse(getSelfEntity(entity), evaluate(entity.getExpression())));
	}

    @Override
	public void visit(Addition entity) {
		setResult(MathUtils.addition(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
	@Override
	public void visit(Subtraction entity) {
		setResult(MathUtils.subtraction(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
	@Override
	public void visit(Multiplication entity) {
		setResult(MathUtils.multiplication(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
	@Override
	public void visit(Division entity) {
		setResult(MathUtils.division(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
	@Override
	public void visit(Remainder entity) {
		setResult(MathUtils.remainder(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}

	@Override
	public void visit(Equals entity) {
		setResult(MathUtils.equals(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
    @Override
	public void visit(NotEquals entity) {
		setResult(MathUtils.notEquals(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
    @Override
	public void visit(LessThan entity) {
		setResult(MathUtils.lessThan(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
    @Override
	public void visit(LessOrEquals entity) {
		setResult(MathUtils.lessOrEquals(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
    @Override
	public void visit(GreaterThan entity) {
		setResult(MathUtils.greaterThan(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}
	@Override
	public void visit(GreaterOrEquals entity) {
		setResult(MathUtils.greaterOrEquals(evaluate(entity.getExp1()), evaluate(entity.getExp2())));
	}

	@Override
	public void visit(Singleton entity) {
		setResult(null);
		entity.getExpression().accept(this);

		BehaviorUtils.evaluateSingletonResult(getBindings());
	}
}
