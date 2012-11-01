package org.whole.lang.unifiedlambdadelta.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaGenericBuilderAdapter extends
		GenericIdentityBuilder {
	private IUnifiedLambdaDeltaBuilder specificBuilder;

	public UnifiedLambdaDeltaGenericBuilderAdapter(
			IUnifiedLambdaDeltaBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public UnifiedLambdaDeltaGenericBuilderAdapter(
			IUnifiedLambdaDeltaBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case UnifiedLambdaDeltaFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.polarity_ord:
			specificBuilder.polarity();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.front_ord:
			specificBuilder.front();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.back_ord:
			specificBuilder.back();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.index_ord:
			specificBuilder.index();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.level_ord:
			specificBuilder.level();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.access_ord:
			specificBuilder.access();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.prefix_ord:
			specificBuilder.prefix();
			break;
		case UnifiedLambdaDeltaFeatureDescriptorEnum.postfix_ord:
			specificBuilder.postfix();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Declaration_ord:
			specificBuilder.Declaration();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Definition_ord:
			specificBuilder.Definition();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Top_ord:
			specificBuilder.Top();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Application_ord:
			specificBuilder.Application();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Cast_ord:
			specificBuilder.Cast();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction_ord:
			specificBuilder.Abstraction();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation_ord:
			specificBuilder.Abbreviation();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Local_ord:
			specificBuilder.Local();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Sort_ord:
			specificBuilder.Sort();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Name_ord:
			specificBuilder.Name();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Declaration_ord:
			specificBuilder.Declaration_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Definition_ord:
			specificBuilder.Definition_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Top_ord:
			specificBuilder.Top_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Application_ord:
			specificBuilder.Application_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Cast_ord:
			specificBuilder.Cast_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction_ord:
			specificBuilder.Abstraction_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation_ord:
			specificBuilder.Abbreviation_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Local_ord:
			specificBuilder.Local_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Sort_ord:
			specificBuilder.Sort_();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Name_ord:
			specificBuilder.Name_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Declaration_ord:
			specificBuilder._Declaration();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Definition_ord:
			specificBuilder._Definition();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Top_ord:
			specificBuilder._Top();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Application_ord:
			specificBuilder._Application();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Cast_ord:
			specificBuilder._Cast();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction_ord:
			specificBuilder._Abstraction();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation_ord:
			specificBuilder._Abbreviation();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Local_ord:
			specificBuilder._Local();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Sort_ord:
			specificBuilder._Sort();
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Name_ord:
			specificBuilder._Name();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Polarity_ord:
			specificBuilder.Polarity(value);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Access_ord:
			specificBuilder.Access(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Index_ord:
			specificBuilder.Index(value);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Level_ord:
			specificBuilder.Level(value);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Postfix_ord:
			specificBuilder.Postfix(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Prefix_ord:
			specificBuilder.Prefix(value);
			break;
		}
	}
}
