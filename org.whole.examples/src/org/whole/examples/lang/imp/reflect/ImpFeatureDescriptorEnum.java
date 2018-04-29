package org.whole.examples.lang.imp.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class ImpFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int type_ord = 0;
	public static final int name_ord = 1;
	public static final int parameters_ord = 2;
	public static final int body_ord = 3;
	public static final int initializer_ord = 4;
	public static final int exp_ord = 5;
	public static final int condition_ord = 6;
	public static final int trueBody_ord = 7;
	public static final int falseBody_ord = 8;
	public static final int updater_ord = 9;
	public static final int arrayExp_ord = 10;
	public static final int fileName_ord = 11;
	public static final int language_ord = 12;
	public static final int arguments_ord = 13;
	public static final int lowerBound_ord = 14;
	public static final int upperBound_ord = 15;
	public static final int contentType_ord = 16;
	public static final int indexType_ord = 17;
	public static final int array_ord = 18;
	public static final int index_ord = 19;
	public static final int exp1_ord = 20;
	public static final int exp2_ord = 21;
	public static final ImpFeatureDescriptorEnum instance = new ImpFeatureDescriptorEnum();
	public static final FeatureDescriptor type = instance.valueOf(type_ord);
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor parameters = instance.valueOf(parameters_ord);
	public static final FeatureDescriptor body = instance.valueOf(body_ord);
	public static final FeatureDescriptor initializer = instance.valueOf(initializer_ord);
	public static final FeatureDescriptor exp = instance.valueOf(exp_ord);
	public static final FeatureDescriptor condition = instance.valueOf(condition_ord);
	public static final FeatureDescriptor trueBody = instance.valueOf(trueBody_ord);
	public static final FeatureDescriptor falseBody = instance.valueOf(falseBody_ord);
	public static final FeatureDescriptor updater = instance.valueOf(updater_ord);
	public static final FeatureDescriptor arrayExp = instance.valueOf(arrayExp_ord);
	public static final FeatureDescriptor fileName = instance.valueOf(fileName_ord);
	public static final FeatureDescriptor language = instance.valueOf(language_ord);
	public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
	public static final FeatureDescriptor lowerBound = instance.valueOf(lowerBound_ord);
	public static final FeatureDescriptor upperBound = instance.valueOf(upperBound_ord);
	public static final FeatureDescriptor contentType = instance.valueOf(contentType_ord);
	public static final FeatureDescriptor indexType = instance.valueOf(indexType_ord);
	public static final FeatureDescriptor array = instance.valueOf(array_ord);
	public static final FeatureDescriptor index = instance.valueOf(index_ord);
	public static final FeatureDescriptor exp1 = instance.valueOf(exp1_ord);
	public static final FeatureDescriptor exp2 = instance.valueOf(exp2_ord);

	private ImpFeatureDescriptorEnum() {
		putFeatureDescriptor(type_ord, "type");
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(parameters_ord, "parameters");
		putFeatureDescriptor(body_ord, "body");
		putFeatureDescriptor(initializer_ord, "initializer");
		putFeatureDescriptor(exp_ord, "exp");
		putFeatureDescriptor(condition_ord, "condition");
		putFeatureDescriptor(trueBody_ord, "trueBody");
		putFeatureDescriptor(falseBody_ord, "falseBody");
		putFeatureDescriptor(updater_ord, "updater");
		putFeatureDescriptor(arrayExp_ord, "arrayExp");
		putFeatureDescriptor(fileName_ord, "fileName");
		putFeatureDescriptor(language_ord, "language");
		putFeatureDescriptor(arguments_ord, "arguments");
		putFeatureDescriptor(lowerBound_ord, "lowerBound");
		putFeatureDescriptor(upperBound_ord, "upperBound");
		putFeatureDescriptor(contentType_ord, "contentType");
		putFeatureDescriptor(indexType_ord, "indexType");
		putFeatureDescriptor(array_ord, "array");
		putFeatureDescriptor(index_ord, "index");
		putFeatureDescriptor(exp1_ord, "exp1");
		putFeatureDescriptor(exp2_ord, "exp2");
	}

	private static final long serialVersionUID = 1;
}
