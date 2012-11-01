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
public class LabelAdapter extends AbstractEntityAdapter implements Label {
	private static final long serialVersionUID = 1;

	public LabelAdapter(IEntity implementor) {
		super(implementor);
	}

	public LabelAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Label> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Label;
	}

	public Identifier getName() {
		return wGet(JavaScriptFeatureDescriptorEnum.name).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Identifier);
	}

	public void setName(Identifier name) {
		wSet(JavaScriptFeatureDescriptorEnum.name, name);
	}
}
