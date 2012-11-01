package org.whole.lang.javascript.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class JavaScriptIdentitySwitchVisitor extends AbstractVisitor
		implements IJavaScriptVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case JavaScriptEntityDescriptorEnum.Program_ord:
			visit((Program) entity);
			break;
		case JavaScriptEntityDescriptorEnum.Statements_ord:
			visit((Statements) entity);
			break;
		case JavaScriptEntityDescriptorEnum.Comment_ord:
			visit((Comment) entity);
			break;
		case JavaScriptEntityDescriptorEnum.CommentKind_ord:
			visit((CommentKind) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ObjectLiteral_ord:
			visit((ObjectLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperties_ord:
			visit((ObjectProperties) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperty_ord:
			visit((ObjectProperty) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ArrayLiteral_ord:
			visit((ArrayLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.EmptyExpression_ord:
			visit((EmptyExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ExpressionStatement_ord:
			visit((ExpressionStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.IfStatement_ord:
			visit((IfStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.LabeledStatement_ord:
			visit((LabeledStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.Labels_ord:
			visit((Labels) entity);
			break;
		case JavaScriptEntityDescriptorEnum.Label_ord:
			visit((Label) entity);
			break;
		case JavaScriptEntityDescriptorEnum.BreakStatement_ord:
			visit((BreakStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ContinueStatement_ord:
			visit((ContinueStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.WithStatement_ord:
			visit((WithStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.SwitchStatement_ord:
			visit((SwitchStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCases_ord:
			visit((SwitchCases) entity);
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCase_ord:
			visit((SwitchCase) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ReturnStatement_ord:
			visit((ReturnStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ThrowStatement_ord:
			visit((ThrowStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.TryStatement_ord:
			visit((TryStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.CatchClauses_ord:
			visit((CatchClauses) entity);
			break;
		case JavaScriptEntityDescriptorEnum.CatchClause_ord:
			visit((CatchClause) entity);
			break;
		case JavaScriptEntityDescriptorEnum.WhileStatement_ord:
			visit((WhileStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.DoWhileStatement_ord:
			visit((DoWhileStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ForStatement_ord:
			visit((ForStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ForInStatement_ord:
			visit((ForInStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ForEachStatement_ord:
			visit((ForEachStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.LetStatement_ord:
			visit((LetStatement) entity);
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializers_ord:
			visit((VariableInitializers) entity);
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializer_ord:
			visit((VariableInitializer) entity);
			break;
		case JavaScriptEntityDescriptorEnum.FunctionDeclaration_ord:
			visit((FunctionDeclaration) entity);
			break;
		case JavaScriptEntityDescriptorEnum.VariableDeclaration_ord:
			visit((VariableDeclaration) entity);
			break;
		case JavaScriptEntityDescriptorEnum.VariableDeclarationKind_ord:
			visit((VariableDeclarationKind) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlAny_ord:
			visit((XmlAny) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ComputedXmlRef_ord:
			visit((ComputedXmlRef) entity);
			break;
		case JavaScriptEntityDescriptorEnum.StaticXmlRef_ord:
			visit((StaticXmlRef) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberGet_ord:
			visit((XmlMemberGet) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlDotQuery_ord:
			visit((XmlDotQuery) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberOperator_ord:
			visit((XmlMemberOperator) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlLiteral_ord:
			visit((XmlLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlFragments_ord:
			visit((XmlFragments) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlString_ord:
			visit((XmlString) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlExpression_ord:
			visit((XmlExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlDefaultNamespace_ord:
			visit((XmlDefaultNamespace) entity);
			break;
		case JavaScriptEntityDescriptorEnum.FunctionExpression_ord:
			visit((FunctionExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.Expressions_ord:
			visit((Expressions) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ParenthesizedExpression_ord:
			visit((ParenthesizedExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.PrefixExpression_ord:
			visit((PrefixExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.PostfixExpression_ord:
			visit((PostfixExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.PrefixOperator_ord:
			visit((PrefixOperator) entity);
			break;
		case JavaScriptEntityDescriptorEnum.PostfixOperator_ord:
			visit((PostfixOperator) entity);
			break;
		case JavaScriptEntityDescriptorEnum.InfixExpression_ord:
			visit((InfixExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.InfixOperator_ord:
			visit((InfixOperator) entity);
			break;
		case JavaScriptEntityDescriptorEnum.AssignmentExpression_ord:
			visit((AssignmentExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.AssignmentOperator_ord:
			visit((AssignmentOperator) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ConditionalExpression_ord:
			visit((ConditionalExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.NewExpression_ord:
			visit((NewExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.CallExpression_ord:
			visit((CallExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ComputedMemberExpression_ord:
			visit((ComputedMemberExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.StaticMemberExpression_ord:
			visit((StaticMemberExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.YieldExpression_ord:
			visit((YieldExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression_ord:
			visit((ArrayComprehensionExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ComprehensionBlocks_ord:
			visit((ComprehensionBlocks) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ForInComprehensionBlock_ord:
			visit((ForInComprehensionBlock) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock_ord:
			visit((ForEachComprehensionBlock) entity);
			break;
		case JavaScriptEntityDescriptorEnum.LetExpression_ord:
			visit((LetExpression) entity);
			break;
		case JavaScriptEntityDescriptorEnum.Identifier_ord:
			visit((Identifier) entity);
			break;
		case JavaScriptEntityDescriptorEnum.NullLiteral_ord:
			visit((NullLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.ThisLiteral_ord:
			visit((ThisLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.StringLiteral_ord:
			visit((StringLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.BooleanLiteral_ord:
			visit((BooleanLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.NumberLiteral_ord:
			visit((NumberLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.RegExpLiteral_ord:
			visit((RegExpLiteral) entity);
			break;
		case JavaScriptEntityDescriptorEnum.BooleanData_ord:
			visit((BooleanData) entity);
			break;
		case JavaScriptEntityDescriptorEnum.StringData_ord:
			visit((StringData) entity);
			break;
		}
	}
}
