package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DeclarationsAdapter extends AbstractListEntityAdapter<Declaration>
		implements Declarations {
	private static final long serialVersionUID = 1;

	public DeclarationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeclarationsAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Declarations> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Declarations;
	}
}
