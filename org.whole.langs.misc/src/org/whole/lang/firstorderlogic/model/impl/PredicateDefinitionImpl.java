package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PredicateDefinitionImpl extends AbstractSimpleEntity implements
		PredicateDefinition {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PredicateDefinition> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateDefinition;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateDefinition_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SimplePredicate predicate;

	public SimplePredicate getPredicate() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.predicate,
				predicate);
	}

	public void setPredicate(SimplePredicate predicate) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.predicate,
				this.predicate, this.predicate = predicate);
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.parameters,
				parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.parameters,
				this.parameters, this.parameters = parameters);
	}

	private Formula statement;

	public Formula getStatement() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.statement,
				statement);
	}

	public void setStatement(Formula statement) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.statement,
				this.statement, this.statement = statement);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPredicate().wGetAdaptee(false);
		case 1:
			return getParameters().wGetAdaptee(false);
		case 2:
			return getStatement().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPredicate(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.SimplePredicate));
			break;
		case 1:
			setParameters(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters));
			break;
		case 2:
			setStatement(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
