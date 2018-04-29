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
public class RangeLiteralAdapter extends AbstractEntityAdapter implements RangeLiteral {
	private static final long serialVersionUID = 1;

	public RangeLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public RangeLiteralAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RangeLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.RangeLiteral;
	}

	public IntLiteral getLowerBound() {
		return wGet(ImpFeatureDescriptorEnum.lowerBound).wGetAdapter(ImpEntityDescriptorEnum.IntLiteral);
	}

	public void setLowerBound(IntLiteral lowerBound) {
		wSet(ImpFeatureDescriptorEnum.lowerBound, lowerBound);
	}

	public IntLiteral getUpperBound() {
		return wGet(ImpFeatureDescriptorEnum.upperBound).wGetAdapter(ImpEntityDescriptorEnum.IntLiteral);
	}

	public void setUpperBound(IntLiteral upperBound) {
		wSet(ImpFeatureDescriptorEnum.upperBound, upperBound);
	}
}
