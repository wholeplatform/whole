package org.whole.lang.templates.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.templates.model.*;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class NamesStrictImpl extends AbstractSetCompositeEntity<Name> implements
		Names {
	private static final long serialVersionUID = 1;

	public void accept(ITemplatesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TemplatesEntityDescriptorEnum.Names_ord;
	}

	public EntityDescriptor<Names> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.Names;
	}
}
