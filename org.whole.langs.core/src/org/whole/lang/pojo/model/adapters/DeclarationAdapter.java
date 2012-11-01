package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DeclarationAdapter extends AbstractEntityAdapter implements
		Declaration {
	private static final long serialVersionUID = 1;

	public DeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeclarationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Declaration> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Declaration;
	}
}
