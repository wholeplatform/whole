package org.whole.examples.datatypes.redblacktree.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value;

/** 
 * @generator Whole
 */
public class RedBlackTreeGenericBuilderAdapter extends GenericIdentityBuilder {
	private IRedBlackTreeBuilder specificBuilder;

	public RedBlackTreeGenericBuilderAdapter(
			IRedBlackTreeBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public RedBlackTreeGenericBuilderAdapter(
			IRedBlackTreeBuilder specificBuilder, IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case RedBlackTreeFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case RedBlackTreeFeatureDescriptorEnum.color_ord:
			specificBuilder.color();
			break;
		case RedBlackTreeFeatureDescriptorEnum.left_ord:
			specificBuilder.left();
			break;
		case RedBlackTreeFeatureDescriptorEnum.right_ord:
			specificBuilder.right();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RedBlackTreeEntityDescriptorEnum.RBNode_ord:
			specificBuilder.RBNode();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RedBlackTreeEntityDescriptorEnum.RBNode_ord:
			specificBuilder.RBNode_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RedBlackTreeEntityDescriptorEnum.RBNode_ord:
			specificBuilder._RBNode();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case RedBlackTreeEntityDescriptorEnum.Value_ord:
			specificBuilder.Value(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case RedBlackTreeEntityDescriptorEnum.Color_ord:
			specificBuilder.Color((Value) value);
			break;
		}
	}
}
