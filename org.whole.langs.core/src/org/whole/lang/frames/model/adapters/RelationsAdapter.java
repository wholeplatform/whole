package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RelationsAdapter extends AbstractListEntityAdapter<Relation>
		implements Relations {
	private static final long serialVersionUID = 1;

	public RelationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public RelationsAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Relations> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Relations;
	}
}
