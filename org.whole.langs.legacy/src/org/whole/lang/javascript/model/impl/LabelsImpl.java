package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LabelsImpl extends AbstractListCompositeEntity<Label> implements
		Labels {
	private static final long serialVersionUID = 1;

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.Labels_ord;
	}

	public EntityDescriptor<Labels> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Labels;
	}
}
