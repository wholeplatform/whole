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
public class PackageNameAdapter extends AbstractEntityAdapter implements
		PackageName {
	private static final long serialVersionUID = 1;

	public PackageNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public PackageNameAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PackageName> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.PackageName;
	}
}
