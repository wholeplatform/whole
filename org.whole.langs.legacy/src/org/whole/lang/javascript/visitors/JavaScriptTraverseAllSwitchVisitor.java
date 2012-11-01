package org.whole.lang.javascript.visitors;

import org.whole.lang.javascript.visitors.JavaScriptIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.javascript.model.*;

/** 
 * @generator Whole
 */
public class JavaScriptTraverseAllSwitchVisitor extends
		JavaScriptIdentityUnaryVisitor<IVisitor> {
	public JavaScriptTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Program entity) {
		wGetVisitor1().visit(entity.getStatements());
	}

	public void visit(Statements entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Comment entity) {
		wGetVisitor1().visit(entity.getKind());
		wGetVisitor1().visit(entity.getContents());
	}

	public void visit(Function entity) {
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getParams());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(DestructuringForm entity) {
		wGetVisitor1().visit(entity.getDestructuring());
	}

	public void visit(ObjectLiteral entity) {
		wGetVisitor1().visit(entity.getDestructuring());
		wGetVisitor1().visit(entity.getProperties());
	}

	public void visit(ObjectProperties entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ObjectProperty entity) {
		wGetVisitor1().visit(entity.getKey());
		wGetVisitor1().visit(entity.getValue());
	}

	public void visit(ArrayLiteral entity) {
		wGetVisitor1().visit(entity.getDestructuring());
		wGetVisitor1().visit(entity.getElements());
	}

	public void visit(ExpressionStatement entity) {
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(IfStatement entity) {
		wGetVisitor1().visit(entity.getTest());
		wGetVisitor1().visit(entity.getConsequent());
		wGetVisitor1().visit(entity.getAlternate());
	}

	public void visit(LabeledStatement entity) {
		wGetVisitor1().visit(entity.getLabels());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(Labels entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Label entity) {
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Targeting entity) {
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(BreakStatement entity) {
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(ContinueStatement entity) {
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(WithStatement entity) {
		wGetVisitor1().visit(entity.getObject());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(SwitchStatement entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getCases());
	}

	public void visit(SwitchCases entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SwitchCase entity) {
		wGetVisitor1().visit(entity.getTest());
		wGetVisitor1().visit(entity.getStatements());
	}

	public void visit(ReturnStatement entity) {
		wGetVisitor1().visit(entity.getArgument());
	}

	public void visit(ThrowStatement entity) {
		wGetVisitor1().visit(entity.getArgument());
	}

	public void visit(TryStatement entity) {
		wGetVisitor1().visit(entity.getTry());
		wGetVisitor1().visit(entity.getHandlers());
		wGetVisitor1().visit(entity.getFinally());
	}

	public void visit(CatchClauses entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(CatchClause entity) {
		wGetVisitor1().visit(entity.getParam());
		wGetVisitor1().visit(entity.getGuard());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(WhileStatement entity) {
		wGetVisitor1().visit(entity.getTest());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(DoWhileStatement entity) {
		wGetVisitor1().visit(entity.getBody());
		wGetVisitor1().visit(entity.getTest());
	}

	public void visit(ForStatement entity) {
		wGetVisitor1().visit(entity.getInit());
		wGetVisitor1().visit(entity.getTest());
		wGetVisitor1().visit(entity.getUpdate());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(ForEachIn entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getIterated());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(ForInStatement entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getIterated());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(ForEachStatement entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getIterated());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(Let entity) {
		wGetVisitor1().visit(entity.getVariables());
	}

	public void visit(LetStatement entity) {
		wGetVisitor1().visit(entity.getVariables());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(VariableInitializers entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(VariableInitializer entity) {
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getInit());
	}

	public void visit(FunctionDeclaration entity) {
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getParams());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(VariableDeclaration entity) {
		wGetVisitor1().visit(entity.getKind());
		wGetVisitor1().visit(entity.getVariables());
	}

	public void visit(XmlRef entity) {
		wGetVisitor1().visit(entity.getAttribute());
		wGetVisitor1().visit(entity.getNamespace());
	}

	public void visit(ComputedXmlRef entity) {
		wGetVisitor1().visit(entity.getAttribute());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(StaticXmlRef entity) {
		wGetVisitor1().visit(entity.getAttribute());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getProperty());
	}

	public void visit(XmlMemberGet entity) {
		wGetVisitor1().visit(entity.getLeft());
		wGetVisitor1().visit(entity.getOperator());
		wGetVisitor1().visit(entity.getRight());
	}

	public void visit(XmlDotQuery entity) {
		wGetVisitor1().visit(entity.getLeft());
		wGetVisitor1().visit(entity.getRight());
	}

	public void visit(XmlLiteral entity) {
		wGetVisitor1().visit(entity.getFragments());
	}

	public void visit(XmlFragments entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(XmlString entity) {
		wGetVisitor1().visit(entity.getXml());
	}

	public void visit(XmlExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(XmlDefaultNamespace entity) {
		wGetVisitor1().visit(entity.getOperand());
	}

	public void visit(FunctionExpression entity) {
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getParams());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(Expressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ParenthesizedExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(UnaryExpression entity) {
		wGetVisitor1().visit(entity.getOperand());
	}

	public void visit(PrefixExpression entity) {
		wGetVisitor1().visit(entity.getOperator());
		wGetVisitor1().visit(entity.getOperand());
	}

	public void visit(PostfixExpression entity) {
		wGetVisitor1().visit(entity.getOperand());
		wGetVisitor1().visit(entity.getOperator());
	}

	public void visit(BinaryExpression entity) {
		wGetVisitor1().visit(entity.getLeft());
		wGetVisitor1().visit(entity.getRight());
	}

	public void visit(InfixExpression entity) {
		wGetVisitor1().visit(entity.getLeft());
		wGetVisitor1().visit(entity.getOperator());
		wGetVisitor1().visit(entity.getRight());
	}

	public void visit(AssignmentExpression entity) {
		wGetVisitor1().visit(entity.getLeft());
		wGetVisitor1().visit(entity.getOperator());
		wGetVisitor1().visit(entity.getRight());
	}

	public void visit(ConditionalExpression entity) {
		wGetVisitor1().visit(entity.getTest());
		wGetVisitor1().visit(entity.getConsequent());
		wGetVisitor1().visit(entity.getAlternate());
	}

	public void visit(NewExpression entity) {
		wGetVisitor1().visit(entity.getConstructor());
		wGetVisitor1().visit(entity.getArguments());
	}

	public void visit(CallExpression entity) {
		wGetVisitor1().visit(entity.getCallee());
		wGetVisitor1().visit(entity.getArguments());
	}

	public void visit(MemberExpression entity) {
		wGetVisitor1().visit(entity.getObject());
	}

	public void visit(ComputedMemberExpression entity) {
		wGetVisitor1().visit(entity.getObject());
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(StaticMemberExpression entity) {
		wGetVisitor1().visit(entity.getObject());
		wGetVisitor1().visit(entity.getProperty());
	}

	public void visit(YieldExpression entity) {
		wGetVisitor1().visit(entity.getArgument());
	}

	public void visit(ComprehensionExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getBlocks());
		wGetVisitor1().visit(entity.getFilter());
	}

	public void visit(ArrayComprehensionExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getBlocks());
		wGetVisitor1().visit(entity.getFilter());
	}

	public void visit(ComprehensionBlocks entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ComprehensionBlock entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getIterated());
	}

	public void visit(ForInComprehensionBlock entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getIterated());
	}

	public void visit(ForEachComprehensionBlock entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getIterated());
	}

	public void visit(LetExpression entity) {
		wGetVisitor1().visit(entity.getVariables());
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(StringLiteral entity) {
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getQuote());
	}

	public void visit(RegExpLiteral entity) {
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getFlags());
	}
}
