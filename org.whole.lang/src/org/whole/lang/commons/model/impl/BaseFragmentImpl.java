package org.whole.lang.commons.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.commons.model.BaseFragment;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.commons.model.Phase;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.model.Any;

/** 
 * @generator Whole
 */
public class BaseFragmentImpl extends AbstractSimpleEntity implements BaseFragment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<BaseFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.BaseFragment;
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.BaseFragment_ord;
	}

	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Phase phase;

	public Phase getPhase() {
		return notifyRequested(CommonsFeatureDescriptorEnum.phase, phase);
	}

	public void setPhase(Phase phase) {
		notifyChanged(CommonsFeatureDescriptorEnum.phase, this.phase, this.phase = phase);
	}

	private Any rootEntity;

	public Any getRootEntity() {
		return notifyRequested(CommonsFeatureDescriptorEnum.rootEntity, rootEntity);
	}

	public void setRootEntity(Any rootEntity) {
		notifyChanged(CommonsFeatureDescriptorEnum.rootEntity, this.rootEntity, this.rootEntity = rootEntity);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPhase().wGetAdaptee(false);
		case 1:
			return getRootEntity().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPhase(value.wGetAdapter(CommonsEntityDescriptorEnum.Phase));
			break;
		case 1:
			setRootEntity(value.wGetAdapter(CommonsEntityDescriptorEnum.Any));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
