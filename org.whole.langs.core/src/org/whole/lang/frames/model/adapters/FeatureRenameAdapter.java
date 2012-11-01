package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FeatureRenameAdapter extends AbstractEntityAdapter implements
		FeatureRename {
	private static final long serialVersionUID = 1;

	public FeatureRenameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureRenameAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureRename> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.FeatureRename;
	}

	public FeatureName getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setName(FeatureName name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public FeatureName getNewName() {
		return wGet(FramesFeatureDescriptorEnum.newName).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setNewName(FeatureName newName) {
		wSet(FramesFeatureDescriptorEnum.newName, newName);
	}
}
