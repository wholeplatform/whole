package org.whole.lang.unifiedlambdadelta.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class NameAdapter extends AbstractEntityAdapter implements Name {
	private static final long serialVersionUID = 1;

	public NameAdapter(IEntity implementor) {
		super(implementor);
	}

	public NameAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Name> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Name;
	}

	public Access getAccess() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.access)
				.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Access);
	}

	public void setAccess(Access access) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.access, access);
	}

	public Prefix getPrefix() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix)
				.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Prefix);
	}

	public void setPrefix(Prefix prefix) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix, prefix);
	}

	public Postfix getPostfix() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix)
				.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Postfix);
	}

	public void setPostfix(Postfix postfix) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix, postfix);
	}
}
