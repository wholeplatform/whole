package org.whole.lang.commons.model.impl;

import org.whole.lang.commons.model.AbstractFragment;
import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;

/** 
 * @generator Whole
 */
public class SameStageFragmentImpl extends AbstractFragment implements SameStageFragment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SameStageFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.SameStageFragment;
	}
	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.SameStageFragment_ord;
	}
    public EntityKinds wGetEntityKind() {
    	return EntityKinds.SIMPLE;//WAS SAME_STAGE_FRAGMENT;
    }

	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}