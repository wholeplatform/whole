package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractMapEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MapTestEntityAdapter extends
		AbstractMapEntityAdapter<ITestEntity, IStructuralEntity> implements
		MapTestEntity {
	private static final long serialVersionUID = 1;

	public MapTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public MapTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MapTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.MapTestEntity;
	}
}
