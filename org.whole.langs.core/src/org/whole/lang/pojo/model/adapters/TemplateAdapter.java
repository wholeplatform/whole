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
public class TemplateAdapter extends AbstractEntityAdapter implements Template {
	private static final long serialVersionUID = 1;

	public TemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplateAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Template> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Template;
	}
}
