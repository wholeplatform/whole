package org.whole.examples.lang.imp.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.model.PrimitiveTypeEnum;

/** 
 * @generator Whole
 */
public class ImpSpecificBuilderAdapter extends GenericBuilderContext implements IImpBuilder {
	public ImpSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public ImpSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void exp2() {
		wFeature(ImpFeatureDescriptorEnum.exp2);
	}

	public void exp1() {
		wFeature(ImpFeatureDescriptorEnum.exp1);
	}

	public void index() {
		wFeature(ImpFeatureDescriptorEnum.index);
	}

	public void array() {
		wFeature(ImpFeatureDescriptorEnum.array);
	}

	public void indexType() {
		wFeature(ImpFeatureDescriptorEnum.indexType);
	}

	public void contentType() {
		wFeature(ImpFeatureDescriptorEnum.contentType);
	}

	public void upperBound() {
		wFeature(ImpFeatureDescriptorEnum.upperBound);
	}

	public void lowerBound() {
		wFeature(ImpFeatureDescriptorEnum.lowerBound);
	}

	public void arguments() {
		wFeature(ImpFeatureDescriptorEnum.arguments);
	}

	public void language() {
		wFeature(ImpFeatureDescriptorEnum.language);
	}

	public void fileName() {
		wFeature(ImpFeatureDescriptorEnum.fileName);
	}

	public void arrayExp() {
		wFeature(ImpFeatureDescriptorEnum.arrayExp);
	}

	public void updater() {
		wFeature(ImpFeatureDescriptorEnum.updater);
	}

	public void falseBody() {
		wFeature(ImpFeatureDescriptorEnum.falseBody);
	}

	public void trueBody() {
		wFeature(ImpFeatureDescriptorEnum.trueBody);
	}

	public void condition() {
		wFeature(ImpFeatureDescriptorEnum.condition);
	}

	public void exp() {
		wFeature(ImpFeatureDescriptorEnum.exp);
	}

	public void initializer() {
		wFeature(ImpFeatureDescriptorEnum.initializer);
	}

	public void body() {
		wFeature(ImpFeatureDescriptorEnum.body);
	}

	public void parameters() {
		wFeature(ImpFeatureDescriptorEnum.parameters);
	}

	public void name() {
		wFeature(ImpFeatureDescriptorEnum.name);
	}

	public void type() {
		wFeature(ImpFeatureDescriptorEnum.type);
	}

	public void visit() {
	}

	public void FunctionDeclaration() {
		wEntity(ImpEntityDescriptorEnum.FunctionDeclaration);
	}

	public void FunctionDeclaration_() {
		wEntity_(ImpEntityDescriptorEnum.FunctionDeclaration);
	}

	public void _FunctionDeclaration() {
		_wEntity(ImpEntityDescriptorEnum.FunctionDeclaration);
	}

	public void Parameters() {
		wEntity(ImpEntityDescriptorEnum.Parameters);
	}

	public void Parameters_() {
		wEntity_(ImpEntityDescriptorEnum.Parameters);
	}

	public void Parameters_(int initialCapacity) {
		wEntity_(ImpEntityDescriptorEnum.Parameters, initialCapacity);
	}

	public void _Parameters() {
		_wEntity(ImpEntityDescriptorEnum.Parameters);
	}

	public void Parameter() {
		wEntity(ImpEntityDescriptorEnum.Parameter);
	}

	public void Parameter_() {
		wEntity_(ImpEntityDescriptorEnum.Parameter);
	}

	public void _Parameter() {
		_wEntity(ImpEntityDescriptorEnum.Parameter);
	}

	public void VariableDeclaration() {
		wEntity(ImpEntityDescriptorEnum.VariableDeclaration);
	}

	public void VariableDeclaration_() {
		wEntity_(ImpEntityDescriptorEnum.VariableDeclaration);
	}

	public void _VariableDeclaration() {
		_wEntity(ImpEntityDescriptorEnum.VariableDeclaration);
	}

	public void EmptyStatement() {
		wEntity(ImpEntityDescriptorEnum.EmptyStatement);
	}

	public void EmptyStatement_() {
		wEntity_(ImpEntityDescriptorEnum.EmptyStatement);
	}

	public void _EmptyStatement() {
		_wEntity(ImpEntityDescriptorEnum.EmptyStatement);
	}

	public void ReturnStatement() {
		wEntity(ImpEntityDescriptorEnum.ReturnStatement);
	}

	public void ReturnStatement_() {
		wEntity_(ImpEntityDescriptorEnum.ReturnStatement);
	}

	public void _ReturnStatement() {
		_wEntity(ImpEntityDescriptorEnum.ReturnStatement);
	}

	public void IfStatement() {
		wEntity(ImpEntityDescriptorEnum.IfStatement);
	}

	public void IfStatement_() {
		wEntity_(ImpEntityDescriptorEnum.IfStatement);
	}

	public void _IfStatement() {
		_wEntity(ImpEntityDescriptorEnum.IfStatement);
	}

	public void IfElseStatement() {
		wEntity(ImpEntityDescriptorEnum.IfElseStatement);
	}

	public void IfElseStatement_() {
		wEntity_(ImpEntityDescriptorEnum.IfElseStatement);
	}

	public void _IfElseStatement() {
		_wEntity(ImpEntityDescriptorEnum.IfElseStatement);
	}

	public void WhileStatement() {
		wEntity(ImpEntityDescriptorEnum.WhileStatement);
	}

	public void WhileStatement_() {
		wEntity_(ImpEntityDescriptorEnum.WhileStatement);
	}

	public void _WhileStatement() {
		_wEntity(ImpEntityDescriptorEnum.WhileStatement);
	}

	public void DoWhileStatement() {
		wEntity(ImpEntityDescriptorEnum.DoWhileStatement);
	}

	public void DoWhileStatement_() {
		wEntity_(ImpEntityDescriptorEnum.DoWhileStatement);
	}

	public void _DoWhileStatement() {
		_wEntity(ImpEntityDescriptorEnum.DoWhileStatement);
	}

	public void ForStatement() {
		wEntity(ImpEntityDescriptorEnum.ForStatement);
	}

	public void ForStatement_() {
		wEntity_(ImpEntityDescriptorEnum.ForStatement);
	}

	public void _ForStatement() {
		_wEntity(ImpEntityDescriptorEnum.ForStatement);
	}

	public void ForeachStatement() {
		wEntity(ImpEntityDescriptorEnum.ForeachStatement);
	}

	public void ForeachStatement_() {
		wEntity_(ImpEntityDescriptorEnum.ForeachStatement);
	}

	public void _ForeachStatement() {
		_wEntity(ImpEntityDescriptorEnum.ForeachStatement);
	}

	public void BlockStatement() {
		wEntity(ImpEntityDescriptorEnum.BlockStatement);
	}

	public void BlockStatement_() {
		wEntity_(ImpEntityDescriptorEnum.BlockStatement);
	}

	public void BlockStatement_(int initialCapacity) {
		wEntity_(ImpEntityDescriptorEnum.BlockStatement, initialCapacity);
	}

	public void _BlockStatement() {
		_wEntity(ImpEntityDescriptorEnum.BlockStatement);
	}

	public void PrintStatement() {
		wEntity(ImpEntityDescriptorEnum.PrintStatement);
	}

	public void PrintStatement_() {
		wEntity_(ImpEntityDescriptorEnum.PrintStatement);
	}

	public void _PrintStatement() {
		_wEntity(ImpEntityDescriptorEnum.PrintStatement);
	}

	public void PrintlnStatement() {
		wEntity(ImpEntityDescriptorEnum.PrintlnStatement);
	}

	public void PrintlnStatement_() {
		wEntity_(ImpEntityDescriptorEnum.PrintlnStatement);
	}

	public void _PrintlnStatement() {
		_wEntity(ImpEntityDescriptorEnum.PrintlnStatement);
	}

	public void SaveStatement() {
		wEntity(ImpEntityDescriptorEnum.SaveStatement);
	}

	public void SaveStatement_() {
		wEntity_(ImpEntityDescriptorEnum.SaveStatement);
	}

	public void _SaveStatement() {
		_wEntity(ImpEntityDescriptorEnum.SaveStatement);
	}

	public void ExpressionStatement() {
		wEntity(ImpEntityDescriptorEnum.ExpressionStatement);
	}

	public void ExpressionStatement_() {
		wEntity_(ImpEntityDescriptorEnum.ExpressionStatement);
	}

	public void _ExpressionStatement() {
		_wEntity(ImpEntityDescriptorEnum.ExpressionStatement);
	}

	public void LoadExpression() {
		wEntity(ImpEntityDescriptorEnum.LoadExpression);
	}

	public void LoadExpression_() {
		wEntity_(ImpEntityDescriptorEnum.LoadExpression);
	}

	public void _LoadExpression() {
		_wEntity(ImpEntityDescriptorEnum.LoadExpression);
	}

	public void FunctionInvocationExpression() {
		wEntity(ImpEntityDescriptorEnum.FunctionInvocationExpression);
	}

	public void FunctionInvocationExpression_() {
		wEntity_(ImpEntityDescriptorEnum.FunctionInvocationExpression);
	}

	public void _FunctionInvocationExpression() {
		_wEntity(ImpEntityDescriptorEnum.FunctionInvocationExpression);
	}

	public void Arguments() {
		wEntity(ImpEntityDescriptorEnum.Arguments);
	}

	public void Arguments_() {
		wEntity_(ImpEntityDescriptorEnum.Arguments);
	}

	public void Arguments_(int initialCapacity) {
		wEntity_(ImpEntityDescriptorEnum.Arguments, initialCapacity);
	}

	public void _Arguments() {
		_wEntity(ImpEntityDescriptorEnum.Arguments);
	}

	public void AssignmentExpression() {
		wEntity(ImpEntityDescriptorEnum.AssignmentExpression);
	}

	public void AssignmentExpression_() {
		wEntity_(ImpEntityDescriptorEnum.AssignmentExpression);
	}

	public void _AssignmentExpression() {
		_wEntity(ImpEntityDescriptorEnum.AssignmentExpression);
	}

	public void RunExpression() {
		wEntity(ImpEntityDescriptorEnum.RunExpression);
	}

	public void RunExpression_() {
		wEntity_(ImpEntityDescriptorEnum.RunExpression);
	}

	public void _RunExpression() {
		_wEntity(ImpEntityDescriptorEnum.RunExpression);
	}

	public void SizeExpression() {
		wEntity(ImpEntityDescriptorEnum.SizeExpression);
	}

	public void SizeExpression_() {
		wEntity_(ImpEntityDescriptorEnum.SizeExpression);
	}

	public void _SizeExpression() {
		_wEntity(ImpEntityDescriptorEnum.SizeExpression);
	}

	public void BooleanLiteral() {
		wEntity(ImpEntityDescriptorEnum.BooleanLiteral);
	}

	public void BooleanLiteral(boolean value) {
		wEntity(ImpEntityDescriptorEnum.BooleanLiteral, value);
	}

	public void IntLiteral() {
		wEntity(ImpEntityDescriptorEnum.IntLiteral);
	}

	public void IntLiteral(int value) {
		wEntity(ImpEntityDescriptorEnum.IntLiteral, value);
	}

	public void StringLiteral() {
		wEntity(ImpEntityDescriptorEnum.StringLiteral);
	}

	public void StringLiteral(String value) {
		wEntity(ImpEntityDescriptorEnum.StringLiteral, value);
	}

	public void RangeLiteral() {
		wEntity(ImpEntityDescriptorEnum.RangeLiteral);
	}

	public void RangeLiteral_() {
		wEntity_(ImpEntityDescriptorEnum.RangeLiteral);
	}

	public void _RangeLiteral() {
		_wEntity(ImpEntityDescriptorEnum.RangeLiteral);
	}

	public void ArrayLiteral() {
		wEntity(ImpEntityDescriptorEnum.ArrayLiteral);
	}

	public void ArrayLiteral_() {
		wEntity_(ImpEntityDescriptorEnum.ArrayLiteral);
	}

	public void ArrayLiteral_(int initialCapacity) {
		wEntity_(ImpEntityDescriptorEnum.ArrayLiteral, initialCapacity);
	}

	public void _ArrayLiteral() {
		_wEntity(ImpEntityDescriptorEnum.ArrayLiteral);
	}

	public void Name() {
		wEntity(ImpEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(ImpEntityDescriptorEnum.Name, value);
	}

	public void NameExpression() {
		wEntity(ImpEntityDescriptorEnum.NameExpression);
	}

	public void NameExpression(String value) {
		wEntity(ImpEntityDescriptorEnum.NameExpression, value);
	}

	public void PrimitiveType() {
		wEntity(ImpEntityDescriptorEnum.PrimitiveType);
	}

	public void PrimitiveType(PrimitiveTypeEnum.Value value) {
		wEntity(ImpEntityDescriptorEnum.PrimitiveType, value);
	}

	public void PrimitiveType(String value) {
		wEntity(ImpEntityDescriptorEnum.PrimitiveType, value);
	}

	public void ArrayType() {
		wEntity(ImpEntityDescriptorEnum.ArrayType);
	}

	public void ArrayType_() {
		wEntity_(ImpEntityDescriptorEnum.ArrayType);
	}

	public void _ArrayType() {
		_wEntity(ImpEntityDescriptorEnum.ArrayType);
	}

	public void ArrayAccess() {
		wEntity(ImpEntityDescriptorEnum.ArrayAccess);
	}

	public void ArrayAccess_() {
		wEntity_(ImpEntityDescriptorEnum.ArrayAccess);
	}

	public void _ArrayAccess() {
		_wEntity(ImpEntityDescriptorEnum.ArrayAccess);
	}

	public void Addition() {
		wEntity(ImpEntityDescriptorEnum.Addition);
	}

	public void Addition_() {
		wEntity_(ImpEntityDescriptorEnum.Addition);
	}

	public void _Addition() {
		_wEntity(ImpEntityDescriptorEnum.Addition);
	}

	public void Subtraction() {
		wEntity(ImpEntityDescriptorEnum.Subtraction);
	}

	public void Subtraction_() {
		wEntity_(ImpEntityDescriptorEnum.Subtraction);
	}

	public void _Subtraction() {
		_wEntity(ImpEntityDescriptorEnum.Subtraction);
	}

	public void Multiplication() {
		wEntity(ImpEntityDescriptorEnum.Multiplication);
	}

	public void Multiplication_() {
		wEntity_(ImpEntityDescriptorEnum.Multiplication);
	}

	public void _Multiplication() {
		_wEntity(ImpEntityDescriptorEnum.Multiplication);
	}

	public void Division() {
		wEntity(ImpEntityDescriptorEnum.Division);
	}

	public void Division_() {
		wEntity_(ImpEntityDescriptorEnum.Division);
	}

	public void _Division() {
		_wEntity(ImpEntityDescriptorEnum.Division);
	}

	public void Remainder() {
		wEntity(ImpEntityDescriptorEnum.Remainder);
	}

	public void Remainder_() {
		wEntity_(ImpEntityDescriptorEnum.Remainder);
	}

	public void _Remainder() {
		_wEntity(ImpEntityDescriptorEnum.Remainder);
	}

	public void And() {
		wEntity(ImpEntityDescriptorEnum.And);
	}

	public void And_() {
		wEntity_(ImpEntityDescriptorEnum.And);
	}

	public void _And() {
		_wEntity(ImpEntityDescriptorEnum.And);
	}

	public void Or() {
		wEntity(ImpEntityDescriptorEnum.Or);
	}

	public void Or_() {
		wEntity_(ImpEntityDescriptorEnum.Or);
	}

	public void _Or() {
		_wEntity(ImpEntityDescriptorEnum.Or);
	}

	public void Not() {
		wEntity(ImpEntityDescriptorEnum.Not);
	}

	public void Not_() {
		wEntity_(ImpEntityDescriptorEnum.Not);
	}

	public void _Not() {
		_wEntity(ImpEntityDescriptorEnum.Not);
	}

	public void Equals() {
		wEntity(ImpEntityDescriptorEnum.Equals);
	}

	public void Equals_() {
		wEntity_(ImpEntityDescriptorEnum.Equals);
	}

	public void _Equals() {
		_wEntity(ImpEntityDescriptorEnum.Equals);
	}

	public void NotEquals() {
		wEntity(ImpEntityDescriptorEnum.NotEquals);
	}

	public void NotEquals_() {
		wEntity_(ImpEntityDescriptorEnum.NotEquals);
	}

	public void _NotEquals() {
		_wEntity(ImpEntityDescriptorEnum.NotEquals);
	}

	public void LessThan() {
		wEntity(ImpEntityDescriptorEnum.LessThan);
	}

	public void LessThan_() {
		wEntity_(ImpEntityDescriptorEnum.LessThan);
	}

	public void _LessThan() {
		_wEntity(ImpEntityDescriptorEnum.LessThan);
	}

	public void LessOrEquals() {
		wEntity(ImpEntityDescriptorEnum.LessOrEquals);
	}

	public void LessOrEquals_() {
		wEntity_(ImpEntityDescriptorEnum.LessOrEquals);
	}

	public void _LessOrEquals() {
		_wEntity(ImpEntityDescriptorEnum.LessOrEquals);
	}

	public void GreaterThan() {
		wEntity(ImpEntityDescriptorEnum.GreaterThan);
	}

	public void GreaterThan_() {
		wEntity_(ImpEntityDescriptorEnum.GreaterThan);
	}

	public void _GreaterThan() {
		_wEntity(ImpEntityDescriptorEnum.GreaterThan);
	}

	public void GreaterOrEquals() {
		wEntity(ImpEntityDescriptorEnum.GreaterOrEquals);
	}

	public void GreaterOrEquals_() {
		wEntity_(ImpEntityDescriptorEnum.GreaterOrEquals);
	}

	public void _GreaterOrEquals() {
		_wEntity(ImpEntityDescriptorEnum.GreaterOrEquals);
	}
}
