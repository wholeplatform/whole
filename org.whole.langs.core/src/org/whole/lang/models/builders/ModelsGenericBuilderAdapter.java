package org.whole.lang.models.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.models.model.EntityModifierEnum.Value;

/** 
 * @generator Whole
 */
public class ModelsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IModelsBuilder specificBuilder;

	public ModelsGenericBuilderAdapter(IModelsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public ModelsGenericBuilderAdapter(IModelsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case ModelsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case ModelsFeatureDescriptorEnum.typeRelations_ord:
			specificBuilder.typeRelations();
			break;
		case ModelsFeatureDescriptorEnum.declarations_ord:
			specificBuilder.declarations();
			break;
		case ModelsFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case ModelsFeatureDescriptorEnum.version_ord:
			specificBuilder.version();
			break;
		case ModelsFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		case ModelsFeatureDescriptorEnum.modifiers_ord:
			specificBuilder.modifiers();
			break;
		case ModelsFeatureDescriptorEnum.types_ord:
			specificBuilder.types();
			break;
		case ModelsFeatureDescriptorEnum.features_ord:
			specificBuilder.features();
			break;
		case ModelsFeatureDescriptorEnum.componentModifiers_ord:
			specificBuilder.componentModifiers();
			break;
		case ModelsFeatureDescriptorEnum.componentType_ord:
			specificBuilder.componentType();
			break;
		case ModelsFeatureDescriptorEnum.keyType_ord:
			specificBuilder.keyType();
			break;
		case ModelsFeatureDescriptorEnum.valueType_ord:
			specificBuilder.valueType();
			break;
		case ModelsFeatureDescriptorEnum.dataType_ord:
			specificBuilder.dataType();
			break;
		case ModelsFeatureDescriptorEnum.values_ord:
			specificBuilder.values();
			break;
		case ModelsFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case ModelsFeatureDescriptorEnum.oppositeName_ord:
			specificBuilder.oppositeName();
			break;
		case ModelsFeatureDescriptorEnum.foreignType_ord:
			specificBuilder.foreignType();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ModelsEntityDescriptorEnum.Model_ord:
			specificBuilder.Model();
			break;
		case ModelsEntityDescriptorEnum.ModelDeclarations_ord:
			specificBuilder.ModelDeclarations();
			break;
		case ModelsEntityDescriptorEnum.SimpleEntity_ord:
			specificBuilder.SimpleEntity();
			break;
		case ModelsEntityDescriptorEnum.CompositeEntity_ord:
			specificBuilder.CompositeEntity();
			break;
		case ModelsEntityDescriptorEnum.MapEntity_ord:
			specificBuilder.MapEntity();
			break;
		case ModelsEntityDescriptorEnum.DataEntity_ord:
			specificBuilder.DataEntity();
			break;
		case ModelsEntityDescriptorEnum.EnumEntity_ord:
			specificBuilder.EnumEntity();
			break;
		case ModelsEntityDescriptorEnum.EntityModifiers_ord:
			specificBuilder.EntityModifiers();
			break;
		case ModelsEntityDescriptorEnum.Features_ord:
			specificBuilder.Features();
			break;
		case ModelsEntityDescriptorEnum.Feature_ord:
			specificBuilder.Feature();
			break;
		case ModelsEntityDescriptorEnum.FeatureModifiers_ord:
			specificBuilder.FeatureModifiers();
			break;
		case ModelsEntityDescriptorEnum.ComponentModifiers_ord:
			specificBuilder.ComponentModifiers();
			break;
		case ModelsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues();
			break;
		case ModelsEntityDescriptorEnum.Types_ord:
			specificBuilder.Types();
			break;
		case ModelsEntityDescriptorEnum.TypeRelations_ord:
			specificBuilder.TypeRelations();
			break;
		case ModelsEntityDescriptorEnum.SupertypesOf_ord:
			specificBuilder.SupertypesOf();
			break;
		case ModelsEntityDescriptorEnum.SubtypesOf_ord:
			specificBuilder.SubtypesOf();
			break;
		case ModelsEntityDescriptorEnum.TypeAliasOf_ord:
			specificBuilder.TypeAliasOf();
			break;
		case ModelsEntityDescriptorEnum.AnyType_ord:
			specificBuilder.AnyType();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ModelsEntityDescriptorEnum.Model_ord:
			specificBuilder.Model_();
			break;
		case ModelsEntityDescriptorEnum.ModelDeclarations_ord:
			specificBuilder.ModelDeclarations_();
			break;
		case ModelsEntityDescriptorEnum.SimpleEntity_ord:
			specificBuilder.SimpleEntity_();
			break;
		case ModelsEntityDescriptorEnum.CompositeEntity_ord:
			specificBuilder.CompositeEntity_();
			break;
		case ModelsEntityDescriptorEnum.MapEntity_ord:
			specificBuilder.MapEntity_();
			break;
		case ModelsEntityDescriptorEnum.DataEntity_ord:
			specificBuilder.DataEntity_();
			break;
		case ModelsEntityDescriptorEnum.EnumEntity_ord:
			specificBuilder.EnumEntity_();
			break;
		case ModelsEntityDescriptorEnum.EntityModifiers_ord:
			specificBuilder.EntityModifiers_();
			break;
		case ModelsEntityDescriptorEnum.Features_ord:
			specificBuilder.Features_();
			break;
		case ModelsEntityDescriptorEnum.Feature_ord:
			specificBuilder.Feature_();
			break;
		case ModelsEntityDescriptorEnum.FeatureModifiers_ord:
			specificBuilder.FeatureModifiers_();
			break;
		case ModelsEntityDescriptorEnum.ComponentModifiers_ord:
			specificBuilder.ComponentModifiers_();
			break;
		case ModelsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues_();
			break;
		case ModelsEntityDescriptorEnum.Types_ord:
			specificBuilder.Types_();
			break;
		case ModelsEntityDescriptorEnum.TypeRelations_ord:
			specificBuilder.TypeRelations_();
			break;
		case ModelsEntityDescriptorEnum.SupertypesOf_ord:
			specificBuilder.SupertypesOf_();
			break;
		case ModelsEntityDescriptorEnum.SubtypesOf_ord:
			specificBuilder.SubtypesOf_();
			break;
		case ModelsEntityDescriptorEnum.TypeAliasOf_ord:
			specificBuilder.TypeAliasOf_();
			break;
		case ModelsEntityDescriptorEnum.AnyType_ord:
			specificBuilder.AnyType_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ModelsEntityDescriptorEnum.Model_ord:
			specificBuilder._Model();
			break;
		case ModelsEntityDescriptorEnum.ModelDeclarations_ord:
			specificBuilder._ModelDeclarations();
			break;
		case ModelsEntityDescriptorEnum.SimpleEntity_ord:
			specificBuilder._SimpleEntity();
			break;
		case ModelsEntityDescriptorEnum.CompositeEntity_ord:
			specificBuilder._CompositeEntity();
			break;
		case ModelsEntityDescriptorEnum.MapEntity_ord:
			specificBuilder._MapEntity();
			break;
		case ModelsEntityDescriptorEnum.DataEntity_ord:
			specificBuilder._DataEntity();
			break;
		case ModelsEntityDescriptorEnum.EnumEntity_ord:
			specificBuilder._EnumEntity();
			break;
		case ModelsEntityDescriptorEnum.EntityModifiers_ord:
			specificBuilder._EntityModifiers();
			break;
		case ModelsEntityDescriptorEnum.Features_ord:
			specificBuilder._Features();
			break;
		case ModelsEntityDescriptorEnum.Feature_ord:
			specificBuilder._Feature();
			break;
		case ModelsEntityDescriptorEnum.FeatureModifiers_ord:
			specificBuilder._FeatureModifiers();
			break;
		case ModelsEntityDescriptorEnum.ComponentModifiers_ord:
			specificBuilder._ComponentModifiers();
			break;
		case ModelsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder._EnumValues();
			break;
		case ModelsEntityDescriptorEnum.Types_ord:
			specificBuilder._Types();
			break;
		case ModelsEntityDescriptorEnum.TypeRelations_ord:
			specificBuilder._TypeRelations();
			break;
		case ModelsEntityDescriptorEnum.SupertypesOf_ord:
			specificBuilder._SupertypesOf();
			break;
		case ModelsEntityDescriptorEnum.SubtypesOf_ord:
			specificBuilder._SubtypesOf();
			break;
		case ModelsEntityDescriptorEnum.TypeAliasOf_ord:
			specificBuilder._TypeAliasOf();
			break;
		case ModelsEntityDescriptorEnum.AnyType_ord:
			specificBuilder._AnyType();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case ModelsEntityDescriptorEnum.ModelDeclarations_ord:
			specificBuilder.ModelDeclarations_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.EntityModifiers_ord:
			specificBuilder.EntityModifiers_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.Features_ord:
			specificBuilder.Features_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.FeatureModifiers_ord:
			specificBuilder.FeatureModifiers_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.ComponentModifiers_ord:
			specificBuilder.ComponentModifiers_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.Types_ord:
			specificBuilder.Types_(initialCapacity);
			break;
		case ModelsEntityDescriptorEnum.TypeRelations_ord:
			specificBuilder.TypeRelations_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case ModelsEntityDescriptorEnum.EntityModifier_ord:
			specificBuilder.EntityModifier((Value) value);
			break;
		case ModelsEntityDescriptorEnum.FeatureModifier_ord:
			specificBuilder
					.FeatureModifier((org.whole.lang.models.model.FeatureModifierEnum.Value) value);
			break;
		case ModelsEntityDescriptorEnum.ComponentModifier_ord:
			specificBuilder
					.ComponentModifier((org.whole.lang.models.model.ComponentModifierEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case ModelsEntityDescriptorEnum.DataType_ord:
			specificBuilder.DataType(value);
			break;
		case ModelsEntityDescriptorEnum.EnumValue_ord:
			specificBuilder.EnumValue(value);
			break;
		case ModelsEntityDescriptorEnum.EntityType_ord:
			specificBuilder.EntityType(value);
			break;
		case ModelsEntityDescriptorEnum.SimpleName_ord:
			specificBuilder.SimpleName(value);
			break;
		case ModelsEntityDescriptorEnum.Namespace_ord:
			specificBuilder.Namespace(value);
			break;
		case ModelsEntityDescriptorEnum.Version_ord:
			specificBuilder.Version(value);
			break;
		case ModelsEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		}
	}
}
