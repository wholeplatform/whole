package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArrayLiteralAdapter extends AbstractListEntityAdapter<Literal> implements ArrayLiteral {
	private static final long serialVersionUID = 1;

	public ArrayLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayLiteralAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ArrayLiteral;
	}
}
