package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NaturesAdapter extends AbstractListEntityAdapter<Nature> implements
		Natures {
	private static final long serialVersionUID = 1;

	public NaturesAdapter(IEntity implementor) {
		super(implementor);
	}

	public NaturesAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Natures> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Natures;
	}
}
