package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnumValuesAdapter extends AbstractListEntityAdapter<EnumValue>
		implements EnumValues {
	private static final long serialVersionUID = 1;

	public EnumValuesAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnumValuesAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnumValues> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.EnumValues;
	}
}
