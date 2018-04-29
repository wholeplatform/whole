package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IntLiteralAdapter extends AbstractEntityAdapter implements IntLiteral {
	private static final long serialVersionUID = 1;

	public IntLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntLiteralAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IntLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.IntLiteral;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
