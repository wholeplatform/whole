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
package org.whole.lang.queries.visitors;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.queries.model.Addition;
import org.whole.lang.queries.model.AdditionStep;
import org.whole.lang.queries.model.BooleanLiteral;
import org.whole.lang.queries.model.ByteLiteral;
import org.whole.lang.queries.model.CharLiteral;
import org.whole.lang.queries.model.DateLiteral;
import org.whole.lang.queries.model.Division;
import org.whole.lang.queries.model.DivisionStep;
import org.whole.lang.queries.model.DoubleLiteral;
import org.whole.lang.queries.model.Equals;
import org.whole.lang.queries.model.EqualsStep;
import org.whole.lang.queries.model.Expression;
import org.whole.lang.queries.model.FeatureStep;
import org.whole.lang.queries.model.FloatLiteral;
import org.whole.lang.queries.model.GreaterOrEquals;
import org.whole.lang.queries.model.GreaterOrEqualsStep;
import org.whole.lang.queries.model.GreaterThan;
import org.whole.lang.queries.model.GreaterThanStep;
import org.whole.lang.queries.model.IntLiteral;
import org.whole.lang.queries.model.LessOrEquals;
import org.whole.lang.queries.model.LessOrEqualsStep;
import org.whole.lang.queries.model.LessThan;
import org.whole.lang.queries.model.LessThanStep;
import org.whole.lang.queries.model.LongLiteral;
import org.whole.lang.queries.model.Multiplication;
import org.whole.lang.queries.model.MultiplicationStep;
import org.whole.lang.queries.model.NotEquals;
import org.whole.lang.queries.model.NotEqualsStep;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.queries.model.Predicate;
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
import org.whole.lang.queries.util.MathUtils;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class QueriesInterpreterVisitor extends QueriesIdentityDefaultVisitor {
    @Override
	public void visit(PathExpression entity) {
    	DynamicCompilerOperation.compile(entity, getBindings());
    }
    @Override
    public void visit(Predicate entity) {
    	DynamicCompilerOperation.compile(entity, getBindings());
    }

	protected IEntity evaluateOptional(Expression entity) {
    	entity.accept(this);
    	return getResult();
    }
	protected IEntity evaluate(Expression entity) {
    	IEntity result = evaluateOptional(entity);
    	if (result == null)
    		throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(entity).withBindings(getBindings());
    	return result;
    }
	protected final boolean booleanValue(Expression exp) {
		return evaluate(exp).wBooleanValue();
	}
	protected final int intValue(Expression exp) {
		return evaluate(exp).wIntValue();
	}
	protected final String stringValue(Expression exp) {
		return evaluate(exp).wStringValue();
	}
	protected final IEntity getSelfEntity(IEntity sourceEntity) {
		IEntity self = getBindings().wGet("self");
		if (self == null)
			throw new MissingVariableException("self").withSourceEntity(sourceEntity).withBindings(getBindings());
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
			visit((PathExpression) entity);
		else
			setResult(self.wGet(fd));
	}

    @Override
	public void visit(BooleanLiteral entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.wBooleanValue()));
	}
    @Override
	public void visit(ByteLiteral entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.wByteValue()));
	}
    @Override
	public void visit(CharLiteral entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.wCharValue()));
	}
    @Override
	public void visit(DoubleLiteral entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.wDoubleValue()));
	}
    @Override
	public void visit(FloatLiteral entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.wFloatValue()));
	}
    @Override
	public void visit(IntLiteral entity) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(entity.wIntValue()));
	}
    @Override
	public void visit(LongLiteral entity) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(entity.wLongValue()));
	}
    @Override
	public void visit(ShortLiteral entity) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(entity.wShortValue()));
	}
    @Override
	public void visit(DateLiteral entity) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(entity.wDateValue()));
	}
    @Override
	public void visit(StringLiteral entity) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(entity.wStringValue()));
	}
    @Override
    public void visit(VoidLiteral entity) {
    	setResult(BindingManagerFactory.instance.createVoid());
    }

    @Override
	public void visit(AdditionStep entity) {
		setResult(MathUtils.addition(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(SubtractionStep entity) {
		setResult(MathUtils.subtraction(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(MultiplicationStep entity) {
		setResult(MathUtils.multiplication(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(DivisionStep entity) {
		setResult(MathUtils.division(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(RemainderStep entity) {
		setResult(MathUtils.remainder(getSelfEntity(entity), evaluate(entity.getExpression())));
	}

	@Override
	public void visit(EqualsStep entity) {
		setResult(MathUtils.equals(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(NotEqualsStep entity) {
		setResult(MathUtils.notEquals(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(LessThanStep entity) {
		setResult(MathUtils.lessThan(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(LessOrEqualsStep entity) {
		setResult(MathUtils.lessOrEquals(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
    @Override
	public void visit(GreaterThanStep entity) {
		setResult(MathUtils.greaterThan(getSelfEntity(entity), evaluate(entity.getExpression())));
	}
	@Override
	public void visit(GreaterOrEqualsStep entity) {
		setResult(MathUtils.greaterOrEquals(getSelfEntity(entity), evaluate(entity.getExpression())));
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
		entity.getExpression().accept(this);

		BehaviorUtils.evaluateSingletonResult(getBindings());
	}
}
