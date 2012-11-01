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
public class FolderNameAdapter extends AbstractEntityAdapter implements
		FolderName {
	private static final long serialVersionUID = 1;

	public FolderNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FolderNameAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FolderName> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.FolderName;
	}
}
