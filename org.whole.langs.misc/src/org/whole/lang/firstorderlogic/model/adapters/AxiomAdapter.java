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
public class AxiomAdapter extends AbstractEntityAdapter implements Axiom {
	private static final long serialVersionUID = 1;

	public AxiomAdapter(IEntity implementor) {
		super(implementor);
	}

	public AxiomAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Axiom> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Axiom;
	}

	public Name getName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.name).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public Formula getStatement() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.statement)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setStatement(Formula statement) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.statement, statement);
	}
}
