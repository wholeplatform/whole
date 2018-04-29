package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ImpAdaptersEntityRegistry extends AbstractEntityRegistry {
	public ImpAdaptersEntityRegistry() {
		super(ImpEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new FunctionDeclarationAdapter());
		put(new ParametersAdapter());
		put(new ParameterAdapter());
		put(new VariableDeclarationAdapter());
		put(new DeclarationAdapter());
		put(new EmptyStatementAdapter());
		put(new ReturnStatementAdapter());
		put(new IfStatementAdapter());
		put(new IfElseStatementAdapter());
		put(new WhileStatementAdapter());
		put(new DoWhileStatementAdapter());
		put(new ForStatementAdapter());
		put(new ForeachStatementAdapter());
		put(new BlockStatementAdapter());
		put(new PrintStatementAdapter());
		put(new PrintlnStatementAdapter());
		put(new SaveStatementAdapter());
		put(new ExpressionStatementAdapter());
		put(new LoadExpressionAdapter());
		put(new FunctionInvocationExpressionAdapter());
		put(new ArgumentsAdapter());
		put(new AssignmentExpressionAdapter());
		put(new RunExpressionAdapter());
		put(new SizeExpressionAdapter());
		put(new LiteralAdapter());
		put(new BooleanLiteralAdapter());
		put(new IntLiteralAdapter());
		put(new StringLiteralAdapter());
		put(new RangeLiteralAdapter());
		put(new ArrayLiteralAdapter());
		put(new NameAdapter());
		put(new NameExpressionAdapter());
		put(new PrimitiveTypeAdapter());
		put(new ArrayTypeAdapter());
		put(new ArrayAccessAdapter());
		put(new AdditionAdapter());
		put(new SubtractionAdapter());
		put(new MultiplicationAdapter());
		put(new DivisionAdapter());
		put(new RemainderAdapter());
		put(new AndAdapter());
		put(new OrAdapter());
		put(new NotAdapter());
		put(new EqualsAdapter());
		put(new NotEqualsAdapter());
		put(new LessThanAdapter());
		put(new LessOrEqualsAdapter());
		put(new GreaterThanAdapter());
		put(new GreaterOrEqualsAdapter());
		put(new StatementAdapter());
		put(new TypeAdapter());
		put(new ExpressionAdapter());
	}
}
