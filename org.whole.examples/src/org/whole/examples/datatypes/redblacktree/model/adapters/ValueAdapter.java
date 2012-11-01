package org.whole.examples.datatypes.redblacktree.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ValueAdapter extends AbstractEntityAdapter implements Value {
	private static final long serialVersionUID = 1;

	public ValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public ValueAdapter() {
	}

	public void accept(IRedBlackTreeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Value> wGetEntityDescriptor() {
		return RedBlackTreeEntityDescriptorEnum.Value;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
