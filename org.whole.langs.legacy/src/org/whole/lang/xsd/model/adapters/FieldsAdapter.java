package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FieldsAdapter extends AbstractCollectionEntityAdapter<Field>
		implements Fields {
	private static final long serialVersionUID = 1;

	public FieldsAdapter(IEntity implementor) {
		super(implementor);
	}

	public FieldsAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Fields> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Fields;
	}
}
