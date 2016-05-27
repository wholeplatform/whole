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
public class StageUpFragmentAdapter extends AbstractEntityAdapter implements StageUpFragment {
	private static final long serialVersionUID = 1;

	public StageUpFragmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public StageUpFragmentAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StageUpFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.StageUpFragment;
	}

	public Any getRootEntity() {
		return wGet(CommonsFeatureDescriptorEnum.rootEntity).wGetAdapter(CommonsEntityDescriptorEnum.Any);
	}

	public void setRootEntity(Any rootEntity) {
		wSet(CommonsFeatureDescriptorEnum.rootEntity, rootEntity);
	}
}
