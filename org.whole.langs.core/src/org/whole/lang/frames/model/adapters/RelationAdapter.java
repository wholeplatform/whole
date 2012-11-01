package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RelationAdapter extends AbstractEntityAdapter implements Relation {
	private static final long serialVersionUID = 1;

	public RelationAdapter(IEntity implementor) {
		super(implementor);
	}

	public RelationAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Relation> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Relation;
	}
}
