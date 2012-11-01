package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FunctionApplicationAdapter extends AbstractEntityAdapter implements
		FunctionApplication {
	private static final long serialVersionUID = 1;

	public FunctionApplicationAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionApplicationAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionApplication> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.FunctionApplication;
	}

	public Name getName() {
		return wGet(SemanticsFeatureDescriptorEnum.name).wGetAdapter(
				SemanticsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SemanticsFeatureDescriptorEnum.name, name);
	}

	public Expression getArguments() {
		return wGet(SemanticsFeatureDescriptorEnum.arguments).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setArguments(Expression arguments) {
		wSet(SemanticsFeatureDescriptorEnum.arguments, arguments);
	}

	public Environments getEnvironments() {
		return wGet(SemanticsFeatureDescriptorEnum.environments).wGetAdapter(
				SemanticsEntityDescriptorEnum.Environments);
	}

	public void setEnvironments(Environments environments) {
		wSet(SemanticsFeatureDescriptorEnum.environments, environments);
	}

	public StageChange getStage() {
		return wGet(SemanticsFeatureDescriptorEnum.stage).wGetAdapter(
				SemanticsEntityDescriptorEnum.StageChange);
	}

	public void setStage(StageChange stage) {
		wSet(SemanticsFeatureDescriptorEnum.stage, stage);
	}
}
