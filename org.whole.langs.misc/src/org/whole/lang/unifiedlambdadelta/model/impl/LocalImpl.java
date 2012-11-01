package org.whole.lang.unifiedlambdadelta.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LocalImpl extends AbstractSimpleEntity implements Local {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Local> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Local;
	}

	public int wGetEntityOrd() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Local_ord;
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		visitor.visit(this);
	}

	private Index index;

	public Index getIndex() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.index,
				index);
	}

	public void setIndex(Index index) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.index,
				this.index, this.index = index);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIndex().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIndex(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Index));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
