package org.whole.lang.flowchart.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class FlowchartFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int nodes_ord = 0;
	public static final int transitions_ord = 1;
	public static final int source_ord = 2;
	public static final int target_ord = 3;
	public static final int label_ord = 4;
	public static final int x_ord = 5;
	public static final int y_ord = 6;
	public static final int width_ord = 7;
	public static final int height_ord = 8;
	public static final int description_ord = 9;
	public static final int sourceTransition_ord = 10;
	public static final int targetTransition_ord = 11;
	public static final int trueSourceTransition_ord = 12;
	public static final int falseSourceTransition_ord = 13;
	public static final int targetTransitions_ord = 14;
	public static final FlowchartFeatureDescriptorEnum instance = new FlowchartFeatureDescriptorEnum();
	public static final FeatureDescriptor nodes = instance.valueOf(nodes_ord);
	public static final FeatureDescriptor transitions = instance
			.valueOf(transitions_ord);
	public static final FeatureDescriptor source = instance.valueOf(source_ord);
	public static final FeatureDescriptor target = instance.valueOf(target_ord);
	public static final FeatureDescriptor label = instance.valueOf(label_ord);
	public static final FeatureDescriptor x = instance.valueOf(x_ord);
	public static final FeatureDescriptor y = instance.valueOf(y_ord);
	public static final FeatureDescriptor width = instance.valueOf(width_ord);
	public static final FeatureDescriptor height = instance.valueOf(height_ord);
	public static final FeatureDescriptor description = instance
			.valueOf(description_ord);
	public static final FeatureDescriptor sourceTransition = instance
			.valueOf(sourceTransition_ord);
	public static final FeatureDescriptor targetTransition = instance
			.valueOf(targetTransition_ord);
	public static final FeatureDescriptor trueSourceTransition = instance
			.valueOf(trueSourceTransition_ord);
	public static final FeatureDescriptor falseSourceTransition = instance
			.valueOf(falseSourceTransition_ord);
	public static final FeatureDescriptor targetTransitions = instance
			.valueOf(targetTransitions_ord);

	private FlowchartFeatureDescriptorEnum() {
		putFeatureDescriptor(nodes_ord, "nodes");
		putFeatureDescriptor(transitions_ord, "transitions");
		putFeatureDescriptor(source_ord, "source");
		putFeatureDescriptor(target_ord, "target");
		putFeatureDescriptor(label_ord, "label");
		putFeatureDescriptor(x_ord, "x");
		putFeatureDescriptor(y_ord, "y");
		putFeatureDescriptor(width_ord, "width");
		putFeatureDescriptor(height_ord, "height");
		putFeatureDescriptor(description_ord, "description");
		putFeatureDescriptor(sourceTransition_ord, "sourceTransition");
		putFeatureDescriptor(targetTransition_ord, "targetTransition");
		putFeatureDescriptor(trueSourceTransition_ord, "trueSourceTransition");
		putFeatureDescriptor(falseSourceTransition_ord, "falseSourceTransition");
		putFeatureDescriptor(targetTransitions_ord, "targetTransitions");
	}

	private static final long serialVersionUID = 1;
}
