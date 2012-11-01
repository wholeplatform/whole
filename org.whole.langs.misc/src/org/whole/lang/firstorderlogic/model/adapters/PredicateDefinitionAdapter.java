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
public class PredicateDefinitionAdapter extends AbstractEntityAdapter implements
		PredicateDefinition {
	private static final long serialVersionUID = 1;

	public PredicateDefinitionAdapter(IEntity implementor) {
		super(implementor);
	}

	public PredicateDefinitionAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PredicateDefinition> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateDefinition;
	}

	public SimplePredicate getPredicate() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.predicate)
				.wGetAdapter(
						FirstOrderLogicEntityDescriptorEnum.SimplePredicate);
	}

	public void setPredicate(SimplePredicate predicate) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.predicate, predicate);
	}

	public Parameters getParameters() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.parameters)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.parameters, parameters);
	}

	public Formula getStatement() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.statement)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setStatement(Formula statement) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.statement, statement);
	}
}
