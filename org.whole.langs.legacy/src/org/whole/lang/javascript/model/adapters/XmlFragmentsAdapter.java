package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class XmlFragmentsAdapter extends AbstractListEntityAdapter<XmlFragment>
		implements XmlFragments {
	private static final long serialVersionUID = 1;

	public XmlFragmentsAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlFragmentsAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlFragments> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlFragments;
	}
}
