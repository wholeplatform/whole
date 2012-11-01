package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LabelImpl extends AbstractSimpleEntity implements Label {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Label> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Label;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.Label_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Identifier name;

	public Identifier getName() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.name, name);
	}

	public void setName(Identifier name) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Identifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
