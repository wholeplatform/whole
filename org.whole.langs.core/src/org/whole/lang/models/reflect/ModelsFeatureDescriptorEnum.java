package org.whole.lang.models.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class ModelsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int name_ord = 0;
	public static final int typeRelations_ord = 1;
	public static final int declarations_ord = 2;
	public static final int namespace_ord = 3;
	public static final int version_ord = 4;
	public static final int uri_ord = 5;
	public static final int modifiers_ord = 6;
	public static final int types_ord = 7;
	public static final int features_ord = 8;
	public static final int componentModifiers_ord = 9;
	public static final int componentType_ord = 10;
	public static final int keyType_ord = 11;
	public static final int valueType_ord = 12;
	public static final int dataType_ord = 13;
	public static final int values_ord = 14;
	public static final int type_ord = 15;
	public static final int oppositeName_ord = 16;
	public static final int foreignType_ord = 17;
	public static final ModelsFeatureDescriptorEnum instance = new ModelsFeatureDescriptorEnum();
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor typeRelations = instance
			.valueOf(typeRelations_ord);
	public static final FeatureDescriptor declarations = instance
			.valueOf(declarations_ord);
	public static final FeatureDescriptor namespace = instance
			.valueOf(namespace_ord);
	public static final FeatureDescriptor version = instance
			.valueOf(version_ord);
	public static final FeatureDescriptor uri = instance.valueOf(uri_ord);
	public static final FeatureDescriptor modifiers = instance
			.valueOf(modifiers_ord);
	public static final FeatureDescriptor types = instance.valueOf(types_ord);
	public static final FeatureDescriptor features = instance
			.valueOf(features_ord);
	public static final FeatureDescriptor componentModifiers = instance
			.valueOf(componentModifiers_ord);
	public static final FeatureDescriptor componentType = instance
			.valueOf(componentType_ord);
	public static final FeatureDescriptor keyType = instance
			.valueOf(keyType_ord);
	public static final FeatureDescriptor valueType = instance
			.valueOf(valueType_ord);
	public static final FeatureDescriptor dataType = instance
			.valueOf(dataType_ord);
	public static final FeatureDescriptor values = instance.valueOf(values_ord);
	public static final FeatureDescriptor type = instance.valueOf(type_ord);
	public static final FeatureDescriptor oppositeName = instance
			.valueOf(oppositeName_ord);
	public static final FeatureDescriptor foreignType = instance
			.valueOf(foreignType_ord);

	private ModelsFeatureDescriptorEnum() {
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(typeRelations_ord, "typeRelations");
		putFeatureDescriptor(declarations_ord, "declarations");
		putFeatureDescriptor(namespace_ord, "namespace");
		putFeatureDescriptor(version_ord, "version");
		putFeatureDescriptor(uri_ord, "uri");
		putFeatureDescriptor(modifiers_ord, "modifiers");
		putFeatureDescriptor(types_ord, "types");
		putFeatureDescriptor(features_ord, "features");
		putFeatureDescriptor(componentModifiers_ord, "componentModifiers");
		putFeatureDescriptor(componentType_ord, "componentType");
		putFeatureDescriptor(keyType_ord, "keyType");
		putFeatureDescriptor(valueType_ord, "valueType");
		putFeatureDescriptor(dataType_ord, "dataType");
		putFeatureDescriptor(values_ord, "values");
		putFeatureDescriptor(type_ord, "type");
		putFeatureDescriptor(oppositeName_ord, "oppositeName");
		putFeatureDescriptor(foreignType_ord, "foreignType");
	}

	private static final long serialVersionUID = 1;
}
