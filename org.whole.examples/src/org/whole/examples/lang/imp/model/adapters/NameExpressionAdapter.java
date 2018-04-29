package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NameExpressionAdapter extends AbstractEntityAdapter implements NameExpression {
	private static final long serialVersionUID = 1;

	public NameExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public NameExpressionAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NameExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.NameExpression;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
