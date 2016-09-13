package org.whole.lang.properties.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class PropertiesEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Properties_ord = 0;
	public static final int Entries_ord = 1;
	public static final int Property_ord = 2;
	public static final int Comment_ord = 3;
	public static final int PropertyName_ord = 4;
	public static final int PropertyValue_ord = 5;
	public static final PropertiesEntityDescriptorEnum instance = new PropertiesEntityDescriptorEnum();
	public static final EntityDescriptor<Properties> Properties = (EntityDescriptor<Properties>) instance
			.valueOf(Properties_ord);
	public static final EntityDescriptor<Entries> Entries = (EntityDescriptor<Entries>) instance
			.valueOf(Entries_ord);
	public static final EntityDescriptor<Property> Property = (EntityDescriptor<Property>) instance
			.valueOf(Property_ord);
	public static final EntityDescriptor<Comment> Comment = (EntityDescriptor<Comment>) instance
			.valueOf(Comment_ord);
	public static final EntityDescriptor<PropertyName> PropertyName = (EntityDescriptor<PropertyName>) instance
			.valueOf(PropertyName_ord);
	public static final EntityDescriptor<PropertyValue> PropertyValue = (EntityDescriptor<PropertyValue>) instance
			.valueOf(PropertyValue_ord);

	private PropertiesEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Properties_ord, "Properties", Properties.class, false)
				.withFeature(PropertiesFeatureDescriptorEnum.comment,
						Comment_ord, true, false, false, false, false)
				.withFeature(PropertiesFeatureDescriptorEnum.defaults,
						Properties_ord, true, false, false, false, false)
				.withFeature(PropertiesFeatureDescriptorEnum.entries,
						Entries_ord);
		putCompositeEntity(
		Entries_ord, "Entries", Entries.class, false, Property_ord, false, true);
		putSimpleEntity(Property_ord, "Property", Property.class, false)
				.withFeature(PropertiesFeatureDescriptorEnum.name,
						PropertyName_ord, false, true, false, false, false)
				.withFeature(PropertiesFeatureDescriptorEnum.value,
						PropertyValue_ord);
		putDataEntity(Comment_ord, "Comment", Comment.class, false,
				String.class);
		putDataEntity(PropertyName_ord, "PropertyName", PropertyName.class,
				false, String.class);
		putDataEntity(PropertyValue_ord, "PropertyValue", PropertyValue.class,
				false, String.class);
	}
}
