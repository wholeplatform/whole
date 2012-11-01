package org.whole.lang.scheme.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class SchemeFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int name_ord = 0;
	public static final int expression_ord = 1;
	public static final int test_ord = 2;
	public static final int body_ord = 3;
	public static final int expressions_ord = 4;
	public static final int args_ord = 5;
	public static final int branches_ord = 6;
	public static final int elseBody_ord = 7;
	public static final int definitions_ord = 8;
	public static final int env_ord = 9;
	public static final int car_ord = 10;
	public static final int cdr_ord = 11;
	public static final SchemeFeatureDescriptorEnum instance = new SchemeFeatureDescriptorEnum();
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor expression = instance
			.valueOf(expression_ord);
	public static final FeatureDescriptor test = instance.valueOf(test_ord);
	public static final FeatureDescriptor body = instance.valueOf(body_ord);
	public static final FeatureDescriptor expressions = instance
			.valueOf(expressions_ord);
	public static final FeatureDescriptor args = instance.valueOf(args_ord);
	public static final FeatureDescriptor branches = instance
			.valueOf(branches_ord);
	public static final FeatureDescriptor elseBody = instance
			.valueOf(elseBody_ord);
	public static final FeatureDescriptor definitions = instance
			.valueOf(definitions_ord);
	public static final FeatureDescriptor env = instance.valueOf(env_ord);
	public static final FeatureDescriptor car = instance.valueOf(car_ord);
	public static final FeatureDescriptor cdr = instance.valueOf(cdr_ord);

	private SchemeFeatureDescriptorEnum() {
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(expression_ord, "expression");
		putFeatureDescriptor(test_ord, "test");
		putFeatureDescriptor(body_ord, "body");
		putFeatureDescriptor(expressions_ord, "expressions");
		putFeatureDescriptor(args_ord, "args");
		putFeatureDescriptor(branches_ord, "branches");
		putFeatureDescriptor(elseBody_ord, "elseBody");
		putFeatureDescriptor(definitions_ord, "definitions");
		putFeatureDescriptor(env_ord, "env");
		putFeatureDescriptor(car_ord, "car");
		putFeatureDescriptor(cdr_ord, "cdr");
	}

	private static final long serialVersionUID = 1;
}
