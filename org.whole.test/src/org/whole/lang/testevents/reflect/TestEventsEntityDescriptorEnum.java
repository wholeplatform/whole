package org.whole.lang.testevents.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class TestEventsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int TestEvents_ord = 0;
	public static final int CompositeShape_ord = 1;
	public static final int Rectangle_ord = 2;
	public static final int Labels_ord = 3;
	public static final int Val_ord = 4;
	public static final int Label_ord = 5;
	public static final int Shape_ord = 6;
	public static final TestEventsEntityDescriptorEnum instance = new TestEventsEntityDescriptorEnum();
	public static final EntityDescriptor<TestEvents> TestEvents = (EntityDescriptor<TestEvents>) instance
			.valueOf(TestEvents_ord);
	public static final EntityDescriptor<CompositeShape> CompositeShape = (EntityDescriptor<CompositeShape>) instance
			.valueOf(CompositeShape_ord);
	public static final EntityDescriptor<Rectangle> Rectangle = (EntityDescriptor<Rectangle>) instance
			.valueOf(Rectangle_ord);
	public static final EntityDescriptor<Labels> Labels = (EntityDescriptor<Labels>) instance
			.valueOf(Labels_ord);
	public static final EntityDescriptor<Val> Val = (EntityDescriptor<Val>) instance
			.valueOf(Val_ord);
	public static final EntityDescriptor<Label> Label = (EntityDescriptor<Label>) instance
			.valueOf(Label_ord);
	public static final EntityDescriptor<Shape> Shape = (EntityDescriptor<Shape>) instance
			.valueOf(Shape_ord);

	private TestEventsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(TestEvents_ord, "TestEvents", TestEvents.class, false)
				.withFeature(TestEventsFeatureDescriptorEnum.maxBase, Val_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.maxHeight, Val_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.numShapes, Val_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.shape, Shape_ord);
		putCompositeEntity(
		CompositeShape_ord, "CompositeShape", CompositeShape.class, false, Shape_ord, false, true);
		putSimpleEntity(Rectangle_ord, "Rectangle", Rectangle.class, false)
				.withFeature(TestEventsFeatureDescriptorEnum.base, Val_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.height, Val_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.area, Val_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.perimeter, Val_ord);
		putSimpleEntity(Labels_ord, "Labels", Labels.class, false)
				.withFeature(TestEventsFeatureDescriptorEnum.simple, Label_ord)
				.withFeature(TestEventsFeatureDescriptorEnum.simpleDerived,
						Label_ord)
				.withFeature(
						TestEventsFeatureDescriptorEnum.simpleDerivedDerived,
						Label_ord);
		putDataEntity(Val_ord, "Val", Val.class, false, int.class);
		putDataEntity(Label_ord, "Label", Label.class, false, String.class);
		putSimpleEntity(Shape_ord, "Shape", Shape.class, true,
				CompositeShape_ord, Labels_ord, Rectangle_ord);
	}
}
