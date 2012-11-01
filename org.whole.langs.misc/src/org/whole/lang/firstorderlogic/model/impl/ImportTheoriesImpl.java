package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ImportTheoriesImpl extends
		AbstractListCompositeEntity<ImportDeclaration> implements
		ImportTheories {
	private static final long serialVersionUID = 1;

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.ImportTheories_ord;
	}

	public EntityDescriptor<ImportTheories> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.ImportTheories;
	}
}
