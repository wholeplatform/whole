package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SchemaDirectivesAdapter extends
		AbstractListEntityAdapter<SchemaDirective> implements SchemaDirectives {
	private static final long serialVersionUID = 1;

	public SchemaDirectivesAdapter(IEntity implementor) {
		super(implementor);
	}

	public SchemaDirectivesAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SchemaDirectives> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.SchemaDirectives;
	}
}
