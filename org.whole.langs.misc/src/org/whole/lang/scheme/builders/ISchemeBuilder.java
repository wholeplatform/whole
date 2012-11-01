package org.whole.lang.scheme.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.scheme.model.BuiltinValueEnum;
import org.whole.lang.bindings.IBindingManager;

/** 
 * @generator Whole
 */
public interface ISchemeBuilder extends IBuilder {
	public void visit();

	public void cdr();

	public void car();

	public void env();

	public void definitions();

	public void elseBody();

	public void branches();

	public void args();

	public void expressions();

	public void body();

	public void test();

	public void expression();

	public void name();

	public void Definitions();

	public void Definitions_();

	public void Definitions_(int initialCapacity);

	public void _Definitions();

	public void Definition();

	public void Definition_();

	public void _Definition();

	public void Branches();

	public void Branches_();

	public void Branches_(int initialCapacity);

	public void _Branches();

	public void Branch();

	public void Branch_();

	public void _Branch();

	public void SchemeExpressions();

	public void SchemeExpressions_();

	public void SchemeExpressions_(int initialCapacity);

	public void _SchemeExpressions();

	public void ApplyExpression();

	public void ApplyExpression_();

	public void _ApplyExpression();

	public void LambdaExpression();

	public void LambdaExpression_();

	public void _LambdaExpression();

	public void AndExpression();

	public void AndExpression_();

	public void _AndExpression();

	public void OrExpression();

	public void OrExpression_();

	public void _OrExpression();

	public void CondExpression();

	public void CondExpression_();

	public void _CondExpression();

	public void LocalExpression();

	public void LocalExpression_();

	public void _LocalExpression();

	public void IdExpression();

	public void IdExpression(String value);

	public void ClosureValue();

	public void ClosureValue_();

	public void _ClosureValue();

	public void BuiltinValue();

	public void BuiltinValue(BuiltinValueEnum.Value value);

	public void BuiltinValue(String value);

	public void BooleanValue();

	public void BooleanValue(boolean value);

	public void IntValue();

	public void IntValue(int value);

	public void StringValue();

	public void StringValue(String value);

	public void PairValue();

	public void PairValue_();

	public void _PairValue();

	public void Names();

	public void Names_();

	public void Names_(int initialCapacity);

	public void _Names();

	public void Name();

	public void Name(String value);

	public void SchemeEnvironment();

	public void SchemeEnvironment(IBindingManager value);

	public void SchemeEnvironment(String value);
}
