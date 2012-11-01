package org.whole.lang.scheme.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;
import org.whole.lang.scheme.model.BuiltinValueEnum;
import org.whole.lang.bindings.IBindingManager;

/** 
 * @generator Whole
 */
public class SchemeSpecificBuilderAdapter extends GenericBuilderContext
		implements ISchemeBuilder {
	public SchemeSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public SchemeSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void cdr() {
		wFeature(SchemeFeatureDescriptorEnum.cdr);
	}

	public void car() {
		wFeature(SchemeFeatureDescriptorEnum.car);
	}

	public void env() {
		wFeature(SchemeFeatureDescriptorEnum.env);
	}

	public void definitions() {
		wFeature(SchemeFeatureDescriptorEnum.definitions);
	}

	public void elseBody() {
		wFeature(SchemeFeatureDescriptorEnum.elseBody);
	}

	public void branches() {
		wFeature(SchemeFeatureDescriptorEnum.branches);
	}

	public void args() {
		wFeature(SchemeFeatureDescriptorEnum.args);
	}

	public void expressions() {
		wFeature(SchemeFeatureDescriptorEnum.expressions);
	}

	public void body() {
		wFeature(SchemeFeatureDescriptorEnum.body);
	}

	public void test() {
		wFeature(SchemeFeatureDescriptorEnum.test);
	}

	public void expression() {
		wFeature(SchemeFeatureDescriptorEnum.expression);
	}

	public void name() {
		wFeature(SchemeFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void Definitions() {
		wEntity(SchemeEntityDescriptorEnum.Definitions);
	}

	public void Definitions_() {
		wEntity_(SchemeEntityDescriptorEnum.Definitions);
	}

	public void Definitions_(int initialCapacity) {
		wEntity_(SchemeEntityDescriptorEnum.Definitions, initialCapacity);
	}

	public void _Definitions() {
		_wEntity(SchemeEntityDescriptorEnum.Definitions);
	}

	public void Definition() {
		wEntity(SchemeEntityDescriptorEnum.Definition);
	}

	public void Definition_() {
		wEntity_(SchemeEntityDescriptorEnum.Definition);
	}

	public void _Definition() {
		_wEntity(SchemeEntityDescriptorEnum.Definition);
	}

	public void Branches() {
		wEntity(SchemeEntityDescriptorEnum.Branches);
	}

	public void Branches_() {
		wEntity_(SchemeEntityDescriptorEnum.Branches);
	}

	public void Branches_(int initialCapacity) {
		wEntity_(SchemeEntityDescriptorEnum.Branches, initialCapacity);
	}

	public void _Branches() {
		_wEntity(SchemeEntityDescriptorEnum.Branches);
	}

	public void Branch() {
		wEntity(SchemeEntityDescriptorEnum.Branch);
	}

	public void Branch_() {
		wEntity_(SchemeEntityDescriptorEnum.Branch);
	}

	public void _Branch() {
		_wEntity(SchemeEntityDescriptorEnum.Branch);
	}

	public void SchemeExpressions() {
		wEntity(SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public void SchemeExpressions_() {
		wEntity_(SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public void SchemeExpressions_(int initialCapacity) {
		wEntity_(SchemeEntityDescriptorEnum.SchemeExpressions, initialCapacity);
	}

	public void _SchemeExpressions() {
		_wEntity(SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public void ApplyExpression() {
		wEntity(SchemeEntityDescriptorEnum.ApplyExpression);
	}

	public void ApplyExpression_() {
		wEntity_(SchemeEntityDescriptorEnum.ApplyExpression);
	}

	public void _ApplyExpression() {
		_wEntity(SchemeEntityDescriptorEnum.ApplyExpression);
	}

	public void LambdaExpression() {
		wEntity(SchemeEntityDescriptorEnum.LambdaExpression);
	}

	public void LambdaExpression_() {
		wEntity_(SchemeEntityDescriptorEnum.LambdaExpression);
	}

	public void _LambdaExpression() {
		_wEntity(SchemeEntityDescriptorEnum.LambdaExpression);
	}

	public void AndExpression() {
		wEntity(SchemeEntityDescriptorEnum.AndExpression);
	}

	public void AndExpression_() {
		wEntity_(SchemeEntityDescriptorEnum.AndExpression);
	}

	public void _AndExpression() {
		_wEntity(SchemeEntityDescriptorEnum.AndExpression);
	}

	public void OrExpression() {
		wEntity(SchemeEntityDescriptorEnum.OrExpression);
	}

	public void OrExpression_() {
		wEntity_(SchemeEntityDescriptorEnum.OrExpression);
	}

	public void _OrExpression() {
		_wEntity(SchemeEntityDescriptorEnum.OrExpression);
	}

	public void CondExpression() {
		wEntity(SchemeEntityDescriptorEnum.CondExpression);
	}

	public void CondExpression_() {
		wEntity_(SchemeEntityDescriptorEnum.CondExpression);
	}

	public void _CondExpression() {
		_wEntity(SchemeEntityDescriptorEnum.CondExpression);
	}

	public void LocalExpression() {
		wEntity(SchemeEntityDescriptorEnum.LocalExpression);
	}

	public void LocalExpression_() {
		wEntity_(SchemeEntityDescriptorEnum.LocalExpression);
	}

	public void _LocalExpression() {
		_wEntity(SchemeEntityDescriptorEnum.LocalExpression);
	}

	public void IdExpression() {
		wEntity(SchemeEntityDescriptorEnum.IdExpression);
	}

	public void IdExpression(String value) {
		wEntity(SchemeEntityDescriptorEnum.IdExpression, value);
	}

	public void ClosureValue() {
		wEntity(SchemeEntityDescriptorEnum.ClosureValue);
	}

	public void ClosureValue_() {
		wEntity_(SchemeEntityDescriptorEnum.ClosureValue);
	}

	public void _ClosureValue() {
		_wEntity(SchemeEntityDescriptorEnum.ClosureValue);
	}

	public void BuiltinValue() {
		wEntity(SchemeEntityDescriptorEnum.BuiltinValue);
	}

	public void BuiltinValue(BuiltinValueEnum.Value value) {
		wEntity(SchemeEntityDescriptorEnum.BuiltinValue, value);
	}

	public void BuiltinValue(String value) {
		wEntity(SchemeEntityDescriptorEnum.BuiltinValue, value);
	}

	public void BooleanValue() {
		wEntity(SchemeEntityDescriptorEnum.BooleanValue);
	}

	public void BooleanValue(boolean value) {
		wEntity(SchemeEntityDescriptorEnum.BooleanValue, value);
	}

	public void IntValue() {
		wEntity(SchemeEntityDescriptorEnum.IntValue);
	}

	public void IntValue(int value) {
		wEntity(SchemeEntityDescriptorEnum.IntValue, value);
	}

	public void StringValue() {
		wEntity(SchemeEntityDescriptorEnum.StringValue);
	}

	public void StringValue(String value) {
		wEntity(SchemeEntityDescriptorEnum.StringValue, value);
	}

	public void PairValue() {
		wEntity(SchemeEntityDescriptorEnum.PairValue);
	}

	public void PairValue_() {
		wEntity_(SchemeEntityDescriptorEnum.PairValue);
	}

	public void _PairValue() {
		_wEntity(SchemeEntityDescriptorEnum.PairValue);
	}

	public void Names() {
		wEntity(SchemeEntityDescriptorEnum.Names);
	}

	public void Names_() {
		wEntity_(SchemeEntityDescriptorEnum.Names);
	}

	public void Names_(int initialCapacity) {
		wEntity_(SchemeEntityDescriptorEnum.Names, initialCapacity);
	}

	public void _Names() {
		_wEntity(SchemeEntityDescriptorEnum.Names);
	}

	public void Name() {
		wEntity(SchemeEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(SchemeEntityDescriptorEnum.Name, value);
	}

	public void SchemeEnvironment() {
		wEntity(SchemeEntityDescriptorEnum.SchemeEnvironment);
	}

	public void SchemeEnvironment(IBindingManager value) {
		wEntity(SchemeEntityDescriptorEnum.SchemeEnvironment, value);
	}

	public void SchemeEnvironment(String value) {
		wEntity(SchemeEntityDescriptorEnum.SchemeEnvironment, value);
	}
}
