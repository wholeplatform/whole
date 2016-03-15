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
package org.whole.lang.scheme.visitors;

import java.io.PrintWriter;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.scheme.factories.SchemeEntityFactory;
import org.whole.lang.scheme.model.AndExpression;
import org.whole.lang.scheme.model.ApplyExpression;
import org.whole.lang.scheme.model.Branch;
import org.whole.lang.scheme.model.Branches;
import org.whole.lang.scheme.model.BuiltinValue;
import org.whole.lang.scheme.model.ClosureValue;
import org.whole.lang.scheme.model.CondExpression;
import org.whole.lang.scheme.model.ConstExpression;
import org.whole.lang.scheme.model.Definition;
import org.whole.lang.scheme.model.Definitions;
import org.whole.lang.scheme.model.ISchemeEntity;
import org.whole.lang.scheme.model.IdExpression;
import org.whole.lang.scheme.model.LambdaExpression;
import org.whole.lang.scheme.model.LocalExpression;
import org.whole.lang.scheme.model.OrExpression;
import org.whole.lang.scheme.model.SchemeEnvironment;
import org.whole.lang.scheme.model.SchemeExpression;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.VisitException;


/**
 * @author Riccardo Solmi
 */
public class SchemeInterpreterVisitor extends SchemeTraverseAllVisitor {
    protected final SchemeValueInterpreter valueInterpreter;
    protected final PrintWriter out;
    protected String[] parameters; //TODO move in bindingManager

    public SchemeInterpreterVisitor(InterpreterOperation operation) {
    	setOperation(operation);
    	out = operation.getPrintWriter();
    	valueInterpreter = new SchemeValueInterpreter(this);
   }

    protected void setLiteral(IEntity entity) {
    	setResult(EntityUtils.clone(entity));
    }

    protected IEntity evaluate(ISchemeEntity entity) {
    	entity.accept(this);
    	return getResult();
    }
	protected final boolean booleanValue(SchemeExpression exp) {
		return evaluate(exp).wBooleanValue();
	}
	protected final int intValue(SchemeExpression exp) {
		return evaluate(exp).wIntValue();
	}
	protected final String stringValue(SchemeExpression exp) {
		return evaluate(exp).wStringValue();
	}

	@Override
	public void visit(Definitions entity) {
		super.visit(entity);
		IEntity mainDefine = getBindings().wGet("main");
		if (mainDefine == null)
			throw new VisitException("expected the definition of: main");
		
		stagedVisit(mainDefine);
	}

	@Override
	public void visit(Definition entity) {
		String definitionName = entity.getName().wStringValue();
		IEntity definitionBody = entity.getExpression();
		getBindings().wDef(definitionName, definitionBody);
	}

	public void visit(AndExpression entity) {
		IEntity exprs = entity.getExpressions();

		if (!exprs.wGetEntityDescriptor().equals(SchemeEntityDescriptorEnum.SchemeExpressions))
			throw new VisitException("expected a "+SchemeEntityDescriptorEnum.SchemeExpressions);
		
		boolean result = true;
		for (int i = 0; i < exprs.wSize(); i++)
			result = result && booleanValue(((SchemeExpression) exprs.wGet(i)));
		setResult(SchemeEntityFactory.instance.createBooleanValue(result));
	}
	public void visit(OrExpression entity) {
		IEntity exprs = entity.getExpressions();

		if (!exprs.wGetEntityDescriptor().equals(SchemeEntityDescriptorEnum.SchemeExpressions))
			throw new VisitException("expected a "+SchemeEntityDescriptorEnum.SchemeExpressions);
		
		boolean result = true;
		for (int i = 0; i < exprs.wSize(); i++)
			result = result || booleanValue(((SchemeExpression) exprs.wGet(i)));
		setResult(SchemeEntityFactory.instance.createBooleanValue(result));
	}

	public void visit(ApplyExpression entity) {
		IEntity exprs = entity.getExpressions();

		if (!exprs.wGetEntityDescriptor().equals(SchemeEntityDescriptorEnum.SchemeExpressions))
			throw new VisitException("expected a "+SchemeEntityDescriptorEnum.SchemeExpressions);
		if (exprs.wIsEmpty())
			throw new VisitException("empty application");

		ConstExpression head = (ConstExpression) evaluate((SchemeExpression) exprs.wGet(0));
		ConstExpression[] args = new ConstExpression[exprs.wSize()-1];
		for (int i = 1; i < exprs.wSize(); i++)
			args[i-1] = (ConstExpression) evaluate(((SchemeExpression) exprs.wGet(i)));

		apply(head, args);
	}

	public void visit(CondExpression entity) {
		boolean prune = false;
		Branches branches = (Branches) entity.getBranches();
		if (!branches.wGetEntityDescriptor().equals(SchemeEntityDescriptorEnum.Branches))
			throw new VisitException("expected a "+SchemeEntityDescriptorEnum.Branches);

		for (int i = 0; i < branches.wSize() && !prune; i++) {
			Branch branch = (Branch) entity.wGet(i);
			if (booleanValue(branch.getTest())) {
				branch.getBody().accept(this);
				return;
			}
		}
		
		entity.getElseBody().accept(this);
	}

	public void visit(IdExpression entity) {
		setResult(getBindings().wGet(entity.getValue()));
	}
	
	public void visit(LambdaExpression entity) {
		setResult(SchemeEntityFactory.instance.createClosureValue(
				entity.getArgs(),
				entity.getBody(),
				SchemeEntityFactory.instance.createSchemeEnvironment(getBindings())));
	}
	
	public void visit(LocalExpression entity) {
		getBindings().wEnterScope();
		
		Definitions defs = entity.getDefinitions();
		if (!defs.wGetEntityDescriptor().equals(SchemeEntityDescriptorEnum.Definitions))
			throw new VisitException("expected a "+SchemeEntityDescriptorEnum.Definitions);
		
		for (int i = 0; i < defs.wSize(); i++) {
			IEntity e = defs.wGet(i);
			if (e.wGetEntityDescriptor().equals(SchemeEntityDescriptorEnum.Definition)) {
				Definition def = ((Definition) e);
				getBindings().wDef(def.getName().wStringValue(), def.getExpression());
			}
		}
		
		entity.getBody().accept(this);
		getBindings().wExitScope();
	}

	protected void apply(ConstExpression head, ConstExpression[] args) {
		valueInterpreter.args = args;
		head.accept(valueInterpreter);
	}

	public static class SchemeValueInterpreter extends SchemeIdentityVisitor {
		private SchemeInterpreterVisitor expressionInterpreter;
	    protected ConstExpression[] args;

		public SchemeValueInterpreter(SchemeInterpreterVisitor expressionInterpreter) {
			this.expressionInterpreter = expressionInterpreter;
		}


		public void visit(BuiltinValue entity) {
			//TODO
		}

		public void visit(ClosureValue entity) {
			if (args.length != entity.getArgs().wSize())
			    throw new VisitException("wrong number of arguments: "
						      + args.length + " instead of "
						      + entity.getArgs().wSize());

			expressionInterpreter.getBindings().wEnterScope(((SchemeEnvironment) entity.getEnv()).getValue(), false);
			IEntity names = entity.getArgs();
			for (int i=0; i<names.wSize(); i++) {
				expressionInterpreter.getBindings().wDef(names.wGet(i).wStringValue(), args[i]);
			}
			entity.getBody().accept(expressionInterpreter);
			expressionInterpreter.getBindings().wExitScope();
		}
	}
}
