package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SortTypeAdapter extends AbstractEntityAdapter implements SortType {
	private static final long serialVersionUID = 1;

	public SortTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public SortTypeAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SortType> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.SortType;
	}
}
