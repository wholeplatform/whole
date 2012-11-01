package org.whole.lang.testevents.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEventsGenericBuilderAdapter extends GenericIdentityBuilder {
	private ITestEventsBuilder specificBuilder;

	public TestEventsGenericBuilderAdapter(ITestEventsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public TestEventsGenericBuilderAdapter(ITestEventsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case TestEventsFeatureDescriptorEnum.maxBase_ord:
			specificBuilder.maxBase();
			break;
		case TestEventsFeatureDescriptorEnum.maxHeight_ord:
			specificBuilder.maxHeight();
			break;
		case TestEventsFeatureDescriptorEnum.numShapes_ord:
			specificBuilder.numShapes();
			break;
		case TestEventsFeatureDescriptorEnum.shape_ord:
			specificBuilder.shape();
			break;
		case TestEventsFeatureDescriptorEnum.base_ord:
			specificBuilder.base();
			break;
		case TestEventsFeatureDescriptorEnum.height_ord:
			specificBuilder.height();
			break;
		case TestEventsFeatureDescriptorEnum.area_ord:
			specificBuilder.area();
			break;
		case TestEventsFeatureDescriptorEnum.perimeter_ord:
			specificBuilder.perimeter();
			break;
		case TestEventsFeatureDescriptorEnum.simple_ord:
			specificBuilder.simple();
			break;
		case TestEventsFeatureDescriptorEnum.simpleDerived_ord:
			specificBuilder.simpleDerived();
			break;
		case TestEventsFeatureDescriptorEnum.simpleDerivedDerived_ord:
			specificBuilder.simpleDerivedDerived();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestEventsEntityDescriptorEnum.TestEvents_ord:
			specificBuilder.TestEvents();
			break;
		case TestEventsEntityDescriptorEnum.CompositeShape_ord:
			specificBuilder.CompositeShape();
			break;
		case TestEventsEntityDescriptorEnum.Rectangle_ord:
			specificBuilder.Rectangle();
			break;
		case TestEventsEntityDescriptorEnum.Labels_ord:
			specificBuilder.Labels();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestEventsEntityDescriptorEnum.TestEvents_ord:
			specificBuilder.TestEvents_();
			break;
		case TestEventsEntityDescriptorEnum.CompositeShape_ord:
			specificBuilder.CompositeShape_();
			break;
		case TestEventsEntityDescriptorEnum.Rectangle_ord:
			specificBuilder.Rectangle_();
			break;
		case TestEventsEntityDescriptorEnum.Labels_ord:
			specificBuilder.Labels_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestEventsEntityDescriptorEnum.TestEvents_ord:
			specificBuilder._TestEvents();
			break;
		case TestEventsEntityDescriptorEnum.CompositeShape_ord:
			specificBuilder._CompositeShape();
			break;
		case TestEventsEntityDescriptorEnum.Rectangle_ord:
			specificBuilder._Rectangle();
			break;
		case TestEventsEntityDescriptorEnum.Labels_ord:
			specificBuilder._Labels();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case TestEventsEntityDescriptorEnum.CompositeShape_ord:
			specificBuilder.CompositeShape_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case TestEventsEntityDescriptorEnum.Val_ord:
			specificBuilder.Val(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case TestEventsEntityDescriptorEnum.Label_ord:
			specificBuilder.Label(value);
			break;
		}
	}
}
