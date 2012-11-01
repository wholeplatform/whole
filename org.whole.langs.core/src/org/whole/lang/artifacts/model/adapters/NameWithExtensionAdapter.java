package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class NameWithExtensionAdapter extends AbstractEntityAdapter implements
		NameWithExtension {
	private static final long serialVersionUID = 1;

	public NameWithExtensionAdapter(IEntity implementor) {
		super(implementor);
	}

	public NameWithExtensionAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NameWithExtension> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.NameWithExtension;
	}

	public Name getName() {
		return wGet(ArtifactsFeatureDescriptorEnum.name).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public Extension getExtension() {
		return wGet(ArtifactsFeatureDescriptorEnum.extension).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Extension);
	}

	public void setExtension(Extension extension) {
		wSet(ArtifactsFeatureDescriptorEnum.extension, extension);
	}
}
