package org.whole.lang.templates.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SimpleNameAdapter extends AbstractEntityAdapter implements
		SimpleName {
	private static final long serialVersionUID = 1;

	public SimpleNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleNameAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleName> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.SimpleName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
