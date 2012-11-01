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
public class SortAdapter extends AbstractEntityAdapter implements Sort {
	private static final long serialVersionUID = 1;

	public SortAdapter(IEntity implementor) {
		super(implementor);
	}

	public SortAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Sort> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Sort;
	}

	public Level getLevel() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.level).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Level);
	}

	public void setLevel(Level level) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.level, level);
	}
}
