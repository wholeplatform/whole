package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ByteDataAdapter extends AbstractEntityAdapter implements ByteData {
	private static final long serialVersionUID = 1;

	public ByteDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public ByteDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ByteData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.ByteData;
	}

	public byte getValue() {
		return wByteValue();
	}

	public void setValue(byte value) {
		wSetValue(value);
	}
}
