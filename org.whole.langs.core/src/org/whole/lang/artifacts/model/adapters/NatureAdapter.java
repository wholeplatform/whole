package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NatureAdapter extends AbstractEntityAdapter implements Nature {
	private static final long serialVersionUID = 1;

	public NatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public NatureAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Nature> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Nature;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
