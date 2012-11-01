package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IDataEntityAdapter extends AbstractEntityAdapter implements
		IDataEntity {
	private static final long serialVersionUID = 1;

	public IDataEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public IDataEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IDataEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.IDataEntity;
	}
}
