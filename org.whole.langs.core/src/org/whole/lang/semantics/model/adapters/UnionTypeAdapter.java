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
public class UnionTypeAdapter extends AbstractListEntityAdapter<Category>
		implements UnionType {
	private static final long serialVersionUID = 1;

	public UnionTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public UnionTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UnionType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.UnionType;
	}
}
