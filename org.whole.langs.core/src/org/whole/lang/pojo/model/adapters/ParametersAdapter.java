package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ParametersAdapter extends AbstractListEntityAdapter<Parameter>
		implements Parameters {
	private static final long serialVersionUID = 1;

	public ParametersAdapter(IEntity implementor) {
		super(implementor);
	}

	public ParametersAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Parameters> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Parameters;
	}
}
