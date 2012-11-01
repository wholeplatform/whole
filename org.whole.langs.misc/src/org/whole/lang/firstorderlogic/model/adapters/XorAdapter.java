package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class XorAdapter extends AbstractEntityAdapter implements Xor {
	private static final long serialVersionUID = 1;

	public XorAdapter(IEntity implementor) {
		super(implementor);
	}

	public XorAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Xor> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Xor;
	}

	public Formula getLeftFormula() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.leftFormula)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setLeftFormula(Formula leftFormula) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.leftFormula, leftFormula);
	}

	public Formula getRightFormula() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.rightFormula)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setRightFormula(Formula rightFormula) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.rightFormula, rightFormula);
	}
}
