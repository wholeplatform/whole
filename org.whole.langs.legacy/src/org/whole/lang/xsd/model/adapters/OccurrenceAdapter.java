package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class OccurrenceAdapter extends AbstractEntityAdapter implements
		Occurrence {
	private static final long serialVersionUID = 1;

	public OccurrenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public OccurrenceAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Occurrence> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Occurrence;
	}
}
