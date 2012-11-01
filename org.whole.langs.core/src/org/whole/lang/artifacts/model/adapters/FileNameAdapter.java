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
public class FileNameAdapter extends AbstractEntityAdapter implements FileName {
	private static final long serialVersionUID = 1;

	public FileNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FileNameAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FileName> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.FileName;
	}
}
