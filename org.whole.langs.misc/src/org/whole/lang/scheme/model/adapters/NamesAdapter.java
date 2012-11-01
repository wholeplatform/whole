package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NamesAdapter extends AbstractListEntityAdapter<Name> implements
		Names {
	private static final long serialVersionUID = 1;

	public NamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public NamesAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Names> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Names;
	}
}
