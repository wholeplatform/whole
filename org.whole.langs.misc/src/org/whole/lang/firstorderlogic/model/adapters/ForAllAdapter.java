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
public class ForAllAdapter extends AbstractEntityAdapter implements ForAll {
	private static final long serialVersionUID = 1;

	public ForAllAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForAllAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForAll> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.ForAll;
	}

	public Parameters getParameters() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.parameters)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.parameters, parameters);
	}

	public Formula getFormula() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.formula).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setFormula(Formula formula) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.formula, formula);
	}
}
