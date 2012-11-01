package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnvironmentTypeAdapter extends AbstractEntityAdapter implements
		EnvironmentType {
	private static final long serialVersionUID = 1;

	public EnvironmentTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnvironmentTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnvironmentType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.EnvironmentType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
