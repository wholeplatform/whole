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
public class PropertyValuePairsAdapter extends
		AbstractListEntityAdapter<Constructors> implements PropertyValuePairs {
	private static final long serialVersionUID = 1;

	public PropertyValuePairsAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertyValuePairsAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PropertyValuePairs> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.PropertyValuePairs;
	}
}
