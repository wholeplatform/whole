package org.whole.lang.properties.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.properties.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesEntityFactory extends GenericEntityFactory {
	public static final PropertiesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static PropertiesEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new PropertiesEntityFactory(provider);
	}

	protected PropertiesEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Properties createProperties() {
		return create(PropertiesEntityDescriptorEnum.Properties);
	}

	public Properties createProperties(Comment comment, Properties defaults,
			Entries entries) {
		return create(PropertiesEntityDescriptorEnum.Properties, comment,
				defaults, entries);
	}

	public IEntityBuilder<Properties> buildProperties() {
		return new EntityBuilder<Properties>(
				create(PropertiesEntityDescriptorEnum.Properties));
	}

	public Entries createEntries() {
		return create(PropertiesEntityDescriptorEnum.Entries);
	}

	public Entries createEntries(Property... entities) {
		return create(PropertiesEntityDescriptorEnum.Entries,
				(IEntity[]) entities);
	}

	public Entries createEntries(int initialSize) {
		return clone(PropertiesEntityDescriptorEnum.Entries, initialSize);
	}

	public Property createProperty() {
		return create(PropertiesEntityDescriptorEnum.Property);
	}

	public Property createProperty(PropertyName name, PropertyValue value) {
		return create(PropertiesEntityDescriptorEnum.Property, name, value);
	}

	public IEntityBuilder<Property> buildProperty() {
		return new EntityBuilder<Property>(
				create(PropertiesEntityDescriptorEnum.Property));
	}

	public Comment createComment() {
		return create(PropertiesEntityDescriptorEnum.Comment);
	}

	public Comment createComment(String value) {
		return create(PropertiesEntityDescriptorEnum.Comment, value);
	}

	public PropertyName createPropertyName() {
		return create(PropertiesEntityDescriptorEnum.PropertyName);
	}

	public PropertyName createPropertyName(String value) {
		return create(PropertiesEntityDescriptorEnum.PropertyName, value);
	}

	public PropertyValue createPropertyValue() {
		return create(PropertiesEntityDescriptorEnum.PropertyValue);
	}

	public PropertyValue createPropertyValue(String value) {
		return create(PropertiesEntityDescriptorEnum.PropertyValue, value);
	}
}
