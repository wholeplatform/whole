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
public class ReferenceTypeAdapter extends AbstractEntityAdapter implements
		ReferenceType {
	private static final long serialVersionUID = 1;

	public ReferenceTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ReferenceTypeAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ReferenceType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.ReferenceType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
