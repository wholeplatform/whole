package org.whole.lang.javascript.visitors;

import org.whole.lang.javascript.visitors.JavaScriptIdentityUnaryVisitor;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class JavaScriptTraverseAllChildrenVisitor extends
		JavaScriptIdentityUnaryVisitor<IJavaScriptVisitor> {
	public JavaScriptTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public JavaScriptTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Program entity) {
		entity.getStatements().accept(wGetVisitor1());
	}

	public void visit(Statements entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Comment entity) {
		entity.getKind().accept(wGetVisitor1());
		entity.getContents().accept(wGetVisitor1());
	}

	public void visit(Function entity) {
		entity.getId().accept(wGetVisitor1());
		entity.getParams().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(DestructuringForm entity) {
		entity.getDestructuring().accept(wGetVisitor1());
	}

	public void visit(ObjectLiteral entity) {
		entity.getDestructuring().accept(wGetVisitor1());
		entity.getProperties().accept(wGetVisitor1());
	}

	public void visit(ObjectProperties entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ObjectProperty entity) {
		entity.getKey().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}

	public void visit(ArrayLiteral entity) {
		entity.getDestructuring().accept(wGetVisitor1());
		entity.getElements().accept(wGetVisitor1());
	}

	public void visit(ExpressionStatement entity) {
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(IfStatement entity) {
		entity.getTest().accept(wGetVisitor1());
		entity.getConsequent().accept(wGetVisitor1());
		entity.getAlternate().accept(wGetVisitor1());
	}

	public void visit(LabeledStatement entity) {
		entity.getLabels().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(Labels entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Label entity) {
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Targeting entity) {
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(BreakStatement entity) {
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(ContinueStatement entity) {
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(WithStatement entity) {
		entity.getObject().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(SwitchStatement entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getCases().accept(wGetVisitor1());
	}

	public void visit(SwitchCases entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SwitchCase entity) {
		entity.getTest().accept(wGetVisitor1());
		entity.getStatements().accept(wGetVisitor1());
	}

	public void visit(ReturnStatement entity) {
		entity.getArgument().accept(wGetVisitor1());
	}

	public void visit(ThrowStatement entity) {
		entity.getArgument().accept(wGetVisitor1());
	}

	public void visit(TryStatement entity) {
		entity.getTry().accept(wGetVisitor1());
		entity.getHandlers().accept(wGetVisitor1());
		entity.getFinally().accept(wGetVisitor1());
	}

	public void visit(CatchClauses entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(CatchClause entity) {
		entity.getParam().accept(wGetVisitor1());
		entity.getGuard().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(WhileStatement entity) {
		entity.getTest().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(DoWhileStatement entity) {
		entity.getBody().accept(wGetVisitor1());
		entity.getTest().accept(wGetVisitor1());
	}

	public void visit(ForStatement entity) {
		entity.getInit().accept(wGetVisitor1());
		entity.getTest().accept(wGetVisitor1());
		entity.getUpdate().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(ForEachIn entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getIterated().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(ForInStatement entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getIterated().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(ForEachStatement entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getIterated().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(Let entity) {
		entity.getVariables().accept(wGetVisitor1());
	}

	public void visit(LetStatement entity) {
		entity.getVariables().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(VariableInitializers entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(VariableInitializer entity) {
		entity.getId().accept(wGetVisitor1());
		entity.getInit().accept(wGetVisitor1());
	}

	public void visit(FunctionDeclaration entity) {
		entity.getId().accept(wGetVisitor1());
		entity.getParams().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(VariableDeclaration entity) {
		entity.getKind().accept(wGetVisitor1());
		entity.getVariables().accept(wGetVisitor1());
	}

	public void visit(XmlRef entity) {
		entity.getAttribute().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
	}

	public void visit(ComputedXmlRef entity) {
		entity.getAttribute().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(StaticXmlRef entity) {
		entity.getAttribute().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getProperty().accept(wGetVisitor1());
	}

	public void visit(XmlMemberGet entity) {
		entity.getLeft().accept(wGetVisitor1());
		entity.getOperator().accept(wGetVisitor1());
		entity.getRight().accept(wGetVisitor1());
	}

	public void visit(XmlDotQuery entity) {
		entity.getLeft().accept(wGetVisitor1());
		entity.getRight().accept(wGetVisitor1());
	}

	public void visit(XmlLiteral entity) {
		entity.getFragments().accept(wGetVisitor1());
	}

	public void visit(XmlFragments entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(XmlString entity) {
		entity.getXml().accept(wGetVisitor1());
	}

	public void visit(XmlExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(XmlDefaultNamespace entity) {
		entity.getOperand().accept(wGetVisitor1());
	}

	public void visit(FunctionExpression entity) {
		entity.getId().accept(wGetVisitor1());
		entity.getParams().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(Expressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ParenthesizedExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(UnaryExpression entity) {
		entity.getOperand().accept(wGetVisitor1());
	}

	public void visit(PrefixExpression entity) {
		entity.getOperator().accept(wGetVisitor1());
		entity.getOperand().accept(wGetVisitor1());
	}

	public void visit(PostfixExpression entity) {
		entity.getOperand().accept(wGetVisitor1());
		entity.getOperator().accept(wGetVisitor1());
	}

	public void visit(BinaryExpression entity) {
		entity.getLeft().accept(wGetVisitor1());
		entity.getRight().accept(wGetVisitor1());
	}

	public void visit(InfixExpression entity) {
		entity.getLeft().accept(wGetVisitor1());
		entity.getOperator().accept(wGetVisitor1());
		entity.getRight().accept(wGetVisitor1());
	}

	public void visit(AssignmentExpression entity) {
		entity.getLeft().accept(wGetVisitor1());
		entity.getOperator().accept(wGetVisitor1());
		entity.getRight().accept(wGetVisitor1());
	}

	public void visit(ConditionalExpression entity) {
		entity.getTest().accept(wGetVisitor1());
		entity.getConsequent().accept(wGetVisitor1());
		entity.getAlternate().accept(wGetVisitor1());
	}

	public void visit(NewExpression entity) {
		entity.getConstructor().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(CallExpression entity) {
		entity.getCallee().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(MemberExpression entity) {
		entity.getObject().accept(wGetVisitor1());
	}

	public void visit(ComputedMemberExpression entity) {
		entity.getObject().accept(wGetVisitor1());
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(StaticMemberExpression entity) {
		entity.getObject().accept(wGetVisitor1());
		entity.getProperty().accept(wGetVisitor1());
	}

	public void visit(YieldExpression entity) {
		entity.getArgument().accept(wGetVisitor1());
	}

	public void visit(ComprehensionExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getBlocks().accept(wGetVisitor1());
		entity.getFilter().accept(wGetVisitor1());
	}

	public void visit(ArrayComprehensionExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getBlocks().accept(wGetVisitor1());
		entity.getFilter().accept(wGetVisitor1());
	}

	public void visit(ComprehensionBlocks entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ComprehensionBlock entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getIterated().accept(wGetVisitor1());
	}

	public void visit(ForInComprehensionBlock entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getIterated().accept(wGetVisitor1());
	}

	public void visit(ForEachComprehensionBlock entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getIterated().accept(wGetVisitor1());
	}

	public void visit(LetExpression entity) {
		entity.getVariables().accept(wGetVisitor1());
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(StringLiteral entity) {
		entity.getValue().accept(wGetVisitor1());
		entity.getQuote().accept(wGetVisitor1());
	}

	public void visit(RegExpLiteral entity) {
		entity.getValue().accept(wGetVisitor1());
		entity.getFlags().accept(wGetVisitor1());
	}
}
