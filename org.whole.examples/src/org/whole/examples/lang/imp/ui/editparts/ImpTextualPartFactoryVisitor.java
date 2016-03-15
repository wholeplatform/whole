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
package org.whole.examples.lang.imp.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.examples.lang.imp.model.Addition;
import org.whole.examples.lang.imp.model.And;
import org.whole.examples.lang.imp.model.Arguments;
import org.whole.examples.lang.imp.model.ArrayAccess;
import org.whole.examples.lang.imp.model.ArrayLiteral;
import org.whole.examples.lang.imp.model.ArrayType;
import org.whole.examples.lang.imp.model.AssignmentExpression;
import org.whole.examples.lang.imp.model.BlockStatement;
import org.whole.examples.lang.imp.model.Division;
import org.whole.examples.lang.imp.model.DoWhileStatement;
import org.whole.examples.lang.imp.model.EmptyStatement;
import org.whole.examples.lang.imp.model.Equals;
import org.whole.examples.lang.imp.model.ExpressionStatement;
import org.whole.examples.lang.imp.model.ForStatement;
import org.whole.examples.lang.imp.model.ForeachStatement;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.model.FunctionInvocationExpression;
import org.whole.examples.lang.imp.model.GreaterOrEquals;
import org.whole.examples.lang.imp.model.GreaterThan;
import org.whole.examples.lang.imp.model.IImpEntity;
import org.whole.examples.lang.imp.model.IfElseStatement;
import org.whole.examples.lang.imp.model.IfStatement;
import org.whole.examples.lang.imp.model.LessOrEquals;
import org.whole.examples.lang.imp.model.LessThan;
import org.whole.examples.lang.imp.model.LoadExpression;
import org.whole.examples.lang.imp.model.Multiplication;
import org.whole.examples.lang.imp.model.Not;
import org.whole.examples.lang.imp.model.NotEquals;
import org.whole.examples.lang.imp.model.Or;
import org.whole.examples.lang.imp.model.Parameter;
import org.whole.examples.lang.imp.model.Parameters;
import org.whole.examples.lang.imp.model.PrintStatement;
import org.whole.examples.lang.imp.model.PrintlnStatement;
import org.whole.examples.lang.imp.model.RangeLiteral;
import org.whole.examples.lang.imp.model.Remainder;
import org.whole.examples.lang.imp.model.ReturnStatement;
import org.whole.examples.lang.imp.model.RunExpression;
import org.whole.examples.lang.imp.model.SaveStatement;
import org.whole.examples.lang.imp.model.SizeExpression;
import org.whole.examples.lang.imp.model.StringLiteral;
import org.whole.examples.lang.imp.model.Subtraction;
import org.whole.examples.lang.imp.model.VariableDeclaration;
import org.whole.examples.lang.imp.model.WhileStatement;
import org.whole.examples.lang.imp.visitors.ImpIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.editparts.QuotedStringTextualEntityPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class ImpTextualPartFactoryVisitor extends ImpIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IImpEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IImpEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(FunctionDeclaration entity) {
		part = new FunctionDeclarationPart();
	}

	public void visit(Parameters entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(Parameter entity) {
		part = new ParameterPart();
	}

	public void visit(FunctionInvocationExpression entity) {
		part = new FunctionInvocationPart();
	}

	public void visit(Arguments entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(StringLiteral entity) {
		part = new QuotedStringTextualEntityPart();
	}

	public void visit(EmptyStatement entity) {
		part = new EmptyStatementPart();
	}

	public void visit(ReturnStatement entity) {
		part = new ReturnStatementPart();
	}

	public void visit(IfStatement entity) {
		part = new IfStatementTextualPart();
	}

	public void visit(IfElseStatement entity) {
		part = new IfElseStatementTextualPart();
	}

	public void visit(WhileStatement entity) {
		part = new WhileStatementTextualPart();
	}

	public void visit(DoWhileStatement entity) {
		part = new DoWhileStatementTextualPart();
	}

	public void visit(ForStatement entity) {
		part = new ForStatementPart();
	}

	public void visit(ForeachStatement entity) {
		part = new ForeachStatementPart();
	}

	public void visit(BlockStatement entity) {
		part = new CompositeColumnPart();
	}

	public void visit(VariableDeclaration entity) {
		part = new VariableDeclarationPart();
	}

	public void visit(AssignmentExpression entity) {
		part = new AssignmentExpressionPart();
	}

	public void visit(PrintStatement entity) {
		part = new PrintStatementPart();
	}

	public void visit(PrintlnStatement entity) {
		part = new PrintlnStatementPart();
	}

	public void visit(SaveStatement entity) {
		part = new SaveStatementPart();
	}

	public void visit(ExpressionStatement entity) {
		part = new ExpressionStatementPart();
	}

	public void visit(LoadExpression entity) {
		part = new LoadExpressionPart();
	}

	public void visit(RunExpression entity) {
		part = new RunExpressionPart();
	}

	public void visit(SizeExpression entity) {
		part = new PrefixExpressionPart("#");
	}

	public void visit(RangeLiteral entity) {
		part = new RangeLiteralPart();
	}

	public void visit(ArrayLiteral entity) {
		part = new CompositeRowPart();
	}

	public void visit(ArrayType entity) {
		part = new ArrayTypePart();
	}

	public void visit(ArrayAccess entity) {
		part = new ArrayAccessPart();
	}

	public void visit(Addition entity) {
		part = new InfixExpressionPart("+");
	}

	public void visit(Subtraction entity) {
		part = new InfixExpressionPart("-");
	}

	public void visit(Multiplication entity) {
		part = new InfixExpressionPart("*");
	}

	public void visit(Division entity) {
		part = new InfixExpressionPart("/");
	}

	public void visit(Remainder entity) {
		part = new InfixExpressionPart("%");
	}

	public void visit(And entity) {
		part = new InfixExpressionPart("&&");
	}

	public void visit(Or entity) {
		part = new InfixExpressionPart("||");
	}

	public void visit(Not entity) {
		part = new PrefixExpressionPart("!");
	}

	public void visit(Equals entity) {
		part = new InfixExpressionPart("==");
	}

	public void visit(NotEquals entity) {
		part = new InfixExpressionPart("!=");
	}

	public void visit(LessThan entity) {
		part = new InfixExpressionPart("<");
	}

	public void visit(LessOrEquals entity) {
		part = new InfixExpressionPart("<=");
	}

	public void visit(GreaterThan entity) {
		part = new InfixExpressionPart(">");
	}

	public void visit(GreaterOrEquals entity) {
		part = new InfixExpressionPart(">=");
	}
}