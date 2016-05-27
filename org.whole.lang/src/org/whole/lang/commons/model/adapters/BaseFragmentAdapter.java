package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class BaseFragmentAdapter extends AbstractEntityAdapter implements BaseFragment {
	private static final long serialVersionUID = 1;

	public BaseFragmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public BaseFragmentAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BaseFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.BaseFragment;
	}

	public Phase getPhase() {
		return wGet(CommonsFeatureDescriptorEnum.phase).wGetAdapter(CommonsEntityDescriptorEnum.Phase);
	}

	public void setPhase(Phase phase) {
		wSet(CommonsFeatureDescriptorEnum.phase, phase);
	}

	public Any getRootEntity() {
		return wGet(CommonsFeatureDescriptorEnum.rootEntity).wGetAdapter(CommonsEntityDescriptorEnum.Any);
	}

	public void setRootEntity(Any rootEntity) {
		wSet(CommonsFeatureDescriptorEnum.rootEntity, rootEntity);
	}
}
