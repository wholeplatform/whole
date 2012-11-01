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
public class MutuallyExcludeAdapter extends
		AbstractCollectionEntityAdapter<FeatureName> implements MutuallyExclude {
	private static final long serialVersionUID = 1;

	public MutuallyExcludeAdapter(IEntity implementor) {
		super(implementor);
	}

	public MutuallyExcludeAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MutuallyExclude> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.MutuallyExclude;
	}
}
