package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AttributesAdapter extends AbstractSetEntityAdapter<Attribute>
		implements Attributes {
	private static final long serialVersionUID = 1;

	public AttributesAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributesAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Attributes> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Attributes;
	}
}
