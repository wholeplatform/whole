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
public class ChooseTemplateAdapter extends AbstractListEntityAdapter<Case>
		implements ChooseTemplate {
	private static final long serialVersionUID = 1;

	public ChooseTemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public ChooseTemplateAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ChooseTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.ChooseTemplate;
	}
}
