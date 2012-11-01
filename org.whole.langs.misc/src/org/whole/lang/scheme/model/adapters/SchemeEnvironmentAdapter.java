package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.bindings.IBindingManager;

/** 
 * @generator Whole
 */
public class SchemeEnvironmentAdapter extends AbstractEntityAdapter implements
		SchemeEnvironment {
	private static final long serialVersionUID = 1;

	public SchemeEnvironmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public SchemeEnvironmentAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SchemeEnvironment> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.SchemeEnvironment;
	}

	public IBindingManager getValue() {
		return (IBindingManager) wGetValue();
	}

	public void setValue(IBindingManager value) {
		wSetValue((Object) value);
	}
}
