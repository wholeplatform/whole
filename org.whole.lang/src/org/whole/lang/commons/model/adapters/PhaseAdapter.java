package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PhaseAdapter extends AbstractEntityAdapter implements Phase {
	private static final long serialVersionUID = 1;

	public PhaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public PhaseAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Phase> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Phase;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
