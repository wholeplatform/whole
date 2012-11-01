package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BuiltInTypeAdapter extends AbstractEntityAdapter implements
		BuiltInType {
	private static final long serialVersionUID = 1;

	public BuiltInTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public BuiltInTypeAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BuiltInType> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.BuiltInType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
