package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class HierarchicalImpl extends AbstractSimpleEntity implements
		Hierarchical {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Hierarchical> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Hierarchical;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.Hierarchical_ord;
	}

	public void accept(IActionsVisitor visitor) {
		visitor.visit(this);
	}

	private NamingStrategy namingStrategy;

	public NamingStrategy getNamingStrategy() {
		return notifyRequested(ActionsFeatureDescriptorEnum.namingStrategy,
				namingStrategy);
	}

	public void setNamingStrategy(NamingStrategy namingStrategy) {
		notifyChanged(ActionsFeatureDescriptorEnum.namingStrategy,
				this.namingStrategy, this.namingStrategy = namingStrategy);
	}

	private Size splitSize;

	public Size getSplitSize() {
		return notifyRequested(ActionsFeatureDescriptorEnum.splitSize,
				splitSize);
	}

	public void setSplitSize(Size splitSize) {
		notifyChanged(ActionsFeatureDescriptorEnum.splitSize, this.splitSize,
				this.splitSize = splitSize);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNamingStrategy().wGetAdaptee(false);
		case 1:
			return getSplitSize().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNamingStrategy(value
					.wGetAdapter(ActionsEntityDescriptorEnum.NamingStrategy));
			break;
		case 1:
			setSplitSize(value.wGetAdapter(ActionsEntityDescriptorEnum.Size));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
