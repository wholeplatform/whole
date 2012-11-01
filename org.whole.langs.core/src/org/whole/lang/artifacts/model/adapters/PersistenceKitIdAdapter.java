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
public class PersistenceKitIdAdapter extends AbstractEntityAdapter implements
		PersistenceKitId {
	private static final long serialVersionUID = 1;

	public PersistenceKitIdAdapter(IEntity implementor) {
		super(implementor);
	}

	public PersistenceKitIdAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PersistenceKitId> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.PersistenceKitId;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
