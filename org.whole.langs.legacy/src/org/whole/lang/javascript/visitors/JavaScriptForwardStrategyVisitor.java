package org.whole.lang.javascript.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class JavaScriptForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IJavaScriptVisitor> implements
		IJavaScriptVisitor {
	public JavaScriptForwardStrategyVisitor() {
		this(new JavaScriptIdentityVisitor());
	}

	public JavaScriptForwardStrategyVisitor(
			IJavaScriptVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IJavaScriptEntity) entity).accept(this);
	}

	public void visit(Program entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Statements entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Comment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CommentKind entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ObjectLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ObjectProperties entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ObjectProperty entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EmptyExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ExpressionStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IfStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LabeledStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Labels entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Label entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BreakStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ContinueStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WithStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SwitchStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SwitchCases entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SwitchCase entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ReturnStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ThrowStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TryStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CatchClauses entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CatchClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WhileStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoWhileStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForInStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForEachStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LetStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableInitializers entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableInitializer entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableDeclarationKind entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlAny entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComputedXmlRef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StaticXmlRef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlMemberGet entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlDotQuery entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlMemberOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlFragments entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlString entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XmlDefaultNamespace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Expressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ParenthesizedExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrefixExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PostfixExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrefixOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PostfixOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InfixExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InfixOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AssignmentExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AssignmentOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ConditionalExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NewExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CallExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComputedMemberExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StaticMemberExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(YieldExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayComprehensionExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComprehensionBlocks entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForInComprehensionBlock entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForEachComprehensionBlock entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LetExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Identifier entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NullLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ThisLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NumberLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RegExpLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringData entity) {
		wGetStrategy().visit(entity);
	}
}
