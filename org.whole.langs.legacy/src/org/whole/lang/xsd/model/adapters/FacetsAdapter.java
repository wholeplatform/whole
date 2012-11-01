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
public class FacetsAdapter extends AbstractListEntityAdapter<Facet> implements
		Facets {
	private static final long serialVersionUID = 1;

	public FacetsAdapter(IEntity implementor) {
		super(implementor);
	}

	public FacetsAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Facets> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Facets;
	}
}
