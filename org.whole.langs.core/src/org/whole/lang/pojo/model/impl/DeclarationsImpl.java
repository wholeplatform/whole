package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DeclarationsImpl extends AbstractListCompositeEntity<Declaration>
		implements Declarations {
	private static final long serialVersionUID = 1;

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.Declarations_ord;
	}

	public EntityDescriptor<Declarations> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Declarations;
	}
}
