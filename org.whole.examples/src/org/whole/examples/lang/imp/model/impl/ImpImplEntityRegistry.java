package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ImpImplEntityRegistry extends AbstractEntityRegistry {
	public ImpImplEntityRegistry() {
		super(ImpEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new FunctionDeclarationImpl());
		put(new ParametersImpl());
		put(new ParameterImpl());
		put(new VariableDeclarationImpl());
		put(new EmptyStatementImpl());
		put(new ReturnStatementImpl());
		put(new IfStatementImpl());
		put(new IfElseStatementImpl());
		put(new WhileStatementImpl());
		put(new DoWhileStatementImpl());
		put(new ForStatementImpl());
		put(new ForeachStatementImpl());
		put(new BlockStatementImpl());
		put(new PrintStatementImpl());
		put(new PrintlnStatementImpl());
		put(new SaveStatementImpl());
		put(new ExpressionStatementImpl());
		put(new LoadExpressionImpl());
		put(new FunctionInvocationExpressionImpl());
		put(new ArgumentsImpl());
		put(new AssignmentExpressionImpl());
		put(new RunExpressionImpl());
		put(new SizeExpressionImpl());
		put(new BooleanLiteralImpl());
		put(new IntLiteralImpl());
		put(new StringLiteralImpl());
		put(new RangeLiteralImpl());
		put(new ArrayLiteralImpl());
		put(new NameImpl());
		put(new NameExpressionImpl());
		put(new PrimitiveTypeImpl());
		put(new ArrayTypeImpl());
		put(new ArrayAccessImpl());
		put(new AdditionImpl());
		put(new SubtractionImpl());
		put(new MultiplicationImpl());
		put(new DivisionImpl());
		put(new RemainderImpl());
		put(new AndImpl());
		put(new OrImpl());
		put(new NotImpl());
		put(new EqualsImpl());
		put(new NotEqualsImpl());
		put(new LessThanImpl());
		put(new LessOrEqualsImpl());
		put(new GreaterThanImpl());
		put(new GreaterOrEqualsImpl());
	}
}
