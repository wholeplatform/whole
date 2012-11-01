package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FeatureRenameImpl extends AbstractSimpleEntity implements
		FeatureRename {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FeatureRename> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.FeatureRename;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.FeatureRename_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private FeatureName name;

	public FeatureName getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(FeatureName name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private FeatureName newName;

	public FeatureName getNewName() {
		return notifyRequested(FramesFeatureDescriptorEnum.newName, newName);
	}

	public void setNewName(FeatureName newName) {
		notifyChanged(FramesFeatureDescriptorEnum.newName, this.newName,
				this.newName = newName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getNewName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(FramesEntityDescriptorEnum.FeatureName));
			break;
		case 1:
			setNewName(value
					.wGetAdapter(FramesEntityDescriptorEnum.FeatureName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
