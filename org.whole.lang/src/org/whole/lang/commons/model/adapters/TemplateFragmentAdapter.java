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
public class TemplateFragmentAdapter extends AbstractEntityAdapter implements TemplateFragment {
	private static final long serialVersionUID = 1;

	public TemplateFragmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplateFragmentAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TemplateFragment> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.TemplateFragment;
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
