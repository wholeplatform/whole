package org.whole.lang.properties.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesGenericBuilderAdapter extends GenericIdentityBuilder {
	private IPropertiesBuilder specificBuilder;

	public PropertiesGenericBuilderAdapter(IPropertiesBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public PropertiesGenericBuilderAdapter(IPropertiesBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case PropertiesFeatureDescriptorEnum.comment_ord:
			specificBuilder.comment();
			break;
		case PropertiesFeatureDescriptorEnum.defaults_ord:
			specificBuilder.defaults();
			break;
		case PropertiesFeatureDescriptorEnum.entries_ord:
			specificBuilder.entries();
			break;
		case PropertiesFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case PropertiesFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.Properties_ord:
			specificBuilder.Properties();
			break;
		case PropertiesEntityDescriptorEnum.Entries_ord:
			specificBuilder.Entries();
			break;
		case PropertiesEntityDescriptorEnum.Property_ord:
			specificBuilder.Property();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.Properties_ord:
			specificBuilder.Properties_();
			break;
		case PropertiesEntityDescriptorEnum.Entries_ord:
			specificBuilder.Entries_();
			break;
		case PropertiesEntityDescriptorEnum.Property_ord:
			specificBuilder.Property_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.Properties_ord:
			specificBuilder._Properties();
			break;
		case PropertiesEntityDescriptorEnum.Entries_ord:
			specificBuilder._Entries();
			break;
		case PropertiesEntityDescriptorEnum.Property_ord:
			specificBuilder._Property();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.Entries_ord:
			specificBuilder.Entries_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.Comment_ord:
			specificBuilder.Comment(value);
			break;
		case PropertiesEntityDescriptorEnum.PropertyName_ord:
			specificBuilder.PropertyName(value);
			break;
		case PropertiesEntityDescriptorEnum.PropertyValue_ord:
			specificBuilder.PropertyValue(value);
			break;
		}
	}
}
