package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SpaceAdapter extends AbstractEntityAdapter implements Space {
	private static final long serialVersionUID = 1;

	public SpaceAdapter(IEntity implementor) {
		super(implementor);
	}

	public SpaceAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Space> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Space;
	}
}
