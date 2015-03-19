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
public class SortImpl extends AbstractSimpleEntity implements Sort {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Sort> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Sort;
	}

	public int wGetEntityOrd() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Sort_ord;
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Level level;

	public Level getLevel() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.level,
				level);
	}

	public void setLevel(Level level) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.level,
				this.level, this.level = level);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLevel().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLevel(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Level));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
