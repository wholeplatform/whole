package org.whole.lang.scheme.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.scheme.model.BuiltinValueEnum.Value;
import org.whole.lang.bindings.IBindingManager;

/** 
 * @generator Whole
 */
public class SchemeGenericBuilderAdapter extends GenericIdentityBuilder {
	private ISchemeBuilder specificBuilder;

	public SchemeGenericBuilderAdapter(ISchemeBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public SchemeGenericBuilderAdapter(ISchemeBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.Definitions_ord:
			specificBuilder.Definitions();
			break;
		case SchemeEntityDescriptorEnum.Definition_ord:
			specificBuilder.Definition();
			break;
		case SchemeEntityDescriptorEnum.Branches_ord:
			specificBuilder.Branches();
			break;
		case SchemeEntityDescriptorEnum.Branch_ord:
			specificBuilder.Branch();
			break;
		case SchemeEntityDescriptorEnum.SchemeExpressions_ord:
			specificBuilder.SchemeExpressions();
			break;
		case SchemeEntityDescriptorEnum.ApplyExpression_ord:
			specificBuilder.ApplyExpression();
			break;
		case SchemeEntityDescriptorEnum.LambdaExpression_ord:
			specificBuilder.LambdaExpression();
			break;
		case SchemeEntityDescriptorEnum.AndExpression_ord:
			specificBuilder.AndExpression();
			break;
		case SchemeEntityDescriptorEnum.OrExpression_ord:
			specificBuilder.OrExpression();
			break;
		case SchemeEntityDescriptorEnum.CondExpression_ord:
			specificBuilder.CondExpression();
			break;
		case SchemeEntityDescriptorEnum.LocalExpression_ord:
			specificBuilder.LocalExpression();
			break;
		case SchemeEntityDescriptorEnum.ClosureValue_ord:
			specificBuilder.ClosureValue();
			break;
		case SchemeEntityDescriptorEnum.PairValue_ord:
			specificBuilder.PairValue();
			break;
		case SchemeEntityDescriptorEnum.Names_ord:
			specificBuilder.Names();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.Definitions_ord:
			specificBuilder.Definitions_();
			break;
		case SchemeEntityDescriptorEnum.Definition_ord:
			specificBuilder.Definition_();
			break;
		case SchemeEntityDescriptorEnum.Branches_ord:
			specificBuilder.Branches_();
			break;
		case SchemeEntityDescriptorEnum.Branch_ord:
			specificBuilder.Branch_();
			break;
		case SchemeEntityDescriptorEnum.SchemeExpressions_ord:
			specificBuilder.SchemeExpressions_();
			break;
		case SchemeEntityDescriptorEnum.ApplyExpression_ord:
			specificBuilder.ApplyExpression_();
			break;
		case SchemeEntityDescriptorEnum.LambdaExpression_ord:
			specificBuilder.LambdaExpression_();
			break;
		case SchemeEntityDescriptorEnum.AndExpression_ord:
			specificBuilder.AndExpression_();
			break;
		case SchemeEntityDescriptorEnum.OrExpression_ord:
			specificBuilder.OrExpression_();
			break;
		case SchemeEntityDescriptorEnum.CondExpression_ord:
			specificBuilder.CondExpression_();
			break;
		case SchemeEntityDescriptorEnum.LocalExpression_ord:
			specificBuilder.LocalExpression_();
			break;
		case SchemeEntityDescriptorEnum.ClosureValue_ord:
			specificBuilder.ClosureValue_();
			break;
		case SchemeEntityDescriptorEnum.PairValue_ord:
			specificBuilder.PairValue_();
			break;
		case SchemeEntityDescriptorEnum.Names_ord:
			specificBuilder.Names_();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.Definitions_ord:
			specificBuilder.Definitions_(initialCapacity);
			break;
		case SchemeEntityDescriptorEnum.Branches_ord:
			specificBuilder.Branches_(initialCapacity);
			break;
		case SchemeEntityDescriptorEnum.SchemeExpressions_ord:
			specificBuilder.SchemeExpressions_(initialCapacity);
			break;
		case SchemeEntityDescriptorEnum.Names_ord:
			specificBuilder.Names_(initialCapacity);
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.Definitions_ord:
			specificBuilder._Definitions();
			break;
		case SchemeEntityDescriptorEnum.Definition_ord:
			specificBuilder._Definition();
			break;
		case SchemeEntityDescriptorEnum.Branches_ord:
			specificBuilder._Branches();
			break;
		case SchemeEntityDescriptorEnum.Branch_ord:
			specificBuilder._Branch();
			break;
		case SchemeEntityDescriptorEnum.SchemeExpressions_ord:
			specificBuilder._SchemeExpressions();
			break;
		case SchemeEntityDescriptorEnum.ApplyExpression_ord:
			specificBuilder._ApplyExpression();
			break;
		case SchemeEntityDescriptorEnum.LambdaExpression_ord:
			specificBuilder._LambdaExpression();
			break;
		case SchemeEntityDescriptorEnum.AndExpression_ord:
			specificBuilder._AndExpression();
			break;
		case SchemeEntityDescriptorEnum.OrExpression_ord:
			specificBuilder._OrExpression();
			break;
		case SchemeEntityDescriptorEnum.CondExpression_ord:
			specificBuilder._CondExpression();
			break;
		case SchemeEntityDescriptorEnum.LocalExpression_ord:
			specificBuilder._LocalExpression();
			break;
		case SchemeEntityDescriptorEnum.ClosureValue_ord:
			specificBuilder._ClosureValue();
			break;
		case SchemeEntityDescriptorEnum.PairValue_ord:
			specificBuilder._PairValue();
			break;
		case SchemeEntityDescriptorEnum.Names_ord:
			specificBuilder._Names();
			break;
		}
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case SchemeFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case SchemeFeatureDescriptorEnum.expression_ord:
			specificBuilder.expression();
			break;
		case SchemeFeatureDescriptorEnum.test_ord:
			specificBuilder.test();
			break;
		case SchemeFeatureDescriptorEnum.body_ord:
			specificBuilder.body();
			break;
		case SchemeFeatureDescriptorEnum.expressions_ord:
			specificBuilder.expressions();
			break;
		case SchemeFeatureDescriptorEnum.args_ord:
			specificBuilder.args();
			break;
		case SchemeFeatureDescriptorEnum.branches_ord:
			specificBuilder.branches();
			break;
		case SchemeFeatureDescriptorEnum.elseBody_ord:
			specificBuilder.elseBody();
			break;
		case SchemeFeatureDescriptorEnum.definitions_ord:
			specificBuilder.definitions();
			break;
		case SchemeFeatureDescriptorEnum.env_ord:
			specificBuilder.env();
			break;
		case SchemeFeatureDescriptorEnum.car_ord:
			specificBuilder.car();
			break;
		case SchemeFeatureDescriptorEnum.cdr_ord:
			specificBuilder.cdr();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.IdExpression_ord:
			specificBuilder.IdExpression(value);
			break;
		case SchemeEntityDescriptorEnum.StringValue_ord:
			specificBuilder.StringValue(value);
			break;
		case SchemeEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.BuiltinValue_ord:
			specificBuilder.BuiltinValue((Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.BooleanValue_ord:
			specificBuilder.BooleanValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.IntValue_ord:
			specificBuilder.IntValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, IBindingManager value) {
		switch (entityDesc.getOrdinal()) {
		case SchemeEntityDescriptorEnum.SchemeEnvironment_ord:
			specificBuilder.SchemeEnvironment(value);
			break;
		}
	}
}
