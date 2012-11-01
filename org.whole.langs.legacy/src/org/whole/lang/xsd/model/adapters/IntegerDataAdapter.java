package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import java.math.BigInteger;

/** 
 * @generator Whole
 */
public class IntegerDataAdapter extends AbstractEntityAdapter implements
		IntegerData {
	private static final long serialVersionUID = 1;

	public IntegerDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntegerDataAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IntegerData> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.IntegerData;
	}

	public BigInteger getValue() {
		return (BigInteger) wGetValue();
	}

	public void setValue(BigInteger value) {
		wSetValue((Object) value);
	}
}
