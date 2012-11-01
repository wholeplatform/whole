package org.whole.lang.properties.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesSpecificBuilderAdapter extends GenericBuilderContext
		implements IPropertiesBuilder {
	public PropertiesSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public PropertiesSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void value() {
		wFeature(PropertiesFeatureDescriptorEnum.value);
	}

	public void name() {
		wFeature(PropertiesFeatureDescriptorEnum.name);
	}

	public void entries() {
		wFeature(PropertiesFeatureDescriptorEnum.entries);
	}

	public void defaults() {
		wFeature(PropertiesFeatureDescriptorEnum.defaults);
	}

	public void comment() {
		wFeature(PropertiesFeatureDescriptorEnum.comment);
	}

	public void visit() {
	}

	public void Properties() {
		wEntity(PropertiesEntityDescriptorEnum.Properties);
	}

	public void Properties_() {
		wEntity_(PropertiesEntityDescriptorEnum.Properties);
	}

	public void _Properties() {
		_wEntity(PropertiesEntityDescriptorEnum.Properties);
	}

	public void Entries() {
		wEntity(PropertiesEntityDescriptorEnum.Entries);
	}

	public void Entries_() {
		wEntity_(PropertiesEntityDescriptorEnum.Entries);
	}

	public void Entries_(int initialCapacity) {
		wEntity_(PropertiesEntityDescriptorEnum.Entries, initialCapacity);
	}

	public void _Entries() {
		_wEntity(PropertiesEntityDescriptorEnum.Entries);
	}

	public void Property() {
		wEntity(PropertiesEntityDescriptorEnum.Property);
	}

	public void Property_() {
		wEntity_(PropertiesEntityDescriptorEnum.Property);
	}

	public void _Property() {
		_wEntity(PropertiesEntityDescriptorEnum.Property);
	}

	public void Comment() {
		wEntity(PropertiesEntityDescriptorEnum.Comment);
	}

	public void Comment(String value) {
		wEntity(PropertiesEntityDescriptorEnum.Comment, value);
	}

	public void PropertyName() {
		wEntity(PropertiesEntityDescriptorEnum.PropertyName);
	}

	public void PropertyName(String value) {
		wEntity(PropertiesEntityDescriptorEnum.PropertyName, value);
	}

	public void PropertyValue() {
		wEntity(PropertiesEntityDescriptorEnum.PropertyValue);
	}

	public void PropertyValue(String value) {
		wEntity(PropertiesEntityDescriptorEnum.PropertyValue, value);
	}
}
