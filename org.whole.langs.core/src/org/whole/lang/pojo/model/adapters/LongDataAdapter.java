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
public class LongDataAdapter extends AbstractEntityAdapter implements LongData {
	private static final long serialVersionUID = 1;

	public LongDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public LongDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LongData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.LongData;
	}

	public long getValue() {
		return wLongValue();
	}

	public void setValue(long value) {
		wSetValue(value);
	}
}
