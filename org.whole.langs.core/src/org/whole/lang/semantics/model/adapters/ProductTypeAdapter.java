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
public class ProductTypeAdapter extends AbstractListEntityAdapter<Signature>
		implements ProductType {
	private static final long serialVersionUID = 1;

	public ProductTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProductTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ProductType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.ProductType;
	}
}
