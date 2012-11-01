package org.whole.lang.javascript.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class JavaScriptForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IJavaScriptVisitor {
	public JavaScriptForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Program entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Statements entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Comment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CommentKind entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ObjectLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ObjectProperties entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ObjectProperty entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EmptyExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ExpressionStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IfStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LabeledStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Labels entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Label entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BreakStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ContinueStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WithStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchCases entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchCase entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ReturnStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ThrowStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TryStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CatchClauses entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CatchClause entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WhileStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoWhileStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForInStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForEachStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LetStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableInitializers entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableInitializer entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FunctionDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclarationKind entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlAny entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ComputedXmlRef entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StaticXmlRef entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlMemberGet entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlDotQuery entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlMemberOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlFragments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlString entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XmlDefaultNamespace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FunctionExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Expressions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ParenthesizedExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrefixExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PostfixExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrefixOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PostfixOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InfixExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InfixOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AssignmentExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AssignmentOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConditionalExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NewExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CallExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ComputedMemberExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StaticMemberExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(YieldExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayComprehensionExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ComprehensionBlocks entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForInComprehensionBlock entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForEachComprehensionBlock entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LetExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Identifier entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NullLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ThisLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NumberLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RegExpLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringData entity) {
		wGetVisitor1().visit(entity);
	}
}
