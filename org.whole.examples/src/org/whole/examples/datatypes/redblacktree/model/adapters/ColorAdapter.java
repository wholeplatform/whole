package org.whole.examples.datatypes.redblacktree.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value;

/** 
 * @generator Whole
 */
public class ColorAdapter extends AbstractEntityAdapter implements Color {
	private static final long serialVersionUID = 1;

	public ColorAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColorAdapter() {
	}

	public void accept(IRedBlackTreeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Color> wGetEntityDescriptor() {
		return RedBlackTreeEntityDescriptorEnum.Color;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
