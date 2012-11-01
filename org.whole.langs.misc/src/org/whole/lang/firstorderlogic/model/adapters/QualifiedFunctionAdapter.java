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
public class QualifiedFunctionAdapter extends AbstractEntityAdapter implements
		QualifiedFunction {
	private static final long serialVersionUID = 1;

	public QualifiedFunctionAdapter(IEntity implementor) {
		super(implementor);
	}

	public QualifiedFunctionAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QualifiedFunction> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedFunction;
	}

	public Name getTheoryAlias() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.theoryAlias)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setTheoryAlias(Name theoryAlias) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.theoryAlias, theoryAlias);
	}

	public SimpleFunction getName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.name).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.SimpleFunction);
	}

	public void setName(SimpleFunction name) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}
}
