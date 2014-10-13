package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class BreakStatementAdapter extends AbstractEntityAdapter implements
		BreakStatement {
	private static final long serialVersionUID = 1;

	public BreakStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public BreakStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BreakStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BreakStatement;
	}

	public SimpleName getLabel() {
		return wGet(JavaFeatureDescriptorEnum.label).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setLabel(SimpleName label) {
		wSet(JavaFeatureDescriptorEnum.label, label);
	}
}
