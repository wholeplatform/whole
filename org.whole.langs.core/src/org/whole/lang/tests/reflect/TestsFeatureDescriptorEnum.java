package org.whole.lang.tests.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class TestsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int packageName_ord = 0;
	public static final int description_ord = 1;
	public static final int name_ord = 2;
	public static final int deployer_ord = 3;
	public static final int filterFamilies_ord = 4;
	public static final int testCases_ord = 5;
	public static final int filterRules_ord = 6;
	public static final int body_ord = 7;
	public static final int aspects_ord = 8;
	public static final int tests_ord = 9;
	public static final int kind_ord = 10;
	public static final int filter_ord = 11;
	public static final int subjectStatement_ord = 12;
	public static final int subject_ord = 13;
	public static final int constraint_ord = 14;
	public static final int descriptorName_ord = 15;
	public static final int throwableType_ord = 16;
	public static final int object_ord = 17;
	public static final TestsFeatureDescriptorEnum instance = new TestsFeatureDescriptorEnum();
	public static final FeatureDescriptor packageName = instance
			.valueOf(packageName_ord);
	public static final FeatureDescriptor description = instance
			.valueOf(description_ord);
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor deployer = instance
			.valueOf(deployer_ord);
	public static final FeatureDescriptor filterFamilies = instance
			.valueOf(filterFamilies_ord);
	public static final FeatureDescriptor testCases = instance
			.valueOf(testCases_ord);
	public static final FeatureDescriptor filterRules = instance
			.valueOf(filterRules_ord);
	public static final FeatureDescriptor body = instance.valueOf(body_ord);
	public static final FeatureDescriptor aspects = instance
			.valueOf(aspects_ord);
	public static final FeatureDescriptor tests = instance.valueOf(tests_ord);
	public static final FeatureDescriptor kind = instance.valueOf(kind_ord);
	public static final FeatureDescriptor filter = instance.valueOf(filter_ord);
	public static final FeatureDescriptor subjectStatement = instance
			.valueOf(subjectStatement_ord);
	public static final FeatureDescriptor subject = instance
			.valueOf(subject_ord);
	public static final FeatureDescriptor constraint = instance
			.valueOf(constraint_ord);
	public static final FeatureDescriptor descriptorName = instance
			.valueOf(descriptorName_ord);
	public static final FeatureDescriptor throwableType = instance
			.valueOf(throwableType_ord);
	public static final FeatureDescriptor object = instance.valueOf(object_ord);

	private TestsFeatureDescriptorEnum() {
		putFeatureDescriptor(packageName_ord, "packageName");
		putFeatureDescriptor(description_ord, "description");
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(deployer_ord, "deployer");
		putFeatureDescriptor(filterFamilies_ord, "filterFamilies");
		putFeatureDescriptor(testCases_ord, "testCases");
		putFeatureDescriptor(filterRules_ord, "filterRules");
		putFeatureDescriptor(body_ord, "body");
		putFeatureDescriptor(aspects_ord, "aspects");
		putFeatureDescriptor(tests_ord, "tests");
		putFeatureDescriptor(kind_ord, "kind");
		putFeatureDescriptor(filter_ord, "filter");
		putFeatureDescriptor(subjectStatement_ord, "subjectStatement");
		putFeatureDescriptor(subject_ord, "subject");
		putFeatureDescriptor(constraint_ord, "constraint");
		putFeatureDescriptor(descriptorName_ord, "descriptorName");
		putFeatureDescriptor(throwableType_ord, "throwableType");
		putFeatureDescriptor(object_ord, "object");
	}

	private static final long serialVersionUID = 1;
}
