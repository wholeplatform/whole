package org.whole.lang.javascript.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class JavaScriptAdaptersEntityRegistry extends AbstractEntityRegistry {
	public JavaScriptAdaptersEntityRegistry() {
		super(JavaScriptEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ProgramAdapter());
		put(new StatementsAdapter());
		put(new CommentAdapter());
		put(new CommentKindAdapter());
		put(new FunctionBodyAdapter());
		put(new FunctionAdapter());
		put(new DestructuringFormAdapter());
		put(new ObjectLiteralAdapter());
		put(new ObjectPropertiesAdapter());
		put(new ObjectPropertyAdapter());
		put(new LiteralOrIdentifierAdapter());
		put(new ArrayLiteralAdapter());
		put(new StatementAdapter());
		put(new ExpressionAdapter());
		put(new EmptyExpressionAdapter());
		put(new ExpressionStatementAdapter());
		put(new IfStatementAdapter());
		put(new LabeledStatementAdapter());
		put(new LabelsAdapter());
		put(new LabelAdapter());
		put(new TargetingAdapter());
		put(new BreakStatementAdapter());
		put(new ContinueStatementAdapter());
		put(new WithStatementAdapter());
		put(new SwitchStatementAdapter());
		put(new SwitchCasesAdapter());
		put(new SwitchCaseAdapter());
		put(new ReturnStatementAdapter());
		put(new ThrowStatementAdapter());
		put(new TryStatementAdapter());
		put(new CatchClausesAdapter());
		put(new CatchClauseAdapter());
		put(new WhileStatementAdapter());
		put(new DoWhileStatementAdapter());
		put(new VariableDeclarationOrExpressionAdapter());
		put(new ForStatementAdapter());
		put(new ForEachInAdapter());
		put(new ForInStatementAdapter());
		put(new ForEachStatementAdapter());
		put(new LetAdapter());
		put(new LetStatementAdapter());
		put(new VariableInitializersAdapter());
		put(new VariableInitializerAdapter());
		put(new FunctionDeclarationAdapter());
		put(new VariableDeclarationAdapter());
		put(new VariableDeclarationKindAdapter());
		put(new IdentifierOrXmlAnyAdapter());
		put(new XmlAnyAdapter());
		put(new XmlRefAdapter());
		put(new ComputedXmlRefAdapter());
		put(new StaticXmlRefAdapter());
		put(new XmlMemberGetAdapter());
		put(new XmlDotQueryAdapter());
		put(new XmlMemberOperatorAdapter());
		put(new XmlLiteralAdapter());
		put(new XmlFragmentsAdapter());
		put(new XmlFragmentAdapter());
		put(new XmlStringAdapter());
		put(new XmlExpressionAdapter());
		put(new XmlDefaultNamespaceAdapter());
		put(new FunctionExpressionAdapter());
		put(new ExpressionsAdapter());
		put(new ParenthesizedExpressionAdapter());
		put(new UnaryExpressionAdapter());
		put(new PrefixExpressionAdapter());
		put(new PostfixExpressionAdapter());
		put(new PrefixOperatorAdapter());
		put(new PostfixOperatorAdapter());
		put(new BinaryExpressionAdapter());
		put(new InfixExpressionAdapter());
		put(new InfixOperatorAdapter());
		put(new AssignmentExpressionAdapter());
		put(new AssignmentOperatorAdapter());
		put(new ConditionalExpressionAdapter());
		put(new NewExpressionAdapter());
		put(new CallExpressionAdapter());
		put(new MemberExpressionAdapter());
		put(new ComputedMemberExpressionAdapter());
		put(new StaticMemberExpressionAdapter());
		put(new YieldExpressionAdapter());
		put(new ComprehensionExpressionAdapter());
		put(new ArrayComprehensionExpressionAdapter());
		put(new ComprehensionBlocksAdapter());
		put(new ComprehensionBlockAdapter());
		put(new ForInComprehensionBlockAdapter());
		put(new ForEachComprehensionBlockAdapter());
		put(new LetExpressionAdapter());
		put(new IdentifierAdapter());
		put(new LiteralAdapter());
		put(new NullLiteralAdapter());
		put(new ThisLiteralAdapter());
		put(new StringLiteralAdapter());
		put(new BooleanLiteralAdapter());
		put(new NumberLiteralAdapter());
		put(new RegExpLiteralAdapter());
		put(new BooleanDataAdapter());
		put(new StringDataAdapter());
	}
}
