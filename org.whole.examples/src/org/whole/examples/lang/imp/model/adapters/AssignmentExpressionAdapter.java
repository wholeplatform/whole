package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class AssignmentExpressionAdapter extends AbstractEntityAdapter implements AssignmentExpression {
	private static final long serialVersionUID = 1;

	public AssignmentExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssignmentExpressionAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AssignmentExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.AssignmentExpression;
	}

	public Name getName() {
		return wGet(ImpFeatureDescriptorEnum.name).wGetAdapter(ImpEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(ImpFeatureDescriptorEnum.name, name);
	}

	public Expression getExp() {
		return wGet(ImpFeatureDescriptorEnum.exp).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setExp(Expression exp) {
		wSet(ImpFeatureDescriptorEnum.exp, exp);
	}
}
