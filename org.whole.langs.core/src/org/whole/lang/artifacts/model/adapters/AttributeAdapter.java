package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.model.AttributeEnum.Value;

/** 
 * @generator Whole
 */
public class AttributeAdapter extends AbstractEntityAdapter implements
		Attribute {
	private static final long serialVersionUID = 1;

	public AttributeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Attribute> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Attribute;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
