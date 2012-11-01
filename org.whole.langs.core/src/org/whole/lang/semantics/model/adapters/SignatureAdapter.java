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
public class SignatureAdapter extends AbstractEntityAdapter implements
		Signature {
	private static final long serialVersionUID = 1;

	public SignatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public SignatureAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Signature> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Signature;
	}
}
