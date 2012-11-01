package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class NameWithExtensionImpl extends AbstractSimpleEntity implements
		NameWithExtension {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NameWithExtension> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.NameWithExtension;
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.NameWithExtension_ord;
	}

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Extension extension;

	public Extension getExtension() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.extension,
				extension);
	}

	public void setExtension(Extension extension) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.extension, this.extension,
				this.extension = extension);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExtension().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Name));
			break;
		case 1:
			setExtension(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Extension));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
