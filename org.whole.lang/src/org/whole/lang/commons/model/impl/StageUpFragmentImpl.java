package org.whole.lang.commons.model.impl;

import org.whole.lang.commons.model.AbstractFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;

/** 
 * @generator Whole
 */
public class StageUpFragmentImpl extends AbstractFragment implements StageUpFragment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<StageUpFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.StageUpFragment;
	}
	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.StageUpFragment_ord;
	}
    public EntityKinds wGetEntityKind() {
    	return EntityKinds.SIMPLE;//WAS STAGE_UP_FRAGMENT;
    }

	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}