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
public class LocalIdentifierAdapter extends AbstractEntityAdapter implements
		LocalIdentifier {
	private static final long serialVersionUID = 1;

	public LocalIdentifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public LocalIdentifierAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LocalIdentifier> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.LocalIdentifier;
	}
}
