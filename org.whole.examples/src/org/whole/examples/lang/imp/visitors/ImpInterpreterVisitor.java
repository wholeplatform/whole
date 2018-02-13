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

import java.io.PrintWriter;

import org.whole.examples.lang.imp.model.Addition;
import org.whole.examples.lang.imp.model.And;
import org.whole.examples.lang.imp.model.Arguments;
import org.whole.examples.lang.imp.model.AssignmentExpression;
import org.whole.examples.lang.imp.model.BooleanLiteral;
import org.whole.examples.lang.imp.model.Division;
import org.whole.examples.lang.imp.model.DoWhileStatement;
import org.whole.examples.lang.imp.model.Equals;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.model.ForStatement;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.model.FunctionInvocationExpression;
import org.whole.examples.lang.imp.model.GreaterOrEquals;
import org.whole.examples.lang.imp.model.GreaterThan;
import org.whole.examples.lang.imp.model.IImpEntity;
import org.whole.examples.lang.imp.model.IfElseStatement;
import org.whole.examples.lang.imp.model.IfStatement;
import org.whole.examples.lang.imp.model.IntLiteral;
import org.whole.examples.lang.imp.model.LessOrEquals;
import org.whole.examples.lang.imp.model.LessThan;
import org.whole.examples.lang.imp.model.LoadExpression;
import org.whole.examples.lang.imp.model.Multiplication;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.model.NameExpression;
import org.whole.examples.lang.imp.model.Not;
import org.whole.examples.lang.imp.model.NotEquals;
import org.whole.examples.lang.imp.model.Or;
import org.whole.examples.lang.imp.model.Parameter;
import org.whole.examples.lang.imp.model.Parameters;
import org.whole.examples.lang.imp.model.PrintStatement;
import org.whole.examples.lang.imp.model.PrintlnStatement;
import org.whole.examples.lang.imp.model.ReturnStatement;
import org.whole.examples.lang.imp.model.RunExpression;
import org.whole.examples.lang.imp.model.SaveStatement;
import org.whole.examples.lang.imp.model.StringLiteral;
import org.whole.examples.lang.imp.model.Subtraction;
import org.whole.examples.lang.imp.model.VariableDeclaration;
import org.whole.examples.lang.imp.model.WhileStatement;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.bindings.ExitScopeException;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class ImpInterpreterVisitor extends ImpTraverseAllVisitor {
    protected final PrintWriter out;
    protected String[] parameters; //TODO move in bindingManager

    public ImpInterpreterVisitor(InterpreterOperation operation) {
    	setOperation(operation);
    	out = operation.getPrintWriter();
   }

    protected void setLiteral(IEntity entity) {
    	setResult(EntityUtils.clone(entity));
    }
	protected IEntity createBooleanLiteral() {
		return GenericEntityFactory.instance.create(ImpEntityDescriptorEnum.BooleanLiteral);
	}

    protected IEntity evaluate(IImpEntity entity) {
    	entity.accept(this);
    	return getResult();
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

	boolean isMain = true;
	public void visit(FunctionDeclaration entity) {
		
		entity.getType().accept(this);
		entity.getName().accept(this);
		getBindings().wDef(getResult().wStringValue(), entity);
//TODO		entity.getParameters().accept(this);
		
		if (isMain) {
			isMain = false;
			try {
				getBindings().wEnterScope();
				stagedVisit(entity.getBody());
			} catch (ExitScopeException e) {
			} finally {
				getBindings().wExitScope();			
			}
		}
	}

	public void visit(Parameters entity) {
		int size = entity.wSize();
		parameters = new String[size];
		for (int i = 0; i < size; i++) {
			((Parameter) entity.wGet(i)).accept(this);
			parameters[i] = getResult().wStringValue();
		}
	}

	public void visit(VariableDeclaration entity) {
		entity.getType().accept(this);
		entity.getName().accept(this);
		String name = getResult().wStringValue();
		entity.getInitializer().accept(this);
		getBindings().wDef(name, getResult());
	}

	public void visit(FunctionInvocationExpression entity) {
		entity.getName().accept(this);
		IEntity functionBody = getResult();
		if (Matcher.matchImpl(ImpEntityDescriptorEnum.FunctionDeclaration, functionBody)) {
			FunctionDeclaration function = (FunctionDeclaration) functionBody;
			//bindingManager.getValue(getName());		
			function.getParameters().accept(this);
			
			try {
				getBindings().wEnterScope();
				entity.getArguments().accept(this);
				stagedVisit(function.getBody());
			} catch (ExitScopeException e) {
			} finally {
				getBindings().wExitScope();			
			}
		} else {
			stagedVisit(functionBody);
		}
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			((Expression) entity.wGet(i)).accept(this);
			getBindings().wDef(parameters[i], getResult());
		}
	}

	public void visit(ReturnStatement entity) {
		super.visit(entity);
		throw new ExitScopeException("return");
	}

	public void visit(IfStatement entity) {
		if (booleanValue(entity.getCondition()))
			entity.getTrueBody().accept(this);
	}

	public void visit(IfElseStatement entity) {
		if (booleanValue(entity.getCondition()))
			entity.getTrueBody().accept(this);
		else
			entity.getFalseBody().accept(this);
	}

	public void visit(WhileStatement entity) {
		while (booleanValue(entity.getCondition()))
			entity.getTrueBody().accept(this);
	}

	public void visit(DoWhileStatement entity) {
		do {
			entity.getTrueBody().accept(this);		
		} while (booleanValue(entity.getCondition()));
	}

	public void visit(ForStatement entity) {
		entity.getInitializer().accept(this);
		while (booleanValue(entity.getCondition())) {
			entity.getTrueBody().accept(this);
			entity.getUpdater().accept(this);
		}
	}

	public void visit(AssignmentExpression entity) {
		entity.getName().accept(this);
		getBindings().wDef(getResult().wStringValue(), evaluate(entity.getExp()));
	}

	public void visit(PrintStatement entity) {
		IEntity value = evaluate(entity.getExp());
		if (!EntityUtils.isData(value) && value.wGetLanguageKit().hasVisitor(PrettyPrinterOperation.ID))
			PrettyPrinterOperation.prettyPrint(value, out);
		else
			out.print(value);
	}
	public void visit(PrintlnStatement entity) {
		IEntity value = evaluate(entity.getExp());
		if (!EntityUtils.isData(value) && value.wGetLanguageKit().hasVisitor(PrettyPrinterOperation.ID))
			PrettyPrinterOperation.prettyPrint(value, out);
		else
			out.println(value);
	}

	public void visit(LoadExpression entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	public void visit(SaveStatement entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	public void visit(RunExpression entity) {
		IEntity value = evaluate(entity.getExp());
		if (!EntityUtils.isData(value) && value.wGetLanguageKit().hasVisitor(InterpreterOperation.ID))
			stagedVisit(value);
	}

	public void visit(BooleanLiteral entity) {
		setLiteral(entity);
	}

	public void visit(IntLiteral entity) {
		setLiteral(entity);
	}

	public void visit(StringLiteral entity) {
		setLiteral(entity);
	}

	public void visit(Name entity) {
		setResult(entity);
//		ve().setName(entity.getValue());
	}

	public void visit(NameExpression entity) {
		IEntity value = getBindings().wGet(entity.getValue());
		if (value == null)
			throw new MissingVariableException(entity.getValue()).withSourceEntity(entity).withBindings(getBindings());
		setLiteral(value);
	}

	public void visit(Addition entity) {
		IEntity result1 = evaluate(entity.getExp1());
		IEntity result2 = evaluate(entity.getExp2());
		boolean isInt1 = DataTypeUtils.getDataKind(result1).isInt();
		boolean isInt2 = DataTypeUtils.getDataKind(result2).isInt();
		if (isInt1 && isInt2) {
			result1.wSetValue(result1.wIntValue() + result2.wIntValue());
			setResult(result1);
		} else if (isInt2) {
			result1.wSetValue(result1.wStringValue() + DataTypeUtils.getAsPresentationString(result2));
			setResult(result1);
		} else {
			result2.wSetValue(result1.wStringValue() + result2.wStringValue());
			setResult(result2);			
		}
	}

	public void visit(Subtraction entity) {
		IEntity result = evaluate(entity.getExp1());
		result.wSetValue(result.wIntValue() - intValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(Multiplication entity) {
		IEntity result = evaluate(entity.getExp1());
		result.wSetValue(result.wIntValue() * intValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(Division entity) {
		IEntity result = evaluate(entity.getExp1());
		result.wSetValue(result.wIntValue() / intValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(And entity) {
		IEntity result = evaluate(entity.getExp1());
		result.wSetValue(result.wBooleanValue() && booleanValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(Or entity) {
		IEntity result = evaluate(entity.getExp1());
		result.wSetValue(result.wBooleanValue() && booleanValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(Not entity) {
		IEntity result = evaluate(entity.getExp());
		result.wSetValue(!result.wBooleanValue());
		setResult(result);
	}

	public void visit(Equals entity) {
		IEntity result = createBooleanLiteral();
		IEntity result1 = evaluate(entity.getExp1());
		IEntity result2 = evaluate(entity.getExp2());
		boolean isInt1 = DataTypeUtils.getDataKind(result1).isInt();
		boolean isInt2 = DataTypeUtils.getDataKind(result2).isInt();
		if (isInt1 && isInt2)
			result.wSetValue(result1.wIntValue() == result2.wIntValue());
		else
			result.wSetValue(DataTypeUtils.getAsPresentationString(result1)
					.equals(DataTypeUtils.getAsPresentationString(result2)));
		setResult(result);
	}

	public void visit(NotEquals entity) {
		IEntity result = createBooleanLiteral();
		IEntity result1 = evaluate(entity.getExp1());
		IEntity result2 = evaluate(entity.getExp2());
		boolean isInt1 = DataTypeUtils.getDataKind(result1).isInt();
		boolean isInt2 = DataTypeUtils.getDataKind(result2).isInt();
		if (isInt1 && isInt2)
			result.wSetValue(result1.wIntValue() != result2.wIntValue());
		else
			result.wSetValue(!DataTypeUtils.getAsPresentationString(result1)
					.equals(DataTypeUtils.getAsPresentationString(result2)));
		setResult(result);
	}

	public void visit(LessThan entity) {
		IEntity result = createBooleanLiteral();
		result.wSetValue(intValue(entity.getExp1()) < intValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(LessOrEquals entity) {
		IEntity result = createBooleanLiteral();
		result.wSetValue(intValue(entity.getExp1()) <= intValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(GreaterThan entity) {
		IEntity result = createBooleanLiteral();
		result.wSetValue(intValue(entity.getExp1()) > intValue(entity.getExp2()));
		setResult(result);
	}

	public void visit(GreaterOrEquals entity) {
		IEntity result = createBooleanLiteral();
		result.wSetValue(intValue(entity.getExp1()) >= intValue(entity.getExp2()));
		setResult(result);
	}
}
