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
package org.whole.lang.javascript.util;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.*;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.javascript.builders.IJavaScriptBuilder;
import org.whole.lang.javascript.model.AssignmentOperatorEnum;
import org.whole.lang.javascript.model.CommentKindEnum;
import org.whole.lang.javascript.model.InfixOperatorEnum;
import org.whole.lang.javascript.model.PostfixOperatorEnum;
import org.whole.lang.javascript.model.PrefixOperatorEnum;
import org.whole.lang.javascript.model.VariableDeclarationKindEnum;
import org.whole.lang.javascript.model.XmlMemberOperatorEnum;
import org.whole.lang.javascript.reflect.JavaScriptLanguageKit;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class RhinoTransformerVisitor implements NodeVisitor {
	protected IJavaScriptBuilder jb;
	protected ICommonsBuilder cb;
	protected IBuilderOperation op;
	protected LinkedList<Comment> comments = new LinkedList<Comment>();

	public RhinoTransformerVisitor(IBuilderOperation op) {
		this.jb = (IJavaScriptBuilder) op.wGetBuilder(JavaScriptLanguageKit.URI);
		this.cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		this.op = op;
	}

	public static IEntity transform(IPersistenceProvider pp) throws Exception {
		CompilerEnvirons compilerEnvirons = CompilerEnvirons.ideEnvirons();
		compilerEnvirons.setLanguageVersion(Context.VERSION_1_8);
		Parser parser = new Parser(compilerEnvirons);
		
		AstRoot astRoot = parser.parse(new InputStreamReader(pp.getInputStream(), pp.getEncoding()), "http://whole.sourceforge.net/test.js", 0);
		ModelBuilderOperation mop = new ModelBuilderOperation();
		RhinoTransformerVisitor visitor = new RhinoTransformerVisitor(mop);
		astRoot.visit(visitor);
		
		return mop.wGetResult();
	}

	protected void safeVisit(AstNode node) {
		if (node != null)
			node.visit(this);
		else
			cb.Resolver();
	}
	protected <T extends AstNode> void safeVisitChildren(AstNode astNode) {
		if (astNode != null) {
			for (Node element : astNode)
				safeVisit((AstNode) element);
		}
	}
	protected <T extends AstNode> void safeVisitChildren(Iterable<T> iterable) {
		if (iterable != null) {
			for (T element : iterable)
				safeVisit(element);
		}
	}
	protected <T extends Node> void safeVisitStatements(Iterable<T> iterable) {
		if (iterable != null) {
			for (Node element : iterable) {
				AstNode statement = (AstNode) element;
				int absolutePosition = statement.getAbsolutePosition();
				while (!comments.isEmpty() && absolutePosition > comments.getFirst().getAbsolutePosition())
					safeVisit(comments.removeFirst());
				safeVisit(statement);
			}
		}
	}
	public boolean visit(AstNode node) {
		switch (node.getType()) {
		case Token.SCRIPT:
			return visitAstRoot((AstRoot) node);
		case Token.COMMENT:
			return visitComment((Comment) node);
		case Token.ARRAYLIT:
			return visitArrayLiteral((ArrayLiteral) node);
		case Token.ARRAYCOMP:
			return visitArrayComprehension((ArrayComprehension) node);
		case Token.ASSIGN:
		case Token.ASSIGN_BITOR:
		case Token.ASSIGN_BITXOR:
		case Token.ASSIGN_BITAND:
		case Token.ASSIGN_LSH:
		case Token.ASSIGN_RSH:
		case Token.ASSIGN_URSH:
		case Token.ASSIGN_ADD:
		case Token.ASSIGN_SUB:
		case Token.ASSIGN_MUL:
		case Token.ASSIGN_DIV:
		case Token.ASSIGN_MOD:
			return visitAssignment((Assignment) node);
		case Token.BLOCK:
			return visitBlock(node);
		case Token.BREAK:
			return visitBreakStatement((BreakStatement) node);
		case Token.CATCH:
			return visitCatchClause((CatchClause) node);
		case Token.HOOK:
			return visitConditionalExpression((ConditionalExpression) node);
		case Token.CONTINUE:
			return visitContinueStatement((ContinueStatement) node);
		case Token.DO:
			return visitDoLoop((DoLoop) node);
		case Token.GETELEM:
			return visitElementGet((ElementGet) node);
		case Token.EMPTY:
			return visitEmptyExpression((EmptyExpression) node);
		case Token.EXPR_VOID:
			return node instanceof LabeledStatement ?
					visitLabeledStatement((LabeledStatement) node) :
						visitExpressionStatement((ExpressionStatement) node);
		case Token.EXPR_RESULT:
			return visitExpressionStatement((ExpressionStatement) node);
		case Token.FOR:
			return node instanceof ForLoop ?
					visitForLoop((ForLoop) node) :
						node instanceof ArrayComprehensionLoop ? 
								visitArrayComprehensionLoop((ArrayComprehensionLoop) node) :
									visitForInLoop((ForInLoop) node);
		case Token.CALL:
			return visitFunctionCall((FunctionCall) node);
		case Token.FUNCTION:
			return visitFunctionNode((FunctionNode) node);
		case Token.IF:
			return visitIfStatement((IfStatement) node);
		case Token.COMMA:
			return visitCommaInfixExpression((InfixExpression) node);
		case Token.ADD:
		case Token.SUB:
		case Token.AND:
		case Token.BITAND:
		case Token.BITOR:
		case Token.BITXOR:
		case Token.EQ:
		case Token.NE:
		case Token.SHEQ:
		case Token.SHNE:
		case Token.MUL:
		case Token.DIV:
		case Token.MOD:
		case Token.OR:
		case Token.IN:
		case Token.INSTANCEOF:
		case Token.LE:
		case Token.LT:
		case Token.GE:
		case Token.GT:
		case Token.LSH:
		case Token.URSH:
		case Token.RSH:
			return visitInfixExpression((InfixExpression) node);
		case Token.THIS:
		case Token.NULL:
		case Token.TRUE:
		case Token.FALSE:
			return visitKeywordLiteral((KeywordLiteral) node);
		case Token.LABEL:
			return visitLabel((Label) node);
		case Token.LET:
			return node instanceof LetNode ?
					visitLetNode((LetNode) node) :
						node instanceof VariableDeclaration ?
								visitVariableDeclaration((VariableDeclaration) node) :
									visitVariableInitializer((VariableInitializer) node);
		case Token.LETEXPR:
			return visitLetNode((LetNode) node);
		case Token.NAME:
			return visitName((Name) node);
		case Token.NEW:
			return visitNewExpression((NewExpression) node);
		case Token.NUMBER:
			return visitNumberLiteral((NumberLiteral) node);
		case Token.OBJECTLIT:
			return visitObjectLiteral((ObjectLiteral) node);
		case Token.COLON:
		case Token.GET:
		case Token.SET:
			return visitObjectProperty((ObjectProperty) node);
		case Token.LP:
			return visitParenthesizedExpression((ParenthesizedExpression) node);
		case Token.GETPROP:
			return visitPropertyGet((PropertyGet) node);
		case Token.REGEXP:
			return visitRegExpLiteral((RegExpLiteral) node);
		case Token.RETURN:
			return visitReturnStatement((ReturnStatement) node);
		case Token.STRING:
			return visitStringLiteral((StringLiteral) node);
		case Token.CASE:
			return visitSwitchCase((SwitchCase) node);
		case Token.SWITCH:
			return visitSwitchStatement((SwitchStatement) node);
		case Token.THROW:
			return visitThrowStatement((ThrowStatement) node);
		case Token.TRY:
			return visitTryStatement((TryStatement) node);
		case Token.DEFAULTNAMESPACE:
			return visitXmlDefaultNamespaceExpression((UnaryExpression) node);
		case Token.VOID:
		case Token.NOT:
		case Token.POS:
		case Token.NEG:
		case Token.BITNOT:
		case Token.TYPEOF:
		case Token.INC:
		case Token.DEC:
		case Token.DELPROP:
			return visitUnaryExpression((UnaryExpression) node);
		case Token.VAR:
		case Token.CONST:
			return node instanceof VariableDeclaration ?
					visitVariableDeclaration((VariableDeclaration) node) :
						visitVariableInitializer((VariableInitializer) node);
		case Token.WHILE:
			return visitWhileLoop((WhileLoop) node);
		case Token.WITH:
			return visitWithStatement((WithStatement) node);
		case Token.DOTQUERY:
			return visitXmlDotQuery((XmlDotQuery) node);
		case Token.REF_MEMBER:
			return visitXmlElemRef((XmlElemRef) node);
		case Token.XML:
			return node instanceof XmlExpression ?
					visitXmlExpression((XmlExpression) node) :
						node instanceof XmlString ?
								visitXmlString((XmlString) node) :
									visitXmlLiteral((XmlLiteral) node);
		case Token.DOT:
		case Token.DOTDOT:
			return visitXmlMemberGet((XmlMemberGet) node);
		case Token.REF_NAME:
			return visitXmlPropRef((XmlPropRef) node);
		case Token.YIELD:
			return visitYield((Yield) node);
		default:
			return false;
		}
	}

	protected boolean visitYield(Yield node) {
		jb.YieldExpression_();
		safeVisit(node.getValue());
		jb._YieldExpression();
		return false;
	}

	protected boolean visitXmlPropRef(XmlPropRef node) {
		jb.StaticXmlRef_();
		jb.BooleanData(node.isAttributeAccess());
		safeVisit(node.getNamespace());
		safeVisit(node.getPropName());
		jb._StaticXmlRef();
		return false;
	}

	protected boolean visitXmlMemberGet(XmlMemberGet node) {
		jb.XmlMemberGet_();
		safeVisit(node.getLeft());
		switch (node.getType()) {
		case Token.DOT:
			jb.XmlMemberOperator(XmlMemberOperatorEnum.dot);
			break;
		case Token.DOTDOT:
			jb.XmlMemberOperator(XmlMemberOperatorEnum.dotdot);
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		safeVisit(node.getRight());
		jb._XmlMemberGet();
		return false;
	}

	private boolean visitXmlLiteral(XmlLiteral node) {
		jb.XmlLiteral_();
		jb.XmlFragments_();
		safeVisitChildren(node.getFragments());
		jb._XmlFragments();
		jb._XmlLiteral();
		return false;
	}

	private boolean visitXmlString(XmlString node) {
		jb.XmlString_();
		jb.StringData(node.getXml());
		jb._XmlString();
		return false;
	}

	protected boolean visitXmlExpression(XmlExpression node) {
		jb.XmlExpression_();
		safeVisit(node.getExpression());
		jb._XmlExpression();
		return false;
	}

	protected boolean visitXmlElemRef(XmlElemRef node) {
		jb.ComputedXmlRef_();
		jb.BooleanData(node.isAttributeAccess());
		safeVisit(node.getNamespace());
		safeVisit(node.getExpression());
		jb._ComputedXmlRef();
		return false;
	}

	protected boolean visitXmlDotQuery(XmlDotQuery node) {
		jb.XmlDotQuery_();
		safeVisit(node.getLeft());
		safeVisit(node.getRight());
		jb._XmlDotQuery();
		return false;
	}

	protected boolean visitWithStatement(WithStatement node) {
		jb.WithStatement_();
		safeVisit(node.getExpression());
		safeVisit(node.getStatement());
		jb._WithStatement();
		return false;
	}

	protected boolean visitWhileLoop(WhileLoop node) {
		jb.WhileStatement_();
		safeVisit(node.getCondition());
		safeVisit(node.getBody());
		jb._WhileStatement();
		return false;
	}

	protected boolean visitVariableInitializer(VariableInitializer node) {
		jb.VariableInitializer_();
		safeVisit(node.getTarget());
		safeVisit(node.getInitializer());
		jb._VariableInitializer();
		return false;
	}

	protected boolean visitVariableDeclaration(VariableDeclaration node) {
		jb.VariableDeclaration_();
		switch (node.getType()) {
		case Token.VAR:
			jb.VariableDeclarationKind(VariableDeclarationKindEnum.var);
			break;
		case Token.LET:
			jb.VariableDeclarationKind(VariableDeclarationKindEnum.let);
			break;
		case Token.CONST:
			jb.VariableDeclarationKind(VariableDeclarationKindEnum._const);
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		jb.VariableInitializers_();
		safeVisitChildren(node.getVariables());
		jb._VariableInitializers();
		jb._VariableDeclaration();
		return false;
	}

	
	protected boolean visitXmlDefaultNamespaceExpression(UnaryExpression node) {
		jb.XmlDefaultNamespace_();
		safeVisit(node.getOperand());
		jb._XmlDefaultNamespace();
		return false;
	}

	protected boolean visitUnaryExpression(UnaryExpression node) {
		if (node.isPrefix()) {
			jb.PrefixExpression_();
			switch (node.getType()) {
			case Token.INC:
				jb.PrefixOperator(PrefixOperatorEnum.increment);
				break;
			case Token.DEC:
				jb.PrefixOperator(PrefixOperatorEnum.decrement);
				break;
			case Token.POS:
				jb.PrefixOperator(PrefixOperatorEnum.plus);
				break;
			case Token.NEG:
				jb.PrefixOperator(PrefixOperatorEnum.minus);
				break;
			case Token.BITNOT:
				jb.PrefixOperator(PrefixOperatorEnum.complement);
				break;
			case Token.NOT:
				jb.PrefixOperator(PrefixOperatorEnum.not);
				break;
			case Token.TYPEOF:
				jb.PrefixOperator(PrefixOperatorEnum.typeof);
				break;
			case Token.VOID:
				jb.PrefixOperator(PrefixOperatorEnum._void);
				break;
			case Token.DELPROP:
				jb.PrefixOperator(PrefixOperatorEnum.delete);
				break;
			default:
				throw new IllegalArgumentException("usupported type");
			}
			safeVisit(node.getOperand());
			jb._PrefixExpression();
		} else {
			jb.PostfixExpression_();
			safeVisit(node.getOperand());
			switch (node.getType()) {
			case Token.INC:
				jb.PostfixOperator(PostfixOperatorEnum.increment);
				break;
			case Token.DEC:
				jb.PostfixOperator(PostfixOperatorEnum.decrement);
				break;
			default:
				throw new IllegalArgumentException("usupported type");
			}
			jb._PostfixExpression();
		}
		return false;
	}

	protected boolean visitTryStatement(TryStatement node) {
		jb.TryStatement_();
		safeVisit(node.getTryBlock());
		List<CatchClause> catchClauses = node.getCatchClauses();
		if (!catchClauses.isEmpty()) {
			jb.CatchClauses_();
			safeVisitChildren(catchClauses);
			jb._CatchClauses();
		} else
			cb.Resolver();
		safeVisit(node.getFinallyBlock());
		jb._TryStatement();
		return false;
	}

	protected boolean visitThrowStatement(ThrowStatement node) {
		jb.ThrowStatement_();
		safeVisit(node.getExpression());
		jb._ThrowStatement();
		return false;
	}

	protected boolean visitSwitchStatement(SwitchStatement node) {
		jb.SwitchStatement_();
		safeVisit(node.getExpression());
		jb.SwitchCases_();
		safeVisitChildren(node.getCases());
		jb._SwitchCases();
		jb._SwitchStatement();
		return false;
	}

	protected boolean visitSwitchCase(SwitchCase node) {
		jb.SwitchCase_();
		safeVisit(node.getExpression());
		jb.Statements_();
		safeVisitStatements(node.getStatements());
		jb._Statements();
		jb._SwitchCase();
		return false;
	}

	protected boolean visitStringLiteral(StringLiteral node) {
		jb.StringLiteral_();
		jb.StringData(node.getValue());
		jb.StringData(Character.toString(node.getQuoteCharacter()));
		jb._StringLiteral();
		return false;
	}

	protected boolean visitReturnStatement(ReturnStatement node) {
		jb.ReturnStatement_();
		safeVisit(node.getReturnValue());
		jb._ReturnStatement();
		return false;
	}

	protected boolean visitRegExpLiteral(RegExpLiteral node) {
		jb.RegExpLiteral_();
		jb.StringData(node.getValue());
		jb.StringData(node.getFlags());
		jb._RegExpLiteral();
		return false;
	}

	protected boolean visitPropertyGet(PropertyGet node) {
		jb.StaticMemberExpression_();
		safeVisit(node.getLeft());
		safeVisit(node.getRight());
		jb._StaticMemberExpression();
		return false;
	}

	protected boolean visitParenthesizedExpression(ParenthesizedExpression node) {
		jb.ParenthesizedExpression_();
		safeVisit(node.getExpression());
		jb._ParenthesizedExpression();
		return false;
	}

	protected boolean visitObjectProperty(ObjectProperty node) {
		jb.ObjectProperty_();
		safeVisit(node.getLeft());
		safeVisit(node.getRight());
		jb._ObjectProperty();
		return false;
	}

	protected boolean visitObjectLiteral(ObjectLiteral node) {
		jb.ObjectLiteral_();
		jb.BooleanData(node.isDestructuring());
		jb.ObjectProperties_();
		safeVisitChildren(node.getElements());
		jb._ObjectProperties();
		jb._ObjectLiteral();
		return false;
	}

	protected boolean visitNumberLiteral(NumberLiteral node) {
		jb.NumberLiteral(node.getNumber());
		return false;
	}

	protected boolean visitNewExpression(NewExpression node) {
		jb.NewExpression_();
		safeVisit(node.getTarget());
		List<AstNode> arguments = node.getArguments();
		if (!arguments.isEmpty()) {
			jb.Expressions_();
			safeVisitChildren(arguments);
			jb._Expressions();
		} else
			cb.Resolver();
		jb._NewExpression();
		return false;
	}

	protected boolean visitName(Name node) {
		String identifier = node.getIdentifier();
		if ("*".equals(identifier))
			jb.XmlAny();
		else
			jb.Identifier(identifier);
		return false;
	}

	protected void buildLetContents(LetNode node) {
		jb.VariableInitializers_();
		safeVisitChildren(node.getVariables().getVariables());
		jb._VariableInitializers();
		safeVisit(node.getBody());
	}
	protected boolean visitLetNode(LetNode node) {
		switch (node.getType()) {
		case Token.LETEXPR:
			jb.LetExpression_();
			buildLetContents(node);
			jb._LetExpression();
			break;
		case Token.LET:
			jb.LetStatement_();
			buildLetContents(node);
			jb._LetStatement();
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		return false;
	}

	protected boolean visitLabeledStatement(LabeledStatement node) {
		jb.LabeledStatement_();
		jb.Labels_();
		safeVisitChildren(node.getLabels());
		jb._Labels();
		safeVisit(node.getStatement());
		jb._LabeledStatement();
		return false;
	}

	protected boolean visitLabel(Label node) {
		jb.Label_();
		jb.Identifier(node.getName());
		jb._Label();
		return false;
	}

	protected boolean visitKeywordLiteral(KeywordLiteral node) {
		switch (node.getType()) {
		case Token.THIS:
			jb.ThisLiteral();
			break;
		case Token.NULL:
			jb.NullLiteral();
			break;
		case Token.TRUE:
			jb.BooleanLiteral(true);
			break;
		case Token.FALSE:
			jb.BooleanLiteral(false);
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		return false;
	}

	protected boolean visitCommaInfixExpression(InfixExpression node) {
		boolean inComma = node.getParent().getType() == Token.COMMA;
		if (!inComma)
			jb.Expressions_();

		safeVisit(node.getLeft());
		safeVisit(node.getRight());
		if (!inComma)
			jb._Expressions();

		return false;
	}

	protected boolean visitInfixExpression(InfixExpression node) {
		jb.InfixExpression_();
		safeVisit(node.getLeft());
		switch (node.getType()) {
		case Token.ADD:
			jb.InfixOperator(InfixOperatorEnum.plus);
			break;
		case Token.SUB:
			jb.InfixOperator(InfixOperatorEnum.minus);
			break;
		case Token.AND:
			jb.InfixOperator(InfixOperatorEnum.conditional_and);
			break;
		case Token.OR:
			jb.InfixOperator(InfixOperatorEnum.conditional_or);
			break;
		case Token.BITAND:
			jb.InfixOperator(InfixOperatorEnum.and);
			break;
		case Token.BITOR:
			jb.InfixOperator(InfixOperatorEnum.or);
			break;
		case Token.BITXOR:
			jb.InfixOperator(InfixOperatorEnum.xor);
			break;
		case Token.EQ:
			jb.InfixOperator(InfixOperatorEnum.equals);
			break;
		case Token.NE:
			jb.InfixOperator(InfixOperatorEnum.not_equals);
			break;
		case Token.SHEQ:
			jb.InfixOperator(InfixOperatorEnum.shallow_equals);
			break;
		case Token.SHNE:
			jb.InfixOperator(InfixOperatorEnum.shallow_not_equals);
			break;
		case Token.MUL:
			jb.InfixOperator(InfixOperatorEnum.times);
			break;
		case Token.DIV:
			jb.InfixOperator(InfixOperatorEnum.divide);
			break;
		case Token.MOD:
			jb.InfixOperator(InfixOperatorEnum.remainder);
			break;
		case Token.IN:
			jb.InfixOperator(InfixOperatorEnum.in);
			break;
		case Token.INSTANCEOF:
			jb.InfixOperator(InfixOperatorEnum._instanceof);
			break;
		case Token.LE:
			jb.InfixOperator(InfixOperatorEnum.less_equals);
			break;
		case Token.LT:
			jb.InfixOperator(InfixOperatorEnum.less);
			break;
		case Token.GE:
			jb.InfixOperator(InfixOperatorEnum.greater_equals);
			break;
		case Token.GT:
			jb.InfixOperator(InfixOperatorEnum.greater);
			break;
		case Token.LSH:
			jb.InfixOperator(InfixOperatorEnum.left_shift);
			break;
		case Token.URSH:
			jb.InfixOperator(InfixOperatorEnum.right_shift_unsigned);
			break;
		case Token.RSH:
			jb.InfixOperator(InfixOperatorEnum.right_shift_signed);
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		safeVisit(node.getRight());
		jb._InfixExpression();
		return false;
	}

	protected boolean visitIfStatement(IfStatement node) {
		jb.IfStatement_();
		safeVisit(node.getCondition());
		safeVisit(node.getThenPart());
		safeVisit(node.getElsePart());
		jb._IfStatement();
		return false;
	}

	protected boolean visitFunctionCall(FunctionCall node) {
		jb.CallExpression_();
		safeVisit(node.getTarget());
		List<AstNode> arguments = node.getArguments();
		if (!arguments.isEmpty()) {
			jb.Expressions_();
			safeVisitChildren(arguments);
			jb._Expressions();
		} else
			cb.Resolver();
		jb._CallExpression();
		return false;
	}

	protected boolean visitFunctionNode(FunctionNode node) {
		boolean isTopLevel = node.getFunctionType() == FunctionNode.FUNCTION_STATEMENT;
		if (isTopLevel)
			jb.FunctionDeclaration_();
		else
			jb.FunctionExpression_();
		safeVisit(node.getFunctionName());
		List<AstNode> params = node.getParams();
		if (!params.isEmpty()) {
			jb.Expressions_();
			safeVisitChildren(params);
			jb._Expressions();
		} else
			cb.Resolver();
		safeVisit(node.getBody());
		if (isTopLevel)
			jb._FunctionDeclaration();
		else
			jb._FunctionExpression();
		return false;
	}

	protected boolean visitForInLoop(ForInLoop node) {
		boolean isForEach = node.isForEach();
		if (isForEach)
			jb.ForEachStatement_();
		else
			jb.ForInStatement_();
		safeVisit(node.getIterator());
		safeVisit(node.getIteratedObject());
		safeVisit(node.getBody());
		if (isForEach)
			jb._ForEachStatement();
		else
			jb._ForInStatement();
		return false;
	}

	protected boolean visitForLoop(ForLoop node) {
		jb.ForStatement_();
		safeVisit(node.getInitializer());
		safeVisit(node.getCondition());
		safeVisit(node.getIncrement());
		safeVisit(node.getBody());
		jb._ForStatement();
		return false;
	}

	protected boolean visitExpressionStatement(ExpressionStatement node) {
		jb.ExpressionStatement_();
		safeVisit(node.getExpression());
		jb._ExpressionStatement();
		return false;
	}

	protected boolean visitEmptyExpression(EmptyExpression node) {
		int parentType = node.getParent().getType();
		boolean isTopLevel = parentType == Token.SCRIPT || parentType == Token.BLOCK;
		if (isTopLevel)
			jb.ExpressionStatement_();
		jb.EmptyExpression();
		if (isTopLevel)
			jb._ExpressionStatement();
		return false;
	}

	protected boolean visitElementGet(ElementGet node) {
		jb.ComputedMemberExpression_();
		safeVisit(node.getTarget());
		safeVisit(node.getElement());
		jb._ComputedMemberExpression();
		return false;
	}

	protected boolean visitDoLoop(DoLoop node) {
		jb.DoWhileStatement_();
		safeVisit(node.getBody());
		safeVisit(node.getCondition());
		jb._DoWhileStatement();
		return false;
	}

	protected boolean visitContinueStatement(ContinueStatement node) {
		jb.ContinueStatement_();
		safeVisit(node.getLabel());
		jb._ContinueStatement();
		return false;
	}

	protected boolean visitConditionalExpression(ConditionalExpression node) {
		jb.ConditionalExpression_();
		safeVisit(node.getTestExpression());
		safeVisit(node.getTrueExpression());
		safeVisit(node.getFalseExpression());
		jb._ConditionalExpression();
		return false;
	}

	protected boolean visitCatchClause(CatchClause node) {
		jb.CatchClause_();
		safeVisit(node.getVarName());
		safeVisit(node.getCatchCondition());
		safeVisit(node.getBody());
		jb._CatchClause();
		return false;
	}

	protected boolean visitBreakStatement(BreakStatement node) {
		jb.BreakStatement_();
		safeVisit(node.getBreakLabel());
		jb._BreakStatement();
		return false;
	}

	// node can be either a Scope or a Block
	protected boolean visitBlock(AstNode node) {
		jb.Statements_();
		safeVisitStatements(node);
		jb._Statements();
		return false;
	}

	protected boolean visitAssignment(Assignment node) {
		jb.AssignmentExpression_();
		safeVisit(node.getLeft());
		switch (node.getType()) {
		case Token.ASSIGN:
			jb.AssignmentOperator(AssignmentOperatorEnum.assign);
			break;
		case Token.ASSIGN_BITOR:
			jb.AssignmentOperator(AssignmentOperatorEnum.bit_or_assign);
			break;
		case Token.ASSIGN_BITXOR:
			jb.AssignmentOperator(AssignmentOperatorEnum.bit_xor_assign);
			break;
		case Token.ASSIGN_BITAND:
			jb.AssignmentOperator(AssignmentOperatorEnum.bit_and_assign);
			break;
		case Token.ASSIGN_LSH:
			jb.AssignmentOperator(AssignmentOperatorEnum.left_shift_assign);
			break;
		case Token.ASSIGN_RSH:
			jb.AssignmentOperator(AssignmentOperatorEnum.right_shift_signed_assign);
			break;
		case Token.ASSIGN_URSH:
			jb.AssignmentOperator(AssignmentOperatorEnum.right_shift_unsigned_assign);
			break;
		case Token.ASSIGN_ADD:
			jb.AssignmentOperator(AssignmentOperatorEnum.plus_assign);
			break;
		case Token.ASSIGN_SUB:
			jb.AssignmentOperator(AssignmentOperatorEnum.minus_assign);
			break;
		case Token.ASSIGN_MUL:
			jb.AssignmentOperator(AssignmentOperatorEnum.times_assign);
			break;
		case Token.ASSIGN_DIV:
			jb.AssignmentOperator(AssignmentOperatorEnum.divide_assign);
			break;
		case Token.ASSIGN_MOD:
			jb.AssignmentOperator(AssignmentOperatorEnum.remainder_assign);
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		safeVisit(node.getRight());
		jb._AssignmentExpression();
		return false;
	}

	protected boolean visitArrayLiteral(ArrayLiteral node) {
		jb.ArrayLiteral_();
		jb.BooleanData(node.isDestructuring());
		jb.Expressions_();
		safeVisitChildren(node.getElements());
		jb._Expressions();
		jb._ArrayLiteral();
		return false;
	}

	protected boolean visitAstRoot(AstRoot node) {
		if (node.getComments() != null)
			this.comments = new LinkedList<Comment>(node.getComments());

		jb.Program_();
		jb.Statements_();
		safeVisitStatements(node);
		jb._Statements();
		jb._Program();
		return false;
	}

	protected boolean visitComment(Comment node) {
		String value = node.getValue();
		jb.Comment_();
		switch (node.getCommentType()) {
		case LINE:
			value = value.replaceAll("^//", "");
			jb.CommentKind(CommentKindEnum.line);
			break;
		case BLOCK_COMMENT:
			value = value.replaceAll("(^/\\*)|(\\*/$)", "");
			jb.CommentKind(CommentKindEnum.block);
			break;
		case JSDOC:
			value = value.replaceAll("(^/\\*\\*)|(\\*/$)", "");
			jb.CommentKind(CommentKindEnum.jsdoc);
			break;
		case HTML:
			value = value.replaceAll("(^<!--)|(-->$)", "");
			jb.CommentKind(CommentKindEnum.html);
			break;
		default:
			throw new IllegalArgumentException("usupported type");
		}
		jb.StringData(value);
		jb._Comment();
		return false;
	}

	protected boolean visitArrayComprehensionLoop(ArrayComprehensionLoop node) {
		boolean isForEach = node.isForEach();
		if (isForEach)
			jb.ForEachComprehensionBlock_();
		else
			jb.ForInComprehensionBlock_();
		safeVisit(node.getIterator());
		safeVisit(node.getIteratedObject());
		if (isForEach)
			jb._ForEachComprehensionBlock();
		else
			jb._ForInComprehensionBlock();
		return false;
	}

	protected boolean visitArrayComprehension(ArrayComprehension node) {
		jb.ArrayComprehensionExpression_();
		safeVisit(node.getResult());
		jb.ComprehensionBlocks_();
		safeVisitChildren(node.getLoops());
		jb._ComprehensionBlocks();
		safeVisit(node.getFilter());
		jb._ArrayComprehensionExpression();
		return false;
	}
}
