package org.whole.lang.templates.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.templates.model.*;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TemplatesImpl extends AbstractListCompositeEntity<TemplateFactory>
		implements Templates {
	private static final long serialVersionUID = 1;

	public void accept(ITemplatesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TemplatesEntityDescriptorEnum.Templates_ord;
	}

	public EntityDescriptor<Templates> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.Templates;
	}
}
