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
public class CategoriesAdapter extends AbstractListEntityAdapter<Name>
		implements Categories {
	private static final long serialVersionUID = 1;

	public CategoriesAdapter(IEntity implementor) {
		super(implementor);
	}

	public CategoriesAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Categories> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Categories;
	}
}
