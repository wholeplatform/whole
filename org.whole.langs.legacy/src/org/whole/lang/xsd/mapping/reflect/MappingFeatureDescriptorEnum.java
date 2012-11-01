package org.whole.lang.xsd.mapping.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class MappingFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int namespace_ord = 0;
	public static final int schemaLocation_ord = 1;
	public static final int synthesized_ord = 2;
	public static final int elementsFormQualified_ord = 3;
	public static final int attributesFormQualified_ord = 4;
	public static final int mixedDataType_ord = 5;
	public static final int mixedTypes_ord = 6;
	public static final int mappings_ord = 7;
	public static final int dataTypes_ord = 8;
	public static final int name_ord = 9;
	public static final int entityType_ord = 10;
	public static final int contextEntityType_ord = 11;
	public static final int featureType_ord = 12;
	public static final int unionTypes_ord = 13;
	public static final int enumValues_ord = 14;
	public static final int enumValue_ord = 15;
	public static final int value_ord = 16;
	public static final int builtInType_ord = 17;
	public static final MappingFeatureDescriptorEnum instance = new MappingFeatureDescriptorEnum();
	public static final FeatureDescriptor namespace = instance
			.valueOf(namespace_ord);
	public static final FeatureDescriptor schemaLocation = instance
			.valueOf(schemaLocation_ord);
	public static final FeatureDescriptor synthesized = instance
			.valueOf(synthesized_ord);
	public static final FeatureDescriptor elementsFormQualified = instance
			.valueOf(elementsFormQualified_ord);
	public static final FeatureDescriptor attributesFormQualified = instance
			.valueOf(attributesFormQualified_ord);
	public static final FeatureDescriptor mixedDataType = instance
			.valueOf(mixedDataType_ord);
	public static final FeatureDescriptor mixedTypes = instance
			.valueOf(mixedTypes_ord);
	public static final FeatureDescriptor mappings = instance
			.valueOf(mappings_ord);
	public static final FeatureDescriptor dataTypes = instance
			.valueOf(dataTypes_ord);
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor entityType = instance
			.valueOf(entityType_ord);
	public static final FeatureDescriptor contextEntityType = instance
			.valueOf(contextEntityType_ord);
	public static final FeatureDescriptor featureType = instance
			.valueOf(featureType_ord);
	public static final FeatureDescriptor unionTypes = instance
			.valueOf(unionTypes_ord);
	public static final FeatureDescriptor enumValues = instance
			.valueOf(enumValues_ord);
	public static final FeatureDescriptor enumValue = instance
			.valueOf(enumValue_ord);
	public static final FeatureDescriptor value = instance.valueOf(value_ord);
	public static final FeatureDescriptor builtInType = instance
			.valueOf(builtInType_ord);

	private MappingFeatureDescriptorEnum() {
		putFeatureDescriptor(namespace_ord, "namespace");
		putFeatureDescriptor(schemaLocation_ord, "schemaLocation");
		putFeatureDescriptor(synthesized_ord, "synthesized");
		putFeatureDescriptor(elementsFormQualified_ord, "elementsFormQualified");
		putFeatureDescriptor(attributesFormQualified_ord,
				"attributesFormQualified");
		putFeatureDescriptor(mixedDataType_ord, "mixedDataType");
		putFeatureDescriptor(mixedTypes_ord, "mixedTypes");
		putFeatureDescriptor(mappings_ord, "mappings");
		putFeatureDescriptor(dataTypes_ord, "dataTypes");
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(entityType_ord, "entityType");
		putFeatureDescriptor(contextEntityType_ord, "contextEntityType");
		putFeatureDescriptor(featureType_ord, "featureType");
		putFeatureDescriptor(unionTypes_ord, "unionTypes");
		putFeatureDescriptor(enumValues_ord, "enumValues");
		putFeatureDescriptor(enumValue_ord, "enumValue");
		putFeatureDescriptor(value_ord, "value");
		putFeatureDescriptor(builtInType_ord, "builtInType");
	}

	private static final long serialVersionUID = 1;
}
