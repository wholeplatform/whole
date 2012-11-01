package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class QualifiedNameAdapter extends AbstractEntityAdapter implements
		QualifiedName {
	private static final long serialVersionUID = 1;

	public QualifiedNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public QualifiedNameAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QualifiedName> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.QualifiedName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
