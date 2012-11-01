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
public class MemberTypesAdapter extends AbstractCollectionEntityAdapter<QName>
		implements MemberTypes {
	private static final long serialVersionUID = 1;

	public MemberTypesAdapter(IEntity implementor) {
		super(implementor);
	}

	public MemberTypesAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MemberTypes> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.MemberTypes;
	}
}
