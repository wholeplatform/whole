package org.whole.lang.javascript.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.javascript.model.*;

/** 
 * @generator Whole
 */
public interface IJavaScriptVisitor extends IVisitor {
	public void visit(Program entity);

	public void visit(Statements entity);

	public void visit(Comment entity);

	public void visit(CommentKind entity);

	public void visit(ObjectLiteral entity);

	public void visit(ObjectProperties entity);

	public void visit(ObjectProperty entity);

	public void visit(ArrayLiteral entity);

	public void visit(EmptyExpression entity);

	public void visit(ExpressionStatement entity);

	public void visit(IfStatement entity);

	public void visit(LabeledStatement entity);

	public void visit(Labels entity);

	public void visit(Label entity);

	public void visit(BreakStatement entity);

	public void visit(ContinueStatement entity);

	public void visit(WithStatement entity);

	public void visit(SwitchStatement entity);

	public void visit(SwitchCases entity);

	public void visit(SwitchCase entity);

	public void visit(ReturnStatement entity);

	public void visit(ThrowStatement entity);

	public void visit(TryStatement entity);

	public void visit(CatchClauses entity);

	public void visit(CatchClause entity);

	public void visit(WhileStatement entity);

	public void visit(DoWhileStatement entity);

	public void visit(ForStatement entity);

	public void visit(ForInStatement entity);

	public void visit(ForEachStatement entity);

	public void visit(LetStatement entity);

	public void visit(VariableInitializers entity);

	public void visit(VariableInitializer entity);

	public void visit(FunctionDeclaration entity);

	public void visit(VariableDeclaration entity);

	public void visit(VariableDeclarationKind entity);

	public void visit(XmlAny entity);

	public void visit(ComputedXmlRef entity);

	public void visit(StaticXmlRef entity);

	public void visit(XmlMemberGet entity);

	public void visit(XmlDotQuery entity);

	public void visit(XmlMemberOperator entity);

	public void visit(XmlLiteral entity);

	public void visit(XmlFragments entity);

	public void visit(XmlString entity);

	public void visit(XmlExpression entity);

	public void visit(XmlDefaultNamespace entity);

	public void visit(FunctionExpression entity);

	public void visit(Expressions entity);

	public void visit(ParenthesizedExpression entity);

	public void visit(PrefixExpression entity);

	public void visit(PostfixExpression entity);

	public void visit(PrefixOperator entity);

	public void visit(PostfixOperator entity);

	public void visit(InfixExpression entity);

	public void visit(InfixOperator entity);

	public void visit(AssignmentExpression entity);

	public void visit(AssignmentOperator entity);

	public void visit(ConditionalExpression entity);

	public void visit(NewExpression entity);

	public void visit(CallExpression entity);

	public void visit(ComputedMemberExpression entity);

	public void visit(StaticMemberExpression entity);

	public void visit(YieldExpression entity);

	public void visit(ArrayComprehensionExpression entity);

	public void visit(ComprehensionBlocks entity);

	public void visit(ForInComprehensionBlock entity);

	public void visit(ForEachComprehensionBlock entity);

	public void visit(LetExpression entity);

	public void visit(Identifier entity);

	public void visit(NullLiteral entity);

	public void visit(ThisLiteral entity);

	public void visit(StringLiteral entity);

	public void visit(BooleanLiteral entity);

	public void visit(NumberLiteral entity);

	public void visit(RegExpLiteral entity);

	public void visit(BooleanData entity);

	public void visit(StringData entity);
}
