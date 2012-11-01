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
public class NameImpl extends AbstractSimpleEntity implements Name {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Name> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Name;
	}

	public int wGetEntityOrd() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Name_ord;
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		visitor.visit(this);
	}

	private Access access;

	public Access getAccess() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.access,
				access);
	}

	public void setAccess(Access access) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.access,
				this.access, this.access = access);
	}

	private Prefix prefix;

	public Prefix getPrefix() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix,
				prefix);
	}

	public void setPrefix(Prefix prefix) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix,
				this.prefix, this.prefix = prefix);
	}

	private Postfix postfix;

	public Postfix getPostfix() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix,
				postfix);
	}

	public void setPostfix(Postfix postfix) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix,
				this.postfix, this.postfix = postfix);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAccess().wGetAdaptee(false);
		case 1:
			return getPrefix().wGetAdaptee(false);
		case 2:
			return getPostfix().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAccess(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Access));
			break;
		case 1:
			setPrefix(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Prefix));
			break;
		case 2:
			setPostfix(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Postfix));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
