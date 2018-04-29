package org.whole.examples.lang.imp.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value;

/** 
 * @generator Whole
 */
public class ImpGenericBuilderAdapter extends GenericIdentityBuilder {
	private IImpBuilder specificBuilder;

	public ImpGenericBuilderAdapter(IImpBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public ImpGenericBuilderAdapter(IImpBuilder specificBuilder, IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case ImpFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case ImpFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case ImpFeatureDescriptorEnum.parameters_ord:
			specificBuilder.parameters();
			break;
		case ImpFeatureDescriptorEnum.body_ord:
			specificBuilder.body();
			break;
		case ImpFeatureDescriptorEnum.initializer_ord:
			specificBuilder.initializer();
			break;
		case ImpFeatureDescriptorEnum.exp_ord:
			specificBuilder.exp();
			break;
		case ImpFeatureDescriptorEnum.condition_ord:
			specificBuilder.condition();
			break;
		case ImpFeatureDescriptorEnum.trueBody_ord:
			specificBuilder.trueBody();
			break;
		case ImpFeatureDescriptorEnum.falseBody_ord:
			specificBuilder.falseBody();
			break;
		case ImpFeatureDescriptorEnum.updater_ord:
			specificBuilder.updater();
			break;
		case ImpFeatureDescriptorEnum.arrayExp_ord:
			specificBuilder.arrayExp();
			break;
		case ImpFeatureDescriptorEnum.fileName_ord:
			specificBuilder.fileName();
			break;
		case ImpFeatureDescriptorEnum.language_ord:
			specificBuilder.language();
			break;
		case ImpFeatureDescriptorEnum.arguments_ord:
			specificBuilder.arguments();
			break;
		case ImpFeatureDescriptorEnum.lowerBound_ord:
			specificBuilder.lowerBound();
			break;
		case ImpFeatureDescriptorEnum.upperBound_ord:
			specificBuilder.upperBound();
			break;
		case ImpFeatureDescriptorEnum.contentType_ord:
			specificBuilder.contentType();
			break;
		case ImpFeatureDescriptorEnum.indexType_ord:
			specificBuilder.indexType();
			break;
		case ImpFeatureDescriptorEnum.array_ord:
			specificBuilder.array();
			break;
		case ImpFeatureDescriptorEnum.index_ord:
			specificBuilder.index();
			break;
		case ImpFeatureDescriptorEnum.exp1_ord:
			specificBuilder.exp1();
			break;
		case ImpFeatureDescriptorEnum.exp2_ord:
			specificBuilder.exp2();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder.FunctionDeclaration();
			break;
		case ImpEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters();
			break;
		case ImpEntityDescriptorEnum.Parameter_ord:
			specificBuilder.Parameter();
			break;
		case ImpEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration();
			break;
		case ImpEntityDescriptorEnum.EmptyStatement_ord:
			specificBuilder.EmptyStatement();
			break;
		case ImpEntityDescriptorEnum.ReturnStatement_ord:
			specificBuilder.ReturnStatement();
			break;
		case ImpEntityDescriptorEnum.IfStatement_ord:
			specificBuilder.IfStatement();
			break;
		case ImpEntityDescriptorEnum.IfElseStatement_ord:
			specificBuilder.IfElseStatement();
			break;
		case ImpEntityDescriptorEnum.WhileStatement_ord:
			specificBuilder.WhileStatement();
			break;
		case ImpEntityDescriptorEnum.DoWhileStatement_ord:
			specificBuilder.DoWhileStatement();
			break;
		case ImpEntityDescriptorEnum.ForStatement_ord:
			specificBuilder.ForStatement();
			break;
		case ImpEntityDescriptorEnum.ForeachStatement_ord:
			specificBuilder.ForeachStatement();
			break;
		case ImpEntityDescriptorEnum.BlockStatement_ord:
			specificBuilder.BlockStatement();
			break;
		case ImpEntityDescriptorEnum.PrintStatement_ord:
			specificBuilder.PrintStatement();
			break;
		case ImpEntityDescriptorEnum.PrintlnStatement_ord:
			specificBuilder.PrintlnStatement();
			break;
		case ImpEntityDescriptorEnum.SaveStatement_ord:
			specificBuilder.SaveStatement();
			break;
		case ImpEntityDescriptorEnum.ExpressionStatement_ord:
			specificBuilder.ExpressionStatement();
			break;
		case ImpEntityDescriptorEnum.LoadExpression_ord:
			specificBuilder.LoadExpression();
			break;
		case ImpEntityDescriptorEnum.FunctionInvocationExpression_ord:
			specificBuilder.FunctionInvocationExpression();
			break;
		case ImpEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments();
			break;
		case ImpEntityDescriptorEnum.AssignmentExpression_ord:
			specificBuilder.AssignmentExpression();
			break;
		case ImpEntityDescriptorEnum.RunExpression_ord:
			specificBuilder.RunExpression();
			break;
		case ImpEntityDescriptorEnum.SizeExpression_ord:
			specificBuilder.SizeExpression();
			break;
		case ImpEntityDescriptorEnum.RangeLiteral_ord:
			specificBuilder.RangeLiteral();
			break;
		case ImpEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder.ArrayLiteral();
			break;
		case ImpEntityDescriptorEnum.ArrayType_ord:
			specificBuilder.ArrayType();
			break;
		case ImpEntityDescriptorEnum.ArrayAccess_ord:
			specificBuilder.ArrayAccess();
			break;
		case ImpEntityDescriptorEnum.Addition_ord:
			specificBuilder.Addition();
			break;
		case ImpEntityDescriptorEnum.Subtraction_ord:
			specificBuilder.Subtraction();
			break;
		case ImpEntityDescriptorEnum.Multiplication_ord:
			specificBuilder.Multiplication();
			break;
		case ImpEntityDescriptorEnum.Division_ord:
			specificBuilder.Division();
			break;
		case ImpEntityDescriptorEnum.Remainder_ord:
			specificBuilder.Remainder();
			break;
		case ImpEntityDescriptorEnum.And_ord:
			specificBuilder.And();
			break;
		case ImpEntityDescriptorEnum.Or_ord:
			specificBuilder.Or();
			break;
		case ImpEntityDescriptorEnum.Not_ord:
			specificBuilder.Not();
			break;
		case ImpEntityDescriptorEnum.Equals_ord:
			specificBuilder.Equals();
			break;
		case ImpEntityDescriptorEnum.NotEquals_ord:
			specificBuilder.NotEquals();
			break;
		case ImpEntityDescriptorEnum.LessThan_ord:
			specificBuilder.LessThan();
			break;
		case ImpEntityDescriptorEnum.LessOrEquals_ord:
			specificBuilder.LessOrEquals();
			break;
		case ImpEntityDescriptorEnum.GreaterThan_ord:
			specificBuilder.GreaterThan();
			break;
		case ImpEntityDescriptorEnum.GreaterOrEquals_ord:
			specificBuilder.GreaterOrEquals();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder.FunctionDeclaration_();
			break;
		case ImpEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters_();
			break;
		case ImpEntityDescriptorEnum.Parameter_ord:
			specificBuilder.Parameter_();
			break;
		case ImpEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration_();
			break;
		case ImpEntityDescriptorEnum.EmptyStatement_ord:
			specificBuilder.EmptyStatement_();
			break;
		case ImpEntityDescriptorEnum.ReturnStatement_ord:
			specificBuilder.ReturnStatement_();
			break;
		case ImpEntityDescriptorEnum.IfStatement_ord:
			specificBuilder.IfStatement_();
			break;
		case ImpEntityDescriptorEnum.IfElseStatement_ord:
			specificBuilder.IfElseStatement_();
			break;
		case ImpEntityDescriptorEnum.WhileStatement_ord:
			specificBuilder.WhileStatement_();
			break;
		case ImpEntityDescriptorEnum.DoWhileStatement_ord:
			specificBuilder.DoWhileStatement_();
			break;
		case ImpEntityDescriptorEnum.ForStatement_ord:
			specificBuilder.ForStatement_();
			break;
		case ImpEntityDescriptorEnum.ForeachStatement_ord:
			specificBuilder.ForeachStatement_();
			break;
		case ImpEntityDescriptorEnum.BlockStatement_ord:
			specificBuilder.BlockStatement_();
			break;
		case ImpEntityDescriptorEnum.PrintStatement_ord:
			specificBuilder.PrintStatement_();
			break;
		case ImpEntityDescriptorEnum.PrintlnStatement_ord:
			specificBuilder.PrintlnStatement_();
			break;
		case ImpEntityDescriptorEnum.SaveStatement_ord:
			specificBuilder.SaveStatement_();
			break;
		case ImpEntityDescriptorEnum.ExpressionStatement_ord:
			specificBuilder.ExpressionStatement_();
			break;
		case ImpEntityDescriptorEnum.LoadExpression_ord:
			specificBuilder.LoadExpression_();
			break;
		case ImpEntityDescriptorEnum.FunctionInvocationExpression_ord:
			specificBuilder.FunctionInvocationExpression_();
			break;
		case ImpEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments_();
			break;
		case ImpEntityDescriptorEnum.AssignmentExpression_ord:
			specificBuilder.AssignmentExpression_();
			break;
		case ImpEntityDescriptorEnum.RunExpression_ord:
			specificBuilder.RunExpression_();
			break;
		case ImpEntityDescriptorEnum.SizeExpression_ord:
			specificBuilder.SizeExpression_();
			break;
		case ImpEntityDescriptorEnum.RangeLiteral_ord:
			specificBuilder.RangeLiteral_();
			break;
		case ImpEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder.ArrayLiteral_();
			break;
		case ImpEntityDescriptorEnum.ArrayType_ord:
			specificBuilder.ArrayType_();
			break;
		case ImpEntityDescriptorEnum.ArrayAccess_ord:
			specificBuilder.ArrayAccess_();
			break;
		case ImpEntityDescriptorEnum.Addition_ord:
			specificBuilder.Addition_();
			break;
		case ImpEntityDescriptorEnum.Subtraction_ord:
			specificBuilder.Subtraction_();
			break;
		case ImpEntityDescriptorEnum.Multiplication_ord:
			specificBuilder.Multiplication_();
			break;
		case ImpEntityDescriptorEnum.Division_ord:
			specificBuilder.Division_();
			break;
		case ImpEntityDescriptorEnum.Remainder_ord:
			specificBuilder.Remainder_();
			break;
		case ImpEntityDescriptorEnum.And_ord:
			specificBuilder.And_();
			break;
		case ImpEntityDescriptorEnum.Or_ord:
			specificBuilder.Or_();
			break;
		case ImpEntityDescriptorEnum.Not_ord:
			specificBuilder.Not_();
			break;
		case ImpEntityDescriptorEnum.Equals_ord:
			specificBuilder.Equals_();
			break;
		case ImpEntityDescriptorEnum.NotEquals_ord:
			specificBuilder.NotEquals_();
			break;
		case ImpEntityDescriptorEnum.LessThan_ord:
			specificBuilder.LessThan_();
			break;
		case ImpEntityDescriptorEnum.LessOrEquals_ord:
			specificBuilder.LessOrEquals_();
			break;
		case ImpEntityDescriptorEnum.GreaterThan_ord:
			specificBuilder.GreaterThan_();
			break;
		case ImpEntityDescriptorEnum.GreaterOrEquals_ord:
			specificBuilder.GreaterOrEquals_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder._FunctionDeclaration();
			break;
		case ImpEntityDescriptorEnum.Parameters_ord:
			specificBuilder._Parameters();
			break;
		case ImpEntityDescriptorEnum.Parameter_ord:
			specificBuilder._Parameter();
			break;
		case ImpEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder._VariableDeclaration();
			break;
		case ImpEntityDescriptorEnum.EmptyStatement_ord:
			specificBuilder._EmptyStatement();
			break;
		case ImpEntityDescriptorEnum.ReturnStatement_ord:
			specificBuilder._ReturnStatement();
			break;
		case ImpEntityDescriptorEnum.IfStatement_ord:
			specificBuilder._IfStatement();
			break;
		case ImpEntityDescriptorEnum.IfElseStatement_ord:
			specificBuilder._IfElseStatement();
			break;
		case ImpEntityDescriptorEnum.WhileStatement_ord:
			specificBuilder._WhileStatement();
			break;
		case ImpEntityDescriptorEnum.DoWhileStatement_ord:
			specificBuilder._DoWhileStatement();
			break;
		case ImpEntityDescriptorEnum.ForStatement_ord:
			specificBuilder._ForStatement();
			break;
		case ImpEntityDescriptorEnum.ForeachStatement_ord:
			specificBuilder._ForeachStatement();
			break;
		case ImpEntityDescriptorEnum.BlockStatement_ord:
			specificBuilder._BlockStatement();
			break;
		case ImpEntityDescriptorEnum.PrintStatement_ord:
			specificBuilder._PrintStatement();
			break;
		case ImpEntityDescriptorEnum.PrintlnStatement_ord:
			specificBuilder._PrintlnStatement();
			break;
		case ImpEntityDescriptorEnum.SaveStatement_ord:
			specificBuilder._SaveStatement();
			break;
		case ImpEntityDescriptorEnum.ExpressionStatement_ord:
			specificBuilder._ExpressionStatement();
			break;
		case ImpEntityDescriptorEnum.LoadExpression_ord:
			specificBuilder._LoadExpression();
			break;
		case ImpEntityDescriptorEnum.FunctionInvocationExpression_ord:
			specificBuilder._FunctionInvocationExpression();
			break;
		case ImpEntityDescriptorEnum.Arguments_ord:
			specificBuilder._Arguments();
			break;
		case ImpEntityDescriptorEnum.AssignmentExpression_ord:
			specificBuilder._AssignmentExpression();
			break;
		case ImpEntityDescriptorEnum.RunExpression_ord:
			specificBuilder._RunExpression();
			break;
		case ImpEntityDescriptorEnum.SizeExpression_ord:
			specificBuilder._SizeExpression();
			break;
		case ImpEntityDescriptorEnum.RangeLiteral_ord:
			specificBuilder._RangeLiteral();
			break;
		case ImpEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder._ArrayLiteral();
			break;
		case ImpEntityDescriptorEnum.ArrayType_ord:
			specificBuilder._ArrayType();
			break;
		case ImpEntityDescriptorEnum.ArrayAccess_ord:
			specificBuilder._ArrayAccess();
			break;
		case ImpEntityDescriptorEnum.Addition_ord:
			specificBuilder._Addition();
			break;
		case ImpEntityDescriptorEnum.Subtraction_ord:
			specificBuilder._Subtraction();
			break;
		case ImpEntityDescriptorEnum.Multiplication_ord:
			specificBuilder._Multiplication();
			break;
		case ImpEntityDescriptorEnum.Division_ord:
			specificBuilder._Division();
			break;
		case ImpEntityDescriptorEnum.Remainder_ord:
			specificBuilder._Remainder();
			break;
		case ImpEntityDescriptorEnum.And_ord:
			specificBuilder._And();
			break;
		case ImpEntityDescriptorEnum.Or_ord:
			specificBuilder._Or();
			break;
		case ImpEntityDescriptorEnum.Not_ord:
			specificBuilder._Not();
			break;
		case ImpEntityDescriptorEnum.Equals_ord:
			specificBuilder._Equals();
			break;
		case ImpEntityDescriptorEnum.NotEquals_ord:
			specificBuilder._NotEquals();
			break;
		case ImpEntityDescriptorEnum.LessThan_ord:
			specificBuilder._LessThan();
			break;
		case ImpEntityDescriptorEnum.LessOrEquals_ord:
			specificBuilder._LessOrEquals();
			break;
		case ImpEntityDescriptorEnum.GreaterThan_ord:
			specificBuilder._GreaterThan();
			break;
		case ImpEntityDescriptorEnum.GreaterOrEquals_ord:
			specificBuilder._GreaterOrEquals();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters_(initialCapacity);
			break;
		case ImpEntityDescriptorEnum.BlockStatement_ord:
			specificBuilder.BlockStatement_(initialCapacity);
			break;
		case ImpEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments_(initialCapacity);
			break;
		case ImpEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder.ArrayLiteral_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.BooleanLiteral_ord:
			specificBuilder.BooleanLiteral(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.IntLiteral_ord:
			specificBuilder.IntLiteral(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.StringLiteral_ord:
			specificBuilder.StringLiteral(value);
			break;
		case ImpEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case ImpEntityDescriptorEnum.NameExpression_ord:
			specificBuilder.NameExpression(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case ImpEntityDescriptorEnum.PrimitiveType_ord:
			specificBuilder.PrimitiveType((Value) value);
			break;
		}
	}
}
