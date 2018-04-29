package org.whole.examples.lang.imp.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class ImpEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int FunctionDeclaration_ord = 0;
	public static final int Parameters_ord = 1;
	public static final int Parameter_ord = 2;
	public static final int VariableDeclaration_ord = 3;
	public static final int Declaration_ord = 4;
	public static final int EmptyStatement_ord = 5;
	public static final int ReturnStatement_ord = 6;
	public static final int IfStatement_ord = 7;
	public static final int IfElseStatement_ord = 8;
	public static final int WhileStatement_ord = 9;
	public static final int DoWhileStatement_ord = 10;
	public static final int ForStatement_ord = 11;
	public static final int ForeachStatement_ord = 12;
	public static final int BlockStatement_ord = 13;
	public static final int PrintStatement_ord = 14;
	public static final int PrintlnStatement_ord = 15;
	public static final int SaveStatement_ord = 16;
	public static final int ExpressionStatement_ord = 17;
	public static final int LoadExpression_ord = 18;
	public static final int FunctionInvocationExpression_ord = 19;
	public static final int Arguments_ord = 20;
	public static final int AssignmentExpression_ord = 21;
	public static final int RunExpression_ord = 22;
	public static final int SizeExpression_ord = 23;
	public static final int Literal_ord = 24;
	public static final int BooleanLiteral_ord = 25;
	public static final int IntLiteral_ord = 26;
	public static final int StringLiteral_ord = 27;
	public static final int RangeLiteral_ord = 28;
	public static final int ArrayLiteral_ord = 29;
	public static final int Name_ord = 30;
	public static final int NameExpression_ord = 31;
	public static final int PrimitiveType_ord = 32;
	public static final int ArrayType_ord = 33;
	public static final int ArrayAccess_ord = 34;
	public static final int Addition_ord = 35;
	public static final int Subtraction_ord = 36;
	public static final int Multiplication_ord = 37;
	public static final int Division_ord = 38;
	public static final int Remainder_ord = 39;
	public static final int And_ord = 40;
	public static final int Or_ord = 41;
	public static final int Not_ord = 42;
	public static final int Equals_ord = 43;
	public static final int NotEquals_ord = 44;
	public static final int LessThan_ord = 45;
	public static final int LessOrEquals_ord = 46;
	public static final int GreaterThan_ord = 47;
	public static final int GreaterOrEquals_ord = 48;
	public static final int Statement_ord = 49;
	public static final int Type_ord = 50;
	public static final int Expression_ord = 51;
	public static final ImpEntityDescriptorEnum instance = new ImpEntityDescriptorEnum();
	public static final EntityDescriptor<FunctionDeclaration> FunctionDeclaration = (EntityDescriptor<FunctionDeclaration>) instance
			.valueOf(FunctionDeclaration_ord);
	public static final EntityDescriptor<Parameters> Parameters = (EntityDescriptor<Parameters>) instance
			.valueOf(Parameters_ord);
	public static final EntityDescriptor<Parameter> Parameter = (EntityDescriptor<Parameter>) instance
			.valueOf(Parameter_ord);
	public static final EntityDescriptor<VariableDeclaration> VariableDeclaration = (EntityDescriptor<VariableDeclaration>) instance
			.valueOf(VariableDeclaration_ord);
	public static final EntityDescriptor<Declaration> Declaration = (EntityDescriptor<Declaration>) instance
			.valueOf(Declaration_ord);
	public static final EntityDescriptor<EmptyStatement> EmptyStatement = (EntityDescriptor<EmptyStatement>) instance
			.valueOf(EmptyStatement_ord);
	public static final EntityDescriptor<ReturnStatement> ReturnStatement = (EntityDescriptor<ReturnStatement>) instance
			.valueOf(ReturnStatement_ord);
	public static final EntityDescriptor<IfStatement> IfStatement = (EntityDescriptor<IfStatement>) instance
			.valueOf(IfStatement_ord);
	public static final EntityDescriptor<IfElseStatement> IfElseStatement = (EntityDescriptor<IfElseStatement>) instance
			.valueOf(IfElseStatement_ord);
	public static final EntityDescriptor<WhileStatement> WhileStatement = (EntityDescriptor<WhileStatement>) instance
			.valueOf(WhileStatement_ord);
	public static final EntityDescriptor<DoWhileStatement> DoWhileStatement = (EntityDescriptor<DoWhileStatement>) instance
			.valueOf(DoWhileStatement_ord);
	public static final EntityDescriptor<ForStatement> ForStatement = (EntityDescriptor<ForStatement>) instance
			.valueOf(ForStatement_ord);
	public static final EntityDescriptor<ForeachStatement> ForeachStatement = (EntityDescriptor<ForeachStatement>) instance
			.valueOf(ForeachStatement_ord);
	public static final EntityDescriptor<BlockStatement> BlockStatement = (EntityDescriptor<BlockStatement>) instance
			.valueOf(BlockStatement_ord);
	public static final EntityDescriptor<PrintStatement> PrintStatement = (EntityDescriptor<PrintStatement>) instance
			.valueOf(PrintStatement_ord);
	public static final EntityDescriptor<PrintlnStatement> PrintlnStatement = (EntityDescriptor<PrintlnStatement>) instance
			.valueOf(PrintlnStatement_ord);
	public static final EntityDescriptor<SaveStatement> SaveStatement = (EntityDescriptor<SaveStatement>) instance
			.valueOf(SaveStatement_ord);
	public static final EntityDescriptor<ExpressionStatement> ExpressionStatement = (EntityDescriptor<ExpressionStatement>) instance
			.valueOf(ExpressionStatement_ord);
	public static final EntityDescriptor<LoadExpression> LoadExpression = (EntityDescriptor<LoadExpression>) instance
			.valueOf(LoadExpression_ord);
	public static final EntityDescriptor<FunctionInvocationExpression> FunctionInvocationExpression = (EntityDescriptor<FunctionInvocationExpression>) instance
			.valueOf(FunctionInvocationExpression_ord);
	public static final EntityDescriptor<Arguments> Arguments = (EntityDescriptor<Arguments>) instance
			.valueOf(Arguments_ord);
	public static final EntityDescriptor<AssignmentExpression> AssignmentExpression = (EntityDescriptor<AssignmentExpression>) instance
			.valueOf(AssignmentExpression_ord);
	public static final EntityDescriptor<RunExpression> RunExpression = (EntityDescriptor<RunExpression>) instance
			.valueOf(RunExpression_ord);
	public static final EntityDescriptor<SizeExpression> SizeExpression = (EntityDescriptor<SizeExpression>) instance
			.valueOf(SizeExpression_ord);
	public static final EntityDescriptor<Literal> Literal = (EntityDescriptor<Literal>) instance.valueOf(Literal_ord);
	public static final EntityDescriptor<BooleanLiteral> BooleanLiteral = (EntityDescriptor<BooleanLiteral>) instance
			.valueOf(BooleanLiteral_ord);
	public static final EntityDescriptor<IntLiteral> IntLiteral = (EntityDescriptor<IntLiteral>) instance
			.valueOf(IntLiteral_ord);
	public static final EntityDescriptor<StringLiteral> StringLiteral = (EntityDescriptor<StringLiteral>) instance
			.valueOf(StringLiteral_ord);
	public static final EntityDescriptor<RangeLiteral> RangeLiteral = (EntityDescriptor<RangeLiteral>) instance
			.valueOf(RangeLiteral_ord);
	public static final EntityDescriptor<ArrayLiteral> ArrayLiteral = (EntityDescriptor<ArrayLiteral>) instance
			.valueOf(ArrayLiteral_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
	public static final EntityDescriptor<NameExpression> NameExpression = (EntityDescriptor<NameExpression>) instance
			.valueOf(NameExpression_ord);
	public static final EntityDescriptor<PrimitiveType> PrimitiveType = (EntityDescriptor<PrimitiveType>) instance
			.valueOf(PrimitiveType_ord);
	public static final EntityDescriptor<ArrayType> ArrayType = (EntityDescriptor<ArrayType>) instance
			.valueOf(ArrayType_ord);
	public static final EntityDescriptor<ArrayAccess> ArrayAccess = (EntityDescriptor<ArrayAccess>) instance
			.valueOf(ArrayAccess_ord);
	public static final EntityDescriptor<Addition> Addition = (EntityDescriptor<Addition>) instance
			.valueOf(Addition_ord);
	public static final EntityDescriptor<Subtraction> Subtraction = (EntityDescriptor<Subtraction>) instance
			.valueOf(Subtraction_ord);
	public static final EntityDescriptor<Multiplication> Multiplication = (EntityDescriptor<Multiplication>) instance
			.valueOf(Multiplication_ord);
	public static final EntityDescriptor<Division> Division = (EntityDescriptor<Division>) instance
			.valueOf(Division_ord);
	public static final EntityDescriptor<Remainder> Remainder = (EntityDescriptor<Remainder>) instance
			.valueOf(Remainder_ord);
	public static final EntityDescriptor<And> And = (EntityDescriptor<And>) instance.valueOf(And_ord);
	public static final EntityDescriptor<Or> Or = (EntityDescriptor<Or>) instance.valueOf(Or_ord);
	public static final EntityDescriptor<Not> Not = (EntityDescriptor<Not>) instance.valueOf(Not_ord);
	public static final EntityDescriptor<Equals> Equals = (EntityDescriptor<Equals>) instance.valueOf(Equals_ord);
	public static final EntityDescriptor<NotEquals> NotEquals = (EntityDescriptor<NotEquals>) instance
			.valueOf(NotEquals_ord);
	public static final EntityDescriptor<LessThan> LessThan = (EntityDescriptor<LessThan>) instance
			.valueOf(LessThan_ord);
	public static final EntityDescriptor<LessOrEquals> LessOrEquals = (EntityDescriptor<LessOrEquals>) instance
			.valueOf(LessOrEquals_ord);
	public static final EntityDescriptor<GreaterThan> GreaterThan = (EntityDescriptor<GreaterThan>) instance
			.valueOf(GreaterThan_ord);
	public static final EntityDescriptor<GreaterOrEquals> GreaterOrEquals = (EntityDescriptor<GreaterOrEquals>) instance
			.valueOf(GreaterOrEquals_ord);
	public static final EntityDescriptor<Statement> Statement = (EntityDescriptor<Statement>) instance
			.valueOf(Statement_ord);
	public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance.valueOf(Type_ord);
	public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance
			.valueOf(Expression_ord);

	private ImpEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(FunctionDeclaration_ord, "FunctionDeclaration", FunctionDeclaration.class, false)
				.withFeature(ImpFeatureDescriptorEnum.type, Type_ord)
				.withFeature(ImpFeatureDescriptorEnum.name, Name_ord)
				.withFeature(ImpFeatureDescriptorEnum.parameters, Parameters_ord, true, false, false, false, false)
				.withFeature(ImpFeatureDescriptorEnum.body, Statement_ord);
		putCompositeEntity(Parameters_ord, "Parameters", Parameters.class, false, Parameter_ord, true, false);
		putSimpleEntity(Parameter_ord, "Parameter", Parameter.class, false)
				.withFeature(ImpFeatureDescriptorEnum.type, Type_ord)
				.withFeature(ImpFeatureDescriptorEnum.name, Name_ord);
		putSimpleEntity(VariableDeclaration_ord, "VariableDeclaration", VariableDeclaration.class, false)
				.withFeature(ImpFeatureDescriptorEnum.type, Type_ord)
				.withFeature(ImpFeatureDescriptorEnum.name, Name_ord)
				.withFeature(ImpFeatureDescriptorEnum.initializer, Expression_ord, true, false, false, false, false);
		putSimpleEntity(Declaration_ord, "Declaration", Declaration.class, true, FunctionDeclaration_ord,
				VariableDeclaration_ord).withFeature(ImpFeatureDescriptorEnum.type, Type_ord)
						.withFeature(ImpFeatureDescriptorEnum.name, Name_ord);
		putSimpleEntity(EmptyStatement_ord, "EmptyStatement", EmptyStatement.class, false);
		putSimpleEntity(ReturnStatement_ord, "ReturnStatement", ReturnStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord, true, false, false, false, false);
		putSimpleEntity(IfStatement_ord, "IfStatement", IfStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.condition, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.trueBody, Statement_ord);
		putSimpleEntity(IfElseStatement_ord, "IfElseStatement", IfElseStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.condition, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.trueBody, Statement_ord)
				.withFeature(ImpFeatureDescriptorEnum.falseBody, Statement_ord);
		putSimpleEntity(WhileStatement_ord, "WhileStatement", WhileStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.condition, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.trueBody, Statement_ord);
		putSimpleEntity(DoWhileStatement_ord, "DoWhileStatement", DoWhileStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.trueBody, Statement_ord)
				.withFeature(ImpFeatureDescriptorEnum.condition, Expression_ord);
		putSimpleEntity(ForStatement_ord, "ForStatement", ForStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.initializer, VariableDeclaration_ord)
				.withFeature(ImpFeatureDescriptorEnum.condition, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.updater, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.trueBody, Statement_ord);
		putSimpleEntity(ForeachStatement_ord, "ForeachStatement", ForeachStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.name, Name_ord)
				.withFeature(ImpFeatureDescriptorEnum.arrayExp, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.trueBody, Statement_ord);
		putCompositeEntity(BlockStatement_ord, "BlockStatement", BlockStatement.class, false, Statement_ord, true,
				false);
		putSimpleEntity(PrintStatement_ord, "PrintStatement", PrintStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord);
		putSimpleEntity(PrintlnStatement_ord, "PrintlnStatement", PrintlnStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord, true, false, false, false, false);
		putSimpleEntity(SaveStatement_ord, "SaveStatement", SaveStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.fileName, Expression_ord, true, false, false, false, false);
		putSimpleEntity(ExpressionStatement_ord, "ExpressionStatement", ExpressionStatement.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord);
		putSimpleEntity(LoadExpression_ord, "LoadExpression", LoadExpression.class, false)
				.withFeature(ImpFeatureDescriptorEnum.fileName, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.language, Expression_ord, true, false, false, false, false);
		putSimpleEntity(FunctionInvocationExpression_ord, "FunctionInvocationExpression",
				FunctionInvocationExpression.class, false)
						.withFeature(ImpFeatureDescriptorEnum.name, NameExpression_ord).withFeature(
								ImpFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false);
		putCompositeEntity(Arguments_ord, "Arguments", Arguments.class, false, Expression_ord, true, false);
		putSimpleEntity(AssignmentExpression_ord, "AssignmentExpression", AssignmentExpression.class, false)
				.withFeature(ImpFeatureDescriptorEnum.name, Name_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord);
		putSimpleEntity(RunExpression_ord, "RunExpression", RunExpression.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord);
		putSimpleEntity(SizeExpression_ord, "SizeExpression", SizeExpression.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord);
		putSimpleEntity(Literal_ord, "Literal", Literal.class, true, IntLiteral_ord, StringLiteral_ord,
				ArrayLiteral_ord, BooleanLiteral_ord, RangeLiteral_ord);
		putDataEntity(BooleanLiteral_ord, "BooleanLiteral", BooleanLiteral.class, false, boolean.class);
		putDataEntity(IntLiteral_ord, "IntLiteral", IntLiteral.class, false, int.class);
		putDataEntity(StringLiteral_ord, "StringLiteral", StringLiteral.class, false, String.class);
		putSimpleEntity(RangeLiteral_ord, "RangeLiteral", RangeLiteral.class, false)
				.withFeature(ImpFeatureDescriptorEnum.lowerBound, IntLiteral_ord)
				.withFeature(ImpFeatureDescriptorEnum.upperBound, IntLiteral_ord);
		putCompositeEntity(ArrayLiteral_ord, "ArrayLiteral", ArrayLiteral.class, false, Literal_ord, true, false);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putDataEntity(NameExpression_ord, "NameExpression", NameExpression.class, false, String.class);
		putDataEntity(PrimitiveType_ord, "PrimitiveType", PrimitiveType.class, false, PrimitiveTypeEnum.Value.class);
		putSimpleEntity(ArrayType_ord, "ArrayType", ArrayType.class, false)
				.withFeature(ImpFeatureDescriptorEnum.contentType, Type_ord)
				.withFeature(ImpFeatureDescriptorEnum.indexType, PrimitiveType_ord);
		putSimpleEntity(ArrayAccess_ord, "ArrayAccess", ArrayAccess.class, false)
				.withFeature(ImpFeatureDescriptorEnum.array, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.index, Expression_ord);
		putSimpleEntity(Addition_ord, "Addition", Addition.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Subtraction_ord, "Subtraction", Subtraction.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Multiplication_ord, "Multiplication", Multiplication.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Division_ord, "Division", Division.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Remainder_ord, "Remainder", Remainder.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(And_ord, "And", And.class, false).withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Or_ord, "Or", Or.class, false).withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Not_ord, "Not", Not.class, false).withFeature(ImpFeatureDescriptorEnum.exp, Expression_ord);
		putSimpleEntity(Equals_ord, "Equals", Equals.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(NotEquals_ord, "NotEquals", NotEquals.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(LessThan_ord, "LessThan", LessThan.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(LessOrEquals_ord, "LessOrEquals", LessOrEquals.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(GreaterThan_ord, "GreaterThan", GreaterThan.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(GreaterOrEquals_ord, "GreaterOrEquals", GreaterOrEquals.class, false)
				.withFeature(ImpFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(ImpFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Statement_ord, "Statement", Statement.class, true, PrintlnStatement_ord, EmptyStatement_ord,
				IfElseStatement_ord, BlockStatement_ord, SaveStatement_ord, WhileStatement_ord, IfStatement_ord,
				FunctionDeclaration_ord, ExpressionStatement_ord, ReturnStatement_ord, PrintStatement_ord,
				VariableDeclaration_ord, Declaration_ord, ForStatement_ord, DoWhileStatement_ord, ForeachStatement_ord);
		putSimpleEntity(Type_ord, "Type", Type.class, true, ArrayType_ord, PrimitiveType_ord);
		putSimpleEntity(Expression_ord, "Expression", Expression.class, true, Multiplication_ord, Or_ord,
				BooleanLiteral_ord, NameExpression_ord, RangeLiteral_ord, FunctionInvocationExpression_ord,
				SizeExpression_ord, Remainder_ord, ArrayAccess_ord, LessThan_ord, AssignmentExpression_ord,
				GreaterThan_ord, Literal_ord, GreaterOrEquals_ord, RunExpression_ord, Division_ord, IntLiteral_ord,
				Addition_ord, LoadExpression_ord, ArrayLiteral_ord, NotEquals_ord, Not_ord, Equals_ord, Subtraction_ord,
				StringLiteral_ord, And_ord, LessOrEquals_ord);
	}
}
