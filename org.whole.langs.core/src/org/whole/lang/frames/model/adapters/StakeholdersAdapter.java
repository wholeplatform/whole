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
public class StakeholdersAdapter extends AbstractListEntityAdapter<Name>
		implements Stakeholders {
	private static final long serialVersionUID = 1;

	public StakeholdersAdapter(IEntity implementor) {
		super(implementor);
	}

	public StakeholdersAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Stakeholders> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Stakeholders;
	}
}
