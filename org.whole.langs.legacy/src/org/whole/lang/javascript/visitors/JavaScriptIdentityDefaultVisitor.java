package org.whole.lang.javascript.visitors;

import org.whole.lang.javascript.model.*;

/** 
 * @generator Whole
 */
public class JavaScriptIdentityDefaultVisitor extends JavaScriptIdentityVisitor {
	public void visit(IJavaScriptEntity entity) {
	}

	public void visit(Program entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(Statement entity) {
	}

	public void visit(Statements entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
		visit((FunctionBody) entity);
	}

	public void visit(FunctionBody entity) {
	}

	public void visit(Comment entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(CommentKind entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(DestructuringForm entity) {
	}

	public void visit(ObjectLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((DestructuringForm) entity);
		visit((Expression) entity);
	}

	public void visit(Expression entity) {
		visit((FunctionBody) entity);
		visit((VariableDeclarationOrExpression) entity);
	}

	public void visit(ObjectProperties entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(ObjectProperty entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(ArrayLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((DestructuringForm) entity);
		visit((Expression) entity);
	}

	public void visit(VariableDeclarationOrExpression entity) {
	}

	public void visit(EmptyExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(ExpressionStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(IfStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(LabeledStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(Labels entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(Label entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(Targeting entity) {
		visit((Statement) entity);
	}

	public void visit(BreakStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Targeting) entity);
	}

	public void visit(ContinueStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Targeting) entity);
	}

	public void visit(WithStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(SwitchStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(SwitchCases entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(SwitchCase entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(ReturnStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ThrowStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(TryStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(CatchClauses entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(CatchClause entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(WhileStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(DoWhileStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ForStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ForEachIn entity) {
		visit((Statement) entity);
	}

	public void visit(ForInStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((ForEachIn) entity);
	}

	public void visit(ForEachStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((ForEachIn) entity);
	}

	public void visit(LetStatement entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
		visit((Let) entity);
	}

	public void visit(Let entity) {
	}

	public void visit(VariableInitializers entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(VariableInitializer entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(Function entity) {
	}

	public void visit(FunctionDeclaration entity) {
		visit((IJavaScriptEntity) entity);
		visit((Function) entity);
		visit((Statement) entity);
	}

	public void visit(VariableDeclaration entity) {
		visit((IJavaScriptEntity) entity);
		visit((Statement) entity);
		visit((VariableDeclarationOrExpression) entity);
	}

	public void visit(VariableDeclarationKind entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(XmlAny entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
		visit((IdentifierOrXmlAny) entity);
	}

	public void visit(IdentifierOrXmlAny entity) {
	}

	public void visit(XmlRef entity) {
		visit((Expression) entity);
	}

	public void visit(ComputedXmlRef entity) {
		visit((IJavaScriptEntity) entity);
		visit((XmlRef) entity);
	}

	public void visit(StaticXmlRef entity) {
		visit((IJavaScriptEntity) entity);
		visit((XmlRef) entity);
	}

	public void visit(BinaryExpression entity) {
		visit((Expression) entity);
	}

	public void visit(XmlMemberGet entity) {
		visit((IJavaScriptEntity) entity);
		visit((BinaryExpression) entity);
	}

	public void visit(XmlDotQuery entity) {
		visit((IJavaScriptEntity) entity);
		visit((BinaryExpression) entity);
	}

	public void visit(XmlMemberOperator entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(Literal entity) {
		visit((Expression) entity);
		visit((LiteralOrIdentifier) entity);
	}

	public void visit(XmlLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(XmlFragments entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(XmlFragment entity) {
	}

	public void visit(XmlString entity) {
		visit((IJavaScriptEntity) entity);
		visit((XmlFragment) entity);
	}

	public void visit(XmlExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((XmlFragment) entity);
	}

	public void visit(UnaryExpression entity) {
		visit((Expression) entity);
	}

	public void visit(XmlDefaultNamespace entity) {
		visit((IJavaScriptEntity) entity);
		visit((UnaryExpression) entity);
	}

	public void visit(FunctionExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Function) entity);
		visit((Expression) entity);
	}

	public void visit(Expressions entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(ParenthesizedExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(PrefixExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((UnaryExpression) entity);
	}

	public void visit(PostfixExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((UnaryExpression) entity);
	}

	public void visit(PrefixOperator entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(PostfixOperator entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(InfixExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((BinaryExpression) entity);
	}

	public void visit(InfixOperator entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(AssignmentExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((BinaryExpression) entity);
	}

	public void visit(AssignmentOperator entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(ConditionalExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(NewExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(CallExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(MemberExpression entity) {
		visit((Expression) entity);
	}

	public void visit(ComputedMemberExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((MemberExpression) entity);
	}

	public void visit(StaticMemberExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((MemberExpression) entity);
	}

	public void visit(YieldExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
	}

	public void visit(ComprehensionExpression entity) {
		visit((Expression) entity);
	}

	public void visit(ArrayComprehensionExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((ComprehensionExpression) entity);
	}

	public void visit(ComprehensionBlocks entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(ComprehensionBlock entity) {
		visit((Statement) entity);
	}

	public void visit(ForInComprehensionBlock entity) {
		visit((IJavaScriptEntity) entity);
		visit((ComprehensionBlock) entity);
	}

	public void visit(ForEachComprehensionBlock entity) {
		visit((IJavaScriptEntity) entity);
		visit((ComprehensionBlock) entity);
	}

	public void visit(LetExpression entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
		visit((Let) entity);
	}

	public void visit(Identifier entity) {
		visit((IJavaScriptEntity) entity);
		visit((Expression) entity);
		visit((LiteralOrIdentifier) entity);
		visit((IdentifierOrXmlAny) entity);
	}

	public void visit(LiteralOrIdentifier entity) {
	}

	public void visit(NullLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(ThisLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(StringLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(BooleanLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(NumberLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(RegExpLiteral entity) {
		visit((IJavaScriptEntity) entity);
		visit((Literal) entity);
	}

	public void visit(BooleanData entity) {
		visit((IJavaScriptEntity) entity);
	}

	public void visit(StringData entity) {
		visit((IJavaScriptEntity) entity);
	}
}
