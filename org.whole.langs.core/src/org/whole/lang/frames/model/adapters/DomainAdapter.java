package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.model.DomainEnum.Value;

/** 
 * @generator Whole
 */
public class DomainAdapter extends AbstractEntityAdapter implements Domain {
	private static final long serialVersionUID = 1;

	public DomainAdapter(IEntity implementor) {
		super(implementor);
	}

	public DomainAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Domain> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Domain;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
