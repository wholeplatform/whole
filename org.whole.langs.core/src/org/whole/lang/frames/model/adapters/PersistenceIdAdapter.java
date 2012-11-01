package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PersistenceIdAdapter extends AbstractEntityAdapter implements
		PersistenceId {
	private static final long serialVersionUID = 1;

	public PersistenceIdAdapter(IEntity implementor) {
		super(implementor);
	}

	public PersistenceIdAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PersistenceId> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.PersistenceId;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
