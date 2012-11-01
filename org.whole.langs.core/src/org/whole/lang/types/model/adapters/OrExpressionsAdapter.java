package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class OrExpressionsAdapter extends
		AbstractListEntityAdapter<TypeExpressions> implements OrExpressions {
	private static final long serialVersionUID = 1;

	public OrExpressionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrExpressionsAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OrExpressions> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.OrExpressions;
	}
}
