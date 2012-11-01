package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class HierarchicalAdapter extends AbstractEntityAdapter implements
		Hierarchical {
	private static final long serialVersionUID = 1;

	public HierarchicalAdapter(IEntity implementor) {
		super(implementor);
	}

	public HierarchicalAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Hierarchical> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Hierarchical;
	}

	public NamingStrategy getNamingStrategy() {
		return wGet(ActionsFeatureDescriptorEnum.namingStrategy).wGetAdapter(
				ActionsEntityDescriptorEnum.NamingStrategy);
	}

	public void setNamingStrategy(NamingStrategy namingStrategy) {
		wSet(ActionsFeatureDescriptorEnum.namingStrategy, namingStrategy);
	}

	public Size getSplitSize() {
		return wGet(ActionsFeatureDescriptorEnum.splitSize).wGetAdapter(
				ActionsEntityDescriptorEnum.Size);
	}

	public void setSplitSize(Size splitSize) {
		wSet(ActionsFeatureDescriptorEnum.splitSize, splitSize);
	}
}
