package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TargetingAdapter extends AbstractEntityAdapter implements
		Targeting {
	private static final long serialVersionUID = 1;

	public TargetingAdapter(IEntity implementor) {
		super(implementor);
	}

	public TargetingAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Targeting> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Targeting;
	}

	public Identifier getTarget() {
		return wGet(JavaScriptFeatureDescriptorEnum.target).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Identifier);
	}

	public void setTarget(Identifier target) {
		wSet(JavaScriptFeatureDescriptorEnum.target, target);
	}
}
