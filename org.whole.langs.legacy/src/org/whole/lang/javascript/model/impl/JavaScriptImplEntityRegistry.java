package org.whole.lang.javascript.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class JavaScriptImplEntityRegistry extends AbstractEntityRegistry {
	public JavaScriptImplEntityRegistry() {
		super(JavaScriptEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ProgramImpl());
		put(new StatementsImpl());
		put(new CommentImpl());
		put(new CommentKindImpl());
		put(new ObjectLiteralImpl());
		put(new ObjectPropertiesImpl());
		put(new ObjectPropertyImpl());
		put(new ArrayLiteralImpl());
		put(new EmptyExpressionImpl());
		put(new ExpressionStatementImpl());
		put(new IfStatementImpl());
		put(new LabeledStatementImpl());
		put(new LabelsImpl());
		put(new LabelImpl());
		put(new BreakStatementImpl());
		put(new ContinueStatementImpl());
		put(new WithStatementImpl());
		put(new SwitchStatementImpl());
		put(new SwitchCasesImpl());
		put(new SwitchCaseImpl());
		put(new ReturnStatementImpl());
		put(new ThrowStatementImpl());
		put(new TryStatementImpl());
		put(new CatchClausesImpl());
		put(new CatchClauseImpl());
		put(new WhileStatementImpl());
		put(new DoWhileStatementImpl());
		put(new ForStatementImpl());
		put(new ForInStatementImpl());
		put(new ForEachStatementImpl());
		put(new LetStatementImpl());
		put(new VariableInitializersImpl());
		put(new VariableInitializerImpl());
		put(new FunctionDeclarationImpl());
		put(new VariableDeclarationImpl());
		put(new VariableDeclarationKindImpl());
		put(new XmlAnyImpl());
		put(new ComputedXmlRefImpl());
		put(new StaticXmlRefImpl());
		put(new XmlMemberGetImpl());
		put(new XmlDotQueryImpl());
		put(new XmlMemberOperatorImpl());
		put(new XmlLiteralImpl());
		put(new XmlFragmentsImpl());
		put(new XmlStringImpl());
		put(new XmlExpressionImpl());
		put(new XmlDefaultNamespaceImpl());
		put(new FunctionExpressionImpl());
		put(new ExpressionsImpl());
		put(new ParenthesizedExpressionImpl());
		put(new PrefixExpressionImpl());
		put(new PostfixExpressionImpl());
		put(new PrefixOperatorImpl());
		put(new PostfixOperatorImpl());
		put(new InfixExpressionImpl());
		put(new InfixOperatorImpl());
		put(new AssignmentExpressionImpl());
		put(new AssignmentOperatorImpl());
		put(new ConditionalExpressionImpl());
		put(new NewExpressionImpl());
		put(new CallExpressionImpl());
		put(new ComputedMemberExpressionImpl());
		put(new StaticMemberExpressionImpl());
		put(new YieldExpressionImpl());
		put(new ArrayComprehensionExpressionImpl());
		put(new ComprehensionBlocksImpl());
		put(new ForInComprehensionBlockImpl());
		put(new ForEachComprehensionBlockImpl());
		put(new LetExpressionImpl());
		put(new IdentifierImpl());
		put(new NullLiteralImpl());
		put(new ThisLiteralImpl());
		put(new StringLiteralImpl());
		put(new BooleanLiteralImpl());
		put(new NumberLiteralImpl());
		put(new RegExpLiteralImpl());
		put(new BooleanDataImpl());
		put(new StringDataImpl());
	}
}
