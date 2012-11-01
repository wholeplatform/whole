package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FunctionApplicationImpl extends AbstractSimpleEntity implements
		FunctionApplication {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionApplication> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.FunctionApplication;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.FunctionApplication_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SemanticsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Expression arguments;

	public Expression getArguments() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Expression arguments) {
		notifyChanged(SemanticsFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	private Environments environments;

	public Environments getEnvironments() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.environments,
				environments);
	}

	public void setEnvironments(Environments environments) {
		notifyChanged(SemanticsFeatureDescriptorEnum.environments,
				this.environments, this.environments = environments);
	}

	private StageChange stage;

	public StageChange getStage() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.stage, stage);
	}

	public void setStage(StageChange stage) {
		notifyChanged(SemanticsFeatureDescriptorEnum.stage, this.stage,
				this.stage = stage);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getArguments().wGetAdaptee(false);
		case 2:
			return getEnvironments().wGetAdaptee(false);
		case 3:
			return getStage().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
			break;
		case 1:
			setArguments(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
			break;
		case 2:
			setEnvironments(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Environments));
			break;
		case 3:
			setStage(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.StageChange));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
