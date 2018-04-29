package org.whole.examples.lang.imp.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ImpEntityFactory extends GenericEntityFactory {
	public static final ImpEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static ImpEntityFactory instance(IEntityRegistryProvider provider) {
		return new ImpEntityFactory(provider);
	}

	protected ImpEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public FunctionDeclaration createFunctionDeclaration() {
		return create(ImpEntityDescriptorEnum.FunctionDeclaration);
	}

	public FunctionDeclaration createFunctionDeclaration(Type type, Name name, Parameters parameters, Statement body) {
		return create(ImpEntityDescriptorEnum.FunctionDeclaration, type, name, parameters, body);
	}

	public IEntityBuilder<FunctionDeclaration> buildFunctionDeclaration() {
		return new EntityBuilder<FunctionDeclaration>(create(ImpEntityDescriptorEnum.FunctionDeclaration));
	}

	public Parameters createParameters() {
		return create(ImpEntityDescriptorEnum.Parameters);
	}

	public Parameters createParameters(Parameter... entities) {
		return create(ImpEntityDescriptorEnum.Parameters, (IEntity[]) entities);
	}

	public Parameters createParameters(int initialSize) {
		return clone(ImpEntityDescriptorEnum.Parameters, initialSize);
	}

	public Parameter createParameter() {
		return create(ImpEntityDescriptorEnum.Parameter);
	}

	public Parameter createParameter(Type type, Name name) {
		return create(ImpEntityDescriptorEnum.Parameter, type, name);
	}

	public IEntityBuilder<Parameter> buildParameter() {
		return new EntityBuilder<Parameter>(create(ImpEntityDescriptorEnum.Parameter));
	}

	public VariableDeclaration createVariableDeclaration() {
		return create(ImpEntityDescriptorEnum.VariableDeclaration);
	}

	public VariableDeclaration createVariableDeclaration(Type type, Name name, Expression initializer) {
		return create(ImpEntityDescriptorEnum.VariableDeclaration, type, name, initializer);
	}

	public IEntityBuilder<VariableDeclaration> buildVariableDeclaration() {
		return new EntityBuilder<VariableDeclaration>(create(ImpEntityDescriptorEnum.VariableDeclaration));
	}

	public EmptyStatement createEmptyStatement() {
		return create(ImpEntityDescriptorEnum.EmptyStatement);
	}

	public ReturnStatement createReturnStatement() {
		return create(ImpEntityDescriptorEnum.ReturnStatement);
	}

	public ReturnStatement createReturnStatement(Expression exp) {
		return create(ImpEntityDescriptorEnum.ReturnStatement, exp);
	}

	public IfStatement createIfStatement() {
		return create(ImpEntityDescriptorEnum.IfStatement);
	}

	public IfStatement createIfStatement(Expression condition, Statement trueBody) {
		return create(ImpEntityDescriptorEnum.IfStatement, condition, trueBody);
	}

	public IEntityBuilder<IfStatement> buildIfStatement() {
		return new EntityBuilder<IfStatement>(create(ImpEntityDescriptorEnum.IfStatement));
	}

	public IfElseStatement createIfElseStatement() {
		return create(ImpEntityDescriptorEnum.IfElseStatement);
	}

	public IfElseStatement createIfElseStatement(Expression condition, Statement trueBody, Statement falseBody) {
		return create(ImpEntityDescriptorEnum.IfElseStatement, condition, trueBody, falseBody);
	}

	public IEntityBuilder<IfElseStatement> buildIfElseStatement() {
		return new EntityBuilder<IfElseStatement>(create(ImpEntityDescriptorEnum.IfElseStatement));
	}

	public WhileStatement createWhileStatement() {
		return create(ImpEntityDescriptorEnum.WhileStatement);
	}

	public WhileStatement createWhileStatement(Expression condition, Statement trueBody) {
		return create(ImpEntityDescriptorEnum.WhileStatement, condition, trueBody);
	}

	public IEntityBuilder<WhileStatement> buildWhileStatement() {
		return new EntityBuilder<WhileStatement>(create(ImpEntityDescriptorEnum.WhileStatement));
	}

	public DoWhileStatement createDoWhileStatement() {
		return create(ImpEntityDescriptorEnum.DoWhileStatement);
	}

	public DoWhileStatement createDoWhileStatement(Statement trueBody, Expression condition) {
		return create(ImpEntityDescriptorEnum.DoWhileStatement, trueBody, condition);
	}

	public IEntityBuilder<DoWhileStatement> buildDoWhileStatement() {
		return new EntityBuilder<DoWhileStatement>(create(ImpEntityDescriptorEnum.DoWhileStatement));
	}

	public ForStatement createForStatement() {
		return create(ImpEntityDescriptorEnum.ForStatement);
	}

	public ForStatement createForStatement(VariableDeclaration initializer, Expression condition, Expression updater,
			Statement trueBody) {
		return create(ImpEntityDescriptorEnum.ForStatement, initializer, condition, updater, trueBody);
	}

	public IEntityBuilder<ForStatement> buildForStatement() {
		return new EntityBuilder<ForStatement>(create(ImpEntityDescriptorEnum.ForStatement));
	}

	public ForeachStatement createForeachStatement() {
		return create(ImpEntityDescriptorEnum.ForeachStatement);
	}

	public ForeachStatement createForeachStatement(Name name, Expression arrayExp, Statement trueBody) {
		return create(ImpEntityDescriptorEnum.ForeachStatement, name, arrayExp, trueBody);
	}

	public IEntityBuilder<ForeachStatement> buildForeachStatement() {
		return new EntityBuilder<ForeachStatement>(create(ImpEntityDescriptorEnum.ForeachStatement));
	}

	public BlockStatement createBlockStatement() {
		return create(ImpEntityDescriptorEnum.BlockStatement);
	}

	public BlockStatement createBlockStatement(Statement... entities) {
		return create(ImpEntityDescriptorEnum.BlockStatement, (IEntity[]) entities);
	}

	public BlockStatement createBlockStatement(int initialSize) {
		return clone(ImpEntityDescriptorEnum.BlockStatement, initialSize);
	}

	public PrintStatement createPrintStatement() {
		return create(ImpEntityDescriptorEnum.PrintStatement);
	}

	public PrintStatement createPrintStatement(Expression exp) {
		return create(ImpEntityDescriptorEnum.PrintStatement, exp);
	}

	public PrintlnStatement createPrintlnStatement() {
		return create(ImpEntityDescriptorEnum.PrintlnStatement);
	}

	public PrintlnStatement createPrintlnStatement(Expression exp) {
		return create(ImpEntityDescriptorEnum.PrintlnStatement, exp);
	}

	public SaveStatement createSaveStatement() {
		return create(ImpEntityDescriptorEnum.SaveStatement);
	}

	public SaveStatement createSaveStatement(Expression exp, Expression fileName) {
		return create(ImpEntityDescriptorEnum.SaveStatement, exp, fileName);
	}

	public IEntityBuilder<SaveStatement> buildSaveStatement() {
		return new EntityBuilder<SaveStatement>(create(ImpEntityDescriptorEnum.SaveStatement));
	}

	public ExpressionStatement createExpressionStatement() {
		return create(ImpEntityDescriptorEnum.ExpressionStatement);
	}

	public ExpressionStatement createExpressionStatement(Expression exp) {
		return create(ImpEntityDescriptorEnum.ExpressionStatement, exp);
	}

	public LoadExpression createLoadExpression() {
		return create(ImpEntityDescriptorEnum.LoadExpression);
	}

	public LoadExpression createLoadExpression(Expression fileName, Expression language) {
		return create(ImpEntityDescriptorEnum.LoadExpression, fileName, language);
	}

	public IEntityBuilder<LoadExpression> buildLoadExpression() {
		return new EntityBuilder<LoadExpression>(create(ImpEntityDescriptorEnum.LoadExpression));
	}

	public FunctionInvocationExpression createFunctionInvocationExpression() {
		return create(ImpEntityDescriptorEnum.FunctionInvocationExpression);
	}

	public FunctionInvocationExpression createFunctionInvocationExpression(NameExpression name, Arguments arguments) {
		return create(ImpEntityDescriptorEnum.FunctionInvocationExpression, name, arguments);
	}

	public IEntityBuilder<FunctionInvocationExpression> buildFunctionInvocationExpression() {
		return new EntityBuilder<FunctionInvocationExpression>(
				create(ImpEntityDescriptorEnum.FunctionInvocationExpression));
	}

	public Arguments createArguments() {
		return create(ImpEntityDescriptorEnum.Arguments);
	}

	public Arguments createArguments(Expression... entities) {
		return create(ImpEntityDescriptorEnum.Arguments, (IEntity[]) entities);
	}

	public Arguments createArguments(int initialSize) {
		return clone(ImpEntityDescriptorEnum.Arguments, initialSize);
	}

	public AssignmentExpression createAssignmentExpression() {
		return create(ImpEntityDescriptorEnum.AssignmentExpression);
	}

	public AssignmentExpression createAssignmentExpression(Name name, Expression exp) {
		return create(ImpEntityDescriptorEnum.AssignmentExpression, name, exp);
	}

	public IEntityBuilder<AssignmentExpression> buildAssignmentExpression() {
		return new EntityBuilder<AssignmentExpression>(create(ImpEntityDescriptorEnum.AssignmentExpression));
	}

	public RunExpression createRunExpression() {
		return create(ImpEntityDescriptorEnum.RunExpression);
	}

	public RunExpression createRunExpression(Expression exp) {
		return create(ImpEntityDescriptorEnum.RunExpression, exp);
	}

	public SizeExpression createSizeExpression() {
		return create(ImpEntityDescriptorEnum.SizeExpression);
	}

	public SizeExpression createSizeExpression(Expression exp) {
		return create(ImpEntityDescriptorEnum.SizeExpression, exp);
	}

	public BooleanLiteral createBooleanLiteral() {
		return create(ImpEntityDescriptorEnum.BooleanLiteral);
	}

	public BooleanLiteral createBooleanLiteral(boolean value) {
		return create(ImpEntityDescriptorEnum.BooleanLiteral, value);
	}

	public IntLiteral createIntLiteral() {
		return create(ImpEntityDescriptorEnum.IntLiteral);
	}

	public IntLiteral createIntLiteral(int value) {
		return create(ImpEntityDescriptorEnum.IntLiteral, value);
	}

	public StringLiteral createStringLiteral() {
		return create(ImpEntityDescriptorEnum.StringLiteral);
	}

	public StringLiteral createStringLiteral(String value) {
		return create(ImpEntityDescriptorEnum.StringLiteral, value);
	}

	public RangeLiteral createRangeLiteral() {
		return create(ImpEntityDescriptorEnum.RangeLiteral);
	}

	public RangeLiteral createRangeLiteral(IntLiteral lowerBound, IntLiteral upperBound) {
		return create(ImpEntityDescriptorEnum.RangeLiteral, lowerBound, upperBound);
	}

	public IEntityBuilder<RangeLiteral> buildRangeLiteral() {
		return new EntityBuilder<RangeLiteral>(create(ImpEntityDescriptorEnum.RangeLiteral));
	}

	public ArrayLiteral createArrayLiteral() {
		return create(ImpEntityDescriptorEnum.ArrayLiteral);
	}

	public ArrayLiteral createArrayLiteral(Literal... entities) {
		return create(ImpEntityDescriptorEnum.ArrayLiteral, (IEntity[]) entities);
	}

	public ArrayLiteral createArrayLiteral(int initialSize) {
		return clone(ImpEntityDescriptorEnum.ArrayLiteral, initialSize);
	}

	public Name createName() {
		return create(ImpEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(ImpEntityDescriptorEnum.Name, value);
	}

	public NameExpression createNameExpression() {
		return create(ImpEntityDescriptorEnum.NameExpression);
	}

	public NameExpression createNameExpression(String value) {
		return create(ImpEntityDescriptorEnum.NameExpression, value);
	}

	public PrimitiveType createPrimitiveType() {
		return create(ImpEntityDescriptorEnum.PrimitiveType);
	}

	public PrimitiveType createPrimitiveType(PrimitiveTypeEnum.Value value) {
		return create(ImpEntityDescriptorEnum.PrimitiveType, value);
	}

	public ArrayType createArrayType() {
		return create(ImpEntityDescriptorEnum.ArrayType);
	}

	public ArrayType createArrayType(Type contentType, PrimitiveType indexType) {
		return create(ImpEntityDescriptorEnum.ArrayType, contentType, indexType);
	}

	public IEntityBuilder<ArrayType> buildArrayType() {
		return new EntityBuilder<ArrayType>(create(ImpEntityDescriptorEnum.ArrayType));
	}

	public ArrayAccess createArrayAccess() {
		return create(ImpEntityDescriptorEnum.ArrayAccess);
	}

	public ArrayAccess createArrayAccess(Expression array, Expression index) {
		return create(ImpEntityDescriptorEnum.ArrayAccess, array, index);
	}

	public IEntityBuilder<ArrayAccess> buildArrayAccess() {
		return new EntityBuilder<ArrayAccess>(create(ImpEntityDescriptorEnum.ArrayAccess));
	}

	public Addition createAddition() {
		return create(ImpEntityDescriptorEnum.Addition);
	}

	public Addition createAddition(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Addition, exp1, exp2);
	}

	public IEntityBuilder<Addition> buildAddition() {
		return new EntityBuilder<Addition>(create(ImpEntityDescriptorEnum.Addition));
	}

	public Subtraction createSubtraction() {
		return create(ImpEntityDescriptorEnum.Subtraction);
	}

	public Subtraction createSubtraction(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Subtraction, exp1, exp2);
	}

	public IEntityBuilder<Subtraction> buildSubtraction() {
		return new EntityBuilder<Subtraction>(create(ImpEntityDescriptorEnum.Subtraction));
	}

	public Multiplication createMultiplication() {
		return create(ImpEntityDescriptorEnum.Multiplication);
	}

	public Multiplication createMultiplication(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Multiplication, exp1, exp2);
	}

	public IEntityBuilder<Multiplication> buildMultiplication() {
		return new EntityBuilder<Multiplication>(create(ImpEntityDescriptorEnum.Multiplication));
	}

	public Division createDivision() {
		return create(ImpEntityDescriptorEnum.Division);
	}

	public Division createDivision(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Division, exp1, exp2);
	}

	public IEntityBuilder<Division> buildDivision() {
		return new EntityBuilder<Division>(create(ImpEntityDescriptorEnum.Division));
	}

	public Remainder createRemainder() {
		return create(ImpEntityDescriptorEnum.Remainder);
	}

	public Remainder createRemainder(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Remainder, exp1, exp2);
	}

	public IEntityBuilder<Remainder> buildRemainder() {
		return new EntityBuilder<Remainder>(create(ImpEntityDescriptorEnum.Remainder));
	}

	public And createAnd() {
		return create(ImpEntityDescriptorEnum.And);
	}

	public And createAnd(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.And, exp1, exp2);
	}

	public IEntityBuilder<And> buildAnd() {
		return new EntityBuilder<And>(create(ImpEntityDescriptorEnum.And));
	}

	public Or createOr() {
		return create(ImpEntityDescriptorEnum.Or);
	}

	public Or createOr(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Or, exp1, exp2);
	}

	public IEntityBuilder<Or> buildOr() {
		return new EntityBuilder<Or>(create(ImpEntityDescriptorEnum.Or));
	}

	public Not createNot() {
		return create(ImpEntityDescriptorEnum.Not);
	}

	public Not createNot(Expression exp) {
		return create(ImpEntityDescriptorEnum.Not, exp);
	}

	public Equals createEquals() {
		return create(ImpEntityDescriptorEnum.Equals);
	}

	public Equals createEquals(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.Equals, exp1, exp2);
	}

	public IEntityBuilder<Equals> buildEquals() {
		return new EntityBuilder<Equals>(create(ImpEntityDescriptorEnum.Equals));
	}

	public NotEquals createNotEquals() {
		return create(ImpEntityDescriptorEnum.NotEquals);
	}

	public NotEquals createNotEquals(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.NotEquals, exp1, exp2);
	}

	public IEntityBuilder<NotEquals> buildNotEquals() {
		return new EntityBuilder<NotEquals>(create(ImpEntityDescriptorEnum.NotEquals));
	}

	public LessThan createLessThan() {
		return create(ImpEntityDescriptorEnum.LessThan);
	}

	public LessThan createLessThan(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.LessThan, exp1, exp2);
	}

	public IEntityBuilder<LessThan> buildLessThan() {
		return new EntityBuilder<LessThan>(create(ImpEntityDescriptorEnum.LessThan));
	}

	public LessOrEquals createLessOrEquals() {
		return create(ImpEntityDescriptorEnum.LessOrEquals);
	}

	public LessOrEquals createLessOrEquals(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.LessOrEquals, exp1, exp2);
	}

	public IEntityBuilder<LessOrEquals> buildLessOrEquals() {
		return new EntityBuilder<LessOrEquals>(create(ImpEntityDescriptorEnum.LessOrEquals));
	}

	public GreaterThan createGreaterThan() {
		return create(ImpEntityDescriptorEnum.GreaterThan);
	}

	public GreaterThan createGreaterThan(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.GreaterThan, exp1, exp2);
	}

	public IEntityBuilder<GreaterThan> buildGreaterThan() {
		return new EntityBuilder<GreaterThan>(create(ImpEntityDescriptorEnum.GreaterThan));
	}

	public GreaterOrEquals createGreaterOrEquals() {
		return create(ImpEntityDescriptorEnum.GreaterOrEquals);
	}

	public GreaterOrEquals createGreaterOrEquals(Expression exp1, Expression exp2) {
		return create(ImpEntityDescriptorEnum.GreaterOrEquals, exp1, exp2);
	}

	public IEntityBuilder<GreaterOrEquals> buildGreaterOrEquals() {
		return new EntityBuilder<GreaterOrEquals>(create(ImpEntityDescriptorEnum.GreaterOrEquals));
	}
}
