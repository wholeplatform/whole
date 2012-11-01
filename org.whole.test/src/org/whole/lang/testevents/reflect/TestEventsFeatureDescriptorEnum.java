package org.whole.lang.testevents.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class TestEventsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int maxBase_ord = 0;
	public static final int maxHeight_ord = 1;
	public static final int numShapes_ord = 2;
	public static final int shape_ord = 3;
	public static final int base_ord = 4;
	public static final int height_ord = 5;
	public static final int area_ord = 6;
	public static final int perimeter_ord = 7;
	public static final int simple_ord = 8;
	public static final int simpleDerived_ord = 9;
	public static final int simpleDerivedDerived_ord = 10;
	public static final TestEventsFeatureDescriptorEnum instance = new TestEventsFeatureDescriptorEnum();
	public static final FeatureDescriptor maxBase = instance
			.valueOf(maxBase_ord);
	public static final FeatureDescriptor maxHeight = instance
			.valueOf(maxHeight_ord);
	public static final FeatureDescriptor numShapes = instance
			.valueOf(numShapes_ord);
	public static final FeatureDescriptor shape = instance.valueOf(shape_ord);
	public static final FeatureDescriptor base = instance.valueOf(base_ord);
	public static final FeatureDescriptor height = instance.valueOf(height_ord);
	public static final FeatureDescriptor area = instance.valueOf(area_ord);
	public static final FeatureDescriptor perimeter = instance
			.valueOf(perimeter_ord);
	public static final FeatureDescriptor simple = instance.valueOf(simple_ord);
	public static final FeatureDescriptor simpleDerived = instance
			.valueOf(simpleDerived_ord);
	public static final FeatureDescriptor simpleDerivedDerived = instance
			.valueOf(simpleDerivedDerived_ord);

	private TestEventsFeatureDescriptorEnum() {
		putFeatureDescriptor(maxBase_ord, "maxBase");
		putFeatureDescriptor(maxHeight_ord, "maxHeight");
		putFeatureDescriptor(numShapes_ord, "numShapes");
		putFeatureDescriptor(shape_ord, "shape");
		putFeatureDescriptor(base_ord, "base");
		putFeatureDescriptor(height_ord, "height");
		putFeatureDescriptor(area_ord, "area");
		putFeatureDescriptor(perimeter_ord, "perimeter");
		putFeatureDescriptor(simple_ord, "simple");
		putFeatureDescriptor(simpleDerived_ord, "simpleDerived");
		putFeatureDescriptor(simpleDerivedDerived_ord, "simpleDerivedDerived");
	}

	private static final long serialVersionUID = 1;
}
