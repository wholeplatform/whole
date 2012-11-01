package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionAdapter extends AbstractEntityAdapter implements Version {
	private static final long serialVersionUID = 1;

	public VersionAdapter(IEntity implementor) {
		super(implementor);
	}

	public VersionAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Version> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Version;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
