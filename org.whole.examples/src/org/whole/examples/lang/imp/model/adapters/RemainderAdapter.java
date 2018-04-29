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
public class RemainderAdapter extends AbstractEntityAdapter implements Remainder {
	private static final long serialVersionUID = 1;

	public RemainderAdapter(IEntity implementor) {
		super(implementor);
	}

	public RemainderAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Remainder> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.Remainder;
	}

	public Expression getExp1() {
		return wGet(ImpFeatureDescriptorEnum.exp1).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setExp1(Expression exp1) {
		wSet(ImpFeatureDescriptorEnum.exp1, exp1);
	}

	public Expression getExp2() {
		return wGet(ImpFeatureDescriptorEnum.exp2).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setExp2(Expression exp2) {
		wSet(ImpFeatureDescriptorEnum.exp2, exp2);
	}
}
