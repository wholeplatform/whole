package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class InputBindingsAdapter extends
		AbstractListEntityAdapter<InputBinding> implements InputBindings {
	private static final long serialVersionUID = 1;

	public InputBindingsAdapter(IEntity implementor) {
		super(implementor);
	}

	public InputBindingsAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InputBindings> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.InputBindings;
	}
}
