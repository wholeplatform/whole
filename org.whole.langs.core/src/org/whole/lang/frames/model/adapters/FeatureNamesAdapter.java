package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FeatureNamesAdapter extends
		AbstractCollectionEntityAdapter<FeatureName> implements FeatureNames {
	private static final long serialVersionUID = 1;

	public FeatureNamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureNamesAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureNames> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.FeatureNames;
	}
}
