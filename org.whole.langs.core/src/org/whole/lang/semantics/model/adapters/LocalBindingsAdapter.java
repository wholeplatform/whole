package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class LocalBindingsAdapter extends
		AbstractSetEntityAdapter<LocalBinding> implements LocalBindings {
	private static final long serialVersionUID = 1;

	public LocalBindingsAdapter(IEntity implementor) {
		super(implementor);
	}

	public LocalBindingsAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LocalBindings> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.LocalBindings;
	}
}
