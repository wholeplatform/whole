package org.whole.lang.commons.model.impl;

import org.whole.lang.commons.model.AbstractFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;

/** 
 * @generator Whole
 */
public class StageDownFragmentImpl extends AbstractFragment implements StageDownFragment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<StageDownFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.StageDownFragment;
	}
	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.StageDownFragment_ord;
	}
    public EntityKinds wGetEntityKind() {
    	return EntityKinds.SIMPLE;//WAS STAGE_DOWN_FRAGMENT;
    }

	public void accept(ICommonsVisitor visitor) {
		visitor.visit(this);
	}
}