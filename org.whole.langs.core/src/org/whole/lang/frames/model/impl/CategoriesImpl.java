package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CategoriesImpl extends AbstractListCompositeEntity<Name> implements
		Categories {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Categories_ord;
	}

	public EntityDescriptor<Categories> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Categories;
	}
}
